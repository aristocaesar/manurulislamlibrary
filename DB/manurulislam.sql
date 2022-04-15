-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2022 at 02:36 PM
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
  `id` int(11) UNSIGNED NOT NULL,
  `id_anggota` varchar(16) NOT NULL,
  `nis` int(11) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `id_kelas` int(11) UNSIGNED NOT NULL,
  `jumlah_buku_dipinjam` int(8) NOT NULL,
  `skor` int(8) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ma_buku`
--

CREATE TABLE `ma_buku` (
  `id` int(11) UNSIGNED NOT NULL,
  `isbn` varchar(28) NOT NULL,
  `judul` varchar(128) NOT NULL,
  `jenis` enum('PKT','UMM') DEFAULT 'UMM',
  `id_kategori` int(11) UNSIGNED NOT NULL,
  `harga` int(11) NOT NULL,
  `lebar_panjang` varchar(16) NOT NULL,
  `jumlah_halaman` int(11) NOT NULL,
  `tahun_terbit` int(8) NOT NULL,
  `penulis` varchar(32) NOT NULL,
  `id_penerbit` int(11) UNSIGNED NOT NULL,
  `stok` int(11) NOT NULL,
  `id_rak` int(11) UNSIGNED NOT NULL,
  `deskripsi` text NOT NULL,
  `jumlah_dipinjam` int(11) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_buku`
--

INSERT INTO `ma_buku` (`id`, `isbn`, `judul`, `jenis`, `id_kategori`, `harga`, `lebar_panjang`, `jumlah_halaman`, `tahun_terbit`, `penulis`, `id_penerbit`, `stok`, `id_rak`, `deskripsi`, `jumlah_dipinjam`, `created_at`, `updated_at`) VALUES
(1, '9786233311557', 'Hallo Koding', 'UMM', 2, 150000, '50,80', 168, 2021, 'Hilman Ramadhan', 1, 26, 1, 'Buku yang membahas masalah dan motivasi seorang programmer', 0, '2022-03-23 10:26:14', '2022-03-23 10:26:14');

-- --------------------------------------------------------

--
-- Table structure for table `ma_dashboard`
--

CREATE TABLE `ma_dashboard` (
  `id` int(11) NOT NULL,
  `total_buku` int(11) NOT NULL DEFAULT '0',
  `buku_dipinjam` int(11) NOT NULL DEFAULT '0',
  `buku_bermasalah` int(11) NOT NULL DEFAULT '0',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ma_detail_transaksi`
--

CREATE TABLE `ma_detail_transaksi` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_transaksi` int(11) UNSIGNED NOT NULL,
  `isbn` varchar(28) NOT NULL,
  `judul_buku` varchar(128) NOT NULL,
  `batas_pinjam` int(28) NOT NULL,
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
  `id` int(11) UNSIGNED NOT NULL,
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_jurusan`
--

INSERT INTO `ma_jurusan` (`id`, `kode`, `nama`, `created_at`, `updated_at`) VALUES
(1, 'IPA', 'Ilmu Pengetahuan Alam', '2022-03-23 10:18:50', '2022-03-23 10:18:50'),
(2, 'IPS', 'Ilmu Pengetahuan Sosial', '2022-03-23 10:18:50', '2022-03-23 10:18:50');

-- --------------------------------------------------------

--
-- Table structure for table `ma_kategori`
--

CREATE TABLE `ma_kategori` (
  `id` int(11) UNSIGNED NOT NULL,
  `kode` varchar(16) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_kategori`
--

INSERT INTO `ma_kategori` (`id`, `kode`, `nama`, `deskripsi`, `created_at`, `updated_at`) VALUES
(1, 'MAT', 'MATEMATIKA', 'Buku Kategori Matematika', '2022-03-23 10:22:49', '2022-03-23 10:22:49'),
(2, 'PRGM', 'PROGRAM', 'Buku yang berkategori membahasa bahasa program', '2022-03-23 10:22:49', '2022-03-23 10:22:49');

-- --------------------------------------------------------

--
-- Table structure for table `ma_kelas`
--

CREATE TABLE `ma_kelas` (
  `id` int(11) UNSIGNED NOT NULL,
  `kelas` varchar(8) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_kelas`
--

INSERT INTO `ma_kelas` (`id`, `kelas`, `created_at`, `updated_at`) VALUES
(1, 'X', '2022-03-23 10:19:54', '2022-03-23 10:19:54'),
(2, 'XI', '2022-03-23 10:19:54', '2022-03-23 10:19:54'),
(3, 'XII', '2022-03-23 10:19:54', '2022-03-23 10:19:54');

-- --------------------------------------------------------

--
-- Table structure for table `ma_log`
--

CREATE TABLE `ma_log` (
  `id` int(11) NOT NULL,
  `process` varchar(64) NOT NULL,
  `message` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ma_log`
--

INSERT INTO `ma_log` (`id`, `process`, `message`, `created_at`) VALUES
(1, 'Login', 'test massej', '2022-04-15 02:16:06'),
(2, 'Login', 'test massej', '2022-04-15 02:16:56'),
(3, '', 'test massej', '2022-04-15 02:18:22');

-- --------------------------------------------------------

--
-- Table structure for table `ma_penerbit`
--

CREATE TABLE `ma_penerbit` (
  `id` int(11) UNSIGNED NOT NULL,
  `kode` varchar(16) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_penerbit`
--

INSERT INTO `ma_penerbit` (`id`, `kode`, `nama`, `kontak`, `created_at`, `updated_at`) VALUES
(1, 'PNT-00001', 'PT. Erlangga', '085235119101', '2022-03-23 10:17:59', '2022-03-23 10:17:59');

-- --------------------------------------------------------

--
-- Table structure for table `ma_pengurus`
--

CREATE TABLE `ma_pengurus` (
  `id` varchar(16) NOT NULL,
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

INSERT INTO `ma_pengurus` (`id`, `nip`, `username`, `password`, `nama_lengkap`, `hak_akses`, `status`, `created_at`, `updated_at`) VALUES
('PGS-10000', '198511282008121002', 'a', 'a', 'Aji Seto Arifianto, S.ST., M.T.', 'ADMINISTRATOR', 'AKTIF', '2022-03-23 10:10:48', '2022-03-23 10:10:48');

-- --------------------------------------------------------

--
-- Table structure for table `ma_rak`
--

CREATE TABLE `ma_rak` (
  `id` int(11) UNSIGNED NOT NULL,
  `kode` varchar(16) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_rak`
--

INSERT INTO `ma_rak` (`id`, `kode`, `deskripsi`, `created_at`, `updated_at`) VALUES
(1, 'RAK-00004', 'Rak ini menampung buku berkategori ilmu sosial', '2022-03-23 10:15:02', '2022-03-23 10:15:02');

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
(1, 200011, 7, 1, '2022-03-23 10:13:34');

-- --------------------------------------------------------

--
-- Table structure for table `ma_transaksi`
--

CREATE TABLE `ma_transaksi` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_transaksi` varchar(16) NOT NULL,
  `id_anggota` int(11) UNSIGNED NOT NULL,
  `nama_anggota` varchar(64) NOT NULL,
  `kelas` varchar(8) NOT NULL,
  `id_pengelola` int(11) UNSIGNED NOT NULL,
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Kelas` (`id_kelas`);

--
-- Indexes for table `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Kategori` (`id_kategori`),
  ADD KEY `FK_Penerbit` (`id_penerbit`);

--
-- Indexes for table `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Transaksi` (`id_transaksi`);

--
-- Indexes for table `ma_jurusan`
--
ALTER TABLE `ma_jurusan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_kelas`
--
ALTER TABLE `ma_kelas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_log`
--
ALTER TABLE `ma_log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_penerbit`
--
ALTER TABLE `ma_penerbit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_pengurus`
--
ALTER TABLE `ma_pengurus`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `ma_rak`
--
ALTER TABLE `ma_rak`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_setting`
--
ALTER TABLE `ma_setting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Anggota` (`id_anggota`),
  ADD KEY `FK_Pengelola` (`id_pengelola`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ma_anggota`
--
ALTER TABLE `ma_anggota`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ma_buku`
--
ALTER TABLE `ma_buku`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ma_jurusan`
--
ALTER TABLE `ma_jurusan`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ma_kelas`
--
ALTER TABLE `ma_kelas`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ma_log`
--
ALTER TABLE `ma_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ma_penerbit`
--
ALTER TABLE `ma_penerbit`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_rak`
--
ALTER TABLE `ma_rak`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_setting`
--
ALTER TABLE `ma_setting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ma_anggota`
--
ALTER TABLE `ma_anggota`
  ADD CONSTRAINT `FK_Kelas` FOREIGN KEY (`id_kelas`) REFERENCES `ma_kelas` (`id`);

--
-- Constraints for table `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD CONSTRAINT `FK_Kategori` FOREIGN KEY (`id_kategori`) REFERENCES `ma_kategori` (`id`),
  ADD CONSTRAINT `FK_Penerbit` FOREIGN KEY (`id_penerbit`) REFERENCES `ma_penerbit` (`id`);

--
-- Constraints for table `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD CONSTRAINT `FK_Transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `ma_transaksi` (`id`);

--
-- Constraints for table `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD CONSTRAINT `FK_Anggota` FOREIGN KEY (`id_anggota`) REFERENCES `ma_anggota` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
