SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `tbl_detail_order_customer` (
  `id_detail_order` int(11) NOT NULL,
  `kd_detail_order` varchar(50) NOT NULL,
  `item_menu_id` int(11) NOT NULL,
  `siap_disantap` enum('no','yes') NOT NULL DEFAULT 'no',
  `qty` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_item_menu` (
  `id_item_menu` int(11) NOT NULL,
  `item_menu_nama` text NOT NULL,
  `item_menu_harga` double NOT NULL,
  `kd_menu` varchar(50) NOT NULL,
  `menu_kategory` enum('makanan','minuman') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_meja` (
  `id_meja` int(11) NOT NULL,
  `kd_meja` varchar(50) NOT NULL,
  `kategori_meja` enum('reguler','vip') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_payment_type` (
  `id_payment_type` int(11) NOT NULL,
  `kd_payment_type` varchar(50) NOT NULL,
  `type_payment` text NOT NULL,
  `tax_payment` decimal(3,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `pegawai_nip` varchar(50) NOT NULL,
  `pegawai_nama` text NOT NULL,
  `pegawai_jabatan` enum('pelayan','kepalakoki','kasir') NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_pos_computer` (
  `id_pos_computer` int(11) NOT NULL,
  `kd_computer_pos` varchar(50) NOT NULL,
  `computer_hostname` text NOT NULL,
  `computer_ip` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_master_user_application` (
  `id_user` int(11) NOT NULL,
  `idaccess` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `level` enum('superadmin','operator') NOT NULL,
  `blokir` enum('y','n') NOT NULL,
  `date_registered` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_order_customer` (
  `id_order_cust` int(11) NOT NULL,
  `kd_order` varchar(50) NOT NULL,
  `payment_type_id` int(11) NOT NULL,
  `detail_order_kd` varchar(50) NOT NULL,
  `meja_id` int(11) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `tbl_struk_for_koki` (
  `id_struk_for_koki` int(11) NOT NULL,
  `order_cust_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `tbl_master_item_menu`
  ADD PRIMARY KEY (`id_item_menu`);

ALTER TABLE `tbl_master_meja`
  ADD PRIMARY KEY (`id_meja`);

ALTER TABLE `tbl_master_payment_type`
  ADD PRIMARY KEY (`id_payment_type`);

ALTER TABLE `tbl_master_pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `pegawai_nip` (`pegawai_nip`);

ALTER TABLE `tbl_master_pos_computer`
  ADD PRIMARY KEY (`id_pos_computer`);

ALTER TABLE `tbl_master_user_application`
  ADD PRIMARY KEY (`id_user`);

ALTER TABLE `tbl_order_customer`
  ADD PRIMARY KEY (`id_order_cust`);

ALTER TABLE `tbl_struk`
  ADD PRIMARY KEY (`id_struk`);

ALTER TABLE `tbl_struk_for_koki`
  ADD PRIMARY KEY (`id_struk_for_koki`);


ALTER TABLE `tbl_master_item_menu`
  MODIFY `id_item_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
ALTER TABLE `tbl_master_meja`
  MODIFY `id_meja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
ALTER TABLE `tbl_master_payment_type`
  MODIFY `id_payment_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `tbl_master_pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `tbl_master_pos_computer`
  MODIFY `id_pos_computer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
ALTER TABLE `tbl_master_user_application`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `tbl_order_customer`
  MODIFY `id_order_cust` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
ALTER TABLE `tbl_struk`
  MODIFY `id_struk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
ALTER TABLE `tbl_struk_for_koki`
  MODIFY `id_struk_for_koki` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
