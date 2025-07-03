Projeto API de Triagem de Pronto-Socorro

Este projeto é uma API REST desenvolvida em Java e Spring Boot para um sistema de triagem de pacientes de um pronto-socorro. Ultima avalição da Materia de POO!

O objetivo do sistema é gerenciar médicos e a fila de atendimento, com uma lógica para priorizar os casos mais graves, como acontece nos consultorios e hospitais atualmente (PREFERENCIAL) de acordo com a Gravidade do Pacinte.

Tecnologias que foram utilizadas:

Java 17
Spring Boot
Maven
JPA / Hibernate
Banco de Dados H2 (em memória)
Funcionalidades:

Verificação de status da API.
Cadastro de novos médicos.
Controle de plantão dos médicos.
Registro (triagem) de novos pacientes com dados e nível de prioridade.
Consulta de pacientes por ID.
Lógica para retornar o próximo paciente a ser atendido com base na prioridade.
Pré-requisitos:

Para rodar o projeto, é necessário ter instalado:

Java 17 ou superior SDK

Maven

Como Rodar a Aplicação:

Siga os passos abaixo para executar o projeto.

Clone o repositório

Use o terminal para clonar o projeto:
git clone https://github.com/matheusvsp/API-de-Triagem-Atividade
Em seguida, acesse a pasta do projeto:
cd triagem-pronto-socorro
Execute o projeto com o Maven

Dentro da pasta do projeto, execute o seguinte comando no terminal:

./mvnw spring-boot:run
(No Windows, utilize o comando: mvnw.cmd spring-boot:run)

Este comando irá compilar o código e iniciar o servidor da aplicação.

Verifique a execução

Ao final do processo no terminal, a aplicação estará em execução quando a mensagem Tomcat started on port(s): 8080 (http) for exibida.
A aplicação estará disponível em http://localhost:8080.
Como Testar está API?

Teste de Saúde

Para uma verificação rápida, acesse http://localhost:8080/health no seu navegador. A resposta deve indicar que o sistema está no ar ("UP").
Acessando o Banco de Dados

O banco de dados em memória (H2) pode ser acessado pelo navegador para consulta das tabelas e dados.
Acesse: http://localhost:8080/h2-console
Na tela de login, clique em Conectar (Connect) sem alterar nenhuma informação.
Testando os Endpoints

Para testar as operações de POST e PUT, é necessário utilizar um cliente de API como Postman, Insomnia ou a extensão Thunder Client do VS Code (Meu Caso).

Fluxo de teste recomendado:

POST /api/medicos para cadastrar um médico.
PUT /api/medicos/{id}/plantao para definir o status de plantão do médico.
POST /api/triagem para cadastrar pacientes com diferentes prioridades.
GET /api/atendimento/proximo para verificar se a lógica de prioridade funciona.
Estrutura do Projeto

model: Contém as classes que representam os dados (Pacientes e Medicos).
repository: Camada de acesso aos dados, responsável pela comunicação com o banco.
service: Contém as regras de negócio e a lógica da aplicação.
controller: Camada que define os endpoints da API e lida com as requisições HTTP.
