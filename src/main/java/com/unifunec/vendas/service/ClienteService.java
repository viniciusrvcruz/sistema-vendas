package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unifunec.vendas.forms.ClienteForm;
import com.unifunec.vendas.models.Bairro;
import com.unifunec.vendas.models.Cep;
import com.unifunec.vendas.models.Cidade;
import com.unifunec.vendas.models.Cliente;
import com.unifunec.vendas.models.Rua;
import com.unifunec.vendas.models.Sexo;
import com.unifunec.vendas.repository.BairroRepository;
import com.unifunec.vendas.repository.CepRepository;
import com.unifunec.vendas.repository.CidadeRepository;
import com.unifunec.vendas.repository.ClienteRepository;
import com.unifunec.vendas.repository.RuaRepository;
import com.unifunec.vendas.repository.SexoRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final SexoRepository sexoRepository;
    private final RuaRepository ruaRepository;
    private final BairroRepository bairroRepository;
    private final CepRepository cepRepository;
    private final CidadeRepository cidadeRepository;

    public ClienteService(
            ClienteRepository clienteRepository,
            SexoRepository sexoRepository,
            RuaRepository ruaRepository,
            BairroRepository bairroRepository,
            CepRepository cepRepository,
            CidadeRepository cidadeRepository) {
        this.clienteRepository = clienteRepository;
        this.sexoRepository = sexoRepository;
        this.ruaRepository = ruaRepository;
        this.bairroRepository = bairroRepository;
        this.cepRepository = cepRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente ClienteId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public void apagaClienteId(Integer id) {
        Cliente cliente = ClienteId(id);
        clienteRepository.delete(cliente);
    }

    public Cliente salvaCliente(ClienteForm clienteForm) {
        Cliente cliente = new Cliente();
        aplicaDadosCliente(cliente, clienteForm);
        return clienteRepository.save(cliente);
    }

    public Cliente atualizaCliente(ClienteForm clienteForm, Integer id) {
        Cliente cliente = ClienteId(id);
        aplicaDadosCliente(cliente, clienteForm);
        cliente.setCodcliente(id);
        return clienteRepository.save(cliente);
    }

    private void aplicaDadosCliente(Cliente cliente, ClienteForm clienteForm) {
        Sexo sexo = sexoRepository.findById(clienteForm.getCodsexofk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sexo não encontrado"));
        Rua rua = ruaRepository.findById(clienteForm.getCodruafk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rua não encontrada"));
        Bairro bairro = bairroRepository.findById(clienteForm.getCodbairrofk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bairro não encontrado"));
        Cep cep = cepRepository.findById(clienteForm.getCodcepfk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado"));
        Cidade cidade = cidadeRepository.findById(clienteForm.getCodcidadefk())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada"));

        cliente.setNomecliente(clienteForm.getNomecliente());
        cliente.setSexo(sexo);
        cliente.setRua(rua);
        cliente.setBairro(bairro);
        cliente.setCep(cep);
        cliente.setCidade(cidade);
    }
}
