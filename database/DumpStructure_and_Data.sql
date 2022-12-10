-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: stumanagerdb
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
-- Table structure for table `tb_class`
--

DROP TABLE IF EXISTS `tb_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_class` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) DEFAULT NULL,
  `specName` varchar(100) DEFAULT NULL,
  `className` int(11) NOT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_class`
--

LOCK TABLES `tb_class` WRITE;
/*!40000 ALTER TABLE `tb_class` DISABLE KEYS */;
INSERT INTO `tb_class` VALUES (1,'Computer College','Software Engineering',1),(3,'Computer College','Computer Science',2),(5,'Art College','Fashion design',1),(6,'Engineering College','Information System',2),(7,'Engineering College','Information System',1),(8,'Computer College','Computer Science',1),(9,'Science College','Physics',1),(10,'Science College','Physics',2),(11,'Computer College','Software Engineering',2);
/*!40000 ALTER TABLE `tb_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cource`
--

DROP TABLE IF EXISTS `tb_cource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cource` (
  `courceId` int(11) NOT NULL AUTO_INCREMENT,
  `courceName` varchar(100) NOT NULL,
  `courceHour` float DEFAULT NULL,
  `courceSpecName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`courceId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cource`
--

LOCK TABLES `tb_cource` WRITE;
/*!40000 ALTER TABLE `tb_cource` DISABLE KEYS */;
INSERT INTO `tb_cource` VALUES (1,'Calculus',2.5,'Physics'),(2,'Database',1.5,'Information System'),(3,'Computer Networks',5.5,'Computer Science'),(4,'Java Programming',3,'Software Engineering'),(5,'Data structure',3,'Software Engineering'),(6,'mechanics',1.5,'physics'),(7,'Art design',1.5,'Fashion design'),(8,'marketing',2.5,'Fashion design');
/*!40000 ALTER TABLE `tb_cource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_depart`
--

DROP TABLE IF EXISTS `tb_depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_depart` (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) NOT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_depart`
--

LOCK TABLES `tb_depart` WRITE;
/*!40000 ALTER TABLE `tb_depart` DISABLE KEYS */;
INSERT INTO `tb_depart` VALUES (1,'Computer College'),(3,'Art College'),(4,'Engineering College'),(5,'Science College'),(7,'物理学院');
/*!40000 ALTER TABLE `tb_depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_score`
--

DROP TABLE IF EXISTS `tb_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_score` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `courceName` varchar(100) NOT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_score`
--

LOCK TABLES `tb_score` WRITE;
/*!40000 ALTER TABLE `tb_score` DISABLE KEYS */;
INSERT INTO `tb_score` VALUES (1,3001,'Java programming',95),(3,3002,'Calculus',59),(5,3004,'Calculus',96),(7,3001,'Data structure',97),(8,3006,'Calculus',100);
/*!40000 ALTER TABLE `tb_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_spec`
--

DROP TABLE IF EXISTS `tb_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_spec` (
  `specId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) DEFAULT NULL,
  `specName` varchar(100) NOT NULL,
  PRIMARY KEY (`specId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_spec`
--

LOCK TABLES `tb_spec` WRITE;
/*!40000 ALTER TABLE `tb_spec` DISABLE KEYS */;
INSERT INTO `tb_spec` VALUES (1,'Computer College','Computer Science'),(3,'Art College','Fashion design'),(5,'Computer College','Software Engineering'),(6,'Science College','Physics'),(7,'Engineering College','Information System'),(14,'Computer College','Cyber security');
/*!40000 ALTER TABLE `tb_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `stuName` varchar(20) NOT NULL,
  `stuDepart` varchar(100) DEFAULT NULL,
  `stuSpec` varchar(100) DEFAULT NULL,
  `stuClass` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  UNIQUE KEY `stuNumber_UNIQUE` (`stuNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_student`
--

LOCK TABLES `tb_student` WRITE;
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
INSERT INTO `tb_student` VALUES (1,3001,'yyl','Computer College','Software Engineering',1),(4,3003,'zzz','Computer College','Computer Science',2),(6,3002,'zdm','Computer College','Software Engineering',1),(7,3004,'yuyueliang','Engineering College','Information System',2),(8,3005,'day','Engineering College','Information System',2),(9,3006,'lly','Science college','Physics',1),(10,3007,'Mark','Science College','Physics',1),(11,3008,'yhq','Science','Physics',1),(13,3009,'jack','Art College','Fashion design',1);
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userPwd` varchar(45) DEFAULT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'admin','',1),(4,'test','bbb',2),(5,'abc','123',2);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-29 20:46:25
