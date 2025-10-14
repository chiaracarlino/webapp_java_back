# Your backend API

## Technologies utilisées

Java 21
Spring Boot 3.2
Spring Data JPA / Hibernate
PostgreSQL
Docker & Docker Compose


## Set up 
1. Copie-colle le `.env.sample` en `.env`
2. Remplis le fichier `.env` avec les credentials de ton choix
3. Fait un `docker compose up`
4. Rajoute le plugin : [env-file](https://plugins.jetbrains.com/plugin/7861-envfile)
5. Ajoute ton fichier `.env` comme ci-dessous (n'oublie pas d'activer les fichiers cachés)
<img src="img-readme/img.png">
<img src="img-readme/img_1.png">
<img src="img-readme/img_2.png">


## Data Base

User table:
| Column     | Type    | Collation | Nullable | Default                               |
| ---------- | ------- | --------- | -------- | ------------------------------------- |
| id_user    | integer |           | not null | nextval('user_id_user_seq'::regclass) |
| first_name | text    |           | not null |                                       |
| last_name  | text    |           | not null |                                       |
| email      | text    |           | not null |                                       |
| password   | text    |           | not null |                                       |


Portfolio table:
| Column         | Type    | Collation | Nullable | Default                                         |
| -------------- | ------- | --------- | -------- | ----------------------------------------------- |
| id_portfolio   | integer |           | not null | nextval('portfolio_id_portfolio_seq'::regclass) |
| name_portfolio | text    |           | not null |                                                 |
| link           | text    |           | not null |                                                 |
| linkedin       | text    |           | not null |                                                 |
| creation_date  | date    |           |          | CURRENT_DATE                                    |
| edition_date   | date    |           |          | CURRENT_DATE                                    |
| id_user        | integer |           | not null |                                                 |
| id_template    | integer |           | not null |                                                 |
| json_data      | text    |           |          |                                                 |


## API Endpoints

Users
| Method | Endpoint      | Description                             | Body (JSON)                                                                    |
| ------ | ------------- | --------------------------------------- | ------------------------------------------------------------------------------ |
| POST   | `/users`      | Crée un nouvel utilisateur              | `{ "firstName": "...", "lastName": "...", "email": "...", "password": "..." }` |
| GET    | `/users`      | Récupère tous les utilisateurs          | -                                                                              |
| GET    | `/users/{id}` | Récupère un utilisateur par ID          | -                                                                              |
| PUT    | `/users/{id}` | Met à jour un utilisateur               | `{ ... }`                                                                      |
| PATCH  | `/users/{id}` | Met à jour partiellement un utilisateur | `{ ... }`                                                                      |
| DELETE | `/users/{id}` | Supprime un utilisateur                 | -                                                                              |


Portfolios
| Method | Endpoint           | Description                           | Body (JSON)                                                                              |
| ------ | ------------------ | ------------------------------------- | ---------------------------------------------------------------------------------------- |
| POST   | `/portfolios`      | Crée un portfolio                     | `{ "name": "...", "link": "...", "linkedin": "...", "templateId": 1, "jsonData": "{}" }` |
| GET    | `/portfolios`      | Récupère tous les portfolios          | -                                                                                        |
| GET    | `/portfolios/{id}` | Récupère un portfolio par ID          | -                                                                                        |
| PUT    | `/portfolios/{id}` | Met à jour un portfolio               | `{ ... }`                                                                                |
| PATCH  | `/portfolios/{id}` | Met à jour partiellement un portfolio | `{ ... }`                                                                                |
| DELETE | `/portfolios/{id}` | Supprime un portfolio                 | -                                                                                        |


## Postman

Example of json for a user:
```
{
  "idUser": 5,
  "firstName": "David",
  "lastName": "Martin",
  "email": "david.martin@test.com",
  "password": "azerty123",
  "portfolios": null,
  "portfolio": null
}
```

Example of json for a portfolio:
```
{
  "idPortfolio": 13,
  "namePortfolio": "Portfolio de david3",
  "link": "https://david3-portfolio.com",
  "linkedin": "https://www.linkedin.com/in/david",
  "creationDate": "2025-10-14",
  "editionDate": "2025-10-14",
  "template": {
    "idTemplate": 1,
    "nameTemplate": "template de base"
  },
  "jsonData": null
}
```



##Important Notes

Passwords must be at least 6 characters long.
When a user is deleted, all their associated portfolios are also deleted (CASCADE).
The jsonData column in portfolio stores raw JSON for the frontend.
