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
-- Table structure for table `nutrition`
--

DROP TABLE IF EXISTS `nutrition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nutrition` (
  `ID` int(11) NOT NULL,
  `FOOD_TYPE` varchar(100) NOT NULL,
  `CALORIES` varchar(45) NOT NULL,
  `SAT_FAT` int(11) NOT NULL,
  `TRANS_FAT` int(11) NOT NULL,
  `CARBS` int(11) NOT NULL,
  `SODIUM` int(11) NOT NULL,
  `PROTIEN` int(11) NOT NULL,
  `FIBER` int(11) NOT NULL,
  `TOTAL_FAT` int(11) NOT NULL,
  `FOOD_CLASSIFICATION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nutrition`
--

LOCK TABLES `nutrition` WRITE;
/*!40000 ALTER TABLE `nutrition` DISABLE KEYS */;
INSERT INTO `nutrition` VALUES (1,'Italian Pretzel Grinder w/ Fries Only','680',9,0,63,1920,26,5,35,'L'),(2,'1/2 BLT & Avocado w/ Fries Only','620',10,0,63,1920,26,5,35,'L'),(3,'Strawberry Fields Salad with Chicken w/ Breadstick Only','650',10,0,63,1920,26,5,35,'L'),(4,'Bruschetta Pasta Pomodoro','270',1,0,63,1920,26,5,35,'L'),(5,'Half California Club w/ Fries Only','560',1,0,63,1920,26,5,35,'L'),(6,'Chipotle Yucatan Chicken Salad w/ Breadstick Only','530',1,0,63,1920,26,5,35,'L'),(7,'Smoked Sausage Mac & Cheese','620',1,0,63,1920,26,5,35,'L'),(8,'Chicken & Bacon Mac & Cheesee','630',1,0,63,1920,26,5,35,'L'),(9,'JackTM Sliders® w/ Fries Only','870',1,0,63,1920,26,5,35,'L'),(10,'Spicy Chicken Sliders w/ Fries Only','860',1,0,63,1920,26,5,35,'L'),(11,'Cajun Chicken Pasta w/ Breadstick Only','440',1,0,63,1920,26,5,35,'L'),(12,'Ceasar Salad with Grilled Chicken','640',1,0,63,1920,26,5,35,'L'),(13,'Buffalo Wings (Boneless) Classic ','720',8,0,44,3330,42,3,42,'B'),(14,'Buffalo Wings (Boneless) Sriracha with Sriracha Ranch','870',15,0,44,3330,42,3,42,'B'),(15,'White Cheddar Broccoli Cheese','280',11,0,44,3330,42,3,42,'B'),(16,'French Onion','350',11,0,44,3330,42,3,42,'B'),(17,'Soup of the Day - Tortilla','210',11,0,44,3330,42,3,42,'B'),(18,'Soup of the Day - New England Clam Chowder','500',11,0,44,3330,42,3,42,'B'),(19,'Soup of the Day - Tomato Basil','300',11,0,44,3330,42,3,42,'B'),(20,'Caesar Salad w/ Bread Stick','370',11,0,44,3330,42,3,42,'B'),(21,'Bourbon Barrel Chicken','270',11,0,44,3330,42,3,42,'B'),(22,'Bruschetta Chicken Pasta','860',11,0,44,3330,42,3,42,'B'),(23,'Cajun Shrimp & Chicken Pasta','1110',11,0,44,3330,42,3,42,'B'),(24,'Crispy Chicken Fingers','1030',11,0,44,3330,42,3,42,'B'),(25,'Parmesan-Crusted Chicken','980',11,0,44,3330,42,3,42,'B'),(26,'Tennessee Whiskey Cake','1110',11,0,44,3330,42,3,42,'D'),(27,'Brownie Obsession','1200',11,0,44,3330,42,3,42,'D'),(28,'Vanilla Bean Cheesecake','920',11,0,44,3330,42,3,42,'D'),(29,'Oreo® Madness','500',11,0,44,3330,42,3,42,'D'),(30,'Kid’s Dessert - Cup of Dirt','480',11,0,44,3330,42,3,42,'D'),(31,'Kid’s Dessert - Vanilla Ice Cream','460',11,0,44,3330,42,3,42,'D'),(32,'Kid’s Sundae','690',11,0,44,3330,42,3,42,'D');
/*!40000 ALTER TABLE `nutrition` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-03 13:43:29
