SELECT a.kd_order,b.kd_detail_order,a.tanggal_transaksi,c.item_menu_nama,d.bungkus
from tbl_order_customer a
LEFT JOIN tbl_detail_order_customer b ON b.kd_detail_order = a.detail_order_kd
LEFT JOIN tbl_master_item_menu c on c.id_item_menu = b.item_menu_id
LEFT JOIN tbl_transaksi_pesanan d ON d.order_kd = a.kd_order
GROUP BY a.kd_order



##query untuk laporan penjualan
SELECT toc.tanggal_order,tmim.item_menu_nama,tdoc.qty,(tdoc.qty * tmim.item_menu_harga) as subtotal FROM tbl_order_customer toc 
LEFT JOIN tbl_detail_order_customer tdoc ON tdoc.kd_detail_order = toc.detail_order_kd
LEFT JOIN tbl_master_item_menu tmim ON tmim.id_item_menu = tdoc.item_menu_id
LEFT JOIN tbl_transaksi_pesanan ttp ON ttp.order_kd = toc.kd_order
WHERE ttp.lunas ='y' AND ttp.tgl_pembayaran BETWEEN '2019-05-07 00:00:00' AND '2019-06-07 23:59:59' 

##query untuk membuat struk for customer
SELECT kd_order, tmj.kd_meja,tmim.item_menu_nama,(tdoc.qty * tmim.item_menu_harga) as subtotal  FROM tbl_order_customer toc
RIGHT JOIN tbl_detail_order_customer tdoc ON toc.detail_order_kd = tdoc.kd_detail_order
LEFT JOIN tbl_master_item_menu tmim ON tdoc.item_menu_id = tmim.id_item_menu
INNER JOIN tbl_transaksi_pesanan ttp ON toc.kd_order = ttp.order_kd
LEFT JOIN tbl_master_meja tmj ON toc.meja_id = tmj.id_meja
LEFT JOIN tbl_master_payment_type tmpt ON ttp.payment_type_id = tmpt.id_payment_type
WHERE toc.kd_order = "ODR20190518MJ00133"

##query untuk membuat struk for koki
SELECT tmim.item_menu_nama,tdoc.qty FROM tbl_struk_for_koki tsfk 
LEFT JOIN tbl_order_customer toc ON tsfk.order_kd = toc.kd_order
RIGHT JOIN tbl_detail_order_customer tdoc ON toc.detail_order_kd = tdoc.kd_detail_order
LEFT JOIN tbl_master_item_menu tmim ON tdoc.item_menu_id = tmim.id_item_menu
WHERE tsfk.order_kd = "ODR20190518MJ00133"



DELETE tbl_order_customer,tbl_detail_order_customer,tbl_transaksi_pesanan,tbl_struk_for_koki
FROM tbl_order_customer
INNER JOIN tbl_detail_order_customer ON tbl_order_customer.detail_order_kd = tbl_detail_order_customer.kd_detail_order
INNER JOIN tbl_transaksi_pesanan ON tbl_order_customer.kd_order = tbl_transaksi_pesanan.order_kd
INNER JOIN tbl_struk_for_koki ON tbl_order_customer.kd_order = tbl_struk_for_koki.order_kd
WHERE tbl_order_customer.kd_order = "ODR20190520MJ0011"


##truncate smua tabel transaksi
TRUNCATE tbl_order_customer;
TRUNCATE tbl_detail_order_customer;
TRUNCATE tbl_transaksi_pesanan;
TRUNCATE tbl_struk_for_koki;







#jasper area
SELECT toc.tanggal_order,tmim.item_menu_nama,tdoc.qty,(tdoc.qty * tmim.item_menu_harga) as subtotal FROM tbl_order_customer toc 
LEFT JOIN tbl_detail_order_customer tdoc ON tdoc.kd_detail_order = toc.detail_order_kd
LEFT JOIN tbl_master_item_menu tmim ON tmim.id_item_menu = tdoc.item_menu_id
LEFT JOIN tbl_transaksi_pesanan ttp ON ttp.order_kd = toc.kd_order
WHERE ttp.lunas ='y' AND ttp.tgl_pembayaran BETWEEN $P{tgl1} AND $P{tgl2}