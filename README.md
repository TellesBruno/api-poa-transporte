# Api Poa Transporte

Guide to installing and configuring the project available in: Portuguese and English
Guia de instalação e configuração do projeto disponível em: Português e Inglês

### English

## Start

This configuration was made using the IDEA intellij 2023.1

## Installation

### Environment

```bash
Jdk: 17
branch base: main
```

### Before running the project

It will be necessary to create a `PostgreSQL` database for the API to work
It will also be necessary to have `Docker` and `Docker-compose` installed

In some linux distributions, it will be necessary to use the sudo command to run the commands below

In the folder where the `docker-compose.yml` (`src\main\resources\docker`) file is run in the terminal:
```bash
$ docker-compose up
```
To run the containers

```bash
$ docker-compose start
```

To stop the containers

```bash
docker-compose stop
```

### Run the project

```bash
run the following Gradle commands
gradle->build-> clean
gradle->appliaction->bootRun

then run the application in:
api-poa-transport\src\main\java\com\telles\bruno\apipoatransporte\apipoatransport\ApiPoaTransporteApplication.java
```
### Documentation of the APIs
Available in the following link: [Swagger](http://localhost:8080/swagger-ui.html)

A file containing the requests can be imported using Insomnia 4 available in:
`src\main\resources\insomnia\API_poa_transporte.json`

#### Make database backup (run where you want the backup file to be saved)
```bash
$ docker exec -t <container-name> pg_dumpall -c -U postgres > dump_`date +%d-%m-%Y"_"%H_%M_%S`.sql
```

#### Restore database (run in the folder where the backup file is)
```bash
$ cat <file-name>.sql | docker exec -i <container-name> psql -U postgres
```


### Português

## Inicio

Esta configuração foi realizada utilizando a IDEA intellij 2023.1

## Instalação

### Ambiente

```bash
Jdk: 17
branch base: main
```

### Antes de rodar o projeto

Será necessário criar um banco `PostgreSQL` para a API funcionar
Será necessário também o `Docker` e o `Docker-compose` instalado

Em algumas distribuições linux, será necessário utilizar o comando sudo para executar os comandos abaixo

Na pasta em que está o arquivo `docker-compose.yml` (`src\main\resources\docker`) rodar no terminal:
```bash
$ docker-compose up
```
Para rodar os containers

```bash
$ docker-compose start
```

Para parar os containers

```bash
docker-compose stop
```

### Rodar o projeto

```bash
executar os seguintes comandos do Gradle
gradle->build-> clean
gradle->appliaction->bootRun

depois execute a aplicação em:
api-poa-transport\src\main\java\com\telles\bruno\apipoatransporte\apipoatransport\ApiPoaTransporteApplication.java
```
### Documentação das APIs
Disponível no seguinte link: [Swagger](http://localhost:8080/swagger-ui.html)

Um arquivo contendo as request pode ser importado usando Insomnia 4 disponivel em:
`src\main\resources\insomnia\API_poa_transporte.json`

#### Fazer Backup database (rodar onde quer que o arquivo de backup seja salvo)
```bash
$ docker exec -t <container-name> pg_dumpall -c -U postgres > dump_`date +%d-%m-%Y"_"%H_%M_%S`.sql
```

#### Restore database (rodar na pasta em que está o arquivo de backup)
```bash
$ cat <file-name>.sql | docker exec -i <container-name> psql -U postgres
```