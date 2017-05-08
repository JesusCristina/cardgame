-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cardgame
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `cartas`
--

DROP TABLE IF EXISTS `cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartas` (
  `id_carta` int(11) NOT NULL,
  `valor` varchar(2) COLLATE utf8_spanish2_ci NOT NULL,
  `palo` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id_carta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas`
--

LOCK TABLES `cartas` WRITE;
/*!40000 ALTER TABLE `cartas` DISABLE KEYS */;
INSERT INTO `cartas` VALUES (1,'2','Picas'),(2,'3','Picas'),(3,'4','Picas'),(4,'5','Picas'),(5,'6','Picas'),(6,'7','Picas'),(7,'8','Picas'),(8,'9','Picas'),(9,'10','Picas'),(10,'J','Picas'),(11,'Q','Picas'),(12,'K','Picas'),(13,'A','Picas'),(14,'2','Corazones'),(15,'3','Corazones'),(16,'4','Corazones'),(17,'5','Corazones'),(18,'6','Corazones'),(19,'7','Corazones'),(20,'8','Corazones'),(21,'9','Corazones'),(22,'10','Corazones'),(23,'J','Corazones'),(24,'Q','Corazones'),(25,'K','Corazones'),(26,'A','Corazones'),(27,'2','Tréboles'),(28,'3','Tréboles'),(29,'4','Tréboles'),(30,'5','Tréboles'),(31,'6','Tréboles'),(32,'7','Tréboles'),(33,'8','Tréboles'),(34,'9','Tréboles'),(35,'10','Tréboles'),(36,'J','Tréboles'),(37,'Q','Tréboles'),(38,'K','Tréboles'),(39,'A','Tréboles'),(40,'2','Diamantes'),(41,'3','Diamantes'),(42,'4','Diamantes'),(43,'5','Diamantes'),(44,'6','Diamantes'),(45,'7','Diamantes'),(46,'8','Diamantes'),(47,'9','Diamantes'),(48,'10','Diamantes'),(49,'J','Diamantes'),(50,'Q','Diamantes'),(51,'K','Diamantes'),(52,'A','Diamantes');
/*!40000 ALTER TABLE `cartas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores` (
  `id_jug` int(11) NOT NULL,
  `nombre` varchar(30) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_jug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'jesus'),(2,'cristina');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manos`
--

DROP TABLE IF EXISTS `manos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manos` (
  `id_mano` int(11) NOT NULL,
  `id_carta` int(11) NOT NULL,
  PRIMARY KEY (`id_mano`,`id_carta`),
  KEY `fk_mano_cartas_idx` (`id_carta`),
  CONSTRAINT `fk_mano_cartas` FOREIGN KEY (`id_carta`) REFERENCES `cartas` (`id_carta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manos`
--

LOCK TABLES `manos` WRITE;
/*!40000 ALTER TABLE `manos` DISABLE KEYS */;
/*!40000 ALTER TABLE `manos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidas`
--

DROP TABLE IF EXISTS `partidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partidas` (
  `id_partida` int(11) NOT NULL,
  `id_jug` int(11) NOT NULL,
  `id_mano` int(11) NOT NULL,
  PRIMARY KEY (`id_partida`,`id_jug`,`id_mano`),
  KEY `fk_part_jug_idx` (`id_jug`),
  KEY `fk_part_mano_idx` (`id_mano`),
  CONSTRAINT `fk_part_jug` FOREIGN KEY (`id_jug`) REFERENCES `jugadores` (`id_jug`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_part_mano` FOREIGN KEY (`id_mano`) REFERENCES `manos` (`id_mano`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidas`
--

LOCK TABLES `partidas` WRITE;
/*!40000 ALTER TABLE `partidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `partidas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08  1:23:43
