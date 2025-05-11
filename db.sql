-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: rentacar
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branches` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `manager_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hw68nd07qk3jrjfg70qxq9vb7` (`name`),
  KEY `FK5px87q4tfp6w39g58weglw4h7` (`manager_id`),
  CONSTRAINT `FK5px87q4tfp6w39g58weglw4h7` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` VALUES (1,_binary '','Beyoğlu, İstiklal Caddesi No: 123','İstanbul','İstanbul Merkez','+90 212 555 1212',NULL),(2,_binary '','Kadıköy, Bağdat Caddesi No: 456','İstanbul','İstanbul Anadolu','+90 216 444 3434',NULL),(3,_binary '','Bakırköy, İncirli Caddesi No: 789','İstanbul','İstanbul Avrupa','+90 212 666 5656',NULL),(4,_binary '','Sarıyer, Cumhuriyet Caddesi No: 101','İstanbul','İstanbul Kuzey','+90 212 777 7878',NULL),(5,_binary '','Ataşehir, Barbaros Bulvarı No: 202','İstanbul','İstanbul Güney','+90 216 888 9090',NULL),(6,_binary '','Çankaya, Tunalı Hilmi Caddesi No: 78','Ankara','Ankara Merkez','+90 312 333 5656',NULL),(7,_binary '','Yenimahalle, Batıkent Bulvarı No: 45','Ankara','Ankara Batıkent','+90 312 222 4545',NULL),(8,_binary '','Kızılay, Ziya Gökalp Caddesi No: 67','Ankara','Ankara Kızılay','+90 312 111 2323',NULL),(9,_binary '','Çayyolu, Ümitköy Caddesi No: 89','Ankara','Ankara Ümitköy','+90 312 999 7878',NULL),(10,_binary '','Çayyolu, Alacaatlı Caddesi No: 123','Ankara','Ankara Çayyolu','+90 312 888 6565',NULL),(11,_binary '','Konak, Cumhuriyet Bulvarı No: 90','İzmir','İzmir Merkez','+90 232 222 7878',NULL),(12,_binary '','Karşıyaka, Cemal Gürsel Caddesi No: 34','İzmir','İzmir Karşıyaka','+90 232 333 4545',NULL),(13,_binary '','Bornova, Kazım Dirik Caddesi No: 56','İzmir','İzmir Bornova','+90 232 444 6767',NULL),(14,_binary '','Alsancak, Kıbrıs Şehitleri Caddesi No: 78','İzmir','İzmir Alsancak','+90 232 555 8989',NULL),(15,_binary '','Çeşme, Atatürk Bulvarı No: 90','İzmir','İzmir Çeşme','+90 232 666 1212',NULL),(16,_binary '','Muratpaşa, Işıklar Caddesi No: 45','Antalya','Antalya Merkez','+90 242 111 9898',NULL),(17,_binary '','Konyaaltı, Atatürk Bulvarı No: 67','Antalya','Antalya Konyaaltı','+90 242 222 8787',NULL),(18,_binary '','Lara, Lara Caddesi No: 89','Antalya','Antalya Lara','+90 242 333 7676',NULL),(19,_binary '','Kemer, Sahil Caddesi No: 101','Antalya','Antalya Kemer','+90 242 444 6565',NULL),(20,_binary '','Alanya, Atatürk Caddesi No: 123','Antalya','Antalya Alanya','+90 242 555 5454',NULL),(21,_binary '','Osmangazi, Fevzi Çakmak Caddesi No: 32','Bursa','Bursa Merkez','+90 224 666 1010',NULL),(22,_binary '','Nilüfer, 23 Nisan Bulvarı No: 45','Bursa','Bursa Nilüfer','+90 224 777 2020',NULL),(23,_binary '','İnegöl, Ankara Yolu No: 67','Bursa','Bursa İnegöl','+90 224 888 3030',NULL),(24,_binary '','Mudanya, Sahil Caddesi No: 89','Bursa','Bursa Mudanya','+90 224 999 4040',NULL),(25,_binary '','Gemlik, İstiklal Caddesi No: 101','Bursa','Bursa Gemlik','+90 224 111 5050',NULL),(26,_binary '','Seyhan, Atatürk Caddesi No: 67','Adana','Adana Merkez','+90 322 777 2323',NULL),(27,_binary '','Çukurova, Turgut Özal Bulvarı No: 45','Adana','Adana Çukurova','+90 322 888 3434',NULL),(28,_binary '','Yüreğir, Karataş Bulvarı No: 78','Adana','Adana Yüreğir','+90 322 999 4545',NULL),(29,_binary '','Ceyhan, D-400 Karayolu No: 90','Adana','Adana Ceyhan','+90 322 111 5656',NULL),(30,_binary '','Kozan, Cumhuriyet Caddesi No: 112','Adana','Adana Kozan','+90 322 222 6767',NULL),(31,_binary '','Ortahisar, Maraş Caddesi No: 54','Trabzon','Trabzon Merkez','+90 462 888 4545',NULL),(32,_binary '','Tepebaşı, İsmet İnönü Caddesi No: 21','Eskişehir','Eskişehir Merkez','+90 222 999 6767',NULL),(33,_binary '','Şehitkamil, Prof. Dr. Muammer Aksoy Bulvarı No: 89','Gaziantep','Gaziantep Merkez','+90 342 111 2222',NULL),(34,_binary '','Kayapınar, Diclekent Bulvarı No: 101','Diyarbakır','Diyarbakır Merkez','+90 412 333 4444',NULL),(35,_binary '','Selçuklu, Feritpaşa Mahallesi No: 33','Konya','Konya Merkez','+90 332 555 6666',NULL),(36,_binary '','İlkadım, Cumhuriyet Meydanı No: 15','Samsun','Samsun Merkez','+90 362 777 8888',NULL),(37,_binary '','Melikgazi, Sivas Bulvarı No: 43','Kayseri','Kayseri Merkez','+90 352 999 0000',NULL),(38,_binary '','Yenişehir, Bahçelievler Mahallesi No: 22','Mersin','Mersin Merkez','+90 324 111 3333',NULL),(39,_binary '','Serdivan, Arabacıalanı Mahallesi No: 77','Sakarya','Sakarya Merkez','+90 264 555 7777',NULL),(40,_binary '','Pamukkale, Üniversite Caddesi No: 55','Denizli','Denizli Merkez','+90 258 333 9999',NULL),(41,_binary '','Yeşilyurt, Turgut Özal Bulvarı No: 38','Malatya','Malatya Merkez','+90 422 111 5555',NULL),(42,_binary '','İpekyolu, Cumhuriyet Caddesi No: 71','Van','Van Merkez','+90 432 222 6666',NULL),(43,_binary '','Yakutiye, Atatürk Üniversitesi Bulvarı No: 29','Erzurum','Erzurum Merkez','+90 442 444 8888',NULL),(44,_binary '','Haliliye, İpekyol Bulvarı No: 63','Şanlıurfa','Şanlıurfa Merkez','+90 414 666 0000',NULL),(45,_binary '','Antakya, Atatürk Caddesi No: 51','Hatay','Hatay Merkez','+90 326 888 2222',NULL),(46,_binary '','Şehzadeler, 8 Eylül Mahallesi No: 19','Manisa','Manisa Merkez','+90 236 777 4444',NULL),(47,_binary '','Karesi, Anafartalar Caddesi No: 83','Balıkesir','Balıkesir Merkez','+90 266 555 6666',NULL),(48,_binary '','Dulkadiroğlu, Trabzon Bulvarı No: 47','Kahramanmaraş','Kahramanmaraş Merkez','+90 344 333 8888',NULL),(49,_binary '','Efeler, Adnan Menderes Bulvarı No: 36','Aydın','Aydın Merkez','+90 256 111 0000',NULL);
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracts`
--

DROP TABLE IF EXISTS `contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contracts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `contract_number` varchar(255) NOT NULL,
  `daily_rate` double NOT NULL,
  `deposit_amount` double DEFAULT NULL,
  `end_date` date NOT NULL,
  `km_end` int DEFAULT NULL,
  `km_start` int NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `start_date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `total_amount` double NOT NULL,
  `branch_id` bigint NOT NULL,
  `customer_id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  `vehicle_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bx9jyu2cccdntb3ehrf0ojpfd` (`contract_number`),
  KEY `FK78avcunk4iv8mti7oqk3q8cpi` (`branch_id`),
  KEY `FKgcu7bfqv1j7nltm5uhk91kxcy` (`customer_id`),
  KEY `FKf5c9xgkxh0n28hbhsgo5rkq58` (`employee_id`),
  KEY `FKob17svessse3xlrb1t9qm2o7w` (`vehicle_id`),
  CONSTRAINT `FK78avcunk4iv8mti7oqk3q8cpi` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`),
  CONSTRAINT `FKf5c9xgkxh0n28hbhsgo5rkq58` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKgcu7bfqv1j7nltm5uhk91kxcy` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKob17svessse3xlrb1t9qm2o7w` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (1,_binary '','CNT-2023-001',300,1000,'2023-01-20',15500,15000,'Standard rental','2023-01-20','2023-01-15','COMPLETED',1500,1,1,2,1),(2,_binary '','CNT-2023-002',280,900,'2023-01-30',22500,22000,'Business rental','2023-01-30','2023-01-25','COMPLETED',1400,2,2,3,2),(3,_binary '','CNT-2023-003',450,1500,'2023-02-26',18500,18000,'Premium rental','2023-02-26','2023-02-18','COMPLETED',3600,3,3,4,3),(4,_binary '','CNT-2023-004',350,1200,'2023-03-01',12500,12000,'Standard rental','2023-03-01','2023-02-25','COMPLETED',1750,4,4,5,4),(5,_binary '','CNT-2023-005',500,1800,'2023-03-15',9500,9000,'Luxury rental','2023-03-15','2023-03-10','COMPLETED',2500,5,5,6,5),(6,_binary '','CNT-2023-006',450,1500,'2023-03-30',32500,32000,'Premium rental','2023-03-30','2023-03-25','COMPLETED',2250,6,6,7,6),(7,_binary '','CNT-2023-007',400,1300,'2023-04-15',41500,41000,'Business rental','2023-04-15','2023-04-08','COMPLETED',2800,7,7,8,7),(8,_binary '','CNT-2023-008',420,1400,'2023-04-26',15500,15000,'Business rental','2023-04-26','2023-04-18','COMPLETED',3360,8,8,9,8),(9,_binary '','CNT-2023-009',300,1000,'2023-05-09',22500,22000,'Standard rental','2023-05-09','2023-05-05','COMPLETED',1200,9,9,10,9),(10,_binary '','CNT-2023-010',280,900,'2023-05-20',18500,18000,'Economy rental','2023-05-20','2023-05-15','COMPLETED',1400,10,10,11,10),(11,_binary '','CNT-2023-011',320,1100,'2023-06-15',12500,12000,'Standard rental','2023-06-15','2023-06-10','COMPLETED',1600,11,11,12,11),(12,_binary '','CNT-2023-012',290,950,'2023-06-25',9500,9000,'Economy rental','2023-06-25','2023-06-20','COMPLETED',1450,12,12,13,12),(13,_binary '','CNT-2023-013',430,1400,'2023-07-15',32500,32000,'Premium rental','2023-07-15','2023-07-08','COMPLETED',3010,13,13,14,13),(14,_binary '','CNT-2023-014',500,1800,'2023-07-25',41500,41000,'Luxury rental','2023-07-25','2023-07-20','COMPLETED',2500,14,14,15,14),(15,_binary '','CNT-2023-015',360,1200,'2023-08-14',15500,15000,'Standard rental','2023-08-14','2023-08-09','COMPLETED',1800,15,15,16,15),(16,_binary '','CNT-2023-016',380,1300,'2023-08-30',22500,22000,'Business rental','2023-08-30','2023-08-25','COMPLETED',1900,16,16,17,16),(17,_binary '','CNT-2023-017',320,1100,'2023-09-15',18500,18000,'Standard rental','2023-09-15','2023-09-10','COMPLETED',1600,17,17,18,17),(18,_binary '','CNT-2023-018',280,900,'2023-09-30',12500,12000,'Economy rental','2023-09-30','2023-09-25','COMPLETED',1400,18,18,19,18),(19,_binary '','CNT-2023-019',340,1150,'2023-10-15',9500,9000,'Standard rental','2023-10-15','2023-10-08','COMPLETED',2380,19,19,20,19),(20,_binary '','CNT-2023-020',400,1300,'2023-10-26',32500,32000,'Business rental','2023-10-26','2023-10-18','COMPLETED',3200,20,20,21,20),(21,_binary '','CNT-2023-021',320,1100,'2023-11-10',41500,41000,'Standard rental','2023-11-10','2023-11-05','COMPLETED',1920,21,21,22,21),(22,_binary '','CNT-2023-022',370,1250,'2023-11-20',15500,15000,'Business rental','2023-11-20','2023-11-15','COMPLETED',1850,22,22,23,22),(23,_binary '','CNT-2023-023',420,1400,'2023-12-15',22500,22000,'Premium rental','2023-12-15','2023-12-08','COMPLETED',2940,23,23,24,23),(24,_binary '','CNT-2023-024',520,1800,'2023-12-25',18500,18000,'Luxury rental','2023-12-25','2023-12-20','COMPLETED',2600,24,24,25,24),(25,_binary '','CNT-2024-001',290,950,'2024-01-17',12500,12000,'Economy rental','2024-01-17','2024-01-12','COMPLETED',2030,25,25,26,25),(26,_binary '','CNT-2024-002',270,900,'2024-01-29',9500,9000,'Economy rental','2024-01-29','2024-01-22','COMPLETED',1890,26,26,27,26),(27,_binary '','CNT-2024-003',350,1200,'2024-02-15',32500,32000,'Standard rental','2024-02-15','2024-02-08','COMPLETED',2450,27,27,28,27),(28,_binary '','CNT-2024-004',430,1450,'2024-02-25',41500,41000,'Premium rental','2024-02-25','2024-02-20','COMPLETED',2150,28,28,29,28),(29,_binary '','CNT-2024-005',550,1900,'2024-03-15',15500,15000,'Luxury rental','2024-03-15','2024-03-10','COMPLETED',2750,29,29,30,29),(30,_binary '','CNT-2024-006',380,1300,'2024-03-30',22500,22000,'Business rental',NULL,'2024-03-20','ACTIVE',1900,30,30,31,30),(31,_binary '','CNT-2024-007',310,1050,'2024-04-15',18500,18000,'Standard rental',NULL,'2024-04-05','ACTIVE',1550,31,31,32,31),(32,_binary '','CNT-2024-008',270,900,'2024-04-30',12500,12000,'Economy rental',NULL,'2024-04-20','ACTIVE',1350,32,32,33,32),(33,_binary '','CNT-2024-009',440,1500,'2024-05-15',9500,9000,'Premium rental',NULL,'2024-05-05','ACTIVE',2200,33,33,34,33),(34,_binary '','CNT-2024-010',330,1100,'2024-05-30',32500,32000,'Standard rental',NULL,'2024-05-20','ACTIVE',1650,34,34,35,34),(35,_binary '','CNT-2024-011',510,1700,'2024-06-15',41500,41000,'Luxury rental',NULL,'2024-06-05','ACTIVE',2550,35,35,36,35),(36,_binary '','CNT-2024-012',460,1550,'2024-06-30',15500,15000,'Premium rental',NULL,'2024-06-20','ACTIVE',2300,36,36,37,36),(37,_binary '','CNT-2024-013',310,1050,'2024-07-15',22500,22000,'Standard rental',NULL,'2024-07-05','ACTIVE',1550,37,37,38,37),(38,_binary '','CNT-2024-014',280,950,'2024-07-30',18500,18000,'Economy rental',NULL,'2024-07-20','ACTIVE',1400,38,38,39,38),(39,_binary '','CNT-2024-015',360,1200,'2024-08-15',12500,12000,'Standard rental',NULL,'2024-08-05','ACTIVE',1800,39,39,40,39),(40,_binary '','CNT-2024-016',420,1400,'2024-08-30',9500,9000,'Premium rental',NULL,'2024-08-20','ACTIVE',2100,40,40,41,40),(41,_binary '','CNT-2024-017',330,1100,'2024-09-15',32500,32000,'Standard rental',NULL,'2024-09-05','RESERVED',1650,41,41,42,41),(42,_binary '','CNT-2024-018',380,1300,'2024-09-30',41500,41000,'Business rental',NULL,'2024-09-20','RESERVED',1900,42,42,43,42),(43,_binary '','CNT-2024-019',410,1400,'2024-10-15',15500,15000,'Premium rental',NULL,'2024-10-05','RESERVED',2050,43,43,44,43),(44,_binary '','CNT-2024-020',520,1800,'2024-10-30',22500,22000,'Luxury rental',NULL,'2024-10-20','RESERVED',2600,44,44,45,44),(45,_binary '','CNT-2024-021',370,1250,'2024-11-15',18500,18000,'Business rental',NULL,'2024-11-05','RESERVED',1850,45,45,46,45),(46,_binary '','CNT-2024-022',290,950,'2024-11-30',12500,12000,'Economy rental',NULL,'2024-11-20','RESERVED',1450,46,46,47,46),(47,_binary '','CNT-2024-023',430,1450,'2024-12-15',9500,9000,'Premium rental',NULL,'2024-12-05','RESERVED',2150,47,47,48,47),(48,_binary '','CNT-2024-024',380,1300,'2024-12-30',32500,32000,'Business rental',NULL,'2024-12-20','RESERVED',1900,48,48,49,48),(49,_binary '','CNT-2025-001',320,1100,'2025-01-15',41500,41000,'Standard rental',NULL,'2025-01-10','RESERVED',1600,49,49,50,49),(50,_binary '','CNT-2025-002',480,1600,'2025-01-25',15500,15000,'Premium rental',NULL,'2025-01-20','RESERVED',2400,1,50,51,50);
/*!40000 ALTER TABLE `contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `customer_type` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `identity_number` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registration_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rfbvkrffamfql7cjmen8v976v` (`email`),
  UNIQUE KEY `UK_jq6xwht92chem0xwlgtp4h8eq` (`identity_number`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'İstanbul','1990-01-15','Bireysel','ahmet@email.com','Ahmet','Yılmaz','12345678901','5551234567','2023-01-01'),(2,'Ankara','1985-05-20','Bireysel','ayse@email.com','Ayşe','Demir','23456789012','5552345678','2023-02-15'),(3,'İzmir','1980-11-30','Kurumsal','mehmet@email.com','Mehmet','Kaya','34567890123','5553456789','2023-03-10'),(4,'Bursa','1995-07-25','Bireysel','fatma@email.com','Fatma','Şahin','45678901234','5554567890','2023-04-05'),(5,'Antalya','1975-03-12','Kurumsal','ali@email.com','Ali','Öztürk','56789012345','5555678901','2023-05-20'),(6,'İstanbul, Kadıköy Mah. Bağdat Cad. No:112','1985-05-12','INDIVIDUAL','ali.yilmaz@gmail.com','Ali','Yılmaz','12345678910','5321112233','2020-03-15'),(7,'Ankara, Çankaya Mah. Tunalı Hilmi Cad. No:45','1990-07-18','INDIVIDUAL','ayse.demir@gmail.com','Ayşe','Demir','12345678911','5332223344','2020-05-20'),(8,'İzmir, Karşıyaka Mah. Cemal Gürsel Cad. No:23','1988-03-25','INDIVIDUAL','mehmet.kaya@gmail.com','Mehmet','Kaya','12345678912','5343334455','2020-07-10'),(9,'Bursa, Nilüfer Mah. Fatih Sultan Mehmet Cad. No:67','1992-11-05','INDIVIDUAL','zeynep.sahin@gmail.com','Zeynep','Şahin','12345678913','5354445566','2020-08-15'),(10,'Antalya, Konyaaltı Mah. Boğaçayı Cad. No:89','1986-09-28','INDIVIDUAL','mustafa.ozturk@gmail.com','Mustafa','Öztürk','12345678914','5365556677','2020-09-01'),(11,'Adana, Seyhan Mah. Atatürk Cad. No:34','1991-12-03','INDIVIDUAL','elif.celik@gmail.com','Elif','Çelik','12345678915','5376667788','2020-10-15'),(12,'İstanbul, Beşiktaş Mah. Barbaros Cad. No:56','1987-07-14','INDIVIDUAL','ahmet.koc@gmail.com','Ahmet','Koç','12345678916','5387778899','2020-11-05'),(13,'Ankara, Keçiören Mah. Fatih Cad. No:78','1993-05-21','INDIVIDUAL','selin.yildiz@gmail.com','Selin','Yıldız','12345678917','5398889900','2020-12-10'),(14,'İzmir, Bornova Mah. Cumhuriyet Cad. No:12','1989-10-09','INDIVIDUAL','burak.aydin@gmail.com','Burak','Aydın','12345678918','5409990011','2021-01-15'),(15,'Bursa, Osmangazi Mah. İnönü Cad. No:45','1994-02-14','INDIVIDUAL','deniz.aksoy@gmail.com','Deniz','Aksoy','12345678919','5411112222','2021-02-20'),(16,'Antalya, Muratpaşa Mah. Güllük Cad. No:23','1990-11-27','INDIVIDUAL','emre.gunes@gmail.com','Emre','Güneş','12345678920','5422223333','2021-03-10'),(17,'Adana, Çukurova Mah. Turgut Özal Cad. No:67','1992-08-19','INDIVIDUAL','ceren.ozkan@gmail.com','Ceren','Özkan','12345678921','5433334444','2021-04-15'),(18,'İstanbul, Bakırköy Mah. İstanbul Cad. No:89','1988-06-05','INDIVIDUAL','berk.yalcin@gmail.com','Berk','Yalçın','12345678922','5444445555','2021-05-20'),(19,'Ankara, Yenimahalle Mah. Ragıp Tüzün Cad. No:34','1995-03-18','INDIVIDUAL','ece.cetin@gmail.com','Ece','Çetin','12345678923','5455556666','2021-06-10'),(20,'İzmir, Konak Mah. Gazi Cad. No:56','1991-04-25','INDIVIDUAL','furkan.kara@gmail.com','Furkan','Kara','12345678924','5466667777','2021-07-15'),(21,'Bursa, Mudanya Mah. Sahil Cad. No:78','1993-09-12','INDIVIDUAL','gizem.tekin@gmail.com','Gizem','Tekin','12345678925','5477778888','2021-08-25'),(22,'Antalya, Kepez Mah. Mehmet Akif Ersoy Cad. No:12','1986-12-08','INDIVIDUAL','hakan.oz@gmail.com','Hakan','Öz','12345678926','5488889999','2021-09-30'),(23,'Adana, Sarıçam Mah. Adnan Menderes Cad. No:45','1994-07-30','INDIVIDUAL','irem.yilmazer@gmail.com','İrem','Yılmazer','12345678927','5499990000','2021-10-05'),(24,'İstanbul, Ümraniye Mah. Alemdağ Cad. No:23','1989-05-15','INDIVIDUAL','kadir.bulut@gmail.com','Kadir','Bulut','12345678928','5301112222','2021-11-10'),(25,'Ankara, Etimesgut Mah. İstasyon Cad. No:67','1996-01-22','INDIVIDUAL','leyla.yildirim@gmail.com','Leyla','Yıldırım','12345678929','5312223333','2021-12-15'),(26,'İzmir, Çeşme Mah. Sahil Cad. No:89','1990-03-28','INDIVIDUAL','mert.aslan@gmail.com','Mert','Aslan','12345678930','5323334444','2022-01-20'),(27,'Bursa, İnegöl Mah. Ankara Cad. No:34','1992-06-14','INDIVIDUAL','nur.dogan@gmail.com','Nur','Doğan','12345678931','5334445555','2022-02-25'),(28,'Antalya, Manavgat Mah. Side Cad. No:56','1987-09-03','INDIVIDUAL','okan.korkmaz@gmail.com','Okan','Korkmaz','12345678932','5345556666','2022-03-10'),(29,'Adana, Yüreğir Mah. Kışla Cad. No:78','1993-11-17','INDIVIDUAL','pinar.celik@gmail.com','Pınar','Çelik','12345678933','5356667777','2022-04-15'),(30,'İstanbul, Maltepe Mah. Bağdat Cad. No:12','1985-08-20','INDIVIDUAL','riza.erdogan@gmail.com','Rıza','Erdoğan','12345678934','5367778888','2022-05-20'),(31,'Ankara, Gölbaşı Mah. Konya Cad. No:45','1991-02-14','INDIVIDUAL','seda.sen@gmail.com','Seda','Şen','12345678935','5378889999','2022-06-10'),(32,'İzmir, Bayraklı Mah. Manisa Cad. No:23','1988-04-09','INDIVIDUAL','tolga.yalcin@gmail.com','Tolga','Yalçın','12345678936','5389990000','2022-07-15'),(33,'Bursa, Gürsu Mah. Yalova Cad. No:67','1994-10-23','INDIVIDUAL','ulku.ozdemir@gmail.com','Ülkü','Özdemir','12345678937','5390001111','2022-08-25'),(34,'Antalya, Alanya Mah. Cleopatra Cad. No:89','1990-12-01','INDIVIDUAL','veli.demirci@gmail.com','Veli','Demirci','12345678938','5401112222','2022-09-30'),(35,'Adana, Kozan Mah. Cumhuriyet Cad. No:34','1986-07-07','INDIVIDUAL','yasemin.can@gmail.com','Yasemin','Can','12345678939','5412223333','2022-10-05'),(36,'İstanbul, Beylikdüzü Mah. Marmara Cad. No:56','1992-03-29','INDIVIDUAL','zafer.koc@gmail.com','Zafer','Koç','12345678940','5423334444','2022-11-10'),(37,'Ankara, Sincan Mah. Fatih Cad. No:78','1989-08-16','INDIVIDUAL','asli.tuncer@gmail.com','Aslı','Tuncer','12345678941','5434445555','2022-12-15'),(38,'İzmir, Gaziemir Mah. Atatürk Cad. No:12','1995-05-05','INDIVIDUAL','baris.kaya@gmail.com','Barış','Kaya','12345678942','5445556666','2023-01-20'),(39,'Bursa, Karacabey Mah. İzmir Cad. No:45','1987-01-12','INDIVIDUAL','cansu.yucel@gmail.com','Cansu','Yücel','12345678943','5456667777','2023-02-25'),(40,'Antalya, Finike Mah. Liman Cad. No:23','1993-06-19','INDIVIDUAL','dogan.aydin@gmail.com','Doğan','Aydın','12345678944','5467778888','2023-03-10'),(41,'Adana, Karataş Mah. Sahil Cad. No:67','1988-09-26','INDIVIDUAL','ebru.tas@gmail.com','Ebru','Taş','12345678945','5478889999','2023-04-15'),(42,'İstanbul, Silivri Mah. Deniz Cad. No:89','1994-12-03','INDIVIDUAL','ferit.simsek@gmail.com','Ferit','Şimşek','12345678946','5489990000','2023-05-20'),(43,'Ankara, Beypazarı Mah. Tarihi Cad. No:12','1990-03-10','INDIVIDUAL','gamze.eren@gmail.com','Gamze','Eren','12345678947','5390001111','2023-06-10'),(44,'İzmir, Urla Mah. Deniz Cad. No:45','1986-06-17','INDIVIDUAL','huseyin.akar@gmail.com','Hüseyin','Akar','12345678948','5301112222','2023-07-15'),(45,'Bursa, Orhangazi Mah. Göl Cad. No:23','1992-09-24','INDIVIDUAL','irmak.genc@gmail.com','Irmak','Genç','12345678949','5312223333','2023-08-25'),(46,'Antalya, Kaş Mah. Akdeniz Cad. No:67','1988-02-01','INDIVIDUAL','jale.cinar@gmail.com','Jale','Çınar','12345678950','5323334444','2023-09-30'),(47,'Adana, İmamoğlu Mah. Merkez Cad. No:89','1995-04-08','INDIVIDUAL','kerem.aktas@gmail.com','Kerem','Aktaş','12345678951','5334445555','2023-10-05'),(48,'İstanbul, Çatalca Mah. Ormanlı Cad. No:12','1987-07-15','INDIVIDUAL','lara.kilic@gmail.com','Lara','Kılıç','12345678952','5345556666','2023-11-10'),(49,'Ankara, Polatlı Mah. Sakarya Cad. No:45','1993-10-22','INDIVIDUAL','metin.aydin@gmail.com','Metin','Aydın','12345678953','5356667777','2023-12-15'),(50,'İzmir, Seferihisar Mah. Sığacık Cad. No:23','1989-01-29','INDIVIDUAL','naz.guler@gmail.com','Naz','Güler','12345678954','5367778888','2024-01-20'),(51,'Bursa, Kestel Mah. Uludağ Cad. No:67','1996-04-05','INDIVIDUAL','oktay.yavuz@gmail.com','Oktay','Yavuz','12345678955','5378889999','2024-02-25'),(52,'Antalya, Demre Mah. Myra Cad. No:89','1991-07-12','INDIVIDUAL','pelin.durmaz@gmail.com','Pelin','Durmaz','12345678956','5389990000','2024-03-10'),(53,'Adana, Pozantı Mah. Dağ Cad. No:12','1987-10-19','INDIVIDUAL','ramazan.guven@gmail.com','Ramazan','Güven','12345678957','5291112222','2024-04-15'),(54,'İstanbul, Şile Mah. Karadeniz Cad. No:45','1993-01-26','INDIVIDUAL','sevil.ayhan@gmail.com','Sevil','Ayhan','12345678958','5202223333','2024-05-20'),(55,'Ankara, Kahramankazan Mah. Kale Cad. No:23','1989-04-03','INDIVIDUAL','tarik.yoruk@gmail.com','Tarık','Yörük','12345678959','5213334444','2024-06-10');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `hire_date` date DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `identity_number` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `branch_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r3hlvtweaf7xpyrg1sbemc166` (`identity_number`),
  KEY `FKmef7fp4oyblw7d2y3g1whac3o` (`branch_id`),
  CONSTRAINT `FKmef7fp4oyblw7d2y3g1whac3o` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (2,_binary '','ahmet.yilmaz@rentacar.com','Ahmet','2018-03-15','Yılmaz','12345678901',NULL,'5551112233','Genel Müdür',NULL,1),(3,_binary '','ayse.kaya@rentacar.com','Ayşe','2018-05-20','Kaya','12345678902',NULL,'5551112234','Şube Müdürü',NULL,1),(4,_binary '','mehmet.demir@rentacar.com','Mehmet','2019-01-10','Demir','12345678903',NULL,'5551112235','Satış Müdürü',NULL,2),(5,_binary '','zeynep.celik@rentacar.com','Zeynep','2019-06-15','Çelik','12345678904',NULL,'5551112236','İK Müdürü',NULL,3),(6,_binary '','ali.ozturk@rentacar.com','Ali','2018-08-01','Öztürk','12345678905',NULL,'5551112237','Finans Müdürü',NULL,4),(7,_binary '','fatma.sahin@rentacar.com','Fatma','2020-01-15','Şahin','12345678906',NULL,'5551112238','Muhasebe Müdürü',NULL,5),(8,_binary '','mustafa.koc@rentacar.com','Mustafa','2019-11-05','Koç','12345678907',NULL,'5551112239','Şube Müdürü',NULL,6),(9,_binary '','elif.yildiz@rentacar.com','Elif','2020-03-10','Yıldız','12345678908',NULL,'5551112240','Müşteri İlişkileri Müdürü',NULL,7),(10,_binary '','emre.kilic@rentacar.com','Emre','2020-05-20','Kılıç','12345678909',NULL,'5551112241','Satış Temsilcisi',NULL,1),(11,_binary '','selin.aksoy@rentacar.com','Selin','2021-01-15','Aksoy','12345678910',NULL,'5551112242','İK Uzmanı',NULL,1),(12,_binary '','berk.aydin@rentacar.com','Berk','2019-08-10','Aydın','12345678911',NULL,'5551112243','Satış Temsilcisi',NULL,2),(13,_binary '','ceren.gunes@rentacar.com','Ceren','2020-09-15','Güneş','12345678912',NULL,'5551112244','Muhasebe Uzmanı',NULL,3),(14,_binary '','deniz.ozkan@rentacar.com','Deniz','2019-04-12','Özkan','12345678913',NULL,'5551112245','Satış Temsilcisi',NULL,4),(15,_binary '','ece.yalcin@rentacar.com','Ece','2021-03-20','Yalçın','12345678914',NULL,'5551112246','Müşteri Temsilcisi',NULL,5),(16,_binary '','furkan.cetin@rentacar.com','Furkan','2020-11-10','Çetin','12345678915',NULL,'5551112247','Teknik Servis Müdürü',NULL,6),(17,_binary '','gizem.kara@rentacar.com','Gizem','2021-06-15','Kara','12345678916',NULL,'5551112248','Satış Temsilcisi',NULL,7),(18,_binary '','hakan.tekin@rentacar.com','Hakan','2018-10-01','Tekin','12345678917',NULL,'5551112249','Araç Bakım Sorumlusu',NULL,8),(19,_binary '','irem.oz@rentacar.com','İrem','2021-09-10','Öz','12345678918',NULL,'5551112250','Müşteri Temsilcisi',NULL,9),(20,_binary '','kadir.yilmazer@rentacar.com','Kadir','2019-07-05','Yılmazer','12345678919',NULL,'5551112251','Araç Bakım Sorumlusu',NULL,10),(21,_binary '','leyla.bulut@rentacar.com','Leyla','2022-01-15','Bulut','12345678920',NULL,'5551112252','Satış Temsilcisi',NULL,1),(22,_binary '','mert.yildirim@rentacar.com','Mert','2020-02-10','Yıldırım','12345678921',NULL,'5551112253','Muhasebe Uzmanı',NULL,2),(23,_binary '','nur.aslan@rentacar.com','Nur','2020-08-15','Aslan','12345678922',NULL,'5551112254','İK Uzmanı',NULL,3),(24,_binary '','ozan.dogan@rentacar.com','Ozan','2019-05-20','Doğan','12345678923',NULL,'5551112255','Araç Bakım Sorumlusu',NULL,4),(25,_binary '','pinar.korkmaz@rentacar.com','Pınar','2021-04-10','Korkmaz','12345678924',NULL,'5551112256','Müşteri Temsilcisi',NULL,5),(26,_binary '','ramazan.celik@rentacar.com','Ramazan','2018-09-15','Çelik','12345678925',NULL,'5551112257','Şube Müdürü',NULL,6),(27,_binary '','seda.erdogan@rentacar.com','Seda','2020-06-20','Erdoğan','12345678926',NULL,'5551112258','Satış Temsilcisi',NULL,7),(28,_binary '','tolga.sen@rentacar.com','Tolga','2019-10-15','Şen','12345678927',NULL,'5551112259','Muhasebe Uzmanı',NULL,8),(29,_binary '','umit.yalcin@rentacar.com','Ümit','2021-07-10','Yalçın','12345678928',NULL,'5551112260','Araç Bakım Sorumlusu',NULL,9),(30,_binary '','vildan.ozdemir@rentacar.com','Vildan','2020-04-15','Özdemir','12345678929',NULL,'5551112261','Satış Temsilcisi',NULL,10),(31,_binary '','yigit.demirci@rentacar.com','Yiğit','2018-11-20','Demirci','12345678930',NULL,'5551112262','Teknik Servis Uzmanı',NULL,1),(32,_binary '','zehra.can@rentacar.com','Zehra','2020-10-10','Can','12345678931',NULL,'5551112263','Müşteri Temsilcisi',NULL,2),(33,_binary '','alper.koc@rentacar.com','Alper','2019-12-15','Koç','12345678932',NULL,'5551112264','Satış Temsilcisi',NULL,3),(34,_binary '','betul.tuncer@rentacar.com','Betül','2021-11-10','Tuncer','12345678933',NULL,'5551112265','Muhasebe Uzmanı',NULL,4),(35,_binary '','cihan.kaya@rentacar.com','Cihan','2019-02-15','Kaya','12345678934',NULL,'5551112266','Araç Teslimat Sorumlusu',NULL,5),(36,_binary '','derya.yucel@rentacar.com','Derya','2021-02-20','Yücel','12345678935',NULL,'5551112267','Satış Temsilcisi',NULL,6),(37,_binary '','erkan.aydin@rentacar.com','Erkan','2020-07-15','Aydın','12345678936',NULL,'5551112268','Müşteri Temsilcisi',NULL,7),(38,_binary '','funda.ozel@rentacar.com','Funda','2020-12-10','Özel','12345678937',NULL,'5551112269','İK Uzmanı',NULL,8),(39,_binary '','gokhan.ates@rentacar.com','Gökhan','2018-12-05','Ateş','12345678938',NULL,'5551112270','Araç Teslimat Sorumlusu',NULL,9),(40,_binary '','hande.demir@rentacar.com','Hande','2021-08-15','Demir','12345678939',NULL,'5551112271','Satış Temsilcisi',NULL,10),(41,_binary '','ismail.guler@rentacar.com','İsmail','2019-03-20','Güler','12345678940',NULL,'5551112272','Araç Bakım Sorumlusu',NULL,1),(42,_binary '','jasmin.yalin@rentacar.com','Jasmin','2022-02-10','Yalın','12345678941',NULL,'5551112273','Müşteri Temsilcisi',NULL,2),(43,_binary '','kemal.turk@rentacar.com','Kemal','2019-09-25','Türk','12345678942',NULL,'5551112274','Muhasebe Uzmanı',NULL,3),(44,_binary '','lale.sari@rentacar.com','Lale','2020-05-15','Sarı','12345678943',NULL,'5551112275','Satış Temsilcisi',NULL,4),(45,_binary '','murat.akin@rentacar.com','Murat','2019-06-10','Akın','12345678944',NULL,'5551112276','Araç Teslimat Sorumlusu',NULL,5),(46,_binary '','nalan.yurt@rentacar.com','Nalan','2021-05-20','Yurt','12345678945',NULL,'5551112277','İK Uzmanı',NULL,6),(47,_binary '','orhan.tas@rentacar.com','Orhan','2018-07-15','Taş','12345678946',NULL,'5551112278','Araç Bakım Sorumlusu',NULL,7),(48,_binary '','pelin.kucuk@rentacar.com','Pelin','2021-10-15','Küçük','12345678947',NULL,'5551112279','Müşteri Temsilcisi',NULL,8),(49,_binary '','recep.isik@rentacar.com','Recep','2019-01-25','Işık','12345678948',NULL,'5551112280','Satış Temsilcisi',NULL,9),(50,_binary '','sevgi.yavuz@rentacar.com','Sevgi','2020-08-10','Yavuz','12345678949',NULL,'5551112281','Muhasebe Uzmanı',NULL,10),(51,_binary '','tamer.bilgin@rentacar.com','Tamer','2018-04-20','Bilgin','12345678950',NULL,'5551112282','Araç Teslimat Sorumlusu',NULL,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurances`
--

DROP TABLE IF EXISTS `insurances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurances` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) NOT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `insurance_type` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurances`
--

LOCK TABLES `insurances` WRITE;
/*!40000 ALTER TABLE `insurances` DISABLE KEYS */;
INSERT INTO `insurances` VALUES (1,_binary '','İstanbul, Kadıköy Mah. Sigorta Cad. No:123','Anadolu Sigorta','Ayşe Demir','Zorunlu trafik sigortası temel paket','info@anadolusigorta.com','Zorunlu Trafik','Trafik Sigortası Basic','0212 555 2001'),(2,_binary '','İstanbul, Beşiktaş Mah. Sigorta Sk. No:45','Axa Sigorta','Mehmet Kaya','Premium kasko paketi','bilgi@axasigorta.com','Kasko','Kasko Gold','0212 444 2002'),(3,_binary '','İstanbul, Şişli Mah. Sigorta Cad. No:67','Allianz','Zeynep Yıldız','Tam kapsamlı araç koruma sigortası','destek@allianz.com','Kasko','Tam Koruma Kasko','0212 333 2003'),(4,_binary '','İstanbul, Ataşehir Mah. Sigorta Sk. No:89','Mapfre Sigorta','Ali Öztürk','Ekonomik kasko paketi','iletisim@mapfre.com','Kasko','Mini Kasko','0212 222 2004'),(5,_binary '','İstanbul, Maltepe Mah. Sigorta Cad. No:12','Aksigorta','Selin Kara','Genişletilmiş trafik sigortası','info@aksigorta.com','Zorunlu Trafik','Trafik Plus','0212 111 2005'),(6,_binary '','İstanbul, Üsküdar Mah. Sigorta Sk. No:34','Halk Sigorta','Murat Demir','Lüks araçlar için özel kasko','musteri@halksigorta.com','Kasko','Prestij Kasko','0212 777 2006'),(7,_binary '','İstanbul, Beylikdüzü Mah. Sigorta Cad. No:56','Güneş Sigorta','Deniz Yılmaz','Ekonomik zorunlu trafik sigortası','bilgi@gunessigorta.com','Zorunlu Trafik','Temel Trafik','0212 888 2007'),(8,_binary '','İstanbul, Bakırköy Mah. Sigorta Sk. No:78','Ray Sigorta','Emre Kaya','25 yaş altı sürücüler için özel kasko','iletisim@raysigorta.com','Kasko','Genç Sürücü Kasko','0212 999 2008'),(9,_binary '','İstanbul, Sarıyer Mah. Sigorta Cad. No:90','HDI Sigorta','Burak Çelik','Klasik ve antika araçlar için özel sigorta','info@hdisigorta.com','Özel','Klasik Araç Sigortası','0212 666 2009'),(10,_binary '','İstanbul, Kağıthane Mah. Sigorta Sk. No:23','Zurich Sigorta','Ceren Taş','Ticari araçlar için trafik sigortası','bilgi@zurich.com','Zorunlu Trafik','Ticari Araç Trafik','0212 555 2010'),(11,_binary '','İstanbul, Eyüp Mah. Sigorta Cad. No:45','Eureko Sigorta','Serkan Akar','Geniş kapsamlı araç koruma','iletisim@eureko.com','Kasko','Oto Koruma','0212 444 2011'),(12,_binary '','İstanbul, Arnavutköy Mah. Sigorta Sk. No:67','Sompo Sigorta','Taner İşcan','İş ve ticari araçlar için özel sigorta','destek@sompo.com','Özel','İş Aracı Sigortası','0212 333 2012'),(13,_binary '','İstanbul, Bayrampaşa Mah. Sigorta Cad. No:89','Generali Sigorta','Melis Motor','Motosikletler için özel trafik ve kasko sigortası','info@generali.com','Özel','Motosiklet Sigortası','0212 222 2013'),(14,_binary '','İstanbul, Beykoz Mah. Sigorta Sk. No:12','Neova Sigorta','Nazlı Ekonomi','Uygun fiyatlı trafik sigortası','bilgi@neova.com','Zorunlu Trafik','Ekonomik Trafik','0212 111 2014'),(15,_binary '','İstanbul, Başakşehir Mah. Sigorta Cad. No:34','Groupama','Selim Süper','Tam kapsamlı kasko sigortası','iletisim@groupama.com','Kasko','Süper Kasko','0212 777 2015'),(16,_binary '','İstanbul, Beyoğlu Mah. Sigorta Sk. No:56','Unico Sigorta','Ufuk Kiralık','Kiralık araçlar için özel sigorta paketi','destek@unico.com','Özel','Rent A Car Sigortası','0212 888 2016'),(17,_binary '','İstanbul, Güngören Mah. Sigorta Cad. No:78','Gulf Sigorta','Yeliz Yeni','Yeni araçlar için özel trafik sigortası','info@gulfsigorta.com','Zorunlu Trafik','Yeni Araç Trafik','0212 999 2017'),(18,_binary '','İstanbul, Kartal Mah. Sigorta Sk. No:90','Quick Sigorta','Ahmet Aile','Aile araçları için ekonomik kasko','bilgi@quicksigorta.com','Kasko','Aile Kasko','0212 666 2018'),(19,_binary '','İstanbul, Fatih Mah. Sigorta Cad. No:23','Dubai Sigorta','Yasemin Yüksek','Yüksek teminatlı araç sigortası','iletisim@dubaisigorta.com','Kasko','Yüksek Koruma','0212 555 2019'),(20,_binary '','İstanbul, Zeytinburnu Mah. Sigorta Sk. No:45','Orient Sigorta','Orhan Oto','Araç garanti uzatma sigortası','destek@orient.com','Özel','Oto Garanti','0212 444 2020'),(21,_binary '','İstanbul, Pendik Mah. Sigorta Cad. No:67','Bereket Sigorta','Tarık Ticari','Ticari araçlar için özel kasko paketi','info@bereket.com','Kasko','Ticari Kasko','0212 333 2021'),(22,_binary '','İstanbul, Esenyurt Mah. Sigorta Sk. No:89','Koru Sigorta','Jale Jeep','Arazi araçları için özel kasko','bilgi@korusigorta.com','Kasko','Jeep Kasko','0212 222 2022'),(23,_binary '','İstanbul, Silivri Mah. Sigorta Cad. No:12','Türk Nippon Sigorta','Serdar Servis','Servis araçları için trafik sigortası','iletisim@turknippon.com','Zorunlu Trafik','Servis Trafik','0212 111 2023'),(24,_binary '','İstanbul, Sultangazi Mah. Sigorta Sk. No:34','Doğa Sigorta','Aydın Ağır','Kamyon ve ağır vasıtalar için sigorta','destek@dogasigorta.com','Özel','Ağır Vasıta Sigortası','0212 777 2024'),(25,_binary '','İstanbul, Tuzla Mah. Sigorta Cad. No:56','Katılım Emeklilik','Mete Minibüs','Minibüsler için özel kasko paketi','info@katilimemeklilik.com','Kasko','Minibüs Kasko','0212 888 2025'),(26,_binary '','Ankara, Çankaya Mah. Sigorta Sk. No:78','Ankara Sigorta','Taylan Traktör','Tarım araçları için özel sigorta','bilgi@ankarasigorta.com','Özel','Traktör Sigortası','0312 999 2026'),(27,_binary '','İstanbul, Ümraniye Mah. Sigorta Cad. No:90','Ceyhan Sigorta','Ceyda Taksi','Ticari taksiler için özel sigorta paketi','iletisim@ceyhansigorta.com','Özel','Taksi Sigortası','0212 666 2027'),(28,_binary '','İstanbul, Sancaktepe Mah. Sigorta Sk. No:23','Türk P&I Sigorta','Umut Uzun','Şehirlerarası araçlar için kasko','destek@turkpandi.com','Kasko','Uzun Yol Kasko','0212 555 2028'),(29,_binary '','İstanbul, Çekmeköy Mah. Sigorta Cad. No:45','Corpus Sigorta','Fatih Filo','Şirket filoları için toplu sigorta','info@corpus.com','Özel','Filo Araç Sigortası','0212 444 2029'),(30,_binary '','İstanbul, Şile Mah. Sigorta Sk. No:67','Magdeburger Sigorta','Derya Değer','Kaza sonrası değer kaybı teminatı','bilgi@magdeburger.com','Özel','Araç Değer Kaybı','0212 333 2030'),(31,_binary '','İstanbul, Adalar Mah. Sigorta Cad. No:89','ERGO Sigorta','Elif Engelli','Engelli araçları için özel sigorta paketi','iletisim@ergo.com','Özel','Engelli Araç Sigortası','0212 222 2031'),(32,_binary '','İstanbul, Büyükçekmece Mah. Sigorta Sk. No:12','Dask Sigorta','Cenk Cam','Araç camları için özel koruma','destek@dasksigorta.com','Özel','Cam Kırılması Teminatı','0212 111 2032'),(33,_binary '','İstanbul, Avcılar Mah. Sigorta Cad. No:34','TARSİM','Yavuz Yedek','Orijinal yedek parça garantisi','info@tarsim.com','Özel','Yedek Parça Sigortası','0212 777 2033'),(34,_binary '','İstanbul, Bağcılar Mah. Sigorta Sk. No:56','SBN Sigorta','Rıza Ralli','Yarış ve ralli araçları için özel sigorta','bilgi@sbnsigorta.com','Özel','Ralli Aracı Sigortası','0212 888 2034'),(35,_binary '','İstanbul, Esenler Mah. Sigorta Cad. No:78','Batı Sigorta','Canan Caretta','Özelleştirilmiş geniş kapsamlı kasko','iletisim@batisigorta.com','Kasko','Caretta Kasko','0212 999 2035'),(36,_binary '','İstanbul, Gaziosmanpaşa Mah. Sigorta Sk. No:90','Merkez Sigorta','İrem İthal','İthal araçlar için özel sigorta paketi','destek@merkezsigorta.com','Özel','İthal Araç Sigortası','0212 666 2036'),(37,_binary '','İstanbul, Bahçelievler Mah. Sigorta Cad. No:23','Işık Sigorta','Yusuf Yurtdışı','Yurtdışı seyahat teminatı içeren paket','info@isiksigorta.com','Özel','Yurtdışı Teminatı','0212 555 2037'),(38,_binary '','İstanbul, Küçükçekmece Mah. Sigorta Sk. No:45','Kale Sigorta','Melih Modifiye','Modifiyeli araçlar için özel sigorta','bilgi@kalesigorta.com','Özel','Modifiye Araç Sigortası','0212 444 2038'),(39,_binary '','İstanbul, Sultanbeyli Mah. Sigorta Cad. No:67','Lider Sigorta','Tugay Tam','Tam otomatik araçlar için özel kasko','iletisim@lidersigorta.com','Kasko','Tam Otomatik Kasko','0212 333 2039'),(40,_binary '','İstanbul, Beyoğlu Mah. Sigorta Sk. No:89','Vakıf Emeklilik','Ayten Aile','Aile araçları için geniş kapsamlı sigorta','destek@vakifemeklilik.com','Özel','Aile Koruma Sigortası','0212 222 2040');
/*!40000 ALTER TABLE `insurances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makes`
--

DROP TABLE IF EXISTS `makes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `makes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9pxjtve5c50fx3aq64dhb4f8m` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makes`
--

LOCK TABLES `makes` WRITE;
/*!40000 ALTER TABLE `makes` DISABLE KEYS */;
INSERT INTO `makes` VALUES (1,'Japonya','Toyota'),(2,'Japonya','Honda'),(3,'ABD','Ford'),(4,'ABD','Chevrolet'),(5,'Almanya','BMW'),(6,'Almanya','Mercedes-Benz'),(7,'Almanya','Audi'),(8,'Almanya','Volkswagen'),(9,'Güney Kore','Hyundai'),(10,'Güney Kore','Kia'),(11,'Japonya','Nissan'),(12,'Japonya','Mazda'),(13,'Japonya','Subaru'),(14,'Japonya','Lexus'),(15,'Almanya','Porsche'),(16,'İsveç','Volvo'),(17,'İngiltere','Jaguar'),(18,'İngiltere','Land Rover'),(19,'İtalya','Ferrari'),(20,'İtalya','Lamborghini'),(21,'İtalya','Maserati'),(22,'İtalya','Alfa Romeo'),(23,'İtalya','Fiat'),(24,'Fransa','Peugeot'),(25,'Fransa','Renault'),(26,'Fransa','Citroen'),(27,'ABD','Tesla'),(28,'ABD','Jeep'),(29,'ABD','Dodge'),(30,'ABD','Chrysler'),(31,'ABD','Cadillac'),(32,'ABD','GMC'),(33,'ABD','Buick'),(34,'ABD','Lincoln'),(35,'Japonya','Acura'),(36,'Japonya','Infiniti'),(37,'Japonya','Mitsubishi'),(38,'Japonya','Suzuki'),(39,'Japonya','Daihatsu'),(40,'Almanya','Smart'),(41,'İngiltere','MINI'),(42,'İngiltere','Bentley'),(43,'İngiltere','Rolls-Royce'),(44,'İngiltere','Aston Martin'),(45,'İngiltere','McLaren'),(46,'Fransa','Bugatti'),(47,'İsveç','Koenigsegg'),(48,'İtalya','Pagani'),(49,'İngiltere','Lotus'),(50,'Güney Kore','Genesis');
/*!40000 ALTER TABLE `makes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `make_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8fm3p80h4dh513qubnxd2qefl` (`make_id`),
  CONSTRAINT `FK8fm3p80h4dh513qubnxd2qefl` FOREIGN KEY (`make_id`) REFERENCES `makes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (1,'Corolla',1),(2,'Camry',1),(3,'RAV4',1),(4,'Highlander',1),(5,'Yaris',1),(6,'Civic',2),(7,'Accord',2),(8,'CR-V',2),(9,'Pilot',2),(10,'Fit',2),(11,'Mustang',3),(12,'Focus',3),(13,'F-150',3),(14,'Explorer',3),(15,'Escape',3),(16,'Malibu',4),(17,'Impala',4),(18,'Silverado',4),(19,'Equinox',4),(20,'Tahoe',4),(21,'3 Series',5),(22,'5 Series',5),(23,'X3',5),(24,'X5',5),(25,'7 Series',5),(26,'C-Class',6),(27,'E-Class',6),(28,'S-Class',6),(29,'GLC',6),(30,'GLE',6),(31,'A4',7),(32,'A6',7),(33,'Q5',7),(34,'Q7',7),(35,'TT',7),(36,'Golf',8),(37,'Passat',8),(38,'Tiguan',8),(39,'Atlas',8),(40,'Jetta',8),(41,'Elantra',9),(42,'Sonata',9),(43,'Tucson',9),(44,'Santa Fe',9),(45,'Kona',9),(46,'Optima',10),(47,'Sorento',10),(48,'Sportage',10),(49,'Soul',10),(50,'Telluride',10);
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `payment_date` datetime(6) NOT NULL,
  `payment_type` varchar(255) NOT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `contract_id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqywegtqyijw241foqfkseq1l6` (`contract_id`),
  KEY `FKgg9970yjb56tmui83b0dccqv5` (`employee_id`),
  CONSTRAINT `FKgg9970yjb56tmui83b0dccqv5` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKqywegtqyijw241foqfkseq1l6` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (101,1500,'Tam ödeme','2023-01-15 14:30:00.000000','CREDIT_CARD','TRX-23-0001',1,2),(102,1400,'Tam ödeme','2023-01-25 15:45:00.000000','CREDIT_CARD','TRX-23-0002',2,3),(103,3600,'Tam ödeme','2023-02-18 10:15:00.000000','CREDIT_CARD','TRX-23-0003',3,4),(104,1750,'Tam ödeme','2023-02-25 11:30:00.000000','CASH','TRX-23-0004',4,5),(105,2500,'Tam ödeme','2023-03-10 12:45:00.000000','CREDIT_CARD','TRX-23-0005',5,6),(106,2250,'Tam ödeme','2023-03-25 13:15:00.000000','CREDIT_CARD','TRX-23-0006',6,7),(107,2800,'Tam ödeme','2023-04-08 14:30:00.000000','CASH','TRX-23-0007',7,8),(108,3360,'Tam ödeme','2023-04-18 15:45:00.000000','CREDIT_CARD','TRX-23-0008',8,9),(109,1200,'Tam ödeme','2023-05-05 10:15:00.000000','CREDIT_CARD','TRX-23-0009',9,10),(110,1400,'Tam ödeme','2023-05-15 11:30:00.000000','CASH','TRX-23-0010',10,11),(111,1600,'Tam ödeme','2023-06-10 12:45:00.000000','CREDIT_CARD','TRX-23-0011',11,12),(112,1450,'Tam ödeme','2023-06-20 13:15:00.000000','CASH','TRX-23-0012',12,13),(113,3010,'Tam ödeme','2023-07-08 14:30:00.000000','CREDIT_CARD','TRX-23-0013',13,14),(114,2500,'Tam ödeme','2023-07-20 15:45:00.000000','CREDIT_CARD','TRX-23-0014',14,15),(115,1800,'Tam ödeme','2023-08-09 10:15:00.000000','CASH','TRX-23-0015',15,16),(116,1900,'Tam ödeme','2023-08-25 11:30:00.000000','CREDIT_CARD','TRX-23-0016',16,17),(117,1600,'Tam ödeme','2023-09-10 12:45:00.000000','CREDIT_CARD','TRX-23-0017',17,18),(118,1400,'Tam ödeme','2023-09-25 13:15:00.000000','CASH','TRX-23-0018',18,19),(119,2380,'Tam ödeme','2023-10-08 14:30:00.000000','CREDIT_CARD','TRX-23-0019',19,20),(120,3200,'Tam ödeme','2023-10-18 15:45:00.000000','CREDIT_CARD','TRX-23-0020',20,21),(121,1920,'Tam ödeme','2023-11-05 10:15:00.000000','CASH','TRX-23-0021',21,22),(122,1850,'Tam ödeme','2023-11-15 11:30:00.000000','CREDIT_CARD','TRX-23-0022',22,23),(123,2940,'Tam ödeme','2023-12-08 12:45:00.000000','CREDIT_CARD','TRX-23-0023',23,24),(124,2600,'Tam ödeme','2023-12-20 13:15:00.000000','CASH','TRX-23-0024',24,25),(125,2030,'Tam ödeme','2024-01-12 14:30:00.000000','CREDIT_CARD','TRX-24-0001',25,26),(126,1890,'Tam ödeme','2024-01-22 15:45:00.000000','CREDIT_CARD','TRX-24-0002',26,27),(127,2450,'Tam ödeme','2024-02-08 10:15:00.000000','CASH','TRX-24-0003',27,28),(128,2150,'Tam ödeme','2024-02-20 11:30:00.000000','CREDIT_CARD','TRX-24-0004',28,29),(129,2750,'Tam ödeme','2024-03-10 12:45:00.000000','CREDIT_CARD','TRX-24-0005',29,30),(130,950,'Ön ödeme - %50','2024-03-20 13:15:00.000000','CREDIT_CARD','TRX-24-0006A',30,31),(131,775,'Ön ödeme - %50','2024-04-05 14:30:00.000000','CASH','TRX-24-0007A',31,32),(132,675,'Ön ödeme - %50','2024-04-20 15:45:00.000000','CREDIT_CARD','TRX-24-0008A',32,33),(133,1100,'Ön ödeme - %50','2024-05-05 10:15:00.000000','CREDIT_CARD','TRX-24-0009A',33,34),(134,825,'Ön ödeme - %50','2024-05-20 11:30:00.000000','CASH','TRX-24-0010A',34,35),(135,1275,'Ön ödeme - %50','2024-06-05 12:45:00.000000','CREDIT_CARD','TRX-24-0011A',35,36),(136,1150,'Ön ödeme - %50','2024-06-20 13:15:00.000000','CREDIT_CARD','TRX-24-0012A',36,37),(137,775,'Ön ödeme - %50','2024-07-05 14:30:00.000000','CASH','TRX-24-0013A',37,38),(138,700,'Ön ödeme - %50','2024-07-20 15:45:00.000000','CREDIT_CARD','TRX-24-0014A',38,39),(139,900,'Ön ödeme - %50','2024-08-05 10:15:00.000000','CREDIT_CARD','TRX-24-0015A',39,40),(140,1050,'Ön ödeme - %50','2024-08-20 11:30:00.000000','CASH','TRX-24-0016A',40,41),(141,825,'Ön ödeme - %50','2024-09-05 12:45:00.000000','CREDIT_CARD','TRX-24-0017A',41,42),(142,950,'Ön ödeme - %50','2024-09-20 13:15:00.000000','CREDIT_CARD','TRX-24-0018A',42,43),(143,1025,'Ön ödeme - %50','2024-10-05 14:30:00.000000','CASH','TRX-24-0019A',43,44),(144,1300,'Ön ödeme - %50','2024-10-20 15:45:00.000000','CREDIT_CARD','TRX-24-0020A',44,45),(145,925,'Ön ödeme - %50','2024-11-05 10:15:00.000000','CREDIT_CARD','TRX-24-0021A',45,46),(146,725,'Ön ödeme - %50','2024-11-20 11:30:00.000000','CASH','TRX-24-0022A',46,47),(147,1075,'Ön ödeme - %50','2024-12-05 12:45:00.000000','CREDIT_CARD','TRX-24-0023A',47,48),(148,1200,'Ön ödeme - %50','2024-12-20 13:15:00.000000','CREDIT_CARD','TRX-24-0024A',48,49),(149,950,'Ön ödeme - %50','2025-01-05 14:30:00.000000','CASH','TRX-25-0001A',49,50),(150,1000,'Ön ödeme - %50','2025-01-20 15:45:00.000000','CREDIT_CARD','TRX-25-0002A',50,51);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicecenters`
--

DROP TABLE IF EXISTS `servicecenters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicecenters` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `tax_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicecenters`
--

LOCK TABLES `servicecenters` WRITE;
/*!40000 ALTER TABLE `servicecenters` DISABLE KEYS */;
INSERT INTO `servicecenters` VALUES (1,_binary '','İstanbul, Kadıköy Mah. Motor Sk. No:12','Ahmet Yıldız','info@yildizservis.com','Yıldız Servis','0212 555 1001','1234567801'),(2,_binary '','Ankara, Çankaya Cad. No:45','Mehmet Demir','iletisim@merkezoto.com','Merkez Oto','0312 444 1002','1234567802'),(3,_binary '','İzmir, Konak Mah. Sanayi Cad. No:78','Ayşe Kaya','info@anadoluteknik.com','Anadolu Teknik','0232 333 1003','1234567803'),(4,_binary '','Bursa, Nilüfer Mah. Otomotiv Sk. No:23','Ali Özkan','servis@motorplus.com','Motor Plus','0224 222 1004','1234567804'),(5,_binary '','Antalya, Muratpaşa Cad. No:56','Zeynep Yılmaz','bilgi@teknikoto.com','Teknik Oto','0242 111 1005','1234567805'),(6,_binary '','Adana, Seyhan Mah. Otomotiv Cad. No:34','Mustafa Kara','iletisim@deltaservis.com','Delta Servis','0322 777 1006','1234567806'),(7,_binary '','İstanbul, Beşiktaş Mah. Motor Sk. No:67','Selin Ak','info@atolye34.com','Atölye 34','0212 888 1007','1234567807'),(8,_binary '','Ankara, Keçiören Mah. Sanayi Cad. No:12','Emre Çelik','servis@ustagarage.com','Usta Garage','0312 999 1008','1234567808'),(9,_binary '','Konya, Selçuklu Mah. Oto Sk. No:45','Hakan Taş','info@icanadoluteknik.com','İç Anadolu Teknik','0332 666 1009','1234567809'),(10,_binary '','İzmir, Bornova Mah. Tamirat Cad. No:89','Deniz Mavi','iletisim@mavimotor.com','Mavi Motor','0232 555 1010','1234567810'),(11,_binary '','Samsun, İlkadım Mah. Otomotiv Sk. No:56','Serkan Karadeniz','bilgi@karadenizoto.com','Karadeniz Oto','0362 444 1011','1234567811'),(12,_binary '','Mersin, Mezitli Mah. Tamirci Cad. No:23','Berk Akdeniz','info@akdenizteknik.com','Akdeniz Teknik','0324 333 1012','1234567812'),(13,_binary '','Erzurum, Yakutiye Mah. Motor Sk. No:78','Cem Doğu','servis@doguservis.com','Doğu Servis','0442 222 1013','1234567813'),(14,_binary '','Muğla, Bodrum Mah. Sanayi Cad. No:12','Ege Tekin','info@egeoto.com','Ege Oto','0252 111 1014','1234567814'),(15,_binary '','Edirne, Merkez Mah. Otomotiv Sk. No:45','Burak Avrupa','iletisim@avrupateknik.com','Avrupa Teknik','0284 777 1015','1234567815'),(16,_binary '','Eskişehir, Tepebaşı Mah. Tamir Cad. No:67','Yıldız Yıldırım','info@staroto.com','Star Oto','0222 888 1016','1234567816'),(17,_binary '','Kayseri, Melikgazi Mah. Motor Sk. No:34','Kaan Elit','servis@elitmotor.com','Elit Motor','0352 999 1017','1234567817'),(18,_binary '','Gaziantep, Şahinbey Mah. Otomotiv Cad. No:12','Levent Pro','bilgi@profesyonelservis.com','Profesyonel Servis','0342 666 1018','1234567818'),(19,_binary '','Diyarbakır, Yenişehir Mah. Oto Sk. No:45','Özgür Uzman','info@uzmanoto.com','Uzman Oto','0412 555 1019','1234567819'),(20,_binary '','Kocaeli, İzmit Mah. Servis Cad. No:89','Canan Premium','iletisim@premiumteknik.com','Premium Teknik','0262 444 1020','1234567820'),(21,_binary '','Sakarya, Adapazarı Mah. Tamirat Sk. No:56','Mehmet Mega','info@megamotor.com','Mega Motor','0264 333 1021','1234567821'),(22,_binary '','Trabzon, Ortahisar Mah. Motor Cad. No:23','Hasan Hızlı','servis@hizliservis.com','Hızlı Servis','0462 222 1022','1234567822'),(23,_binary '','Manisa, Şehzadeler Mah. Otomotiv Sk. No:78','Güven Güvenç','info@guvenoto.com','Güven Oto','0236 111 1023','1234567823'),(24,_binary '','Hatay, Antakya Mah. Sanayi Cad. No:12','Pınar Pro','iletisim@profesyonelteknik.com','Profesyonel Teknik','0326 777 1024','1234567824'),(25,_binary '','Balıkesir, Karesi Mah. Oto Sk. No:45','Acar Acaroğlu','bilgi@acarservis.com','Acar Servis','0266 888 1025','1234567825'),(26,_binary '','Denizli, Pamukkale Mah. Tamir Cad. No:67','Özel Özkan','info@ozelmotor.com','Özel Motor','0258 999 1026','1234567826'),(27,_binary '','Malatya, Yeşilyurt Mah. Motor Sk. No:34','Lider Liderci','servis@lideroto.com','Lider Oto','0422 666 1027','1234567827'),(28,_binary '','Kahramanmaraş, Dulkadiroğlu Mah. Otomotiv Cad. No:12','Tolga Teknik','info@teknikmaster.com','Teknik Master','0344 555 1028','1234567828'),(29,_binary '','Mardin, Artuklu Mah. Sanayi Sk. No:45','Gökhan Global','iletisim@globalservis.com','Global Servis','0482 444 1029','1234567829'),(30,_binary '','Tekirdağ, Süleymanpaşa Mah. Oto Cad. No:89','Yeni Yenioğlu','bilgi@yeninesiloto.com','Yeni Nesil Oto','0282 333 1030','1234567830'),(31,_binary '','Şanlıurfa, Haliliye Mah. Tamirat Sk. No:56','Turan Turuncu','info@turuncumotor.com','Turuncu Motor','0414 222 1031','1234567831'),(32,_binary '','Aydın, Efeler Mah. Motor Cad. No:23','Çetin Çözüm','servis@cozumteknik.com','Çözüm Teknik','0256 111 1032','1234567832'),(33,_binary '','Ordu, Altınordu Mah. Otomotiv Sk. No:78','Sinem Sistem','info@sistemoto.com','Sistem Oto','0452 777 1033','1234567833'),(34,_binary '','Tokat, Merkez Mah. Sanayi Cad. No:12','Mert Mekanik','iletisim@mekanikservis.com','Mekanik Servis','0356 888 1034','1234567834'),(35,_binary '','Zonguldak, Merkez Mah. Oto Sk. No:45','Gamze Garanti','bilgi@garantioto.com','Garanti Oto','0372 999 1035','1234567835'),(36,_binary '','Sivas, Merkez Mah. Tamir Cad. No:67','Başar Başarı','info@basariteknik.com','Başarı Teknik','0346 666 1036','1234567836'),(37,_binary '','Afyonkarahisar, Merkez Mah. Motor Sk. No:34','Umut Uygun','servis@uygunmotor.com','Uygun Motor','0272 555 1037','1234567837'),(38,_binary '','Kütahya, Merkez Mah. Otomotiv Cad. No:12','Yetkin Yetkili','info@yetkilioto.com','Yetkili Servis','0274 444 1038','1234567838'),(39,_binary '','Elazığ, Merkez Mah. Sanayi Sk. No:45','Utku Usta','iletisim@ustamoto.com','Usta Moto','0424 333 1039','1234567839'),(40,_binary '','Van, İpekyolu Mah. Oto Cad. No:89','Çetin Çelik','bilgi@celikmotor.com','Çelik Motor','0432 222 1040','1234567840'),(41,_binary '','Batman, Merkez Mah. Tamirat Sk. No:56','Alp Alaaddin','info@alaaddinoto.com','Alaaddin Oto','0488 111 1041','1234567841'),(42,_binary '','Kırıkkale, Merkez Mah. Motor Cad. No:23','Beyza Beyaz','servis@beyazteknik.com','Beyaz Teknik','0318 777 1042','1234567842'),(43,_binary '','Aksaray, Merkez Mah. Otomotiv Sk. No:78','Tarık Tam','info@tamservis.com','Tam Servis','0382 888 1043','1234567843'),(44,_binary '','Kastamonu, Merkez Mah. Sanayi Cad. No:12','Evin Evci','iletisim@motorevi.com','Motor Evi','0366 999 1044','1234567844'),(45,_binary '','Düzce, Merkez Mah. Oto Sk. No:45','Kemal Keskin','bilgi@keskinoto.com','Keskin Oto','0380 666 1045','1234567845'),(46,_binary '','Uşak, Merkez Mah. Tamir Cad. No:67','Murat Makina','info@makinateknik.com','Makina Teknik','0276 555 1046','1234567846'),(47,_binary '','Bitlis, Merkez Mah. Motor Sk. No:34','Nesrin Nisan','servis@nisanmotor.com','Nisan Motor','0434 444 1047','1234567847'),(48,_binary '','Kırşehir, Merkez Mah. Otomotiv Cad. No:12','Selim Sonsuz','info@sonsuzservis.com','Sonsuz Servis','0386 333 1048','1234567848'),(49,_binary '','Yozgat, Merkez Mah. Sanayi Sk. No:45','Ümit Üstün','iletisim@ustunoto.com','Üstün Oto','0354 222 1049','1234567849'),(50,_binary '','Çankırı, Merkez Mah. Oto Cad. No:89','Veli Vizyon','bilgi@vizyonteknik.com','Vizyon Teknik','0376 111 1050','1234567850');
/*!40000 ALTER TABLE `servicecenters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_types`
--

DROP TABLE IF EXISTS `vehicle_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_60iboy5hwibufl71hsc73g35i` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_types`
--

LOCK TABLES `vehicle_types` WRITE;
/*!40000 ALTER TABLE `vehicle_types` DISABLE KEYS */;
INSERT INTO `vehicle_types` VALUES (1,'Klasik 4 kapılı, 5 kişilik araç tipi','Sedan'),(2,'Spor çok amaçlı araç','SUV'),(3,'Arkadan açılabilir kapak özelliği olan küçük araçlar','Hatchback'),(4,'İki kapılı spor araçlar','Coupe'),(5,'Üstü açılabilir araçlar','Convertible'),(6,'Station wagon tipi geniş bagajlı araçlar','Wagon'),(7,'Çok kişilik aile araçları','Minivan'),(8,'Arkasında açık kasası olan araçlar','Pickup'),(9,'SUV ve sedan karışımı araçlar','Crossover'),(10,'Lüks segment araçlar','Luxury');
/*!40000 ALTER TABLE `vehicle_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicleinsurances`
--

DROP TABLE IF EXISTS `vehicleinsurances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicleinsurances` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) NOT NULL,
  `cost` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) NOT NULL,
  `policy_number` varchar(255) NOT NULL,
  `start_date` datetime(6) NOT NULL,
  `insurance_id` bigint NOT NULL,
  `vehicle_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_aohjlenuvjnwjfdxo527qag9e` (`policy_number`),
  KEY `FKh69sgfyogeobv8dpt7sv67dre` (`insurance_id`),
  KEY `FK1qfucidtq0edf67gjx58l345n` (`vehicle_id`),
  CONSTRAINT `FK1qfucidtq0edf67gjx58l345n` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`),
  CONSTRAINT `FKh69sgfyogeobv8dpt7sv67dre` FOREIGN KEY (`insurance_id`) REFERENCES `insurances` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicleinsurances`
--

LOCK TABLES `vehicleinsurances` WRITE;
/*!40000 ALTER TABLE `vehicleinsurances` DISABLE KEYS */;
INSERT INTO `vehicleinsurances` VALUES (1,_binary '',1200,'Zorunlu trafik sigortası','2023-01-25 00:00:00.000000','POL-TR-100001','2022-01-25 00:00:00.000000',1,1),(2,_binary '',3500,'Tam kapsamlı kasko','2022-04-15 00:00:00.000000','POL-TR-100002','2021-04-15 00:00:00.000000',3,2),(3,_binary '',2800,'Premium kasko paketi','2024-03-01 00:00:00.000000','POL-TR-100003','2023-03-01 00:00:00.000000',2,3),(4,_binary '',1500,'Genişletilmiş trafik sigortası','2023-06-10 00:00:00.000000','POL-TR-100004','2022-06-10 00:00:00.000000',5,4),(5,_binary '',4200,'Tam kapsamlı kasko','2024-02-05 00:00:00.000000','POL-TR-100005','2023-02-05 00:00:00.000000',3,5),(6,_binary '',3800,'Lüks araç sigortası','2022-07-20 00:00:00.000000','POL-TR-100006','2021-07-20 00:00:00.000000',6,6),(7,_binary '',3100,'Premium kasko paketi','2023-04-12 00:00:00.000000','POL-TR-100007','2022-04-12 00:00:00.000000',2,7),(8,_binary '',3600,'Tam kapsamlı kasko','2024-05-30 00:00:00.000000','POL-TR-100008','2023-05-30 00:00:00.000000',3,8),(9,_binary '',1150,'Zorunlu trafik sigortası','2022-09-15 00:00:00.000000','POL-TR-100009','2021-09-15 00:00:00.000000',1,9),(10,_binary '',2200,'Ekonomik kasko paketi','2023-08-25 00:00:00.000000','POL-TR-100010','2022-08-25 00:00:00.000000',4,10),(11,_binary '',1300,'Ekonomik trafik sigortası','2024-06-10 00:00:00.000000','POL-TR-100011','2023-06-10 00:00:00.000000',7,11),(12,_binary '',2500,'Genç sürücü kasko paketi','2023-05-15 00:00:00.000000','POL-TR-100012','2022-05-15 00:00:00.000000',8,12),(13,_binary '',3200,'Oto koruma paketi','2022-10-20 00:00:00.000000','POL-TR-100013','2021-10-20 00:00:00.000000',11,13),(14,_binary '',4300,'Tam kapsamlı kasko','2024-04-05 00:00:00.000000','POL-TR-100014','2023-04-05 00:00:00.000000',3,14),(15,_binary '',1600,'Genişletilmiş trafik sigortası','2023-07-10 00:00:00.000000','POL-TR-100015','2022-07-10 00:00:00.000000',5,15),(16,_binary '',3900,'Süper kasko paketi','2022-11-15 00:00:00.000000','POL-TR-100016','2021-11-15 00:00:00.000000',15,16),(17,_binary '',3500,'Klasik araç özel sigortası','2024-08-20 00:00:00.000000','POL-TR-100017','2023-08-20 00:00:00.000000',9,17),(18,_binary '',1800,'Ticari araç trafik sigortası','2023-09-25 00:00:00.000000','POL-TR-100018','2022-09-25 00:00:00.000000',10,18),(19,_binary '',2100,'Motosiklet sigortası','2022-12-30 00:00:00.000000','POL-TR-100019','2021-12-30 00:00:00.000000',13,19),(20,_binary '',1250,'Ekonomik trafik sigortası','2024-10-05 00:00:00.000000','POL-TR-100020','2023-10-05 00:00:00.000000',14,20),(21,_binary '',3700,'İş aracı sigortası','2023-11-10 00:00:00.000000','POL-TR-100021','2022-11-10 00:00:00.000000',12,21),(22,_binary '',1550,'Genişletilmiş trafik sigortası','2022-01-15 00:00:00.000000','POL-TR-100022','2021-01-15 00:00:00.000000',5,22),(23,_binary '',2800,'Rent A Car sigortası','2024-12-20 00:00:00.000000','POL-TR-100023','2023-12-20 00:00:00.000000',16,23),(24,_binary '',3300,'Premium kasko paketi','2023-02-25 00:00:00.000000','POL-TR-100024','2022-02-25 00:00:00.000000',2,24),(25,_binary '',2900,'Aile kasko paketi','2022-03-30 00:00:00.000000','POL-TR-100025','2021-03-30 00:00:00.000000',18,25),(26,_binary '',4100,'Yüksek koruma sigortası','2024-01-05 00:00:00.000000','POL-TR-100026','2023-01-05 00:00:00.000000',19,26),(27,_binary '',1900,'Oto garanti uzatma','2023-04-10 00:00:00.000000','POL-TR-100027','2022-04-10 00:00:00.000000',20,27),(28,_binary '',3400,'Ticari kasko paketi','2022-05-15 00:00:00.000000','POL-TR-100028','2021-05-15 00:00:00.000000',21,28),(29,_binary '',3650,'Premium kasko paketi','2024-07-20 00:00:00.000000','POL-TR-100029','2023-07-20 00:00:00.000000',2,29),(30,_binary '',2600,'Minibüs kasko paketi','2023-08-25 00:00:00.000000','POL-TR-100030','2022-08-25 00:00:00.000000',25,30),(31,_binary '',1180,'Zorunlu trafik sigortası','2022-02-28 00:00:00.000000','POL-TR-100031','2021-02-28 00:00:00.000000',1,31),(32,_binary '',3550,'Tam kapsamlı kasko','2024-09-10 00:00:00.000000','POL-TR-100032','2023-09-10 00:00:00.000000',3,32),(33,_binary '',1850,'Ticari araç trafik sigortası','2023-06-15 00:00:00.000000','POL-TR-100033','2022-06-15 00:00:00.000000',10,33),(34,_binary '',3250,'Premium kasko paketi','2022-07-20 00:00:00.000000','POL-TR-100034','2021-07-20 00:00:00.000000',2,34),(35,_binary '',3950,'Uzun yol kasko paketi','2024-01-25 00:00:00.000000','POL-TR-100035','2023-01-25 00:00:00.000000',28,35),(36,_binary '',4250,'Tam kapsamlı kasko','2023-12-01 00:00:00.000000','POL-TR-100036','2022-12-01 00:00:00.000000',3,36),(37,_binary '',1650,'Genişletilmiş trafik sigortası','2022-09-05 00:00:00.000000','POL-TR-100037','2021-09-05 00:00:00.000000',5,37),(38,_binary '',4800,'Filo araç sigortası','2024-02-10 00:00:00.000000','POL-TR-100038','2023-02-10 00:00:00.000000',29,38),(39,_binary '',3150,'Oto koruma paketi','2023-08-15 00:00:00.000000','POL-TR-100039','2022-08-15 00:00:00.000000',11,39),(40,_binary '',3750,'Klasik araç özel sigortası','2022-07-20 00:00:00.000000','POL-TR-100040','2021-07-20 00:00:00.000000',9,40),(41,_binary '',1350,'Zorunlu trafik sigortası','2024-11-25 00:00:00.000000','POL-TR-100041','2023-11-25 00:00:00.000000',1,41),(42,_binary '',3450,'Premium kasko paketi','2023-09-30 00:00:00.000000','POL-TR-100042','2022-09-30 00:00:00.000000',2,42),(43,_binary '',1700,'Genişletilmiş trafik sigortası','2022-06-05 00:00:00.000000','POL-TR-100043','2021-06-05 00:00:00.000000',5,43),(44,_binary '',4350,'Tam kapsamlı kasko','2024-03-10 00:00:00.000000','POL-TR-100044','2023-03-10 00:00:00.000000',3,44),(45,_binary '',2250,'Araç değer kaybı sigortası','2023-12-15 00:00:00.000000','POL-TR-100045','2022-12-15 00:00:00.000000',30,45),(46,_binary '',1220,'Zorunlu trafik sigortası','2022-10-20 00:00:00.000000','POL-TR-100046','2021-10-20 00:00:00.000000',1,46),(47,_binary '',4050,'Süper kasko paketi','2024-05-25 00:00:00.000000','POL-TR-100047','2023-05-25 00:00:00.000000',15,47),(48,_binary '',1750,'Genişletilmiş trafik sigortası','2023-11-30 00:00:00.000000','POL-TR-100048','2022-11-30 00:00:00.000000',5,48),(49,_binary '',3350,'Premium kasko paketi','2022-12-05 00:00:00.000000','POL-TR-100049','2021-12-05 00:00:00.000000',2,49),(50,_binary '',4150,'Tam kapsamlı kasko','2024-04-10 00:00:00.000000','POL-TR-100050','2023-04-10 00:00:00.000000',3,50);
/*!40000 ALTER TABLE `vehicleinsurances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `chassis_no` varchar(255) DEFAULT NULL,
  `color` varchar(255) NOT NULL,
  `daily_rate` double NOT NULL,
  `engine_capacity` int DEFAULT NULL,
  `engine_power` int DEFAULT NULL,
  `fuel_type` varchar(255) NOT NULL,
  `manufactureYear` int NOT NULL,
  `mileage` int NOT NULL,
  `plate` varchar(255) NOT NULL,
  `purchase_date` date DEFAULT NULL,
  `registration_no` varchar(255) DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `transmission_type` varchar(255) NOT NULL,
  `branch_id` bigint NOT NULL,
  `make_id` bigint NOT NULL,
  `model_id` bigint NOT NULL,
  `vehicle_type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lle7kf4cbmwh6twthj1tik9us` (`plate`),
  UNIQUE KEY `UK_8japfiy1bsqr8ko7iowppcohf` (`chassis_no`),
  UNIQUE KEY `UK_6i8sfyxrihwn5mtf1c58o9vqw` (`registration_no`),
  KEY `FK6ixo0t4ynljk4xep1u9dpfhdv` (`branch_id`),
  KEY `FKjg7io1k1o1wgolbmf040w2h84` (`make_id`),
  KEY `FKcqr04i693x6qn5mh3x8m4ilr7` (`model_id`),
  KEY `FKk3cs3vldlan30kg1x6b57i4fe` (`vehicle_type_id`),
  CONSTRAINT `FK6ixo0t4ynljk4xep1u9dpfhdv` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`),
  CONSTRAINT `FKcqr04i693x6qn5mh3x8m4ilr7` FOREIGN KEY (`model_id`) REFERENCES `models` (`id`),
  CONSTRAINT `FKjg7io1k1o1wgolbmf040w2h84` FOREIGN KEY (`make_id`) REFERENCES `makes` (`id`),
  CONSTRAINT `FKk3cs3vldlan30kg1x6b57i4fe` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'CHS10001','Beyaz',300,1600,120,'Benzin',2022,15000,'34ABC123','2022-01-15','REG10001',NULL,'AVAILABLE','Otomatik',1,1,1,1),(2,'CHS10002','Siyah',280,1500,110,'Dizel',2021,25000,'34DEF456','2021-03-20','REG10002',NULL,'AVAILABLE','Otomatik',2,2,4,2),(3,'CHS10003','Kırmızı',450,2000,180,'Benzin',2023,8000,'34GHI789','2023-02-10','REG10003',NULL,'AVAILABLE','Otomatik',3,3,7,3),(4,'CHS10004','Gri',350,1800,150,'Dizel',2022,18000,'34JKL012','2022-05-05','REG10004',NULL,'AVAILABLE','Otomatik',4,4,10,4),(5,'CHS10005','Mavi',500,2200,200,'Benzin',2023,10000,'34MNO345','2023-01-20','REG10005',NULL,'AVAILABLE','Otomatik',5,5,13,5),(6,'CHS10006','Siyah',450,2000,190,'Dizel',2021,20000,'34PQR678','2021-06-15','REG10006',NULL,'AVAILABLE','Otomatik',6,6,16,6),(7,'CHS10007','Beyaz',400,1800,170,'Benzin',2022,15000,'34STU901','2022-03-10','REG10007',NULL,'AVAILABLE','Otomatik',7,7,19,7),(8,'CHS10008','Gri',420,2000,180,'Dizel',2023,9000,'34VWX234','2023-04-25','REG10008',NULL,'AVAILABLE','Otomatik',8,8,22,8),(9,'CHS10009','Beyaz',300,1600,130,'Benzin',2021,22000,'34YZA567','2021-08-18','REG10009',NULL,'AVAILABLE','Otomatik',9,9,25,9),(10,'CHS10010','Siyah',280,1500,120,'Dizel',2022,18000,'34BCD890','2022-07-30','REG10010',NULL,'AVAILABLE','Otomatik',10,10,28,10),(11,'CHS10011','Mavi',320,1800,140,'Benzin',2023,10000,'06EFG123','2023-05-12','REG10011',NULL,'AVAILABLE','Otomatik',1,1,2,1),(12,'CHS10012','Beyaz',290,1600,130,'Dizel',2022,16000,'06HIJ456','2022-04-22','REG10012',NULL,'AVAILABLE','Otomatik',2,2,5,2),(13,'CHS10013','Siyah',430,2000,180,'Dizel',2021,24000,'06KLM789','2021-09-14','REG10013',NULL,'AVAILABLE','Otomatik',3,3,8,3),(14,'CHS10014','Kırmızı',500,2200,200,'Benzin',2023,7000,'06NOP012','2023-03-30','REG10014',NULL,'AVAILABLE','Otomatik',4,4,11,4),(15,'CHS10015','Gri',450,2000,190,'Dizel',2022,14000,'06QRS345','2022-06-25','REG10015',NULL,'AVAILABLE','Otomatik',5,5,14,5),(16,'CHS10016','Beyaz',380,1800,160,'Benzin',2021,21000,'06TUV678','2021-10-10','REG10016',NULL,'AVAILABLE','Otomatik',6,6,17,6),(17,'CHS10017','Siyah',320,1600,140,'Dizel',2023,8000,'35WXY901','2023-07-05','REG10017',NULL,'AVAILABLE','Otomatik',7,7,20,7),(18,'CHS10018','Mavi',280,1500,120,'Benzin',2022,13000,'35ZAB234','2022-08-20','REG10018',NULL,'AVAILABLE','Otomatik',8,8,23,8),(19,'CHS10019','Gri',340,1800,150,'Dizel',2021,26000,'35CDE567','2021-11-15','REG10019',NULL,'AVAILABLE','Otomatik',9,9,26,9),(20,'CHS10020','Beyaz',400,2000,170,'Benzin',2023,6000,'35FGH890','2023-09-10','REG10020',NULL,'AVAILABLE','Otomatik',10,10,29,10),(21,'CHS10021','Siyah',480,2200,200,'Dizel',2022,12000,'16IJK123','2022-10-05','REG10021',NULL,'AVAILABLE','Otomatik',1,1,3,1),(22,'CHS10022','Kırmızı',370,1800,160,'Benzin',2021,23000,'16LMN456','2021-12-18','REG10022',NULL,'AVAILABLE','Otomatik',2,2,6,2),(23,'CHS10023','Gri',420,2000,180,'Dizel',2023,5000,'16OPQ789','2023-11-25','REG10023',NULL,'AVAILABLE','Otomatik',3,3,9,3),(24,'CHS10024','Beyaz',520,2200,210,'Benzin',2022,11000,'16RST012','2022-12-20','REG10024',NULL,'AVAILABLE','Otomatik',4,4,12,4),(25,'CHS10025','Mavi',290,1600,130,'Dizel',2021,28000,'16UVW345','2021-11-30','REG10025',NULL,'AVAILABLE','Otomatik',5,5,15,5),(26,'CHS10026','Siyah',270,1500,120,'Benzin',2023,4000,'16XYZ678','2023-10-15','REG10026',NULL,'AVAILABLE','Otomatik',6,6,18,6),(27,'CHS10027','Beyaz',350,1800,150,'Dizel',2022,13000,'01ABC901','2022-09-28','REG10027',NULL,'AVAILABLE','Otomatik',7,7,21,7),(28,'CHS10028','Gri',430,2000,190,'Benzin',2021,19000,'01DEF234','2021-08-05','REG10028',NULL,'AVAILABLE','Otomatik',8,8,24,8),(29,'CHS10029','Kırmızı',550,2200,210,'Dizel',2023,3000,'01GHI567','2023-06-20','REG10029',NULL,'AVAILABLE','Otomatik',9,9,27,9),(30,'CHS10030','Beyaz',380,1800,160,'Benzin',2022,14000,'01JKL890','2022-11-10','REG10030',NULL,'AVAILABLE','Otomatik',10,10,30,10),(31,'CHS10031','Siyah',310,1600,130,'Dizel',2021,27000,'07MNO123','2021-07-25','REG10031',NULL,'AVAILABLE','Otomatik',1,1,1,1),(32,'CHS10032','Mavi',270,1500,120,'Benzin',2023,9000,'07PQR456','2023-08-15','REG10032',NULL,'AVAILABLE','Otomatik',2,2,4,2),(33,'CHS10033','Gri',440,2000,180,'Dizel',2022,17000,'07STU789','2022-05-30','REG10033',NULL,'AVAILABLE','Otomatik',3,3,7,3),(34,'CHS10034','Beyaz',330,1800,150,'Benzin',2021,25000,'07VWX012','2021-04-18','REG10034',NULL,'AVAILABLE','Otomatik',4,4,10,4),(35,'CHS10035','Kırmızı',510,2200,200,'Dizel',2023,7000,'07YZA345','2023-12-05','REG10035',NULL,'AVAILABLE','Otomatik',5,5,13,5),(36,'CHS10036','Siyah',460,2000,190,'Benzin',2022,12000,'07BCD678','2022-10-22','REG10036',NULL,'AVAILABLE','Otomatik',6,6,16,6),(37,'CHS10037','Beyaz',310,1600,130,'Dizel',2021,23000,'33EFG901','2021-09-14','REG10037',NULL,'AVAILABLE','Otomatik',7,7,19,7),(38,'CHS10038','Mavi',280,1500,120,'Benzin',2023,8000,'33HIJ234','2023-11-30','REG10038',NULL,'AVAILABLE','Otomatik',8,8,22,8),(39,'CHS10039','Gri',360,1800,150,'Dizel',2022,15000,'33KLM567','2022-07-15','REG10039',NULL,'AVAILABLE','Otomatik',9,9,25,9),(40,'CHS10040','Siyah',420,2000,180,'Benzin',2021,28000,'33NOP890','2021-06-20','REG10040',NULL,'AVAILABLE','Otomatik',10,10,28,10),(41,'CHS10041','Beyaz',330,1600,140,'Dizel',2023,6000,'42QRS123','2023-10-10','REG10041',NULL,'AVAILABLE','Otomatik',1,1,2,1),(42,'CHS10042','Kırmızı',380,1800,160,'Benzin',2022,13000,'42TUV456','2022-08-25','REG10042',NULL,'AVAILABLE','Otomatik',2,2,5,2),(43,'CHS10043','Gri',410,2000,170,'Dizel',2021,24000,'42WXY789','2021-05-15','REG10043',NULL,'AVAILABLE','Otomatik',3,3,8,3),(44,'CHS10044','Mavi',520,2200,200,'Benzin',2023,5000,'42ZAB012','2023-07-28','REG10044',NULL,'AVAILABLE','Otomatik',4,4,11,4),(45,'CHS10045','Siyah',370,1800,150,'Dizel',2022,16000,'42CDE345','2022-06-10','REG10045',NULL,'AVAILABLE','Otomatik',5,5,14,5),(46,'CHS10046','Beyaz',290,1500,120,'Benzin',2021,26000,'42FGH678','2021-09-22','REG10046',NULL,'AVAILABLE','Otomatik',6,6,17,6),(47,'CHS10047','Kırmızı',430,2000,180,'Dizel',2023,7000,'42IJK901','2023-04-15','REG10047',NULL,'AVAILABLE','Otomatik',7,7,20,7),(48,'CHS10048','Gri',370,1800,160,'Benzin',2022,14000,'42LMN234','2022-12-12','REG10048',NULL,'AVAILABLE','Otomatik',8,8,23,8),(49,'CHS10049','Beyaz',320,1600,130,'Dizel',2021,22000,'42OPQ567','2021-10-30','REG10049',NULL,'AVAILABLE','Otomatik',9,9,26,9),(50,'CHS10050','Siyah',540,2200,210,'Benzin',2023,4000,'42RST890','2023-12-25','REG10050',NULL,'AVAILABLE','Otomatik',10,10,29,10);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicleservicerecords`
--

DROP TABLE IF EXISTS `vehicleservicerecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicleservicerecords` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cost` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `entry_date` datetime(6) NOT NULL,
  `exit_date` datetime(6) DEFAULT NULL,
  `mileage` int NOT NULL,
  `performed_operations` varchar(255) DEFAULT NULL,
  `service_type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `service_center_id` bigint NOT NULL,
  `vehicle_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcl1exgs79s5yc29rmm02qtl1` (`service_center_id`),
  KEY `FKdkqlb77wyrfwkdb0n5pj9682` (`vehicle_id`),
  CONSTRAINT `FKcl1exgs79s5yc29rmm02qtl1` FOREIGN KEY (`service_center_id`) REFERENCES `servicecenters` (`id`),
  CONSTRAINT `FKdkqlb77wyrfwkdb0n5pj9682` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicleservicerecords`
--

LOCK TABLES `vehicleservicerecords` WRITE;
/*!40000 ALTER TABLE `vehicleservicerecords` DISABLE KEYS */;
INSERT INTO `vehicleservicerecords` VALUES (1,850,'10.000 km bakımı','2022-03-15 00:00:00.000000','2022-03-16 00:00:00.000000',20000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',1,1),(2,950,'30.000 km bakımı','2021-09-20 00:00:00.000000','2021-09-21 00:00:00.000000',30000,'Yağ, filtre, buji değişimi, genel kontrol','Periyodik Bakım','COMPLETED',2,2),(3,2800,'Kaza sonrası ön tampon değişimi','2023-04-15 00:00:00.000000','2023-04-20 00:00:00.000000',12000,'Tampon değişimi, boya işlemi','Hasar Onarım','COMPLETED',3,3),(4,920,'20.000 km bakımı','2022-07-10 00:00:00.000000','2022-07-11 00:00:00.000000',25000,'Yağ, filtre değişimi, fren balataları kontrolü','Periyodik Bakım','COMPLETED',4,4),(5,0,'Motor arızası kontrolü','2023-03-25 00:00:00.000000','2023-03-28 00:00:00.000000',15000,'Elektronik sistem kontrolü, yazılım güncelleme','Garanti Kapsamında Onarım','COMPLETED',5,5),(6,3500,'Yan panel değişimi','2021-12-05 00:00:00.000000','2021-12-10 00:00:00.000000',25000,'Panel değişimi, boya işlemleri','Hasar Onarım','COMPLETED',6,6),(7,780,'20.000 km bakımı','2022-05-18 00:00:00.000000','2022-05-19 00:00:00.000000',20000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',7,7),(8,2200,'4 adet lastik değişimi','2023-06-20 00:00:00.000000','2023-06-20 00:00:00.000000',15000,'Lastik değişimi, balans ayarı','Lastik Değişimi','COMPLETED',8,8),(9,950,'20.000 km bakımı','2021-11-15 00:00:00.000000','2021-11-16 00:00:00.000000',27000,'Yağ, filtre değişimi, akü kontrolü','Periyodik Bakım','COMPLETED',9,9),(10,650,'Klima gazı değişimi','2022-06-25 00:00:00.000000','2022-06-26 00:00:00.000000',22000,'Klima gazı dolumu, sistem kontrolü','Klima Bakımı','COMPLETED',10,10),(11,820,'10.000 km bakımı','2023-07-30 00:00:00.000000','2023-07-31 00:00:00.000000',15000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',11,11),(12,1350,'Fren balatası değişimi','2022-08-10 00:00:00.000000','2022-08-12 00:00:00.000000',20000,'Fren balatası ve disk değişimi','Fren Sistemi Tamiri','COMPLETED',12,12),(13,980,'30.000 km bakımı','2021-12-15 00:00:00.000000','2021-12-16 00:00:00.000000',30000,'Yağ, filtre, yakıt filtresi değişimi','Periyodik Bakım','COMPLETED',13,13),(14,750,'Akü arızası','2023-05-20 00:00:00.000000','2023-05-20 00:00:00.000000',12000,'Akü değişimi, şarj sistemi kontrolü','Akü Değişimi','COMPLETED',14,14),(15,850,'10.000 km bakımı','2022-09-25 00:00:00.000000','2022-09-26 00:00:00.000000',18000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',15,15),(16,1850,'Amortisör arızası','2021-12-10 00:00:00.000000','2021-12-15 00:00:00.000000',25000,'Ön amortisör değişimi','Süspansiyon Tamiri','COMPLETED',16,16),(17,780,'10.000 km bakımı','2023-09-05 00:00:00.000000','2023-09-06 00:00:00.000000',12000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',17,17),(18,3200,'Arka tamponda hasar','2022-10-15 00:00:00.000000','2022-10-20 00:00:00.000000',18000,'Tampon değişimi, boya işlemi','Hasar Onarım','COMPLETED',18,18),(19,920,'30.000 km bakımı','2022-01-10 00:00:00.000000','2022-01-11 00:00:00.000000',30000,'Yağ, filtre değişimi, triger kayışı kontrolü','Periyodik Bakım','COMPLETED',19,19),(20,950,'Sağ far arızası','2023-11-15 00:00:00.000000','2023-11-16 00:00:00.000000',10000,'Far değişimi, elektrik sistemi kontrolü','Far Değişimi','COMPLETED',20,20),(21,850,'10.000 km bakımı','2023-01-20 00:00:00.000000','2023-01-21 00:00:00.000000',15000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',21,21),(22,2200,'Debriyaj aşınması','2021-11-25 00:00:00.000000','2021-12-01 00:00:00.000000',28000,'Debriyaj seti değişimi','Debriyaj Tamiri','COMPLETED',22,22),(23,780,'10.000 km bakımı','2023-12-30 00:00:00.000000','2023-12-31 00:00:00.000000',10000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',23,23),(24,950,'Ön cam çatlağı','2022-03-15 00:00:00.000000','2022-03-16 00:00:00.000000',15000,'Ön cam değişimi','Cam Değişimi','COMPLETED',24,24),(25,980,'30.000 km bakımı','2021-12-20 00:00:00.000000','2021-12-21 00:00:00.000000',32000,'Yağ, filtre değişimi, yakıt filtresi değişimi','Periyodik Bakım','COMPLETED',25,25),(26,1250,'Motor kontrol lambası yanması','2023-02-10 00:00:00.000000','2023-02-12 00:00:00.000000',8000,'Sensör değişimi, yazılım güncelleme','Elektronik Sistem Tamiri','COMPLETED',26,26),(27,820,'10.000 km bakımı','2022-05-15 00:00:00.000000','2022-05-16 00:00:00.000000',18000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',27,27),(28,3800,'Şanzıman arızası','2021-08-20 00:00:00.000000','2021-08-25 00:00:00.000000',29000,'Şanzıman revizyonu','Şanzıman Tamiri','COMPLETED',28,28),(29,750,'10.000 km bakımı','2023-08-10 00:00:00.000000','2023-08-11 00:00:00.000000',8000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',29,29),(30,1150,'Radyatör sızıntısı','2022-09-20 00:00:00.000000','2022-09-22 00:00:00.000000',19000,'Radyatör değişimi, soğutma sistemi kontrolü','Radyatör Değişimi','COMPLETED',30,30),(31,920,'30.000 km bakımı','2021-04-25 00:00:00.000000','2021-04-26 00:00:00.000000',32000,'Yağ, filtre, buji değişimi','Periyodik Bakım','COMPLETED',1,31),(32,2500,'Kapı hasarı','2023-10-05 00:00:00.000000','2023-10-10 00:00:00.000000',14000,'Kapı panel değişimi, boya işlemi','Hasar Onarım','COMPLETED',2,32),(33,850,'20.000 km bakımı','2022-07-20 00:00:00.000000','2022-07-21 00:00:00.000000',22000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',3,33),(34,1200,'Şarj sorunu','2021-10-15 00:00:00.000000','2021-10-17 00:00:00.000000',30000,'Alternatör değişimi','Alternatör Tamiri','COMPLETED',4,34),(35,780,'10.000 km bakımı','2023-03-05 00:00:00.000000','2023-03-06 00:00:00.000000',12000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',5,35),(36,1850,'Direksiyon pompası arızası','2022-11-10 00:00:00.000000','2022-11-13 00:00:00.000000',17000,'Direksiyon pompası değişimi','Direksiyon Sistemi Tamiri','COMPLETED',6,36),(37,920,'20.000 km bakımı','2021-11-25 00:00:00.000000','2021-11-26 00:00:00.000000',28000,'Yağ, filtre değişimi, fren balataları kontrolü','Periyodik Bakım','COMPLETED',7,37),(38,4500,'Motor performans kaybı','2023-12-10 00:00:00.000000','2023-12-18 00:00:00.000000',13000,'Motor revizyonu','Motor Tamiri','COMPLETED',8,38),(39,850,'20.000 km bakımı','2022-09-15 00:00:00.000000','2022-09-16 00:00:00.000000',20000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',9,39),(40,950,'Egzoz sızıntısı','2021-08-20 00:00:00.000000','2021-08-22 00:00:00.000000',32000,'Egzoz borusu değişimi','Egzoz Tamiri','COMPLETED',10,40),(41,780,'10.000 km bakımı','2023-12-05 00:00:00.000000','2023-12-06 00:00:00.000000',10000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',11,41),(42,2800,'Çamurluk hasarı','2022-10-10 00:00:00.000000','2022-10-15 00:00:00.000000',18000,'Çamurluk değişimi, boya işlemi','Hasar Onarım','COMPLETED',12,42),(43,950,'20.000 km bakımı','2021-07-15 00:00:00.000000','2021-07-16 00:00:00.000000',29000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',13,43),(44,1150,'Fren merkezi arızası','2023-04-20 00:00:00.000000','2023-04-22 00:00:00.000000',10000,'Fren merkezi değişimi','Fren Tamiri','COMPLETED',14,44),(45,880,'20.000 km bakımı','2022-12-25 00:00:00.000000','2022-12-26 00:00:00.000000',21000,'Yağ, filtre değişimi, fren balataları kontrolü','Periyodik Bakım','COMPLETED',15,45),(46,1800,'Jantlarda deformasyon','2021-12-15 00:00:00.000000','2021-12-16 00:00:00.000000',31000,'4 adet jant değişimi','Jant Değişimi','COMPLETED',16,46),(47,780,'10.000 km bakımı','2023-05-20 00:00:00.000000','2023-05-21 00:00:00.000000',12000,'Yağ, filtre değişimi, fren kontrolü','Periyodik Bakım','COMPLETED',17,47),(48,1350,'Elektronik arıza','2022-12-30 00:00:00.000000','2023-01-02 00:00:00.000000',19000,'Elektrik tesisatı kontrolü, sensör değişimi','Elektrik Sistemi Tamiri','COMPLETED',18,48),(49,920,'20.000 km bakımı','2021-12-10 00:00:00.000000','2021-12-11 00:00:00.000000',27000,'Yağ, filtre değişimi, genel kontrol','Periyodik Bakım','COMPLETED',19,49),(50,1250,'Yakıt pompası arızası','2023-01-15 00:00:00.000000','2023-01-18 00:00:00.000000',9000,'Yakıt pompası değişimi','Yakıt Sistemi Tamiri','COMPLETED',20,50);
/*!40000 ALTER TABLE `vehicleservicerecords` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-11 15:06:41
