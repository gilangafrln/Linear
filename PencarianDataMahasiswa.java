// Mengimpor library Scanner untuk input dari pengguna
import java.util.Scanner;

// Kelas Mahasiswa merepresentasikan data mahasiswa
class Mahasiswa {
    String nim;        // NIM mahasiswa
    String nama;       // Nama mahasiswa
    String jurusan;    // Jurusan mahasiswa
    double ipk;        // IPK mahasiswa

    // Konstruktor untuk mengisi data mahasiswa saat objek dibuat
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim;           // Inisialisasi NIM
        this.nama = nama;         // Inisialisasi nama
        this.jurusan = jurusan;   // Inisialisasi jurusan
        this.ipk = ipk;           // Inisialisasi IPK
    }

    // Override method toString untuk menampilkan data mahasiswa secara rapi
    @Override
    public String toString() {
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}

// Kelas utama program
public class PencarianDataMahasiswa {
    // Method utama
    public static void main(String[] args) {
        // Array berisi daftar mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        // Membuat objek Scanner untuk input dari user
        Scanner scanner = new Scanner(System.in);

        // Menampilkan menu awal
        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ===");
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine(); // Membaca input NIM dari user

        // Memanggil method pencarian berdasarkan NIM
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari);

        // Menampilkan hasil pencarian
        System.out.println("\nHASIL PENCARIAN:");
        if (hasilPencarian != null) {
            System.out.println("Mahasiswa ditemukan!");
            System.out.println(hasilPencarian); // Menampilkan detail mahasiswa
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }

        scanner.close(); // Menutup scanner setelah selesai digunakan
    }

    // Method untuk mencari mahasiswa berdasarkan NIM (linear search)
    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i]; // Jika ditemukan, kembalikan objek mahasiswa
            }
        }
        return null; // Jika tidak ditemukan, kembalikan null
    }
}