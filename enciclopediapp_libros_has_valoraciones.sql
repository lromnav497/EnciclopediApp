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
-- Table structure for table `libros_has_valoraciones`
--

DROP TABLE IF EXISTS `libros_has_valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros_has_valoraciones` (
  `libros_idlibros` int(11) NOT NULL,
  `valoraciones_idvaloraciones` int(11) NOT NULL,
  PRIMARY KEY (`libros_idlibros`,`valoraciones_idvaloraciones`),
  KEY `fk_libros_has_valoraciones_valoraciones1` (`valoraciones_idvaloraciones`),
  CONSTRAINT `fk_libros_has_valoraciones_libros1` FOREIGN KEY (`libros_idlibros`) REFERENCES `libros` (`idlibros`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_libros_has_valoraciones_valoraciones1` FOREIGN KEY (`valoraciones_idvaloraciones`) REFERENCES `valoraciones` (`idvaloraciones`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros_has_valoraciones`
--

LOCK TABLES `libros_has_valoraciones` WRITE;
/*!40000 ALTER TABLE `libros_has_valoraciones` DISABLE KEYS */;
INSERT INTO `libros_has_valoraciones` VALUES (1,1),(2,2),(2,9),(2,23),(5,9),(5,14),(5,19),(7,1),(9,17),(9,24),(10,22),(13,16),(14,4),(14,11),(15,8);
/*!40000 ALTER TABLE `libros_has_valoraciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-20 15:55:55
