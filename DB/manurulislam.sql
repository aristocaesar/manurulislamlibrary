-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2022 at 12:43 PM
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
  `id` int(11) NOT NULL,
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_jurusan`
--

INSERT INTO `ma_jurusan` (`id`, `kode`, `nama`, `created_at`, `updated_at`) VALUES
(1, 'AK', 'Akustansi', '2022-04-17 15:50:09', '2022-04-17 16:08:43'),
(2, 'APK', 'Administrator Perkantoran', '2022-04-17 15:54:08', '2022-04-17 16:06:54'),
(3, 'MIF', 'Manajemen Informatika', '2022-04-17 15:47:01', '2022-04-17 16:09:10'),
(4, 'RPL', 'Rekayasa Perangkat Lunak', '2022-04-17 16:44:01', '2022-04-17 16:44:01'),
(5, 'TGK', 'Teknik Geomatika dan Fisika', '2022-04-17 16:09:50', '2022-04-17 16:44:35'),
(6, 'TKJ', 'Teknik Komputer Dan Jaringan', '2022-04-17 15:48:21', '2022-04-17 16:07:10'),
(7, 'TPL', 'Teknik Perkapalan', '2022-04-17 16:10:32', '2022-04-17 16:10:32'),
(8, 'TPU', 'Teknologi Pesawat Udara', '2022-04-17 16:10:08', '2022-04-17 16:10:08'),
(9, 'TSM', 'Teknik Sepeda Motor', '2022-03-23 10:18:50', '2022-04-17 16:09:05');

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
  `id` int(11) NOT NULL,
  `kode` varchar(8) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ma_kelas`
--

INSERT INTO `ma_kelas` (`id`, `kode`, `created_at`, `updated_at`) VALUES
(20, 'X', '2022-04-24 01:30:17', '2022-04-24 16:49:30'),
(21, 'XXI', '2022-04-24 01:30:22', '2022-04-24 01:59:02'),
(33, 'XII', '2022-04-24 01:58:33', '2022-04-24 01:58:51'),
(34, 'V', '2022-04-24 02:08:10', '2022-04-24 02:08:17');

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
(1, 'Login', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:40:48'),
(2, 'LOGIN', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:40:48'),
(3, 'LOGIN', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:42:19'),
(4, 'LOGIN', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:42:42'),
(5, 'TAMBAH JURUSAN', 'Menambahkan jurusan Rekayasa Perangkat Lunak', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:44:03'),
(6, 'UPDATE JURUSAN', 'Memperbarui jurusan Teknik Geomatika dan Fisika', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 16:44:36'),
(7, 'LOGIN', 'Akses login berhasil', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 17:07:24'),
(8, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 17:07:29'),
(9, 'Update Pengaturan', 'Memperbarui data pengaturan', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-17 17:07:36'),
(10, 'HAPUS KELAS', 'Mengahapus kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:01:48'),
(11, 'HAPUS KELAS', 'Mengahapus kelas XI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:01:51'),
(12, 'HAPUS KELAS', 'Mengahapus kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:04:16'),
(13, 'HAPUS KELAS', 'Mengahapus kelas XI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:07:41'),
(14, 'TAMBAH KELAS', 'Menambahkan kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:07:57'),
(15, 'HAPUS KELAS', 'Mengahapus kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:17:29'),
(16, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:17:48'),
(17, 'UPDATE KELAS', 'Memperbarui kelas Xd', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:20:09'),
(18, 'UPDATE KELAS', 'Memperbarui kelas Xd', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:21:38'),
(19, 'UPDATE KELAS', 'Memperbarui kelas dsdsadas', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:24:36'),
(20, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 15:25:16'),
(21, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 16:05:31'),
(22, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:43:39'),
(23, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:43:41'),
(24, 'TAMBAH KELAS', 'Menambahkan kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:43:59'),
(25, 'HAPUS KELAS', 'Mengahapus kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:45:46'),
(26, 'HAPUS KELAS', 'Mengahapus kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:45:50'),
(27, 'TAMBAH KELAS', 'Menambahkan kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:45:57'),
(28, 'TAMBAH KELAS', 'Menambahkan kelas IX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:46:07'),
(29, 'TAMBAH KELAS', 'Menambahkan kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-23 21:46:11'),
(30, 'TAMBAH KELAS', 'Menambahkan kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:12:22'),
(31, 'TAMBAH KELAS', 'Menambahkan kelas asa', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:12:28'),
(32, 'TAMBAH KELAS', 'Menambahkan kelas ASu', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:12:48'),
(33, 'TAMBAH KELAS', 'Menambahkan kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:13:00'),
(34, 'TAMBAH KELAS', 'Menambahkan kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:13:04'),
(35, 'UPDATE KELAS', 'Memperbarui kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:15:30'),
(36, 'UPDATE KELAS', 'Memperbarui kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:15:33'),
(37, 'HAPUS KELAS', 'Mengahapus kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:18:08'),
(38, 'HAPUS KELAS', 'Mengahapus kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:18:10'),
(39, 'HAPUS KELAS', 'Mengahapus kelas ASU', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:18:12'),
(40, 'HAPUS KELAS', 'Mengahapus kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:20:55'),
(41, 'HAPUS KELAS', 'Mengahapus kelas ASA', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:21:57'),
(42, 'HAPUS KELAS', 'Mengahapus kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:22:00'),
(43, 'HAPUS KELAS', 'Mengahapus kelas IX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:22:03'),
(44, 'TAMBAH KELAS', 'Menambahkan kelas xi', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:22:08'),
(45, 'UPDATE KELAS', 'Memperbarui kelas XI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:22:38'),
(46, 'HAPUS KELAS', 'Mengahapus kelas XI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:25:20'),
(47, 'HAPUS KELAS', 'Mengahapus kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:28:40'),
(48, 'TAMBAH KELAS', 'Menambahkan kelas x', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:29:05'),
(49, 'HAPUS KELAS', 'Mengahapus kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:29:16'),
(50, 'TAMBAH KELAS', 'Menambahkan kelas x', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:30:12'),
(51, 'TAMBAH KELAS', 'Menambahkan kelas xi', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:30:17'),
(52, 'TAMBAH KELAS', 'Menambahkan kelas XXI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:30:22'),
(53, 'UPDATE KELAS', 'Memperbarui kelas XX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:32:48'),
(54, 'UPDATE KELAS', 'Memperbarui kelas Xdsadasd', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:39:08'),
(55, 'UPDATE KELAS', 'Memperbarui kelas XC', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:40:28'),
(56, 'UPDATE KELAS', 'Memperbarui kelas XCC', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:40:35'),
(57, 'TAMBAH KELAS', 'Menambahkan kelas XC', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:40:45'),
(58, 'TAMBAH KELAS', 'Menambahkan kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:40:57'),
(59, 'TAMBAH KELAS', 'Menambahkan kelas XXX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:41:40'),
(60, 'HAPUS KELAS', 'Mengahapus kelas XXX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:43:53'),
(61, 'HAPUS KELAS', 'Mengahapus kelas XCC', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:43:59'),
(62, 'TAMBAH KELAS', 'Menambahkan kelas XCX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:52:55'),
(63, 'TAMBAH KELAS', 'Menambahkan kelas XCXC', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:53:04'),
(64, 'UPDATE KELAS', 'Memperbarui kelas Xa', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:56:04'),
(65, 'TAMBAH KELAS', 'Menambahkan kelas XXsddsad', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:56:46'),
(66, 'UPDATE KELAS', 'Memperbarui kelas X', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:57:20'),
(67, 'HAPUS KELAS', 'Mengahapus kelas ', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:14'),
(68, 'HAPUS KELAS', 'Mengahapus kelas ', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:16'),
(69, 'HAPUS KELAS', 'Mengahapus kelas ', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:19'),
(70, 'HAPUS KELAS', 'Mengahapus kelas ', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:23'),
(71, 'HAPUS KELAS', 'Mengahapus kelas ', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:27'),
(72, 'TAMBAH KELAS', 'Menambahkan kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:34'),
(73, 'UPDATE KELAS', 'Memperbarui kelas XIIu', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:47'),
(74, 'UPDATE KELAS', 'Memperbarui kelas XII', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:58:52'),
(75, 'UPDATE KELAS', 'Memperbarui kelas XXI', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 01:59:03'),
(76, 'TAMBAH KELAS', 'Menambahkan kelas IIX', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 02:08:11'),
(77, 'UPDATE KELAS', 'Memperbarui kelas V', 'Aji Seto Arifianto, S.ST., M.T.', '2022-04-24 02:08:17'),
(78, 'UPDATE KELAS', 'Memperbarui kelas X', 'Hana Wulan Agusta', '2022-04-24 16:49:31');

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
  `id` int(11) NOT NULL,
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

INSERT INTO `ma_pengurus` (`id`, `kode`, `nip`, `username`, `password`, `nama_lengkap`, `hak_akses`, `status`, `created_at`, `updated_at`) VALUES
(1, 'PGS-69698', '343243243243243', 'a', 'a', 'Hana Wulan Agusta', 'ADMINISTRATOR', 'AKTIF', '2022-04-24 16:03:17', '2022-04-24 16:21:34');

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
(1, 2000, 3, 0, '2022-04-17 17:07:36');

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `KODE_uniq` (`kode`),
  ADD UNIQUE KEY `NAMA_uniq` (`nama`);

--
-- Indexes for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ma_kelas`
--
ALTER TABLE `ma_kelas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Kode_Uniq` (`kode`);

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
  ADD UNIQUE KEY `username` (`username`);

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
-- AUTO_INCREMENT for table `ma_jurusan`
--
ALTER TABLE `ma_jurusan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `ma_kategori`
--
ALTER TABLE `ma_kategori`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ma_kelas`
--
ALTER TABLE `ma_kelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `ma_log`
--
ALTER TABLE `ma_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `ma_penerbit`
--
ALTER TABLE `ma_penerbit`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ma_pengurus`
--
ALTER TABLE `ma_pengurus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
