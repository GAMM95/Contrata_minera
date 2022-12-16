
use ContrataMinera;

-- Dumping data for table 'empresa'
insert into empresa (ruc, razonSocial, ciiu, telefono, celular, direccionLegal, email, paginaWeb, logo, ruta)
values ('###########','########','#####','#########','#########','#################','#################','###########',
LOAD_FILE('F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg'),'F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg');
select * from empresa;

-- Dumping data for cargo table
insert into cargo (nombreCargo,categoria) values ('Supervisor de operaciones','Empleado');
insert into cargo (nombreCargo,categoria) values ('Supervisor de seguridad','Empleado');
insert into cargo (nombreCargo,categoria) values ('Asistente de operaciones','Empleado');
insert into cargo (nombreCargo,categoria) values ('Asistente de seguridad','Empleado');
insert into cargo (nombreCargo,categoria) values ('Asistente administrativo','Empleado');
insert into cargo (nombreCargo,categoria) values ('Operador','Obrero');
insert into cargo (nombreCargo,categoria) values ('Mecanico','Obrero');
insert into cargo (nombreCargo,categoria) values ('Llantero','Obrero');
insert into cargo (nombreCargo,categoria) values ('Conductor de combi','Obrero');

-- Dumping data for trabajador table
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('70120107','Altamirano','Anticona','Dicasion','Masculino','Soltero','1988-11-18','Caserio La Florida S/N','998161235','Primaria completa','',null,'','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('42940600','Ruiz','Carrión','Elder Hugo','Masculino','Soltero','1985-02-27','Av. Los Angeles 51 - Caserio Quinta Alta','926140036','Secundaria completa','', null, '', 'Activo',9);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('44253243','Moreno','Baylon','Idelson Eleodoro','Masculino','Conviviente','1975-11-16','Caserio Quinta Alta','987444666','Secundaria completa','', null, '','Activo', 6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19560828','Acevedo','Baltazar','Mercedes','Masculino','Conviviente','1970-03-02','Javier Heraud Cda 5','950031665','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('10753085','Acevedo','Baltazar','Santos Benito','Masculino','Conviviente','1978-03-21','Javier Heraud Cda 5','914678266','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('42396744','Altamirano','Asunción','Ronald Richard','Masculino','Conviviente','1978-08-15','Caserio La Colpa','958292979','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('45512152','Graus','Rodríguez ','Santos Anastacio','Masculino','Conviviente','1974-10-18','Psje. Junin 451','952985830','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('70555743','Mantilla','Miñano','Edwin Jhonatan','Masculino','Soltero','1995-03-19','Mz a3 lt 45 2° etapa Urb. Manuel Arévalo','950212908','Universitario','Ingeniero de minas', null, '','Activo',1);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('41577541','Flores','Castillo','Faustino Confesor','Masculino','Casado','1972-12-07','Caserio Paranshique','914862011','Técnico','Electricista','', null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19578462','Altamirano','Asuncion','Hugo Kenedy','Masculino','Conviviente','1978-01-25','Caserio La Colpa','906517462','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19576594','Escobedo','Peña','Berthadele','Masculino','Conviviente','1982-11-11','Psje. San Pedro','988862967','Técnico','Mecánico de mantenimiento', null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('74429473','Seclén','Ruíz','Jhon Edgar','Masculino','Conviviente','1983-10-26','Psje. Trujillo 1546','942157236','Técnico','Mecánico de mantenimiento', null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('71609619','Ruiz','Carranza','Juan Carlos','Masculino','Conviviente','1988-05-19','Psje Balta Cuadra 3','916151763','Técnico','Mecánico de mantenimiento', null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19558715','Vera','Acevedo','Gonzalo','Masculino','Conviviente','1979-06-16','Psje. Heraud 1626','948666328','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('42930920','Gonzales','Rojas','Daniel Ananias','Masculino','Soltero','1985-04-19','Grau 439 INT. 309','977656269','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('71219950','Polo','Joaquin','Eduar Wilson','Masculino','Conviviente','1985-11-13','Caserio Quinta Alta','978468618','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('70515736','Flores','Baltazar','Ronald','Masculino','Casado','1976-10-28','Caserio La Ramada','919892600','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('47606040','Ballena','Ballena','Alex Miguel','Masculino','Conviviente','1980-10-15','Coygobamba','950629863','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('48435209','Palomino','Contreras','Wilson','Masculino','Conviviente','1984-01-07','Av. 10 de Julio 264','918815698','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('46372750','Campos','Castillo','Moises','Masculino','Conviviente','1985-04-16','Caserio San Miguel','929842606','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('46852611','Campos','Infantes','Santos Arcadio','Masculino','Conviviente','1992-03-10','Psje. Junin 128','917182610','Secundaria completa','', null, '','Activo',8);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('43718945','Calderon','Rodriguez','Luis Clademir','Masculino','Conviviente','1986-09-03','Caserio San Miguel','996810145','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('41907077','Barreto','Gorbalan','Jhonny Roger','Masculino','Conviviente','1983-08-12','Caserio La Colpa','909546973','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('46061784','Valderrama','Garcia','Florencio','Masculino','Conviviente','1981-08-07','Jr. Balta 13','986162236','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('47770331','Pizan','Tumbajulca','Ever','Masculino','Soltero','1990-09-25','Caserio Paranshique','988452966','Técnico','Mecanico de mantenimiento',null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19571416','Baltazar','Escobedo','Modesto','Masculino','Conviviente','1976-01-12','Mz 23 LT 14 Los Pinos','936279900','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('19559410','Ruiz','Carrion','Enrique','Masculino','Casado','1971-07-13','Caserio Quinta Alta','900331189','Secundaria completa','', null, '','Activo',9);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
values ('73568829','Salvatierra','Baltazar','Yolbin Wilser','Masculino','Soltero','1994-11-30','Jr. Balta 45','929096266','Universitario','Ingeniero de minas',null, '','Activo',1);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('72252469','Marcelo','Miñano','Liliana Patricia','Femenino','Soltero','1996-02-26','Psje. Nestor Morales 229','923146659','Universitario','Bachiller Ingenieria de minas',null, '','Activo',2);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('46396464','Ruiz','Valverde','Jaime','Masculino','Conviviente','1990-04-15','Jr. Huanuco #361','941516186','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('46423452','Valderrama','Altamirano','Wilmer','Masculino','Conviviente','1985-10-18','Caserio Paranshique','910336035','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('45957372','Ynfantes','Polo','Gilmer Confesor','Masculino','Casado','1975-05-27','Caserio La Arena','977845160','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('46524990','Marcelo','Esquivel','Catalino Felipe','Masculino','Casado','1979-10-29','Psje. Cesar Vallejo 156','917416284','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('75503501','Tandaypan','Rodriguez','Carlos','Masculino','Conviviente','1993-04-09','Av. Trujillo Cuadra 3','917813969','Universitario','Ingeniero de minas',null, '','Activo',1);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('48553931','Sare','Alvarez','Edin Enrique','Masculino','Soltero','1993-04-22','Av. 10 de Julio 1536','922154667','Técnico','Mecanico de mantenimiento',null, '','Activo',7);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('73120078','Rojas','Aguilar','Antonio','Masculino','Soltero','1978-09-12','Jr. Huanuco 1416','988400560','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('71971030','Infantes','Negreiros','Heiner','Masculino','Soltero','1994-05-02','Caserio El Toro','942699827','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('45351290','Esquivel','Barreto','Elin Alin','Masculino','Conviviente','1988-09-07','Caserio Santo Domingo','905496299','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('44727031','Graus','Rodriguez ','Combercion','Masculino','Soltero','1986-11-02','Jr. Pachacutec 155','958926846','Universitario','Ingeniero de minas',null, '','Activo',1);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('75269630','Segura','Campos','Jhon Marino','Masculino','Conviviente','1994-04-02','Jr. Florencia de Mora 320','972392226','Universitario','Bachiller Ingenieria de minas', null, '','Activo',1);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('47419890','Barreto','Esquivel','Abimael','Masculino','Conviviente','1992-10-28','Jr. San Roman Cuadra 1','959484966','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('72872907','Chacon','Villalva','Wilson','Masculino','Soltero','1995-05-14','Javier Heraud Cda 2','959789267','Universitario','Bachiller Ingenieria de minas',null, '','Activo',3);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('41143587','Otiniano','Ruiz','Hely Misale','Masculino','Soltero','1990-11-25','Garcilazo de la Vega s/n','913100310','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('70219243','Palomino','Tandaypan','Luis Daniel','Masculino','Conviviente','1993-10-10','Caserio Quinta Alta','940604883','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('42643012','Esteban','Morillo','Santos Fortunato','Masculino','Conviviente','1984-10-13','Coygobamba','941663178','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('41743215','Altamirano','Aranda','Cristian','Masculino','Conviviente','1983-03-22','Caserio Quinta Alta','925979995','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('72871863','Yupanqui','Lavado','Laura Massiel','Femenino','Soltero','1999-07-06','Jr. Sucre 989','916568267','Universitario','Bachiller Ingenieria Industrial',null, '','Activo',5);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('41693405','Anticona','Campos','Pablo','Masculino','Casado','1983-02-25','Garcilazo de la Vega s/n','903154854','Secundaria completa','', null, '','Activo',6);
insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, estado, codCargo)		
VALUES ('72965274','Tandaypan','Campos','Felix Gabriel','Masculino','Conviviente','1998-10-22','Psje. San Pedro','931499299','Técnico','Mecanico de mantenimiento',null, '','Activo',7);

-- Dumping data for perfilLaboral table
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) values ('2019-06-10','Operaciones mina','2200',null,'',1);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-06-10','Transporte','1800',null,'',2);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-06-10','Operaciones mina','2200','2020-07-24','Renuncia',3);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-06-10','Operaciones mina','2200','2021-01-15','Renuncia',4);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-06-10','Operaciones mina','2200',NULL,'',5);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-07-23','Operaciones mina','2200','2021-07-12','Falta',6);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-07-23','Operaciones mina','2200','2021-04-05','Falta',7);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-07-29','Operaciones mina','2500','2022-04-12','Renuncia',8);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-08-06','Mantenimiento','1800','2020-08-13','Renuncia',9);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-12-15','Operaciones mina','2200',NULL,'','10');
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-08-19','Mantenimiento','1800','2021-03-23','Renuncia',11);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-08-19','Mantenimiento','1800','2021-01-06','Renuncia',12);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2019-08-19','Mantenimiento','1800','2020-02-15','Renuncia',13);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-06-09','Operaciones mina','2200','2021-04-23','Renuncia',14);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-06-12','Operaciones mina','2200',NULL,'',15);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-08-05','Operaciones mina','2200','2021-08-17','Renuncia',16);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-08-05','Operaciones mina','2200','2021-10-10','Renuncia',17);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-08-14','Operaciones mina','2200','2021-05-16','Renuncia',18);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-09-01','Operaciones mina','2200','2021-06-29','Incidente grave',19);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-09-09','Operaciones mina','2200','2021-07-06','Falta',20);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-11-29','Mantenimiento','1600',NULL,'','21');
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-10-28','Operaciones mina','2200',NULL,'',22);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-11-07','Operaciones mina','2200',NULL,'',23);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-11-14','Operaciones mina','2200','2021-08-02','Falta',24);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-11-19','Mantenimiento','1800','2021-05-22','Renuncia',25);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-11-27','Operaciones mina','2200',NULL,'',26);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2020-11-29','Transporte','1800',NULL,'',27);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-01-17','Operaciones mina','2500','2022-03-13','Renuncia',28);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-01-26','Seguridad','2300',NULL,'',29);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-02-02','Operaciones mina','2200',NULL,'',30);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-03-30','Operaciones mina','2200','2022-04-02','Abandono de labores',31);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-04-06','Operaciones mina','2200','2021-12-12','Renuncia',32);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-05-25','Operaciones mina','2200','2021-06-15','Renuncia',33);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-06-04','Operaciones mina','2500','2021-08-31','Renuncia',34);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-06-15','Mantenimiento','1800','2021-08-18','Renuncia',35);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-07-08','Operaciones mina','2200','2021-12-21','Renuncia',36);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-07-08','Operaciones mina','2200',NULL,'',37);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-07-09','Operaciones mina','2200',NULL,'',38);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-08-17','Operaciones mina','2500',NULL,'',39);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-01-24','Operaciones mina','2200',NULL,'',40);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-09-21','Operaciones mina','2200',NULL,'',41);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-04-12','Operaciones mina','2500',NULL,'',42);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-10-14','Operaciones mina','2200','2021-10-28','No aprobó exámen',43);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2021-12-27','Operaciones mina','2200',NULL,'',44);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-01-13','Operaciones mina','2200',NULL,'',45);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-01-18','Operaciones mina','2200',NULL,'',46);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-02-01','Administración','1500',NULL,'',47);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-02-07','Operaciones mina','2200',NULL,'',48);
insert into perfillaboral (fechaIngreso,area,sueldo,fechaCese,motivoCese,idTrabajador) VALUES ('2022-02-16','Mantenimiento','1800',NULL,'',49);

-- Dumping data for Licencia table
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D19560828','AIIIC','2019-11-15','2022-10-05',4);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D10753085','AIIIC','2016-02-21','2022-08-15',5);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D70120107','AIIIC','2016-05-23','2022-06-28',1);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D41743215','AIIIC','2017-02-14','2022-10-06',46);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D19578462','AIIIC','2018-08-19','2022-10-06',10);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D42396744','AIIIC','2018-06-16','2022-06-23',6);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D41693405','AIIIC','2014-07-23','2024-01-27',48);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D47606040','AIIIB','2018-12-31','2021-10-27',18);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D19571416','AIIIC','2018-12-31','2026-11-27',26);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D47419890','AIIIC','2016-08-11','2022-09-19',41);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D41907077','AIIIC','2021-10-22','2026-11-06',23);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D43718945','AIIIC','2017-06-10','2022-10-26',22);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D46372750','AIIIB','2017-05-25','2021-06-14',20);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D72872907','AI','2017-01-11','2022-10-07',42);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D45351290','AIIIC','2017-06-02','2022-07-08',38);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D42643012','AIIIC','2017-09-02','2022-10-06',45);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('Q70515736','AIIIC','2015-12-21','2020-01-15',17);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D41577541','AIIIC','2016-07-06','2021-10-06',9);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D42930920','AIIIB','2017-04-14','2022-07-05',15);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D45512152','AIIB','2016-05-10','2022-01-23',7);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D71971030','AIIIC','2017-06-03','2022-07-08',37);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D46524990','AIIIC','2018-03-01','2025-05-23',33);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D44253243','AIIIC','2015-08-29','2021-05-25',3);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D70555743','AI','2029-05-07','2022-08-16',8);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D48435209','AIIIB','2018-12-31','2023-11-03',19);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D70219243','AIIIB','2017-09-15','2022-10-06',44);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D71219950','AIIIB','2021-01-24','2026-10-06',16);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D73120078','AIIIC','2018-02-22','2022-07-08',36);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D42940600','AIIIC','2017-02-04','2022-10-27',2);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('Q19559410','AIIIC','2018-09-30','2021-11-28',27);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D46396464','AIIIC','2016-12-31','2022-01-30',30);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D73568829','AI','2018-11-14','2028-01-14',28);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('Q48553931','AIIB','2017-10-15','2027-10-15',35);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D75269630','AI','2016-10-18','2026-10-18',40);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D75503501','AI','2017-10-23','2027-10-23',34);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D46423452','AIIIC','2016-12-06','2025-03-28',31);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D46061784','AIIIB','2021-09-05','2027-11-13',24);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D19558715','AIIIB','2018-10-26','2025-09-19',14);
insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad,idTrabajador) values ('D45957372','AIIIC','2020-09-18','2026-04-05',32);

-- Dumping data for tipoVehiculo table
insert into tipovehiculo (nombreTipo) value ('Volquete');
insert into tipovehiculo (nombreTipo) value ('Camioneta');
insert into tipovehiculo (nombreTipo) value ('Combi');

-- Dumping data for vehiculo table
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('V_1300','T0A-844','Volvo','Volvo FMX 540','2019-03-14','2019',1);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('V_1301','T0A-831','Volvo','Volvo FMX 540','2019-03-14','2019',1);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('V_1306','T0R-944','Volvo','Volvo FMX 540','2020-10-15','2020',1);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('V_1307','T0R-911','Volvo','Volvo FMX 540','2020-10-15','2020',1);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('V_1308','T0W-943','Volvo','Volvo FMX 540','2020-10-15','2020',1);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('CA_099','BAY-916','Toyota','Hilux','2021-07-07','2019',2);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('CA_100','T0X-919','Toyota','Hilux','2021-08-21','2021',2);
insert into vehiculo (idVehiculo,placa,modelo,marca,fechaCompra,año,codTipo) values ('CO_098','T9A-955','Mitsubishi','Common Rail','2021-10-16','2020',3);

-- Dumping data for vehiculo table
insert into guardia (nombreGuardia,codTurno) values ('Guardia A',1);
insert into guardia (nombreGuardia,codTurno) values ('Guardia A',2);
insert into guardia (nombreGuardia,codTurno) values ('Guardia B',1);
insert into guardia (nombreGuardia,codTurno) values ('Guardia B',2);
insert into guardia (nombreGuardia,codTurno) values ('Guardia C',1);
insert into guardia (nombreGuardia,codTurno) values ('Guardia C',2);


