create table planet
(
    id bigint not null primary key,
    name varchar(75) not null,
    rotation_period varchar(50),
    orbital_period varchar(50),
    diameter varchar(20),
    climate varchar(35),
    gravity varchar(50),
    terrain varchar(50),
    surface_water varchar(50),
    population varchar(50)
)