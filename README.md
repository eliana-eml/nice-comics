# Nice Comics
Nice Comics é um projeto desenvolvido com o objetivo de criar uma API utilizando a tecnologia de Spring Boot para consumo através de um front-end de uma loja online de livros.

## Pré-requisitos
- Java JDK 17
- Maven 4.0.0
- MySQL 8

## Instalação e Configuração
1. Clone o repositório.
2. Configure o arquivo application.properties alterando o seu usuário e senha para o banco de dados:
```
spring.datasource.username=usuario
spring.datasource.password=senha
```
3. Execute `mvn clean install` para compilar e instalar as dependências.
4. No seu SGBD de preferência para o MySQL, crie um banco de dados conforme o seguinte script:

```
CREATE DATABASE nice_comics;
USE nice_comics;

CREATE TABLE metodo_pagamento (
	id_metodo_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    nome_metodo_pagamento VARCHAR(100) NOT NULL
);

CREATE TABLE clientes (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    cpf_cliente VARCHAR(14) NOT NULL,
    nome_cliente VARCHAR(100) NOT NULL,
    cep_cliente VARCHAR(9) NOT NULL,
    logradouro_cliente VARCHAR(100) NOT NULL,
    numero_cliente VARCHAR(8) NOT NULL,
    complemento_cliente VARCHAR(30) NOT NULL,
    bairro_cliente VARCHAR(30) NOT NULL,
    cidade_cliente VARCHAR(50) NOT NULL,
    uf_cliente VARCHAR(2),
	email_cliente VARCHAR(100) NOT NULL,
    senha_cliente VARCHAR(50) NOT NULL,
	telefone_cliente VARCHAR(13) NOT NULL,
    id_metodo_pagamento INT NOT NULL,
    CONSTRAINT fk_id_metodo_pagto FOREIGN KEY (id_metodo_pagamento) REFERENCES metodo_pagamento(id_metodo_pagamento)
);

CREATE TABLE editoras (
	id_editora INT AUTO_INCREMENT PRIMARY KEY,
    nome_editora VARCHAR(100) NOT NULL
);

CREATE TABLE autores (
	id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nome_autor VARCHAR(100) NOT NULL
);

CREATE TABLE titulos (
	id_titulo INT AUTO_INCREMENT PRIMARY KEY,
    nome_titulo VARCHAR(100) NOT NULL,
    qtd_paginas_titulo INT NOT NULL,
    preco_titulo DECIMAL(10,2) NOT NULL,
    tipo_titulo VARCHAR(50) NOT NULL,
    genero_titulo VARCHAR(50) NOT NULL,
    url_capa_titulo VARCHAR(200) NOT NULL,
    promocao_titulo CHAR(1),
    categoria_titulo VARCHAR(50),
    id_autor INT NOT NULL,
    id_editora INT NOT NULL,
    CONSTRAINT fk_id_autor FOREIGN KEY (id_autor) REFERENCES autores(id_autor),
    CONSTRAINT fk_id_editora FOREIGN KEY (id_editora) REFERENCES editoras(id_editora)
);

CREATE TABLE colecoes (
	id_colecao INT AUTO_INCREMENT PRIMARY KEY,
    nome_colecao VARCHAR(100) NOT NULL,
    id_autor INT NOT NULL,
    CONSTRAINT fk_id_autor_colecao FOREIGN KEY (id_autor) REFERENCES autores(id_autor)
);

CREATE TABLE titulo_colecao (
	id_titulo_colecao INT AUTO_INCREMENT PRIMARY KEY,
    id_titulo INT NOT NULL,
    id_colecao INT NOT NULL,
    CONSTRAINT fk_id_titulo FOREIGN KEY (id_titulo) REFERENCES titulos(id_titulo),
    CONSTRAINT fk_id_colecao FOREIGN KEY (id_colecao) REFERENCES colecoes(id_colecao)
);

CREATE TABLE pedidos (
	id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE NOT NULL,
    valor_total_pedido DECIMAL(10,2) NOT NULL,
    id_cliente INT NOT NULL,
	CONSTRAINT fk_id_cliente_pedido FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE item_pedido (
	id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    qtd_titulo_item INT NOT NULL,
    valor_unitario_item DECIMAL(10,2) NOT NULL,
    id_pedido INT NOT NULL,
    id_titulo INT NOT NULL,
    CONSTRAINT fk_id_pedido_item_pedido FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido) ON DELETE CASCADE,
    CONSTRAINT fk_id_titulo_item_pedido FOREIGN KEY (id_titulo) REFERENCES titulos(id_titulo)
);
```
## Como Usar
Para iniciar o projeto localmente, execute:
```
mvn sprint-boot:run
```
Para utilização da API, acesse no seu navegador ou ferramenta semelhante ao Postman: `http://localhost:8080/NiceComics/...`

### Endpoints

- **CRUD CLIENTES ("/clientes")**
    - **@GetMapping("/clientes")** listarClientes 
    - **@GetMapping("/clientes/{id}")** findById 
    - **@PostMapping("/clientes")** cadastrarCliente 
    - **@PostMapping("/clientes")** efetuarLogin 
    - **@PutMapping("/clientes/{id}")** atualizarCadastroCliente
    - **@DeleteMapping("/clientes/{id}")** excluirCadastroCliente

- **CRUD TÍTULOS ("/titulos")**
    - GET
    - POST
    - PUT
    - DELETE

## Tecnologias Utilizadas
- Spring Boot 3.2.4
- Java JDK 17
- MySQL 8

