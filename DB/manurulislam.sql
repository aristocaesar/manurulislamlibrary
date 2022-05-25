-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Bulan Mei 2022 pada 20.16
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Struktur dari tabel `ma_anggota`
--

CREATE TABLE `ma_anggota` (
  `nis` varchar(28) CHARACTER SET utf8mb4 NOT NULL,
  `nama_lengkap` varchar(128) CHARACTER SET utf8mb4 DEFAULT '',
  `jurusan` varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL,
  `jumlah_buku_dipinjam` int(11) NOT NULL DEFAULT 0,
  `skor` int(100) DEFAULT 100,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ma_anggota`
--

INSERT INTO `ma_anggota` (`nis`, `nama_lengkap`, `jurusan`, `jumlah_buku_dipinjam`, `skor`, `created_at`, `updated_at`) VALUES
('41211601', 'M Lutfi Zein A', 'TKJ', 1, 100, '2022-05-25 10:50:48', '2022-05-25 10:50:48'),
('41211674', 'Slamet Daeroni', 'TKJ', 2, 100, '2022-05-26 00:43:22', '2022-05-26 00:43:22'),
('41211696', 'Bachtiar Arya Habibi', 'TPL', 1, 100, '2022-05-25 10:48:10', '2022-05-25 10:48:48'),
('41211739', 'Fifa Fajr Firdaus', 'TKJ', 0, 100, '2022-05-11 16:20:11', '2022-05-25 10:54:34'),
('41211741', 'Karren Novita', 'TKJ', 1, 100, '2022-05-11 23:01:06', '2022-05-25 10:54:43'),
('41211742', 'Hana Wulan Agustaa', 'TKJ', 0, 55, '2022-05-11 16:18:58', '2022-05-25 10:53:38'),
('41212221', 'Naufal A', 'AK', 0, 100, '2022-05-25 10:49:30', '2022-05-25 10:49:30'),
('41212278', 'Diaz Bagus Maulana', 'TGK', 0, 100, '2022-05-25 10:50:16', '2022-05-25 10:50:16'),
('41212285', 'Elisa Christian Alfrido Mantolas', 'TGK', 0, 100, '2022-05-25 09:54:28', '2022-05-25 10:53:28'),
('41212335', 'Mohammad Tajut Zam Zami', 'MIF', 0, 100, '2022-05-25 10:46:51', '2022-05-25 10:46:51'),
('41212382', 'Dwi Nafis Mahardika', 'TKJ', 0, 100, '2022-05-25 10:51:40', '2022-05-25 10:54:22');

--
-- Trigger `ma_anggota`
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
-- Struktur dari tabel `ma_buku`
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
  `stok` int(11) NOT NULL,
  `rak` varchar(16) DEFAULT NULL,
  `deskripsi` text DEFAULT NULL,
  `max_hari_pinjam` int(11) NOT NULL,
  `jumlah_dipinjam` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_buku`
--

INSERT INTO `ma_buku` (`isbn`, `judul`, `jenis`, `kategori`, `harga`, `tahun_terbit`, `penulis`, `penerbit`, `stok`, `rak`, `deskripsi`, `max_hari_pinjam`, `jumlah_dipinjam`, `created_at`, `updated_at`) VALUES
('602-6232-57-1', 'Buku Security Jaringan Komputer Berbasis Ceh | Belajar Menjadi White Hacker', 'UMUM', 'TGNI', '89000.0', '2018', 'Rifkie Primartha?', 'Cakradenta Agung Pertiwi, Pt', 2, 'TIK', 'Penulis mendapati bahwa permasalahan riil yang terkait security jaringan komputer, khususnya yang terkait dengan aktifitas hacking, sudah mencapai batas ambang gawat darurat. Sehingga diperlukan obat penawar dengan dosis tinggi untuk mengatasi penyakit akut tersebut.?? ??', 7, 3, '2022-05-22 14:39:42', '2022-05-22 14:39:42'),
('978-602-0823-06-5', 'Buku Hacking Aplikasi Web Uncensored Untuk Pemula', 'UMUM', 'TGNI', '70000.0', '2015', 'Efvy Zam', 'Cakradenta Agung Pertiwi, Pt', 3, 'TIK', 'Buku ini akan menunjukkan kepada kamu, bahwa dengan logika yang sederhana saja maka seseorang sudah bisa melakukan aksi website hacking. Dimulai dari proses menggali informasi sebuah website hingga melakukan eksekusi untuk menerobos website. Tentu saja, ada banyak jalan menuju Roma dan banyak pula cara atau teknik yang dapat ditempuh. Teknik itulah yang akan diulas dan dibahas dalam buku ini', 7, 1, '2022-05-22 14:38:31', '2022-05-22 14:38:31'),
('978-602-1514-71-9', 'Buku Belajar Otodidak Mysql Teknik Pembuatan Dan Pengelolaan Database', 'UMUM', 'TGNI', '85000.0', '2022', 'Budi Raharjo', 'Calista Alam, Pt', 5, 'TIK', ' MySQL adalah software yang berfungsi untuk membuat, mengatur, dan mengelola database. Dengan MySQL, Anda dapat membuat sendiri database untuk menyimpan dan mengelola data perusahaan (misal: data pegawai, keuangan dan akuntansi, aset, dll), data pribadi Anda, koleksi foto keluarga Anda dan sebagainya secara mudah dan aman.?', 7, 1, '2022-05-22 14:44:17', '2022-05-22 14:46:47'),
('978-602-6231-28-4', 'Buku 5 Langkah Mudah Menguasai React Native | Lukmanul Hakim', 'UMUM', 'TGNI', '75000.0', '2021', 'Lukmanul Hakim', 'Calista Alam, Pt', 10, 'TIK', 'React Native merupakan salah satu tool terbaik untuk membuat aplikasi mobile (mobile apps). Karena sesuai tagline-nya Learn Once, Write Anywhere, App dapat dijalankan di dua platform sekaligus, yaitu Android dan iOS (Apple). Selain itu, App yang dibuat dengan React Native berkinerja bagus, cepat dan stabil.', 7, 0, '2022-05-22 14:40:46', '2022-05-22 14:40:46'),
('978-602-62311-8-5', 'Buku Analisa Dan Perancangan Sistem Informasi Dengan Codeigniter Dan Laravel', 'UMUM', 'TGNI', '65000.0', '2018', 'Meilan Anastasia Maharani', 'Cibaliung Tunggal Plantation, Pt', 8, 'TIK', 'Sistem Informasi dibuat tidak harus mewah, yang paling penting adalah sesuai dengan kebutuhan user. Buku ini membahas tentang cara merancang sebuah sistem informasi sesuai dengan kebutuhan user. Step by step merancang sebuah sistem sampai menjadi sistem informasi yang handal. Buku ini menjelaskan bagaimana sebuah sistem informasi dibuat, dimulai dari mengumpulkan informasi suatu instansi, memahami proses bisnis berjalan, menganalisa masalah yang dihadapi pada proses bisnis berjalan, membuat Fishbone untuk menganalisa permasalahan, membuat usulan dan menganalisa untuk memecahakan tiap masalah yang dihadapi.', 7, 0, '2022-05-22 14:45:52', '2022-05-23 01:54:53'),
('978-602-6232-24-3', 'Buku Belajar Pemrograman Web Dari Dasar Edisi Revisi', 'UMUM', 'TGNI', '95000.0', '2017', 'Priyanto Hidayatullah', 'Cahaya Pelita Andika, Pt', 9, 'TIK', 'Buku Pemrograman Web: Studi Kasus Web Sistem Informasi Akademik ini cocok untuk Mahasiswa/ Siswa SMK dalam menyelesaikan tugas mata kuliah pemrograman web dan tugas akhir dengan topik web atau sistem informasi. Buku ini juga cocok untuk freelance programmer maupun programmer profesional yang bekerja di perusahaan serta orang awam terhadap dunia pemrograman web karena dijelaskan dari nol secara runtut dan terperinci dengan bahasa yang sederhana dan mudah dimengerti.', 7, 0, '2022-05-22 14:32:41', '2022-05-22 14:34:29'),
('978-602-6232-75-5', 'Buku Pemrograman Javascript Untuk Aplikasi Web | Belajar Javascript Untuk Pemula', 'UMUM', 'TGNI', '130000.0', '2018', 'Betha Sidik', 'Calista Alam, Pt', 10, 'TIK', ' Salah satu bahasa Pemrograman yang harus dikuasai oleh pengembang aplikasi berbasis web adalah Javascript. Secara de fakto, Javascript adalah satu-satunya bahasa pemrograman yang ada dalam lingkungan browser web, yang didukung oleh semua browser web modern. Menguasai dasar pemrograman javascript menjadi keharusan, karena kita akan dapat mengetahui bagaimana suatu halaman web bisa ditampilkan untuk menjadi aplikasi berbasis web atau untuk menampilkan informasi dengan banyak cara.?', 7, 0, '2022-05-22 14:36:14', '2022-05-22 14:36:21'),
('978-602-8759-42-7', 'Buku Logika Algoritma Dan Pemrograman Dasar Bahasa Pascal C C++', 'UMUM', 'TGNI', '170000.0', '2018', 'Rosa A.s.?', 'Cipta Narada Sejati', 6, 'TIK', ' Algoritma berarti solusi. Ketika orang berbicara mengenai algoritma di bidang pemrograman, maka yang dimaksud adalah solusi dari suatu masalah yang harus dipecahkan dengan menggunakan komputer. Algoritma harus dibuat secara runut agar komputer mengerti dan mampu mengeksekusinya. Analisis kasus sangat dibutuhkan dalam membuat sebuah algoritma, misalnya proses apa saja yang sekiranya dibutuhkan untuk menyelesaikan masalah yang harus diselesaikan.??', 7, 0, '2022-05-22 14:35:16', '2022-05-22 14:36:26'),
('978-623-7131-03-8', 'Buku Network Security Dan Cyber Security | Cisco Ccna | Linux | Windows | Amazon Aws | Android', 'UMUM', 'TGNI', '130000.0', '2019', 'Iwan Sofana, Rifkie Primartha', 'Cahaya Pelita Andika, Pt', 7, 'TIK', 'Buku ini berisi tentang seluk-beluk computer security dan network security, mulai dari teori hingga praktik. Beberapa materi inti yang dibahas dalam buku ini antara lain: Ciscosecurity, Windows security, Linux security, Android security, AWS cloud computing security, Security Audit ISO 27001 dan NIST 800-53. ?', 7, 0, '2022-05-22 14:34:08', '2022-05-22 14:34:08'),
('978-860-2556-84-04', 'Buku Fundamental Of Python For Machine Learning Untuk Pemula', 'UMUM', 'TGNI', '60000.0', '2018', 'Teguh Wahyono', 'Cibaliung Tunggal Plantation, Pt', 5, 'TIK', 'Artificial intelligence  (AI) dan machine learning saat ini kembali memasuki fase booming setelah beberapa dekade mengalami pasang surut. Kecerdasan Buatan kembali digandrungi, di mana penerapannya dilakukan secara masive pada aplikasi-aplikasi bisnis dan social media jaman sekarang.', 7, 0, '2022-05-22 14:42:43', '2022-05-22 14:42:43');

--
-- Trigger `ma_buku`
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
-- Struktur dari tabel `ma_dashboard`
--

CREATE TABLE `ma_dashboard` (
  `id` int(11) NOT NULL,
  `total_buku` int(11) NOT NULL DEFAULT 0,
  `buku_dipinjam` int(11) NOT NULL DEFAULT 0,
  `buku_bermasalah` int(11) NOT NULL DEFAULT 0,
  `total_anggota` int(11) DEFAULT NULL,
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_dashboard`
--

INSERT INTO `ma_dashboard` (`id`, `total_buku`, `buku_dipinjam`, `buku_bermasalah`, `total_anggota`, `updated_at`) VALUES
(1, 10, 0, 0, 11, '2022-05-11 15:41:11');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_detail_transaksi`
--

CREATE TABLE `ma_detail_transaksi` (
  `id_transaksi` varchar(64) DEFAULT NULL,
  `isbn` varchar(28) NOT NULL,
  `masa_pinjam` varchar(64) DEFAULT NULL,
  `status_buku` enum('Dipinjam','Dikembalikan','Bermasalah') DEFAULT 'Dipinjam',
  `status_masalah` enum('Tidak Bermasalah','Terlambat','Hilang','Rusak') DEFAULT 'Tidak Bermasalah',
  `jumlah_denda` varchar(128) DEFAULT '0',
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_detail_transaksi`
--

INSERT INTO `ma_detail_transaksi` (`id_transaksi`, `isbn`, `masa_pinjam`, `status_buku`, `status_masalah`, `jumlah_denda`, `created_at`, `updated_at`) VALUES
('TR-1653494061052', '602-6232-57-1', '1654098877442', 'Dipinjam', 'Tidak Bermasalah', '0', '2022-05-25 22:54:37', '2022-05-25 22:54:37'),
('TR-1653500851494', '602-6232-57-1', '1654105688859', 'Dipinjam', 'Tidak Bermasalah', '0', '2022-05-26 00:48:08', '2022-05-26 00:48:08'),
('TR-1653500851494', '978-602-0823-06-5', '1654105688863', 'Dipinjam', 'Tidak Bermasalah', '0', '2022-05-26 00:48:08', '2022-05-26 00:48:08'),
('TR-1653501269899', '978-602-1514-71-9', '1654106089088', 'Dipinjam', 'Tidak Bermasalah', '0', '2022-05-26 00:54:49', '2022-05-26 00:54:49'),
('TR-1653502454219', '602-6232-57-1', '1654107279578', 'Dipinjam', 'Tidak Bermasalah', '0', '2022-05-26 01:14:39', '2022-05-26 01:14:39');

--
-- Trigger `ma_detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `CHANGE_STOKBUKU_USRPINJAM_AFTER_PINJAM` AFTER INSERT ON `ma_detail_transaksi` FOR EACH ROW BEGIN

UPDATE ma_buku SET stok = stok - 1, jumlah_dipinjam = jumlah_dipinjam + 1 WHERE isbn = NEW.isbn;

UPDATE ma_anggota SET jumlah_buku_dipinjam = jumlah_buku_dipinjam + 1 WHERE nis = (SELECT nis_anggota FROM ma_transaksi WHERE id_transaksi = NEW.id_transaksi);

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_jurusan`
--

CREATE TABLE `ma_jurusan` (
  `kode` varchar(8) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_jurusan`
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
-- Struktur dari tabel `ma_kategori`
--

CREATE TABLE `ma_kategori` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_kategori`
--

INSERT INTO `ma_kategori` (`kode`, `nama`, `deskripsi`, `created_at`, `updated_at`) VALUES
('MAT', 'Matematika', 'Buku Kategori Matematika', '2022-03-23 10:22:49', '2022-05-09 21:46:52'),
('SINS', 'Sains', 'dafds', '2022-05-25 10:08:28', '2022-05-25 10:08:28'),
('SOS', 'Sosial', 'buku berkategori sosial', '2022-05-22 14:41:31', '2022-05-22 14:41:31'),
('TGNI', 'Teknologi', 'buku kategori teknologi', '2022-05-16 22:31:45', '2022-05-22 12:41:36');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_log`
--

CREATE TABLE `ma_log` (
  `id` int(11) NOT NULL,
  `process` varchar(64) NOT NULL,
  `message` text NOT NULL,
  `pengurus` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ma_log`
--

INSERT INTO `ma_log` (`id`, `process`, `message`, `pengurus`, `created_at`) VALUES
(1, 'LOGIN', 'Berhasil Login', 'PGS-69696', '2022-05-12 00:05:52');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_penerbit`
--

CREATE TABLE `ma_penerbit` (
  `nama` varchar(32) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_penerbit`
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
-- Struktur dari tabel `ma_pengurus`
--

CREATE TABLE `ma_pengurus` (
  `kode` varchar(16) NOT NULL,
  `nip` varchar(32) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `hak_akses` enum('ADMINISTRATOR','STAF') DEFAULT 'STAF',
  `status` enum('AKTIF','BLOKIR') DEFAULT 'AKTIF',
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_pengurus`
--

INSERT INTO `ma_pengurus` (`kode`, `nip`, `username`, `password`, `nama_lengkap`, `hak_akses`, `status`, `created_at`, `updated_at`) VALUES
('PGS - 23125', '2342343434', 'as', 'as', 'Hana Wulan Agusta', 'STAF', 'BLOKIR', '2022-05-16 13:46:53', '2022-05-25 10:11:00'),
('PGS-69696', '5345435', 'a', 'a', 'Aristo Caesar Pratama', 'ADMINISTRATOR', 'AKTIF', '2022-04-29 21:59:11', '2022-05-15 02:42:27');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_rak`
--

CREATE TABLE `ma_rak` (
  `kode` varchar(16) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `deskripsi` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_rak`
--

INSERT INTO `ma_rak` (`kode`, `nama`, `deskripsi`, `created_at`, `updated_at`) VALUES
('IPS', 'Ilmu Pengetahuan Sosial', 'rak buku ilmu pengetahuan sosial bor', '2022-05-08 00:01:33', '2022-05-22 12:40:50'),
('MTK', 'Matematika', 'rak buku matematika', '2022-05-07 23:59:30', '2022-05-07 23:59:30'),
('TIK', 'Teknik Informatika', 'rak buku teknik informatika', '2022-03-23 10:15:02', '2022-03-23 10:15:02');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_setting`
--

CREATE TABLE `ma_setting` (
  `id` int(11) NOT NULL,
  `denda_terlambat` int(11) NOT NULL,
  `max_pinjam_buku_umum` int(11) NOT NULL,
  `time_backup_database` int(28) NOT NULL,
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_setting`
--

INSERT INTO `ma_setting` (`id`, `denda_terlambat`, `max_pinjam_buku_umum`, `time_backup_database`, `updated_at`) VALUES
(1, 2000, 2, 0, '2022-05-25 21:25:11');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_transaksi`
--

CREATE TABLE `ma_transaksi` (
  `id_transaksi` varchar(64) NOT NULL,
  `nis_anggota` varchar(28) NOT NULL,
  `kode_pengurus` varchar(16) NOT NULL,
  `jenis_buku` enum('UMUM','PAKET') DEFAULT NULL,
  `status_transaksi` enum('DIPINJAM','BERMASALAH','SELESAI') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_transaksi`
--

INSERT INTO `ma_transaksi` (`id_transaksi`, `nis_anggota`, `kode_pengurus`, `jenis_buku`, `status_transaksi`, `created_at`, `updated_at`) VALUES
('TR-1653494061052', '41211741', 'PGS-69696', 'UMUM', 'DIPINJAM', '2022-05-25 22:54:37', '2022-05-25 22:54:37'),
('TR-1653500851494', '41211674', 'PGS-69696', 'UMUM', 'DIPINJAM', '2022-05-26 00:48:08', '2022-05-26 00:48:08'),
('TR-1653501269899', '41211696', 'PGS-69696', 'UMUM', 'DIPINJAM', '2022-05-26 00:54:49', '2022-05-26 00:54:49'),
('TR-1653502454219', '41211601', 'PGS-69696', 'UMUM', 'DIPINJAM', '2022-05-26 01:14:39', '2022-05-26 01:14:39');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `ma_anggota`
--
ALTER TABLE `ma_anggota`
  ADD PRIMARY KEY (`nis`),
  ADD KEY `FK Jurusan` (`jurusan`);

--
-- Indeks untuk tabel `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `FK_Kategori` (`kategori`),
  ADD KEY `FK_Penerbit` (`penerbit`),
  ADD KEY `FK_Rak` (`rak`);

--
-- Indeks untuk tabel `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD KEY `FK_ma_detail_transaksi_ma_buku` (`isbn`),
  ADD KEY `FK_ma_detail_transaksi_ma_transaksi` (`id_transaksi`);

--
-- Indeks untuk tabel `ma_jurusan`
--
ALTER TABLE `ma_jurusan`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `ma_kategori`
--
ALTER TABLE `ma_kategori`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `ma_log`
--
ALTER TABLE `ma_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Pengurus` (`pengurus`);

--
-- Indeks untuk tabel `ma_penerbit`
--
ALTER TABLE `ma_penerbit`
  ADD PRIMARY KEY (`nama`);

--
-- Indeks untuk tabel `ma_pengurus`
--
ALTER TABLE `ma_pengurus`
  ADD PRIMARY KEY (`kode`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `nip` (`nip`);

--
-- Indeks untuk tabel `ma_rak`
--
ALTER TABLE `ma_rak`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `ma_setting`
--
ALTER TABLE `ma_setting`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD UNIQUE KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `FK_ma_transaksi_ma_anggota` (`nis_anggota`),
  ADD KEY `FK_ma_transaksi_ma_pengurus` (`kode_pengurus`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `ma_dashboard`
--
ALTER TABLE `ma_dashboard`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `ma_log`
--
ALTER TABLE `ma_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `ma_setting`
--
ALTER TABLE `ma_setting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
