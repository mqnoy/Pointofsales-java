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



SELECT toc.tanggal_order,tmim.item_menu_nama,tdoc.qty,(tdoc.qty * tmim.item_menu_harga) as subtotal FROM tbl_order_customer toc 
LEFT JOIN tbl_detail_order_customer tdoc ON tdoc.kd_detail_order = toc.detail_order_kd
LEFT JOIN tbl_master_item_menu tmim ON tmim.id_item_menu = tdoc.item_menu_id
LEFT JOIN tbl_transaksi_pesanan ttp ON ttp.order_kd = toc.kd_order
WHERE ttp.lunas ='y' AND ttp.tgl_pembayaran BETWEEN $P{tgl1} AND $P{tgl2}