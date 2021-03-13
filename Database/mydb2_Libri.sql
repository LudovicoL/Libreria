CREATE DATABASE  IF NOT EXISTS `mydb2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb2`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: mydb2
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `Libri`
--

DROP TABLE IF EXISTS `Libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Libri` (
  `idLibro` int(11) NOT NULL AUTO_INCREMENT,
  `Titolo` varchar(45) NOT NULL,
  `Genere` varchar(45) DEFAULT NULL,
  `Quantita` int(11) NOT NULL,
  `CasaEditrice_idCasaEditrice` int(11) NOT NULL,
  `Autori_idAutore` int(11) NOT NULL,
  `Scaffale_idScaffale` int(11) NOT NULL,
  `Costo` int(11) NOT NULL,
  `AnnoPubblicazione` int(11) NOT NULL,
  PRIMARY KEY (`idLibro`),
  UNIQUE KEY `idLibri_UNIQUE` (`idLibro`),
  KEY `fk_Libri_CasaEditrice1_idx` (`CasaEditrice_idCasaEditrice`),
  KEY `fk_Libri_Autori1_idx` (`Autori_idAutore`),
  KEY `fk_Libri_Scaffale1_idx` (`Scaffale_idScaffale`),
  CONSTRAINT `fk_Libri_Autori1` FOREIGN KEY (`Autori_idAutore`) REFERENCES `Autori` (`idAutore`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libri_CasaEditrice1` FOREIGN KEY (`CasaEditrice_idCasaEditrice`) REFERENCES `CasaEditrice` (`idCasaEditrice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libri_Scaffale1` FOREIGN KEY (`Scaffale_idScaffale`) REFERENCES `Scaffale` (`idScaffale`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libri`
--

LOCK TABLES `Libri` WRITE;
/*!40000 ALTER TABLE `Libri` DISABLE KEYS */;
INSERT INTO `Libri` VALUES (1,'I Promessi Sposi','Romanzo',20,1,1,1,12,1827),(2,'Gomorra','Romanzo',10,1,4,1,15,2006),(3,'Il Codice da Vinci','Romanzo',2,1,3,1,10,2003),(4,'Il fu Mattia Pascal','Romanzo',1,1,2,1,8,1904),(5,'Il linguaggio Java','Informatica',2,2,5,2,30,2008),(6,'Le basi di dati','Informatica',1,2,5,2,28,2008),(7,'La verità del ghiaccio','Romanzo',3,1,3,1,14,2001),(8,'Crypto','Romanzo',1,1,3,1,12,1998),(9,'Angeli e Demoni','Romanzo',4,1,3,1,10,2000),(10,'Topolino','Fumetto',4,3,6,3,2,2015),(11,'Paperinik','Fumetto',2,3,6,3,5,2015);
/*!40000 ALTER TABLE `Libri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-24 15:53:28
