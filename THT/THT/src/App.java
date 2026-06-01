public class App {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Laptop ASUS", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Kursi Kerja", "Furnitur", 25);
        gudang.tambahBarangBaru("B03", "Mouse Logitech", "Elektronik", 50);

        gudang.tambahStok("B01", 5);
        gudang.kurangiStok("B02", 10);
        gudang.kurangiStok("B01", 20);
        gudang.cetakLaporan();
    }
}