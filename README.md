<div align="center">
  <h1>Gerenciador de Tarefas (API)</h1>
  
  <div align="center">
    <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" alt="Java 21">
    <img src="https://img.shields.io/badge/Spring_Boot-3.0-green?style=for-the-badge&logo=spring-boot" alt="Spring Boot">
    <img src="https://img.shields.io/badge/H2_Database-Enabled-blue?style=for-the-badge" alt="H2">
    <img src="https://img.shields.io/badge/Swagger-UI-brightgreen?style=for-the-badge&logo=swagger" alt="Swagger">
    <img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge" alt="License">
  </div>

  <br>
  
  <p>
    API RESTful desenvolvida com <strong>Spring Boot</strong> para gerenciar tarefas.
    <br>
    Serve como backend para a aplicação frontend em React.
  </p>
</div>

<br>

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA**
* **SpringDoc OpenAPI** (Documentação via Swagger)
* **H2 Database** (Banco em memória para desenvolvimento rápido)
* **Lombok** (Redução de boilerplate code)
* **Maven** (Gerenciamento de dependências)

---

## 📂 Estrutura do Projeto

O código segue a arquitetura em camadas padrão do Spring Boot, facilitando a manutenção e escalabilidade:

```text
src/main/
├── java/com/elociny/gerenciadorTarefas/
│   ├── config/                                # Configurações globais (ex: Carga inicial de dados)
│   ├── controller/                            # Camada de Controle (Endpoints da API REST)
│   ├── model/                                 # Objetos de Domínio (Entidades do Banco de Dados)
│   ├── repository/                            # Camada de Persistência (Interfaces JPA)
│   ├── service/                               # Camada de Serviço (Regras de Negócio)
│   └── GerenciadorTarefasApplication.java     # Classe Principal (Main)
└── resources/
    └── application.properties                 # Configurações do Banco H2 e Spring
```

---

## 🔗 Integração com Frontend

Esta API foi criada para ser consumida pelo projeto front-end.

* **Repositório do Front:** [https://github.com/Elociny/to-do-list](https://github.com/Elociny/to-do-list)
* **CORS Configurado:** A API aceita requisições vindas de `http://localhost:5173`

### 🖼️ Visualização do Projeto
Abaixo, uma prévia da aplicação React consumindo os dados desta API:

<div align="center">
  <img src="https://github.com/Elociny/to-do-list/blob/main/src/images/screenshots/application.gif?raw=true" alt="Frontend consumindo API" />
</div>

---

## 🛠️ Como Rodar o Projeto

### Pré-requisitos
* Java JDK 21 instalado.
* Maven instalado (ou utilizar o wrapper `./mvnw` incluso na pasta).

### Passo a passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Elociny/tasks.git
    cd tasks
    ```

2.  **Execute o projeto:**
    Se estiver usando o terminal (Linux/Mac):
    ```bash
    ./mvnw spring-boot:run
    ```
    Se estiver no Windows:
    ```bash
    .\mvnw.cmd spring-boot:run
    ```
    Ou abra a pasta na sua IDE favorita (IntelliJ, Eclipse, VS Code) e execute a classe principal `GerenciadorTarefasApplication.java`.

3.  A API estará rodando em: `http://localhost:8080`.

---

## 🔌 Documentação da API (Endpoints)

### 📖 Swagger UI (Interativo)
O projeto conta com documentação automática via **OpenAPI**. Com a aplicação rodando, você pode testar todas as rotas visualmente, ver os modelos de dados e executar requisições sem precisar instalar o Postman.

👉 **Acesse:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

### 📋 Rotas Disponíveis

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| **GET** | `/tarefas` | Retorna a lista de todas as tarefas. |
| **POST** | `/tarefas` | Cria uma nova tarefa. |
| **PUT** | `/tarefas/{id}` | Atualiza os dados de uma tarefa existente. |
| **DELETE** | `/tarefas/{id}` | Exclui uma tarefa pelo ID. |

---

### 📝 Exemplo de JSON (Corpo da Requisição)

Para criar (`POST`) ou atualizar (`PUT`), utilize este formato:

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Finalizar o módulo de JPA e Integração com Front",
  "responsavel": "Elociny",
  "dataTermino": "2025-12-25"
}
```

Nota: O formato da data deve ser `YYYY-MM-DD`

---

## 💾 Banco de Dados (H2 Console)

O projeto utiliza o H2 Database em memória. Isso significa que os dados são armazenados na memória RAM e são **recriados toda vez que a aplicação reinicia**, o que é ideal para ambientes de desenvolvimento e testes rápidos.

Para visualizar as tabelas, os dados inseridos e fazer consultas SQL direto no navegador:

1.  Com a aplicação rodando, acesse: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2.  Preencha os dados de conexão conforme abaixo:
    * **Driver Class:** `org.h2.Driver`
    * **JDBC URL:** `jdbc:h2:mem:tarefasdb`
    * **User Name:** `sa`
    * **Password:** ` ` (deixe em branco)
3.  Clique no botão **Connect**.

### 🔄 Carga Inicial de Dados (Data Loader)
O sistema conta com um `DataLoader` automático. Ao iniciar a aplicação, ele popula o banco com:
* **4 Tarefas Atrasadas** para testar alertas e filtros de atraso.
* **4 Tarefas Pendentes** para testar o fluxo normal.

---

## 🤝 Autor

Feito com 💜 por **Elociny**.

Entre em contato ou veja outros projetos em:
* **GitHub:** [Elociny](https://github.com/Elociny)
* **LinkedIn:** [Nicole Lins Coelho](https://www.linkedin.com/in/nicolelinscoelho/)
