package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unifunec.vendas.forms.FornecedorForm;
import com.unifunec.vendas.models.Bairro;
import com.unifunec.vendas.models.Cep;
import com.unifunec.vendas.models.Cidade;
import com.unifunec.vendas.models.Fornecedor;
import com.unifunec.vendas.models.Rua;
import com.unifunec.vendas.repository.BairroRepository;
import com.unifunec.vendas.repository.CepRepository;
import com.unifunec.vendas.repository.CidadeRepository;
import com.unifunec.vendas.repository.FornecedorRepository;
import com.unifunec.vendas.repository.RuaRepository;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final RuaRepository ruaRepository;
    private final BairroRepository bairroRepository;
    private final CepRepository cepRepository;
    private final CidadeRepository cidadeRepository;

    public FornecedorService(
            FornecedorRepository fornecedorRepository,
            RuaRepository ruaRepository,
            BairroRepository bairroRepository,
            CepRepository cepRepository,
            CidadeRepository cidadeRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.ruaRepository = ruaRepository;
        this.bairroRepository = bairroRepository;
        this.cepRepository = cepRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor getFornecedorId(Integer id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }

    public void apagaFornecedorId(Integer id) {
        Fornecedor fornecedor = getFornecedorId(id);
        fornecedorRepository.delete(fornecedor);
    }

    public Fornecedor salvaFornecedor(FornecedorForm fornecedorForm) {
        validarEmailDuplicado(fornecedorForm.getEmailfornecedor(), null);

        Fornecedor fornecedor = new Fornecedor();
        preencherFornecedor(fornecedor, fornecedorForm);

        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizaFornecedor(FornecedorForm fornecedorForm, Integer id) {
        Fornecedor fornecedor = getFornecedorId(id);
        validarEmailDuplicado(fornecedorForm.getEmailfornecedor(), id);

        preencherFornecedor(fornecedor, fornecedorForm);

        return fornecedorRepository.save(fornecedor);
    }

    private void preencherFornecedor(Fornecedor fornecedor, FornecedorForm fornecedorForm) {
        Rua rua = ruaRepository.findById(fornecedorForm.getCodrua())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rua não encontrada"));

        Bairro bairro = bairroRepository.findById(fornecedorForm.getCodbairro())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bairro não encontrado"));

        Cep cep = cepRepository.findById(fornecedorForm.getCodcep())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado"));

        Cidade cidade = cidadeRepository.findById(fornecedorForm.getCodcidade())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada"));

        fornecedor.setNomefornecedor(fornecedorForm.getNomefornecedor());
        fornecedor.setTelefonefornecedor(fornecedorForm.getTelefonefornecedor());
        fornecedor.setEmailfornecedor(fornecedorForm.getEmailfornecedor());
        fornecedor.setRua(rua);
        fornecedor.setBairro(bairro);
        fornecedor.setCep(cep);
        fornecedor.setCidade(cidade);
    }

    private void validarEmailDuplicado(String emailfornecedor, Integer codfornecedorAtual) {
        boolean emailDuplicado = codfornecedorAtual == null
                ? fornecedorRepository.emailFornecedorExiste(emailfornecedor)
                : fornecedorRepository.existePorEmailfornecedorEByCodfornecedorNao(emailfornecedor, codfornecedorAtual);

        if (emailDuplicado) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail de fornecedor já cadastrado");
        }
    }
}
