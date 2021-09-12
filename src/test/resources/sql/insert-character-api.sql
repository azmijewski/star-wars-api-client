INSERT INTO planet (id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population) VALUES (1, 'Tatooine', '23', '304', '10465', 'arid', '1 standard', 'desert', '1', '200000');
INSERT INTO planet (id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population) VALUES (2, 'Alderaan', '24', '364', '12500', 'temperate', '1 standard', 'grasslands, mountains', '40', '2000000000');
INSERT INTO planet (id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population) VALUES (8, 'Naboo', '26', '312', '12120', 'temperate', '1 standard', 'grassy hills, swamps, forests, mountains', '12', '4500000000');
INSERT INTO planet (id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population) VALUES (20, 'Stewjon', 'unknown', 'unknown', '0', 'temperate', '1 standard', 'grass', 'unknown', 'unknown');

INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (1, 'Luke Skywalker', '172', '77', 'blond', 'fair', 'blue', '19BBY', 'male', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (2, 'C-3PO', '167', '75', 'n/a', 'gold', 'yellow', '112BBY', 'n/a', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (3, 'R2-D2', '96', '32', 'n/a', 'white, blue', 'red', '33BBY', 'n/a', 8);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (4, 'Darth Vader', '202', '136', 'none', 'white', 'yellow', '41.9BBY', 'male', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (5, 'Leia Organa', '150', '49', 'brown', 'light', 'brown', '19BBY', 'female', 2);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (6, 'Owen Lars', '178', '120', 'brown, grey', 'light', 'blue', '52BBY', 'male', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (7, 'Beru Whitesun lars', '165', '75', 'brown', 'light', 'blue', '47BBY', 'female', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (8, 'R5-D4', '97', '32', 'n/a', 'white, red', 'red', 'unknown', 'n/a', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (9, 'Biggs Darklighter', '183', '84', 'black', 'light', 'brown', '24BBY', 'male', 1);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (10, 'Obi-Wan Kenobi', '182', '77', 'auburn, white', 'fair', 'blue-gray', '57BBY', 'male', 20);
INSERT INTO character (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld) VALUES (11, 'Anakin Skywalker', '188', '84', 'blond', 'fair', 'blue', '41.9BBY', 'male', 1);

INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (64, 'Naboo star skiff', 'J-type star skiff', 'Theed Palace Space Vessel Engineering Corps/Nubia Star Drives, Incorporated', 'unknown', '29.2', '1050', '3', '3', 'unknown', 'unknown', '0.5', 'unknown', 'yacht');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (65, 'Jedi Interceptor', 'Eta-2 Actis-class light interceptor', 'Kuat Systems Engineering', '320000', '5.47', '1500', '1', '0', '60', '2 days', '1.0', 'unknown', 'starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (74, 'Belbullab-22 starfighter', 'Belbullab-22 starfighter', 'Feethan Ottraw Scalable Assemblies', '168000', '6.71', '1100', '1', '0', '140', '7 days', '6', 'unknown', 'starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (12, 'X-wing', 'T-65 X-wing', 'Incom Corporation', '149999', '12.5', '1050', '1', '0', '110', '1 week', '1.0', '100', 'Starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (13, 'TIE Advanced x1', 'Twin Ion Engine Advanced x1', 'Sienar Fleet Systems', 'unknown', '9.2', '1200', '1', '0', '150', '5 days', '1.0', '105', 'Starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (22, 'Imperial shuttle', 'Lambda-class T-4a shuttle', 'Sienar Fleet Systems', '240000', '20', '850', '6', '20', '80000', '2 months', '1.0', '50', 'Armed government transport');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (39, 'Naboo fighter', 'N-1 starfighter', 'Theed Palace Space Vessel Engineering Corps', '200000', '11', '1100', '1', '0', '65', '7 days', '1.0', 'unknown', 'Starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (48, 'Jedi starfighter', 'Delta-7 Aethersprite-class interceptor', 'Kuat Systems Engineering', '180000', '8', '1150', '1', '0', '60', '7 days', '1.0', 'unknown', 'Starfighter');
INSERT INTO starship (id, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hyperdrive_rating, mglt, starship_class) VALUES (59, 'Trade Federation cruiser', 'Providence-class carrier/destroyer', 'Rendili StarDrive, Free Dac Volunteers Engineering corps.', '125000000', '1088', '1050', '600', '48247', '50000000', '4 years', '1.5', 'unknown', 'capital ship');

INSERT INTO character_starship (character_id, starship_id) VALUES (1, 22);
INSERT INTO character_starship (character_id, starship_id) VALUES (1, 12);
INSERT INTO character_starship (character_id, starship_id) VALUES (4, 13);
INSERT INTO character_starship (character_id, starship_id) VALUES (9, 12);
INSERT INTO character_starship (character_id, starship_id) VALUES (10, 74);
INSERT INTO character_starship (character_id, starship_id) VALUES (10, 48);
INSERT INTO character_starship (character_id, starship_id) VALUES (10, 64);
INSERT INTO character_starship (character_id, starship_id) VALUES (10, 59);
INSERT INTO character_starship (character_id, starship_id) VALUES (10, 65);
INSERT INTO character_starship (character_id, starship_id) VALUES (11, 39);
INSERT INTO character_starship (character_id, starship_id) VALUES (11, 59);
INSERT INTO character_starship (character_id, starship_id) VALUES (11, 65);