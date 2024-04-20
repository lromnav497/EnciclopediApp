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
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `idvaloraciones` int(11) NOT NULL AUTO_INCREMENT,
  `puntaje` int(11) NOT NULL,
  `recomendado` tinyint(4) NOT NULL,
  `comentario` varchar(300) DEFAULT NULL,
  `fch_publi` date NOT NULL,
  `clientes_idclientes` int(11) NOT NULL,
  PRIMARY KEY (`idvaloraciones`,`clientes_idclientes`),
  KEY `fk_valoraciones_clientes1` (`clientes_idclientes`),
  CONSTRAINT `fk_valoraciones_clientes1` FOREIGN KEY (`clientes_idclientes`) REFERENCES `clientes` (`idclientes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES (1,3,0,'Sed et libero. Proin mi. Aliquam','2017-07-03',7),(2,1,0,'orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio','2016-03-16',8),(3,3,1,'nisi. Aenean eget metus.','2018-08-31',21),(4,5,1,'sagittis placerat. Cras','2020-06-22',33),(5,0,1,'mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate,','2023-01-08',44),(6,3,1,'Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc,','2017-01-11',19),(7,2,0,'a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna','2018-07-13',20),(8,4,1,'sit amet luctus vulputate, nisi sem semper erat, in consectetuer ipsum nunc id enim.','2022-12-07',36),(9,4,0,'nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed','2020-09-25',32),(10,3,1,'Duis elementum, dui quis accumsan convallis,','2019-05-05',40),(11,2,0,'urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam,','2015-03-09',12),(12,1,0,'Donec feugiat metus sit amet ante. Vivamus','2023-01-26',9),(13,4,1,'sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio.','2018-12-06',23),(14,5,0,'neque. In ornare sagittis felis. Donec tempor, est ac','2019-04-27',8),(15,5,1,'leo elementum sem,','2017-04-24',38),(16,1,1,'ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum.','2017-08-17',41),(17,5,0,'lobortis augue','2021-07-11',12),(18,5,1,'Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In','2022-09-14',18),(19,3,0,'lacinia at, iaculis','2018-04-29',36),(20,1,0,'pharetra nibh. Aliquam ornare, libero at auctor','2020-09-21',46),(21,2,0,'id risus quis diam luctus lobortis.','2017-02-12',21),(22,3,1,'Donec egestas. Duis ac arcu. Nunc mauris. Morbi','2022-04-06',46),(23,2,1,'pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin','2019-01-21',36),(24,2,1,'In lorem. Donec elementum, lorem ut aliquam iaculis, lacus','2017-06-16',8),(25,3,0,'cubilia Curae Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem,','2020-01-29',23);
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
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
