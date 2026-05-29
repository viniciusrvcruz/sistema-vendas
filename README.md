# Sistema Vendas

API REST de um sistema de vendas, desenvolvida em **Spring Boot** com **JPA** e **PostgreSQL**.

## Sobre o projeto

Este repositório faz parte das atividades da disciplina **Desenvolvimento de APIs avançadas** da pós-graduação na **UNIFUNEC**.

O código foi construído **a partir de uma base já existente** fornecida no contexto da disciplina. A arquitetura em camadas, os nomes das entidades (`models`), atributos, relacionamentos e convenções do domínio **já faziam parte dessa base**, o foco deste repositório é estender, integrar e evoluir o que foi entregue, conforme os requisitos da matéria.

## Como executar

```sh
docker compose up -d
./start.sh
```

## Acesso

- API: http://localhost:8090
- Swagger: http://localhost:8090/swagger-ui/index.html
- Exemplo: `GET http://localhost:8090/ufs`

## Estrutura do projeto

```
vendas/
├── docker-compose.yml      # PostgreSQL local
├── start.sh                # Sobe a API com checagem de Java
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/unifunec/vendas/
    │   │   ├── VendasApplication.java   # Ponto de entrada Spring Boot
    │   │   ├── config/                  # Configurações (ex.: CORS)
    │   │   ├── controller/              # Endpoints REST (@RestController)
    │   │   ├── forms/                   # DTOs de entrada/saída da API
    │   │   ├── models/                  # Entidades JPA (tabelas do domínio)
    │   │   ├── repository/              # Interfaces Spring Data JPA
    │   │   └── service/                 # Regras de negócio e orquestração
    │   └── resources/
    │       └── application.properties   # Porta, datasource, JPA
```

**Fluxo típico de uma requisição:** `Controller` → `Service` → `Repository` → banco (entidades em `models`). Os `forms` desacoplam o JSON da API das entidades persistidas.

**Principais entidades:** `Uf`, `Cidade`, `Bairro`, `Rua`, `Cep`, `Cliente`, `Sexo`, `Fornecedor`, `Marca`, `Tipo`, `Produto`, `Compra`, `CompraProduto` (chave composta).

## Rotas da API

Base URL: `http://localhost:8090`

A documentação interativa completa está no **Swagger** (`/swagger-ui/index.html`).

| Recurso | Prefixo | Operações |
|--------|---------|-----------|
| UFs | `/ufs` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Cidades | `/cidades` | `GET`, `GET /{id}`, `GET /nomecidade/{nomecidade}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Bairros | `/bairros` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Ruas | `/ruas` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| CEPs | `/ceps` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Sexos | `/sexos` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Clientes | `/clientes` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Fornecedores | `/fornecedores` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Marcas | `/marcas` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Tipos | `/tipos` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Produtos | `/produtos` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Compras | `/compras` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Itens da compra | `/compra-produto` | `GET`, `POST`, `GET /{codCompra}/{codProduto}`, `PUT /{codCompra}/{codProduto}`, `DELETE /{codCompra}/{codProduto}` |

## Requisitos

- Java 17.x
- Docker

## Execução automática

O script `start.sh` aplica as configurações de Java automaticamente (quando possível) e valida a versão antes de iniciar.

## Integrantes

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/DaviTorelli" target="_blank" rel="noopener noreferrer">
        <img src="https://github.com/DaviTorelli.png" width="80px;" alt="Davi Torelli"/><br>
        <sub><b>Davi Torelli</b></sub>
      </a><br>
      <a href="https://github.com/DaviTorelli" title="GitHub" target="_blank" rel="noopener noreferrer">
        <img src="https://skillicons.dev/icons?i=github" width="25px" />
      </a>
      <a href="https://www.linkedin.com/in/davitorelli" title="LinkedIn" target="_blank" rel="noopener noreferrer">
        <img src="https://skillicons.dev/icons?i=linkedin" width="25px" />
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/viniciusrvcruz" target="_blank" rel="noopener noreferrer">
        <img src="https://github.com/viniciusrvcruz.png" width="80px;" alt="Vinicius Cruz"/><br>
        <sub><b>Vinicius Cruz</b></sub>
      </a><br>
      <a href="https://github.com/viniciusrvcruz" title="GitHub" target="_blank" rel="noopener noreferrer">
        <img src="https://skillicons.dev/icons?i=github" width="25px" />
      </a>
      <a href="https://www.linkedin.com/in/viniciuscruz7" title="LinkedIn" target="_blank" rel="noopener noreferrer">
        <img src="https://skillicons.dev/icons?i=linkedin" width="25px" />
      </a>
    </td>
  </tr>
</table>
