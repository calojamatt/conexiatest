--
-- Create TABLE `conexiatest`.`cliente`
--
CREATE TABLE conexiatest.cliente (
  idCliente int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(70) NOT NULL,
  Apellido1 varchar(30) NOT NULL,
  Apellido2 varchar(30) DEFAULT NULL,
  Observaciones varchar(255) DEFAULT NULL,
  PRIMARY KEY (idCliente)
)
ENGINE = INNODB,
COMMENT = 'almacena informacion de clientes';

--
-- Create TABLE `conexiatest`.`mesa`
--
CREATE TABLE conexiatest.mesa (
  idMesa int(11) NOT NULL AUTO_INCREMENT,
  NumMaxComensales smallint(6) NOT NULL,
  Ubicacion varchar(100) DEFAULT NULL,
  PRIMARY KEY (idMesa)
)
ENGINE = INNODB,
COMMENT = 'Almacena informacion de las mesas';

--
-- Create TABLE `conexiatest`.`camarero`
--
CREATE TABLE conexiatest.camarero (
  idCamarero int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(70) NOT NULL,
  Apellido1 varchar(30) NOT NULL,
  Apellido2 varchar(30) DEFAULT NULL,
  PRIMARY KEY (idCamarero)
)
ENGINE = INNODB,
COMMENT = 'Almacena informacion de los camareros que atienden las mesas';

--
-- Create TABLE `conexiatest`.`cocinero`
--
CREATE TABLE conexiatest.cocinero (
  idCocinero int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(70) NOT NULL,
  Apellido1 varchar(30) NOT NULL,
  Apellido2 varchar(255) DEFAULT NULL,
  PRIMARY KEY (idCocinero)
)
ENGINE = INNODB,
COMMENT = 'Almacena informacion de los cocineros del restaurante';

--
-- Create TABLE `conexiatest`.`plato`
--
CREATE TABLE conexiatest.plato (
  idPlato int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(200) NOT NULL,
  importe float(15, 2) NOT NULL,
  idCocinero int(11) DEFAULT NULL,
  PRIMARY KEY (idPlato)
)
ENGINE = INNODB,
COMMENT = 'Almacena los datos de los platos que ofrece el restaurante';

ALTER TABLE conexiatest.plato
ADD CONSTRAINT FK_plato_cocinero FOREIGN KEY (idCocinero)
REFERENCES conexiatest.cocinero (idCocinero) ON DELETE NO ACTION;

--
-- Create TABLE `conexiatest`.`factura`
--
CREATE TABLE conexiatest.factura (
  idFactura int(11) NOT NULL AUTO_INCREMENT,
  idCliente int(11) DEFAULT NULL,
  idCamarero int(11) DEFAULT NULL,
  idMesa int(11) DEFAULT NULL,
  FechaFactura datetime DEFAULT NULL,
  PRIMARY KEY (idFactura)
)
ENGINE = INNODB,
COMMENT = 'Almacena los datos principales de la factura';

ALTER TABLE conexiatest.factura
ADD CONSTRAINT FK_factura_cliente FOREIGN KEY (idCliente)
REFERENCES conexiatest.cliente (idCliente) ON DELETE NO ACTION;

ALTER TABLE conexiatest.factura
ADD CONSTRAINT FK_factura_camarero FOREIGN KEY (idCamarero)
REFERENCES conexiatest.camarero (idCamarero) ON DELETE NO ACTION;

ALTER TABLE conexiatest.factura
ADD CONSTRAINT FK_factura_mesa FOREIGN KEY (idMesa)
REFERENCES conexiatest.mesa (idMesa) ON DELETE NO ACTION;

--
-- Create TABLE `conexiatest`.`detallefactura`
--
CREATE TABLE conexiatest.detallefactura (
  idDetalleFactura int(11) NOT NULL AUTO_INCREMENT,
  idFactura int(11) NOT NULL,
  idCocinero int(11) NOT NULL,
  idPlato int(11) NOT NULL,
  importe float(15, 2) NOT NULL,
  PRIMARY KEY (idDetalleFactura)
)
ENGINE = INNODB,
COMMENT = 'Almacena en detalle la informacion de lo registrado en la factura';

ALTER TABLE conexiatest.detallefactura
ADD CONSTRAINT FK_detallefactura_cocinero FOREIGN KEY (idCocinero)
REFERENCES conexiatest.cocinero (idCocinero) ON DELETE NO ACTION;

ALTER TABLE conexiatest.detallefactura
ADD CONSTRAINT FK_detallefactura_factura FOREIGN KEY (idFactura)
REFERENCES conexiatest.factura (idFactura) ON DELETE NO ACTION;

ALTER TABLE conexiatest.detallefactura
ADD CONSTRAINT FK_detallefactura_plato FOREIGN KEY (idPlato)
REFERENCES conexiatest.plato (idPlato) ON DELETE NO ACTION;