# AJuDE BACKEND
> Repositório referente ao backend do projeto final da disciplina Projeto de Software, na UFCG, desenvolvido em Spring MVC.

O AJuDE é uma ferramenta que permite a organização de doações para projetos/campanhas, onde as causas mais populares ganham mais visibilidade. Cada projeto (ou campanha) será atendido quando conseguir arrecadar uma quantidade de doações igual ou superior à meta.

# **O projeto utilizou das seguintes ferramentas:**

- Spring Boot
- Spring Data
- Spring Security
- JPA
- Hibernate
- JWT
- Java 8
- H2
- Heroku(Deploy)

# **Diretórios usados:**
- ProjetoPSOFTBackEnd/ajude/src/main/java/ajude/psoft Nesse caminho está todas as pastas nescessárias para o funcionamento do sistema.
  - /config Diretório onde encontra-se o arquivo EmailController.java e Swagger.java.
    - /Swagger Responsável pela geração da api.
  - /controladores Diretório onde encontra-se os arquivos CampanhaController.java, UsuarioController.java e LoginController.java.Nos controladores estão as rotas para comunicação com o frontend.
    - /CampanhaController Responsável por inserir, recuperar e remover campanhas, comentarios, likes e doações.
    - /UsuarioController Responsável por cadastrar e recuperar um usuario(para os novos usuarios é enviado e-mail de boas vindas ao sistema).
    - /LoginController Responsável pela geração do token, autorizando um usuario a acessar ao seu perfil e campanhas.
  - /repositories Diretório onde encontra-se os arquivos ComentariosRepository.java, CampanhasRepository.java, UsuariosRepository.java, LikesRepository.java, DoacoesRepository.java.
    - /ComentariosRepository Responsável pelo DAO de comentários, com as funcionalidades de salvar um novo comentário, recuperar todos os comentarios, e buscar o comentário pelo seu ID.
    - /CampanhasRepository Responsável pelo DAO de campanhas, com as funcionalidades de salvar uma nova campanha, buscar a campanha pelo ID, retornar todas as campanhas cadastradas no sistema.
    - / DoacoesRepository Responsável pelo DAO de doações, com as funcionalidades de salvar uma nova doação, buscar a doação pelo ID, além de retornar todos as doações.
    - /LikesRepository Responsável pelo DAO de curtidas, com a funcionalidade de salvar um nova curtida, recuperar pelo id e todas as curtidas salvas.
    - /UsuariosRepository Responsável pelo DAO de usuários, com as funcionalidades de salvar um novo usuario além de buscar um usuario pelo seu email e recuperar todos os usuários.
  - /entidades Diretório onde encontra-se os arquivos Comentario.java, Campanha.java, Curtir.java, Doacao.java, Usuario.java. é nesse pacote que estão as entidades usadas no sistema.
    - /Comentario Entidade responsável pelo comentário.
    - /Campanha Entidade responsável pela campanha.
    - /Curtir Entidade responsável pelos likes.
    - /Doacao Entidade responsável pela resposta de doações.
    - /Usuario Entidade responsável pelo usuário.
  - /servicos Diretório onde encontra-se os arquivos ComentariosService.java, CampanhasService.java,LikesService.java, DoacoesServiceService.java, UsuariosService.java.
    - /ComentariosService Service responsável pela inserção e remoção de comentários do sistema.
    - /CampanhasService Service responsável pelo cadastramento e buscas das disciplinas.
    - /LikesService Service responsável pelo cadastramento e buscas de perfis.
    - /DoacoesService Service responsável pela inserção e remoção de respostas a comentários.
    - /UsuariosService Service responsável pelo cadastramento, remoção e buscas de usuários.
  - /filtros Diretório onde encontra-se o arquivo TokenFilter.java.
    - /TokenFilter Responsável pela autorização do usuario para acesso ao sistema, validando ou não o token.
  - /enums Diretório onde encontra-se o arquivo EnumStatus
    - /EnumStatus Responsável por indicar os status possíveis de uma campanha.
