DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.car;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL,
    username character varying(60) COLLATE pg_catalog."default" NOT NULL,
    password character varying(120) COLLATE pg_catalog."default" NOT NULL,
    role character varying(60) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.car
(
    name character varying(60) COLLATE pg_catalog."default" NOT NULL,
    model character varying(60) COLLATE pg_catalog."default" NOT NULL,
    generation character varying(60) COLLATE pg_catalog."default" NOT NULL,
    mileage character varying(60) COLLATE pg_catalog."default",
    engine character varying(60) COLLATE pg_catalog."default",
    user_id integer NOT NULL,
    price real,
    id integer NOT NULL DEFAULT nextval('car_id_seq'::regclass),
    deleted boolean,
    CONSTRAINT car_pkey PRIMARY KEY (id),
    CONSTRAINT "Car_fkey_User" FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);
