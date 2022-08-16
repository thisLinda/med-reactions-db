-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: medication_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `adverse_reactions`
--

DROP TABLE IF EXISTS `adverse_reactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adverse_reactions` (
  `reaction_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `reaction_severity` enum('SEVERE','MODERATE','MILD') NOT NULL,
  `reaction` varchar(40) NOT NULL,
  PRIMARY KEY (`reaction_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adverse_reactions`
--

LOCK TABLES `adverse_reactions` WRITE;
/*!40000 ALTER TABLE `adverse_reactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `adverse_reactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generics`
--

DROP TABLE IF EXISTS `generics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generics` (
  `generic_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `med_fk` int unsigned NOT NULL,
  `generic_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`generic_pk`),
  KEY `med_fk` (`med_fk`),
  CONSTRAINT `generics_ibfk_1` FOREIGN KEY (`med_fk`) REFERENCES `medications` (`med_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generics`
--

LOCK TABLES `generics` WRITE;
/*!40000 ALTER TABLE `generics` DISABLE KEYS */;
/*!40000 ALTER TABLE `generics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_adverse_reactions`
--

DROP TABLE IF EXISTS `med_adverse_reactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `med_adverse_reactions` (
  `med_adverse_reaction_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `med_fk` int unsigned NOT NULL,
  `reaction_fk` int unsigned NOT NULL,
  PRIMARY KEY (`med_adverse_reaction_pk`),
  KEY `med_fk` (`med_fk`),
  KEY `reaction_fk` (`reaction_fk`),
  CONSTRAINT `med_adverse_reactions_ibfk_1` FOREIGN KEY (`med_fk`) REFERENCES `medications` (`med_pk`),
  CONSTRAINT `med_adverse_reactions_ibfk_2` FOREIGN KEY (`reaction_fk`) REFERENCES `adverse_reactions` (`reaction_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_adverse_reactions`
--

LOCK TABLES `med_adverse_reactions` WRITE;
/*!40000 ALTER TABLE `med_adverse_reactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `med_adverse_reactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medications`
--

DROP TABLE IF EXISTS `medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medications` (
  `med_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(40) NOT NULL,
  `has_reaction` tinyint(1) NOT NULL,
  PRIMARY KEY (`med_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
/*!40000 ALTER TABLE `medications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_meds_list`
--

DROP TABLE IF EXISTS `user_meds_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_meds_list` (
  `user_meds_list_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `user_fk` int unsigned NOT NULL,
  `med_fk` int unsigned NOT NULL,
  PRIMARY KEY (`user_meds_list_pk`),
  KEY `user_fk` (`user_fk`),
  KEY `med_fk` (`med_fk`),
  CONSTRAINT `user_meds_list_ibfk_1` FOREIGN KEY (`user_fk`) REFERENCES `users` (`user_pk`),
  CONSTRAINT `user_meds_list_ibfk_2` FOREIGN KEY (`med_fk`) REFERENCES `medications` (`med_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_meds_list`
--

LOCK TABLES `user_meds_list` WRITE;
/*!40000 ALTER TABLE `user_meds_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_meds_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_pk` int unsigned NOT NULL AUTO_INCREMENT,
  `pseudo_name` varchar(40) NOT NULL,
  `age` int NOT NULL,
  `date_of_eval` varchar(10) NOT NULL,
  `date_of_discharge` varchar(10) DEFAULT NULL,
  `med_dx_icd` varchar(20) NOT NULL,
  `tx_dx_icd` varchar(20) NOT NULL,
  PRIMARY KEY (`user_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 16:23:35
