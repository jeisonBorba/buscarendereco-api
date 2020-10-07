<h3 align="center"> 
	Buscar Endereço API
</h3>

<p align="center">
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#rocket-Tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#information_source-como-utilizar">Como Utilizar</a>&nbsp;&nbsp;&nbsp;
</p>

## 💻 Projeto
Aplicação para buscar endereços através de CEP utilizando como stack Java com Spring Boot para criação de API no padrão Rest. A aplicação possui uma camada de segurança que utilizado o HTTP Basic para a autenticação, onde deve ser provido um usuário e senha no momento da requisição. Utilizando ferramentas como Logback, Spring Actuator, Micrometer e Prometheus é possível criar logs bem estruturados com backup gerado automaticamente a cada 1hr e endpoints que nos fornecem todos os dados necessários para acompanhar a saúde e métricas da aplicação.

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
$ mvnw.cmd test

# Criar projeto
$ mvnw.cmd clean package

# Executar projeto
$ mvnw.cmd spring-boot:run

# Executar Prometheus `Não é obrigatório`
$ docker-compose up -d
```

### Recursos disponíveis
```bash
# Buscar endereço na API
http://localhost:8080/api/buscar-endereco/cep/{cep}

# Swagger
http://localhost:8080/api/swagger-ui.html

# Saúde da aplicação
http://localhost:8080/api/manage/health

# Informação da aplicação
http://localhost:8080/api/manage/info

# Métricas da aplicação
http://localhost:8080/api/manage/metrics/{metric}

# Prometheus
http://localhost:8080/api/manage/prometheus


# Dashboard Prometheus
http://localhost:9090/targets
```

---
Made by Jeison de Borba :wave: [Get in touch!](https://www.linkedin.com/in/jeison-de-borba/)

[git]: https://git-scm.com/
[java]: https://adoptopenjdk.net/
[lombok]: https://projectlombok.org/
[docker]: https://docs.docker.com/get-docker/
