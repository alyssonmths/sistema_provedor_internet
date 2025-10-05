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

- **Java 23+** – linguagem principal
- **UML** – modelagem do sistema
- **Git & GitHub** – versionamento de código
- **Figma / Draw.io** – prototipação e diagramas

---