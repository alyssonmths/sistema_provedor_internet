-- Tabela de Planos
CREATE TABLE Plano (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    velocidade DECIMAL(10,2) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);

-- Tabela de Clientes
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    contato VARCHAR(50) NOT NULL,
    plano_id INT NOT NULL,
    FOREIGN KEY (plano_id) REFERENCES Plano(id) ON DELETE RESTRICT
);

-- Tabela de Estoque
CREATE TABLE Estoque (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    quantidade INT NOT NULL DEFAULT 0
);

-- Tabela de Equipamentos
CREATE TABLE Equipamento (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    entregue BOOLEAN NOT NULL DEFAULT FALSE,
    estoque_id INT NOT NULL,
    FOREIGN KEY (estoque_id) REFERENCES Estoque(id) ON DELETE CASCADE
);