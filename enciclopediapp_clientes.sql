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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idclientes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fch_nac` date NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `afiliado` tinyint(4) NOT NULL,
  `acept_publi` tinyint(4) NOT NULL,
  PRIMARY KEY (`idclientes`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Lance','Cross','2005-04-27','mauris@aol.com','221 18 26 75','LLM22IYP83SK2',0,0),(2,'Jonah','Love','1997-12-10','mauris@hotmail.couk','953 35 53 72','ZUO94BXP53IS7',0,0),(3,'Josiah','Lamb','2000-09-29','ipsum.dolor@aol.org','435 52 02 87','BTR17RUX51EX2',1,1),(4,'Adrian','Jimenez','2003-11-24','ullamcorper.magna.sed@outlook.org','823 86 51 75','DIL18KCV96KZ9',0,1),(5,'Rashad','Kinney','2000-04-01','amet@hotmail.com','452 85 35 74','JSM53QDG30NI1',1,0),(6,'Adele','Richard','2005-07-21','nulla.vulputate@icloud.edu','811 51 61 06','SZY72GXN66WJ7',1,1),(7,'Yoko','Bolton','1999-01-10','lorem@icloud.net','561 71 29 57','PCN17EOP48GV2',0,0),(8,'Iola','Dickson','2005-06-17','erat.nonummy@outlook.com','126 61 47 25','HIP51QPV15WP7',0,1),(9,'Aaron','Rutledge','2002-03-26','ac.ipsum@aol.org','755 35 68 81','QEP44VOD52SI3',1,0),(10,'Duncan','Newton','1999-10-10','nibh.enim.gravida@hotmail.org','206 42 41 81','AFR31XRK24VK3',0,0),(11,'Tanek','Watkins','1997-03-05','cum.sociis@outlook.org','311 82 88 47','UFC58JQR45GE5',1,1),(12,'Farrah','Schneider','2002-07-20','dui@icloud.couk','064 14 21 98','XDH64PJM83LK2',1,1),(13,'Keiko','Clements','2004-03-22','nisi@icloud.org','327 91 65 43','SPM83VIR23JS6',0,0),(14,'Yuri','Jones','1996-06-20','in.nec@aol.ca','467 47 10 53','USW12VMP78QN3',0,1),(15,'Yen','Norris','1996-09-03','nostra.per.inceptos@google.org','949 80 41 21','CFT53ZGB11AB5',0,1),(16,'Ruth','Vinson','1998-12-15','molestie.sodales@hotmail.net','548 31 38 44','MFI83OFW43NP2',0,0),(17,'Alexa','Matthews','1998-10-06','non@yahoo.ca','583 67 36 16','OTY54DHE63UD8',1,1),(18,'Prescott','Allison','2001-12-10','semper.et.lacinia@hotmail.edu','758 38 68 96','QMK35HQE37KO3',0,0),(19,'Ruth','Bruce','1996-06-03','rutrum.urna@aol.couk','230 81 42 16','AAY56VXS61PD7',1,1),(20,'Rhoda','Walker','2003-04-14','non.bibendum@yahoo.net','323 41 13 12','XZO36ZPI35DZ2',1,1),(21,'Piper','Rush','1999-02-28','cursus.purus@outlook.org','756 38 77 15','QPJ28DQI82SX9',0,1),(22,'Byron','Vaughn','2001-12-08','ridiculus.mus@yahoo.org','271 52 77 18','NCW71BCZ53IE6',0,0),(23,'Giselle','Paul','1995-03-19','quis.massa@protonmail.couk','523 55 32 23','DCV01YDV49LF5',1,0),(24,'Nasim','Hood','1997-04-01','neque.venenatis@hotmail.ca','260 66 50 75','JWY62MXS64TK7',0,0),(25,'Arden','England','2005-08-08','pretium@aol.edu','828 60 23 05','ZYS04HIX40FL4',0,0),(26,'Shelly','Franks','1997-04-10','velit.eu@yahoo.org','031 56 96 06','XWT71FCC54GM1',1,0),(27,'Keane','Parrish','1996-07-21','orci@aol.couk','448 15 70 11','UGC28DTR87SC3',0,1),(28,'Barclay','Head','1995-12-11','consectetuer.rhoncus.nullam@protonmail.net','465 80 36 47','KSB65KAK24ZK7',0,1),(29,'Denise','Wiley','1995-01-22','posuere.cubilia@protonmail.couk','721 57 24 17','JKE33KQU27QM6',0,1),(30,'Illana','Buckley','2003-06-16','blandit.nam@google.couk','257 75 50 82','GHF55DVH60EY5',1,0),(31,'Zeus','Valenzuela','2004-02-10','pharetra.nam.ac@google.couk','248 33 58 77','BKG58BPL35BW4',0,0),(32,'Declan','Heath','2004-03-09','non@google.edu','624 19 73 95','KLG18XWO83CT1',1,1),(33,'Helen','Mcneil','2002-08-09','adipiscing.mauris@outlook.edu','231 16 24 75','KQC40DQB44JO5',0,0),(34,'Henry','Mcmahon','2005-06-18','eu.tempor.erat@hotmail.ca','787 87 24 38','OVM33DOT82CE5',0,0),(35,'Frances','Cameron','2002-07-02','egestas.a@icloud.org','323 65 84 44','MVJ33ICQ42JL7',0,0),(36,'Fulton','Ayala','2001-02-09','mauris@google.net','578 77 75 67','LSR33YYO63JY0',0,1),(37,'Nero','Kirk','2003-01-20','eu.augue@icloud.com','881 17 25 24','HSH37OFU30IN4',1,1),(38,'Joshua','Tate','2005-12-05','phasellus.nulla@google.com','585 34 27 30','LCK03NBI01QQ8',1,1),(39,'Bianca','Lopez','2003-06-30','sed.turpis@icloud.net','252 66 18 71','GKH25DDM66JV3',1,1),(40,'Nerea','Wade','2004-09-04','donec.nibh@icloud.com','363 21 89 19','OEK52YTO62LK8',0,0),(41,'Cole','Martin','1995-11-26','sed@yahoo.edu','623 45 56 67','GPV35FNT63VK1',1,0),(42,'Carson','Richmond','2003-06-25','vulputate@hotmail.couk','988 52 33 64','FCP96ZIP13JT5',1,1),(43,'Dante','Faulkner','2001-09-13','tristique.neque@protonmail.net','817 24 36 21','EMH08LXX85VP8',0,1),(44,'Xander','Mcneil','2003-01-20','libero.dui@outlook.couk','394 17 53 16','EMT91KZQ74BX4',1,0),(45,'Geoffrey','Stone','2004-03-04','lectus.pede@yahoo.com','322 90 15 73','VWI60FFP15VX7',1,1),(46,'Yuri','Conway','2005-09-13','mauris.ipsum.porta@protonmail.ca','413 85 86 22','QVH75RNX15CP9',0,0),(47,'Amaya','Malone','1998-12-27','id.ante@google.com','392 57 48 04','AJI52EMR12PY6',0,1),(48,'Cooper','Walker','2004-11-01','orci.consectetuer@protonmail.com','369 94 45 66','SAX48ORD57EB5',1,1),(49,'Linus','Singleton','1999-03-21','sed.sapien.nunc@protonmail.edu','188 54 60 75','IDO02UEN41PT6',1,1),(50,'Victor','Sherman','1997-08-01','libero.donec@google.net','204 67 34 53','NKV20LPE28NS0',0,1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
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
