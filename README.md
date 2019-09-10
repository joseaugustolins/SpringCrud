### SpringCrud - José Augusto
Crud com Spring
### Requisitos
- Gradle
- Docker (verificar versão)
- Docker-compose (verificar versão)

### Steps
- Criar volume (referenciado no docker-compose.yml), comando: <br> 
`docker volume create postgres_data`
- Gerar build do projeto com o gradle, comando: <br>
`gradle build`
- Com o arquivo Dockerfile criado, gerar imagem (o nome da imagem, springcrudjdk8, deve ser referenciado no docker-compose.yml), comando: <br>
`docker build . -t springcrudjdk8`
- Levantar container <br>
`docker-compose up -d`

### Outros
- Documentacao swagger em: http://localhost:8080/swagger-ui.htm
- Inserir departamento - POST na url localhost:8080/api/departamento
`{
"nome": "Vendas"
}`

- Buscar todos os Departamentos - get na url localhost:8080/api/departamento/all

- Atualizar departamento - POST em localhost:8080/api/departamento de um id de departamento existente, trocando o valor do nome 
`{
	"id": 1,
	"nome": "Jurid"
}` 

- Inserir funcionário - POST na url localhost:8080/api/funcionario
`{
	"cpf": 555,
	"nome": "Joao",
	"departamento": {
		"id": 1
	}
}`

- Buscar funcionario por cpf - HTTP GET na URL: localhost:8080/api/funcionario/555  ; onde 555 é o cpf de um usuario existente
  
- delete funcionario - HTTP DELETE na URL: localhost:8080/api/funcionario/555  ; onde 555 é o cpf do usuário
