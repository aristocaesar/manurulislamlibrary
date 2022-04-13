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
-- Table structure for table `MA_Anggota`
--

DROP TABLE IF EXISTS `MA_Anggota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Anggota` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_anggota` varchar(16) NOT NULL,
  `nis` int(11) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `id_kelas` int(11) unsigned NOT NULL,
  `jumlah_buku_dipinjam` int(8) NOT NULL,
  `skor` int(8) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_Kelas` (`id_kelas`),
  CONSTRAINT `FK_Kelas` FOREIGN KEY (`id_kelas`) REFERENCES `MA_Kelas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Anggota`
--

LOCK TABLES `MA_Anggota` WRITE;
/*!40000 ALTER TABLE `MA_Anggota` DISABLE KEYS */;
/*!40000 ALTER TABLE `MA_Anggota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Buku`
--

DROP TABLE IF EXISTS `MA_Buku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Buku` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(28) NOT NULL,
  `judul` varchar(128) NOT NULL,
  `jenis` enum('PKT','UMM') DEFAULT 'UMM',
  `id_kategori` int(11) unsigned NOT NULL,
  `harga` int(11) NOT NULL,
  `lebar_panjang` varchar(16) NOT NULL,
  `jumlah_halaman` int(11) NOT NULL,
  `tahun_terbit` int(8) NOT NULL,
  `penulis` varchar(32) NOT NULL,
  `id_penerbit` int(11) unsigned NOT NULL,
  `stok` int(11) NOT NULL,
  `id_rak` int(11) unsigned NOT NULL,
  `deskripsi` text NOT NULL,
  `jumlah_dipinjam` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Kategori` FOREIGN KEY (`id_kategori`) REFERENCES `MA_Kategori` (`id`),
  CONSTRAINT `FK_Penerbit` FOREIGN KEY (`id_penerbit`) REFERENCES `MA_Penerbit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Buku`
--

LOCK TABLES `MA_Buku` WRITE;
/*!40000 ALTER TABLE `MA_Buku` DISABLE KEYS */;
INSERT INTO `MA_Buku` VALUES (1,'9786233311557','Hallo Koding','UMM',2,150000,'50,80',168,2021,'Hilman Ramadhan',1,26,1,'Buku yang membahas masalah dan motivasi seorang programmer',0,'2022-03-23 10:26:14','2022-03-23 10:26:14');
/*!40000 ALTER TABLE `MA_Buku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Dashboard`
--

DROP TABLE IF EXISTS `MA_Dashboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Dashboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_buku` int(11) NOT NULL DEFAULT 0,
  `buku_dipinjam` int(11) NOT NULL DEFAULT 0,
  `buku_bermasalah` int(11) NOT NULL DEFAULT 0,
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Dashboard`
--

LOCK TABLES `MA_Dashboard` WRITE;
/*!40000 ALTER TABLE `MA_Dashboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `MA_Dashboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Detail_Transaksi`
--

DROP TABLE IF EXISTS `MA_Detail_Transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Detail_Transaksi` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_transaksi` int(11) unsigned NOT NULL,
  `isbn` varchar(28) NOT NULL,
  `judul_buku` varchar(128) NOT NULL,
  `batas_pinjam` int(28) NOT NULL,
  `status_buku` enum('Tepat','Perpanjang','Bermasalah','Terlambat') DEFAULT NULL,
  `kondisi_buku` enum('Baik','Rusak','Hilang') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_Transaksi` (`id_transaksi`),
  CONSTRAINT `FK_Transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `MA_Transaksi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Detail_Transaksi`
--

LOCK TABLES `MA_Detail_Transaksi` WRITE;
/*!40000 ALTER TABLE `MA_Detail_Transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `MA_Detail_Transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Jurusan`
--

DROP TABLE IF EXISTS `MA_Jurusan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Jurusan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Jurusan`
--

LOCK TABLES `MA_Jurusan` WRITE;
/*!40000 ALTER TABLE `MA_Jurusan` DISABLE KEYS */;
INSERT INTO `MA_Jurusan` VALUES (1,'IPA','Ilmu Pengetahuan Alam','2022-03-23 10:18:50','2022-03-23 10:18:50'),(2,'IPS','Ilmu Pengetahuan Sosial','2022-03-23 10:18:50','2022-03-23 10:18:50');
/*!40000 ALTER TABLE `MA_Jurusan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Kategori`
--

DROP TABLE IF EXISTS `MA_Kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Kategori` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kode` varchar(16) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Kategori`
--

LOCK TABLES `MA_Kategori` WRITE;
/*!40000 ALTER TABLE `MA_Kategori` DISABLE KEYS */;
INSERT INTO `MA_Kategori` VALUES (1,'MAT','MATEMATIKA','Buku Kategori Matematika','2022-03-23 10:22:49','2022-03-23 10:22:49'),(2,'PRGM','PROGRAM','Buku yang berkategori membahasa bahasa program','2022-03-23 10:22:49','2022-03-23 10:22:49');
/*!40000 ALTER TABLE `MA_Kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Kelas`
--

DROP TABLE IF EXISTS `MA_Kelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Kelas` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kelas` varchar(8) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Kelas`
--

LOCK TABLES `MA_Kelas` WRITE;
/*!40000 ALTER TABLE `MA_Kelas` DISABLE KEYS */;
INSERT INTO `MA_Kelas` VALUES (1,'X','2022-03-23 10:19:54','2022-03-23 10:19:54'),(2,'XI','2022-03-23 10:19:54','2022-03-23 10:19:54'),(3,'XII','2022-03-23 10:19:54','2022-03-23 10:19:54');
/*!40000 ALTER TABLE `MA_Kelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Penerbit`
--

DROP TABLE IF EXISTS `MA_Penerbit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Penerbit` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kode` varchar(16) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Penerbit`
--

LOCK TABLES `MA_Penerbit` WRITE;
/*!40000 ALTER TABLE `MA_Penerbit` DISABLE KEYS */;
INSERT INTO `MA_Penerbit` VALUES (1,'PNT-00001','PT. Erlangga','085235119101','2022-03-23 10:17:59','2022-03-23 10:17:59');
/*!40000 ALTER TABLE `MA_Penerbit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Pengurus`
--

DROP TABLE IF EXISTS `MA_Pengurus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Pengurus` (
  `id` varchar(16) NOT NULL,
  `nip` varchar(32) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `hak_akses` enum('ADMINISTRATOR','STAF') DEFAULT 'STAF',
  `status` enum('AKTIF','BLOKIR') DEFAULT 'AKTIF',
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Pengurus`
--

LOCK TABLES `MA_Pengurus` WRITE;
/*!40000 ALTER TABLE `MA_Pengurus` DISABLE KEYS */;
INSERT INTO `MA_Pengurus` VALUES ('PGS-10000','198511282008121002','ajiseto','ajiseto12345','Aji Seto Arifianto, S.ST., M.T.','ADMINISTRATOR','AKTIF','2022-03-23 10:10:48','2022-03-23 10:10:48');
/*!40000 ALTER TABLE `MA_Pengurus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Rak`
--

DROP TABLE IF EXISTS `MA_Rak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Rak` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kode` varchar(16) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Rak`
--

LOCK TABLES `MA_Rak` WRITE;
/*!40000 ALTER TABLE `MA_Rak` DISABLE KEYS */;
INSERT INTO `MA_Rak` VALUES (1,'RAK-00004','Rak ini menampung buku berkategori ilmu sosial','2022-03-23 10:15:02','2022-03-23 10:15:02');
/*!40000 ALTER TABLE `MA_Rak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Setting`
--

DROP TABLE IF EXISTS `MA_Setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denda_terlambat` int(11) NOT NULL,
  `max_pinjam_buku_umum` int(11) NOT NULL,
  `time_backup_database` int(28) NOT NULL,
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Setting`
--

LOCK TABLES `MA_Setting` WRITE;
/*!40000 ALTER TABLE `MA_Setting` DISABLE KEYS */;
INSERT INTO `MA_Setting` VALUES (1,200,3,1,'2022-03-23 10:13:34');
/*!40000 ALTER TABLE `MA_Setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MA_Transaksi`
--

DROP TABLE IF EXISTS `MA_Transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MA_Transaksi` (
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
  PRIMARY KEY (`id`),
  KEY `FK_Anggota` (`id_anggota`),
  KEY `FK_Pengelola` (`id_pengelola`),
  CONSTRAINT `FK_Anggota` FOREIGN KEY (`id_anggota`) REFERENCES `MA_Anggota` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MA_Transaksi`
--

LOCK TABLES `MA_Transaksi` WRITE;
/*!40000 ALTER TABLE `MA_Transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `MA_Transaksi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-12  9:01:13
