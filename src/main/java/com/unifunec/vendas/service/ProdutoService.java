package com.unifunec.vendas.service;

import com.unifunec.vendas.forms.ProdutoForm;
import com.unifunec.vendas.models.Fornecedor;
import com.unifunec.vendas.models.Marca;
import com.unifunec.vendas.models.Produto;
import com.unifunec.vendas.models.Tipo;
import com.unifunec.vendas.repository.CompraProdutoRepository;
import com.unifunec.vendas.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    CompraProdutoRepository compraProdutoRepository;

    TipoService tipoService;
    MarcaService marcaService;
    FornecedorService fornecedorService;

    public ProdutoService(
        ProdutoRepository produtoRepository,
        CompraProdutoRepository compraProdutoRepository,
        TipoService tipoService,
        MarcaService marcaService,
        FornecedorService fornecedorService
    ) {
        this.produtoRepository = produtoRepository;
        this.compraProdutoRepository = compraProdutoRepository;
        this.tipoService = tipoService;
        this.marcaService = marcaService;
        this.fornecedorService = fornecedorService;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public void apagaProdutoId(Long id) {
        getProdutoId(id);

        if (compraProdutoRepository.existsByProduto_Codproduto(id)) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Não é possível excluir o produto pois existem itens vinculados em compras");
        }

        produtoRepository.deleteById(id);
    }

    public Produto salvaProduto(ProdutoForm produtoForm) {
        Produto produto = new Produto();

        preencherProduto(produto, produtoForm);

        return produtoRepository.save(produto);
    }

    public Produto atualizaProduto(ProdutoForm produtoForm, Long id) {
        Produto produto = getProdutoId(id);

        preencherProduto(produto, produtoForm);

        return produtoRepository.save(produto);
    }

    private void preencherProduto(Produto produto, ProdutoForm produtoForm) {
        Tipo tipo = tipoService.getTipoId(produtoForm.getCodtipofk());
        Marca marca = marcaService.MarcaId(produtoForm.getCodmarcafk());
        Fornecedor fornecedor = fornecedorService.getFornecedorId(produtoForm.getCodfornecedorfk());

        produto.setTipo(tipo);
        produto.setMarca(marca);
        produto.setFornecedor(fornecedor);
        produto.setNomeproduto(produtoForm.getNomeproduto());
        produto.setQuantidade(produtoForm.getQuantidade());
        produto.setValor(produtoForm.getValor());
    }
}
