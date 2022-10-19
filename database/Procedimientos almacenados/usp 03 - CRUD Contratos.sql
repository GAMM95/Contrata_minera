use CorpPiscis;

-- VERIFICACION FINAL 
SELECT * FROM CorpPiscis.contrato;
SELECT * FROM CorpPiscis.contador;

-- NUEVO REGISTRO DE DATOS
	DROP PROCEDURE usp_registrar_trabajador;
    DROP PROCEDURE usp_consultar_trabajador;
    DROP PROCEDURE usp_actualizar_trabajador; 
    DROP PROCEDURE usp_eliminar_cargo;
	DELETE FROM CorpPiscis.trabajador;
	DELETE FROM CorpPiscis.contador WHERE Tabla = 'Contratos';
	INSERT INTO CorpPiscis.contador Values ('Contratos', 0);

--------------------------------------------------------------------------------------
-- PROCEDIMIENTO ALMACENADO PARA MOSTRAR CONTRATOS
DROP PROCEDURE IF EXISTS usp_mostrar_contratos$$
delimiter $$
create procedure usp_mostrar_contratos()
begin
	SELECT c.codContrato, fechaIngreso, area, CONCAT(apellidos, ' ', nombres) as Trabajador, nombre, fechaCese,
	motivoCese FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
	order by c.codContrato;
end $$
delimiter ;
call usp_mostrar_contratos;

-- PROCEDIMIENTO ALMACENADO PARA REGISTRAR CONTRATOS
BEGIN;
DROP PROCEDURE IF EXISTS usp_registrar_contrato$$
DELIMITER $$
CREATE PROCEDURE usp_registrar_contrato (
    IN p_fechaIngreso 	DATE , 			-- fecha de ingreso del trabajador
	IN p_area			VARCHAR	(20), 	-- area del trabajador
	IN p_sueldo			DECIMAL (8,2),  -- sueldo del trabajador
    IN p_fechaCese		DATE,	 		-- fecha de cese de labores del trabajador
	IN p_motivoCese		VARCHAR	(60), 	-- motivo de cese de labores del trabajador
	IN p_idTrabajador	INT			  	-- id del trabajador
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
    where Tabla = 'Contratos';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Contratos';
    -- Insertar nuevo contrato
	INSERT INTO contrato
    (fechaIngreso, area, sueldo, fechaCese, motivoCese, idTrabajador)
	VALUES(p_fechaIngreso,p_area, p_sueldo, p_fechaCese, p_motivoCese, p_idTrabajador);
  COMMIT;
END$$
DELIMITER ;

call usp_registrar_trabajador 
('70555743','Mantilla Miñano','Jhonatan','Masculino','Soltero','1995-03-19','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','950212908','Universitario','Bach. ingenieria de minas','1');
call usp_registrar_trabajador 
('70555740','Mantilla Miñano','Gustavo','Masculino','Soltero','1998-02-23','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','987654321','Universitario','Bach. ingenieria de minas','2');
call usp_mostrar_contratos;
--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA CONSULTAR CONTRATO
BEGIN;
DROP PROCEDURE IF EXISTS usp_consultar_contrato$$
DELIMITER $$
CREATE PROCEDURE usp_consultar_contrato (
	IN p_codigo int -- codigo del trabajador
)
BEGIN 
	-- Consultar trabajador registrado
    SELECT * FROM contrato 
	WHERE codContrato = p_codigo;
  COMMIT;
END$$
DELIMITER ;
call usp_consultar_contrato ('1');
call usp_consultar_trabajador ('2');
--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR CONTRATO
begin;
DROP PROCEDURE IF EXISTS usp_actualizar_contrato$$
DELIMITER $$
CREATE PROCEDURE usp_actualizar_contrato (
	IN p_fechaIngreso 	DATE , 			-- fecha de ingreso del trabajador
	IN p_area			VARCHAR	(20), 	-- area del trabajador
	IN p_sueldo			DECIMAL (8,2),  -- sueldo del trabajador
    IN p_fechaCese		DATE,	 		-- fecha de cese de labores del trabajador
	IN p_motivoCese		VARCHAR	(60), 	-- motivo de cese de labores del trabajador
	IN p_idTrabajador	INT		,	  	-- id del trabajador
    IN p_codigo			INT
)
BEGIN 
	-- Actualizar contrato registrado
	UPDATE contrato SET 
		fechaIngreso = p_fechaIngreso, 
		area = p_area, 
        sueldo = p_sueldo, 
        fechaCese = p_fechaCese,
        motivoCese = p_motivoCese, 
        idTrabajador = p_idTrabajador
	WHERE codContrato = p_codigo;
END$$
DELIMITER ;
use corppiscis;

call usp_actualizar_contrato 
('70555740','Mantilla Miñano','Gustavo','Masculino','Soltero','1998-02-23','La Libertad','Trujillo','La Esperanza','Urb. Manuel Arevalo','987654321','Universitario','Bach. ingenieria industrial','2');
call usp_mostrar_trabajadores;
--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA ELIMINAR CONTRATO
BEGIN;
DROP PROCEDURE IF EXISTS usp_eliminar_contrato$$
DELIMITER $$
CREATE PROCEDURE usp_eliminar_contrato (
	IN p_codigo		INT  -- codigo del contrato
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
    where Tabla = 'Contratos';
    SELECT contador = Cantidad
	FROM contador WHERE Tabla='Contratos';
    -- Eliminar contrato registrado
	DELETE FROM contrato where codContrato = p_codigo;
  COMMIT;
END$$
DELIMITER ;

call usp_eliminar_cargo ('002');

--------------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA FILTRAR CONTRATOS POR AREA
BEGIN;
DROP PROCEDURE IF EXISTS usp_filtrarContratoArea$$
DELIMITER $$
CREATE PROCEDURE usp_filtrarContratoArea (
	IN p_area VARCHAR(20)  -- categoria del trabajador
)
BEGIN 
	-- Consultar cargo registrado
     SELECT c.codContrato, fechaIngreso, area, CONCAT(apellidos, ' ', nombres) as Trabajador, nombre, fechaCese,
	motivoCese FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
     where area = p_area
     order by  c.codContrato;
END$$
DELIMITER ;
call usp_filtrarContratoArea('Operaciones mina');
select count(*) from trabajador;

-- PROCEDIMIENTO ALMACENADO PARA CONTAR LOS CONTRATOS POR AREA
begin;
DROP PROCEDURE IF EXISTS usp_contarContratoArea$$
DELIMITER $$
CREATE PROCEDURE usp_contarContratoArea (
	IN p_area VARCHAR(20)  -- categoria del trabajador
)
BEGIN
	SELECT count(*) as Cantidad FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
	where area = p_area;
END$$
DELIMITER ;
call usp_contarContratoArea ('Operaciones mina');
-----------------------------------------------------------------------------------

-- PROCEDIMIENTO ALMACENADO PARA FILTRAR CONTRATO POR CARGO
begin;
DROP PROCEDURE IF EXISTS usp_filtrarContratoCargo$$
DELIMITER $$
CREATE PROCEDURE usp_filtrarContratoCargo (
	IN p_cargo VARCHAR(50)  -- cargo del trabajador
)
BEGIN 
	-- Consultar contrato registrado
    SELECT c.codContrato, fechaIngreso, area, CONCAT(apellidos, ' ', nombres) as Trabajador, nombre, fechaCese,
	motivoCese FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
    where nombre = p_cargo
	order by c.codContrato;
END$$
DELIMITER ;
call usp_filtrarContratoCargo('Supervisor de seguridad');

-- PROCEDIMIENTO ALMACENADO PARA CONTAR CONTRATOS POR CARGO
begin;
DROP PROCEDURE IF EXISTS usp_contarContratoCargo$$
DELIMITER $$
CREATE PROCEDURE usp_contarContratoCargo (
	IN p_cargo VARCHAR(50)  -- categoria del trabajador
)
BEGIN
	SELECT count(*) as Cantidad FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
    where nombre = p_cargo;
END$$
DELIMITER ;
call usp_contarContratoCargo ('Supervisor de seguridad');

-- PROCEDIMIENTO ALMACENADO PARA MOSTRAR CONTRATOS DE TRABAJADORES CESADOS
DROP PROCEDURE IF EXISTS usp_mostrar_contratosCesados$$
delimiter $$
create procedure usp_mostrar_contratosCesados()
begin
	SELECT c.codContrato, fechaIngreso, area, CONCAT(apellidos, ' ', nombres) as Trabajador, nombre, fechaCese,
	motivoCese FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
    where fechaCese is not null
	order by c.codContrato;
end $$
delimiter ;
call usp_mostrar_contratosCesados;

-- PROCEDIMIENTO ALMACENADO PARA CONTAR CONTRATOS DE TRABAJADORES CESADOS
begin;
drop procedure if exists usp_contar_contratosCesados$$
delimiter $$
create procedure usp_contar_contratosCesados()
begin
	select count(*) as Cantidad from contrato 
	where fechaCese is not null;
end $$
delimiter ;
call usp_contar_contratosCesados;

-- PROCEDIMIENTO ALMACENADO PARA MOSTRAR CONTRATOS DE TRABAJADORES ACTIVOS
DROP PROCEDURE IF EXISTS usp_mostrar_contratosActivos$$
delimiter $$
create procedure usp_mostrar_contratosActivos()
begin
	SELECT c.codContrato, fechaIngreso, area, CONCAT(apellidos, ' ', nombres) as Trabajador, nombre, fechaCese,
	motivoCese FROM contrato c 
	inner join trabajador t on t.idTrabajador = c.idTrabajador
    inner join cargo car on car.codCargo = t.codCargo
    where fechaCese is null
	order by c.codContrato;
end $$
delimiter ;
call usp_mostrar_contratosActivos;

-- PROCEDIMIENTO ALMACENADO PARA CONTAR CONTRATOS DE TRABAJADORES ACTIVOS
begin;
drop procedure if exists usp_contar_contratosActivos$$
delimiter $$
create procedure usp_contar_contratosActivos()
begin
	select count(*) as Cantidad from contrato 
	where fechaCese is null;
end $$
delimiter ;
call usp_contar_contratosActivos;

