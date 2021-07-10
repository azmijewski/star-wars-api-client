alter table character
    add column homeworld_id bigint;

alter table character
    add constraint character__homeworld_id_fk foreign key (homeworld_id) references homeworld (id);