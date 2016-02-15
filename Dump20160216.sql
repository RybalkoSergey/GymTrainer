CREATE DATABASE  IF NOT EXISTS `GymTrainer` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `GymTrainer`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: GymTrainer
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `COMPLEXITY_TYPES`
--

DROP TABLE IF EXISTS `COMPLEXITY_TYPES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPLEXITY_TYPES` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPLEXITY_TYPES`
--

LOCK TABLES `COMPLEXITY_TYPES` WRITE;
/*!40000 ALTER TABLE `COMPLEXITY_TYPES` DISABLE KEYS */;
INSERT INTO `COMPLEXITY_TYPES` VALUES (1,'Begginer'),(2,'Middle level'),(3,'Profi'),(4,'Expert');
/*!40000 ALTER TABLE `COMPLEXITY_TYPES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DAYS`
--

DROP TABLE IF EXISTS `DAYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DAYS` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DAYS`
--

LOCK TABLES `DAYS` WRITE;
/*!40000 ALTER TABLE `DAYS` DISABLE KEYS */;
INSERT INTO `DAYS` VALUES (1,'Monday'),(2,'Tuesday'),(3,'Wednesday'),(4,'Thursday'),(5,'Friday'),(6,'Saturday'),(7,'Sunday');
/*!40000 ALTER TABLE `DAYS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXERCISES`
--

DROP TABLE IF EXISTS `EXERCISES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXERCISES` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `amount_of_set` int(11) NOT NULL,
  `amount_of_iteration` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXERCISES`
--

LOCK TABLES `EXERCISES` WRITE;
/*!40000 ALTER TABLE `EXERCISES` DISABLE KEYS */;
INSERT INTO `EXERCISES` VALUES (1,'Exercixe 1','Description for exercise 1',4,10),(2,'Exercixe 2','Description for exercixe 2',4,8),(3,'Exercixe 3','Description for exercixe 2',3,10),(4,'Exercixe 4','Description for exercixe 2',4,8),(5,'Exercixe 5','Description for exercixe 2',3,10),(6,'Exercixe 6','Description for exercixe 2',4,8),(7,'Exercixe 7','Description for exercixe 2',3,10),(8,'Exercixe 8','Description for exercixe 2',4,8),(9,'Exercixe 9','Description for exercixe 2',3,10),(10,'Exercixe 10','Description for exercixe 2',4,8);
/*!40000 ALTER TABLE `EXERCISES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROGRAMS`
--

DROP TABLE IF EXISTS `PROGRAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROGRAMS` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `complexity_type_id` int(11) NOT NULL,
  `is_archive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_COMPLEXITY_TYPES_idx` (`complexity_type_id`),
  CONSTRAINT `FK_COMPLEXITY_TYPES` FOREIGN KEY (`complexity_type_id`) REFERENCES `COMPLEXITY_TYPES` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROGRAMS`
--

LOCK TABLES `PROGRAMS` WRITE;
/*!40000 ALTER TABLE `PROGRAMS` DISABLE KEYS */;
INSERT INTO `PROGRAMS` VALUES (1,'Program 1','Description of program 1',1,0),(2,'Program 2','Description of program 2',2,0);
/*!40000 ALTER TABLE `PROGRAMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROGRAM_EXERCISES`
--

DROP TABLE IF EXISTS `PROGRAM_EXERCISES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROGRAM_EXERCISES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `program_id` int(11) NOT NULL,
  `day_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PROG_EXERC_PROGRAM_idx` (`program_id`),
  KEY `FK_PROG_EXERC_DAY_idx` (`day_id`),
  KEY `FK_PROG_EXERC_EXERCISE_idx` (`exercise_id`),
  CONSTRAINT `FK_PROG_EXERC_DAY` FOREIGN KEY (`day_id`) REFERENCES `DAYS` (`id`),
  CONSTRAINT `FK_PROG_EXERC_EXERCISE` FOREIGN KEY (`exercise_id`) REFERENCES `EXERCISES` (`id`),
  CONSTRAINT `FK_PROG_EXERC_PROGRAM` FOREIGN KEY (`program_id`) REFERENCES `PROGRAMS` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROGRAM_EXERCISES`
--

LOCK TABLES `PROGRAM_EXERCISES` WRITE;
/*!40000 ALTER TABLE `PROGRAM_EXERCISES` DISABLE KEYS */;
INSERT INTO `PROGRAM_EXERCISES` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,2,4),(5,1,2,5),(6,1,2,6),(7,2,3,7),(8,2,3,8),(9,2,3,9),(10,2,3,10),(11,2,4,1),(12,2,4,2);
/*!40000 ALTER TABLE `PROGRAM_EXERCISES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLES`
--

LOCK TABLES `ROLES` WRITE;
/*!40000 ALTER TABLE `ROLES` DISABLE KEYS */;
INSERT INTO `ROLES` VALUES (1,'ADMIN'),(2,'TRAINER'),(3,'ATHLETE');
/*!40000 ALTER TABLE `ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,'SergeyRy','Sergey','Rybalko','11111','Sergey@gmail.com','Active'),(2,'VladimirSh','Vladimir','Shevchenko','22222','Vladimir@gmail.com','Active'),(3,'DmitriyBr','Dmitriy','Burkalov','33333','Dmitriy@gmail.com','Active'),(4,'IgorPk','Igor','Pakushin','44444','Igor@gmail.com','Active');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_PROGRAMS`
--

DROP TABLE IF EXISTS `USER_PROGRAMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_PROGRAMS` (
  `USER_ID` int(11) NOT NULL,
  `PROGRAM_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`PROGRAM_ID`),
  KEY `FK_USER_PROG_PROGRAMS_idx` (`PROGRAM_ID`),
  KEY `FK_USER_PROG_USERS_idx` (`USER_ID`),
  CONSTRAINT `FK_USER_PROG_PROGRAMS` FOREIGN KEY (`PROGRAM_ID`) REFERENCES `PROGRAMS` (`id`),
  CONSTRAINT `FK_USER_PROG_USERS` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_PROGRAMS`
--

LOCK TABLES `USER_PROGRAMS` WRITE;
/*!40000 ALTER TABLE `USER_PROGRAMS` DISABLE KEYS */;
INSERT INTO `USER_PROGRAMS` VALUES (1,1),(2,1),(3,1),(4,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `USER_PROGRAMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLES`
--

DROP TABLE IF EXISTS `USER_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLES` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLES_idx` (`role_id`),
  KEY `FK_USERS_idx` (`user_id`),
  CONSTRAINT `FK_ROLES` FOREIGN KEY (`role_id`) REFERENCES `ROLES` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERS` FOREIGN KEY (`user_id`) REFERENCES `USERS` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLES`
--

LOCK TABLES `USER_ROLES` WRITE;
/*!40000 ALTER TABLE `USER_ROLES` DISABLE KEYS */;
INSERT INTO `USER_ROLES` VALUES (1,1),(2,1),(3,1),(4,1);
/*!40000 ALTER TABLE `USER_ROLES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-16  0:57:01
