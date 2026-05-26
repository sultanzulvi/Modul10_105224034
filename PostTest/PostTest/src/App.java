import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String, Film> daftarFilm = new HashMap<>();

        daftarFilm.put("F01", new Film("Bumi", 50000));
        daftarFilm.put("F02", new Film("Bulan", 45000));
        daftarFilm.put("F03", new Film("Matahari", 55000));

        Map<String, Set<String>> kursiPenonton = new HashMap<>();
        List<Transaksi> riwayatTransaksi = new ArrayList<>();

        pesanTiket("Budi", "F01", "A1", daftarFilm, kursiPenonton, riwayatTransaksi);
        pesanTiket("Siti", "F02", "B4", daftarFilm, kursiPenonton, riwayatTransaksi);
        pesanTiket("Andi", "F03", "C3", daftarFilm, kursiPenonton, riwayatTransaksi);
        pesanTiket("Rina", "F01", "A1", daftarFilm, kursiPenonton, riwayatTransaksi);
        pesanTiket("Toni", "F02", "B5", daftarFilm, kursiPenonton, riwayatTransaksi);

        System.out.println();
        cetakRiwayat(riwayatTransaksi);
    }

    private static void pesanTiket(
            String namaPelanggan,
            String kodeFilm,
            String nomorKursi,
            Map<String, Film> daftarFilm,
            Map<String, Set<String>> kursiTerisi,
            List<Transaksi> riwayatTransaksi) {

        Film film = daftarFilm.get(kodeFilm);
        if (film == null) {
            System.out.println("Gagal : " + kodeFilm);
            return;
        }

        Set<String> kursiUntukFilm = kursiTerisi.computeIfAbsent(kodeFilm, k -> new HashSet<>());
        if (kursiUntukFilm.contains(nomorKursi)) {
            System.out.println("Gagal memesan: kursi " + nomorKursi + " untuk film '" + film.getJudul() + "' sudah dipesan.");
            return;
        }

        kursiUntukFilm.add(nomorKursi);
        riwayatTransaksi.add(new Transaksi(namaPelanggan, kodeFilm, film.getJudul(), nomorKursi, film.getHarga()));
        System.out.println("Berhasil memesan: " + namaPelanggan + " | " + film.getJudul() + " | " + nomorKursi + " | Rp" + film.getHarga());
    }

    private static void cetakRiwayat(List<Transaksi> riwayatTransaksi) {
        System.out.println("Riwayat Transaksi :");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
            return;
        }

        for (int i = 0; i < riwayatTransaksi.size(); i++) {
            Transaksi transaksi = riwayatTransaksi.get(i);
            System.out.println((i + 1) + "Nama Pemesan : " + transaksi.getNamaPelanggan());
            System.out.println("Judul Film  : " + transaksi.getJudulFilm());
            System.out.println("Nomor Kursi : " + transaksi.getNomorKursi());
            System.out.println("Harga : Rp" + transaksi.getHarga());
            System.out.println();
        }
    }
}
