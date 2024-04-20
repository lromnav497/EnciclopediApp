CREATE DATABASE  IF NOT EXISTS `enciclopediapp` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `enciclopediapp`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enciclopediapp
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idempleados` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fch_nac` date NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  PRIMARY KEY (`idempleados`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Charde','Mills','1995-07-11','justo.praesent@hotmail.edu','529 83 66 11','KCS01ETT4JW','Administrador'),(2,'Whitney','Jimenez','1998-11-01','in.condimentum@icloud.net','472 23 95 29','VOG67OXL1IQ','Gestor'),(3,'Clio','Dale','2001-08-07','nunc@google.edu','578 94 16 41','VOU70ICY4OU','Administrador'),(4,'Nina','Hull','2005-06-30','pede@icloud.ca','426 77 47 86','YMF37LOF3KO','Soporte'),(5,'Aimee','Morgan','2005-09-05','purus@yahoo.edu','417 62 21 36','XEB57DRJ3XJ','Gerente'),(6,'Celeste','Madden','1996-07-21','fermentum.metus@outlook.net','815 44 03 98','RSK91FQV5GG','Gestor'),(7,'Keane','Cabrera','2005-11-28','pretium.et.rutrum@icloud.edu','489 75 17 13','KOJ64YXH7LJ','Soporte'),(8,'George','York','1997-10-25','nibh.phasellus@icloud.couk','274 70 63 44','DOK14YEY2GX','Soporte'),(9,'Anthony','Chen','2005-04-05','nec.enim.nunc@yahoo.com','597 57 75 78','CUQ80LJO3EN','Soporte'),(10,'India','Kane','1995-07-06','dui@aol.couk','924 61 16 66','RCJ69XGI5VX','Soporte');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-20 15:55:54
