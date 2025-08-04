# Sistema de Biblioteca ABC

Back-end desenvolvido em Spring Boot para gerenciamento de biblioteca - Projeto 4º Período.

## Tecnologias

- Java 17
- Spring Boot 3.5.3
- Maven
- Lombok

## Como executar

1. Clone o repositório
2. Execute o comando:
   ```bash
   ./mvnw spring-boot:run
   ```

## Entidades

O sistema possui 4 entidades com CRUD completo:

- **BIBLIOTECA** - id, nome, telefone
- **LIVRO** - id, ISSN, título, sinopse, ano, número de páginas
- **AUTOR** - id, nome, cpf, idade
- **EDITORA** - id, nome, endereço, telefone

## Endpoints REST

Cada entidade possui 5 operações CRUD:

### Editora
- `POST /api/editoras` - Criar editora
- `GET /api/editoras` - Listar todas
- `GET /api/editoras/{id}` - Buscar por ID
- `PUT /api/editoras/{id}` - Atualizar editora
- `DELETE /api/editoras/{id}` - Deletar editora

### Autor
- `POST /api/autor/save` - Criar autor

## Observações

- Dados armazenados em memória (sem banco de dados)
- Padrões REST implementados
- IDs gerados automaticamente