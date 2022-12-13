-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: contrataminera
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `codCargo` int NOT NULL AUTO_INCREMENT,
  `nombreCargo` varchar(30) NOT NULL,
  `categoria` varchar(10) NOT NULL,
  PRIMARY KEY (`codCargo`),
  UNIQUE KEY `uq_nombreCargo` (`nombreCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Supervisor de operaciones','Empleado'),(2,'Supervisor de seguridad','Empleado'),(3,'Asistente de operaciones','Empleado'),(4,'Asistente de seguridad','Empleado'),(5,'Asistente administrativo','Empleado'),(6,'Operador','Obrero'),(7,'Mecánico','Obrero'),(8,'Llantero','Obrero'),(9,'Conductor de combi','Obrero');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contador`
--

DROP TABLE IF EXISTS `contador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contador` (
  `Tabla` varchar(30) NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Tabla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contador`
--

LOCK TABLES `contador` WRITE;
/*!40000 ALTER TABLE `contador` DISABLE KEYS */;
INSERT INTO `contador` VALUES ('Cargos',9),('Guardias',0),('Licencias',0),('Perfiles',0),('Tipos de vehiculo',0),('Trabajadores',0),('Vales',0),('Vehiculos',0);
/*!40000 ALTER TABLE `contador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `codEmpresa` int NOT NULL AUTO_INCREMENT,
  `ruc` char(11) NOT NULL,
  `razonSocial` varchar(60) NOT NULL,
  `ciiu` char(5) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  `direccionLegal` varchar(80) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `paginaWeb` varchar(30) DEFAULT NULL,
  `logo` longblob,
  `ruta` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardia`
--

DROP TABLE IF EXISTS `guardia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guardia` (
  `codGuardia` int NOT NULL AUTO_INCREMENT,
  `nombreGuardia` varchar(15) NOT NULL,
  `codTurno` int NOT NULL,
  PRIMARY KEY (`codGuardia`),
  KEY `fk_guardia_turno` (`codTurno`),
  CONSTRAINT `fk_guardia_turno` FOREIGN KEY (`codTurno`) REFERENCES `turno` (`codTurno`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardia`
--

LOCK TABLES `guardia` WRITE;
/*!40000 ALTER TABLE `guardia` DISABLE KEYS */;
/*!40000 ALTER TABLE `guardia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licencia`
--

DROP TABLE IF EXISTS `licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `licencia` (
  `codLicencia` int NOT NULL AUTO_INCREMENT,
  `numLicencia` char(9) NOT NULL,
  `categoria` varchar(5) NOT NULL,
  `fechaEmision` date NOT NULL,
  `fechaCaducidad` date NOT NULL,
  `idTrabajador` int NOT NULL,
  PRIMARY KEY (`codLicencia`),
  UNIQUE KEY `uq_licencia` (`numLicencia`),
  KEY `fk_trabajador_licencia` (`idTrabajador`),
  CONSTRAINT `fk_trabajador_licencia` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licencia`
--

LOCK TABLES `licencia` WRITE;
/*!40000 ALTER TABLE `licencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfillaboral`
--

DROP TABLE IF EXISTS `perfillaboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfillaboral` (
  `codPerfil` int NOT NULL AUTO_INCREMENT,
  `fechaIngreso` date NOT NULL,
  `area` varchar(20) NOT NULL,
  `sueldo` decimal(8,2) NOT NULL,
  `fechaCese` date DEFAULT NULL,
  `motivoCese` varchar(60) DEFAULT NULL,
  `idTrabajador` int NOT NULL,
  PRIMARY KEY (`codPerfil`),
  KEY `fk_trabajador_contrato` (`idTrabajador`),
  CONSTRAINT `fk_trabajador_contrato` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfillaboral`
--

LOCK TABLES `perfillaboral` WRITE;
/*!40000 ALTER TABLE `perfillaboral` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfillaboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(30) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipovehiculo`
--

DROP TABLE IF EXISTS `tipovehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipovehiculo` (
  `codTipo` int NOT NULL AUTO_INCREMENT,
  `nombreTipo` varchar(20) NOT NULL,
  PRIMARY KEY (`codTipo`),
  UNIQUE KEY `uq_nombreTipo` (`nombreTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipovehiculo`
--

LOCK TABLES `tipovehiculo` WRITE;
/*!40000 ALTER TABLE `tipovehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipovehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `idTrabajador` int NOT NULL AUTO_INCREMENT,
  `dni` char(8) NOT NULL,
  `apePaterno` varchar(15) NOT NULL,
  `apeMaterno` varchar(15) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estadoCivil` varchar(15) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` char(9) NOT NULL,
  `gradoInstruccion` varchar(20) NOT NULL,
  `profesion` varchar(35) DEFAULT NULL,
  `foto` longblob,
  `ruta` varchar(200) DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'Activo',
  `codCargo` int NOT NULL,
  PRIMARY KEY (`idTrabajador`),
  UNIQUE KEY `uq_dni` (`dni`),
  UNIQUE KEY `uq_telefono` (`telefono`),
  KEY `fk_cargo_trabajador` (`codCargo`),
  CONSTRAINT `fk_cargo_trabajador` FOREIGN KEY (`codCargo`) REFERENCES `cargo` (`codCargo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (1,'70120107','Altamirano','Anticona','Dicasion','Masculino','Soltero','1988-11-18','Caserio La Florida S/N','998161235','Primaria completa','',NULL,'','Activo',6);
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `codTurno` int NOT NULL AUTO_INCREMENT,
  `nombreTurno` varchar(10) NOT NULL,
  `horaEntrada` varchar(10) NOT NULL,
  `horaSalida` varchar(10) NOT NULL,
  PRIMARY KEY (`codTurno`),
  UNIQUE KEY `uq_nombreTurno` (`nombreTurno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Día','06:30 am','06:30 pm'),(2,'Noche','06:30 pm','06:30 am');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lastSesion` datetime DEFAULT '0000-00-00 00:00:00',
  `idRol` int NOT NULL,
  `foto` longblob,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `uq_usuario` (`username`),
  UNIQUE KEY `uq_nombre` (`nombre`),
  KEY `fk_usuario_rol` (`idRol`),
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'user','user','Jhonatan Mantilla Miñano','jhonatanmm.1995@gmail.com','2022-12-13 09:48:12',2,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�Photoshop 3.0\08BIM\0\0\0\0\0g(\0bFBMD01000aa80300006e080000f10f000007110000191200008c160000612200006f23000003250000d12600002f3c0000\0�\�ICC_PROFILE\0\0\0lcms\0\0mntrRGB XYZ \�\0\0\0\0)\09acspAPPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\�-lcms\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ndesc\0\0\0�\0\0\0^cprt\0\0\\\0\0\0wtpt\0\0h\0\0\0bkpt\0\0|\0\0\0rXYZ\0\0�\0\0\0gXYZ\0\0�\0\0\0bXYZ\0\0�\0\0\0rTRC\0\0\�\0\0\0@gTRC\0\0\�\0\0\0@bTRC\0\0\�\0\0\0@desc\0\0\0\0\0\0\0c2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0text\0\0\0\0FB\0\0XYZ \0\0\0\0\0\0�\�\0\0\0\0\0\�-XYZ \0\0\0\0\0\0\0\03\0\0�XYZ \0\0\0\0\0\0o�\0\08�\0\0�XYZ \0\0\0\0\0\0b�\0\0��\0\0\�XYZ \0\0\0\0\0\0$�\0\0�\0\0�\�curv\0\0\0\0\0\0\0\Z\0\0\0\�\�c�k�?Q4!�)�2;�FQw]\�kpz���|�i�}\�\�\�0���\�\0C\0	\n		\r#\Z!\Z)!$%\'(\'+.+&.#&\'&�\�\0C		\n\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&�\�\0\0�@\0\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0��\0����:9��:�\�\�̾�M�O\�&\�9wb\�ꨫ�\ZAS+����f\�\�P��Y�\�\�K\n\�U��k\n/\�~���,\�b�i\�o\'v	/�\\���\��D�\�h%3��l��\�\�J&/\�\�3QkdV���E����\n�k��\�\\z)�g˗Wi�u�v�}\�\�T���M]�\�\�m\rW\��\�y\�5I��[���\�k\�\�qϔ�\�z7L\�i�&N6�}\�@s���T�Kʥ�����v\nAjG�1NIF�\\t7R>^ꀙ\�\��^\�}_(;\�\��/\0�\�\�ŗP+_�J�x�ñ��@�Ht�(n\�r\�OH\�\�δ�\�\"��_X�\�E/\�ο���[����r}_$ÅhV�[\�s\�}\Z|�\�ͯ>o6\�ϩ�,\�Z\�\�7ʑ\�\��[y\�X2�\��2ҝ\�Cĩ\�R�d�\�t�G�$Um-\��\�u���\ZMg?iг\�\�\�s�C\�	 \�k�NyjeNt?K=\��4�6\�\��K\��\�\�\�넜\�\n�X\�Vu7?�\\\"\�\�\��3\�v�f�/]b-\�ޔP�_+�\�\�\�\�\�e�\Zޚ(\�$\�H�`�\�\�*�\�\n��GL\�\�;��\�D\�\\\�2L\�\�?�_կ\\~u\�G\�\�O.j�>z1\�lW�D�e2�ǋ�K��A��\���\Z�Gq�T��\r\�g:1k1\�6\�=r\�9�\�\�_)L>��\"\�\���(g\nNE\\��i\���D�y\r�2��1�>�_9��eO�\�4:2m��\rs?\Z\r;rq\�ÿн5~�j�\�z@�l^\�m=MLA�`�g8\��\�⦀��Тek\�K�\�9\�w_�/$�o^\Zav�ol|�\0\���Ě��o��@�V\�6�B؁�\'-y\�\��UA;\��h}_\��~��-�>Z�]cwG\�:yߖ\�:ys�\��)\�ͷ�FK�/?��;���H\�\�Aͫ�L�?-2\�9|>\�y\�z�2*�<\�9\�zh��u[\Z3U �Ý\'\�4ifg}�\��ry�o��~{\�`\��\�\�\�:s��Q\�l\�%�r`*��% �yR�T\�vv�W�\�e\0��5yh#A�M_g\�\n��*WSS��5͵�Lf���\\�ڟ=>y;���\�<\�U+��F%\�b���\�\ZA��s\�AXΏ\rW:�	\�H\��FI�_\'��\�\�\�%�\�׆��6�9$�q:\��XU�=\�\�\�>]K\�(��\�\�I�.^�LZ�\����<�y\�U\��e\�\�&,���96y�HD\��LEN\�W\�\�h��6\�\�\��ph\0Mцw\�\�a���K\\�uzK\�(#�]\0zO�\�\'�\�\0)\0\0\0\0\0\0!1\"23A#B 4C�\�\0\0\0\�\�M#\�\�\�ۇd6\� ��3v�Oo�\�����U֛\�H�z��Nws\�V\��.r�XKT�*z�Z[�e{�]\'o\��ɮ\�\�\�x~\�\�1�n(2SA�����\�ڪ�;����US>�Q[z���\�ٮܵ{�5d�\�\Zd8�V\�\�E�\�\�9]o��\�-\�\�:�ϖ�7Y�\Z��V�%��\0�݋u\'ܽT&�vYm\�b�t��Mp�[^@\�~I2T���P\�݌8+]����i��ߚ\��=i��\���\0\�\��w\��Uƒ\�\��\�\�\����\��\�����\�#0�\��\�?�\�1+-]Y�\�\�\�#1:�\Z§�}�i�.0\�ŕt�@\�\rg\���\�\n��G�w\�Ϟ��.�I�\Z�\�\�JF\��\0^�b��\�MU�����pu\�[�<YY��{�\�WV��8��\�#Npnm\�\�݈\�e�+K:�䲳\�Rx�Ň演Y���ݞ��+8k׺#*։��9hy^�S�\��\�(��>G���m��\�\�;�\�8��\0�J���Ԫ/�!�P�u\"�	Y����4�\�6\r�\�\'\��\�D�\�F\�SrL\�Y���\���/�pB��\0&bWa@��\�if3��l\�t\�Y\�Ҷ\�\�P!�\��\��\0\��\0L&r_\�=��~I�J�-ڈz����ڴ�\�&b$3cc1\�|\�c2\�\�m�D\�т��Y\������\�ԡFx;��\�\�\n�y�rL\�j���%u����YIbt\��\�h@N0P�K�5�11�\0+c*�,fLѶ		Sɍ\0�\�`�	\'ڟ��o�^��\'s�\�q3���.\�\�n̗҉n�\�1t\�a�?\�\\�G\�\r�s�R`𒾠L���]^�\�\�\�S���Fam\�G�@�؈0�G8�a\�6��~�\n��\�jXOL\�\�\�u�Þ+��D&g�B�h\�r\�\�f\"$��\�.IA\���\��UI�\r�i\�q��\��Ŭ�[Jӟl\�N�p\� <	\�\�\�ͧ38�f1\�s\�NJ�	�\�\�W8w2\0v\�F!\�ml B0?c\�\�1FL\�s\�Q�\�\�<.\�vg���`rM��`\�\�bZ?J76\'��\\:$�2m�\�C\��\"\�7r:-��|��l\n\0Xq2#��vkG�Y��ؓ��,h0�G�!�bT%�c\�\�\�e��\�,fπ#LJ��9���\�\�5C	=ŭf�/����c�#y𝘼J\�ôS\0\�\�d�k��\"c0�F�������\� �a��\�Olc\�‛T�_1�%��8A3\�8Q\�p�{~\�c��s�(\�XL\�pN\"��\\\�s7\�	�:|m,Dm@�?!n(�}��4~A���\�`d3�8�\��=\�����N`��s	��\�qU\�vLT\�^ab�\�k,c5�\�ĴX�j\0o�کTb�\�X[�i�\Z!��>�C\��,��\��0s	\�X��\�	M>��\�\�)���\�c5{�Ѩk\0x۵�\�#�L�\�\\\��bV7�}\�9\���L\'3 \�\��r\�F\�\�\�*oM\�\�\r��C�\�s�\n��Mel\'�\0���Ւ�0\�P9�,\�b����=�\�vؤwnU\�> FiSbW\�\�\�|\�\�\�1\�\�\�\�q�I����v�\�!�\"��1\�q1\Z \��?\�&\��Ƃ3c\�\Z~�lpN`of\�Χg��;d��\��\�\�ej\�.���3\�\�7�\�s�H\�0\�\�e�/��\�����8��C\�XL\��z�	��\�\�2n�W��\"Ҹz�\0�SSKWSC\�qLq�\�\��7\'⧿\�=�\0ɀF9� ;`\�\�� �`���\�İ	�q�ԗ�+�\r$�\\zQ뎒\�\�\�\���y�N^4w�gBd���A�rO�q<	\�\nn	u�\r/�\�z\�2�a�[T�1-��\�F�W\�\�<��	�x�\�\�\� \�\�����+��G\Z�,�{��,c�N&sj	.\�s0\0\�0Bs\';�\�!\��a��: �ʻӘ�F\�S.�\�fy�9��\0\�6dp;�\�L^I��A\��8�Y���f)��SĲo�Y\�\�,1�\�ѺX|�\0�\�\0#\0\0\0\0\0\0\0\0\0 !01AB�\�\0?�\�$��?�ƏL�\�\"�hDa*Z�Օ����Q�\�BZq\��t{\�!kV{!��g�];M&K��O�Gŭ^����f<U݉mnX�\�\�\��}#�ĺyE�D���F=2�y_9\�S?�Gԅ\Z\�\�e�!�B\�\�N��3ޖ\�\�W��di��\���\�\�^\�=a�j\��^�9�\0�>��-w=�Bf9Z\����3$?F#����~��(^Ĩ�	�\�\�\���	gDr;#!i�e\�j�\�\�E\�!���\�\0\"\0\0\0\0\0\0\0\0\0\0 !1A0Q�\�\0?Ĕ?ٌ�\�R��/\�⡹xX�Z\��eǤ�+Y.>p����$}⺇z�+��h�@�Һ�_\�\�+���ɂ�\�!��\�_&����\'\�H�ᱲ\��U\�\���\�9$�\�_ �ϵ�\�F\���u��6H�)�k\�\�\Z)C\�.4�\�6\���˩z\'Z7�c\�h�M*\n��C\�H\�C \�E�n�\�}\rC\�tN_$h�S�=^\��<�ty\�Q�\���\"��tZ�\n\�*y�x�\�\0-\0\0\0\0\0\0\0\0 !1Qaq\"A02��BR@����\�\0\0\0?�\�$^F�\���\0\�iLK\\F<᲋����L?(��S���%\�Gm\��\�1{K�d��8���zg(\��V\n1����Pp�\�t�\�\n\�n\"�B�\0�(�\� �\�u:\0�zꝓj�+��\�őÄ�\��\"O�3u\�A�$6�!a,\�Uel�M\�րr:�\�E\�y���\�%	�#QJ>\nڂQ.�\�z(�)��|�Ԍ;�6�Xb�\�B\�\�\�\��M���s\�:\�l�*!\�ź�\ZL�,��G�7�M��\"N�\�B���#\��\�\"(Z!�\�DB~��\�M���\�1\�e?\�D&FF	u�L}\�\�,�e��\�P\�v�\��e2�\��a�o6L&\��!\�Q\0\�J&\�\�8�\�l$}#\�\�\��A\�&Wy:z|]:}�Ѥr��\�8QM��|>=�\�Gj\�\�b�0�\�\�\'W��\����BN\�\�M!\�f�%�\0\��,=6\�u|\�\�qFK$\�]\�\�3�^\"V/\nƂE\�\'L�2v��=���{yW�#hS3C>ЙwY:p�V�e[\�q�$I�W�\�>k4b\�~Ky�)\�i\�\�l�L�ʱZ�����]��Y\�|����\�\�V[ɖ\�J\�\�\�Ɇk%��NB�E\�R\�e^S`+~��Y3,\�YZW\�7�j�N\��K:,�\�m\�Ĳ��\�\�鴭��̙���O����/\')\�u�.�n��B\�Ʉ\�\�\�y]�\�r�\0�`���	���\�m,ց49-hBrf饼���\�\n�qi�&M\�qS\���e�`�U󖂋��\��ۓ�]��\�[�N��)\�72e��=Ӝ崜\�\�ge��}0\�+Y��\��\�H\��&�Ӛ\\��a�jw�\�Ú�brtQz����v���\�J`�-�\������\�\�/��w(J\��\'\�+ӹ�2u\�e\�[&r�� \�\"\n\�\�u��i\0�&V�b\�\r\"\�\��\�\")�&қ+\�F鼦�\�@�\00�U\�\�DJ\�&5;M\�\�\�W\�\�\�\�.�L3�����\�\�4\�wQG�\�;�#�{<�S��q�&��d��tG1nS�iY\���\�y���kF\�\�\���1��\�ib��J\�=�B1�+\r�}�=��O�)�\�m+M�쭒ct\ZXPh\�2\�[Ӈ1�\��W�����\�(E\�\"t���\�\�\�h���\�.)o|e�R��n�n�\��\�E\�M67�\�\�v�P�\�P\�o@��\�\0&\0\0\0\0\0\0\0!1AQaq�����\���\��\�\0\0\0?!�Ɯ���}�-E��\�\�M5��[V\�r2L\�����\��\nj�Ej��	$h����>F	mѕ�,\��11�J�dRS\�)r��D�v�Y�>A�M�I�d\�Q\�\�9\�$#\nR�}\n\�\r�ZH�RSy�(\\C\�;l�\�݅cI\�RƵ� ,7\�\�Y�3\�c4Ҡc	\��B�\rҿ#�.d5���X+#E\��:yh\�Yz>Dd��\�`��\Z;/0?\�Ɣ\�A�Hi|@hF:��A�\�=\�)?iƸ�\�\�����bO	+\�Hx>PO\��Uy�n��\�3�rؼ�\�\�)�#\�f�\�z:72X�r$D�b5\n��\�qVe��S(26�2mRx	����>\r��\�Kd۸�� r8\�\Z=�\�!\���Ƃ\�2KU�㙐��\�Q%���J��1*8�S\�0��ɧ30�ر�\�N�v�D�rٌ)�K\\{\\�5�k\�\�+\�fW��\�4�ᒂ���jH\�?\�	�\�\�Q���g@�\�\�6����Q(�,�\�!�\'bZ�3�6Y@\�ءJ�g\�N\���K!2_�ٝ�,��\'4<�I\r�#\"i�GB��<��\�dj��-V\�\�\n/Rɜ���2r-N\�c\�I�Je\�;	\�t`.p9����+\�@\�0\�޲$*~J�3r�I\�ص!�1<!��N\�	\�[\'U�&6\"ߗ�\Z\�\�Y�\�3*�D)���L�\�/���\�\�#Y�\�0o\�9	\n\�2�񔗒\���Ά��)g#P�>D���A�PY\�\�k��ʚd\�_CI\�\�\�%S1f_,\r>��P�-��\�N��1e�⑿��m����XQDn0fbw��)�$荫�	S�p6*M��E/�LH\�\�\"\�wp\��7#�8LزW�P�\�GaS�+5	\�J\�g��������\���O&�-��h[��7\�\�A\"\�|@�o\�IJ\�P\�Bn����9��S��N\��rRɓ�\�b��Q{�\�%!FY\nM.\�b\�eٽ��3K$g_\�BI��U\�ճf��]�����G8X2\�k\�\�%���|\�H\�bz\�b�T�\'I�L\�\�\"�t�W\�R�<M32��el�퉤��x2ڽ!8\�Bv~|���r%2�\�T)�B6����k/�\�\�e`{-R�\�6$5<<��\�G\�\�g�B\�\�\�r\�Њ\�xP�[D����\�j͢Lb\�/# �iy�b��Hg�B�dG�*�\�\�I�Oќ�}�eԹ�Ѵ8�hB=\��h�W�\\X؉Nh7K�\Z�~F\�\�r$��\�V6���$1/��㱲&\�+\"�\�fW�9M�\����\�WV�K�D!%3\��OhV\�!�\�.�\�4���\��Xl6{1zD�\�\�\���,B\��WB�\�\"��\'�5P\�^MBey%�\�\n`��P�\�\�*+\�2��1-i�\'Dݕ\r��%,a|�^�(#l�\�\r��L\\c�R\�\�P��D�RU�#ɞY\\p��(&��$�!%\�b\'0\�>f\�&���W���!J<�4�hD̲�$7\"\��?%jݒtC�\�\�eJ����Bhs�\�K^\�o�v�.H/dE�:��jZG�/�\ZB\�\�\�xT�yޡ\'+�*�\�t \��o2FOp\�1�����ȡțK�R��\�m2?G���\�M\�BB\�\���ܗ��YA�I��`gfB\��A�)\Z���.\�\��C\�f4ݕ:#�E���ɒ\��\���\�\�:B9��)?\��Gp��X�f`�nCd�O�	g�7	X�qBS\�[tH�\�`�{�*؜$�\�BR\�C-,{w��8\�=�<I�\��A\\�\�m�Ճ߭#%\�\�Gh���1\�!5\\�r(�g\�!�\�G�\r˖\�V�N\�\�\�.ʤ�\��x\�ZY\�:\�>Y�\�[G\�~\�K?Ir9�4W�Tg�\�\�T�_ت,��\�\�\�I&\�,�2/Bz#\�Ѡ�@-�$b�\�S�KT�$ ���\�\�P�\�k\�\�mRb\���x\�o�pE�¢\��f\n\�����\� %b^Lh+)\�U �;\ZK�Q��m?\�\�\r��L�	K^�wĆ0��S�fCX���H�8�\��\�܇ɓ�V5(�C)�M��&�Ml+Gb\\4��f�IJD\�\�+$,4x�o��c.L\�+���%\��NTw�\�y\��ȪY\�\�\�A\�P��RI\'<\�Z\�9\�Њ{Y\�SD�p�iBH�Э:�eiy�\'v&�\�\Z|�\�,��\�hO�E�r]|\�Q\�!\r�<�\"P�\�y,�ŋfs�!D�YLU�d\�\�ŦY\�����ׯ�\�?\�\�h\�>ȝ\�3hc�r=��ԙd�\�\�\�Hqx��\�\�\'0�M���J�����LA�\�psZث��N��K\�8xbHdy-��-\�\�\�o�Bpv9�\0�Rǵؤ\���p�ȣ\0����P\��CѰ��\�ivOBn0Y�,���<�ݰ8�>EKt�t�E�yNܓ1\����*X\�HY\�I�<J\�\����\�	���ǘ�|n�p\�\��$���;9C�M\��\"\�d�J\�\�\ZY\�(\�L�.H1ԉ�n�ɒڦ5PM!���P\�R_b�-�z!�M\n%\Z�#�Bm\�BU�\�e:ʩLt$\�N\�\�R�cB�+\�@٥\�\rñ`\�6\�X�	.�8J��0QC\�r~�\��7���\�O��2ƌ�4=��Q�AfXɜ%\��)^�k/a%��9\��e�\\�0�\��V3Ȩ��\�d\0�КJ��2*�\0�3\�l\�\�\�\�^E\'bɶ\�\�\"ʞ6�Y�	�\��;��Mm&�\�l�\nH%o,j��3�5�^\����bø�=.$�k!+I,!>�ٷ]�\�B���zr5��*���rd\����/͒��\�K��aK/�{�GN>\�ehJ��g#x&A_%\�Ԑ\�H�1t*@\�\�Y%	p1��	@�M���\�\�lٳ$�\�-r1�(\\!4��\0���?�FO�BS\������$�\�CW\�#8\Z\�\�!m�$폋U�\'��7~�2���\�\�LL�@��f���!�2\�.=���[�c*�DTm�L\��`�2\�b��\'lb���\�$u��	ތ��\�p?B�\0\�HIs��\�۷l�\'0\��\�.�6^ \\!#ఎQs,f\�)�\�\�k�\�\��I,�\�\�tТ�	�#xE*X�\�\\0FI\r���it+�%�\�4]\�[$��;[_d���ذ��9��O\��\�+$����q(C���H��,	�҉qdUvIn5!��4}����D��8T5��P�N=\�����:\�Q�6��?�U\n\�AG�X�H@��fĶp*�cbσ�E��\�#p�\�\0\0\0\0\0z_b\�q�@�B��\�\�Lh��W��\��m�^&x\�i��Z\��6j����Çf�\�Sf\��Om\�*:jh���\�*A\�IP�l�\��\'y�EC\�/>\�U~�\'���\�W\�\r诹����\0��?����\�0gL#�\�t�g�7�\�x\�0w�j�ؐ�gB�\���\�JV�\�d\���ǆ��\�\�?�$\�s\�\"\�3/\�a�\�\�y9�\�h*XGk䋚\�Y��\�^�<6#\\P\�H\��\�\0\0\0\0\0\0\0\0\0!1AQa�\�\0?\�\�\�6�ǟ	\�\�m��C�\Zr\�Y�fl��O�\�o\'�;\'\�\�0l�\'��,�\��/^\�\����g��~^?D�\�\�\�\�˧,\��J��1�\\�\�\�;e��!�&\�6\�\�^.\�OX\�|\�\�\"�ʗlLog�dP`\�E����d|]ڧ�吟|��I\�!r�v?l!a�\�\��#��I���l��\�%�\����\��\�N��Q�O\�>?�\��~�\�\�{\�\�%ˊ�i,^\�m��\�\�\�>+t\�,\�\�n�W]�cv\�E����\�#�\�lؔo\�1 �6ٷ\����Y�n�G:\��{Ƞ$\�둜\�ap\"l{��O��3\�?���<�ߞ�\�B�/\�)o/\�\�0��\�\�\�ۗ\��\�i/N�rq\�X^�\\�𳈞�9\�\�,��t�2�O�{x��\�\0\0\0\0\0\0\0\0!1AQaq�\�\0?ϛ;.YO�\�<��7��l\�ާ\�g$�\��\�\�ߟ�m\�~+��\�\'%ndO�\�\��\�\�\�\�m�^\�,�<�	m�\�\�\'\�H��o%/e\�[-\���1/rU�.3�M[�/><vC\�,X3�a\�y~O�	j�\�P�ӑ\����P\�\�o�v\�!9���ëD=�\�nȺ��\�\�p\�FZ�\�d_\�\�\�$Β�ρOY#����\�\��eV�]d\�M�{��\�\�e\�\�\�\�?\�\�_\�8\�_`\�[ް�0$�\�O�~O�&~˞Y�`��z۳ߜޤ!E\�G{>ٯ\�\�>\��\0��o_-9\�\�7�Ɏ�\�$�\�\Z�\�̆Nޣ�\�5\�\�v\��ߴ�\�\�\�.����|�c}���;:`�<�L\�\��ޒ\�p�(�J��\0%\�;��=��s\�\���\�!�]9\�K�52a؏nB5\�[\��m\�\�\�`\�\�\��p]<��\�푇l���\�\0&\0\0\0\0\0\0\0!1AQaq�����\�\����\�\0\0\0?M\r��n��)\0&U\�\0\�~�\��2�}\�[#b�L&׋`\�=s\�1���[y\�\�e\�X�g�$2C���\r%\�x��h�7\�\�BB�P+0\�\�ӡN�~�\n�\�ގ�����/Op�\����D�\�UB;�S�\r���\r3e��SlC����7+E\�z\�?\�*.\0��\����	r\�8�1:�\��mAR�֔8�r\�\��\�\�3z��\�*\�\�Y\rs]�P�n�\'1\��)�\��s�<$=p��\r���M<��\0 \�F�\�!�\�Hh+\�,\��MR0\�h޾\"]\���\Z3��M�\�\�$��KExf]�rZ�sb�gk���-PC��Դ�h9�\�(3����a\�;	\�\Z��\��g>��j]��^\�\�m\�71e%i��3p\�im� 9jwv@\�+=@�mq2��ńk@rY-�-E��\����\� _ܳmi���D�1Q}\�Je����)��`(jƓ\'�HG+;\�c�V)5\�UZJ�\�\01�\��b޽K�\�\�\�\�\�\�/$�c�n�\�@�൝K��U��~\�\"��\���+)\��Yr1\��\�\�;d+@�b�p��n��R�G�\�U\�+v���\0\�Y*�r} �4�����\Z\�\�\�寊\�42\��/q�\r\�*%a�\0V�h�\�\n.$T�8\�ߩEչg1��@����	��8�.x��\�ޥ*O\�*\�k���\���-�m��\�V�>\���J�\�P�[yx�G\�v\�n��^3�\�p�Q\���AA-�ǈ\�\�ǰ��\�#c����f[��Y\�@��Q*\nÐW\\���Gr�\�*\�\�\�[J�\n*�\�\��\"R\�8`h��\�QdG�1\�\�T%̾�\�\�ҏ�\�V\��2\����C\n�\�\�1j�-` X��b�\"���\�\�\��\02x�u\���m�\�J\����\�8��/P\��i�K�+^%\�\�qT;\�\r�t�cո�\�\��Sh��X\�w(t|*p\�\�\�\�sa\�\�`�Ȉ9\��\�@\"\'�\�(\�\�\�S�\nu̥�6\�(!CꚉO\�,M\�����%Q�\�X����?��\�\�,,�d\"�q	hO�RĴ|\�\�<F �Y\�?h\�P\�5�\�n:VR6}�C\�\rpK>�*�?�^�ru{\"��C�!��WB8Wr4\�\��\��\0�IZ\�N�o;�ǶM�\�$�=1��|K	6㺙>�A\�է\�y�/�B�*2��W\�x���P��K\�t\�יj�\�\�DZ)/\�v\0��U�-��h\�\�\0���@\r��X�3ao�\�h(z�bW���n�\� !QG\�\�U2\0�;�\�\\\"\�;bK+��[���z¦�+�\�KQ\���\�n*�0h6\�\�y&\"ծ8��#PZ}\�\�YJ�\rk\�Phi�\0\0�J͗Us#�@Ё_\��\Z\�d�\�\n\�-\�-m_�EU�\�\�+?)͐e��G�\�Q۪�1�\�R��\�P\���\�)�Ņ��\��\�;�z����\�&]G�x�+8z�\�x�n:��\n�\�\�\��B��\\�\�\�\�\�g(^\'�\n\���jy%\�w~�\�:��@/=�|K��lY����\�Wܑk�YU\�\���J\��S��;t���*�&5�\�~e\�v�!@ܱ2\nل2\�>]J7\��#�_��P���\\,>\�\�r��d\��P;H�j�gL��b\��\�R�����T�R\�\�\��G\�k�`H\�A\� �=�&�F�\�io�����\�͗\�̦\�\Z\�%~娣v�fk�J*�\�w\�X��\�\�\�NB+�y\�D@lĮ���N�\�Cawg�Y�)\�//\�Z\�k-\���.^����Iӂ`yN\0.a��O3�J{2�;�Q�%�q�\�\�Zh� V±U\nS\�L0�5+k8�3�$�U\�` ��,��oǩjE�ƈc\�;�\"\Z��\�\��\�P)\�A95\�s-�A[\��Y�8`\�w�U\�0\�\\}�.r�P l�i��b\���,1����\�8!��\n\�KK?\��B�\�\\�F?�-���*\�:\�B�I�Eg\�Jՙ��}A̸\n`%e�3\�.-Xz��\�,�\�u�o/c�\nn<s0�K\r��RbZ_�n�\��\�d� ]�\�vç�D\'���R�\��\�m�\\��\�\r��\"ޜDJ�7\�?�_\�@\rv�V�\�6\r�e�<��C\���<	�W��eFm�\"ц+���JІnZ\�1�-(�|\�\�1\��/Я=M.\�p�!�,���سd�\�p\"\�:`\�1#\�\�\�\"�\�P��\�`�o\n\�C�Z�d.1\�=Es)\�6�b\�a�:�6��B�h\\�fW�\��gm�q*\�(e\�]J6\'\Z�q�\�����\�\�mf\�s\��&���Y\��!\�ܛ/\��\�^\�D(_�	�06r`�¡�Ὢ%�\��{�\��\�e�\�ӷw\���\�k\�\�Ñ��3`oǈqm7�ce4\�U\r�ӈ\n�� �Xe\�\� ~�\n\�EG\Z\���\�$ƥ\�-tߩJ\�Fu2�\��P!Z3QE@\����u��\�\�(,pn\0�\�.	�T4f;\05FY��s\�&�\�\��S)�t|J\�d\�ҟļD\�+\�@ki⬖��\�\�nj�H\�E��\�<�ƫ},��\r��FT�W~��\�\0G�l9ef\��7_�L*a���fJ�\\z�b\�\�F\�FV��\�\��Eme�\�\�q\�U?\03�#\�K�cC]9�S^\��z��d�Y_\�\���\�f�r��]lH-~&������	��.ʃ�X(\�y��gЌ.OO0\�X\���\��2�6^_\�%\n�qUV\�:��NF\��=ԇ\�oM�|E\�m�\�kV�#	ݵ�)۞\�\�\r#��VZ}�Z�\�\��E�\�יT,\�\�\�a�d\���y=\�snѪ\�h\�\�Î���\�+�-�4�pf�\0IR\��\'b�x�n�R\�cS\�V��Vj\����t\��\n>�~n#A\��\�&\n\�\�\�r��w\�Yc\��<�H�~\�q����@�\�#��\00�\�+\�\n@�}V\�\�V\Z\�\�5eP\�9�*o\�P9\Z�8YM\�Xɨ��\�\�\�\�7Ɯ\�7\�--zr\�@k\�ùCZ0_>Yp�\���\0\�\�T.�X\"�W�\���M�b¼�įJp<\�\�tye��o,-M\�`���u��1�{\�\�\n�\�$\ZV^�̨.̤\02\��yzS\�2�JR`�\��\0R¦8�\�Ey�\�+\��?�`�-=³\���T\��\�+���\�i\n��.�&\�\�,�����\�;uk{�uZO\�:*`\\�㰺�\�x�65����>R\�}3B>\��R��\�`�\�Q\�[V\�w9A�^W�\�p�\�2��J囖{����!e\������\�i���ȩ.�}�\�%�9306\�F\�Z��G\�~\0\�o\�4p\�\Z m9�0\�癅,��h�\0\�R�;��Ė\�4ye\�g��\n\Z\\��\�`�\�|\��fDF��>��P\���\�Oo3\'NK�c|\���=Kp�\�\�twT�\�	8(2�\�!ت_�(^)Ī���	[\�w���EW�=ŽX\�\�\r�H�\����oP\�\�5�b\�89�\�{�0\ZO\�Y���w\�\��\0 \"h\�\�7�wԦ���\��No�f�,0RW�FG�_H63�c$\�ר�T.�\�\�u�\�v���R81\�/�\�ƥ\n��\�2�2>�k]j��$8-ĵB\�qp�$\��\����\���)[\�W6͝��h:�0\n^\�%\�,T��%vric�UU#�o+������\��_=�m�lq\�%�es��K)[\�a4:\���z�\�l�\�c\���H��M��\'!A\�r���\�pX�g\� r\�V�+,�g\�Q���?�05(铊\�L���54ũ~�J]��b/���LҲ�Z�4P�\'�\�Q�n\r1֏e�Z�ہ\�mQ\�9�k?ڱ��H�):Y��D�l�L\��9\�J��n�Pl�X\'�����~���S�#1i���^\���kƎ�D\�ܼ\�(߬\�\�%7\�Asx�;�\�\\�)/\�\�\�r\�\�s\\D�u\�\'[\�\�\��\0\�(\�rA}\�\n�\�\�`\0ݽ��G��g3nm\�e�6���\��{���cR�\�\�\�v�rNfK��2\�!*���qu��0g.�f\�/oR\�n\�U+�_\�\�\0\�gӓ\�\�\�\�\�Rw�Y��K\0���v��0u_|�\�\�F\�Q�8��c�막\�?��%��\"oz�\�����D�\�+s�f\n��,�\�9b&E�\�\�(`kߏq%��\�^\�`��\�&P\�Ԡ@��ޔO�ǈ[��P8Ǯ^&\�X<�\�r\�[�����y��i\�2\�4�߯2�9`_pv4\�\��N\�\�c�%U:L2�e\�\�\�WOb�\02\�Z[_�t�Y�\�H\�(�\�\�\���(\�\�u(5kL�\�aǩ�\�O1C\�s|�U8&^�\�P\�\�-�\�<%\�\��ΈmIK�\�~`7H��qX\�\�\�U�\�2\�V�\"�%ݯq�G�\�R\�\�0y{�L�p�\n�\�G\�\�!\�\�\�R\�X���FbR\��\�\�qZ�S���\�8SycY�}\�(�\�v�.\�(Ц�Yb/6y�\"\nG,�\��\��sDS��\�/P��T\�֦�\0x\��\'\�\�\�>\�\0\�\�\"�9_\�VJ	�FR���NR\'mo�,�L�S%����l\�{J\��.��l�\0p�71��N�\�tL��\� �b�WA\�`�l*�mv�,�B�YB�\�^e\�V��\�[ȗ��*\�~\"\Z\�V\"�+�`�ߢQ\�[���\�o\� mbإ\�+}\�\\��%�\��x	Np)\�6\�.v}\"MC��\�)�\0Q�Ġo;\�=�z�C)O�\�Ը�j\�׸\��֜�\�8�\�\�N�l�*\n���(}�\�\�v*\0-\�\�*Vt\�Q�\�\ZQ�g\�\�F\r�|�C\��67=3*\���\�\�)g\�6\'��\�;\�\'��mJ;\rT3��.\�1\�]�u!-��Wl��Wl�\�fIo\�偔>�\07�\�\��y�Q\0=��`�j\��\0����\��`�\�����A�%��\�Ae_��Cx\nh�fn7�£\��x\�~�\r�\�\�v:�\���	TՀ9�\�4D�m�N�o���	�?�7:_�\�`E���]�\\C8a��\��nd(\�9��b.�&\�\n*�$�`:�9\"k�빕\�\�\n\�,<\�2|�\�n�x�q��ca_hfe�\�\��fz�\�\��@\�\�\�\�2�v\�``\�p[��|{��\�V\�>:<˵�l\�ZO�%\�l\r��燐:���\�\\��CTf߱\����\�r�d\�-��OO�;�\\���\�\��h�n�M��=īj\�{�		\�\�R�J扦�&#2�a\r\n; T\�(\0\\#G�Cz;:�\�|�\�\�OԸ�z\"�v{b�ZB�\03�s\�,t�\�\�>\�Z\�\n��k\�]�- ��R�S�\��\��<��z\�éf�y�f\�^e�^\�̪��\�7-C��f�O\�^�W���8l\�lÃ\�ɏ�v�E[r\���Q=���\r�\�`\�j�\�0L��\�JЮ�%*\�\\\�	�@~\��\Z�\����S3�`oN�\rJ]\'\�`ʓLɇ���\�\�\�\�Q\�\"1B�+:�7�w-\ro�+�\n�\�\�\��J\ZAx�\�\�Ό�fm�{gEG�\��\��׉�\�\�,H��En\�|���bܻ�w\'o,\�ޡ\�%\�m\�P@͏�X\0r\�JC\'�<\��6p\�Ec uPE?�\�(%0-Dx�\�5q:�*]lL\n<\�#\�\��E��\�r���ُ�6�\�i�Z\�~��r\�\�<=˕NwǉF�b0t_A�\�F��,jQ\�\�\��� �ư\�6�\06\0��-ϢUxӈY�\�(mC\0�\�\\ו?\�n�X\�r��Y[�K��&y6�\0d\�V�\0s\0E��^U�6Y��9�\0\�\�¢��(e~b\�w	v�\0,�\�Y\� ad�п�(\�J8�	��k��\0r��0��֎���\rL@�\�\'�\�');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vale`
--

DROP TABLE IF EXISTS `vale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vale` (
  `idVale` int NOT NULL AUTO_INCREMENT,
  `codVale` char(6) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time DEFAULT NULL,
  `lugar` varchar(20) NOT NULL,
  `horometro` double NOT NULL,
  `galones` double NOT NULL,
  `codGuardia` int NOT NULL,
  `idTrabajador` int NOT NULL,
  `codVehiculo` int NOT NULL,
  PRIMARY KEY (`idVale`),
  UNIQUE KEY `u_vale` (`codVale`),
  KEY `fk_vale_guardia` (`codGuardia`),
  KEY `fk_vale_trabajador` (`idTrabajador`),
  KEY `fk_vale_vehiculo` (`codVehiculo`),
  CONSTRAINT `fk_vale_guardia` FOREIGN KEY (`codGuardia`) REFERENCES `guardia` (`codGuardia`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_vale_trabajador` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_vale_vehiculo` FOREIGN KEY (`codVehiculo`) REFERENCES `vehiculo` (`codVehiculo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vale`
--

LOCK TABLES `vale` WRITE;
/*!40000 ALTER TABLE `vale` DISABLE KEYS */;
/*!40000 ALTER TABLE `vale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `codVehiculo` int NOT NULL AUTO_INCREMENT,
  `idVehiculo` varchar(6) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `modelo` varchar(15) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `fechaCompra` date NOT NULL,
  `año` char(4) DEFAULT NULL,
  `codTipo` int NOT NULL,
  PRIMARY KEY (`codVehiculo`),
  UNIQUE KEY `uq_idVehiculo` (`idVehiculo`),
  UNIQUE KEY `uq_placa` (`placa`),
  KEY `fk_tipoVehiculo_vehiculo` (`codTipo`),
  CONSTRAINT `fk_tipoVehiculo_vehiculo` FOREIGN KEY (`codTipo`) REFERENCES `tipovehiculo` (`codTipo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'contrataminera'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-13 10:02:06
