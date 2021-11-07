DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id integer NOT NULL,
    username character varying(60) COLLATE pg_catalog."default" NOT NULL,
    password character varying(120) COLLATE pg_catalog."default" NOT NULL,
    role character varying(60) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS car
(
    id integer NOT NULL,
    name character varying(60) COLLATE pg_catalog."default" NOT NULL,
    model character varying(60) COLLATE pg_catalog."default" NOT NULL,
    generation character varying(60) COLLATE pg_catalog."default" NOT NULL,
    mileage character varying(60) COLLATE pg_catalog."default",
    engine character varying(60) COLLATE pg_catalog."default",
    user_id integer NOT NULL,
    price real,
    deleted boolean,
    CONSTRAINT car_pkey PRIMARY KEY (id),
    CONSTRAINT car_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);
