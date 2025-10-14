# Your backend API

##Technologies utilisées

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
   Column   |  Type   | Collation | Nullable |                Default
------------+---------+-----------+----------+---------------------------------------
 id_user    | integer |           | not null | nextval('user_id_user_seq'::regclass)
 first_name | text    |           | not null |
 last_name  | text    |           | not null |
 email      | text    |           | not null |
 password   | text    |           | not null |


Portfolio table:
     Column     |  Type   | Collation | Nullable |                      Default
----------------+---------+-----------+----------+---------------------------------------------------
 id_portfolio   | integer |           | not null | nextval('portefolio_id_portefolio_seq'::regclass)
 name_portfolio | text    |           | not null |
 link           | text    |           | not null |
 linkedin       | text    |           | not null |
 creation_date  | date    |           |          | CURRENT_DATE
 edition_date   | date    |           |          | CURRENT_DATE
 id_user        | integer |           | not null |
 id_template    | integer |           | not null |
 json_data      | text    |           |          |


##API Endpoints

##


##Important Notes

Passwords must be at least 6 characters long.
When a user is deleted, all their associated portfolios are also deleted (CASCADE).
The jsonData column in portfolio stores raw JSON for the frontend.
