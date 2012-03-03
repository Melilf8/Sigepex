CREATE DATABASE  IF NOT EXISTS `sigepex` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sigepex`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: sigepex
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ius_sigepex`
--

DROP TABLE IF EXISTS `ius_sigepex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ius_sigepex` (
  `ID_IU` varchar(100) NOT NULL,
  `ALIAS_IU` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_IU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ius_sigepex`
--

LOCK TABLES `ius_sigepex` WRITE;
/*!40000 ALTER TABLE `ius_sigepex` DISABLE KEYS */;
INSERT INTO `ius_sigepex` VALUES ('frm_admin_ius_por_rol','Administracion de Pantallas por Rol'),('frm_admin_mensajes_ayuda','Administracion de Mensajes de Ayuda'),('frm_admin_roles','Administracion de Roles'),('frm_admin_serie_documental','Administracion de Series Documentales'),('frm_aprobar_prestamo','Aprobar Prestamo'),('frm_aprobar_remision','Aprobar Remision'),('frm_consultar_prestamo','Consultar Prestamo'),('frm_consultar_remision','Consultar Remision'),('frm_inicio','Pantalla de Inicio del Sistema'),('frm_llenar_remision','Llenar Remision'),('frm_mantenimiento_usuarios','Administracion de Usuarios'),('frm_parametros','Parametros'),('frm_reporte_prestamo','Reporte Prestamo'),('frm_reporte_remision','Reporte Remision'),('frm_solicitar_prestamo','Solicitar Prestamo');
/*!40000 ALTER TABLE `ius_sigepex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `ID_ROL` int(11) NOT NULL,
  `DESCRIPCION_ROL` varchar(45) DEFAULT NULL,
  `NOMBRE_ROL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador SIGEPEX','Administrador'),(2,'Funcionario SIGEPEX','Funcionario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `ID_PARAMETRO` int(11) NOT NULL,
  `NOMBRE_PARAMETRO` varchar(100) NOT NULL,
  `VALOR_PARAMETRO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES (1,'MAX_DIAS_PRESTAMO_EXP',15),(2,'DIAS_PREV_TO_SEND_MAIL',3);
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nxview`
--

DROP TABLE IF EXISTS `nxview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nxview` (
  `ID_ESTUDIANTE` int(11) NOT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTUDIANTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nxview`
--

LOCK TABLES `nxview` WRITE;
/*!40000 ALTER TABLE `nxview` DISABLE KEYS */;
/*!40000 ALTER TABLE `nxview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ayuda_iu`
--

DROP TABLE IF EXISTS `ayuda_iu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ayuda_iu` (
  `ID_IU` varchar(100) NOT NULL,
  `IU_TEXTO_AYUDA` mediumtext,
  PRIMARY KEY (`ID_IU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayuda_iu`
--

LOCK TABLES `ayuda_iu` WRITE;
/*!40000 ALTER TABLE `ayuda_iu` DISABLE KEYS */;
INSERT INTO `ayuda_iu` VALUES ('frm_admin_ius_por_rol','En esta pantalla puedes asignarle a un rol de usuario las pantallas a las que este puede tener acceso dentro del sistema. Para asignar pantallas de acceso a un rol de usuario debes ingresar el numero de rol y presionar el boton Consultar, luego debes seleccionar las pantallas a las cuales quieres que el usuario tenga acceso y presionar el boton Guardar. Cuando quieras agregar o quitar pantallas de acceso a un determinado rol de usuario, simplemente marca o desmarca las que desees. Luego presiona el boton Guardar.'),('frm_admin_mensajes_ayuda','Esta pantalla esta diseñada para que puedas modificar los mensajes de ayuda que aparecen en cada una de las pantallas. Para modificar un mensaje de ayuda debes ingresar el ID de la interfaz y presionar el boton consultar. Luego cambias el texto del mensaje de ayuda y presionas el boton Actualizar.'),('frm_admin_roles','En esta pantalla puedes consultar, registrar o actualizar un rol de usuario. Para consultar un rol de usuario debes ingresar el numero de rol y luego presionar el boton Consultar. Para registrar o actualizar un rol de usuario debes ingresar los datos que se te solicitan.'),('frm_admin_serie_documental','Esta pantalla esta diseñada para administracion de series documentales. Para agregar una serie documental debes ingresar el identificador y el nombre de la serie documental. Luego presionas el boton Registar. Para actualizar el nombre de una serie documental debes ingresar el identificador de la serie documental y el noevo nombre que sera actualizado. Luego presionas el boton Actualizar. Para eliminar una o varias series documentales, las seleccionas del listado de series documentales y luego presionas el boton Eliminar.'),('frm_aprobar_remision','...'),('frm_consultar_prestamo','...'),('frm_consultar_remision','...'),('frm_inicio','El sistema SIGEPEX es un sistema de gestion y prestamo de expedientes estudiantiles del Archivo Especializado de Expedientes Estudiantiles del Departamento de Registro de la Universidad Nacional.'),('frm_llenar_remision','...'),('frm_mantenimiento_usuarios','En esta pantalla puedes consultar, registrar y actualizar las informacion de un funcionario como usuario del sistema. Para ingresar un funcionario al sistema SIGEPEX debe digitar toda la informacion requerida.\nPara actualizar un funcionario  debe ingresar la identificacion del mismo y presionar el boton Consultar.\nLos funcionarios no se eliminan del sistema, unicamente quedan inhactivos, en tales casos cambie el estado de AC a IN, luego presione el boton Actualizar. Para autentificar un funcionario este debe existir dentro del sistema, en tales casos cambie el estado de IN a AC, luego presione el boton Actualizar.'),('frm_parametros','Esta pantalla esta diseñada para que modifiques parametros del sistema.  Como por ejemplo los dias maximos para la devolucion de un prestamo de expediente. En tal caso debes ingresar el identificador del parametro que te aparece en el listado de parametros. Luego ingresas el nuevo valor del parametro que deseas actualizar y presionas el boton Actualizar. El nombre del parametro no se modifica porque el sistema lo utiliza de forma interna.'),('frm_reporte_prestamo','...'),('frm_reporte_remision','...'),('frm_solicitar_prestamo','...');
/*!40000 ALTER TABLE `ayuda_iu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `ID_FUNCIONARIO` varchar(10) NOT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  `CONTRASENA` varchar(10) DEFAULT NULL,
  `ROL` int(11) DEFAULT NULL,
  `ID_DEPENDENCIA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_FUNCIONARIO`),
  KEY `ROL` (`ROL`),
  KEY `ID_DEPENDENCIA` (`ID_DEPENDENCIA`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`ROL`) REFERENCES `rol` (`ID_ROL`),
  CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`ID_DEPENDENCIA`) REFERENCES `dependencia` (`ID_DEPENDENCIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('18','daniela','vindas','loaiza','danielavindas@hotmail.com',1,'dani',2,1),('20','vale','vindas','loaiza','valevindas@hotmail.com',1,'vale',2,3),('22','hugo','vindas','bolaños','hugovin@gmail.com',1,'hugo',2,2),('3','David','lopez','jojo','murdoc@hotmail.com',1,'david',2,2),('7','melissa','loaiza','fonseca','melilf8@gmail.com',1,'xxx',2,4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_remision`
--

DROP TABLE IF EXISTS `lista_remision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_remision` (
  `ID_LISTA_REMISION` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_RECIBIDO` datetime DEFAULT NULL,
  `ID_FUNCIONARIO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_LISTA_REMISION`),
  KEY `ID_FUNCIONARIO` (`ID_FUNCIONARIO`),
  CONSTRAINT `lista_remision_ibfk_1` FOREIGN KEY (`ID_FUNCIONARIO`) REFERENCES `funcionario` (`ID_FUNCIONARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_remision`
--

LOCK TABLES `lista_remision` WRITE;
/*!40000 ALTER TABLE `lista_remision` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_remision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expediente` (
  `ID_ESTUDIANTE` varchar(10) NOT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `ID_TIPO` int(11) DEFAULT NULL,
  `ID_SEDE` int(11) DEFAULT NULL,
  `ID_ESTADO` int(11) DEFAULT NULL,
  `ID_FUENTE_BD` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTUDIANTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
INSERT INTO `expediente` VALUES ('1','melvin','sibaja','sibaja',1,3,1,12345),('2','luis','lolo','granados',2,4,1,12345),('3','ariel','rojas','lopez',3,1,1,12345);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleta_prestamo`
--

DROP TABLE IF EXISTS `boleta_prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boleta_prestamo` (
  `ID_BOLETA_PRESTAMO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_PRESTAMO` datetime DEFAULT NULL,
  `ID_FUNCIONARIO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_BOLETA_PRESTAMO`),
  KEY `ID_FUNCIONARIO` (`ID_FUNCIONARIO`),
  CONSTRAINT `boleta_prestamo_ibfk_1` FOREIGN KEY (`ID_FUNCIONARIO`) REFERENCES `funcionario` (`ID_FUNCIONARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=569 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleta_prestamo`
--

LOCK TABLES `boleta_prestamo` WRITE;
/*!40000 ALTER TABLE `boleta_prestamo` DISABLE KEYS */;
INSERT INTO `boleta_prestamo` VALUES (7,'2004-10-11 00:00:00','7'),(123,'2006-11-11 00:00:00','20'),(345,'2009-09-12 00:00:00','18'),(567,'2012-02-23 00:00:00','22'),(568,'2012-02-23 00:00:00','3');
/*!40000 ALTER TABLE `boleta_prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_estudiante`
--

DROP TABLE IF EXISTS `tipo_estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_estudiante` (
  `ID_TIPO` int(11) NOT NULL,
  `NOMBRE_TIPO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_estudiante`
--

LOCK TABLES `tipo_estudiante` WRITE;
/*!40000 ALTER TABLE `tipo_estudiante` DISABLE KEYS */;
INSERT INTO `tipo_estudiante` VALUES (1,'bueno'),(2,'malo'),(3,'pesimo');
/*!40000 ALTER TABLE `tipo_estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea_prestamo`
--

DROP TABLE IF EXISTS `linea_prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea_prestamo` (
  `ID_LINEA_PRESTAMO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_BOLETA_PRESTAMO` int(11) DEFAULT NULL,
  `ID_ESTUDIANTE` varchar(10) DEFAULT NULL,
  `FOLIOS_PRESTADOS` int(11) DEFAULT NULL,
  `FOLIOS_DEVUELTOS` int(11) DEFAULT NULL,
  `FECHA_DEVOLUCION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_LINEA_PRESTAMO`),
  KEY `ID_BOLETA_PRESTAMO` (`ID_BOLETA_PRESTAMO`),
  CONSTRAINT `linea_prestamo_ibfk_1` FOREIGN KEY (`ID_BOLETA_PRESTAMO`) REFERENCES `boleta_prestamo` (`ID_BOLETA_PRESTAMO`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_prestamo`
--

LOCK TABLES `linea_prestamo` WRITE;
/*!40000 ALTER TABLE `linea_prestamo` DISABLE KEYS */;
INSERT INTO `linea_prestamo` VALUES (8,7,'9',9,9,'2008-08-11 00:00:00'),(9,568,'9',9,9,'2008-08-11 00:00:00');
/*!40000 ALTER TABLE `linea_prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie_documental`
--

DROP TABLE IF EXISTS `serie_documental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serie_documental` (
  `ID_SERIE_DOCUMENTAL` int(11) NOT NULL,
  `TIPO_SERIE_DOCUMENTAL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie_documental`
--

LOCK TABLES `serie_documental` WRITE;
/*!40000 ALTER TABLE `serie_documental` DISABLE KEYS */;
INSERT INTO `serie_documental` VALUES (1,'Cedulas'),(2,'Titulos Universitarios'),(3,'Equiparacion de Titulos'),(4,'Retiros Justificados'),(5,'Empadronamientos'),(6,'Fotos'),(7,'Expedientes'),(8,'Titulos Universitarios'),(9,'Titulos Autentificados'),(10,'Titulos de Colegio'),(11,'Certificacion de Titulos'),(12,'Resoluciones de la Universidad'),(13,'Retiros de Cursos'),(14,'Fotocopias de Titulos de Enseñanza Media'),(15,'Actas de Graduacion');
/*!40000 ALTER TABLE `serie_documental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interfaz_usuario`
--

DROP TABLE IF EXISTS `interfaz_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interfaz_usuario` (
  `ID_IU` varchar(100) NOT NULL,
  `NOMBRE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_IU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interfaz_usuario`
--

LOCK TABLES `interfaz_usuario` WRITE;
/*!40000 ALTER TABLE `interfaz_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `interfaz_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iusxrol`
--

DROP TABLE IF EXISTS `iusxrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iusxrol` (
  `ID_IU` varchar(100) NOT NULL,
  `ID_ROL` int(11) NOT NULL,
  PRIMARY KEY (`ID_IU`,`ID_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iusxrol`
--

LOCK TABLES `iusxrol` WRITE;
/*!40000 ALTER TABLE `iusxrol` DISABLE KEYS */;
INSERT INTO `iusxrol` VALUES ('frm_admin_ius_por_rol',1),('frm_admin_mensajes_ayuda',1),('frm_admin_roles',1),('frm_admin_serie_documental',1),('frm_aprobar_prestamo',1),('frm_aprobar_remision',1),('frm_consultar_prestamo',1),('frm_consultar_prestamo',2),('frm_consultar_remision',1),('frm_consultar_remision',2),('frm_inicio',1),('frm_inicio',2),('frm_llenar_remision',1),('frm_llenar_remision',2),('frm_mantenimiento_usuarios',1),('frm_mantenimiento_usuarios',2),('frm_parametros',1),('frm_reporte_prestamo',1),('frm_reporte_remision',1),('frm_solicitar_prestamo',1),('frm_solicitar_prestamo',2);
/*!40000 ALTER TABLE `iusxrol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede_universitaria`
--

DROP TABLE IF EXISTS `sede_universitaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sede_universitaria` (
  `ID_SEDE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_SEDE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede_universitaria`
--

LOCK TABLES `sede_universitaria` WRITE;
/*!40000 ALTER TABLE `sede_universitaria` DISABLE KEYS */;
INSERT INTO `sede_universitaria` VALUES (1,'san jose'),(3,'Cartago'),(4,'Omar Dengo'),(6,'Guanacaste');
/*!40000 ALTER TABLE `sede_universitaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea_remision`
--

DROP TABLE IF EXISTS `linea_remision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea_remision` (
  `ID_LINEA_REMISION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_LISTA_REMISION` int(11) DEFAULT NULL,
  `ID_ESTUDIANTE` varchar(10) DEFAULT NULL,
  `NUMERO_ORDEN` int(11) DEFAULT NULL,
  `CANTIDAD_FOLIOS` int(11) DEFAULT NULL,
  `OBSERVACIONES` mediumtext,
  `ID_FUENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_LINEA_REMISION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_remision`
--

LOCK TABLES `linea_remision` WRITE;
/*!40000 ALTER TABLE `linea_remision` DISABLE KEYS */;
/*!40000 ALTER TABLE `linea_remision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependencia`
--

DROP TABLE IF EXISTS `dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependencia` (
  `ID_DEPENDENCIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_DEPENDENCIA` varchar(45) DEFAULT NULL,
  `DESCRIPCION_DEPENDENCIA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_DEPENDENCIA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependencia`
--

LOCK TABLES `dependencia` WRITE;
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
INSERT INTO `dependencia` VALUES (1,'Atencion a Estudiantes','Atencion a Estudiantes'),(2,'Administracion de Expedientes','Atencion a Estudiantes'),(3,'Expedientes Estudiantilies','Expedientes Estudiantiles'),(4,'Soporte Documental','Soporte Documental');
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuente_bd`
--

DROP TABLE IF EXISTS `fuente_bd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuente_bd` (
  `ID_FUENTE_BD` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_BD` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_FUENTE_BD`)
) ENGINE=InnoDB AUTO_INCREMENT=12346 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuente_bd`
--

LOCK TABLES `fuente_bd` WRITE;
/*!40000 ALTER TABLE `fuente_bd` DISABLE KEYS */;
INSERT INTO `fuente_bd` VALUES (12345,'Nxview');
/*!40000 ALTER TABLE `fuente_bd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_expediente`
--

DROP TABLE IF EXISTS `estado_expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_expediente` (
  `ID_ESTADO` int(11) NOT NULL,
  `NOMBRE_ESTADO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_expediente`
--

LOCK TABLES `estado_expediente` WRITE;
/*!40000 ALTER TABLE `estado_expediente` DISABLE KEYS */;
INSERT INTO `estado_expediente` VALUES (1,'prestado'),(2,'libre');
/*!40000 ALTER TABLE `estado_expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sigepex'
--
/*!50003 DROP PROCEDURE IF EXISTS `ST_AYUDAIU_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_AYUDAIU_BUSCAR`(pID_IU VARCHAR(100))
BEGIN 
      SELECT ID_IU,IU_TEXTO_AYUDA
      FROM AYUDA_IU         
      WHERE ID_IU = TRIM(pID_IU);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_DEPENDENCIA_LISTAR_TODAS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_DEPENDENCIA_LISTAR_TODAS`()
BEGIN
      SELECT ID_DEPENDENCIA,NOMBRE_DEPENDENCIA,DESCRIPCION_DEPENDENCIA FROM DEPENDENCIA;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ESTUDIANTE_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ESTUDIANTE_BUSCAR`(pID_ESTUDIANTE VARCHAR(10))
BEGIN 
      SELECT
        e.ID_ESTUDIANTE, e.NOMBRE, e.APELLIDO1, e.APELLIDO2, e.ID_TIPO, 	

e.ID_SEDE      
      FROM EXPEDIENTE e 
      WHERE ID_ESTUDIANTE = TRIM(pID_ESTUDIANTE);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_AGREGAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_AGREGAR`(pID_FUNCIONARIO VARCHAR(20),pNOMBRE VARCHAR(45),pAPELLIDO1 VARCHAR(45),pAPELLIDO2 VARCHAR(45),
                                        pEMAIL VARCHAR(50), pIDESTADO INT, pCONTRASENA VARCHAR(10), pID_ROL INT,pID_DEPENDENCIA INT)
BEGIN
      INSERT INTO FUNCIONARIO
        (ID_FUNCIONARIO
        ,NOMBRE
        ,APELLIDO1
        ,APELLIDO2
        ,EMAIL
        ,ESTADO
        ,CONTRASENA
        ,ROL
        ,ID_DEPENDENCIA)
      VALUES(
        TRIM(pID_FUNCIONARIO)
        ,TRIM(pNOMBRE)
        ,TRIM(pAPELLIDO1)
        ,TRIM(pAPELLIDO2)
        ,TRIM(pEMAIL)
        ,pIDESTADO
        ,TRIM(pCONTRASENA)
        ,pID_ROL,pID_DEPENDENCIA);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_BUSCAR`(pID_FUNCIONARIO VARCHAR(20))
BEGIN 
      SELECT
        f.ID_FUNCIONARIO, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.EMAIL, f.ESTADO AS ID_ESTADO,
        CASE WHEN f.ESTADO = 0 THEN 'IN' ELSE 'AC' END AS ESTADO,
        f.CONTRASENA, f.ROL AS ID_ROL, r.NOMBRE_ROL AS ROL, f.ID_DEPENDENCIA,
        d.NOMBRE_DEPENDENCIA AS DEPENDENCIA       
      FROM FUNCIONARIO f 
        INNER JOIN ROL r ON f.ROL = r.ID_ROL
        INNER JOIN DEPENDENCIA d ON f.ID_DEPENDENCIA = d.ID_DEPENDENCIA
      WHERE ID_FUNCIONARIO = TRIM(pID_FUNCIONARIO);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_BUSCARXNOMBRE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_BUSCARXNOMBRE`(pNOMBRE_FUNCIONARIO VARCHAR(20))
BEGIN
      SELECT
        f.ID_FUNCIONARIO, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.EMAIL, f.ESTADO AS ID_ESTADO,
        CASE WHEN f.ESTADO = 0 THEN 'IN' ELSE 'AC' END AS ESTADO,
        f.CONTRASENA, f.ROL AS ID_ROL, r.NOMBRE_ROL AS ROL, f.ID_DEPENDENCIA,
        d.NOMBRE_DEPENDENCIA AS DEPENDENCIA      
      FROM FUNCIONARIO f
        INNER JOIN ROL r ON f.ROL = r.ID_ROL
        INNER JOIN DEPENDENCIA d ON f.ID_DEPENDENCIA = d.ID_DEPENDENCIA
      WHERE NOMBRE LIKE CONCAT('', TRIM(pNOMBRE_FUNCIONARIO) ,'%');     
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_BUSCARXNOMBREYAPELL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_BUSCARXNOMBREYAPELL`(pNOMBRE VARCHAR(20),pAPELLIDO1 VARCHAR(45),pAPELLIDO2 VARCHAR(45))
BEGIN
    SET @query =
      '
      SELECT
        f.ID_FUNCIONARIO, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.EMAIL, f.ESTADO AS ID_ESTADO,
        CASE WHEN f.ESTADO = 0 THEN ''IN'' ELSE ''AC'' END AS ESTADO,
        f.CONTRASENA, f.ROL AS ID_ROL, r.NOMBRE_ROL AS ROL, f.ID_DEPENDENCIA,
        d.NOMBRE_DEPENDENCIA AS DEPENDENCIA      
      FROM FUNCIONARIO f
        INNER JOIN ROL r ON f.ROL = r.ID_ROL
        INNER JOIN DEPENDENCIA d ON f.ID_DEPENDENCIA = d.ID_DEPENDENCIA
      WHERE 1 = 1
      ';
      IF (pNOMBRE IS NOT NULL AND pNOMBRE != '') THEN
        SET @param = CONCAT("'", TRIM(pNOMBRE),"%'");           
        SET @stmt = CONCAT(' AND f.NOMBRE LIKE ', @param);
        SET @query = CONCAT(@query, @stmt);   
      END IF;
      IF (pAPELLIDO1 IS NOT NULL AND pAPELLIDO1 != '') THEN
        SET @param = CONCAT("'", TRIM(pAPELLIDO1),"%'");           
        SET @stmt = CONCAT(' AND f.APELLIDO1 LIKE ', @param);
        SET @query = CONCAT(@query, @stmt);   
      END IF;
      IF (pAPELLIDO2 IS NOT NULL AND pAPELLIDO2 != '') THEN
        SET @param = CONCAT("'", TRIM(pAPELLIDO2),"%'");
        SET @stmt = CONCAT(' AND f.APELLIDO2 LIKE ', @param);
        SET @query = CONCAT(@query, @stmt);         
      END IF;
       
      SET @query = CONCAT(@query, ';');
           
      PREPARE stmt2 FROM @query;
      EXECUTE stmt2;
      DEALLOCATE PREPARE stmt2;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_LIKE_ID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_LIKE_ID`(pID_FUNCIONARIO VARCHAR(20))
BEGIN
      SELECT
        f.ID_FUNCIONARIO, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.EMAIL, f.ESTADO AS ID_ESTADO,
        CASE WHEN f.ESTADO = 0 THEN 'IN' ELSE 'AC' END AS ESTADO,
        f.CONTRASENA, f.ROL AS ID_ROL, r.NOMBRE_ROL AS ROL, f.ID_DEPENDENCIA,
        d.NOMBRE_DEPENDENCIA AS DEPENDENCIA      
      FROM FUNCIONARIO f
        INNER JOIN ROL r ON f.ROL = r.ID_ROL
        INNER JOIN DEPENDENCIA d ON f.ID_DEPENDENCIA = d.ID_DEPENDENCIA
      WHERE ID_FUNCIONARIO LIKE CONCAT('', TRIM(pID_FUNCIONARIO) ,'%');     
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_LISTAR_TODOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_LISTAR_TODOS`()
BEGIN   
      SELECT
        f.ID_FUNCIONARIO,f.NOMBRE,f.APELLIDO1,f.APELLIDO2,f.EMAIL,f.ESTADO AS ID_ESTADO,
        CASE WHEN f.ESTADO = 0 THEN 'IN' ELSE 'AC' END AS ESTADO,
        f.CONTRASENA, f.ROL AS ID_ROL, r.NOMBRE_ROL AS ROL, f.ID_DEPENDENCIA,
        d.NOMBRE_DEPENDENCIA AS DEPENDENCIA         
      FROM FUNCIONARIO f 
        INNER JOIN ROL r ON f.ROL = r.ID_ROL
        INNER JOIN DEPENDENCIA d ON f.ID_DEPENDENCIA = d.ID_DEPENDENCIA;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_MODIFICAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_MODIFICAR`(pID_FUNCIONARIO VARCHAR(20),pNOMBRE VARCHAR(45),pAPELLIDO1 VARCHAR(45),pAPELLIDO2 VARCHAR(45),
                                          pEMAIL VARCHAR(50), pIDESTADO INT, pCONTRASENA VARCHAR(10), pID_ROL INT,pID_DEPENDENCIA INT)
BEGIN    
      UPDATE FUNCIONARIO
            SET NOMBRE = TRIM(pNOMBRE)
            ,APELLIDO1 = TRIM(pAPELLIDO1)
            ,APELLIDO2 = TRIM(pAPELLIDO2)
            ,EMAIL = TRIM(pEMAIL)
            ,ESTADO = pIDESTADO
            ,CONTRASENA = TRIM(pCONTRASENA)
            ,ROL = pID_ROL
            ,ID_DEPENDENCIA = pID_DEPENDENCIA
      WHERE
            ID_FUNCIONARIO = TRIM(pID_FUNCIONARIO);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_FUNCIONARIO_SUSPENDER` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_FUNCIONARIO_SUSPENDER`(pID_FUNCIONARIO VARCHAR(20), pIDESTADO INT)
BEGIN  
      UPDATE FUNCIONARIO
            SET ESTADO = pIDESTADO           
      WHERE
            ID_FUNCIONARIO = TRIM(pID_FUNCIONARIO);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_IUSXROL_ELIMINAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_IUSXROL_ELIMINAR`(pID_ROL INT)
BEGIN 
      DELETE FROM IUSXROL WHERE ID_ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_IUSXROL_LISTAR_POR_ROL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_IUSXROL_LISTAR_POR_ROL`(pID_ROL INT)
BEGIN
      SELECT ID_IU,ID_ROL FROM IUSXROL WHERE ID_ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_IUSXROL_LISTAR_TODAS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_IUSXROL_LISTAR_TODAS`()
BEGIN
      SELECT ID_IU,ID_ROL FROM IUSXROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_IUS_LISTAR_TODAS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_IUS_LISTAR_TODAS`()
BEGIN
      SELECT ID_IU,ALIAS_IU FROM IUS_SIGEPEX;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_MENSAJE_AYUDA_IU_AGREGAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_MENSAJE_AYUDA_IU_AGREGAR`(pID_IU VARCHAR(100),pMENSAJE_AYUDA VARCHAR(8000))
BEGIN
      INSERT INTO AYUDA_IU(ID_IU,IU_TEXTO_AYUDA) VALUES(TRIM(pID_IU),TRIM(pMENSAJE_AYUDA));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_MENSAJE_AYUDA_IU_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_MENSAJE_AYUDA_IU_BUSCAR`(pID_IU VARCHAR(100))
BEGIN 
      SELECT ID_IU,IU_TEXTO_AYUDA
      FROM AYUDA_IU         
      WHERE ID_IU = TRIM(pID_IU);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_MENSAJE_AYUDA_IU_MODIFICAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_MENSAJE_AYUDA_IU_MODIFICAR`(pID_IU VARCHAR(100),pMENSAJE_AYUDA VARCHAR(8000))
BEGIN    
      UPDATE AYUDA_IU
            SET IU_TEXTO_AYUDA = TRIM(pMENSAJE_AYUDA)            
      WHERE
            ID_IU = TRIM(pID_IU);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_PARAMETRO_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_PARAMETRO_BUSCAR`(pID_PARAMETRO INT)
BEGIN 
      SELECT ID_PARAMETRO,NOMBRE_PARAMETRO,VALOR_PARAMETRO
      FROM PARAMETRO         
      WHERE ID_PARAMETRO = pID_PARAMETRO;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_PARAMETRO_LISTAR_TODOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_PARAMETRO_LISTAR_TODOS`()
BEGIN
      SELECT ID_PARAMETRO,NOMBRE_PARAMETRO,VALOR_PARAMETRO FROM PARAMETRO;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_PARAMETRO_MODIFICAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_PARAMETRO_MODIFICAR`(pID_PARAMETRO INT, pVALOR_PARAMETRO INT)
BEGIN 
      UPDATE PARAMETRO
            SET VALOR_PARAMETRO = pVALOR_PARAMETRO            
      WHERE
            ID_PARAMETRO = pID_PARAMETRO;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_REPORTE_EXPEDIENTE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_REPORTE_EXPEDIENTE`(IN fechaIni    VARCHAR(10),

                                IN fechaFin    VARCHAR(10),

                                IN dependencia VARCHAR(50),                                
                                IN funcionario VARCHAR(50)
                                )
BEGIN

  SET @query = 'SELECT bp.id_boleta_prestamo,bp.fecha_prestamo,fu.nombre,fu.apellido1,de.nombre_dependencia FROM boleta_prestamo as bp,funcionario as fu,dependencia as de';

  SET @query = concat(@query, " WHERE  bp.ID_FUNCIONARIO = fu.ID_FUNCIONARIO"); 
               
  
    IF (dependencia IS NOT NULL) THEN
     SET @query = concat(@query, " AND de.id_dependencia = (SELECT ID_DEPENDENCIA FROM dependencia WHERE NOMBRE_DEPENDENCIA LIKE '%",dependencia,"%') ");
     SET @query = concat(@query, " AND fu.id_dependencia = de.id_dependencia ");   
  END IF;

  SET @query = concat(@query, " AND bp.fecha_prestamo > '", fechaIni, "' ");

  SET @query = concat(@query, " AND bp.fecha_prestamo < '", fechaFin, "' ");
    
  IF (funcionario IS NOT NULL) THEN

    SET @query = concat(@query, " AND fu.nombre LIKE '%", funcionario,"%' ");
  END IF;


  SET @query = concat(@query, " group by bp.id_boleta_prestamo;");



  PREPARE stmt1 FROM @query;



  EXECUTE stmt1;





END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_AGREGAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_AGREGAR`(pID_ROL INT,pDESCRIPCION VARCHAR(45),pNOMBRE VARCHAR(45))
BEGIN
      INSERT INTO ROL
        (ID_ROL
        ,DESCRIPCION_ROL
        ,NOMBRE_ROL)
      VALUES(
        pID_ROL
        ,TRIM(pDESCRIPCION)
        ,TRIM(pNOMBRE));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_BUSCAR`(pID_ROL INT)
BEGIN 
      SELECT ID_ROL,DESCRIPCION_ROL,NOMBRE_ROL
      FROM ROL         
      WHERE ID_ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_CANTIDAD_FUNCIONARIOSXROL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_CANTIDAD_FUNCIONARIOSXROL`(pID_ROL INT)
BEGIN        
      SELECT COUNT(ROL) AS CANTIDAD
      FROM  FUNCIONARIO     
      WHERE ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_ELIMINAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_ELIMINAR`(pID_ROL INT)
BEGIN 
      DELETE FROM ROL WHERE ID_ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_LISTAR_TODOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_LISTAR_TODOS`()
BEGIN
      SELECT ID_ROL,DESCRIPCION_ROL,NOMBRE_ROL FROM ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_ROL_MODIFICAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_ROL_MODIFICAR`(pID_ROL INT, pDESCRIPCION VARCHAR(45), pNOMBRE VARCHAR(45))
BEGIN 
      UPDATE ROL
            SET DESCRIPCION_ROL = TRIM(pDESCRIPCION), NOMBRE_ROL = TRIM(pNOMBRE)            
      WHERE
            ID_ROL = pID_ROL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_SERIE_DOCUMENTAL_AGREGAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_SERIE_DOCUMENTAL_AGREGAR`(pID_SERIE_DOCUMENTAL INT, pTIPO_SERIE_DOCUMENTAL VARCHAR(45))
BEGIN
      INSERT INTO SERIE_DOCUMENTAL
        (ID_SERIE_DOCUMENTAL       
        ,TIPO_SERIE_DOCUMENTA)
      VALUES(
        pID_SERIE_DOCUMENTAL
        ,TRIM(pTIPO_SERIE_DOCUMENTAL));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_SERIE_DOCUMENTAL_BUSCAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_SERIE_DOCUMENTAL_BUSCAR`(pID_SERIE_DOCUMENTAL INT)
BEGIN
      SELECT ID_SERIE_DOCUMENTAL,TIPO_SERIE_DOCUMENTAL
      FROM SERIE_DOCUMENTAL        
      WHERE ID_SERIE_DOCUMENTAL = pID_SERIE_DOCUMENTAL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_SERIE_DOCUMENTAL_ELIMINAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_SERIE_DOCUMENTAL_ELIMINAR`(pID_SERIE_DOCUMENTAL INT)
BEGIN 
      DELETE FROM SERIE_DOCUMENTAL WHERE ID_SERIE_DOCUMENTAL = pID_SERIE_DOCUMENTAL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_SERIE_DOCUMENTAL_LISTAR_TODAS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_SERIE_DOCUMENTAL_LISTAR_TODAS`()
BEGIN     
      SELECT ID_SERIE_DOCUMENTAL,TIPO_SERIE_DOCUMENTAL FROM SERIE_DOCUMENTAL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_SERIE_DOCUMENTAL_MODIFICAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_SERIE_DOCUMENTAL_MODIFICAR`(pID_SERIE_DOCUMENTAL INT, pTIPO_SERIE_DOCUMENTAL VARCHAR(45))
BEGIN
      UPDATE SERIE_DOCUMENTAL
            SET TIPO_SERIE_DOCUMENTAL = TRIM(pTIPO_SERIE_DOCUMENTAL)
      WHERE
            ID_SERIE_DOCUMENTAL = pID_SERIE_DOCUMENTAL;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ST_UIXROL_AGREGAR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `ST_UIXROL_AGREGAR`(pID_ROL INT, pID_IU VARCHAR(100))
BEGIN
      INSERT INTO IUSXROL
        (ID_ROL
        ,ID_IU)
      VALUES(
        pID_ROL
        ,TRIM(pID_IU));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `test` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `test`()
BEGIN DECLARE cr_stack_depth INTEGER DEFAULT cr_debug.ENTER_MODULE('test', 'sigepex', 7);
 CALL cr_debug.TRACE(2, 2, 0, 5, cr_stack_depth); CALL cr_debug.TRACE(3, 3, 0, 101, cr_stack_depth);SET @aaa = (SELECT ID_DEPENDENCIA FROM dependencia WHERE NOMBRE_DEPENDENCIA LIKE '%Administracion%');CALL cr_debug.UPDATE_SYSTEM_CALLS(101);CALL cr_debug.UPDATE_WATCH2('@aaa', @aaa, cr_stack_depth);

 CALL cr_debug.TRACE(5, 10, 0, 29, cr_stack_depth);SELECT bp.id_boleta_prestamo,bp.fecha_prestamo,fu.nombre+" "+fu.apellido1 as "NombreFuncionario",de.nombre_dependencia
FROM boleta_prestamo as bp,funcionario as fu,dependencia as de
WHERE bp.ID_FUNCIONARIO = fu.ID_FUNCIONARIO 
AND bp.fecha_prestamo > '1900-12-31'
AND bp.fecha_prestamo < '9999-12-31'
AND fu.id_dependencia = @aaa;CALL cr_debug.UPDATE_SYSTEM_CALLS(101);

 CALL cr_debug.TRACE(12, 12, 0, 3, cr_stack_depth);END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-03  3:36:31
