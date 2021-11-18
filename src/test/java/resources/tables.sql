CREATE TABLE person(
    person_id bigserial PRIMARY KEY,
    first_name VARCHAR(150) UNIQUE NOT NULL,
    last_name VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(1500) NOT NULL,
    email VARCHAR(255) NOT NULL,
    image VARCHAR(2000) DEFAULT '',
    is_active_driver boolean DEFAULT false,
    is_default_user boolean DEFAULT true,
    is_driver boolean DEFAULT false,
    is_moderator boolean DEFAULT false
);
