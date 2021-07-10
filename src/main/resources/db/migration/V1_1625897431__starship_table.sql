create table starship
(
    id bigint not null primary key,
    name varchar(100) not null,
    model varchar(100),
    manufacturer varchar(100),
    cost_in_credits varchar(20),
    length varchar(35),
    max_atmospheric_speed varchar(15),
    crew varchar(20),
    passengers varchar(20),
    cargo_capacity varchar(35),
    consumables varchar(35),
    hyperdrive_rating varchar(10),
    mglt varchar(15),
    starship_class varchar(75)
)