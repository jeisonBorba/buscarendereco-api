<h4 align="center"> 
	Buscar Endereço API
</h4>

<p align="center">
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#rocket-Tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#information_source-como-utilizar">Como Utilizar</a>&nbsp;&nbsp;&nbsp;
</p>

## 💻 Projeto
Aplicação no padrão Rest API para buscas de endereços através de CEP

## :rocket: Tecnologias
O projeto foi desenvolvido utilizando as seguintes tenclogias:

- Java 11
- Spring Boot
- Spring Security
- Spring Actuator
- Swagger
- Micromete
- Prometheus
- Logback
- Junit
- Lombok

## :information_source: Como Utilizar
Para clonar a aplicação e rodar localmente é necessário instalar:
- [Git][git]
- [Java 11][java]
- [Lombok][lombok] 
- [Docker][docker] `Não obrigatório. Somente para utilização do Prometheus`

Pela linha de comando:

### Baixar projeto
```bash
# Clonar aplicação
$ git clone https://github.com/jeisonBorba/buscarendereco-api.git && cd buscarendereco-api
```

### Utilizar segurança
```bash
# Adicionar login de autenticação no arquivo application.properties
auth.username | auth.password | auth.role
```

### Utilizar projeto
```bash
# Validar testes integrados
$ mvn verify

# Criar projeto
$ mvn clean package

# Executar projeto
$ mvn spring-boot:run

# Executar Prometheus `Não é obrigatório`
$ docker-compose up -d
```

### Recursos disponíveis
```bash
# Buscar endereço na API
http://localhost:8080/api/buscar-endereco/cep

# Swagger
http://localhost:3000/api/swagger-ui.html

# Saúde da aplicação
http://localhost:3000/api/manage/health

# Informação da aplicação
http://localhost:3000/api/manage/info

# Métricas da aplicação
http://localhost:3000/api/manage/metrics


# Prometheus
http://localhost:9090/targets
```

---
Made by Jeison de Borba :wave: [Get in touch!](https://www.linkedin.com/in/jeison-de-borba/)

[git]: https://git-scm.com/
[java]: https://adoptopenjdk.net/
[lombok]: https://projectlombok.org/
[docker]: https://docs.docker.com/get-docker/
