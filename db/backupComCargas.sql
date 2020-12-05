-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: eventdb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) DEFAULT NULL,
  `DESCRICAO` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'congresso/seminário','Encontros para educação ex: gdg'),(2,'curso/workshop','reuniões para aprendizado'),(3,'esportivo','eventos relacionados a esportes'),(4,'feira/exposição','reuniões sobre feiras ou exposições'),(5,'show/musica/festa','festivos com musica e apresentações');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificado` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `LINK` varchar(50) DEFAULT NULL,
  `ID_EVENTO` int DEFAULT NULL,
  `ID_USUARIO` int DEFAULT NULL,
  `DATAEMISSAO` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_EVENTO` (`ID_EVENTO`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  CONSTRAINT `certificado_ibfk_1` FOREIGN KEY (`ID_EVENTO`) REFERENCES `evento` (`ID`),
  CONSTRAINT `certificado_ibfk_2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificado`
--

LOCK TABLES `certificado` WRITE;
/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
INSERT INTO `certificado` VALUES (1,'certificados/caio.pdf',6,2,'2020-11-22');
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CEP` char(9) DEFAULT NULL,
  `RUA` varchar(60) DEFAULT NULL,
  `NUMERO` int DEFAULT NULL,
  `BAIRRO` varchar(60) DEFAULT NULL,
  `COMPLEMENTO` varchar(60) DEFAULT NULL,
  `CIDADE` varchar(60) DEFAULT NULL,
  `ESTADO` char(2) DEFAULT NULL,
  `LINK` varchar(60) DEFAULT NULL,
  `PLATAFORMA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'38408251','Av. José Roberto Migliorini',0,'Santa Mônica','Estadio parque sabiá','Uberlândia','MG',NULL,NULL),(2,'38411104','R. Blanche Galassi',150,'Altamira, Uberlândia','Predio na esquina branco','Uberlândia','MG',NULL,NULL),(3,'38411411','Av. Lidormira Borges do Nascimento',2005,'Shopping Park','predio bonito top grama na porta','Uberlândia','MG',NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'https://meet.google.com/pav-uyfw-gbvedads','Google Meet'),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'https://meet.google.com/asv-asdw-ggertccs','Google Meet');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(60) DEFAULT NULL,
  `IMAGEM` varchar(100) DEFAULT NULL,
  `DATAHORAINICIO` datetime DEFAULT NULL,
  `DATAHORATERMINO` datetime DEFAULT NULL,
  `DESCRICAO` varchar(300) DEFAULT NULL,
  `QTDMAXIMAINGRESSO` int DEFAULT NULL,
  `ID_USUARIO` int DEFAULT NULL,
  `ID_CATEGORIA` int DEFAULT NULL,
  `ID_ENDERECO` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  KEY `ID_CATEGORIA` (`ID_CATEGORIA`),
  KEY `evento_ibfk_3` (`ID_ENDERECO`),
  CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`),
  CONSTRAINT `evento_ibfk_2` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`),
  CONSTRAINT `evento_ibfk_3` FOREIGN KEY (`ID_ENDERECO`) REFERENCES `endereco` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (6,'Seminário GDG','imagens/gdg.png','2020-10-05 11:30:00','2020-10-06 17:00:00','Evento sobre tecnologia que voce precisa ver!',400,3,1,4),(7,'Curso sobre python','imagens/python.png','2020-11-27 14:00:00','2020-11-27 18:00:00','Curso de python para iniciantes',50,3,2,5),(8,'Curso sobre java','imagens/java.png','2020-11-27 14:00:00','2020-11-27 19:00:00','Curso de java para iniciantes',50,6,2,1),(9,'Jogo de futebol para 8 times','imagens/futebol.png','2020-12-01 14:30:00','2020-12-01 18:00:00','Jogo de futebol em quadra society com 8 times e premio para o campeao',40,5,3,2),(10,'Udi reveillon 2021','imagens/udireve.png','2020-12-31 22:00:00','2021-01-01 08:30:00','Evento para reunião e fogos para o reveillon de 2021!',10000,6,5,3);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresso`
--

DROP TABLE IF EXISTS `ingresso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresso` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `VALOR` decimal(6,2) DEFAULT NULL,
  `DATAHORAPAGAMENTO` datetime DEFAULT NULL,
  `FORMAPAGAMENTO` char(2) DEFAULT NULL,
  `VALORPAGAMENTO` decimal(6,2) DEFAULT NULL,
  `DATAHORAAQUISICAO` datetime DEFAULT NULL,
  `ID_USUARIO` int DEFAULT NULL,
  `ID_EVENTO` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  KEY `ID_EVENTO` (`ID_EVENTO`),
  CONSTRAINT `ingresso_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`),
  CONSTRAINT `ingresso_ibfk_2` FOREIGN KEY (`ID_EVENTO`) REFERENCES `evento` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresso`
--

LOCK TABLES `ingresso` WRITE;
/*!40000 ALTER TABLE `ingresso` DISABLE KEYS */;
INSERT INTO `ingresso` VALUES (1,0.00,'2020-10-06 17:00:00','CC',0.00,'2020-10-06 17:00:00',2,6),(2,30.00,'2020-11-25 18:00:00','BB',30.00,'2020-11-25 18:00:00',3,7),(3,30.00,'2020-11-24 18:00:00','CC',15.00,'2020-11-24 18:00:00',4,7),(4,500.00,'2020-10-18 18:03:00','CC',500.00,'2020-10-18 18:03:00',6,10),(5,8.00,'2020-10-18 17:03:00','BB',8.00,'2020-10-18 17:03:00',2,9);
/*!40000 ALTER TABLE `ingresso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RAZAOSOCIAL` varchar(60) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `SENHA` varchar(100) DEFAULT NULL,
  `TELEFONE` varchar(60) DEFAULT NULL,
  `DATANASCIMENTO` date DEFAULT NULL,
  `CPF` char(11) DEFAULT NULL,
  `CNPJ` char(14) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'caio','cesar silva','caiosilva@gmail.com','123456','34995625487','1998-02-15',NULL,'98756321654527'),(3,'amanda','teixeira','amandateixeira@gmail.com','123456','34995647854','1960-05-27',NULL,'68732135468444'),(4,'patricia','tostes','patriciatostes@gmail.com','123456','34983599945','1997-06-13','41045874514',NULL),(5,'lucas','pereira','lucaspereira@gmail.com','123456','34984568794','1985-03-21','65487452157',NULL),(6,'ricardo','cavalcante','ricardocavalcante@gmail.com','123456','34998652247','1977-11-03','36548798458',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-05 17:12:08
