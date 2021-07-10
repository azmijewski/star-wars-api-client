create table homeworld
(
    id bigint not null primary key,
    name varchar(75) not null,
    rotation_period varchar(6),
    orbital_period varchar(6),
    diameter varchar(20),
    climate varchar(35),
    gravity varchar(50),
    terrain varchar(50),
    surface_water varchar(5),
    population varchar(50)
)