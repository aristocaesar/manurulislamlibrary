-- MariaDB dump 10.19  Distrib 10.5.15-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: manurulislam
-- ------------------------------------------------------
-- Server version	10.5.15-MariaDB-1:10.5.15+maria~bullseye

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ma_anggota`
--

DROP TABLE IF EXISTS `ma_anggota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_anggota` (
  `nis` varchar(28) NOT NULL,
  `nama_lengkap` varchar(128) DEFAULT '',
  `jurusan` varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jumlah_buku_dipinjam` int(11) NOT NULL DEFAULT 0,
  `skor` int(100) DEFAULT 100,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`nis`),
  KEY `FK Jurusan` (`jurusan`),
  CONSTRAINT `FK Jurusan` FOREIGN KEY (`jurusan`) REFERENCES `ma_jurusan` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_anggota`
--

LOCK TABLES `ma_anggota` WRITE;
/*!40000 ALTER TABLE `ma_anggota` DISABLE KEYS */;
INSERT INTO `ma_anggota` VALUES ('E41211739','Ahjl','TKJ',0,100,'2022-05-11 16:20:11','2022-05-11 16:20:11'),('E41211740','Hana Wulan Agusta','TKJ',0,100,'2022-05-11 16:18:58','2022-05-11 16:18:58'),('E41211741','Mega Kharisma','TKJ',0,100,'2022-05-11 23:01:06','2022-05-11 23:01:06');
/*!40000 ALTER TABLE `ma_anggota` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ADD_COUNT_ANGGOTA` BEFORE INSERT ON `ma_anggota` FOR EACH ROW UPDATE ma_dashboard SET total_anggota = (SELECT SUM(total_anggota) + 1 FROM ma_dashboard) WHERE id = 1 */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `LESS_COUNT_ANGGOTA` BEFORE DELETE ON `ma_anggota` FOR EACH ROW UPDATE ma_dashboard SET total_anggota = (SELECT SUM(total_anggota) - 1 FROM ma_dashboard) WHERE id = 1 */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ma_buku`
--

DROP TABLE IF EXISTS `ma_buku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_buku` (
  `isbn` varchar(28) NOT NULL,
  `judul` varchar(128) NOT NULL,
  `jenis` enum('PKT','UMM') DEFAULT 'UMM',
  `kategori` varchar(16) DEFAULT NULL,
  `harga` varchar(50) NOT NULL,
  `tahun_terbit` int(8) NOT NULL,
  `penulis` varchar(32) NOT NULL,
  `penerbit` varchar(32) DEFAULT NULL,
  `stok` int(11) NOT NULL,
  `rak` varchar(16) DEFAULT NULL,
  `deskripsi` text NOT NULL,
  `jumlah_dipinjam` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`isbn`),
  KEY `FK_Kategori` (`kategori`),
  KEY `FK_Penerbit` (`penerbit`),
  KEY `FK_Rak` (`rak`),
  CONSTRAINT `FK_Kategori` FOREIGN KEY (`kategori`) REFERENCES `ma_kategori` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_Penerbit` FOREIGN KEY (`penerbit`) REFERENCES `ma_penerbit` (`nama`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_Rak` FOREIGN KEY (`rak`) REFERENCES `ma_rak` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_buku`
--

LOCK TABLES `ma_buku` WRITE;
/*!40000 ALTER TABLE `ma_buku` DISABLE KEYS */;
INSERT INTO `ma_buku` VALUES ('3435345345','Cara Bersikap Bodo Amat','UMM','MAT','100000',2000,'Boger','Cahaya Pelita Andika, Pt',54,'TIK','Buku goer',0,'2022-05-11 23:05:27','2022-05-11 23:05:27'),('9786233311557','Hallo Koding','UMM','MAT','150000',2021,'Hilman Ramadhan','PT. Erlangga',26,'MTK','Buku yang membahas masalah dan motivasi seorang programmer',0,'2022-03-23 10:26:14','2022-03-23 10:26:14');
/*!40000 ALTER TABLE `ma_buku` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ADD_COUNT_BUKU` BEFORE INSERT ON `ma_buku` FOR EACH ROW UPDATE ma_dashboard SET total_buku = (SELECT SUM(total_buku) + 1 FROM ma_dashboard) WHERE id = 1 */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `LESS_COUNT_BUKU` BEFORE DELETE ON `ma_buku` FOR EACH ROW UPDATE ma_dashboard SET total_buku = (SELECT SUM(total_buku) - 1 FROM ma_dashboard) WHERE id = 1 */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ma_dashboard`
--

DROP TABLE IF EXISTS `ma_dashboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_dashboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_buku` int(11) NOT NULL DEFAULT 0,
  `buku_dipinjam` int(11) NOT NULL DEFAULT 0,
  `buku_bermasalah` int(11) NOT NULL DEFAULT 0,
  `total_anggota` int(11) DEFAULT NULL,
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_dashboard`
--

LOCK TABLES `ma_dashboard` WRITE;
/*!40000 ALTER TABLE `ma_dashboard` DISABLE KEYS */;
INSERT INTO `ma_dashboard` VALUES (1,2,0,0,3,'2022-05-11 15:41:11');
/*!40000 ALTER TABLE `ma_dashboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_detail_transaksi`
--

DROP TABLE IF EXISTS `ma_detail_transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_detail_transaksi` (
  `id_transaksi` int(11) unsigned NOT NULL,
  `isbn` varchar(28) NOT NULL,
  `judul_buku` varchar(128) NOT NULL,
  `batas_pinjam` int(28) NOT NULL,
  `status_buku` enum('Tepat','Perpanjang','Bermasalah','Terlambat') DEFAULT NULL,
  `kondisi_buku` enum('Baik','Rusak','Hilang') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  KEY `FK_Transaksi` (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_detail_transaksi`
--

LOCK TABLES `ma_detail_transaksi` WRITE;
/*!40000 ALTER TABLE `ma_detail_transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `ma_detail_transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_jurusan`
--

DROP TABLE IF EXISTS `ma_jurusan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_jurusan` (
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_jurusan`
--

LOCK TABLES `ma_jurusan` WRITE;
/*!40000 ALTER TABLE `ma_jurusan` DISABLE KEYS */;
INSERT INTO `ma_jurusan` VALUES ('AK','Akutansi','2022-04-17 15:50:09','2022-05-08 02:26:35'),('MIF','Manajemen Informatika','2022-04-17 15:47:01','2022-04-17 16:09:10'),('RPL','Rekayasa Perangkat Lunak','2022-04-17 16:44:01','2022-04-17 16:44:01'),('TGK','Teknik Geomatika dan Fisika','2022-04-17 16:09:50','2022-04-17 16:44:35'),('TKJ','Teknik Komputer Dan Jaringan','2022-04-17 15:48:21','2022-04-17 16:07:10'),('TKR','Teknik Kendaraan Ringan','2022-05-11 12:16:16','2022-05-11 12:16:16'),('TPL','Teknik Perkapalan','2022-04-17 16:10:32','2022-04-17 16:10:32');
/*!40000 ALTER TABLE `ma_jurusan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_kategori`
--

DROP TABLE IF EXISTS `ma_kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_kategori` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_kategori`
--

LOCK TABLES `ma_kategori` WRITE;
/*!40000 ALTER TABLE `ma_kategori` DISABLE KEYS */;
INSERT INTO `ma_kategori` VALUES ('MAT','Matematika','Buku Kategori Matematika','2022-03-23 10:22:49','2022-05-09 21:46:52');
/*!40000 ALTER TABLE `ma_kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_log`
--

DROP TABLE IF EXISTS `ma_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process` varchar(64) NOT NULL,
  `message` text NOT NULL,
  `pengurus` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_Pengurus` (`pengurus`),
  CONSTRAINT `FK_Pengurus` FOREIGN KEY (`pengurus`) REFERENCES `ma_pengurus` (`kode`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_log`
--

LOCK TABLES `ma_log` WRITE;
/*!40000 ALTER TABLE `ma_log` DISABLE KEYS */;
INSERT INTO `ma_log` VALUES (1,'LOGIN','Berhasil Login','PGS-69696','2022-05-12 00:05:52');
/*!40000 ALTER TABLE `ma_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_penerbit`
--

DROP TABLE IF EXISTS `ma_penerbit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_penerbit` (
  `nama` varchar(32) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`nama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_penerbit`
--

LOCK TABLES `ma_penerbit` WRITE;
/*!40000 ALTER TABLE `ma_penerbit` DISABLE KEYS */;
INSERT INTO `ma_penerbit` VALUES ('Cahaya Pelita Andika, Pt','234324234','2022-05-08 15:51:57','2022-05-08 15:54:55'),('Cakradenta Agung Pertiwi, Pt','55234234','2022-05-08 15:56:02','2022-05-08 15:56:02'),('Cakung Permata Nusa, Pt','43523455','2022-05-08 15:56:36','2022-05-08 15:56:36'),('Calista Alam, Pt','6965523445','2022-05-08 15:56:47','2022-05-08 15:56:47'),('Cibaliung Tunggal Plantation, Pt','55234234','2022-05-08 15:57:00','2022-05-08 15:57:00'),('Cipta Narada Sejati','55243','2022-05-08 15:57:08','2022-05-08 15:57:08'),('Cv Casear Cell','47408934932','2022-05-08 15:32:53','2022-05-08 15:43:04'),('Pt Player Cell','085655990781','2022-05-08 15:35:10','2022-05-08 15:38:31'),('PT. Erlangga','085235119101','2022-03-23 10:17:59','2022-03-23 10:17:59'),('PT. Maju Mundur Cantik','543534534545','2022-05-08 13:24:59','2022-05-08 13:24:59'),('PT. Mencari Cinta Sejati','654657654345','2022-05-08 13:25:35','2022-05-08 13:25:35');
/*!40000 ALTER TABLE `ma_penerbit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_pengurus`
--

DROP TABLE IF EXISTS `ma_pengurus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_pengurus` (
  `kode` varchar(16) NOT NULL,
  `nip` varchar(32) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `hak_akses` enum('ADMINISTRATOR','STAF') DEFAULT 'STAF',
  `status` enum('AKTIF','BLOKIR') DEFAULT 'AKTIF',
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`kode`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_pengurus`
--

LOCK TABLES `ma_pengurus` WRITE;
/*!40000 ALTER TABLE `ma_pengurus` DISABLE KEYS */;
INSERT INTO `ma_pengurus` VALUES ('PGS-69696','5345435','a','a','Aristo Caesar Pratama','ADMINISTRATOR','AKTIF','2022-04-29 21:59:11','2022-04-29 22:06:34');
/*!40000 ALTER TABLE `ma_pengurus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_rak`
--

DROP TABLE IF EXISTS `ma_rak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_rak` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_rak`
--

LOCK TABLES `ma_rak` WRITE;
/*!40000 ALTER TABLE `ma_rak` DISABLE KEYS */;
INSERT INTO `ma_rak` VALUES ('IPS','Ilmu Pengetahuan Sosials','rak buku ilmu pengetahuan sosial','2022-05-08 00:01:33','2022-05-08 02:18:54'),('MTK','Matematika','rak buku matematika','2022-05-07 23:59:30','2022-05-07 23:59:30'),('TIK','Teknik Informatika','rak buku teknik informatika','2022-03-23 10:15:02','2022-03-23 10:15:02');
/*!40000 ALTER TABLE `ma_rak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_setting`
--

DROP TABLE IF EXISTS `ma_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denda_terlambat` int(11) NOT NULL,
  `max_pinjam_buku_umum` int(11) NOT NULL,
  `time_backup_database` int(28) NOT NULL,
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_setting`
--

LOCK TABLES `ma_setting` WRITE;
/*!40000 ALTER TABLE `ma_setting` DISABLE KEYS */;
INSERT INTO `ma_setting` VALUES (1,2000,5,0,'2022-05-08 03:09:54');
/*!40000 ALTER TABLE `ma_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_transaksi`
--

DROP TABLE IF EXISTS `ma_transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ma_transaksi` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_transaksi` varchar(16) NOT NULL,
  `id_anggota` int(11) unsigned NOT NULL,
  `nama_anggota` varchar(64) NOT NULL,
  `kelas` varchar(8) NOT NULL,
  `id_pengelola` int(11) unsigned NOT NULL,
  `jenis_buku` enum('PKT','UMM') DEFAULT NULL,
  `status_transaksi` enum('DIPINJAM','BERMASALAH','SELESAI') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_transaksi`
--

LOCK TABLES `ma_transaksi` WRITE;
/*!40000 ALTER TABLE `ma_transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `ma_transaksi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-14 23:26:18
