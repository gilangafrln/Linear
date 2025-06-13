// Mengimpor library yang dibutuhkan
import java.util.ArrayList; // Untuk menyimpan hasil pencarian kata
import java.util.Scanner;   // Untuk membaca input dari pengguna

public class PencarianKata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM PENCARIAN KATA ===");
        System.out.print("Masukkan teks: ");
        String teks = scanner.nextLine();

        System.out.print("Masukkan kata yang dicari: ");
        String kataCari = scanner.nextLine();

        // Memanggil fungsi pencarian kata dan menyimpan hasilnya.
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari);

        System.out.println("\nHASIL PENCARIAN:");
        if (posisiDitemukan.size() > 0) {
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " +
                               posisiDitemukan.size() + " kali pada posisi:");

            // Menampilkan posisi kata yang ditemukan.
            for (int i = 0; i < posisiDitemukan.size(); i++) {
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) +
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")");
            }

            // Menampilkan teks dengan highlight kata yang ditemukan.
            System.out.println("\nTeks dengan highlight:");
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan);
        } else {
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks.");
        }

        scanner.close(); // Menutup scanner setelah selesai digunakan.
    }

    // Fungsi untuk mencari kata dalam teks.
    public static ArrayList<Integer> cariKata(String teks, String kata) {
        ArrayList<Integer> posisi = new ArrayList<>();

        // Mengubah teks dan kata menjadi lowercase untuk pencarian case-insensitive.
        String teksLower = teks.toLowerCase();
        String kataLower = kata.toLowerCase();

        int panjangKata = kataLower.length();
        int panjangTeks = teksLower.length();

        // Melakukan pencarian linear.
        for (int i = 0; i <= panjangTeks - panjangKata; i++) {
            // Memotong teks untuk memeriksa apakah sama dengan kata yang dicari.
            String potongan = teksLower.substring(i, i + panjangKata);

            if (potongan.equals(kataLower)) {
                posisi.add(i); // Menambahkan posisi kata yang ditemukan ke dalam list.
            }
        }

        return posisi; // Mengembalikan list posisi kata yang ditemukan.
    }

    // Fungsi untuk menampilkan teks dengan highlight pada kata yang ditemukan.
    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks);

        // Menambahkan tanda "[ ]" untuk highlight kata yang ditemukan.
        for (int i = posisi.size() - 1; i >= 0; i--) { //Iterasi mundur untuk menghindari pergeseran indeks.
            int pos = posisi.get(i);
            hasil.insert(pos + kata.length(), "]");
            hasil.insert(pos, "[");
        }

        System.out.println(hasil.toString()); // Menampilkan teks dengan highlight.
    }
}