create table character_starship
(
    character_id bigint not null,
    starship_id  bigint not null,
    PRIMARY KEY (character_id, starship_id)
);

alter table character_starship
    add constraint character_starship__character_id_fk foreign key (character_id) REFERENCES character (id);

alter table character_starship
    add constraint character_starship__starship_id_fk foreign key (starship_id) REFERENCES starship (id);