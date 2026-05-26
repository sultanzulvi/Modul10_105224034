public class Film {
    protected String judul;
    protected int harga;

    public Film(String judul, int harga) {
        this.judul = judul;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public int getHarga() {
        return harga;
    }
}
