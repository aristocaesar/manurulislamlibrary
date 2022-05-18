-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Bulan Mei 2022 pada 11.09
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.10

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
('E41211739', 'Fifa Fajr Firdaus', 'TKJ', 0, 100, '2022-05-11 16:20:11', '2022-05-15 19:41:44'),
('E41211741', 'Aristo Caesar Pratama', 'TKJ', 0, 100, '2022-05-11 23:01:06', '2022-05-15 19:41:28'),
('E41211742', 'Hana Wulan Agustaa', 'TKJ', 0, 96, '2022-05-11 16:18:58', '2022-05-15 19:40:50');

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
  `stok` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `rak` varchar(16) DEFAULT NULL,
  `deskripsi` text DEFAULT NULL,
  `max_hari_pinjam` int(11) NOT NULL,
  `jumlah_dipinjam` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ma_buku`
--

INSERT INTO `ma_buku` (`isbn`, `judul`, `jenis`, `kategori`, `harga`, `tahun_terbit`, `penulis`, `penerbit`, `stok`, `rak`, `deskripsi`, `max_hari_pinjam`, `jumlah_dipinjam`, `created_at`, `updated_at`) VALUES
('978-602-244-314-8', 'Buku Panduan Guru Pendidikan Pancasila Dan Kewarganegaraan Untuk Smp Kelas 7', 'PAKET', 'IS', '50000.0', '2022', 'Badan Penelitian', 'Pt. Gramedia Asri Media', 28, 'TIK', '', 1, NULL, '2022-05-18 16:01:52', '2022-05-18 16:01:52'),
('978-602-464-053-8', 'Buku Halo Koding - Buku Untuk Programmer', 'UMUM', 'TGNI', '125000.0', '2022', 'Hilman', 'Pt. Gramedia Asri Media', 8, 'TIK', '', 7, NULL, '2022-05-18 15:56:32', '2022-05-18 16:02:12'),
('978-602-6948-93-9 ', 'Manajemen Sistem Informasi Perpustakaan', 'UMUM', 'TGNI', '124000.0', '2022', 'Drs. Hartono, S.s., M.hum.', 'Pt. Gramedia Asri Media', 3, 'KMK', '', 7, NULL, '2022-05-18 16:00:07', '2022-05-18 16:00:07'),
('978-602-7869-75-2', 'Manajemen Kearsipan Modern Dari Konvensional Ke Basis Komputer Edisi Baru', 'UMUM', 'TGNI', '59000.0', '2022', 'Agus Sugiarto, S.pd,m.m.', 'Pt. Gramedia Asri Media', 0, 'TIK', '', 5, NULL, '2022-05-18 15:58:46', '2022-05-18 16:02:43'),
('978-602-8545-46-4 ', 'Manajemen Kearsipan Elektronik Panduan Pengembangan Aplikasi Kearsipan Elektronik', 'UMUM', 'TGNI', '56000.0', '2022', 'Agus Sugiarto', 'Pt. Gramedia Asri Media', 5, 'TIK', '', 7, NULL, '2022-05-18 15:57:55', '2022-05-18 16:02:50');

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
(1, 5, 0, 0, 3, '2022-05-11 15:41:11');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_detail_transaksi`
--

CREATE TABLE `ma_detail_transaksi` (
  `id_transaksi` varchar(16) DEFAULT NULL,
  `isbn` varchar(28) NOT NULL,
  `status_buku` enum('Tepat','Perpanjang','Bermasalah','Terlambat') DEFAULT NULL,
  `kondisi_buku` enum('Baik','Rusak','Hilang') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
('IS', 'Ilmu Sosial', 'buku ilmu sosial', '2022-05-18 15:49:58', '2022-05-18 15:49:58'),
('MAT', 'Matematika', 'Buku Kategori Matematika', '2022-03-23 10:22:49', '2022-05-09 21:46:52'),
('MJLH', 'Majalah', 'buku kategori majalah', '2022-05-18 15:48:40', '2022-05-18 15:48:40'),
('TGNI', 'Teknologi', 'buku kategori teknologi', '2022-05-16 22:31:45', '2022-05-18 15:50:29');

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
('Pt. Gramedia Asri Media', '081370708828', '2022-05-18 15:51:27', '2022-05-18 15:51:27');

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
('PGS - 23125', '2342343434', 'av', 'as', 'Hana Wulan Agusta', 'STAF', 'AKTIF', '2022-05-16 13:46:53', '2022-05-16 13:47:43'),
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
('KMK', 'Komik', 'rak komik', '2022-05-18 15:52:12', '2022-05-18 15:52:12'),
('MJLH', 'Majalah', 'rak majalah', '2022-05-18 15:52:35', '2022-05-18 15:52:35'),
('TIK', 'Teknologi', 'rak teknologi', '2022-05-18 15:51:49', '2022-05-18 15:51:49');

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
(1, 2000, 5, 0, '2022-05-08 03:09:54');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ma_transaksi`
--

CREATE TABLE `ma_transaksi` (
  `id_transaksi` varchar(16) NOT NULL,
  `nis_anggota` varchar(28) NOT NULL,
  `kode_pengurus` varchar(16) NOT NULL,
  `jenis_buku` enum('PKT','UMM') DEFAULT NULL,
  `status_transaksi` enum('DIPINJAM','BERMASALAH','SELESAI') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD UNIQUE KEY `judul` (`judul`),
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
  ADD KEY `FK_ma_detail_transaksi_ma_transaksi` (`id_transaksi`),
  ADD KEY `FK_ma_detail_transaksi_ma_buku` (`isbn`);

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

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `ma_anggota`
--
ALTER TABLE `ma_anggota`
  ADD CONSTRAINT `FK Jurusan` FOREIGN KEY (`jurusan`) REFERENCES `ma_jurusan` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `ma_buku`
--
ALTER TABLE `ma_buku`
  ADD CONSTRAINT `FK_Kategori` FOREIGN KEY (`kategori`) REFERENCES `ma_kategori` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Penerbit` FOREIGN KEY (`penerbit`) REFERENCES `ma_penerbit` (`nama`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Rak` FOREIGN KEY (`rak`) REFERENCES `ma_rak` (`kode`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `ma_detail_transaksi`
--
ALTER TABLE `ma_detail_transaksi`
  ADD CONSTRAINT `FK_ma_detail_transaksi_ma_buku` FOREIGN KEY (`isbn`) REFERENCES `ma_buku` (`isbn`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ma_detail_transaksi_ma_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `ma_transaksi` (`id_transaksi`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `ma_log`
--
ALTER TABLE `ma_log`
  ADD CONSTRAINT `FK_Pengurus` FOREIGN KEY (`pengurus`) REFERENCES `ma_pengurus` (`kode`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `ma_transaksi`
--
ALTER TABLE `ma_transaksi`
  ADD CONSTRAINT `FK_ma_transaksi_ma_anggota` FOREIGN KEY (`nis_anggota`) REFERENCES `ma_anggota` (`nis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ma_transaksi_ma_pengurus` FOREIGN KEY (`kode_pengurus`) REFERENCES `ma_pengurus` (`kode`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
