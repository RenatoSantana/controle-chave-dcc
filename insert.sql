CREATE DATABASE  IF NOT EXISTS `controle_chave` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `controle_chave`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: controle_chave
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `matricula` varchar(9) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `id_departamento` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_departamento`),
  KEY `fk_aluno_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_aluno_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (2,'Teste2','teste','teste',1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chave`
--

DROP TABLE IF EXISTS `chave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `id_laboratorio` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_laboratorio`),
  KEY `fk_Chave_sala1_idx` (`id_laboratorio`),
  CONSTRAINT `fk_Chave_sala1` FOREIGN KEY (`id_laboratorio`) REFERENCES `laboratorio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chave`
--

LOCK TABLES `chave` WRITE;
/*!40000 ALTER TABLE `chave` DISABLE KEYS */;
INSERT INTO `chave` VALUES (1,'Chave 147',1);
/*!40000 ALTER TABLE `chave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chave_com_aluno`
--

DROP TABLE IF EXISTS `chave_com_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chave_com_aluno` (
  `id_chave` int(11) NOT NULL,
  `id_aluno_anterior` int(11) NOT NULL,
  `id_aluno_posterior` int(11) DEFAULT NULL,
  `dataHoraPosseChave` datetime DEFAULT NULL,
  `dataHoraEntregaChave` datetime DEFAULT NULL,
  `id_status` int(11) NOT NULL,
  KEY `fk_Chave_has_aluno_aluno1_idx` (`id_aluno_anterior`),
  KEY `fk_Chave_has_aluno_Chave1_idx` (`id_chave`),
  KEY `fK_status_idx` (`id_status`),
  CONSTRAINT `fK_status` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Chave_has_aluno_Chave1` FOREIGN KEY (`id_chave`) REFERENCES `chave` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Chave_has_aluno_aluno1` FOREIGN KEY (`id_aluno_anterior`) REFERENCES `aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chave_com_aluno`
--

LOCK TABLES `chave_com_aluno` WRITE;
/*!40000 ALTER TABLE `chave_com_aluno` DISABLE KEYS */;
INSERT INTO `chave_com_aluno` VALUES (1,2,NULL,NULL,NULL,1),(1,2,NULL,'2016-01-01 00:00:00',NULL,2);
/*!40000 ALTER TABLE `chave_com_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `id_instituto` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_instituto`),
  KEY `fk_departamento_instituto1_idx` (`id_instituto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Computação',1),(2,'Estatística',1),(3,'Matemática',1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituto`
--

DROP TABLE IF EXISTS `instituto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituto` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituto`
--

LOCK TABLES `instituto` WRITE;
/*!40000 ALTER TABLE `instituto` DISABLE KEYS */;
INSERT INTO `instituto` VALUES (1,'IM');
/*!40000 ALTER TABLE `instituto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(6) DEFAULT NULL,
  `id_departamento` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_departamento`),
  KEY `fk_sala_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_sala_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorio`
--

LOCK TABLES `laboratorio` WRITE;
/*!40000 ALTER TABLE `laboratorio` DISABLE KEYS */;
INSERT INTO `laboratorio` VALUES (1,'147',1);
/*!40000 ALTER TABLE `laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Pendente'),(2,'Aceito');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-27 20:44:42
