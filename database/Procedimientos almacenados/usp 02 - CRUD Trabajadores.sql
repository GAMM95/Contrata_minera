use CorpPiscis;

-- VERIFICACION FINAL 
SELECT * FROM CorpPiscis.trabajador;
SELECT * FROM CorpPiscis.contador;
select * from corppiscis.cargo;

-- NUEVO REGISTRO DE DATOS
	DROP PROCEDURE usp_registrar_trabajador;
    DROP PROCEDURE usp_consultar_trabajador;
    DROP PROCEDURE usp_actualizar_trabajador; 
    DROP PROCEDURE usp_eliminar_cargo;
	DELETE FROM CorpPiscis.trabajador;
	DELETE FROM CorpPiscis.contador WHERE Tabla = 'Trabajadores';
	INSERT INTO CorpPiscis.contador Values ('Trabajadores', 0, 3 );

--------------------------------------------------------------------------------------
-- PROCEDIMIENTO ALMACENADO PARA MOSTRAR TRABAJADORES
DROP PROCEDURE IF EXISTS usp_mostrar_trabajadores$$
delimiter $$
create procedure usp_mostrar_trabajadores()
begin
	SELECT idTrabajador, dni, CONCAT(apellidos, ' ', nombres) as Trabajador,
	telefono, nombre , categoria FROM trabajador t 
	inner join cargo c on c.codCargo = t.codCargo
	order by idTrabajador;
end $$
delimiter ;
call usp_mostrar_trabajadores;

-- PROCEDIMIENTO ALMACENADO PARA REGISTRAR CARGOS
BEGIN;
DROP PROCEDURE IF EXISTS usp_registrar_trabajador$$
DELIMITER $$
CREATE PROCEDURE usp_registrar_trabajador (
    IN p_dni 			CHAR	(8),  -- dni del trabajador
	IN p_apellidos 		VARCHAR	(50), -- apellidos del trabajador
	IN p_nombres		VARCHAR (50), -- nombres del trabajador
    IN p_sexo			VARCHAR	(10), -- genero del trabajador
	IN p_estadoCivil	VARCHAR	(15), -- estado civil del trabajador
	IN p_fechaNacimiento		DATE, -- fecha de nacimiento
	IN p_departamento	VARCHAR	(50), -- region 
	IN p_provincia		VARCHAR	(50), -- provincia
	IN p_distrito		VARCHAR	(50), -- distrito
	IN p_direccion		VARCHAR	(80), -- direccion domiciliaria
	IN p_telefono		CHAR	(9),  -- telefono del trabajador
	IN p_instruccion	VARCHAR (30), -- grado de instruccion
	IN p_profesion		VARCHAR	(50), -- profesion
	IN p_cargo			INT			  -- codigo del cargo del trabajador
)
BEGIN 
	declare contador int;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback;
		-- Propaga el error    
    RESIGNAL;
	END;
	-- Iniciar Transacción
	start transaction;
    -- Actualizar la tabla contador
	update contador
    set Cantidad  = Cantidad + 1
    where Tabla = 'Trabajadores';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Trabajadores';
    -- Insertar nuevo trabajador
	INSERT INTO trabajador
    (dni,apellidos,nombres, sexo, estadoCivil,fechaNacimiento, departamento, provincia, distrito, direccion, telefono, gradoInstruccion, profesion, codCargo)
	VALUES(p_dni,p_apellidos, p_nombres, p_sexo, p_estadoCivil, p_fechaNacimiento, p_departamento, p_provincia, p_distrito, p_direccion, p_telefono, p_instruccion, p_profesion, p_cargo);
  COMMIT;
END$$
DELIMITER ;

call usp_registrar_trabajador 
('70555743','Mantilla Miñano','Jhonatan','Masculino','Soltero','1995-03-19','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','950212908','Universitario','Bach. ingenieria de minas','1');
call usp_registrar_trabajador 
('70555740','Mantilla Miñano','Gustavo','Masculino','Soltero','1998-02-23','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','987654321','Universitario','Bach. ingenieria de minas','2');
call usp_mostrar_trabajadores;
--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA CONSULTAR CARGO
BEGIN;
DROP PROCEDURE IF EXISTS usp_consultar_trabajador$$
DELIMITER $$
CREATE PROCEDURE usp_consultar_trabajador (
	IN p_codigo int -- codigo del trabajador
)
BEGIN 
	-- Consultar trabajador registrado
    SELECT * FROM trabajador 
	WHERE idTrabajador = p_codigo;
  COMMIT;
END$$
DELIMITER ;
call usp_consultar_trabajador ('1');
call usp_consultar_trabajador ('2');

--------------------------------------------------------------------------------------
 -- PROCEDIMIENTO ALMACENADO PARA BUSCAR TRABAJADOR POR DNI
begin;
drop procedure if exists usp_buscar_trabajadorDNI$$
delimiter $$
create procedure usp_buscar_trabajadorDNI(
	IN p_dni 			CHAR	(8)
)
begin
	-- Buscar trabajador por dni
    select * from trabajador
    where dni = p_dni +'%';
end$$
delimiter ;
call usp_buscar_trabajadorDNI ('70555743');
call usp_buscar_trabajadorDNI ('70555740');
--------------------------------------------------------------------------------------
-- PROCEDIMIENTO ALMACENADO PARA BUSCAR TRABAJADOR POR APELLIDOS
begin;
drop procedure if exists usp_buscar_trabajadorApellido$$
delimiter $$
create procedure usp_buscar_trabajadorApellido (
	IN p_apellidos 		VARCHAR	(50) -- apellidos del trabajador
)
begin 
	-- Buscar trabajador por apellidos
    select * from trabajador
    where apellidos = p_apellidos;
end$$
delimiter ;
call usp_buscar_trabajadorApellido('M');

--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR CARGO
begin;
DROP PROCEDURE IF EXISTS usp_actualizar_trabajador$$
DELIMITER $$
CREATE PROCEDURE usp_actualizar_trabajador (
	IN p_dni 			CHAR	(8),  -- dni del trabajador
	IN p_apellidos 		VARCHAR	(50), -- apellidos del trabajador
	IN p_nombres		VARCHAR (50), -- nombres del trabajador
    IN p_sexo			VARCHAR	(10), -- genero del trabajador
	IN p_estadoCivil	VARCHAR	(15), -- estado civil del trabajador
	IN p_fechaNacimiento		DATE, -- fecha de nacimiento
	IN p_departamento	VARCHAR	(50), -- region 
	IN p_provincia		VARCHAR	(50), -- provincia
	IN p_distrito		VARCHAR	(50), -- distrito
	IN p_direccion		VARCHAR	(80), -- direccion domiciliaria
	IN p_telefono		CHAR	(9),  -- telefono del trabajador
	IN p_instruccion	VARCHAR (30), -- grado de instruccion
	IN p_profesion		VARCHAR	(50), -- profesion
    IN p_codCargo			INT, --  codigo del cargo
    IN p_codigo 		INT 	  -- id del trabajador
)
BEGIN 
	-- Actualizar cargo registrado
	UPDATE trabajador SET 
		dni = p_dni, 
		apellidos = p_apellidos, 
        nombres = p_nombres, 
        sexo = p_sexo,
        estadoCivil = p_estadoCivil, 
        fechaNacimiento = p_fechaNacimiento, 
        departamento = p_departamento,
		provincia = p_provincia, 
        distrito = p_distrito, 
        direccion = p_direccion, 
        telefono = p_telefono,
		gradoInstruccion = p_instruccion, 
        profesion = p_profesion,
        codCargo = p_codCargo
	WHERE idtrabajador = p_codigo;
END$$
DELIMITER ;
use corppiscis;
drop procedure usp_actualizar_trabajador;
call usp_actualizar_trabajador 
('70555740','Mantilla Miñano','Gustavo','Masculino','Soltero','1998-02-23','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','987654321','Universitario','Bach. ingenieria industrial','2');
call usp_mostrar_trabajadores;
--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA ELIMINAR CARGO
DROP PROCEDURE IF EXISTS usp_eliminar_trabajador$$
DELIMITER $$
CREATE PROCEDURE usp_eliminar_trabajador (
	IN p_codigo		INT  -- codigo del trabajador
)
BEGIN 
	declare contador int;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback;
		-- Propaga el error    
    RESIGNAL;
	END;
	-- Iniciar Transacción
	start transaction;
    -- Actualizar la tabla contador
	update contador
    set Cantidad  = Cantidad - 1
    where Tabla = 'Trabajadores';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Trabajadores';
    -- Eliminar trabajador registrado
	DELETE FROM trabajador where idTrabajador = p_codigo;
  COMMIT;
END$$
DELIMITER ;

call usp_eliminar_cargo ('002');

--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA FILTRAR TRABAJADOR POR CATEGORIA
DROP PROCEDURE IF EXISTS usp_filtrarTrabajadorCategoria$$
DELIMITER $$
CREATE PROCEDURE usp_filtrarTrabajadorCategoria (
	IN p_categoria VARCHAR(50)  -- categoria del trabajador
)
BEGIN 
	-- Consultar cargo registrado
     SELECT idTrabajador, dni, CONCAT(apellidos, ' ', nombres) as Trabajador,
	 telefono, nombre , categoria FROM trabajador t 
	 inner join cargo c on c.codCargo = t.codCargo
     where categoria = p_categoria
     order by idTrabajador;
END$$
DELIMITER ;

call usp_filtrarTrabajadorCategoria('Empleado');
select count(*) from trabajador;
begin;
DROP PROCEDURE IF EXISTS usp_contarTrabajadorCategoria$$
DELIMITER $$
CREATE PROCEDURE usp_contarTrabajadorCategoria (
	IN p_categoria VARCHAR(50)  -- categoria del trabajador
)
BEGIN
	SELECT count(*) as Cantidad FROM trabajador t 
	inner join cargo c on c.codCargo = t.codCargo
	where categoria = p_categoria;
END$$
DELIMITER ;
call usp_contarTrabajadorCategoria ('Empleado');
-----------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA FILTRAR TRABAJADOR POR CARGO
begin;
DROP PROCEDURE IF EXISTS usp_filtrarTrabajadorCargo$$
DELIMITER $$
CREATE PROCEDURE usp_filtrarTrabajadorCargo (
	IN p_cargo VARCHAR(50)  -- cargo del trabajador
)
BEGIN 
	-- Consultar cargo registrado
     SELECT idTrabajador, dni, CONCAT(apellidos, ' ', nombres) as Trabajador,
	 telefono, nombre , categoria FROM trabajador t 
	 inner join cargo c on c.codCargo = t.codCargo
     where nombre = p_cargo
     order by idTrabajador;
END$$
DELIMITER ;

call usp_filtrarTrabajadorCargo('Supervisor de operaciones');

begin;
DROP PROCEDURE IF EXISTS usp_contarTrabajadorCargo$$
DELIMITER $$
CREATE PROCEDURE usp_contarTrabajadorCargo (
	IN p_cargo VARCHAR(50)  -- categoria del trabajador
)
BEGIN
	SELECT count(*) as Cantidad FROM trabajador t 
	inner join cargo c on c.codCargo = t.codCargo
	where nombre = p_cargo;
END$$
DELIMITER ;
call usp_contarTrabajadorCargo ('Supervisor de operaciones');