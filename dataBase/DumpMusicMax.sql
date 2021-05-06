-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: max_music
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birth_date` datetime NOT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id_client`),
  KEY `fk_client_role1_idx` (`id_role`),
  CONSTRAINT `fk_client_role1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Parsifal','Blasgen','pblasgen0@google.es','9I1KfL8WRR','1959-03-06 00:00:00',2),(2,'Heda','Orrill','horrill1@linkedin.com','bKTREECgmdLC','1990-09-07 00:00:00',1),(3,'Giffy','Matthius','gmatthius2@plala.or.jp','egV9dhD1ZRiw','1952-07-13 00:00:00',1),(4,'Neila','Cumpton','ncumpton3@nbcnews.com','31DuK2AYjg','1960-08-13 00:00:00',2),(5,'Worth','Torricella','wtorricella4@friendfeed.com','qrAcuor','2005-06-28 00:00:00',2),(6,'Bronson','Haselgrove','bhaselgrove5@nsw.gov.au','DE6TQF2IcO','1956-01-09 00:00:00',2),(7,'Farrell','Bradberry','fbradberry6@rediff.com','Ftg2HZd8l','1964-08-22 00:00:00',2),(8,'Merna','Perot','mperot7@businessweek.com','o00mLo','2015-10-04 00:00:00',1),(9,'Brigit','Rathbourne','brathbourne8@delicious.com','XBXI7j','1976-12-23 00:00:00',1),(10,'Addie','Shoosmith','ashoosmith9@arizona.edu','SMpLwtRnut','1995-05-23 00:00:00',2),(11,'Germana','Brockett','gbrocketta@flavors.me','QcML6wI475r','1996-10-29 00:00:00',1),(12,'Angele','Long','alongb@blogtalkradio.com','QWKAj0f5','1996-03-13 00:00:00',1),(13,'Marv','Deverson','mdeversonc@dropbox.com','XC3h98F01B','1976-05-30 00:00:00',2),(14,'Sanders','Denisot','sdenisotd@imdb.com','HBhUVRoG','1965-01-21 00:00:00',1),(15,'Aundrea','Wilsdon','awilsdone@oakley.com','2Z47kUw','1978-09-24 00:00:00',1),(16,'Grannie','McGeffen','gmcgeffenf@mit.edu','iz69DjHy','1960-09-12 00:00:00',2),(17,'Larina','Benard','lbenardg@google.fr','sRR0uYe','1961-09-01 00:00:00',2),(18,'Daffie','Clementson','dclementsonh@apache.org','ULDBb3vsdmxV','1962-06-25 00:00:00',2),(19,'Loralie','Putson','lputsoni@icio.us','NrmIVqGVYV','1998-12-13 00:00:00',2),(20,'Scottie','Gelderd','sgelderdj@webeden.co.uk','tdbchX','1961-05-25 00:00:00',1),(21,'Dall','Borgars','dborgarsk@imgur.com','z239R3Dln','1959-12-27 00:00:00',1),(22,'Temple','Blagden','tblagdenl@wisc.edu','AfhFEV','1983-09-09 00:00:00',1),(23,'Maxi','Paulley','mpaulleym@redcross.org','XSo2r17u','2011-03-17 00:00:00',1),(24,'Gerianna','Wimbridge','gwimbridgen@sina.com.cn','U3h3VTOnPY','2005-01-27 00:00:00',2),(25,'Dreddy','Saunper','dsaunpero@feedburner.com','X0QTTLze','1958-06-29 00:00:00',1),(26,'Sheffie','Weitzel','sweitzelp@ebay.com','PeQWA3IHQ','2003-11-01 00:00:00',2),(27,'Gertrudis','Walwood','gwalwoodq@networksolutions.com','6ohv6jLJODs6','1987-10-06 00:00:00',1),(28,'Stace','Dmych','sdmychr@drupal.org','2otIJRd','1988-11-30 00:00:00',2),(29,'Elton','Hitscher','ehitschers@google.pl','J3w5PTXdwUBB','2012-08-06 00:00:00',1),(30,'Miltie','Geffen','mgeffent@google.nl','6ykYW1','1973-12-04 00:00:00',1),(31,'Haily','Isakson','hisaksonu@telegraph.co.uk','JGTsn3Yj','1980-01-04 00:00:00',2),(32,'Clayton','Moncreiff','cmoncreiffv@psu.edu','PkNpIH','1965-11-21 00:00:00',1),(33,'Avictor','Sewter','asewterw@thetimes.co.uk','r4TEwZ','1956-11-23 00:00:00',2),(34,'Rudie','Gotcher','rgotcherx@washingtonpost.com','9LCejv5','2000-07-05 00:00:00',2),(35,'Hanny','Chinnock','hchinnocky@gizmodo.com','Pen4fu','2006-07-25 00:00:00',2),(36,'Anders','Hanley','ahanleyz@phoca.cz','zym91MdPoUi','1971-01-04 00:00:00',1),(37,'Tucky','Banbrigge','tbanbrigge10@weibo.com','C3P4uXhbshV','1969-08-01 00:00:00',1),(38,'Kippie','Tremeer','ktremeer11@apache.org','wlBX9l59k','1982-05-10 00:00:00',2),(39,'Lelia','Blackmore','lblackmore12@behance.net','QEWP5sd','1961-08-18 00:00:00',2),(40,'Persis','Coombe','pcoombe13@rakuten.co.jp','wAWfN89xIX3c','1955-07-28 00:00:00',2),(41,'Akim','Tomasi','atomasi14@goo.ne.jp','Wzbhh7','1960-01-29 00:00:00',1),(42,'Ansell','Blasik','ablasik15@slate.com','s3h3Sp','2007-06-26 00:00:00',2);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id_comment` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(1500) NOT NULL,
  `id_forum_topic` int NOT NULL,
  `likes` int NOT NULL,
  `unlikes` int NOT NULL,
  `date` datetime NOT NULL,
  `id_client_added_comment` int NOT NULL,
  `id_comment_reply` int DEFAULT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `fk_comment_forum_topic1_idx` (`id_forum_topic`),
  KEY `fk_comment_client1_idx` (`id_client_added_comment`),
  KEY `fk_comment_comment1_idx` (`id_comment_reply`),
  CONSTRAINT `fk_comment_client1` FOREIGN KEY (`id_client_added_comment`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_comment_comment1` FOREIGN KEY (`id_comment_reply`) REFERENCES `comment` (`id_comment`),
  CONSTRAINT `fk_comment_forum_topic1` FOREIGN KEY (`id_forum_topic`) REFERENCES `forum_topic` (`id_forum_topic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creator`
--

DROP TABLE IF EXISTS `creator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creator` (
  `id_creator` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id_creator`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creator`
--

LOCK TABLES `creator` WRITE;
/*!40000 ALTER TABLE `creator` DISABLE KEYS */;
INSERT INTO `creator` VALUES (1,'Bob','Dylan'),(2,'Paul','McCartney'),(3,'Stevie','Wonder'),(4,'Bob','Marley'),(5,'Elton','John'),(6,'Glenn','Danzig'),(7,'Marshall ','Mathers'),(8,'James','Hetfield'),(9,'Michael ','Jackson'),(10,'Kurt','Cobain'),(11,'David','Bowie'),(12,'Dolly','Parton'),(13,'Kanye','West '),(14,'Fatboy','Slim'),(15,'George','Michael'),(16,'Marina','Tucaković');
/*!40000 ALTER TABLE `creator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `festival`
--

DROP TABLE IF EXISTS `festival`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `festival` (
  `id_festival` int NOT NULL AUTO_INCREMENT,
  `description` varchar(1500) NOT NULL,
  `date_begin` datetime NOT NULL,
  `date_end` varchar(45) NOT NULL,
  `id_administrator` int NOT NULL,
  PRIMARY KEY (`id_festival`),
  KEY `fk_festival_client1_idx` (`id_administrator`),
  CONSTRAINT `fk_festival_client1` FOREIGN KEY (`id_administrator`) REFERENCES `client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `festival`
--

LOCK TABLES `festival` WRITE;
/*!40000 ALTER TABLE `festival` DISABLE KEYS */;
/*!40000 ALTER TABLE `festival` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `festival_comment`
--

DROP TABLE IF EXISTS `festival_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `festival_comment` (
  `id_festival_comment` int NOT NULL AUTO_INCREMENT,
  `text` varchar(1500) DEFAULT NULL,
  `id_festival` int NOT NULL,
  `id_client` int NOT NULL,
  PRIMARY KEY (`id_festival_comment`),
  KEY `fk_festival_comment_festival1_idx` (`id_festival`),
  KEY `fk_festival_comment_client1_idx` (`id_client`),
  CONSTRAINT `fk_festival_comment_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_festival_comment_festival1` FOREIGN KEY (`id_festival`) REFERENCES `festival` (`id_festival`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `festival_comment`
--

LOCK TABLES `festival_comment` WRITE;
/*!40000 ALTER TABLE `festival_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `festival_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum_topic`
--

DROP TABLE IF EXISTS `forum_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_topic` (
  `id_forum_topic` int NOT NULL AUTO_INCREMENT,
  `topic` varchar(500) NOT NULL,
  `date` datetime NOT NULL,
  `id_client` int NOT NULL,
  PRIMARY KEY (`id_forum_topic`),
  KEY `fk_forum_topic_client1_idx` (`id_client`),
  CONSTRAINT `fk_forum_topic_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_topic`
--

LOCK TABLES `forum_topic` WRITE;
/*!40000 ALTER TABLE `forum_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `forum_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fun_fact`
--

DROP TABLE IF EXISTS `fun_fact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fun_fact` (
  `id_fun_fact` int NOT NULL AUTO_INCREMENT,
  `text` varchar(999) NOT NULL,
  `id_administrator` int NOT NULL,
  PRIMARY KEY (`id_fun_fact`),
  KEY `fk_fun_fact_client1_idx` (`id_administrator`),
  CONSTRAINT `fk_fun_fact_client1` FOREIGN KEY (`id_administrator`) REFERENCES `client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fun_fact`
--

LOCK TABLES `fun_fact` WRITE;
/*!40000 ALTER TABLE `fun_fact` DISABLE KEYS */;
/*!40000 ALTER TABLE `fun_fact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id_genre` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_genre`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Goth'),(2,'Grunge'),(3,'Hard rock'),(4,'Indie rock'),(5,'Lo-fi'),(6,'New Wave'),(7,'Punk'),(8,'Blues'),(9,'Classical'),(10,'Opera'),(11,'Symphony'),(12,'Country'),(13,'Dubstep'),(14,'Electro House'),(15,'Disco'),(16,'Italo disco'),(17,'Techno'),(18,'Funk'),(19,'Jazz'),(20,'Electropop'),(21,'Folk'),(22,'Dark wave'),(23,'Rap'),(24,'Heavy metal'),(25,'Black metal'),(26,'Death metal'),(27,'Power metal'),(28,'Speed metal'),(29,'Thrash metal'),(30,'Post punk'),(31,'Soul'),(32,'Reggae'),(33,'Ska'),(34,'Classic rock'),(35,'Rock and roll'),(36,'Turbo folk'),(37,'Rockabilly'),(38,'Psychobilly'),(39,'Pop');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id_grade` int NOT NULL AUTO_INCREMENT,
  `grade` int NOT NULL,
  `date` datetime NOT NULL,
  `id_client` int NOT NULL,
  `id_song` int NOT NULL,
  PRIMARY KEY (`id_grade`),
  KEY `fk_grade_client1_idx` (`id_client`),
  KEY `fk_grade_song1_idx` (`id_song`),
  CONSTRAINT `fk_grade_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_grade_song1` FOREIGN KEY (`id_song`) REFERENCES `song` (`id_song`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impression`
--

DROP TABLE IF EXISTS `impression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `impression` (
  `id_impression` int NOT NULL AUTO_INCREMENT,
  `text` varchar(45) NOT NULL,
  `id_song` int NOT NULL,
  `id_client` int NOT NULL,
  PRIMARY KEY (`id_impression`),
  KEY `fk_impression_song1_idx` (`id_song`),
  KEY `fk_impression_client1_idx` (`id_client`),
  CONSTRAINT `fk_impression_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_impression_song1` FOREIGN KEY (`id_song`) REFERENCES `song` (`id_song`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impression`
--

LOCK TABLES `impression` WRITE;
/*!40000 ALTER TABLE `impression` DISABLE KEYS */;
/*!40000 ALTER TABLE `impression` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performer`
--

DROP TABLE IF EXISTS `performer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performer` (
  `id_performer` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(60) DEFAULT NULL,
  `band_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_performer`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performer`
--

LOCK TABLES `performer` WRITE;
/*!40000 ALTER TABLE `performer` DISABLE KEYS */;
INSERT INTO `performer` VALUES (1,'George','Michael',NULL),(2,'Fatboy','Slim',NULL),(3,'Jimi','Hendrix',NULL),(4,NULL,NULL,'Wham!'),(5,'Eminem',NULL,NULL),(6,NULL,NULL,'Nirvana'),(7,NULL,NULL,'U2'),(8,NULL,NULL,'Metallica'),(9,NULL,NULL,'Beatles'),(10,'Bob','Marley',NULL),(11,'Zdravko','Čolić',NULL),(12,'Dolly','Parton',NULL),(13,'Iggy','Pop',NULL),(14,'Michael ','Jackson',NULL),(15,NULL,NULL,'Misfits'),(16,'Kate ','Bush',NULL),(17,NULL,NULL,'Pointer Sisters'),(18,'Kanye','West',NULL);
/*!40000 ALTER TABLE `performer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'administrator'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `id_song` int NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `released` date NOT NULL,
  `id_performer` int NOT NULL,
  `id_author` int NOT NULL,
  `text_song` varchar(999) DEFAULT NULL,
  `id_client` int NOT NULL,
  `id_composer` int NOT NULL,
  PRIMARY KEY (`id_song`),
  KEY `fk_song_performer_idx` (`id_performer`),
  KEY `fk_song_author1_idx` (`id_author`),
  KEY `fk_song_client1_idx` (`id_client`),
  KEY `fk_song_creator1_idx` (`id_composer`),
  CONSTRAINT `fk_song_author1` FOREIGN KEY (`id_author`) REFERENCES `creator` (`id_creator`),
  CONSTRAINT `fk_song_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_song_creator1` FOREIGN KEY (`id_composer`) REFERENCES `creator` (`id_creator`),
  CONSTRAINT `fk_song_performer` FOREIGN KEY (`id_performer`) REFERENCES `performer` (`id_performer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song_has_genre`
--

DROP TABLE IF EXISTS `song_has_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song_has_genre` (
  `id_song_has_genre` int NOT NULL AUTO_INCREMENT,
  `id_song` int NOT NULL,
  `id_genre` int NOT NULL,
  PRIMARY KEY (`id_song_has_genre`),
  KEY `fk_song_has_genre_song1_idx` (`id_song`),
  KEY `fk_song_has_genre_genre1_idx` (`id_genre`),
  CONSTRAINT `fk_song_has_genre_genre1` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id_genre`),
  CONSTRAINT `fk_song_has_genre_song1` FOREIGN KEY (`id_song`) REFERENCES `song` (`id_song`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song_has_genre`
--

LOCK TABLES `song_has_genre` WRITE;
/*!40000 ALTER TABLE `song_has_genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `song_has_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url_link`
--

DROP TABLE IF EXISTS `url_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `url_link` (
  `id_URL` int NOT NULL AUTO_INCREMENT,
  `url_resource` varchar(255) DEFAULT NULL,
  `id_fun_fact` int DEFAULT NULL,
  `id_song` int DEFAULT NULL,
  PRIMARY KEY (`id_URL`),
  KEY `fk_URL_fun_fact1_idx` (`id_fun_fact`),
  KEY `fk_URL_song1_idx` (`id_song`),
  CONSTRAINT `fk_URL_fun_fact1` FOREIGN KEY (`id_fun_fact`) REFERENCES `fun_fact` (`id_fun_fact`),
  CONSTRAINT `fk_URL_song1` FOREIGN KEY (`id_song`) REFERENCES `song` (`id_song`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url_link`
--

LOCK TABLES `url_link` WRITE;
/*!40000 ALTER TABLE `url_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `url_link` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 13:40:53
