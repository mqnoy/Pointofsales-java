-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 12, 2019 at 11:19 PM
-- Server version: 10.2.13-MariaDB-10.2.13+maria~xenial
-- PHP Version: 5.6.37-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pointofsale`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detail_order_customer`
--

CREATE TABLE `tbl_detail_order_customer` (
  `id_detail_order` int(11) NOT NULL,
  `kd_detail_order` varchar(50) NOT NULL,
  `item_menu_id` int(11) NOT NULL,
  `siap_disantap` enum('no','yes') NOT NULL DEFAULT 'no',
  `qty` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_detail_order_customer`
--

INSERT INTO `tbl_detail_order_customer` (`id_detail_order`, `kd_detail_order`, `item_menu_id`, `siap_disantap`, `qty`, `subtotal`) VALUES
(1, 'ODRD001040819', 1, 'no', 1, 20000),
(2, 'ODRD001040819', 1, 'no', 2, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_item_menu`
--

CREATE TABLE `tbl_master_item_menu` (
  `id_item_menu` int(11) NOT NULL,
  `item_menu_nama` text NOT NULL,
  `item_menu_harga` double NOT NULL,
  `kd_menu` varchar(50) NOT NULL,
  `menu_kategory` enum('makanan','minuman') NOT NULL,
  `hide_menu` enum('y','n') NOT NULL DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_item_menu`
--

INSERT INTO `tbl_master_item_menu` (`id_item_menu`, `item_menu_nama`, `item_menu_harga`, `kd_menu`, `menu_kategory`, `hide_menu`) VALUES
(1, 'menu1', 60000, 'kdmenu1', 'minuman', 'y'),
(5, 'kdmenuao', 33330, 'kdmenuao2', 'minuman', 'y'),
(6, 'ff', 110, '23', 'minuman', 'y'),
(7, 'nasi bakar ', 60000, 'kdmenu2', 'makanan', 'n'),
(8, 'nasi bakar daging', 50000, 'kdmenu23', 'makanan', 'n'),
(9, 'nasi bakar ayam', 60000, 'kdmenu24', 'makanan', 'n');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_meja`
--

CREATE TABLE `tbl_master_meja` (
  `id_meja` int(11) NOT NULL,
  `kd_meja` varchar(50) NOT NULL,
  `kategori_meja` enum('reguler','vip') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_meja`
--

INSERT INTO `tbl_master_meja` (`id_meja`, `kd_meja`, `kategori_meja`) VALUES
(1, 'MJ001', 'reguler'),
(2, 'MJ002', 'reguler'),
(3, 'MJ003', 'reguler'),
(4, 'MJ004', 'reguler'),
(5, 'MJ005', 'reguler'),
(6, 'MJ006', 'reguler'),
(7, 'MJ007', 'reguler'),
(8, 'MJ008', 'reguler'),
(9, 'MJ009', 'reguler');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_payment_type`
--

CREATE TABLE `tbl_master_payment_type` (
  `id_payment_type` int(11) NOT NULL,
  `kd_payment_type` varchar(50) NOT NULL,
  `type_payment` text NOT NULL,
  `tax_payment` decimal(3,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_payment_type`
--

INSERT INTO `tbl_master_payment_type` (`id_payment_type`, `kd_payment_type`, `type_payment`, `tax_payment`) VALUES
(1, 'CASH001', 'pembayaran tunai', '10.0'),
(2, 'DEBITBCA001', 'debit bca', '10.0');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_pegawai`
--

CREATE TABLE `tbl_master_pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `pegawai_nip` varchar(50) NOT NULL,
  `pegawai_nama` text NOT NULL,
  `pegawai_jabatan` enum('pelayan','kepalakoki','kasir') NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_pegawai`
--

INSERT INTO `tbl_master_pegawai` (`id_pegawai`, `pegawai_nip`, `pegawai_nama`, `pegawai_jabatan`, `user_id`) VALUES
(1, '201643502057', 'rifky azmi', 'kepalakoki', 1),
(2, '201643502058', 'rifky qnoy', 'kasir', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_pos_computer`
--

CREATE TABLE `tbl_master_pos_computer` (
  `id_pos_computer` int(11) NOT NULL,
  `kd_computer_pos` varchar(50) NOT NULL,
  `computer_hostname` text NOT NULL,
  `computer_ip` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_pos_computer`
--

INSERT INTO `tbl_master_pos_computer` (`id_pos_computer`, `kd_computer_pos`, `computer_hostname`, `computer_ip`) VALUES
(1, 'COMPUTER001', 'WIN7-POS001', '192.168.1.2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master_user_application`
--

CREATE TABLE `tbl_master_user_application` (
  `id_user` int(11) NOT NULL,
  `idaccess` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `level` enum('superadmin','operator') NOT NULL,
  `blokir` enum('y','n') NOT NULL,
  `date_registered` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_master_user_application`
--

INSERT INTO `tbl_master_user_application` (`id_user`, `idaccess`, `password`, `level`, `blokir`, `date_registered`) VALUES
(1, '201643502057', '3627e7e6b1136675a6b6b04f9c60323f', 'superadmin', 'y', '2019-04-08 00:00:00'),
(2, '2057', '1234', 'operator', 'n', '2019-04-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_customer`
--

CREATE TABLE `tbl_order_customer` (
  `id_order_cust` int(11) NOT NULL,
  `kd_order` varchar(50) NOT NULL,
  `payment_type_id` int(11) NOT NULL,
  `lunas` enum('y','n') NOT NULL DEFAULT 'n',
  `detail_order_kd` varchar(50) NOT NULL,
  `meja_id` int(11) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order_customer`
--

INSERT INTO `tbl_order_customer` (`id_order_cust`, `kd_order`, `payment_type_id`, `lunas`, `detail_order_kd`, `meja_id`, `tanggal_transaksi`) VALUES
(1, 'ODR20190402001', 1, 'n', 'ODRD001040819', 1, '2019-04-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_struk`
--

CREATE TABLE `tbl_struk` (
  `id_struk` int(11) NOT NULL,
  `order_cust_id` int(11) NOT NULL,
  `total_tagihan_pajak` double NOT NULL,
  `total_tagihan` double NOT NULL,
  `nominal_pembayaran` double NOT NULL,
  `kembalian` double NOT NULL,
  `pos_computer_id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `cetakan_tgl_struk` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_struk`
--

INSERT INTO `tbl_struk` (`id_struk`, `order_cust_id`, `total_tagihan_pajak`, `total_tagihan`, `nominal_pembayaran`, `kembalian`, `pos_computer_id`, `id_pegawai`, `cetakan_tgl_struk`) VALUES
(1, 1, 22000, 22000, 100000, 78000, 1, 1, '2019-04-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_struk_for_koki`
--

CREATE TABLE `tbl_struk_for_koki` (
  `id_struk_for_koki` int(11) NOT NULL,
  `order_cust_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_struk_for_koki`
--

INSERT INTO `tbl_struk_for_koki` (`id_struk_for_koki`, `order_cust_id`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_master_item_menu`
--
ALTER TABLE `tbl_master_item_menu`
  ADD PRIMARY KEY (`id_item_menu`),
  ADD UNIQUE KEY `kd_menu` (`kd_menu`);

--
-- Indexes for table `tbl_master_meja`
--
ALTER TABLE `tbl_master_meja`
  ADD PRIMARY KEY (`id_meja`);

--
-- Indexes for table `tbl_master_payment_type`
--
ALTER TABLE `tbl_master_payment_type`
  ADD PRIMARY KEY (`id_payment_type`);

--
-- Indexes for table `tbl_master_pegawai`
--
ALTER TABLE `tbl_master_pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `pegawai_nip` (`pegawai_nip`);

--
-- Indexes for table `tbl_master_pos_computer`
--
ALTER TABLE `tbl_master_pos_computer`
  ADD PRIMARY KEY (`id_pos_computer`);

--
-- Indexes for table `tbl_master_user_application`
--
ALTER TABLE `tbl_master_user_application`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `idaccess` (`idaccess`);

--
-- Indexes for table `tbl_order_customer`
--
ALTER TABLE `tbl_order_customer`
  ADD PRIMARY KEY (`id_order_cust`);

--
-- Indexes for table `tbl_struk`
--
ALTER TABLE `tbl_struk`
  ADD PRIMARY KEY (`id_struk`);

--
-- Indexes for table `tbl_struk_for_koki`
--
ALTER TABLE `tbl_struk_for_koki`
  ADD PRIMARY KEY (`id_struk_for_koki`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_master_item_menu`
--
ALTER TABLE `tbl_master_item_menu`
  MODIFY `id_item_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbl_master_meja`
--
ALTER TABLE `tbl_master_meja`
  MODIFY `id_meja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbl_master_payment_type`
--
ALTER TABLE `tbl_master_payment_type`
  MODIFY `id_payment_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_master_pegawai`
--
ALTER TABLE `tbl_master_pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_master_pos_computer`
--
ALTER TABLE `tbl_master_pos_computer`
  MODIFY `id_pos_computer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_master_user_application`
--
ALTER TABLE `tbl_master_user_application`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_order_customer`
--
ALTER TABLE `tbl_order_customer`
  MODIFY `id_order_cust` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_struk`
--
ALTER TABLE `tbl_struk`
  MODIFY `id_struk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_struk_for_koki`
--
ALTER TABLE `tbl_struk_for_koki`
  MODIFY `id_struk_for_koki` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
