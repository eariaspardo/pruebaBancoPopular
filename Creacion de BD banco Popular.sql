CREATE TABLE cliente (
	id serial NOT NULL,
	documento Integer NOT NULL,
	nombre varchar(200) NULL,
	fecha_ingreso date NOT NULL,
	fecha_salida date NOT null,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);

CREATE TABLE servicio (
	id serial NOT NULL,
	descripcion varchar(300) NOT NULL,
	precio numeric NOT null,
	CONSTRAINT servicio_pkey PRIMARY KEY (id)
);

CREATE TABLE cliente_servicio (
	id SERIAL,
	id_cliente Integer NOT NULL,
	id_servicio Integer not null,
	CONSTRAINT cliente_servicio_pkey PRIMARY KEY (id),
	CONSTRAINT cliente_servicio_id_cliente_key FOREIGN KEY (id_cliente) REFERENCES cliente (id),
	CONSTRAINT cliente_servicio_id_servicio_key FOREIGN KEY (id_servicio) REFERENCES servicio (id)
);

CREATE TABLE acompañantes (
	id serial NOT NULL,
	documento Integer NOT NULL,
	nombre varchar(300) NOT NULL,
	id_cliente Integer NOT null,
	CONSTRAINT acompañantes_pkey PRIMARY KEY (id),
	CONSTRAINT acompañantes_id_cliente_key FOREIGN KEY (id_cliente) REFERENCES cliente (id)
);

INSERT INTO cliente
(documento, nombre, fecha_ingreso, fecha_salida)
VALUES(6871263, 'Edilson Arias', '2022-03-01', '2022-03-10');
INSERT INTO cliente
(documento, nombre, fecha_ingreso, fecha_salida)
VALUES(10335465, 'Willian Ferney Ariza', '2022-03-15', '2022-03-18');
INSERT INTO cliente
(documento, nombre, fecha_ingreso, fecha_salida)
VALUES(687651, 'Yeraldin Pardo', '2022-03-28', '2022-04-15');
INSERT INTO cliente
(documento, nombre, fecha_ingreso, fecha_salida)
VALUES(852146, 'Luz Deiby Arias', '2022-03-01', '2022-04-01');

INSERT INTO servicio
(descripcion, precio)
VALUES('SPA', 10000);
INSERT INTO servicio
(descripcion, precio)
VALUES('Restaurante', 30000);
INSERT INTO servicio
(descripcion, precio)
VALUES('Gym', 15000);
INSERT INTO servicio
(descripcion, precio)
VALUES('Plan Todo incluido', 90000);

INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES( 1, 1);
INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES(1, 2);
INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES( 2, 2);
INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES( 3, 4);
INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES( 3, 2);
INSERT INTO cliente_servicio
(id_cliente, id_servicio)
VALUES(2, 3);

INSERT INTO acompanantes
( documento, nombre, id_cliente)
VALUES( 654132, 'Luz Helijer Pardo', 1);
INSERT INTO acompanantes
( documento, nombre, id_cliente)
VALUES( 987654, 'Pablo Neruda', 1);
INSERT INTO acompanantes
( documento, nombre, id_cliente)
VALUES( 741258, 'Jeison Jimenez', 2);
INSERT INTO acompanantes
( documento, nombre, id_cliente)
VALUES( 79854, 'Mario Martinez', 1);



