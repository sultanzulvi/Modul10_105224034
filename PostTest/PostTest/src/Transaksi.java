public class Transaksi {
    private final String namaPelanggan;
    private final String kodeFilm;
    private final String judulFilm;
    private final String nomorKursi;
    private final int harga;

    public Transaksi(String namaPelanggan, String kodeFilm, String judulFilm, String nomorKursi, int harga) {
        this.namaPelanggan = namaPelanggan;
        this.kodeFilm = kodeFilm;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
        this.harga = harga;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getKodeFilm() {
        return kodeFilm;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }

    public int getHarga() {
        return harga;
    }
}
