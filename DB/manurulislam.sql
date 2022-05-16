-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2022 at 06:57 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manurulislam`
--

-- --------------------------------------------------------

--
-- Table structure for table `ma_anggota`
--

CREATE TABLE `ma_anggota` (
  `nis` varchar(28) CHARACTER SET utf8mb4 NOT NULL,
  `nama_lengkap` varchar(128) CHARACTER SET utf8mb4 DEFAULT '',
  `jurusan` varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jumlah_buku_dipinjam` int(11) NOT NULL DEFAULT '0',
  `skor` int(100) DEFAULT '100',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ma_anggota`
--

INSERT INTO `ma_anggota` (`nis`, `nama_lengkap`, `jurusan`, `jumlah_buku_dipinjam`, `skor`, `created_at`, `updated_at`) VALUES
('E41211739', 'Fifa Fajr Firdaus', 'TKJ', 0, 100, '2022-05-11 16:20:11', '2022-05-15 19:41:44'),
('E41211741', 'Aristo Caesar Pratama', 'TKJ', 0, 100, '2022-05-11 23:01:06', '2022-05-15 19:41:28'),
('E41211742', 'Hana Wulan Agustaa', 'TKJ', 0, 96, '2022-05-11 16:18:58', '2022-05-15 19:40:50');

--
-- Triggers `ma_anggota`
--
DELIMITER $$
CREATE TRIGGER `ADD_COUNT_ANGGOTA` AFTER INSERT ON `ma_anggota` FOR EACH ROW BEGIN

UPDATE ma_dashboard SET total_anggota = total_anggota + 1 WHERE id = 1;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `LESS_COUNT_ANGGOTA` AFTER DELETE ON `ma_anggota` FOR EACH ROW BEGIN

UPDATE ma_dashboard SET total_anggota = total_anggota - 1 WHERE id = 1;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ma_buku`
--

CREATE TABLE `ma_buku` (
  `isbn` varchar(28) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `jenis` enum('PAKET','UMUM') DEFAULT NULL,
  `kategori` varchar(16) DEFAULT NULL,
  `harga` varchar(50) NOT NULL,
  `tahun_terbit` varchar(8) NOT NULL,
  `penulis` varchar(32) NOT NULL,
  `penerbit` varchar(32) DEFAULT NULL,
  `stok` int(11) UNSIGNED ZEROFILL NOT NULL,
  `rak` varchar(16) DEFAULT NULL,
  `deskripsi` text,
  `max_hari_pinjam` int(11) NOT NULL,
  `jumlah_dipinjam` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_buku`
--

INSERT INTO `ma_buku` (`isbn`, `judul`, `jenis`, `kategori`, `harga`, `tahun_terbit`, `penulis`, `penerbit`, `stok`, `rak`, `deskripsi`, `max_hari_pinjam`, `jumlah_dipinjam`, `created_at`, `updated_at`) VALUES
('5343', 'Asas Asasas', 'UMUM', 'TIK', '100000.0', '2022', 'Dsdsd', 'Cahaya Pelita Andika, Pt', 00000000003, 'MTK', 'tydty', 1, NULL, '2022-05-16 23:46:25', '2022-05-16 23:46:25'),
('5454', 'Gffgf', 'UMUM', 'MAT', '50000.0', '2022', 'Fdfdfd', 'Cahaya Pelita Andika, Pt', 00000000005, 'MTK', 'kuntul', 1, NULL, '2022-05-16 23:43:37', '2022-05-16 23:43:37'),
('9786020528540', 'Sebuah Seni Untuk Bersikap Bodo Amat (edisi Handy)', 'UMUM', 'MAT', '78000.0', '2022', 'Mark Manson', 'Calista Alam, Pt', 00000000000, 'IPS', 'Mark Manson adalah satu dari sedikit pengarang yang bukunya setia menemani para pembaca di Indonesia dan seluruh dunia. Telah terjual lebih dari 400.000 eksemplar di Indonesia, Anda pasti tidak asing dengan Sebuah Seni untuk Bersikap Bodo Amat dan Segala-galanya Ambyar. ', 3, NULL, '2022-05-16 23:55:04', '2022-05-16 23:55:04'),
('9786023136322', 'Paket Paten Kisi-kisi Resmi Terkini Cpns Pppk 2022-2023', 'PAKET', 'MAT', '0.0', '2022', 'Siti Khalimatussa`diyah, S.pd', 'Cahaya Pelita Andika, Pt', 00000000005, 'IPS', 'Rangkuman materi soal, dan pembahasan Tes Wawasan Kebangsaan. yang terdlrl darl subtes  ...', 2, NULL, '2022-05-16 23:56:37', '2022-05-16 23:56:37'),
('9786233311557', 'Hallo Koding', 'UMUM', 'MAT', '150000', '2021', 'Hilman Ramadhan', 'PT. Erlangga', 00000000026, 'MTK', 'Buku yang membahas masalah dan motivasi seorang programmer', 0, 0, '2022-03-23 10:26:14', '2022-03-23 10:26:14');

--
-- Triggers `ma_buku`
--
DELIMITER $$
CREATE TRIGGER `ADD_COUNT_BUKU` AFTER INSERT ON `ma_buku` FOR EACH ROW BEGIN

UPDATE ma_dashboard SET total_buku = total_buku + 1 WHERE id = 1;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `LESS_COUNT_BUKU` AFTER DELETE ON `ma_buku` FOR EACH ROW BEGIN

UPDATE ma_dashboard SET total_buku = total_buku - 1 WHERE id = 1;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ma_dashboard`
--

CREATE TABLE `ma_dashboard` (
  `id` int(11) NOT NULL,
  `total_buku` int(11) NOT NULL DEFAULT '0',
  `buku_dipinjam` int(11) NOT NULL DEFAULT '0',
  `buku_bermasalah` int(11) NOT NULL DEFAULT '0',
  `total_anggota` int(11) DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_dashboard`
--

INSERT INTO `ma_dashboard` (`id`, `total_buku`, `buku_dipinjam`, `buku_bermasalah`, `total_anggota`, `updated_at`) VALUES
(1, 5, 0, 0, 3, '2022-05-11 15:41:11');

-- --------------------------------------------------------

--
-- Table structure for table `ma_detail_transaksi`
--

CREATE TABLE `ma_detail_transaksi` (
  `id_transaksi` varchar(16) DEFAULT NULL,
  `isbn` varchar(28) NOT NULL,
  `status_buku` enum('Tepat','Perpanjang','Bermasalah','Terlambat') DEFAULT NULL,
  `kondisi_buku` enum('Baik','Rusak','Hilang') DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ma_jurusan`
--

CREATE TABLE `ma_jurusan` (
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_jurusan`
--

INSERT INTO `ma_jurusan` (`kode`, `nama`, `created_at`, `updated_at`) VALUES
('AK', 'Akutansi', '2022-04-17 15:50:09', '2022-05-08 02:26:35'),
('MIF', 'Manajemen Informatika', '2022-04-17 15:47:01', '2022-04-17 16:09:10'),
('RPL', 'Rekayasa Perangkat Lunak', '2022-04-17 16:44:01', '2022-04-17 16:44:01'),
('TGK', 'Teknik Geomatika dan Fisika', '2022-04-17 16:09:50', '2022-04-17 16:44:35'),
('TKJ', 'Teknik Komputer Dan Jaringan', '2022-04-17 15:48:21', '2022-04-17 16:07:10'),
('TKR', 'Teknik Kendaraan Ringan', '2022-05-11 12:16:16', '2022-05-11 12:16:16'),
('TPL', 'Teknik Perkapalan', '2022-04-17 16:10:32', '2022-04-17 16:10:32');

-- --------------------------------------------------------

--
-- Table structure for table `ma_kategori`
--

CREATE TABLE `ma_kategori` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_kategori`
--

INSERT INTO `ma_kategori` (`kode`, `nama`, `deskripsi`, `created_at`, `updated_at`) VALUES
('MAT', 'Matematika', 'Buku Kategori Matematika', '2022-03-23 10:22:49', '2022-05-09 21:46:52'),
('TIK', 'Teknik Informatika', 'asdasdasd', '2022-05-16 22:31:45', '2022-05-16 22:31:45');

-- --------------------------------------------------------

--
-- Table structure for table `ma_log`
--

CREATE TABLE `ma_log` (
  `id` int(11) NOT NULL,
  `process` varchar(64) NOT NULL,
  `message` text NOT NULL,
  `pengurus` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ma_log`
--

INSERT INTO `ma_log` (`id`, `process`, `message`, `pengurus`, `created_at`) VALUES
(1, 'LOGIN', 'Berhasil Login', 'PGS-69696', '2022-05-12 00:05:52');

-- --------------------------------------------------------

--
-- Table structure for table `ma_penerbit`
--

CREATE TABLE `ma_penerbit` (
  `nama` varchar(32) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_penerbit`
--

INSERT INTO `ma_penerbit` (`nama`, `kontak`, `created_at`, `updated_at`) VALUES
('Cahaya Pelita Andika, Pt', '234324234', '2022-05-08 15:51:57', '2022-05-08 15:54:55'),
('Cakradenta Agung Pertiwi, Pt', '55234234', '2022-05-08 15:56:02', '2022-05-08 15:56:02'),
('Cakung Permata Nusa, Pt', '43523455', '2022-05-08 15:56:36', '2022-05-08 15:56:36'),
('Calista Alam, Pt', '6965523445', '2022-05-08 15:56:47', '2022-05-08 15:56:47'),
('Cibaliung Tunggal Plantation, Pt', '55234234', '2022-05-08 15:57:00', '2022-05-08 15:57:00'),
('Cipta Narada Sejati', '55243', '2022-05-08 15:57:08', '2022-05-08 15:57:08'),
('Cv Casear Cell', '47408934932', '2022-05-08 15:32:53', '2022-05-08 15:43:04'),
('Pt Player Cell', '085655990781', '2022-05-08 15:35:10', '2022-05-08 15:38:31'),
('PT. Erlangga', '085235119101', '2022-03-23 10:17:59', '2022-03-23 10:17:59'),
('PT. Maju Mundur Cantik', '543534534545', '2022-05-08 13:24:59', '2022-05-08 13:24:59'),
('Pt. Mencari Cinta Sejatii', '654657654345', '2022-05-08 13:25:35', '2022-05-16 14:17:56');

-- --------------------------------------------------------

--
-- Table structure for table `ma_pengurus`
--

CREATE TABLE `ma_pengurus` (
  `kode` varchar(16) NOT NULL,
  `nip` varchar(32) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `hak_akses` enum('ADMINISTRATOR','STAF') DEFAULT 'STAF',
  `status` enum('AKTIF','BLOKIR') DEFAULT 'AKTIF',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_pengurus`
--

INSERT INTO `ma_pengurus` (`kode`, `nip`, `username`, `password`, `nama_lengkap`, `hak_akses`, `status`, `created_at`, `updated_at`) VALUES
('PGS - 23125', '2342343434', 'av', 'as', 'Hana Wulan Agusta', 'STAF', 'AKTIF', '2022-05-16 13:46:53', '2022-05-16 13:47:43'),
('PGS-69696', '5345435', 'a', 'a', 'Aristo Caesar Pratama', 'ADMINISTRATOR', 'AKTIF', '2022-04-29 21:59:11', '2022-05-15 02:42:27');

-- --------------------------------------------------------

--
-- Table structure for table `ma_rak`
--

CREATE TABLE `ma_rak` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_rak`
--

INSERT INTO `ma_rak` (`kode`, `nama`, `deskripsi`, `created_at`, `updated_at`) VALUES
('IPS', 'Ilmu Pengetahuan Sosials', 'rak buku ilmu pengetahuan sosial', '2022-05-08 00:01:33', '2022-05-08 02:18:54'),
('MTK', 'Matematika', 'rak buku matematika', '2022-05-07 23:59:30', '2022-05-07 23:59:30'),
('TIK', 'Teknik Informatika', 'rak buku teknik informatika', '2022-03-23 10:15:02', '2022-03-23 10:15:02');

-- --------------------------------------------------------

--
-- Table structure for table `ma_setting`
--

CREATE TABLE `ma_setting` (
  `id` int(11) NOT NULL,
  `denda_terlambat` int(11) NOT NULL,
  `max_pinjam_buku_umum` int(11) NOT NULL,
  `time_backup_database` int(28) NOT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_setting`
--

INSERT INTO `ma_setting` (`id`, `denda_terlambat`, `max_pinjam_buku_umum`, `time_backup_database`, `updated_at`) VALUES
(1, 2000, 5, 0, '2022-05-08 03:09:54');

-- --------------------------------------------------------

--
-- Table structure for table `ma_transaksi`
--

CREATE TABLE `ma_transaksi` (
  `id_transaksi` varchar(16) NOT NULL,
  `nis_anggota` varchar(28) NOT NULL,
  `kode_pengurus` varchar(16) NOT NULL,
  `jenis_buku` enum('PKT','UMM') DEFAULT NULL,
  `status_transaksi` enum('DIPINJAM','BERMASALAH','SELESAI') DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ma_anggota`
--
ALTER TABLE `ma_anggota`
  ADD PRIMARY KEY (`nis`),
  ADD KEY `FK Jurusan` (`jurusan`);

--
-- Indexes for table `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `FK_Kategori` (`kategori`),
  ADD KEY `FK_Penerbit` (`penerbit`),
  ADD KEY `FK_Rak` (`rak`);

--
-- Indexes for table `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD KEY `FK_ma_detail_transaksi_ma_transaksi` (`id_transaksi`),
  ADD KEY `FK_ma_detail_transaksi_ma_buku` (`isbn`);

--
-- Indexes for table `ma_jurusan`
--
ALTER TABLE `ma_jurusan`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `ma_log`
--
ALTER TABLE `ma_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Pengurus` (`pengurus`);

--
-- Indexes for table `ma_penerbit`
--
ALTER TABLE `ma_penerbit`
  ADD PRIMARY KEY (`nama`);

--
-- Indexes for table `ma_pengurus`
--
ALTER TABLE `ma_pengurus`
  ADD PRIMARY KEY (`kode`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `nip` (`nip`);

--
-- Indexes for table `ma_rak`
--
ALTER TABLE `ma_rak`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `ma_setting`
--
ALTER TABLE `ma_setting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD UNIQUE KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `FK_ma_transaksi_ma_anggota` (`nis_anggota`),
  ADD KEY `FK_ma_transaksi_ma_pengurus` (`kode_pengurus`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_log`
--
ALTER TABLE `ma_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_setting`
--
ALTER TABLE `ma_setting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ma_anggota`
--
ALTER TABLE `ma_anggota`
  ADD CONSTRAINT `FK Jurusan` FOREIGN KEY (`jurusan`) REFERENCES `ma_jurusan` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD CONSTRAINT `FK_Kategori` FOREIGN KEY (`kategori`) REFERENCES `ma_kategori` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Penerbit` FOREIGN KEY (`penerbit`) REFERENCES `ma_penerbit` (`nama`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Rak` FOREIGN KEY (`rak`) REFERENCES `ma_rak` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD CONSTRAINT `FK_ma_detail_transaksi_ma_buku` FOREIGN KEY (`isbn`) REFERENCES `ma_buku` (`isbn`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ma_detail_transaksi_ma_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `ma_transaksi` (`id_transaksi`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `ma_log`
--
ALTER TABLE `ma_log`
  ADD CONSTRAINT `FK_Pengurus` FOREIGN KEY (`pengurus`) REFERENCES `ma_pengurus` (`kode`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD CONSTRAINT `FK_ma_transaksi_ma_anggota` FOREIGN KEY (`nis_anggota`) REFERENCES `ma_anggota` (`nis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ma_transaksi_ma_pengurus` FOREIGN KEY (`kode_pengurus`) REFERENCES `ma_pengurus` (`kode`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
