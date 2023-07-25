# ChallengeCarSpringBoot
### English: "Version in Portuguese below"

The "ChallengeCarSpringBoot" project is a Java application that implements two REST endpoints for registering and retrieving information about cars. It uses Java 20 and Maven for dependency management and connects to a MySQL database using JPA and JDBC.

### Endpoints

1. POST ("/cars/post"): This endpoint allows registering a new car in the database. The payload should include the car's chassis number, name, brand, color, and year of manufacture. The car brand must be one of the following options: Ford, Chevrolet, BMW, or Volvo.

2. GET ("/cars/get/{idChassis}"): This endpoint receives the chassis number as a parameter and returns the corresponding car information.

### Rules

The project implements the following rules:

1. The car brand must be one of the four accepted options.
2. Car information is saved in the database.
3. Retrieving a car by chassis number returns the corresponding car information.

This project provides a basic implementation suitable for beginners who want to practice REST API concepts and data persistence in a database.

### Português: 

## Projeto ChallengeCarSpringBoot

O projeto "ChallengeCarSpringBoot" é uma aplicação Java que implementa dois endpoints REST para registrar e obter informações sobre carros. Ele usa Java 20 e Maven para gerenciar dependências e se conecta a um banco de dados MySQL usando JPA e JDBC.

### Endpoints

1. POST ("/cars/post"): Este endpoint permite registrar um novo carro no banco de dados. O payload enviado deve incluir o número de chassi, nome, marca, cor e ano de fabricação do carro. A marca do carro deve ser uma das seguintes opções: Ford, Chevrolet, BMW ou Volvo.

2. GET ("/cars/get/{idChassi}"): Este endpoint recebe o número de chassi como parâmetro e retorna as informações do carro correspondente.

### Regras

O projeto implementa as seguintes regras:

1. A marca do carro deve ser uma das quatro opções aceitáveis.
2. As informações do carro são salvas no banco de dados.
3. A busca pelo número de chassi retorna as informações do carro correspondente.

Este projeto oferece uma implementação básica adequada para iniciantes que desejam praticar conceitos de API REST e persistência de dados em um banco de dados.
