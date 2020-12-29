-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id_aluno` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `role_nome_role` varchar(255) DEFAULT NULL,
  `turma_id_turma` bigint DEFAULT NULL,
  `usuario_login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  KEY `FK2sosdbme3euk4s00chpm5ype1` (`role_nome_role`),
  KEY `FK5kkri9c91iymhc5vfiv6333fy` (`turma_id_turma`),
  KEY `FK37l7fa8c8s6d48i38kanu12kr` (`usuario_login`),
  CONSTRAINT `FK2sosdbme3euk4s00chpm5ype1` FOREIGN KEY (`role_nome_role`) REFERENCES `role` (`nome_role`),
  CONSTRAINT `FK37l7fa8c8s6d48i38kanu12kr` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`),
  CONSTRAINT `FK5kkri9c91iymhc5vfiv6333fy` FOREIGN KEY (`turma_id_turma`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'teste@gmail.com',123132,'teste 1 ',NULL,1,NULL),(2,'teste3@gmail.com',18,'teste2','ROLE_ADMIN',1,'teste3'),(3,'admin@hotmail.com',0,'admin','ROLE_ALUNO',1,'admin'),(4,'alunoTeste@gmail.com',123,'alunoTeste','ROLE_ALUNO',1,'aluno'),(5,'dsad@asdsda',15,'aluno','ROLE_ALUNO',1,'aluno1'),(6,'asdas@sada',45,'alunoteste1','ROLE_ALUNO',1,'alunoteste1'),(7,'',0,'','ROLE_ADMIN',1,''),(8,'asd@sad',15,'ALFACE1','ROLE_ALUNO',1,'alface1'),(9,'adas@saas',15,'teste5','ROLE_ALUNO',1,'teste5'),(10,'asdsa@sda',15,'teste6','',1,'teste6'),(11,'asda@sda',15,'teste7',NULL,1,'teste7'),(12,'dsa@das',15,'tesste8',NULL,1,'teste8'),(13,'dscs@sda',15,'teste9',NULL,1,'teste9'),(14,'sda@dsa',15,'teste10',NULL,1,'teste10'),(15,'sda@da',12,'teste11',NULL,1,'teste11'),(16,'teste12@sda',15,'teste12','ROLE_ALUNO',1,'teste12'),(17,'dsa@sda',15,'gustavo',NULL,1,'gustavoaluno'),(18,'gga2sd@fs',14,'ggg',NULL,1,'ggg'),(19,'qqq@sad',14,'qqq',NULL,1,'qqq'),(20,'dfggd@asd',12,'kkkk','ROLE_ALUNO',1,'kkkk'),(21,'asds@sfa',25,'ÇÇÇALTERADO','ROLE_ALUNO',1,'ççç');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id_disciplina` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (2,'Historia',_binary ''),(3,'Biologia',_binary '\0');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_turma`
--

DROP TABLE IF EXISTS `disciplina_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina_turma` (
  `disciplina_id_disciplina` bigint NOT NULL,
  `turma_id_turma` bigint NOT NULL,
  UNIQUE KEY `UK_501urpq88tc5co64plqc07e21` (`turma_id_turma`),
  KEY `FK8urd85xe6034f45a5y9mfd4px` (`disciplina_id_disciplina`),
  CONSTRAINT `FK8urd85xe6034f45a5y9mfd4px` FOREIGN KEY (`disciplina_id_disciplina`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `FKoa18js4pymq5dvxp6kp4gv672` FOREIGN KEY (`turma_id_turma`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_turma`
--

LOCK TABLES `disciplina_turma` WRITE;
/*!40000 ALTER TABLE `disciplina_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id_docente` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `formacao` varchar(255) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_docente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'marcos@hortmail.com','mestre',45,'Marcos');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente_turma`
--

DROP TABLE IF EXISTS `docente_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente_turma` (
  `docente_id_docente` bigint NOT NULL,
  `turma_id_turma` bigint NOT NULL,
  UNIQUE KEY `UK_pb9eb8k0eyg0ojaht6bn2p9lm` (`turma_id_turma`),
  KEY `FK7inbs6t9jpcq0okob21m63ov5` (`docente_id_docente`),
  CONSTRAINT `FK7inbs6t9jpcq0okob21m63ov5` FOREIGN KEY (`docente_id_docente`) REFERENCES `docente` (`id_docente`),
  CONSTRAINT `FKhnb64asks43iei38odeuqonrp` FOREIGN KEY (`turma_id_turma`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente_turma`
--

LOCK TABLES `docente_turma` WRITE;
/*!40000 ALTER TABLE `docente_turma` DISABLE KEYS */;
INSERT INTO `docente_turma` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `docente_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `nome_role` varchar(255) NOT NULL,
  PRIMARY KEY (`nome_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (''),('ROLE_ADMIN'),('ROLE_ALUNO'),('ROLE_DOCENTE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `id_turma` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `disciplina_id_disciplina` bigint NOT NULL,
  `docente_id_docente` bigint DEFAULT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `FKrngef6eef3phimgpdxmr22k52` (`disciplina_id_disciplina`),
  KEY `FKlwnoff8pqinhp6xyaou9f65in` (`docente_id_docente`),
  CONSTRAINT `FKlwnoff8pqinhp6xyaou9f65in` FOREIGN KEY (`docente_id_docente`) REFERENCES `docente` (`id_docente`),
  CONSTRAINT `FKrngef6eef3phimgpdxmr22k52` FOREIGN KEY (`disciplina_id_disciplina`) REFERENCES `disciplina` (`id_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'TURMA 1',2,1),(2,'Turma ABC',2,1),(3,'Turma ABC',2,1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_aluno`
--

DROP TABLE IF EXISTS `turma_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma_aluno` (
  `turma_id_turma` bigint NOT NULL,
  `aluno_id_aluno` bigint NOT NULL,
  UNIQUE KEY `UK_46ov151fo0e9ou8si0dp88ht4` (`aluno_id_aluno`),
  KEY `FK6p3d6841t15ggpt2fseeayu6c` (`turma_id_turma`),
  CONSTRAINT `FK6p3d6841t15ggpt2fseeayu6c` FOREIGN KEY (`turma_id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `FKn39yfku5w5fph9y0o28m7xu0b` FOREIGN KEY (`aluno_id_aluno`) REFERENCES `aluno` (`id_aluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_aluno`
--

LOCK TABLES `turma_aluno` WRITE;
/*!40000 ALTER TABLE `turma_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `turma_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('','$2a$10$e7gBvm6.SnK0nLVhyJWgiuv.N4jLMzxatgtxTGmFfBcHZ7xDtFOiW'),('admin','$2a$10$Wqsxks/L2m.w65mOg03ZoeZcCdyE80NbzQHzjcwvkAg0CBwhSJ006'),('alface','alface1'),('alface1','$2a$10$NV1xxTIImFWLju.vG/lHYuHWf1fcapwWTgQfC.VB8eec7gczAButi'),('aluno','$2a$10$mcTzFvI3O/moPGRLrKD8jOEqAQJnCcZOQYvF0MEWtNwgy9UrSkO3q'),('aluno1','$2a$10$e/nYcqX6z3mUpurt2WQyo.ZKdtup0i5GLSvi324szvUkZQ9Fn3oLK'),('alunoteste1','$2a$10$9y5JjfblZXFx7TU4Ftegy.LF4xktBgplWiN6STAW7/gDTCGGOoaUa'),('ççç','$2a$10$gJKER84zY2byzqipyROk6erqZUdTqhQPWa/DKFKcFdufFdyg6fVza'),('ççç1','$2a$10$HQ.QnQUSgRY0tBoOfj5sWuOQPZb/.2u9vWoVi6RIsvCNF6hyVEpAK'),('ggg','$2a$10$zCRcU62X1I87bVZVWTE69uJ1A6Eh0iIosEO.bFanouzjyNb10OtbG'),('gustavo','$2a$10$6B.7LUo.zlPxHMLLmfwPWe6QDsyhdSwbLogU9jMBZl5VGwTskmAY6'),('gustavoaluno','$2a$10$tNRChIL.qLdBPk/zjCYKZ.klV.p1LKC3lctRdDf5wp0p6RycFW1KK'),('kkkk','$2a$10$e2ZQQMHVf4sFCPy7V2PqIOaSPsDy88hYRJgyNS.LVVAkHsslL0Tdu'),('qqq','$2a$10$amQ4I7bckEOy30WBXAX8IuLn87CSJvB8FWSPrmrXVW5JF8u3CbVge'),('teste','teste'),('teste10','$2a$10$RD.G9vZqVrB5UpNvi8J.1uw.1GjupxHUZ7ByzJzGymS.FHAV0ZEYa'),('teste11','$2a$10$Vb8ImiNnRVETjR4GdgMEkOJ0KJqyQJiOsHb9Z3NCH78OhOhHal4TC'),('teste12','$2a$10$QjfyIIx5Xi7QmqrpkiWdlOwu3t/ppRzAdfFuppjtBLA6DtBTZMe86'),('teste3','teste3'),('teste5','$2a$10$zyux49sLOAxO3VQtobjMheyPvwuni8vbVQ9KHDUtdlk/kQGfaa1x2'),('teste6','$2a$10$SokNZCoUeDX7YMFiyoo9Ius3mCu/w0YJ/K6CdmN9Cdi1MlGNitLUu'),('teste7','$2a$10$2Db183XzF4WpaAtn4/vzWeJm6OJz560vSAQPPdMPd6D9tBp1sxXfW'),('teste8','$2a$10$jK9VcGnT7zQlI1ms8s5rh.y49AC/QprVJDiIKriYN3Amo5FNx1FWC'),('teste9','$2a$10$HbbFSVeXwup/gjmCjYzDCeqfqkV9rTeSe2OiBY.9pvVh9ru8LGeNm');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_alunos`
--

DROP TABLE IF EXISTS `usuario_alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_alunos` (
  `usuario_login` varchar(255) NOT NULL,
  `alunos_id_aluno` bigint NOT NULL,
  UNIQUE KEY `UK_hq990jkl8sc6e96i1snqas65c` (`alunos_id_aluno`),
  KEY `FKrann3a8vlm1jbfmxcusd67dhv` (`usuario_login`),
  CONSTRAINT `FK89vfs4d4ynlbl62cf0fvdpm7d` FOREIGN KEY (`alunos_id_aluno`) REFERENCES `aluno` (`id_aluno`),
  CONSTRAINT `FKrann3a8vlm1jbfmxcusd67dhv` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_alunos`
--

LOCK TABLES `usuario_alunos` WRITE;
/*!40000 ALTER TABLE `usuario_alunos` DISABLE KEYS */;
INSERT INTO `usuario_alunos` VALUES ('',7),('aluno',4),('aluno1',5),('alunoteste1',6),('ggg',18),('gustavo',3),('gustavoaluno',17),('kkkk',20),('qqq',19),('teste10',14),('teste11',15),('teste12',16),('teste3',2),('teste5',9),('teste6',10),('teste7',11),('teste8',12),('teste9',13);
/*!40000 ALTER TABLE `usuario_alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_roles` (
  `usuario_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  KEY `FKefntoswg8cckktsk0ha1wpm0i` (`role_id`),
  KEY `FKebiaxjbamgu326glxo1fbysuh` (`usuario_id`),
  CONSTRAINT `FKebiaxjbamgu326glxo1fbysuh` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`login`),
  CONSTRAINT `FKefntoswg8cckktsk0ha1wpm0i` FOREIGN KEY (`role_id`) REFERENCES `role` (`nome_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_roles`
--

LOCK TABLES `usuarios_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
INSERT INTO `usuarios_roles` VALUES ('teste3','ROLE_ADMIN'),('gustavo','ROLE_ADMIN'),('aluno','ROLE_ALUNO'),('aluno1','ROLE_ALUNO'),('alunoteste1','ROLE_ALUNO'),('','ROLE_ADMIN'),('teste5','ROLE_ALUNO'),('teste6',''),('teste12','ROLE_ALUNO'),('kkkk','ROLE_ALUNO'),('ççç1','ROLE_ALUNO'),('ççç','ROLE_ALUNO'),('admin','ROLE_ADMIN');
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-28 23:13:46
