import java.util.*;

public class App {
    public static void main(String[] args) {

        Map<String, Buku> daftarBuku = new HashMap<>();
        Set<Anggota> daftarAnggota = new HashSet<>();
        LinkedList<String> daftarPinjam = new LinkedList<>();
        Map<String, String> statusBuku = new HashMap<>();
        
        daftarBuku.put("1", new Buku("1", "Bumi"));
        daftarBuku.put("2", new Buku("2", "Bulan"));

        daftarAnggota.add(new Anggota("1", "Budi", "Siswa"));
        daftarAnggota.add(new Anggota("2", "Siti", "Dosen"));
        daftarAnggota.add(new Anggota("1", "Budi", "Siswa"));

        for (Anggota anggota : daftarAnggota) {
            System.out.println("ID Anggota: " + anggota.idAnggota + "#" + "Nama :" + anggota.nama + "#" + "Tipe :" + anggota.tipe);
        }

        for (Anggota anggota : daftarAnggota) {
            if (anggota.tipe.equals("Dosen")) {
                daftarPinjam.addFirst(anggota.idAnggota + "#" + daftarBuku.get("1").isbn);
            } else if (anggota.tipe.equals("Siswa")) {
                daftarPinjam.addLast(anggota.idAnggota + "#" + daftarBuku.get("2").isbn);
            }
        }

        for (String pinjam : daftarPinjam) {
            System.out.println("Daftar Pinjam: " + pinjam);
        }

         for(String peminjaman : daftarPinjam) {
            String[] parts = peminjaman.split("#");
            String idAnggota = parts[0];
            boolean anggotaTerdaftar = false;
            for(Anggota anggota : daftarAnggota){ {
                if(anggota.idAnggota.equals(idAnggota)){
                    anggotaTerdaftar = true;
                }
            }
            if(!anggotaTerdaftar){
                System.out.println("Anggota dengan ID: " + idAnggota + " tidak ditemukan.");
                continue;
            }
        
            String isbnBuku = parts[1];
            if(daftarBuku.get(isbnBuku) == null){
                System.out.println("Buku dengan ISBN: " + isbnBuku + " tidak ditemukan.");
                continue;
            }
            if(statusBuku.get(isbnBuku) != null && statusBuku.get(isbnBuku).equals("Dipinjam")){
                System.out.println(isbnBuku + " sudah dipinjam oleh anggota lain.");
            }else{
                statusBuku.put(isbnBuku, "Dipinjam");
                System.out.println(idAnggota + " berhasil meminjam buku dengan ISBN: " + isbnBuku);
            }
        }

        System.out.println("Status Buku: " + daftarBuku.get("1").judul + " - " + statusBuku.get("1"));
        System.out.println("Status Buku: " + daftarBuku.get("2").judul + " - " + statusBuku.get("2"));
        

        }
    }
}