# 🌐 Sistema de Gerenciamento de Provedor de Internet

Este projeto tem como objetivo desenvolver um **sistema básico de gerenciamento para um provedor de internet**, permitindo o cadastro e gerenciamento de clientes, planos de internet e controle de equipamentos em estoque.  
O sistema foi projetado como parte de uma atividade acadêmica e implementado em **Java**, seguindo princípios de orientação a objetos.

---

## 📋 Objetivo do Projeto

O objetivo é criar uma aplicação simples que permita que um provedor de internet controle de forma eficiente seus principais processos operacionais, como:

- Cadastrar e gerenciar clientes.
- Associar planos de internet aos clientes.
- Gerenciar estoque de equipamentos (como roteadores e modems).
- Controlar a entrega de equipamentos aos clientes.
- Consultar informações sobre planos e equipamentos disponíveis.

---

## 🧑‍💻 Funcionalidades Principais

✅ Cadastro e edição de **clientes** com seus dados de contato.  
✅ Criação e gerenciamento de **planos de internet** (nome, velocidade, preço, etc.).  
✅ Associação de **planos aos clientes**.  
✅ Consulta e atualização do **estoque de equipamentos**.  
✅ Registro de **equipamentos entregues** aos clientes.  
✅ Atualização de dados e histórico dos clientes.

---

## 🧱 Modelagem do Sistema

### 📊 Diagrama de Casos de Uso

O sistema inclui as seguintes funcionalidades principais:

- Cadastrar Cliente
- Gerenciar Planos
- Associar Plano ao Cliente
- Consultar Estoque
- Registrar Saída de Equipamento
- Atualizar Dados do Cliente

> O diagrama ilustra como **administradores** e **clientes** interagem com o sistema.

---

### 📐 Diagrama de Classes

As principais classes do domínio são:

- **Cliente**: representa um cliente do provedor.
- **Plano**: representa um plano de internet disponível.
- **Estoque**: controla os equipamentos disponíveis.
- **Equipamento**: representa os equipamentos individuais fornecidos aos clientes.

#### Relacionamentos:
- Um **Cliente** possui **um Plano**.
- Um **Cliente** pode ter **muitos Equipamentos**.
- Um **Estoque** pode conter **muitos Equipamentos**.

---

## 🛠️ Tecnologias Utilizadas

- **Java 23** – linguagem principal
- **Maven** – gerenciamento de dependências e build
- **UML** – modelagem do sistema
- **Git & GitHub** – versionamento de código
- **Figma / Draw.io** – prototipação e diagramas

---

## 📁 Estrutura do Projeto

O projeto segue o padrão de arquitetura **MVC (Model-View-Controller)**:

```
sistema_provedor_internet/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/
│   │   │       ├── Main.java                 # Ponto de entrada da aplicação
│   │   │       ├── controller/               # Lógica de negócio e entidades do domínio
│   │   │       │   ├── Cliente.java
│   │   │       │   ├── Equipamento.java
│   │   │       │   ├── Estoque.java
│   │   │       │   └── Plano.java
│   │   │       └── view/                     # Interface do usuário
│   │   │           └── Menu.java
│   │   └── resources/
│   └── test/
│       └── java/
├── documentation/                            # Diagramas e documentação
│   ├── casos_uso.png
│   ├── diagrama de classes.png
│   └── prototipo.png
├── pom.xml                                   # Configuração Maven
└── README.md
```

### Descrição dos Pacotes

- **`controller`**: Classes que representam as entidades do domínio (Cliente, Plano, Estoque, Equipamento) e contêm toda a lógica de negócio do sistema. Os dados são armazenados em memória durante a execução.
- **`view`**: Interface do usuário em modo texto (menu interativo via console) que permite a interação com o sistema.

---

## ⚙️ Requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 23** ou superior
- **Maven 3.6+** (opcional, mas recomendado)
- **Git** (opcional, para clonar o repositório)

**Nota**: O sistema funciona sem banco de dados, armazenando os dados em memória durante a execução.

---

## 🚀 Instalação e Execução

### 1. Clonar o repositório
```bash
git clone <url-do-repositório>
cd sistema_provedor_internet
```

### 2. Instalar dependências (opcional)

Como o projeto não possui dependências externas, você pode compilar diretamente. Se preferir usar Maven:

```bash
mvn clean install
```

### 3. Executar a aplicação

**Opção 1: Via Maven (recomendado)**
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

**Opção 2: Compilar e executar manualmente**
```bash
# Compilar o projeto
mvn compile

# Executar (Windows)
java -cp target/classes org.example.Main

# Executar (Linux/Mac)
java -cp target/classes org.example.Main
```

**Opção 3: Executar o JAR (após empacotar)**
```bash
mvn package
java -jar target/sistema_provedor_internet-1.0-SNAPSHOT.jar
```

**Opção 4: Executar diretamente (se tiver Java instalado)**
```bash
# Navegue até a pasta src/main/java
cd src/main/java

# Compile os arquivos Java
javac org/example/*.java org/example/controller/*.java org/example/view/*.java

# Execute
java org.example.Main
```

### 4. Usar o sistema

Após a execução, o menu principal será exibido no console:

```
O que deseja fazer?
1. Gerenciar clientes
2. Gerenciar planos
3. Gerenciar estoque
0. Sair do sistema
```

> **⚠️ Importante**: Como o sistema funciona em memória, todos os dados cadastrados serão perdidos ao encerrar a aplicação. Os dados não são persistidos em banco de dados ou arquivo.

---

## 📚 Documentação

Documentos adicionais estão disponíveis na pasta `documentation/`:

- **Diagrama de Casos de Uso**: `documentation/casos_uso.png`
- **Diagrama de Classes**: `documentation/diagrama de classes.png`
- **Protótipo de Interface**: `documentation/prototipo.png`

---

## 📐 Diagrama de Classes

<img src="documentation/diagrama%20de%20classes.png">