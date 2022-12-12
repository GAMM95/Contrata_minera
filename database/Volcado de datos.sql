use ContrataMinera;

-- Dumping data for table 'empresa'
insert into empresa (ruc, razonSocial, ciiu, telefono, celular, direccionLegal, email, paginaWeb, logo, ruta)
values ('###########','########','#####','#########','#########','#################','#################','###########',
LOAD_FILE('F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg'),'F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg');

-- Dumping data for cargo table
insert into dbo.cargo (nombre,categoria) values ('Supervisor de operaciones','Empleado');
insert into dbo.cargo (nombre,categoria) values ('Supervisor de seguridad','Empleado');
insert into dbo.cargo (nombre,categoria) values ('Asistente de operaciones','Empleado');
insert into dbo.cargo (nombre,categoria) values ('Asistente de seguridad','Empleado');
insert into dbo.cargo (nombre,categoria) values ('Asistente administrativo','Empleado');
insert into dbo.cargo (nombre,categoria) values ('Operador','Obrero');
insert into dbo.cargo (nombre,categoria) values ('Mecanico','Obrero');
insert into dbo.cargo (nombre,categoria) values ('Llantero','Obrero');
insert into dbo.cargo (nombre,categoria) values ('Conductor de combi','Obrero');

insert into dbo.trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('70120107','Altamirano Anticona','Dicasion','Masculino','Soltero','1988-11-18','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Florida S/N','998161235','Primaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('42940600','Ruiz Carrion','Elder Hugo','Masculino','Soltero','1985-02-27','La Libertad','Sanchez Carrion','Huamachuco','Av. Los Angeles 51 - Caserio Quinta Alta','926140036','Secundaria completa',NULL,9);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('44253243','Moreno Baylon','Idelson Eleodoro','Masculino','Conviviente','1975-11-16','La Libertad','Sanchez Carrion','Huamachuco','Caserio Quinta Alta','987444666','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19560828','Acevedo Baltazar','Mercedes','Masculino','Conviviente','1970-03-02','La Libertad','Sanchez Carrion','Huamachuco','Javier Heraud Cda 5','950031665','Secundaria completa',NULL,9);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('10753085','Acevedo Baltazar','Santos Benito','Masculino','Conviviente','1978-03-21','La Libertad','Sanchez Carrion','Huamachuco','Javier Heraud Cda 5','914678266','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('42396744','Altamirano Asuncion','Ronald Richard','Masculino','Conviviente','1978-08-15','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Colpa','958292979','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('45512152','Graus Rodriguez ','Santos Anastacio','Masculino','Conviviente','1974-10-18','La Libertad','Sanchez Carrion','Huamachuco','Psje. Junin 451','952985830','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('70884654','Olivares Valle','Elder Omar','Masculino','Soltero','1993-08-09','La Libertad','Trujillo','Moche','San Francisco 1180 Alto Moche','958120706','Universitario','Bachiller en Ingenieria de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('41577541','Flores Castillo','Faustino Confesor','Masculino','Casado','1972-12-07','La Libertad','Sanchez Carrion','Huamachuco','Caserio Paranshique','914862011','Tecnico','Electricista',7);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19578462','Altamirano Asuncion','Hugo Kenedy','Masculino','Conviviente','1978-01-25','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Colpa','906517462','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19576594','Escobedo Peña','Berthadele','Masculino','Conviviente','1982-11-11','La Libertad','Sanchez Carrion','Huamachuco','Psje. San Pedro','988862967','Tecnico','Mecanico de mantenimiento',7);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('74429473','Seclen Ruiz','Jhon Edgar','Masculino','Conviviente','1983-10-26','La Libertad','Otuzco','Otuzco','Psje. Trujillo 1546','942157236','Tecnico','Mecanico de mantenimiento',7);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('71609619','Ruiz Carranza','Juan Carlos','Masculino','Conviviente','1988-05-19','La Libertad','Sanchez Carrion','Huamachuco','Psje Balta Cuadra 3','916151763','Tecnico','Mecanico de mantenimiento',7);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19558715','Vera Acevedo','Gonzalo','Masculino','Conviviente','1979-06-16','La Libertad','Sanchez Carrion','Huamachuco','Psje. Heraud 1626','948666328','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('42930920','Gonzales Rojas','Daniel Ananias','Masculino','Soltero','1985-04-19','Lima','Lima','Lima','Grau 439 INT. 309','977656269','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('71219950','Polo Joaquin','Eduar Wilson','Masculino','Conviviente','1985-11-13','La Libertad','Sanchez Carrion','Huamachuco','Caserio Quinta Alta','978468618','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('70515736','Flores Baltazar','Ronald','Masculino','Casado','1976-10-28','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Ramada','919892600','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('47606040','Ballena Ballena','Alex Miguel','Masculino','Conviviente','1980-10-15','La Libertad','Sanchez Carrion','Huamachuco','Coygobamba','950629863','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('48435209','Palomino Contreras','Wilson','Masculino','Conviviente','1984-01-07','La Libertad','Sanchez Carrion','Huamachuco','Av. 10 de Julio 264','918815698','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46372750','Campos Castillo','Moises','Masculino','Conviviente','1985-04-16','La Libertad','Sanchez Carrion','Huamachuco','Caserio San Miguel','929842606','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46852611','Campos Infantes','Santos Arcadio','Masculino','Conviviente','1992-03-10','La Libertad','Sanchez Carrion','Huamachuco','Psje. Junin 128','917182610','Secundaria completa',NULL,8);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('43718945','Calderon Rodriguez ','Luis Clademir','Masculino','Conviviente','1986-09-03','La Libertad','Sanchez Carrion','Marcabal','Caserio San Miguel','996810145','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('41907077','Barreto Gorbalan','Jhonny Roger','Masculino','Conviviente','1983-08-12','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Colpa','909546973','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46061784','Valderrama Garcia','Florencio','Masculino','Conviviente','1981-08-07','La Libertad','Sanchez Carrion','Huamachuco','Jr. Balta 13','986162236','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('47770331','Pizan Tumbajulca','Ever','Masculino','Soltero','1990-09-25','La Libertad','Sanchez Carrion','Huamachuco','Caserio Paranshique','988452966','Tecnico','Mecanico de mantenimiento',7);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19571416','Baltazar Escobedo','Modesto','Masculino','Conviviente','1976-01-12','La Libertad','Viru','Viru','Mz 23 LT 14 Los Pinos','936279900','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('19559410','Ruiz Carrion','Enrique','Masculino','Casado','1971-07-13','La Libertad','Sanchez Carrion','Huamachuco','Caserio Quinta Alta','900331189','Secundaria completa',NULL,9);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('73568829','Salvatierra Baltazar','Yolbin Wilser','Masculino','Soltero','1994-11-30','La Libertad','Sanchez Carrion','Huamachuco','Jr. Balta 45','929096266','Universitario','Bachiller Ingenieria de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('72252469','Marcelo Miñano','Liliana Patricia','Femenino','Soltero','1996-02-26','La Libertad','Santiago de Chuco','Santiago de Chuco','Psje. Nestor Morales 229','923146659','Universitario','Bachiller Ingenieria de minas',2);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46396464','Ruiz Valverde','Jaime','Masculino','Conviviente','1990-04-15','La Libertad','Sanchez Carrion','Huamachuco','Jr. Huanuco #361','941516186','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46423452','Valderrama Altamirano','Wilmer','Masculino','Conviviente','1985-10-18','La Libertad','Sanchez Carrion','Huamachuco','Caserio Paranshique','910336035','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('45957372','Ynfantes Polo','Gilmer Confesor','Masculino','Casado','1975-05-27','La Libertad','Sanchez Carrion','Huamachuco','Caserio La Arena','977845160','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('46524990','Marcelo Esquivel','Catalino Felipe','Masculino','Casado','1979-10-29','La Libertad','Santiago de Chuco','Santiago de Chuco','Psje. Cesar Vallejo 156','917416284','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('75503501','Tandaypan Rodriguez','Carlos','Masculino','Conviviente','1993-04-09','La Libertad','Sanchez Carrion','Huamachuco','Av. Trujillo Cuadra 3','917813969','Universitario','Bachiller Ingenieria de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('48553931','Sare Alvarez','Edin Enrique','Masculino','Soltero','1993-04-22','La Libertad','Sanchez Carrion','Huamachuco','Av. 10 de Julio 1536','922154667','Tecnico','Mecanico de mantenimiento',6)
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('73120078','Rojas Aguilar','Antonio','Masculino','Soltero','1978-09-12','La Libertad','Sanchez Carrion','Huamachuco','Jr. Huanuco 1416','988400560','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('71971030','Infantes Negreiros','Heiner','Masculino','Soltero','1994-05-02','La Libertad','Sanchez Carrion','Huamachuco','Caserio El Toro','942699827','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('45351290','Esquivel Barreto','Elin Alin','Masculino','Conviviente','1988-09-07','La Libertad','Sanchez Carrion','Huamachuco','Caserio Santo Domingo','905496299','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('44727031','Graus Rodriguez ','Combercion','Masculino','Soltero','1986-11-02','La Libertad','Sanchez Carrion','Huamachuco','Jr. Pachacutec 155','958926846','Universitario','Ingeniero de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('75269630','Segura Campos','Jhon Marino','Masculino','Conviviente','1994-04-02','La Libertad','Sanchez Carrion','Huamachuco','Jr. Florencia de Mora 320','972392226','Universitario','Bachiller Ingenieria de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('47419890','Barreto Esquivel','Abimael','Masculino','Conviviente','1992-10-28','La Libertad','Sanchez Carrion','Huamachuco','Jr. San Roman Cuadra 1','959484966','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('72872907','Chacon Villalva','Wilson','Masculino','Soltero','1995-05-14','La Libertad','Sanchez Carrion','Huamachuco','Javier Heraud Cda 2','959789267','Universitario','Bachiller Ingenieria de minas',1);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('41143587','Otiniano Ruiz','Hely Misale','Masculino','Soltero','1990-11-25','La Libertad','Sanchez Carrion','Huamachuco','Garcilazo de la Vega s/n','913100310','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('70219243','Palomino Tandaypan','Luis Daniel','Masculino','Conviviente','1993-10-10','La Libertad','Sanchez Carrion','Huamachuco','Caserio Quinta Alta','940604883','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('42643012','Esteban Morillo','Santos Fortunato','Masculino','Conviviente','1984-10-13','La Libertad','Sanchez Carrion','Huamachuco','Coygobamba','941663178','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('41743215','Altamirano Aranda','Cristian','Masculino','Conviviente','1983-03-22','La Libertad','Sanchez Carrion','Huamachuco','Caserio Quinta Alta','925979995','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('72871863','Yupanqui Lavado','Laura Massiel','Femenino','Soltero','1999-07-06','La Libertad','Sanchez Carrion','Huamachuco','Jr. Sucre 989','916568267','Universitario','Bachiller Ingenieria Industrial',5);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('41693405','Anticona Campos','Pablo','Masculino','Casado','1983-02-25','La Libertad','Sanchez Carrion','Curgos','Garcilazo de la Vega s/n','903154854','Secundaria completa',NULL,6);
INSERT INTO dbo.trabajador (dni,apellidos,nombres,sexo,estadoCivil,fechaNacimiento,departamento,provincia,distrito,direccion,telefono,gradoInstruccion,profesion,codCargo)		
VALUES ('72965274','Tandaypan Campos','Felix Gabriel','Masculino','Conviviente','1998-10-22','La Libertad','Sanchez Carrion','Huamachuco','Psje. San Pedro','931499299','Tecnico','Mecanico de mantenimiento',7);
END;
GO