// Mengimpor library yang dibutuhkan
import java.util.ArrayList;  // Untuk menyimpan hasil pencarian produk
import java.util.Scanner;    // Untuk membaca input dari pengguna

// Kelas Produk yang merepresentasikan data sebuah produk
class Produk {
    String id;         // ID produk
    String nama;       // Nama produk
    String kategori;   // Kategori produk (misalnya Elektronik, Fashion, Buku)
    double harga;      // Harga produk
    int stok;          // Jumlah stok produk

    // Konstruktor untuk inisialisasi objek Produk
    public Produk(String id, String nama, String kategori, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    // Override method toString untuk menampilkan data produk dalam format tabel
    @Override
    public String toString() {
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d",
                            id, nama, kategori, harga, stok);
    }
}

// Kelas utama untuk pencarian produk
public class PencarianProduk {
    public static void main(String[] args) {
        // Inisialisasi data produk dalam array
        Produk[] daftarProduk = {
            new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10),
            new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15),
            new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50),
            new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25),
            new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30),
            new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20),
            new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40),
            new Produk("P008", "Tas Ransel", "Fashion", 300000, 35)
        };

        Scanner scanner = new Scanner(System.in);  // Objek Scanner untuk input

        System.out.println("=== SISTEM PENCARIAN PRODUK ===");
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku");

        // Input kategori
        System.out.print("Masukkan kategori produk: ");
        String kategoriCari = scanner.nextLine();

        // Input rentang harga
        System.out.print("Masukkan harga minimum: Rp ");
        double hargaMin = scanner.nextDouble();

        System.out.print("Masukkan harga maksimum: Rp ");
        double hargaMax = scanner.nextDouble();

        // Panggil fungsi pencarian produk berdasarkan kriteria
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(
            daftarProduk, kategoriCari, hargaMin, hargaMax
        );

        // Menampilkan hasil pencarian dalam format tabel
        System.out.println("\nHASIL PENCARIAN:");
        System.out.println("===============================================================");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n",
                        "ID", "Nama Produk", "Kategori", "Harga", "Stok");
        System.out.println("---------------------------------------------------------------");

        if (hasilPencarian.size() > 0) {
            // Jika ada hasil, tampilkan satu per satu
            for (Produk p : hasilPencarian) {
                System.out.println(p);
            }
        } else {
            // Jika tidak ada yang cocok
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian.");
        }
        System.out.println("===============================================================");

        scanner.close();  // Menutup Scanner setelah digunakan
    }

    // Fungsi pencarian produk berdasarkan kategori dan rentang harga
    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk,
                                                        String kategori,
                                                        double hargaMin,
                                                        double hargaMax) {
        ArrayList<Produk> hasilPencarian = new ArrayList<>();

        // Lakukan pencarian linear terhadap semua produk
        for (int i = 0; i < daftarProduk.length; i++) {
            Produk produk = daftarProduk[i];

            // Cek apakah produk memenuhi semua kriteria
            if (produk.kategori.equalsIgnoreCase(kategori) &&
                produk.harga >= hargaMin &&
                produk.harga <= hargaMax) {
                hasilPencarian.add(produk);  // Tambahkan ke hasil pencarian
            }
        }

        return hasilPencarian;  // Kembalikan daftar produk yang cocok
    }
}