use CorpPiscis;
-- VERIFICACION FINAL 
SELECT * FROM CorpPiscis.cargo;
SELECT * FROM CorpPiscis.contador;

-- NUEVO REGISTRO DE DATOS
	DROP PROCEDURE usp_registrar_cargo;
	DELETE FROM CorpPiscis.cargo;
	DELETE FROM CorpPiscis.contador WHERE Tabla = 'Cargos';
	INSERT INTO CorpPiscis.contador Values ('Cargos', 0);

-- PROCEDIMIENTO ALMACENADO PARA LISTAR CARGOS
BEGIN;
DROP PROCEDURE IF EXISTS usp_listar_cargo$$
DELIMITER $$
CREATE PROCEDURE usp_listar_cargo ()
BEGIN
	-- Mostrar cargos
    SELECT * FROM cargo;
END$$
DELIMITER ;

-- VISTA PARA LISTAR CARGOS
create view listar_cargos
as
	 SELECT nombre, categoria FROM cargo;
select * from listar_cargos;

-- PROCEDIMIENTO ALMACENADO PARA REGISTRAR CARGOS
BEGIN;
DROP PROCEDURE IF EXISTS usp_registrar_cargo$$
DELIMITER $$
CREATE PROCEDURE usp_registrar_cargo (
	IN p_nombre VARCHAR(50),  -- nombre del cargo
	IN p_categoria VARCHAR (50)  -- categoria del cargo
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
    where Tabla = 'Cargos';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Cargos';
    -- Insertar nuevo cargo
	INSERT INTO cargo(nombre,categoria)
	VALUES(p_nombre,p_categoria);
  COMMIT;
END$$
DELIMITER ;
call usp_registrar_cargo ('Asistente administrativo','Empleado');
call usp_listar_cargo;

-- PROCEDIMIENTO ALMACENADO PARA CONSULTAR CARGO
BEGIN;
DROP PROCEDURE IF EXISTS usp_consultar_cargo$$
DELIMITER $$
CREATE PROCEDURE usp_consultar_cargo (
	IN p_codigo INT  -- codigo del cargo
)
BEGIN 
	-- Consultar cargo registrado
    SELECT * FROM cargo 
	WHERE codCargo = p_codigo;
END$$
DELIMITER ;
call usp_consultar_cargo ('1');
call usp_consultar_cargo ('002');

-- PROCEDIMIENTO ALMACENADO PARA CONSULTAR CARGO POR NOMBRE
BEGIN;
DROP PROCEDURE IF EXISTS usp_buscar_cargoNombre$$
DELIMITER $$
create procedure usp_buscar_cargoNombre(
	in p_nombre varchar(50)		-- nombre de cargo
)
begin	
	-- consultar cargo por nombre
    select * from cargo 
    where nombre = p_nombre;
end$$
delimiter ;
call usp_buscar_cargoNombre ('Asistente');

-- PROCEDIMIENTO ALMACENADO PARA CONSULTAR CARGO POR CATEGORIA
BEGIN;
DROP PROCEDURE IF EXISTS usp_buscar_cargoCategoria$$
DELIMITER $$
create procedure usp_buscar_cargoCategoria(
	IN p_categoria VARCHAR (50)  -- categoria del cargo
)
begin	
	-- consultar cargo por categoria
    select * from cargo 
    where categoria = p_categoria;
end$$
delimiter ;

call usp_buscar_cargoCategoria ('Obrero');

-- PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR CARGO
BEGIN;
DROP PROCEDURE IF EXISTS usp_actualizar_cargo$$
DELIMITER $$
CREATE PROCEDURE usp_actualizar_cargo (
    
	IN p_nombre VARCHAR(50),  -- nombre del cargo
	IN p_categoria VARCHAR (50),  -- categoria del cargo
    IN p_codigo INT  -- codigo del cargo
)
BEGIN 
	-- Actualizar cargo registrado
	UPDATE cargo SET nombre = p_nombre, categoria = p_categoria
	WHERE codCargo = p_codigo;
  COMMIT;
END$$
DELIMITER ;
drop procedure usp_actualizar_cargo;
call usp_actualizar_cargo ('Administradora','Empleado','4');
call usp_listar_cargo;

-- PROCEDIMIENTO ALMACENADO PARA ELIMINAR CARGO
BEGIN;
DROP PROCEDURE IF EXISTS usp_eliminar_cargo$$
DELIMITER $$
CREATE PROCEDURE usp_eliminar_cargo (
	IN p_codigo INT  -- codigo del cargo
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
    where Tabla = 'Cargos';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Cargos';
    -- Eliminar cargo registrado
	DELETE FROM cargo where codCargo = p_codigo;
  COMMIT;
END$$
DELIMITER ;

call usp_eliminar_cargo ('5');
call usp_listar_cargo;
select * from contador;

-- PROCEDIMIENTO ALMACENADO PARA VALIDAR EXISTENCIA DE NOMBRE DE CARGO
begin;
DROP PROCEDURE IF EXISTS usp_existeNombreCargo$$
DELIMITER $$
CREATE PROCEDURE usp_existeNombreCargo (
	IN p_nombre VARCHAR(50)  -- nombre del cargo
)
BEGIN 
	-- Consultar cargo registrado
    SELECT count(nombre) FROM Cargo WHERE nombre = p_nombre;
END$$
DELIMITER ;
