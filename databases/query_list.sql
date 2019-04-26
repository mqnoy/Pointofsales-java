SELECT a.kd_order,b.kd_detail_order,a.tanggal_transaksi,c.item_menu_nama,d.bungkus
from tbl_order_customer a
LEFT JOIN tbl_detail_order_customer b ON b.kd_detail_order = a.detail_order_kd
LEFT JOIN tbl_master_item_menu c on c.id_item_menu = b.item_menu_id
LEFT JOIN tbl_transaksi_pesanan d ON d.order_kd = a.kd_order
GROUP BY a.kd_order