import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class SistemGudang {
    private Map<String, Barang> databaseBarang; 
    private Set<String> kategoriUnik;           
    private List<String> riwayat;               

    public SistemGudang() {
        this.databaseBarang = new HashMap<>();
        this.kategoriUnik = new HashSet<>();
        this.riwayat = new ArrayList<>();
    }

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang barangBaru = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barangBaru); 
        kategoriUnik.add(kategori);         
        riwayat.add("Barang Masuk: " + id + " didaftarkan dengan stok " + stok + " unit.");
    }

    public void tambahStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id);
            int stokLama = barang.getStok();
            barang.setStok(stokLama + jumlah);
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit.");
        } else {
            riwayat.add("Gagal!, ID " + id + " tidak ditemukan.");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        if (!databaseBarang.containsKey(id)) {
            riwayat.add("Gagal!, ID " + id + " tidak ditemukan.");
            System.out.println("Transaksi Gagal: ID Barang tidak ditemukan.");
            return;
        }

        Barang barang = databaseBarang.get(id);
        if (barang.getStok() >= jumlah) {
            int stokLama = barang.getStok();
            barang.setStok(stokLama - jumlah);
            riwayat.add("Barang : " + id + " dikurangi " + jumlah + " unit.");
        } else {
            riwayat.add("Gagal!, Sisa stok " + id + " tidak cukup untuk " + jumlah + " unit.");
            System.out.println("Transaksi Gagal: Stok tidak mencukupi.");
        }
    }

    public void cetakLaporan() {
        System.out.println("\nLAPORAN AKHIR GUDANG");
        
        System.out.println("\n[DAFTAR KATEGORI BARANG]");
        for (String kat : kategoriUnik) {
            System.out.println("- " + kat);
        }

        System.out.println("\n[STATUS STOK BARANG SAAT INI]");
        for (Map.Entry<String, Barang> entry : databaseBarang.entrySet()) {
            Barang b = entry.getValue();
            System.out.println("ID: " + b.getIdBarang() + " | Nama: " + b.getNamaBarang() + 
                               " | Kategori: " + b.getKategori() + " | Sisa Stok: " + b.getStok() + " unit");
        }

        System.out.println("\n[RIWAYAT AKTIVITAS TRANSAKSI]");
        int no = 1;
        for (String log : riwayat) {
            System.out.println(no + ". " + log);
            no++;
        }
    }
}