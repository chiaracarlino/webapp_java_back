-- Table des utilisateurs
CREATE TABLE "users" (
    id_user SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    CONSTRAINT chk_password_length CHECK (length(password) >= 6)
);

-- Table des templates
CREATE TABLE template (
    id_template SERIAL PRIMARY KEY,
    name_template TEXT NOT NULL
);

-- Table des portfolios
CREATE TABLE portfolio (
    id_portfolio SERIAL PRIMARY KEY,
    name_portfolio TEXT NOT NULL,
    link TEXT NOT NULL UNIQUE,
    linkedin TEXT NOT NULL,
    creation_date DATE DEFAULT CURRENT_DATE,
    edition_date DATE DEFAULT CURRENT_DATE,
    id_user INT NOT NULL,
    id_template INT NOT NULL,

    CONSTRAINT chk_dates CHECK (edition_date >= creation_date),
    CONSTRAINT fk_user_portfolio FOREIGN KEY (id_user)
        REFERENCES "user"(id_user)
        ON DELETE CASCADE,
    CONSTRAINT fk_template_portfolio FOREIGN KEY (id_template)
        REFERENCES template(id_template),
    CONSTRAINT unique_portfolio_per_user UNIQUE (id_user, name_portfolio),
    json_data TEXT
);