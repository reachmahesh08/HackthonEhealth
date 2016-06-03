-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: eahealth
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `GENDER` varchar(45) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `HEIGHT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'AMIT','AMIT','HI@GMMAIL.COM','M',35,60,'160'),(2,'SUMIT','SUMIT','HI@GMAIL.COM','M',40,60,'165'),(3,'ABC','ABC','hirastogi@gmail.com','M',30,58,'1.575'),(4,'aa','aa','hirastogi@gmail.com','Male',33,68,'1.5250000000000001'),(5,'aa','aa','hirastogi@gmail.com','Male',34,76,'0.9750000000000001'),(6,'dd','cc','hirastogi@gmail.com','Male',45,76,'1.3250000000000002'),(7,'kajal','kajal','hirastogi@gmail.com','Female',34,66,'1.5250000000000001'),(8,'gunnu','gunnu','hirastogi@gmail.com','Male',3,15,'1.0250000000000001'),(9,'abcdef','abcdef','aa@gmail.com','Male',25,65,'1.5250000000000001'),(10,'121','121','1@ss.com','Male',24,80,'0.325'),(11,'bond001','001','hirastogi@gmail.com','Male',35,78,'1.905'),(12,'Mickey','mickey','se.fairozkhan@gmail.com','Male',26,61,'1.7018');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-03 13:43:30
