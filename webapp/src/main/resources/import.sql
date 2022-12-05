
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (1,'username1', 'nombrecompleto1', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (2,'username2', 'nombrecompleto2', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (3,'username3', 'nombrecompleto3', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')
INSERT INTO USUARIOS (ID, USERNAME, NOMBRE_COMPLETO, PASSWORD, ENABLED, AUTHORITY) VALUES (4,'username4', 'nombrecompleto4', '$2a$10$3PYDmPDUliEnU7hSuiutrOC3f3MvDpgz1eZaPu2x8aOCY37XcWYdi', 1, 'user')



INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola1', 'descripcion1', 1, 40, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola2', 'descripcion2', 1, 50, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola3', 'descripcion3', 1, 60, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola4', 'descripcion1', 1, 40, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola5', 'descripcion2', 1, 50, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola6', 'descripcion3', 1, 60, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola7', 'descripcion1', 1, 40, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola8', 'descripcion2', 1, 50, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola9', 'descripcion3', 1, 60, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola10', 'descripcion1', 1, 40, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola11', 'descripcion2', 1, 50, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola12', 'descripcion3', 1, 60, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola13', 'descripcion1', 1, 40, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola14', 'descripcion2', 1, 50, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))
INSERT INTO EVENTOS (titulo, descripcion, FK_USER_ADMIN, MAX_PERSONS, DATE_AT, DATE_FINAL) VALUES ('hola15', 'descripcion3', 1, 60, PARSEDATETIME(20201201, 'yyyyMMdd'), PARSEDATETIME(20201202, 'yyyyMMdd'))

INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (1, 2)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (2, 2)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (3, 2)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (4, 2)
INSERT INTO SUBSCRIPTION(FK_EVENTO, FK_USUARIO) VALUES (1, 4)

