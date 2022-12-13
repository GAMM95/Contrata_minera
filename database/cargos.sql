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
INSERT INTO `cargo` VALUES (1,'Supervisor de operaciones','Empleado'),(2,'Supervisor de seguridad','Empleado'),(3,'Asistente de operaciones','Empleado'),(4,'Asistente de seguridad','Empleado'),(5,'Asistente administrativo','Empleado'),(6,'Operador','Obrero'),(7,'MecÃ¡nico','Obrero'),(8,'Llantero','Obrero'),(9,'Conductor de combi','Obrero');
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
INSERT INTO `turno` VALUES (1,'DÃ­a','06:30 am','06:30 pm'),(2,'Noche','06:30 pm','06:30 am');
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
INSERT INTO `usuario` VALUES (1,'user','user','Jhonatan Mantilla MiÃ±ano','jhonatanmm.1995@gmail.com','2022-12-13 09:48:12',2,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\í\0„Photoshop 3.0\08BIM\0\0\0\0\0g(\0bFBMD01000aa80300006e080000f10f000007110000191200008c160000612200006f23000003250000d12600002f3c0000\0ÿ\âICC_PROFILE\0\0\0lcms\0\0mntrRGB XYZ \Ü\0\0\0\0)\09acspAPPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-lcms\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ndesc\0\0\0ü\0\0\0^cprt\0\0\\\0\0\0wtpt\0\0h\0\0\0bkpt\0\0|\0\0\0rXYZ\0\0\0\0\0gXYZ\0\0¤\0\0\0bXYZ\0\0¸\0\0\0rTRC\0\0\Ì\0\0\0@gTRC\0\0\Ì\0\0\0@bTRC\0\0\Ì\0\0\0@desc\0\0\0\0\0\0\0c2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0text\0\0\0\0FB\0\0XYZ \0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-XYZ \0\0\0\0\0\0\0\03\0\0¤XYZ \0\0\0\0\0\0o¢\0\08õ\0\0XYZ \0\0\0\0\0\0b™\0\0·…\0\0\ÚXYZ \0\0\0\0\0\0$ \0\0„\0\0¶\Ïcurv\0\0\0\0\0\0\0\Z\0\0\0\Ë\Éc’kö?Q4!ñ)2;’FQw]\íkpz‰±š|¬i¿}\Ó\Ã\é0ÿÿÿ\Û\0C\0	\n		\r#\Z!\Z)!$%\'(\'+.+&.#&\'&ÿ\Û\0C		\n\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&ÿ\Â\0\0ð@\0\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ú\0\0\0\0\0üÿ\0Á¡†ù:9…®:Ž\Û\ÆÌ¾¬MºO\Í&\é9wb\Òê¨«…\ZAS+ª’¯f\Ü\ÄP–…Y•\æ‡\ÑK\n\ÃUú“k\n/\Î~‡ø­,\Êbùi\Åo\'v	/½\\‡ª\Ó¬Dš\Óh%3¥³lüž\Ø\ÃJ&/\ê²\Û3QkdV›¦¨E¡™¦\n¦k„Œ\Ý\\z)¢gË—Wi¨uò©v†}\ì\áT”£ñM]ñ\ã\Ùm\rW\Ï“\èy\ã5I¼‡[•Ž¡\ç¶k\ê\ÇqÏ”ª\Îz7L\æi½&N6ž}\à@s¡ùšT¼KÊ¥úŸú ªv\nAjGô1NIF¦\\t7R>^ê€™\É\Õò^\ï}_(;\ï\Âð¼/\0¼\É\ØÅ—P+_J®x¦Ã±¯–@µHt“(n\Ïr\ÖOH\ç\ÔÎ´ž\ã•\"‰‡_X¦\ÈE/\ØÎ¿¹®[ù·ùr}_$Ã…hV†[\ás\é}\Z|°\íÍ¯>o6\ÛÏ©”,\ÆZ\Ó\Ç7Ê‘\Ù\àø[y\ËX2¬\â…2Ò\éCÄ©\èR—d“\Ðt«G­$Um-\ç ø\îu¾¿Ž\ZMg?iÐ³\å\ì\és³C\Ö	 \ÞkõNyjeNt?K=\åò4ý6\Ë\äõK\Ó™\ç\Ð\äë„œ\Ò\n˜X\ÔVu7?®\\\"\Ù\Ó\Íó3\év¦f‡/]b-\çÞ”P¸_+¢\ã\ì\Ã\Å\ïe¹\ZÞš(\ç$\çH“`ó\Ò\Æ*’\ä\n¥GL\Ó\Ä;Œ™\ÔD\ä\\\ß2L\Ó\Û?™_Õ¯\\~u\ßG\é¼\îO.j™>z1\ÞlW“DŠe2öÇ‹K¢šA˜•\ã‹\Z”GqöT©±\r\Åg:1k1\Ê6\Í=r\Î9¨\ë\è_)L>¦¤\"\Ç\Ò¨”(g\nNE\\·i\ÔòùD¶y\rš2–´1­>©_9”ýeO„\Õ4:2mõ²\rs?\Z\r;rq\ËÃ¿Ð½5~²j‰\éŒz@±l^\ãm=MLA°`ªg8\Ôû\Ðâ¦€€ŽÐ¢ek\çK‰\ã9\éw_Ÿ/$Áo^\Zav¹ol|ÿ\0\ÑòõÄš»o…‹@®V\Ð6—BØ’\'-y\ã\ÑðUA;\é h}_\Îý~œŸ-ž>Zš]cwG\ç:yß–\Ê:ys´\Êò)\ÖÍ·—FK¡/? ¥;†”€H\æ\ÉAÍ«•L‚?-2\êº9|>\Öy\Ïz™2*»<\è9\Åzh›ªu[\Z3U ºÃ\'\Ñ4ifg}§\Ëõryúo˜·~{\è`\Ýù\í\ì\Ü:s¥Q\Ël\Ô%žr`*œ§% ˆyR¨T\ÄvvW“\Ñe\0§¡5yh#A¦M_g\È\nƒ©*WSS¿5Íµ‡Lf–“\\ÁÚŸ=>y;—œó\Ñ<\ïU+„¦F%\Íbžš³\Ö\ZAš¯s\ËAXÎ\rW:¦	\êH\ÄÀFI¥_\'¬”\Å\Æ\î%½\Ú×††²6º9$ƒq:\åòXUó¼=\Ù\Ó\Ó>]K\é(¥¡\Ó\ÓIƒ.^£LZù\éö’¨<Ÿy\ÐU\ß˜e\é\Ä&,©©€96yžHD\ÆñLEN\ÙW\ê\äh˜ý6\Ç\Í\ëöph\0MÑ†w\Í\ìaùýñK\\¹uzK\á(#ª]\0zOÁ\î\'ÿ\Ä\0)\0\0\0\0\0\0!1\"23A#B 4Cÿ\Ú\0\0\0\Æ\äM#\í¾\ã\éÛ‡d6\ï¨ ¶º3v“Oo±\îö¨¶UÖ›\ÊH´z™§Nws\êV\Ãø.r‚XKT®*z›Z[ e{µ]\'o\ËµÉ®\Ì\ã\Òx~\ä\æ1ƒn(2SA±¨ö´\ÚÚªö;§÷US>£Q[z–·\ÔÙ®Üµ{‹5d‚\ã\Zd8«V\Å\âEú\Ç\Å9]o±\Î-\Ä\Ï:¢Ï–™7Y»\Z§šVõ%ÿ\0ôÝ‹u\'Ü½T&…vYm\íbôt»Mp÷[^@\Ü~I2TþP\ßÝŒ8+]¡°úŽi£šßš\ë‰ð=i”°\Öüÿ\0\Ý\Çûw\ÃöUÆ’\Þ\Òü\é\ß\íù¢ð\Öò\æý·ý‹\Õ#0ò\Þ\Æ?¹\×1+-]Y­\È\Ð\à¬#1:–\ZÂ§Á}õi¸.0\éÅ•tó@\Ä\rg\Ìü¬\î»\n©ûGþw\í†Ïž•À.›Iû\Z¶\î\ÐJF\Õÿ\0^…b¬š\ËMU›…ù¶›pu\Ë[¤<YYÁ¸{ð§\ÝWVŒ‹8²¨\Ã#Npnm\Æ\ØÝˆ\ßeœ+K:·ä²³\ëRx¶Å‡æ¼”Y‘µºÝž§†+8k×º#*Ö‰»‡9hy^šSõ\ïö\ß(ø©>G«¼žm¸û\Ú\Ë;®\ì8ºÿ\0¨J»¯™Ôª/’!öP§u\"	YœÁ¦‹4­\Ê6\rü\Í\'\Â”\ÔDø\ÊF\íSrL\âY§»¾\Öø‚/´pBñÿ\0&bWa@­´\ç”if3‘òl\ët\æY\ÌÒ¶\Ö\ÌP!þ\êÀ\Òÿ\0\éÿ\0L&r_\Å=½ƒ~IñJ–-Úˆz¢—µžÚ´‹\Ü&b$3cc1\ä’|\Òc2\Ê\ßm¼D\ÆÑ‚·÷Y\äõ¥û‰•\áÔ¡Fx;ø\âµ\æ•\nŒy¨rL\Ôjý¸ð%uŠ¹žŸYIbt\í”\áh@N0PÁK´5‘11ÿ\0+c*±,fLÑ¶		SÉ\0Ž\Ã`­	\'ÚŸººo—^ª\'s©\Îq3‰€.\ï\ÌnÌ—Ò‰n™\Ö1t\Öa†?\é\\©G\Ô\r­s´R`ð’¾ Lˆ “]^˜\å \ã\ÇS™¡Fam\ÑG‚@ŒØˆ0½G8a\æ6¹~\n˜Ÿ\ã¼jXOL\Ã\ã\ÂužÃž+¬¹D&g´B‚h\îr\Ç\Ìf\"$¢\Ä.IA\à™‚\ÅÀUIŽ\r¶i\Ûq¬¬\Û°Å¬Á[JÓŸl\ÚN°p\ß <	\Ä\à´\àÍ§38€f1\Ûs\ã¸NJó	À\Ý\ËW8w2\0v\åF!\æml B0?c\ã\Ù1FL\Üs\ÌQƒ\Ä\Æ<.\èvgô•³`rMž“`\ä\ØbZ?J76\'§À\\:$À2m•\ÌC\Ûð\"\â7r:-˜‚|™¿l\n\0Xq2#©¶vkGñY¥´Ø“˜¡,h0GŽ!†bT%¾c\Ã\Ã\àeˆ’\Å,fÏ€#LJ††9Š¸Œ\Ð\Í5C	=Å­fõ/¨‚£ûc’#yð˜¼J\ÃÂƒÃ´S\0\Ì\èd±k›‰\"c0œFÀŠ¸‰œƒ\Æ Œa”¦\æOlc\î²â€›T¶_1˜%œ’8A3\Ä8Q\Ûp±{~\Äc¹žs°(\ÌXL\ÞpN\"Œ”\\\Âs7\â	Ÿ:|m,Dm@õ?!n(ü}þ…4~A®½õ\î`d3ö8\àÀ=\ÇÀ¿•N`À€s	ƒ™\ÔqU\ÌvLT\Ì^ab¶\ík,c5Œ\ÂÄ´X¶j\0oºÚ©Tb»\ëX[Ÿi›\Z!ƒ…>ÀC\ÂÁ,ƒ„\ÇÁ0s	\ÚX¨„\à	M>£\Æ\æ»)ô˜™\Ðc5{Ñ¨k\0xÛµ‰\Ò#šL·\Â\\\ê©bV7‚}\Â9\ç÷þL\'3 \Æ\âòr\ÅF\Ù\Ô\å*oM\ë\×\rš»C¶\ïsŽ\nšªMel\'À\0Š±˜Õ’«0\ßP9„,\Úb÷ûñ=™\ÔvØ¤wnU\Ú> FiSbW\í…\Ê\Æ|\Ì\Ä\æ1\Ì\Î\Ð\Ãq·I•¬œ¤vñ\Ã!€\"Áƒ1\Ãq1\Z \ä÷?\Æ&\ØðÆ‚3c\Â\Z~¿lpN`of\ìÎ§gô½;d¬´\íªõ\Ú\Êej\Í.¡Šþ3\é\Ï7…\ÜsŽH\å0\Ç\àe§/¸‰\Ã‘…ð8„’C\ÇXL\Ìòz†	ˆ¾\Ð\Æ2n•W‡¡\"Ò¸zÿ\0ŠSSKWSC\ì…qLq‰\Ò\Äù7\'â§¿\Ü=÷\0É€F9ð ;`\Ú\Ñò Œ`™ƒÂˆð\ÊÄ°	¦q¹Ô—€+þ\r$­\\zQëŽ’\Ñ\Æ\ì\Åø¬yúN^4w’gBdñˆ›A€rO€q<	\Ù\nn	uõ\r/ò\íz\Ó2ºa¦[T±1-ñ‡\àF†W\ß\é <‡‘	xŽ\Ù\Æ\Þ \ä¯\Ä˜¼”‹+”½G\Z,ˆ{ý·,cøN&sj	.\Ðs0\0\Ä0Bs\';\î¾!\Úóa™œ: •Ê»Ó˜½F\ëS.\áfyý9€ÿ\0\Ã6dp;„\âL^I„øA\Éð8»Yœ•‚f)•™SÄ²o–Y\Å\ï,1¡\í½µÑºX|ÿ\0ÿ\Ä\0#\0\0\0\0\0\0\0\0\0 !01ABÿ\Ú\0?’\Ò$¶¸?ÆL’\ì\"¼hDa*ZšÕ•¦¶¶¸Q\ÑBZq\à™t{\æŠ!kV{!…¿gò¢];M&K§”OªGÅ­^“‘½¥f<UÝ‰mnX¢\Å\Ò\Çô}#¾ÄºyEŸD‡™‘F=2”y_9\ãS?™GÔ…\Z\Ó\åeŸ!ºB\Ë\ÜNö¹3Þ–\Ú\ÞWù¨di‘—\ËÁû\É\î^\É=a•j\Ëð^ò9ÿ\0’>µ’-w=•Bf9Z\Ýø¨­3$?F#©—Á¯~¬œ(^Ä¨ù	‹\Å\è»\àûŽ	gDr;#!iˆe\éjù\È\ËE\Ù!Ž¿ÿ\Ä\0\"\0\0\0\0\0\0\0\0\0\0 !1A0Qÿ\Ú\0?Ä”?ÙŒ­\áRùŒ/\Íâ¡¹xXñZ\Èð¶eÇ¤þ+Y.>p”÷Š®$}âº‡z”+‰žhœ@‘Òº _\Ó\Þ+¹ü’É‚›\Õ!ü‡\è_&’›ª¥\'\ÙHœá±²\àñU\É\Ã\á9$¢\ã _ ûÏµ³\ÊF\ÅøöuŽ„6H‰)k\Ø\è\Z)C\Ù.4\é6\â©žË©z\'Z7Šc\Þhñ«M*\n«•C\ãH\ËC \ëEÁn¹\áŒ}\rC\ÌtN_$hœSŸ=^\ï˜<‹ty\ÚQÀ\Ðð†\"”§tZ®\n\î¨*y¤xÿ\Ä\0-\0\0\0\0\0\0\0\0 !1Qaq\"A02‘BR@±Á¡ÿ\Ú\0\0\0?˜\Ò$^F©\à‹ÿ\0\ÝiLK\\F<á²‹¡¸ø”L?(³¡S§¿–%\ØGm\ì•\Ô1{K»d‰€8¿¯„zg(\ÖŽV\n1Šø™´Pp¢\átƒ\å\n\Ân\"Bº\0—(Á\Õ ‹\Ýu:\0¿zê“j‡+©…\ÕÅ‘Ã„¸\Ì÷\"Oª3u\ëAö$6º!a,\ÇUelÁM\à¡Ö€r:¢\è¾E\Ây…ð¢€’\æ%	„#QJ>\nÚ‚Q.¡\Ýz(´)—¤|¢ÔŒ;½6üXb°\ÚB\í†\Ê\æ\Éñ¸Mº‡«s\Õ:\élŒ*!\ÒÅº¢\ZL¨,„žG„7ŠMü¤\"N¢\áBŠúö#\é“ò\Â\"(Z!‘\ÖDB~‘„\ÚM¢„µ\Ô1\Âe?\ÖD&FF	u—L}\Ê\å†,Šeô¡\åP\âv§\Í–e2¿\êõaˆo6L&\ëŠ!\èQ\0\ÐJ&\ß\Î8‘\æl$}#\Ù\á\æôA\Ô&Wy:z|]:}•Ñ¤rŒƒ\Ð8QM½|Âˆ>=“\ä‰Gj\à\æb“0þ\É\ï\'W¡“\Éü§”BN\é\ÐM!\Åf%†\0\çý,=6\êu|\Å\àqFK$\í]\Ì\Ù3¬^\"V/\nÆ‚E\Ø\'L¯2v£š=€ôú{yWž#hS3C>Ð™wY:p²V…e[\æq$IÁW¼\Ì>k4b\ê~Ky´)\Îi\â\ÉlžL›Ê±Z¬“·³ñ]™¦Y\Ó|„¬‰“\æ\æV[É–\ëJ\Ê\ê\êÉ†k%¼žNBò»E\ÖR\Ée^S`+~¦…Y3,\ÙYZW\É7…j§N\ÉüK:,–\é—m\ÕÄ²£º\ë\âé´­š½Ì™ž¦§Oøœ¦ð²µ/\')\çu•.šn³›B\êÉ„\ß\Ê\Õy]…\×rÿ\0’`š‡“	µ¡¤\æm,Ö49-hBrfé¥¼œ¦²\í\nñqió&M\åqS\Íô§e²`¯Uó–‚‹§ð˜\Ø¥Û“—]£”\æ[§NšŽ)\å72e¼¯=Óœå´œ\Ð\ÒgeŒ£}0\Û+Yµ¡\äþ\ÃH\Ëþ&­Óš\\­‚a’jw•\ÓÃšõbrtQz­Œ ¦v«ŠŸ\î‚J`­-©\Â‚û“û\í\È/‹¡w(J\à›\'\Ü+Ó¹—2u\Êe\Û[&r²² \Ð\"\n\ê\Ëu’¸i\0­&V²b\Ñ\r\"\ã\éñ’\í\")ñ&Ò›+\çFé¼¦ó\æ@ÿ\00üU\Ó\ÐDJ\Ù&5;M\è½\Ó\äµW\ç\Ù\Ð\è®.·L3“‡ø•„\å\á4\ÞwQGŒ\Ö;”#“{<ûS•²qù&üd·¬tG1nS…iY\Éý–\Òyþ¬™kF\É\å\ÝúŸ1¨¡\èibü›J\ë=¾B1¾+\rþ}Ž=§ñOõ)Œ\Þm+M•ì­’ct\ZXPh\Ù2\Ú[Ó‡1¢\ìüWžô¼¬›\Ó(E\Ô\"tö€¡\ê\ß\Øhû†©\á.)o|e†R¼šnžn®\ê¿\áE\ÞM67°\Ò\åvþPþ\áP\êo@£ÿ\Ä\0&\0\0\0\0\0\0\0!1AQaq‘¡±Á\Ñðñ\áÿ\Ú\0\0\0?!ªÆœ¡¶š}‘-EŠ·\Ñ\àM5†¶[V\ír2L\Ô±‘Œ\íþ\nj’Ej’	$hŸ“›š>F	mÑ•›,\Ôû11‚JŒdRS\Ê)rƒ¾D‘vžYŒ>AùMöI»d\ÆQ\Ì\Ñ9\á$#\nR†}\n\å£\r‘ZH’RSy±(\\C\ì;lñ\àÝ…cI\áRÆµ£ ,7\Ò\åY‹3\éc4Ò c	\ÛÀBµ\rÒ¿#¦.d5»¾–X+#E\Ïö:yh\áYz>Dd¹ƒ\Ê`‘¹\Z;/0?\ÚÆ”\éA˜Hi|@hF:’‘A˜\Ã=\â)?iÆ¸ù\Ó\É¾¹‘òbO	+\ÄHx>PO\Ó•UyÁn”Á\Ò3®rØ¼Ÿ\Ð\Ý)û#\Êfú\äz:72Xœr$D¥b5\n„ý\æqVe¼ˆS(26¤2mRx	»–°ó>\rý•\ïKdÛ¸û’ r8\Ò\Z=€\Ë!\Â˜ðÆ‚\Õ2KU‚ã™¿£\ÑQ%´¡öJ•†1*8¤S\Ê0§«É§30™Ø±’\ÔN†v›D†rÙŒ)¾K\\{\\ò5¾k\ä\Ã+\êfWÁ…\Ù4œá’‚›À’jH\ä?\Ù	´\Æ\áQ• ¶g@·\Ð\Ö6„˜„Q(ô,ô\ï!®\'bZù3ñ6Y@\ÛØ¡Jˆg\àN\Ñ¼œK!2_‚Ù²,—û\'4<òI\r¢#\"iŠGB‹ö<úˆ\ßdjžþ-V\å\Â\n/RÉœŒ¡ö2r-N\ãc\ÚI¬Je\Û;	\ä²t`.p9¡»¾+\æ@\Î0\ÆÞ²$*~J‰3r‰I\ÉØµ!²1<!©ðN\Ñ	\Ê[\'Uò&6\"ß—Á\Z\å\èY’\Â3*ùD)Á…ñL„\ç/Àú–\Ä\ã#YŒ\á0o\Ò9	\n\Æ2‚ñ”—’\Ãö…Î†‘ø)îŠ¨g#P‰>D€¶AóPY\èˆ\Ük¦Êšd\ê_CI\ç\â\Ò%S1f_,\r>¶¾P»-Á”\ÕN˜‰1eâ‘¿ˆºm˜ö¸™XQDn0fbw¿Œ)‰$è«¤	S¤p6*Mˆ’E/LH\Ä\Õ\"\Éwp\Ïðœ7#‰8LØ²WòP”\ÞGaSŒ+5	\ìJ\Îg¤œ·¡¡­¨‡\é‘¹O&„-˜Áh[ƒ”7\ä˜\ìA\"\Ò|@˜o\èIJ\ÂP\ÞBnšœˆð9‹™S’N\ÉÁrRÉ“\Îb„úQ{ø\Ø%!FY\nM.\Äb\ÝeÙ½–¶3K$g_\èBI‘¦U\ÐÕ³fž„]ù’„¥G8X2\Ûk\â\Ë%’‰œ|\àH\Ãbz\Çb¦TÁ\'IôL\í¥\Ù\"tò¯†W\àRŠ<M32±½el†í‰¤„‘x2Ú½!8\æBv~|±Àór%2°\éT)®B6¤¨—k/¡\à¿\Ðe`{-Rô\Ñ6$5<<ƒ\áG\Ä\Òg¦B\×\Ú\Êr\ÛÐŠ\ÉxP˜[D„¤‚ \ÓjÍ¢Lb\Ä/# …iy‘b ûHgýBªdG±*‰\Ë\äI¦OÑœ’}´eÔ¹‚Ñ´8˜hB=\ÃøhöWò\\XØ‰Nh7K¢\Z†~F\æ\ïr$œ‘\ÂV6‰”$1/‚£ã±²&\Ò+\"œ\ËfW9M­\à€œÁ\ìWV±KñD!%3\å©OhV\ß!•\Ë.ô\â4†ª©\Ù‰Xl6{1zD¡\Ü\Æ\ÍÀñ,B\ÎWB‰\Ë\"±£\'–5P\Ø^MBey%ñ\É\n`“Pø\×\É*+\áŽ2²¬1-i±\'DÝ•\rÂ„—Â±%,a|‚^œ(#l—\í\r¼—L\\c³R\á\ÉP¥ŽD’RU§#ÉžY\\p¹¼(&´™$¤!%\çb\'0\ê>f\Ù&‰‘¶W™¤ú!J<4£hDÌ²´$7\"\×ö?%jÝ’tCž\å\ÉeJ†¼Œ÷Bhs³\àK^\Ìoöv•.H/dEƒ:™‡jZG¸/ø\ZB\Û\ä\ÌxTyÞ¡\'+ð*³\ì‹t \æôo2FOp\Û1……’ýÈ¡È›K²RŽ©\äm2?Gµˆ‘\èM\àBB\Ñ\ÉÀ¥Ü—Ž°YAòIœ`gfB\Ø½A©)\Z¾—§.\Ø\Ë„C\Ëf4Ý•:#‚EµœªÉ’\í±ª°\Ùžò\Ë\Ñ:B9¥´)?\ê¡Gp‡X©f`¹nCdµO’	gÁ7	X™qBS\ì[tH“\Î`¢{ø*Øœ$”\ÌBR\èC-,{w®Œ8\Ù=²<I•\çƒòA\\¶\ámÕƒß­#%\äˆ\ÑGhƒ•1\à!5\\‹r(©g\Ñ!‡\ÓG\rË–\íV˜N\Î\Ï\à.Ê¤…\Î‡x\ÂZY\è:\ä¡>Y„\ä[G\ß~\ÆK?Ir9ô4WŽTg€\å\äT®Â’_Øª,’¤\Û\ä\ÌI&\á,±2/Bz#\æÑ „@-ü$b¬\ÖS´KT‘$ †“ƒ\É\ÏPü\Èk\è„\ÒmRb\Æ „x\Ço¢pE¢Â¢\Òöf\n\ÚýŠ²¼\ï %b^Lh+)\ìU ;\ZKðQ‘½m?\Ñ\Í\rŠšL”	K^„wÄ†0¥ÁS–fCXˆ¯ŽH±8 \Í²\àÜ‡É“¹V5(ŠC)ˆMõ©&¨Ml+Gb\\4­³f…IJD\íŠ\ê+$,4x…o±c.L\æ+·ðö%\ÊðNTwÁ\áy\ËòÈªY\Ø\æš\ÐA\àP¯³RI\'<\åZ\Ü9\ÍÐŠ{Y\ÕSD¹pŒiBH¢Ð­:¡eiy’\'v&ò˜\Ó\Z|‹\ì,˜·\èhOøE”r]|\ÅQ\Ë!\r°<¯\"P²\ìy,¶Å‹fs‚!D’YLU±d\ä\æÅ¦Y\ÑÀüˆ‘×¯‚\æ?\å¢\Èh\å>È\Ò3hc‚r=Š Ô™d©\É\ë\àHqx¬¥\Ñ\Ù\'0šMŸ‘J„Œ«˜žLA¸\ÃpsZØ«¿´N…ŽK\á8xbHdy-ƒ°-\Æ\Ý\Åo¶Bpv9Ÿ\0ŒRÇµØ¤\Ëô”p“È£\0•û‘ P\ÕCÑ°³‡\èivOBn0Yý,–†¶<”Ý°8¢>EKt›tE yNÜ“1\Øô¯*X\ÚHY\äIð<J\é\àÁù \Î	˜ŒòÇ˜ž|np\å\Úø$þü¼;9C…M\ÒÁ\"\Ðd’J\Ø\Ô\ZY\è(\èLð.H1Ô‰£n¼É’Ú¦5PM!œ‰¤P\è¿R_b•-´z!ŒM\n%\Z£#‡Bm\àBU¾\ìe:Ê©Lt$\ÖN\Ö\ÈRûcB–+\Ï@Ù¥\Û\rÃ±`\Ñ6\ÒXÁ	.±8J¿þ0QC\Ür~™\Ê¶7ª•\ÜO‘¨2ÆŒÁ4=–”Q€AfXÉœ%\Ñð)^‰k/a%‘ð9\á®‘e²\\¼0©\Û¤V3È¨Œ¸\äd\0ªÐšJ°‡2*ÿ\0ú3\äl\Æ\Ø\Ü\Þ^E\'bÉ¶\î\Õ\"Êž6‘Y”	—\Îø;—±Mm&\ÂlÁ\nH%o,j¥¡3–5•^\íð„›bÃ¸¹=.$°k!+I,!>„Ù·]\ÅB„¡‰zr5±ô*”³¶rd\ãü˜‰/Í’ ‚\ï„K¡aK/ð{®GN>\ÉehJg#x&A_%\ÉÔ\ÉHŠ1t*@\Ó\ÖY%	p1¢“	@ó‡M‰Œ¸\Û\àlÙ³$·\Æ-r1¡(\\!4©ÿ\0¢¼¡?øFO·BS\à„–‹$»\ÂCW\Ï#8\Z\Ó\Ü!m²$í‹U¶\'–ð7~Œ2ð…‘\Ò\ä°LLŒ@²ºf­“°!©2\Ò.=Œ»‡[óc*šDTmL\Âó`ò2\Ïb¢¢\'lb±Àœ\Ä$u…ƒ	ÞŒ‹³\Îp?Bÿ\0\ÉHIsŒ™\ç¢Û·l¶\'0\æú\Ñ.6^ \\!#à°ŽQs,f\Ñ)÷\â\Ùk‚\Ø\ïøI,†\Ã\ËtÐ¢¬	ú#xE*X±\Ú\\0FI\r¼°‰it+‚%¨\Ñ4]\Ó[$¥„;[_dû‡ŠØ°¼£9ù†O\àð\Ã+$”¼˜q(C±ôHš ,	ŸÒ‰qdUvIn5!ü4}ˆúˆúD¡8T5†¨P¶N=\èø–‘:\ÃQ¡6ý™?„U\n\ÔAG”X®H@­‰fÄ¶p*ÁcbÏƒ‰Eðþ\Æ#pÿ\Ú\0\0\0\0\0z_b\èq¿@·B‚·\Ù\èLh¬¦W‡»\ïõm‘^&x\âiˆŸZ\Üü6j½ö…—Ã‡f¶\ÊSf\î¹‡Om\ï*:jh›ýû\å*A\èIPŠl•\æú\'y”EC\å/>\ãµU~£\'°ñ¦\äW\×\rè¯¹¬³ºÿ\0¨?›Œ‡Œ\ç0gL#¨\Òtgù7§\ßx\Ö0w¼jˆØð©ŸgB–\ãðŠ\ÉJVú\íd\ËŒÇ†½²\×\è? $\ï¶s\Ø\"\ì3/\â½aù\Ô\Êy9¢\Úh*XGkä‹š\ÏY·µ\æ^Š<6#\\P\ÑH\Ãÿ\Ä\0\0\0\0\0\0\0\0\0!1AQaÿ\Ú\0?\Í\Ó\à6§ÇŸ	\ï\ÆmŸ–C³\Zr\ÎY›fl˜»O¤\Èo\'ˆ;\'\Ü\ä0l‘\'À¹,‚\Ûô/^\Û\Ìüƒ»gÀ’~^?Dý\Ø\Ö\Å\ÂË§,\ÈþJœƒ1º\\ñ\Ù\Ù;eœø!¯&\Ø6\É\Ç^.\ï‹OX\î|\Ç\ß\"ŽÊ—lLogÀdP`\ÉEðŒd|]Ú§ôåŸ|½‹I\ì!rñv?l!aþ\Å\äþ#ùóI€¸lþÀ\É%ž\Ø¯Àþ\Ï÷\ìN¥§QŽO\Î>?²\ëò~¢\ß\Ê{\Â\Ë%ËŠŒi,^\Ëmû°\Ì\ß\È>+t\ä,\Ë\Èn˜W]•cv\ÄE‰›öó°\Î#’\álØ”o\Ä1 ö6Ù·\å²–­‡Y–n¾G:\Çö{È $\Æë‘œ\Ãap\"l{ðŽO—¨3\à?‡±<¿ßžõ\ÜBö/\ë)o/\Û\Â0¶ö\ä›\Ä\ÆÛ—\æÀ\Èi/N¦rq\ÖX^¶\\˜ð³ˆžò9\í\ë,•t2¼Oö{x–ÿ\Ä\0\0\0\0\0\0\0\0!1AQaqÿ\Ú\0?Ï›;.YO¶\É<›7üƒl\îÞ§\Ëg$¼\áó–\Ò\ÊßŸ³m\É~+¼‹\×\'%ndOó\ã¦\Úù\Ï\Â\å²\Ûmò^\Û,§<—	m\ë\ã\'\íšHŒùo%/e\è[-\Õü­1/rU¾.3üM[õ/><vC\È,X3§a\Ûy~O	j©\ìPöÓ‘\ïÁ–þP\Æ\Ío°v\Â!9°ø¹Ã«D=™\ánÈºŸò\ï\ìp\ÖFZ¡\Ïd_\ä½\å\Ò$Î’—ÏOY#¬¯„©\É\ç²üeVö]d\äM·{š©\Ë\Ïe\ï\Ê\Î\Ï?\ì™\Ö_\ä8\Û_`\Ã[Þ°Á0$À\äO–~Oˆ&~ËžY½`–ÀzÛ³ßœÞ¤!E\ÅG{>Ù¯\Å\×>\Äÿ\0–°o_-9\Ú\Ô7‘ÉŽø\Ý$\Ú\Z²\êÌ†NÞ£ò\ä5\á\Ív\Éþß´§\Ò\ã\Û.’üø|‹c}½Ž;:`ž<ºL\Í\äó’Þ’\ßp¡(˜Jöÿ\0%\Ø;—„=–òs\ã\Ë€\×!®]9\äK±52aØnB5\Ö[\Ûým\Â\Ç\Û`\Â\Ì\ìöp]<…ò\ßí‘‡lü¿ÿ\Ä\0&\0\0\0\0\0\0\0!1AQaq‘¡±Á\Ñ\áðñÿ\Ú\0\0\0?M\r……nÀñ)\0&U\É\0\å~§\ë¢2—}\á[#b—L&×‹`\Õ=s\î1ô°[y\ë…\êe\×X­g¯$2C¢Š¼\r%\Åx„¡hò7\Ä\ÑBB›P+0\Ý\ãÓ¡Nø~±\n\ÒÞŽ©Žˆ/Op•\Ã—„¸Dª\ÑUB;¥S°\r„£º\r3e¯¦SlC’”ª€7+E\âz\Ø?\â*.\0¾®\ËûÀ†	r\Æ8ˆ1:•\ÚõmARºÖ”8ñr\â\Ðý\Ä\Ò3z¤ø\Ô*\á\ÂY\rs]P‚nÀ\'1\èµ)š\î¥Ás…<$=p—•\rô…À’M<«ÿ\0 \ÙF¼\â!‹\ÔHh+\å,\Ú½MR0\ÐhÞ¾\"]\çõ¥\Z3¹Mù\Ò\Ó$º¨KExf]¨rZ‰sb©gk¯›Š-PCøÔ´¥h9®\ê(3«˜•a\ß;	\Ã\Zû\Äõg>¡új]–¦^\Ð\ém\Ì71e%i¢©3p\ïimó 9jwv@\å+=@Àmq2†¾Å„k@rY-®-E›³\ãú€\ï _Ü³miù‚«D‰1Q}\àJe…§Á)£›`(jÆ“\'‘HG+;\ÚcõV)5\êUZJþ\ã\01½\î£bÞ½K°\Ä\Ð\Ë\Õ\Å\È/$²c™n\Ê@ŒàµK¡¬UµÀ~\Ñ\"µ§\Ã—Á+)\îœYr1\Ô‡\Ð\Ò;d+@¨b¹p÷n‡¶R›G†\ÓU\â+vûôÿ\0\ä¡Y*ör} ¬4±¸¥«\Z\Æ\ã\Ôå¯Š\Ü42\éñ/q¡\r\ê*%a˜\0V¬h¥\Û\n.$T›8\éß©EÕ¹g1ˆû@§–ŽÀ	’½8ñ.x¸©\ãÞ¥*O\Ò*\Åk¾§¢\Ûù…-°móý\ËV÷>\Â©ýJ„\ËPû[yx„G\æv\åï‰ŠnˆŒ^3Á\æp­Q\ÉöüAA-þÇˆ\è\ï‚Ç°««\ê#c€—›þf[ü±Y\Ê@‰¹Q*\nÃW\\€¹Gr°\ï*\Ã\Ú\â[J£\n*±\×\Ðý\"R\È8`hù\â¢QdGˆ1\ã\îT%Ì¾²\Æ\ÒÒˆ\ÔV\Êú2\âý¹€C\n¦\ç\Ø1jò-` XøþbŽ\"Š±¢\í\Ã\Úÿ\02xŽu\Ú«¡mõ\äJ\Ñˆƒ£\Ã8˜­/P\à‚iôK·+^%\×\îqT;\Ð\r‘t³cÕ¸ü\Ê\ÈùShø‡X\îw(t|*p\Û\Ø\ä\â·sa\æ\à`ýÈˆ9\ìñ\Ü@\"\'‡\É(\è°\Ó\îS\nuÌ¥¦6\ë(!Cêš‰O\Ù,M\ã¦Á¥‹%Qò\âXü¤£?˜„\Í\Ê,,d\"€q	hO÷RÄ´|\å¸\Ô<F ”Y\î?h\ßP\Û5•\Þn:VR6}™C\Ë\rpK>±*Ÿ?ð^²ru{\"‹°C†!‡ùWB8Wr4\î\à€\æ¹ÿ\0ŽIZ\ÎN¦o;ŠÇ¶Mš\è–$¥=1›Š|K	6ãº™>°A\êÕ§\ây‹/ˆB†*2ŒÁW\ÔxûƒžP÷‰K\Õt\È×™j¯\Ä\ÇDZ)/\Év\0¿¼U–-Àh\í\Ë\0£¢ˆ@\r•·Xš3ao™\Éh(z¾bW¸‰nþ\Ð !QG\ë\ã‰U2\0;º\æ\\\"\Ý;bK+˜[œžózÂ¦½+Ÿ\ä–KQ\É÷€\Än*‡0h6\à\áy&\"Õ®8•¼#PZ}\È\ÛYJ\rk\ÔPhi†\0\0¨JÍ—Us#@Ð_\Ëõ\Z\ßdó\Ü\n\Ö-\í™-m_‰EU‘\à\ä+?)ÍeŽ£G¤\ÔQÛª€1›\ïR´ô\éP\ÈôÀ\Ù)–Å…‰¢\ëõ\æ;z»”¸\Ü&]G‘x”+8zƒ\ÚxÁn:€•\n\Ð\Å\ÝÁBŽý\\«\Ô\È\ë\ç˜g(^\'•\n\Å³jy%\î—w~£\Þ:‹‰@/=›|KûlYˆ¤™„\ÌWÜ‘k YU\Ô\Í¢€J\ÝóS•‹;tŠŒ¼*½&5¨\ï~e\á‰v¾!@Ü±2\nÙ„2\ì>]J7\å¾#†_±ŸP¬•»\\,>\Ô\ær±°d\Ó¬P;H†j‘gL¢†b\î«þ\êR¬±€ˆ®T·R\Ù\æ\ïøG\Ôkž`H\ÕA\á ð=Œ&ŽFª\ëio©‰ñµ„\ÅÍ—\äÌ¦\ê\Z\ß%~å¨£vøfkŒJ*¦\æw\ÂX¡‡\ß\Ï\ÍNB+–y\ÚD@lÄ®ŽˆN¦\ëCawgðY»)\í//\ÚZ\Õk-\áÀ†.^ˆ²¡ŸIÓ‚`yN\0.a‚÷O3ŸJ{2°;•Q•%°q´\Ä\ÈZhþ VÂ±U\nS\ÕL0“5+k8ˆ3‚$ªU\â` ¹•,ºˆoÇ©jEªÆˆc\Ä;¦\"\Z¡ª\Û\Éô†\ÂP)\á”A95\æs-øA[\ãY¶8`\Ñw™U\×0\Å\\}ñ.røP lªi‚€b\èöÁ,1§©‘\Ä8!ª™\n\à¨KK?\ÉüB¬\ã\\¸F?¡-—¥Á*\ß:\è…B»IýEg\ÄJÕ™½±}AÌ¸\n`%eŠ3\ä¼.-Xz€\ï,‹\âu£o/c¸\nn<s0§K\r¢¦RbZ_©n£\à“\Úd™ ]¥\ÜvÃ§ˆD\'ú—R”\Òü\Êm\\³´\Ë\r³–\"ÞœDJ7\Ï?“_\Ì@\rv´VÂ–­\î6\rôeˆ<†C\×ó¿<	ŒW·˜eFm¼\"Ñ†+‹™JÐ†nZ\ß1˜-(ù|\Ë\Ë1\âõ/Ð¯=M.\Ãp•!ò, ¼§Ø³dü\Üp\"\ì:`\×1#\å\Õ\Ì\"–\àPŒ¯\Ä`…o\n\ïC‚ZŸd.1\ê=Es)\Ô6¬b\æ†a¦:6ƒœB”h\\ÁfW \à–gmôq*\å(e\ê]J6\'\Zq¶\æ£µ¨Š\å\ímf\Ôs\Í°&üžñY\Í÷!\ÒÜ›/\ÍÀ\à^\ÝD(_ù	—06r`“Â¡öá½ª%†\Ç{†\Ñ¬\Éeª\æÓ·w\åñ°\âk\î\ÇÃ‘ö±3`oÇˆqm7ˆce4\ÌU\r•Óˆ\n¸®  Xe\í\å‡ ~\n\ÈEG\Z\Ë’›\Ã$Æ¥\á-tß©J\íFu2¿\ÖõP!Z3QE@\Êˆœ‡uŠø\Ì\Ê(,pn\0½\ã.	‘T4f;\05FYÀs\Ú&À\Â\Ë£S)”t|J\Úd\íÒŸÄ¼D\Ù+\î@kiâ¬–¦«\Ç\ÕnjœH\ÅE‡ú\â< Æ«},¶ \r«–FT¸W~¥†\Ï\0G¹l9ef\ã¸œ7_¶L*a€—õfJó\\zb\í\ÐF\ÜFV±ò\í\à—Emeõ\Ô\Þq\ÌU?\03’#\ãK¸cC]9€S^\ÊzùdY_\Õ\ãôþ\åf™rüÀ]lH-~&½Á žûŒ	‡õ.ÊƒŽX(\ãy˜ˆgÐŒ.OO0\ÌX\äü²\Î•2”6^_\î %\nõqUV\Ú:—®NF\íñ=Ô‡\ÄoM‚|E\æm¦\ÔkVô#	Ýµƒ)Ûž\Ø\Æ\r#–½VZ}¢Z¢\â\ØÁEù\á×™T,\æ\â¹\áa¢d\ß¥ñy=\ÊsnÑª\Ðh\Â\ÒÃŽú†\Ý+º-›4±pfÿ\0IR\Ôò”\'bóx…n‡R\ÐcS\â®VºVj\×úŽ¬t\Ô—\n>Œ~n#A\Ï÷\Þ&\n\Â\á\Õr—€w\êYc\Øþ<ÁH«~\ØqƒÁ»ñ@ð\ã»#’ÿ\00‰\ß+\â\n@·}V\è\ÊV\Z\Æ\Þ5eP\Þ9ñ*o\áP9\Z²8YM\ãXÉ¨›ö\ì›\É\Õ\Ü7Æœ\ê7\Ô--zr\æ@k\ËÃ¹CZ0_>Yp—\Ðþÿ\0\ê\ÕT.ƒX\"üWˆ\Ë²‘MþbÂ¼òÄ¯Jp<\Å\Ètye‚ªo,-M\Þ`‚¾°uöó1®{\â\ì\n‡\æ$\ZV^Ì¨.Ì¤\02\ÙôyzS\Þ2¼JR`û\Çÿ\0RÂ¦8¢\ÓEyõ\î+\à€?¹`¹-=Â³\Î»„T\Ïö\æ+ƒÁ¶\Åi\nœƒ.þ&\Ø\ã, †’­§\é;uk{‚uZO\æ:*`\\òã°ºµ\Ëx€65¬ƒÁ¨>R\ç}3B>\É‹R¦þ\Ð`ñ\æQ\ê[V\íw9Aª^W¸\àpÁ\î2ƒƒJå›–{œ§€÷!e\ÜÁ«—úˆ\Éi¤¥ŽÈ©.¬}\î%Š9306\åF\â¼ZõýG\Ô~\0\Òo\é4p\Õ\Z m9ü0\Öç™…,¸˜hÿ\0\ÄRú;ñýÄ–\æ4ye\Ëg±‚\n\Z\\ûˆ\Û`û\Ë|\Ì‰fDFº³>¥ˆP\Ýõš\ÓOo3\'NKc|\Ð‡÷=Kp£\Í\ÆtwTŽ\Ø	8(2ö\Ü!Øª_ñ(^)Äªµ«¢	[\Ðw²¸ýEWÀ=Å½X\ç\Ë\rHº\Êö±¶oP\Ò\Ù5Žb\È89ö\Ë{¨0\ZO\ÆY‘³w\Ü\á—\0 \"h\ã\Ë7‚wÔ¦•¾\î«No¹f­,0RW¦FG³_H63Àc$\Î×¨šT.À\ß\Ôu·\åvÀ½½R81\É/¢\ØÆ¥\n™¡\ß22>¢k]j½À$8-ÄµB\Üqp”$\Èø\çú”¿\Ý—¦)[\ÎW6ÍÁðh:¿0\n^\Ó%\Å,T‚¥%vric UU#§o+–™˜˜À·\Ô·_=Àm¡lq\Ô%¥es”ôK)[\åa4:\éù†z†\Çlñ¸\Ûc\ìøˆH«ýM®ú\'!A\×r ø\âpXñg\í r\ÙV‡+,g\äQÁ»œ?¾05(é“Š\ÅL©ƒ54Å©~ÁJ]ùb/ûÀ˜LÒ²Z—4P·\'ˆ\ÑQün\r1Öe€ZˆÛ\æmQ\á9–k?Ú±…ýH¬):Yõ‰DšlûL\å³9\îJ°¬nóPl±X\'‚«ö”Œ~”¨ð–S¢#1iô˜‘^\ëû™kÆŽüD\âÜ¼\æ(ß¬\Ù\á%7\ÐAsx˜;™\Æ\\Á)/\Ë\ê\Ür\Ð\ås\\D‡u\î\'[\é\Ú\èñ\0\ã(\ã¹rA}\Â\nš\Ô\ê`\0Ý½ø‰G ®g3nm\íe—6§øš\à²ú{ˆ™cRÀ\Í\à\ÑvÀrNfK—2\ß!*¯óªqu´÷0g.¾f\Ø/oR\Én\ËU+²_\É\ì€\0\ÝgÓ“\ë\È\Ã\Ï\ÉRwˆY¹™K\0÷˜v¿0u_|ý\æ\çF\ÏQó8¬ûc»ë§‰\Æ?À–%„ù\"ozü\Ãø€˜½Dð\Í+sûf\nôœ,ª\ë9b&E¥\Ñ\Ñ(`kßq%µ«\×^\â¡`»þ\å&P\ãÔ @€Þ”OÇˆ[‡ŸP8Ç®^&\ËX<ý\Ðr\Å[¨¨•¬¸yŠµi\Ê2\Ô4‰ß¯2‹9`_pv4\å\æ½N\Â\âŒc¸%U:L2Œe\Ñ\Ï\ÖWObÿ\02\ÒZ[_˜tˆYñ¯\î¦H\í±(…\Ý\ï\àˆ—(\î¥\Òu(5kL¡\ÇaÇ©¼\×O1C\Üs|ˆU8&^Ÿ\æP\æ\Ô-ó\à<%\Ë\ÑüÎˆmIK\ã~`7H™·qX\Ø\Ë\ÌUó\Ö2\ÍVþ\"ª%Ý¯q¹G¸\ï¯R\æ\å0y{•Lšp±\n‚\êG\Õ\Ñ!\é\Ë\ÂR\ãX¿¬ÁFbR\Ð¿\Æ\ÙqZ”SÀ”“\î8SycYÀ}\å(ž\ÖvÁ.\ï(Ð¦™Yb/6y®\"\nG,ž\Òö\ÊñsDSº”\ç/P¢­T\ÚÖ¦\0x\ÌÀ\'\ì\Ë\È>\Ê\0\Ø\ä\"¬9_\âVJ	ŸFR‹¥ŽNR\'mo¸,ùL¿S%«Á°¿l\Â{J\ïó.³þlÿ\0p•71€„N›\ÞtLÁ¯\æ ­b°WA\è`ól*ò»•mvˆ,¬B‡YBñ\á™^e\áV†´\î[È—¸´*\×~\"\Z\ÖV\"ƒ+Š`„ß¢Q\É[•´Á\Ôo\è mbØ¥\Ú+}\í‰\\%–\Îôx	Np)\ê6\Ã.v}\"MC‘§\é)¡\0QÀÄ o;\î=¥z–C)O‘\ïÔ¸µj\Ñ×¸\ÜõÖœÀ\å8ò\ç§\ÜN“l©*\n‹ŸÁ(}ž\Ò\Ñv*\0-\ç\Ê*Vt\ÔQ´\å\ZQg\Ñ\ÏF\ró|°C\â«ó67=3*\ëû–\Õ\Ù)g\Û6\'‡Ž\å;\ß\'ŠŽmJ;\rT3£ñ.\ë1\Â]´u!-«¢Wl´”Wl»\ÖfIo\Æå”>£\07ž\Ø\Âðy‚Q\0=À³`Áj\äÿ\0¸…ª…\Åþ`½\àûùˆ§Aù%µ´\ìAe_ÀôCx\nhþfn7Â£\Ìóx\Ã~¿\rõ\å\Òv:†\åÁ¸	TÕ€9†\Ù4D³m÷Nóo·¨„	?–7:_»\í”`EŸˆ€]²\\C8a˜­\Ý¡nd(\Ø9©œb.–&\Ø\n*ð$€`:Œ9\"k†ë¹•\ä\â\n\Ó,<\Ö2|²\ÅnŽx—q‘–ca_hfeû\Ë\Óòfz­\Ã\Ðú@\Õ\ï\Ü\Ã2ñ€v\ì``\Ïp[ ¾|{ŽŒ\âV\à>:<Ëµšl\îZOö%\Øl\röç‡:÷•œ\å\\©CTfß±\çóª£\Ér€d\æ-‹¬OOð;”\\ó‹”¡´\è\à–h‘n”M‚”=Ä«j\å{Ž		\Ç\îR«Jæ‰¦ &#2Ža\r\n; T\Ñ(\0\\#G´Cz;:—\á|—\Ê\ÞOÔ¸¸z\"°v{bšZBÿ\03Œs\ê,t¼\Ê\Å>\é‘Z\Î\n­™k\Ë]©- »‡RžS£\Ñü\Ë®<°¨z\ÝÃ©fùy…f\ç§^eº^\ì¿Ìª»¿\Ú7-CŒ£f½O\é–^´W¸ý8l\è‰lÃƒ\ÄÉvðE[r\Úþ Q=û–§\rü\Å`\Ùj\ã¿0L¨¯\ÌJÐ®ú%*\ç\\\â	ñ@~\Ó…\Z‡\Èññ˜S3®`oNþ\rJ]\'\æ`Ê“LÉ‡ˆ©‚\Ö\ì\Ü\áQ\ê\"1B¼+:£7€w-\roœ+¶\n°\î\å\ÜüJ\ZAx¦\ß\ÔÎŒûfmš{gEG¨\á¾\ã¡×‰ˆ\Ú\ç¸,HÀ¬En\à|Ÿ¹bÜ»¸w\'o,\ÈÞ¡\æ%\ëm\æP@ÍŽX\0r\àJC\'¶<\ç¼À6p\ÕEc uPE?ð\Ä(%0-Dx®\ã5q:ñ*]lL\n<\â#\Æ\ÕðEƒƒ\ßr«–Ù6ñ‰½\Úi–Z\é~„r\è¬\Ä<=Ë•NwÇ‰F¼b0t_Aü\ÎFƒñ,jQ\É\à\ê·ø ³Æ°\æ6ÿ\06\0©À-Ï¢UxÓˆY­\è(mC\0ñ\Ü\\×•?\ên„X\Ïr‹ÁY[ƒKñþ&y6ÿ\0d\ÆVÿ\0s\0Eû…^U¸6YˆŽ9Œ\0\Ì\ÝÂ¢¯ˆ(e~b\Èw	vÿ\0,¥\ÑY\æ adµÐ¿»(\ÒJ8ó	Àk«”\0r¼õ0§³ÖŽ¥›\rL@¶\Î\'ÿ\Ù');
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
  `aÃ±o` char(4) DEFAULT NULL,
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
