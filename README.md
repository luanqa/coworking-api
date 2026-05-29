# Coworking API

API REST para gerenciamento de reservas de salas e auditórios para empresas de coworking.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (embutido)
- Lombok
- Bean Validation

## Como executar

### Pré-requisitos

- Java 17 instalado

### Passos

1. Clone o repositório:

git clone https://github.com/luanqa/coworking-api.git

2. Acesse a pasta do projeto:

cd coworking-api

3. Execute o projeto:

./mvnw spring-boot:run

A aplicação estará disponível em http://localhost:8080
## Banco de dados

O console do H2 está disponível em http://localhost:8080/h2-console com as configurações:
- **JDBC URL:** jdbc:h2:mem:coworkingdb
- **Usuário:** sa
- **Senha:** (deixar em branco)

## Endpoints

### Salas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /salas | Cadastrar sala |
| GET | /salas | Listar todas as salas |
| GET | /salas/livres?data= | Listar salas livres em uma data |

### Reservas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /reservas | Criar reserva |
| DELETE | /reservas/{id} | Cancelar reserva |
| GET | /reservas/agenda?data= | Consultar agenda do dia |

## Exemplos de uso

### Cadastrar sala

POST /salas
{ "nome": "Sala de Reunião A", "tipo": "COLETIVA" }

### Criar reserva

POST /reservas
{ "salaId": 1, "responsavel": "João Silva", "data": "2026-06-01", "horaInicio": "09:00", "horaFim": "11:00" }

### Consultar agenda do dia

GET /reservas/agenda?data=2026-06-01

### Consultar salas livres

GET /salas/livres?data=2026-06-01

### Cancelar reserva

DELETE /reservas/1

## Tipos de sala

- INDIVIDUAL — Sala de reunião individual
- COLETIVA — Sala de reunião coletiva
- AUDITORIO — Auditório

## Testando com Postman

Uma collection do Postman está disponível no repositório no arquivo coworking-api.postman_collection.json.

Para importar:
1. Abra o Postman
2. Clique em Import
3. Selecione o arquivo coworking-api.postman_collection.json
4. Todos os endpoints já estarão prontos para uso