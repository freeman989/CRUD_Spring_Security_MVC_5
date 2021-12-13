INSERT INTO users2 (id, name, surname, age, profession, password, role) VALUES (1, 'admin', 'admin', 0, 'admin', '$2y$10$kbBc2/YyhalAHuK.SRiFPeu/iENCtVjUS9sK4A3/4b5EXdgqcj0cy', 'ADMIN');
INSERT INTO users2 (id, name, surname, age, profession, password, role) VALUES (2, 'Lex', 'Luger', 25, 'Fighter', '$2y$10$kbBc2/YyhalAHuK.SRiFPeu/iENCtVjUS9sK4A3/4b5EXdgqcj0cy', 'USER');
INSERT INTO users2 (id, name, surname, age, profession, password, role) VALUES (3, 'Joan', 'Osborne', 30, 'Singer', '$2y$10$kbBc2/YyhalAHuK.SRiFPeu/iENCtVjUS9sK4A3/4b5EXdgqcj0cy', 'USER');
INSERT INTO users2 (id, name, surname, age, profession, password, role) VALUES (4, 'Mark', 'Twain', 50, 'Writer', '$2y$10$kbBc2/YyhalAHuK.SRiFPeu/iENCtVjUS9sK4A3/4b5EXdgqcj0cy', 'USER');
INSERT INTO roles2 (id, name) VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'STRANGER');
INSERT INTO users2_roles2 VALUES (1, 1),(2, 2),(3, 2),(4, 2);
