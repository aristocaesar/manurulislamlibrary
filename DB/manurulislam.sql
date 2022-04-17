-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2022 at 11:18 AM
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
  `id` varchar(16) NOT NULL,
  `nis` varchar(28) NOT NULL,
  `nama_lengkap` varchar(128) NOT NULL,
  `jurusan` int(11) UNSIGNED NOT NULL,
  `kelas` int(11) UNSIGNED NOT NULL,
  `jumlah_buku_dipinjam` int(11) NOT NULL,
  `skor` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_jurusan`
--

INSERT INTO `ma_jurusan` (`kode`, `nama`, `created_at`, `updated_at`) VALUES
('AK', 'Akustansi', '2022-04-17 15:50:09', '2022-04-17 16:08:43'),
('APK', 'Administrator Perkantoran', '2022-04-17 15:54:08', '2022-04-17 16:06:54'),
('MIF', 'Manajemen Informatika', '2022-04-17 15:47:01', '2022-04-17 16:09:10'),
('TGK', 'Teknik Geomatika', '2022-04-17 16:09:50', '2022-04-17 16:09:50'),
('TKJ', 'Teknik Komputer Dan Jaringan', '2022-04-17 15:48:21', '2022-04-17 16:07:10'),
('TPL', 'Teknik Perkapalan', '2022-04-17 16:10:32', '2022-04-17 16:10:32'),
('TPU', 'Teknologi Pesawat Udara', '2022-04-17 16:10:08', '2022-04-17 16:10:08'),
('TSM', 'Teknik Sepeda Motor', '2022-03-23 10:18:50', '2022-04-17 16:09:05');

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
  `kode` varchar(8) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_kelas`
--

INSERT INTO `ma_kelas` (`kode`, `created_at`, `updated_at`) VALUES
('X', '2022-03-23 10:19:54', '2022-03-23 10:19:54'),
('XI', '2022-03-23 10:19:54', '2022-03-23 10:19:54'),
('XII', '2022-03-23 10:19:54', '2022-03-23 10:19:54');

-- --------------------------------------------------------

--
-- Table structure for table `ma_log`
--

CREATE TABLE `ma_log` (
  `id` int(11) NOT NULL,
  `process` varchar(64) NOT NULL,
  `message` text NOT NULL,
  `petugas` varchar(128) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ma_log`
--

INSERT INTO `ma_log` (`id`, `process`, `message`, `petugas`, `created_at`) VALUES
(1, 'Login', 'test massej', '', '2022-04-15 02:16:06'),
(2, 'Login', 'test massej', '', '2022-04-15 02:16:56'),
(3, '', 'test massej', '', '2022-04-15 02:18:22'),
(4, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-15 21:27:15'),
(5, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-15 21:36:18'),
(6, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-15 21:37:24'),
(7, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-15 21:37:31'),
(8, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-15 23:16:35'),
(9, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 01:44:36'),
(10, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 01:45:06'),
(11, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 01:49:24'),
(12, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 01:49:47'),
(13, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 01:58:08'),
(14, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:02:54'),
(15, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:03:44'),
(16, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:08:16'),
(17, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:12:02'),
(18, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:13:20'),
(19, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:14:43'),
(20, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:14:58'),
(21, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:15:02'),
(22, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:15:06'),
(23, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:15:09'),
(24, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:19:34'),
(25, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 02:23:42'),
(26, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 11:53:34'),
(27, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 12:04:09'),
(28, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 12:05:16'),
(29, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 12:41:55'),
(30, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 12:51:32'),
(31, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:04:37'),
(32, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:10:59'),
(33, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:13:57'),
(34, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:18:20'),
(35, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:24:40'),
(36, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:26:35'),
(37, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:28:18'),
(38, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:46:40'),
(39, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:48:25'),
(40, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:50:41'),
(41, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:52:41'),
(42, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:55:04'),
(43, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 13:57:16'),
(44, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:00:28'),
(45, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:08:54'),
(46, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:10:54'),
(47, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:11:36'),
(48, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:12:09'),
(49, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:29:56'),
(50, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:31:11'),
(51, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:31:45'),
(52, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:32:50'),
(53, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:34:43'),
(54, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 14:35:37'),
(55, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:43:06'),
(56, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:43:56'),
(57, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:44:38'),
(58, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:45:07'),
(59, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:55:20'),
(60, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 15:58:16'),
(61, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:01:02'),
(62, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:04:11'),
(63, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:05:05'),
(64, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:07:11'),
(65, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:16:20'),
(66, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:28:28'),
(67, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:30:20'),
(68, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:34:52'),
(69, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:36:06'),
(70, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:40:06'),
(71, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:42:22'),
(72, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 16:45:22'),
(73, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 17:24:43'),
(74, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 17:25:45'),
(75, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-16 17:41:29'),
(76, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 01:36:31'),
(77, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 01:49:09'),
(78, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:05:00'),
(79, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:06:03'),
(80, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:06:46'),
(81, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:10:16'),
(82, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:11:26'),
(83, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:11:52'),
(84, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:12:40'),
(85, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:14:27'),
(86, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:15:08'),
(87, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:28:01'),
(88, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:28:40'),
(89, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:30:32'),
(90, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:30:59'),
(91, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:32:32'),
(92, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:41:16'),
(93, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:41:48'),
(94, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:42:37'),
(95, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:55:54'),
(96, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 02:56:29'),
(97, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 14:54:05'),
(98, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:09:42'),
(99, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:11:13'),
(100, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:15:09'),
(101, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:16:24'),
(102, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:16:49'),
(103, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:22:03'),
(104, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:27:20'),
(105, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:29:42'),
(106, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:36:43'),
(107, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:38:47'),
(108, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:46:42'),
(109, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:48:14'),
(110, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:50:24'),
(111, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:53:56'),
(112, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 15:59:14'),
(113, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:01:45'),
(114, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:02:58'),
(115, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:04:25'),
(116, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:05:51'),
(117, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:08:25'),
(118, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:11:35'),
(119, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:13:49'),
(120, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:16:15');

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
('PGS-63486', '198511282008121002', 'a', 'a', 'Aji Seto Arifianto, S.ST., M.T.', 'ADMINISTRATOR', 'AKTIF', '2022-03-23 10:10:48', '2022-03-23 10:10:48');

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
(1, 2000, 3, 0, '2022-04-16 02:15:08');

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
  ADD KEY `FK_Kelas` (`kelas`),
  ADD KEY `FK_Jurusan` (`jurusan`);

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
  ADD UNIQUE KEY `KODE_uniq` (`kode`),
  ADD UNIQUE KEY `NAMA_uniq` (`nama`);

--
-- Indexes for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

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
-- AUTO_INCREMENT for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ma_log`
--
ALTER TABLE `ma_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
