# Ocean Unity 🐟
## Sobre a solução
<p>Somos uma empresa de monitoramento da qualidade da água e poluição em praias. Vendemos e instalamos sensores, além de prover um aplicativo de celular para o monitoramento,
contando com comentários e recomendações sugeridas por uma inteligência artificial desenvolvida por nós. </p>
<p>No sentido da poluição nas praias contamos com uma inteligência artificial que pode
detectar plásticos na superfície da areia, podendo tanto ser utilizada em cameras de vigilância como em seu próprio celular.</p>

## Impacto
<p>O monitoramento de locais importantes como rios que desaguam no oceano, habitats naturais e empresas que utilizam recursos hídricos de rios, permite que a vida marinha seja preservada e as empresas compreendam
  melhor o impacto de suas operações no ambiente aquático e ajuda a garantir que estejam em conformidade com as regulamentações ambientais.</p>
  
## Aplicabilidade
<p>Falando sobre software, a Ocean Unity tem grande potencial aplicável, pois é uma ideia inovadora com conceitos relativamente comuns no ambiente da tecnologia atualmente.</p>
<p>A maior dificuldade seria o hardware onde não temos o conhecimento e a realização e escolha de sensores deve ficar para profissionais qualificados no meio ambiental e de IOT.</p>

## API Java
<p>A aplicação desenvolvida em Java é responsável principalmente pela persistência de dados e autenticação, porém também contem diversos métodos de pesquisa.</p>

### Funcionalidades principais
- Registrar
- Login
- Manipulação dos Dados
- Criptografia de Senha
- Geração de Tokens
### Tecnologias
- Spring Web
- Spring Security
- Spring Data JPA
- SqlServerDriver
- Lombok
- Bean Validation
- Oauth
### Endpoints para teste:
#### 1° Passo criar Empresa
- /api/v1/empresas
#### 2° Passo criar/registrar Usuario
- /auth/register
#### 3° Passo Login Usuario
- /auth/login
#### 4° Passo
- Testar qualquer endpoint de acordo com a ROLE do Usuario que voce fez Login

### Principais Endpoints
endpoint base /api/v1/**
#### CRUD - /empresas /alertas /localizacoes /leituras /poluentes /parametros /acoes
  - "/" - Get Pageable
  - "/" - Post Create
  - "/{id}" - Delete
  - "/" - Put Update
#### Personalizadas
- "/api/v1/acoes/empresa/{empresaId}" - Get todas ações de uma empresa
- "/api/v1/acoes/poluente/{poluenteId}" - Get todas ações de um poluente
- "/api/v1/acoes/empresa/{empresaId}/poluente/{poluenteId}" - Get todas ações de uma empresa e de determinado Poluente
- "/api/v1/alertas/leitura/{leituraId}" - Get todos Alertas de determinada Leitura

## Diagrama do Banco de Dados
![Banco de dados](https://github.com/AdurraIS/oceanunity_java/assets/119917719/ab83a063-9eb2-405d-b491-249d45f79def)
## Estrutura do Projeto
![Diagrama](https://github.com/AdurraIS/oceanunity_java/assets/119917719/3f7e4db9-3b76-4a28-8c64-1678e32eb73e)

## Equipe:
| Registro | Nome  | Responsabilidade | Disciplinas|
| ------------- | ------------- | ------------- | ------------- |
| 97161 | Giovanna Tricerri | Data Modeler - Criação de banco de dados e atuação em pontas de JPA | DATABASE / ENTERPRISE APPLICATION |
| 96958 | Giovanni Ultramari | Desenvolvedor back-end | ENTERPRISE APPLICATION / DIGITAL BUSINESS  |
| 97374 |Lucas Contrucci | Responsável na documentação e arquitetura do projeto e criação de Fluxogramas | DEVOPS TOOLS E CLOUD / ENTERPRISE APPLICATION |
| 97058 | Matheus Santos | Tester e implementação de automação na aplicação | COMPLIANCE & QA /  IOT, IOB & IA |
| 96840 | Nicolas Souza | Desenvolvedor Front-end | HYBRID MOBILE APP |
