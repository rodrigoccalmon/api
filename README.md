# nk 
- Utilizar o STS4 para rodar a aplicação
- spring.datasource.url=jdbc:postgresql://localhost:5432/neki
- criar DATABASE com nome neki no banco de dados
- URL Swagger: http://localhost:8080/swagger-ui/index.html#/
- Dependências: JPA, SpringWEB, DevTools, PostgreSQL, test, Spring Security, JWT, tomcat, SpringFox(Swagger), Hibernate, Spring Security

Acredito que todas as funcionalidades elencadas no pdf estão presentes no projeto. 
Agradeço a oportunidade. 

-> 
Endpoint de cadastro de usuário: localhost:8080/api/usuarios
Método POST

Exemplo:
JSON: {
  "dataUltimoLogin": "2022-03-04T15:24:04.239Z",
  "email": "string",
  "nome": "string",
  "senha": "string"
}

GET da lista de usuários cadastrados: localhost:8080/api/usuarios
GET de usuário via ID: localhost:8080/api/usuarios/{id}
___________________________________________

-> Endpoint de login: localhost:8080/api/login
Método POST

Exemplo:
JSON:
{
  "email": "string",
  "senha": "string"
}

________________________________________

Endpoint de skill: localhost:8080/api/skills
Método POST

Exemplo:

JSON: 
{
  "atualizadaEm": "2022-03-04T15:28:46.841Z",
  "criadaEm": "2022-03-04T15:28:46.841Z",
  "descricao": "string",
  "imagemUrl": "string",
  "nivelDeConhecimento": 0,
  "nome": "string",
  "usuario": {
    "dataUltimoLogin": "2022-03-04T15:28:46.841Z",
    "email": "string",
    "id": 0,
    "nome": "string",
    "senha": "string"
  },
  "versao": "string"
}
________________________________________

Endpoint para pesquisar skill via ID: localhost:8080/api/skills/{id}
Método GET

________________________________________

Endpoint para atualizar skill via ID: localhost:8080/api/skills/{id}
Método PUT
Obs: não precisa preencher todos os campos, apenas o que deseje alterar.

________________________________________

Endpoint para deletar skill via ID: localhost:8080/api/skills/{id}
Método DELETE

________________________________________

Endpoint para atualizar apenas o nivel de conhecimento(knowlegde level) localhost:8080/api/skills/atualizarskill/{id}
Método PUT

________________________________________

Endpoint para filtrar skills por id de Usuário: localhost:8080/api/skills/filtrar/{idUsuario}
Método GET

________________________________________

Endpoint para listar todas skills postadas de todos usuários: localhost:8080/api/skills/todas
Método GET

________________________________________

Endpoint de UsuarioSkill: localhost:8080/api/usuarioskill
Método POST
Exemplo:
JSON: {
  "id": 1,
  "usuario": {
    "id": 1,
    "email": "string",
    "senha": "$2a$10$QTZ..FvmRsb7OC09WjHHyOBW8NhL4PIaEcO0K0VZSqSfB7U9spUZW",
    "nome": "string",
    "dataUltimoLogin": "2022-03-04T15:36:02.510+00:00"
  },
  "skill": {
    "id": 1,
    "nome": "string",
    "versao": "string",
    "descricao": "string",
    "imagemUrl": "string",
    "nivelDeConhecimento": 0,
    "criadaEm": "2022-03-04T15:36:07.637+00:00",
    "atualizadaEm": "2022-03-04T15:36:07.637+00:00",
    "usuario": {
      "id": 1,
      "email": "string",
      "senha": "$2a$10$QTZ..FvmRsb7OC09WjHHyOBW8NhL4PIaEcO0K0VZSqSfB7U9spUZW",
      "nome": "string",
      "dataUltimoLogin": "2022-03-04T15:36:02.510+00:00"
    }
  },
  "nivelConhecimento": 10,
  "criadoEm": "2022-03-04T15:38:04.531+00:00",
  "atualizadoEm": "2022-03-04T15:38:04.531+00:00"
}

_______________________________________

Endpoint de UsuarioSkill para pesquisar via id: localhost:8080/api/usuarioskill{id}
Método GET

________________________________________

Endpoint de UsuarioSkill para atualizar knowlegdelevel: localhost:8080/api/usuarioskill/{id}
Método PUT
OBS: Alterar apenas o atributo nivel de conhecimento (knowlegde level)

________________________________________

Endpoint para deletar UsuarioSkill: localhost:8080/api/usuarioskill{id}
Método DELETE

________________________________________

Endpoint para listar todos UsuarioSkill: localhost:8080/api/usuarioskill/todas
Método GET
