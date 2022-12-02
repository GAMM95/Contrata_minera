/* 
+
 * Database		:  ContrataMinera
 * Description	:  Base de Datos para la gestion administrativa
 * Author		:  Jhonatan Mantilla Miñano
 * Email		:  jhonatanmm.1995@gmail.com
 * Date			:  02-febrero-2022
 *
*/

use sys;
drop database if exists ContrataMinera;
create database ContrataMinera;
use ContrataMinera;

-- Counter table creation
create table contador (
 Tabla varchar (30) not null,
 Cantidad int not null,
 constraint PK_Contador primary key (Tabla)
);

-- Role table creation (user privileges)
create table rol(
 idRol int auto_increment not null,
 nombreRol varchar (30) not null,
 constraint pk_rol primary key (idRol)
);
insert into rol (nombreRol) values ('Administrador'),('Usuario'); -- Data dump for role table

-- Creacion de la tabla de usuarios 
create table usuario(
 idUsuario int auto_increment not null,
 username varchar (20) not null,
 password varchar (50) not null,
 nombre varchar (80) not null,
 email varchar (100) not null,
 lastSesion datetime null default '0000-00-00 00:00:00',
 idRol int not null,
 foto longblob,
 constraint pk_usuario primary key (idUsuario),
 constraint uq_usuario unique (username),
 constraint uq_nombre unique (nombre),
 constraint fk_usuario_rol foreign key (idRol)
 references rol (idRol)
 on delete restrict
 on update cascade
);

-- Procedimiento para registrar usuario
begin;
drop procedure if exists usp_registrar_usuario$$
delimiter $$
create procedure usp_registrar_usuario (
	in p_username varchar	(20), 
	in p_password varchar (50),
    in p_nombre	  varchar	(80),
    in p_email	  varchar	(100),
    in p_idRol  int,
    in p_foto   longblob
)
begin 
	INSERT INTO usuario(username, password, nombre, email, idRol, foto)
	VALUES(p_username,p_password,p_nombre,p_email, p_idRol, p_foto);
end$$
delimiter ;

-- Vista para listar usuarios registrados
create view listar_usuarios as
select username, nombre, email, lastSesion, nombreRol from usuario u
inner join rol r on r.idRol = u.idRol;

-- Creacion de la tabla empresa
create table empresa(
   codEmpresa int auto_increment not null,
   ruc char (11) not null,
   razonSocial varchar (60) not null,
   ciiu char (5) null,
   telefono char (9) null,
   celular char (9) null,
   direccionLegal varchar (80) null,
   email varchar (50) null,
   paginaWeb varchar (30) null,
   logo longblob null,
   ruta varchar (100) null,
   constraint pk_codEmpresa primary key (codEmpresa)
);

-- Data dump for company table
insert into empresa (ruc, razonSocial, ciiu, telefono, celular, direccionLegal, email, paginaWeb, logo, ruta)
values ('###########','########','#####','#########','#########','#################','#################','###########',
LOAD_FILE('F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg'),'F:\INGENIERÍA DE SISTEMAS\PROJECTS\Java Swing\Contrata_Minas\src\imagenes\openPit.jpg');

-- Creacion de la tabla cargo
create table cargo(
	codCargo	int  auto_increment not null,
	nombreCargo	varchar		(30)	not null,
	categoria	varchar		(10)	not null,
	constraint pk_cargo primary key (codCargo),
	constraint uq_nombreCargo unique (nombreCargo)
);

-- Procedimiento para registrar cargo
insert into contador values ('Cargos', 0); -- Data dump for counter table
begin;
drop procedure if exists usp_registrar_cargo$$
delimiter $$
create procedure usp_registrar_cargo (
	in p_nombreCargo 	varchar		(50),  
	in p_categoria 		varchar 	(50) 
)
begin 
	declare contador int; 
    declare exit handler for sqlexception, sqlwarning, not found
    begin
		rollback; -- Cancela la transacción
		resignal; -- Propaga el error    
	end;
	start transaction; -- Iniciar Transacción
    -- Actualizar la tabla contador
	update contador set Cantidad = Cantidad + 1
    where Tabla = 'Cargos';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Cargos';
    -- Insertar nuevo cargo
	INSERT INTO cargo(nombreCargo,categoria)
	VALUES(p_nombreCargo,p_categoria);
  commit;
end$$
delimiter ;

-- Procedimiento almacenado para consultar cargo
begin;
drop procedure if exists usp_consultar_cargo$$
delimiter $$
create procedure usp_consultar_cargo (
	in p_codigo int -- codigo del cargo
)
begin 
	-- Consultar cargo registrado
    select * from cargo 
    where codCargo = p_codigo;
end$$
delimiter ;

-- Procedimiento almacenado para actualizar cargos
begin;
drop procedure if exists usp_actualizar_cargo$$
delimiter $$
create procedure usp_actualizar_cargo (
	in p_nombreCargo	varchar(50),	-- nombre del cargo
    in p_categoria	varchar(50), -- categoria del cargo
    in p_codCargo int -- codigo del cargo
)
begin 
	-- Actualizar cargo registrado
	update cargo set 
    nombreCargo = p_nombreCargo,
    categoria = p_categoria	
	where codCargo = p_codCargo;
end$$
delimiter ;

-- Creacion de vistas para mostrar cargos
create view listar_cargos as
select codCargo, nombreCargo, categoria from cargo;

create view listar_cargos_dialog as
select codCargo, nombreCargo from cargo;

-- Worker table creation
create table trabajador(
  idTrabajador int auto_increment not null,
  dni char (8) not null,
  apePaterno varchar (15) not null,
  apeMaterno varchar (15) not null,
  nombres varchar (30) not null,
  sexo varchar (10) not null,
  estadoCivil varchar (15) not null,
  fechaNacimiento date not null,
  direccion varchar (50) not null,
  telefono char (9) not null,
  gradoInstruccion varchar (20) not null,
  profesion varchar (35) null,
  foto longblob null,
  ruta varchar(200) null,
  estado varchar (20) null default 'Activo',
  codCargo int not null,
  constraint pk_trabajador primary key (idTrabajador),
  constraint uq_dni unique (dni),
  constraint uq_telefono unique (telefono),
  constraint fk_cargo_trabajador foreign key (codCargo) references cargo(codCargo)
  on delete restrict
  on update cascade
);

-- Procedimiento para registrar trabajador
insert into contador values ('Trabajadores', 0); -- Data dump for counter table
begin;
drop procedure if exists usp_registrar_trabajador$$
delimiter $$
create procedure usp_registrar_trabajador (
	in p_dni char(8),  -- dni del trabajador
	in p_apePaterno	varchar(15), -- apellido Paterno del trabajador
    in p_apeMaterno	varchar(15), -- apellido Materno del trabajador
	in p_nombres varchar(50), -- nombres del trabajador
    in p_sexo varchar(10), -- genero del trabajador
	in p_estadoCivil varchar(15), -- estado civil del trabajador
	in p_fechaNacimiento date, -- fecha de nacimiento
	in p_direccion varchar(80), -- direccion domiciliaria
	in p_telefono char(9),  -- telefono del trabajador
	in p_instruccion varchar(30), -- grado de instruccion
	in p_profesion varchar(50), -- profesion
    in p_foto longblob,	  -- foto del trabajador
    in p_ruta varchar(200),	-- ruta de la foto del trabajador
	IN p_cargo int -- codigo del cargo del trabajador
)
begin 
	declare contador int; 
    declare exit handler for sqlexception, sqlwarning, not found
    begin
		rollback; -- Cancela la transacción
		resignal; -- Propaga el error    
	end;
	start transaction; -- Iniciar Transacción
    -- Actualizar la tabla contador
	update contador set Cantidad = Cantidad + 1
    where Tabla = 'Trabajadores';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Trabajadores';
    -- Insertar nuevo cargo
		INSERT INTO trabajador(dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil,fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, ruta, codCargo)
		VALUES(p_dni,p_apePaterno, p_apeMaterno, p_nombres, p_sexo, p_estadoCivil, p_fechaNacimiento, p_direccion, p_telefono, p_instruccion, p_profesion, p_foto, p_ruta, p_cargo);
  commit;
end$$
delimiter ;

-- Procedimiento almacenado para actualizar trabajador con foto
begin;
drop procedure if exists usp_actualizar_trabajadorConFoto$$
delimiter $$
create procedure usp_actualizar_trabajadorConFoto (
	in p_dni char(8),  -- dni del trabajador
	in p_apePaterno	varchar(15), -- apellido Paterno del trabajador
    in p_apeMaterno	varchar(15), -- apellido Materno del trabajador
	in p_nombres varchar(50), -- nombres del trabajador
    in p_sexo varchar(10), -- genero del trabajador
	in p_estadoCivil varchar(15), -- estado civil del trabajador
	in p_fechaNacimiento date, -- fecha de nacimiento
	in p_direccion varchar(80), -- direccion domiciliaria
	in p_telefono char(9),  -- telefono del trabajador
	in p_instruccion varchar(30), -- grado de instruccion
	in p_profesion varchar(50), -- profesion
    in p_foto longblob,	  -- foto del trabajador
    in p_ruta varchar(200), -- ruta de la foto del trabajador
    in p_codCargo int, --  codigo del cargo
    in p_idTrabajador int  -- id del trabajador
)
begin 
	-- Actualizar trabajador registrado
	update trabajador set 
		dni = p_dni, 
		apePaterno = p_apePaterno,
		apeMaterno = p_apeMaterno,	
		nombres = p_nombres,
		sexo = p_sexo,
		estadoCivil = p_estadoCivil,
		fechaNacimiento = p_fechaNacimiento,
		direccion = p_direccion,
		telefono = p_telefono,
		gradoInstruccion = p_instruccion,
		profesion = p_profesion,
		foto = p_foto,
        ruta = p_ruta,
		codCargo = p_codCargo
	where idtrabajador = p_idTrabajador;
END$$
DELIMITER ;

-- Procedimiento almacenado para actualizar trabajador sin foto
begin;
drop procedure if exists usp_actualizar_trabajadorSinFoto$$
delimiter $$
create procedure usp_actualizar_trabajadorSinFoto (
	in p_dni char(8),  -- dni del trabajador
	in p_apePaterno	varchar(15), -- apellido Paterno del trabajador
    in p_apeMaterno	varchar(15), -- apellido Materno del trabajador
	in p_nombres varchar(50), -- nombres del trabajador
    in p_sexo varchar(10), -- genero del trabajador
	in p_estadoCivil varchar(15), -- estado civil del trabajador
	in p_fechaNacimiento date, -- fecha de nacimiento
	in p_direccion varchar(80), -- direccion domiciliaria
	in p_telefono char(9),  -- telefono del trabajador
	in p_instruccion varchar(30), -- grado de instruccion
	in p_profesion varchar(50), -- profesion
    in p_codCargo int, --  codigo del cargo
    in p_idTrabajador int  -- id del trabajador
)
begin 
	-- Actualizar trabajador registrado
	update trabajador set 
		dni = p_dni, 
		apePaterno = p_apePaterno,
		apeMaterno = p_apeMaterno,	
		nombres = p_nombres,
		sexo = p_sexo,
		estadoCivil = p_estadoCivil,
		fechaNacimiento = p_fechaNacimiento,
		direccion = p_direccion,
		telefono = p_telefono,
		gradoInstruccion = p_instruccion,
		profesion = p_profesion,
		codCargo = p_codCargo
	where idtrabajador = p_idTrabajador;
END$$
DELIMITER ;

-- Creacion de vistas relacionadas al trabajador
create view listar_trabajador as
select idTrabajador, dni, concat(apePaterno,' ',apeMaterno,' ', nombres) as Trabajador, direccion, telefono, nombreCargo, estado from trabajador t 
inner join cargo c on c.codCargo = t.codCargo
order by idTrabajador desc;

-- Vista para el selector de trabajadores
create view listar_trabajador_dialog as
select idTrabajador,  concat(apePaterno,' ',apeMaterno,' ', nombres) as Trabajador from trabajador t 
order by idTrabajador desc;

create view listar_cargo_trabajador as
select  nombreCargo, categoria ,concat(apePaterno,' ', apeMaterno,' ',nombres) as Trabajador,  estado from cargo c 
inner join trabajador t on t.codCargo = c.codCargo;

--  Creacion de la tabla perfil Laboral
create table perfilLaboral(
	codPerfil int auto_increment not null,
	fechaIngreso date not null,
	area varchar (20) not null,		
	sueldo decimal (8,2) not null,
	fechaCese date null,	
	motivoCese varchar (60) null,
	idTrabajador int not null,	
	constraint pk_perfil primary key (codPerfil),
	constraint fk_trabajador_contrato foreign key (idTrabajador)
	references trabajador(idTrabajador)
	on delete restrict
	on update cascade
);

 -- Procedimiento para registrar perfiles laborales
 insert into contador Values ('Perfiles', 0); -- Data dump for counter table
begin;
drop procedure if exists usp_registrar_perfil$$
delimiter $$
create procedure usp_registrar_perfil (
    in p_fechaIngreso date, -- fecha de ingreso del trabajador
	in p_area varchar(20), 	-- area del trabajador
	in p_sueldo	decimal(8,2),  -- sueldo del trabajador
    in p_fechaCese date, -- fecha de cese de labores del trabajador
	in p_motivoCese	varchar(60), -- motivo de cese de labores del trabajador
	in p_idTrabajador int -- id del trabajador
)
begin 
	declare contador int;
    declare exit handler for sqlexception, sqlwarning, not found
    begin
		rollback;-- Cancela la transacción
		resignal;-- Propaga el error  
	end;
	start transaction;-- Iniciar Transacción
    -- Actualizar la tabla contador
	update contador
    set Cantidad  = Cantidad + 1
    where Tabla = 'Perfiles';
    select contador = Cantidad
	from contador where Tabla='Perfiles';
    -- Insertar nuevo contrato
	insert into perfilLaboral (fechaIngreso, area, sueldo, fechaCese, motivoCese, idTrabajador)
	values (p_fechaIngreso, p_area, p_sueldo, p_fechaCese, p_motivoCese, p_idTrabajador);
  commit;
end$$
delimiter ;

create view listar_perfil as
select codPerfil, concat(apePaterno, ' ', apeMaterno, ' ' , nombres) as Trabajador, fechaIngreso, area, fechaCese, motivoCese from perfilLaboral p 
inner join trabajador t on t.idTrabajador = p.idTrabajador
order by codPerfil asc;

-- Store procedure to show active contratcs 
begin;
drop procedure if exists usp_mostrar_contratosActivos$$
delimiter $$
create procedure usp_mostrar_contratosActivos()
begin
	select codPerfil, concat(apePaterno, ' ', apeMaterno, ' ' , nombres) as Trabajador, fechaIngreso, area,  fechaCese, motivoCese FROM perfilLaboral p 
	inner join trabajador t on t.idTrabajador = p.idTrabajador
    where fechaCese is null
	order by codPerfil;
end$$
delimiter ;

-- Creacion de la tabla de licencia de conducir
create table licencia(
  codLicencia int auto_increment not null,
  numLicencia char (9) not null,
  categoria varchar (5) not null,
  fechaEmision	date not null,				
  fechaCaducidad date not null,			
  idTrabajador int not null,			
  constraint pk_licencia primary key (codLicencia),
  constraint uq_licencia unique (numLicencia),
  constraint fk_trabajador_licencia foreign key (idTrabajador)
  references trabajador(idTrabajador)
  on delete restrict
  on update cascade
);

--  Procedimiento almacenado para registrar licencias de conducir
insert into contador Values ('Licencias', 0); -- Data dump for counter table
begin;
drop procedure if exists usp_registrar_licencia$$
DELIMITER $$
create procedure usp_registrar_licencia (
    in p_numLicencia char(9) , 	-- numero de licencia
	in p_categoria varchar(5),	-- categoria de la licencia
	in p_fechaEmision date,  -- sueldo del trabajador
    in p_fechaCaducidad	date, -- fecha de cese de labores del trabajador
	in p_idTrabajador int -- id del trabajador
)
begin 
	declare contador int;
	declare exit handler for sqlexception, sqlwarning, not found 
    begin
		rollback; -- Cancela la transacción
		resignal;-- Propaga el error   
	end;
	start transaction;-- Iniciar Transacción
    -- Actualizar la tabla contador
	update contador
    set Cantidad  = Cantidad + 1
    where Tabla = 'Licencias';
    select contador = Cantidad
	FROM contador WHERE Tabla='Licencias';
    -- Insertar nueva licencia
	insert into licencia (numLicencia, categoria, fechaEmision, fechaCaducidad, idTrabajador)
    values  (p_numLicencia, p_categoria, p_fechaEmision, p_fechaCaducidad, p_idTrabajador);
    commit;
end$$
DELIMITER ;

-- view para listar licencias
create view listar_licencia as
select codLicencia, concat(apePaterno, ' ', apeMaterno, ' ' , nombres) as Trabajador, numLicencia, categoria, fechaEmision, fechaCaducidad from licencia l 
inner join trabajador t on t.idTrabajador = l.idTrabajador
order by codLicencia desc;

-- Creacion de la tabla tipos de vehiculos
create table tipoVehiculo(
	codTipo	int  auto_increment not null,
	nombreTipo	varchar	(20) not null,
	constraint pk_tipo primary key (codTipo),
	constraint uq_nombreTipo unique (nombreTipo)
);

--  Procedimiento almacenado para registrar licencias de conducir
insert into contador Values ('Tipos de vehiculo', 0); -- Data dump for counter table
begin;
drop procedure if exists usp_registrar_tipoVehiculo$$
DELIMITER $$
create procedure usp_registrar_tipoVehiculo (
    in p_nombreTipo varchar(20)	-- nombre del tipo de vehiculo
)
begin 
	declare contador int;
	declare exit handler for sqlexception, sqlwarning, not found 
    begin
		rollback; -- Cancela la transacción
		resignal;-- Propaga el error   
	end;
	start transaction;-- Iniciar Transacción
    -- Actualizar la tabla contador
	update contador
    set Cantidad  = Cantidad + 1
    where Tabla = 'Tipos de vehiculo';
    select contador = Cantidad
	FROM contador WHERE Tabla='Tipos de vehiculo';
    -- Insertar nuevo tipo de vehiculo
	insert into tipoVehiculo (nombreTipo)
    values  (p_nombreTipo);
    commit;
end$$
delimiter ;

-- view para listar tipos de vehiculo
create view listar_tipoVehiculo as
select codTipo, nombreTipo from tipoVehiculo 
order by codTipo asc;

-- Vehicle table creation
create table vehiculo(
  codVehiculo int auto_increment not null,
  idVehiculo varchar(5)	not null,
  placa	varchar(7) not null,
  modelo varchar(15) not null,
  marca varchar(15) not null,
  fechaCompra date not null,
  año char(4) null,
  codTipo int not null,
	constraint pk_vehiculo primary key (codVehiculo),
    constraint uq_idVehiculo unique (idVehiculo),
	constraint uq_placa unique (placa),
	constraint fk_tipoVehiculo_vehiculo foreign key (codTipo)
	references tipoVehiculo(codTipo)
	on delete restrict
	on update cascade
);

create view listar_vehiculos as
select codVehiculo, idVehiculo,nombreTipo, placa, modelo, marca, fechaCompra from vehiculo v 
inner join tipoVehiculo tv on tv.codTipo = v.codTipo
order by codVehiculo asc;

## -------------------------------------------------------------------------------------------------------------------- ##
## PROCEDIMIENTOS ALMACENADOS ##


## Procedimiento para cambiar de contraseña
BEGIN;
DROP PROCEDURE IF EXISTS usp_cambiarPass$$
DELIMITER $$
CREATE PROCEDURE usp_cambiarPass (
	IN p_username VARCHAR(20),  
    IN p_password VARCHAR(50)
)
BEGIN 
	-- Actualizar cargo registrado
	UPDATE usuario SET password = p_password
	WHERE username = p_username;
END$$
DELIMITER ;

## Procedimiento para actualizar cuenta del usuario
begin;
drop procedure if exists usp_actualizar_cuenta$$
delimiter $$
create procedure usp_actualizar_cuenta (
	in p_username 	varchar	(20),
    in p_password	varchar	(50), 
	in p_nombre 	varchar (80), 
    in p_email 		varchar	(100)
)
begin 
	-- Actualizar cuenta de usuario
	UPDATE usuario SET password = p_password, p_nombre = p_nombre, email = p_email
	WHERE username = p_username;
end$$
delimiter ;


begin;
delimiter $$
create procedure usp_registrarEmpresa(
	p_ruc			char	(11),
    p_razonSocial 	varchar (60),
    p_ciiu			char(5),
    p_telefono		char(9),
    p_celular		char(9),
    p_direccionLegal 	varchar(80),
    p_email			varchar(50),
    p_paginaWeb		varchar(30),
    p_logo			longblob
)
begin 
	insert into empresa (ruc, razonSocial, ciiu, telefono, celular, direccionLegal, email, paginaWeb, logo)
    values (p_ruc, p_razonSocial, p_ciiu, p_telefono, p_celular, p_direccionLegal, p_email, p_paginaWeb, p_logo);
end$$
delimiter ;