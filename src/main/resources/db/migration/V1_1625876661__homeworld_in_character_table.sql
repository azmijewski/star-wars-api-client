alter table character
    add column homeworld bigint;

alter table character
    add constraint character__planet_id_fk foreign key (homeworld) references planet (id);