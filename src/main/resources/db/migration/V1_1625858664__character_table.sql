create table character (
    id bigint not null primary key,
    name varchar(500) not null,
    height varchar(4),
    mass varchar(4),
    hair_color varchar(15),
    skin_color varchar(15),
    eye_color varchar(15),
    birth_year varchar(12),
    gender varchar(10)
);