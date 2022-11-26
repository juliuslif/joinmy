
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (1,'username1', 'nombrecompleto1', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (2,'username2', 'nombrecompleto2', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (3,'username3', 'nombrecompleto3', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (4,'username4', 'nombrecompleto4', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')



INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola1', 'descripcion1', 1, 40)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola2', 'descripcion2', 1, 50)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola3', 'descripcion3', 1, 60)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola4', 'descripcion1', 1, 40)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola5', 'descripcion2', 1, 50)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola6', 'descripcion3', 1, 60)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola7', 'descripcion1', 1, 40)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola8', 'descripcion2', 1, 50)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola9', 'descripcion3', 1, 60)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola10', 'descripcion1', 1, 40)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola11', 'descripcion2', 1, 50)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola12', 'descripcion3', 1, 60)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola13', 'descripcion1', 1, 40)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola14', 'descripcion2', 1, 50)
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS) VALUES ('hola15', 'descripcion3', 1, 60)

INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (1, 2)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (1, 3)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (1, 4)

