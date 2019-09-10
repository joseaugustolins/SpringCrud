# SpringCrud
Crud com Spring
//instalar ultima versao do docker
//instalar ultimar versao do docker-compose

//criar volume (referenciado no docker-compose.yml)
docker volume create postgres_data

//gerar build do projeto com o gradle
gradle build

//com o arquivo Dockerfile criado, gerar imagem (o nome da imagem, springcrudjdk8,
//deve ser referenciado no docker-compose.yml
docker build . -t springcrudjdk8

//levantar container
docker-compose up -d

documentacao swagger em: http://localhost:8080/swagger-ui.htm

//inserir departamento - POST na url localhost:8080/api/departamento
{
"nome": "Vendas"
}


//buscar todos os setores - get na url
localhost:8080/api/departamento/all


//atualizar departamento - POST em localhost:8080/api/departamento de um id de departamento existente, trocando o valor do nome 
{
	"id": 1,
	"nome": "Jurid"
} 

//inserir funcionário - POST na url 
{
	"cpf": 555,
	"nome": "Joao",
	"departamento": {
		"id": 1
	}
}

//buscar funcionario por cpf - HTTP GET na URL: 
localhost:8080/api/funcionario/555
onde 555 é o cpf de um usuario existente
  
//delete funcionario - HTTP DELETE na URL: 
localhost:8080/api/funcionario/555
onde 555 é o cpf do usuário
