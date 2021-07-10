create table starship
(
    id bigint not null primary key,
    name varchar(100) not null,
    model varchar(100),
    manufacturer varchar(100),
    cost_in_credits varchar(20),
    length varchar(35),
    max_atmosphering_speed varchar(30),
    crew varchar(20),
    passengers varchar(20),
    cargo_capacity varchar(35),
    consumables varchar(35),
    hyperdrive_rating varchar(50),
    mglt varchar(30),
    starship_class varchar(75)
)