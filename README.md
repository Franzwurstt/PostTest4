# PostTest4

**Nama: Prakasa Wira Mukti**

**Nim: 2409116054**

**Tema: Manajemen Daftar Harga Komponen Komputer**

---

## Deskripsi Program

Program ini dibuat untuk orang orang seperti pemilik toko komputer, teknisi, atau orang orang yang ingin merakit komputer untuk mencatat harga dari komponen yang ingin mereka beli, sehingga mereka bisa mempertimbangkan terlebih dahulu sebelum membeli. Disini pengguna dapat menambahkan komponen baru beserta harganya, melihat daftar komponen yang sudah tersimpan, memperbarui data komponen, serta menghapus data komponen yang tidak diperlukan.

---

### Struktur program dibagi menjadi 3 bagian:

Model Class Komponen:
Berisi struktur data/atribut. Dalam hal ini Komponen yang punya atribut nama, harga, dan kategori.

View Class Main: 
Menjadi tampilan/menu yang berinteraksi dengan user. Semua input dan output terjadi di sini.

Controller Class KomponenService:
Berisi logika bisnis CRUD. Main hanya memanggil method dari sini tanpa tahu bagaimana data disimpan.

## Penjelasan Alur Program

### Peran Main:

alur program dikendalikan melalui kelas Main. Saat dijalankan, pengguna akan ditampilkan menu interaktif untuk memilih aksi, seperti menambah komponen PC, menambah komponen I/O, melihat daftar, memperbarui, menghapus, menghitung total harga, atau keluar dari program. Input pengguna diproses menggunakan Scanner, lalu diteruskan ke metode yang sesuai di KomponenService. Ketika pengguna memilih menambah komponen, mereka dapat memilih apakah ingin menambahkan komponen PC dengan detail spesifikasinya, atau komponen I/O dengan detail konektivitasnya. Semua data yang dimasukkan kemudian dikelola oleh service, disimpan dalam list, dan bisa ditampilkan kembali sesuai kebutuhan

package com.mycompany.posttest3;

import Model.Komponen;
import Model.KomponenPC;
import Model.KomponenIO;
import Service.KomponenService;
import java.util.Scanner;

public class Posttest3 {
    public static void main(String[] args) {
        KomponenService service = new KomponenService();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n*** Daftar Harga Komponen Komputer ***");
            System.out.println("1. Tambah Komponen");
            System.out.println("2. Lihat List Komponen");
            System.out.println("3. Update Komponen");
            System.out.println("4. Hapus Komponen");
            System.out.println("5. Hitung Total Harga");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\nPilih jenis komponen:");
                    System.out.println("1. Komponen PC (CPU, RAM, GPU, dll)");
                    System.out.println("2. Komponen I/O (Keyboard, Mouse, Monitor, dll)");
                    System.out.print("Masukkan pilihan: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan nama komponen: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan harga komponen: ");
                    double harga = input.nextDouble();
                    input.nextLine();
                    System.out.print("Masukkan kategori komponen: ");
                    String kategori = input.nextLine();

                    if (jenis == 1) {
                        KomponenPC pc = new KomponenPC(nama, harga, kategori);
                        service.tambahKomponen(pc);
                    } else if (jenis == 2) {
                        KomponenIO io = new KomponenIO(nama, harga, kategori);
                        service.tambahKomponen(io);
                    } else {
                        System.out.println("Pilihan jenis tidak valid!");
                    }
                    break;

                case 2:
                    service.lihatKomponen();
                    break;

                case 3:
                    service.lihatKomponen();
                    System.out.print("Masukkan nomor komponen yang ingin diupdate: ");
                    int update = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan nama baru: ");
                    String namabaru = input.nextLine();
                    System.out.print("Masukkan harga baru: ");
                    double hargabaru = input.nextDouble();
                    input.nextLine();
                    System.out.print("Masukkan kategori baru: ");
                    String kategoribaru = input.nextLine();

                    System.out.println("Apakah komponen ini PC atau IO?");
                    System.out.println("1. PC");
                    System.out.println("2. IO");
                    int jenisUpdate = input.nextInt();
                    input.nextLine();

                    Komponen baru;
                    if (jenisUpdate == 1) {
                        baru = new KomponenPC(namabaru, hargabaru, kategoribaru);
                    } else {
                        baru = new KomponenIO(namabaru, hargabaru, kategoribaru);
                    }

                    service.updateKomponen(update - 1, baru);
                    break;

                case 4:
                    service.lihatKomponen();
                    System.out.print("Masukkan nomor komponen yang ingin dihapus: ");
                    int hapus = input.nextInt();
                    input.nextLine();
                    service.hapusKomponen(hapus - 1);
                    break;

                case 5:
                    service.hitungTotalHarga();
                    break;

                case 6:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        input.close();
    }
}


### Peran Class Service (KomponenService)

Pengelolaan data komponen ditangani oleh kelas KomponenService. Di dalamnya ada ArrayList yang menyimpan daftar komponen. Service ini bertugas melaksanakan operasi CRUD terhadap data komponen. Metode tambahKomponen() digunakan untuk menambahkan objek baru ke dalam list, lihatKomponen() untuk menampilkan semua komponen yang sudah ada, updateKomponen() untuk memperbarui komponen tertentu, dan hapusKomponen() untuk menghapus. Ada juga method hitungTotalHarga() yang akan menjumlahkan harga semua komponen.

package Service;

import Model.Komponen;

import java.util.ArrayList;

public class KomponenService {
   private ArrayList<Komponen> listKomponen = new ArrayList<>();

    public void tambahKomponen(Komponen k) {
        listKomponen.add(k);
        System.out.println(" Komponen berhasil ditambahkan!");
    }

    public void lihatKomponen() {
        System.out.println("\n=== Daftar Komponen ===");
        if (listKomponen.isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            for (int i = 0; i < listKomponen.size(); i++) {
                System.out.print((i + 1) + ". ");
                listKomponen.get(i).tampilkanInfo(); // polymorphism → sesuai subclass
            }
        }
    }

    public void updateKomponen(int index, Komponen k) {
        if (index >= 0 && index < listKomponen.size()) {
            listKomponen.set(index, k);
            System.out.println("Komponen berhasil diupdate!");
        } else {
            System.out.println("Nomor komponen tidak valid.");
        }
    }

    public void hapusKomponen(int index) {
        if (index >= 0 && index < listKomponen.size()) {
            listKomponen.remove(index);
            System.out.println("Komponen berhasil dihapus!");
        } else {
            System.out.println("Nomor komponen tidak valid.");
        }
    }

    public void hitungTotalHarga() {
        double total = 0;
        for (Komponen k : listKomponen) {
            total += k.getHarga();
        }
        System.out.println("Total harga semua komponen: Rp" + String.format("%,.2f", total));
    }
}


### Peran Class Model (Komponen, KomponenPC, KomponenIO)

Pertama, kelas Komponen bertindak sebagai superclass yang mendefinisikan atribut dasar dari setiap komponen komputer, yaitu nama, harga, dan kategori. Ketiga atribut ini dibuat dengan akses private agar tidak bisa diakses langsung dari luar kelas. Untuk bisa mengubah atau membaca nilai atribut, digunakan getter dan setter sehingga penerapan encapsulation terlihat jelas. Di dalam kelas ini juga terdapat method tampilkanInfo(), sebuah method umum yang nantinya dapat dioverride oleh subclass agar bisa menampilkan informasi dengan cara yang lebih spesifik.

package Model;

public class Komponen {
    private String nama;
    private double harga;
    private String kategori;

    public Komponen(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama +
                           " | Harga: Rp" + harga +
                           " | Kategori: " + kategori);
    }
}


Selanjutnya ada kelas KomponenPC yang menjadi subclass pertama dari Komponen. Kelas ini mewakili seluruh komponen internal PC seperti prosesor, RAM, motherboard, atau VGA. Selain atribut umum dari superclass, kelas ini menambahkan atribut baru berupa spesifikasi yang berfungsi menjelaskan detail teknis komponen tersebut. Di sini method tampilkanInfo() dioverride agar menampilkan informasi lengkap termasuk spesifikasi tambahan tersebut. Dengan begitu, informasi yang muncul lebih sesuai dengan kebutuhan pengguna ketika melihat daftar komponen PC.

Package Model;

public class KomponenPC extends Komponen {
    private String tipePC; 

    public KomponenPC(String nama, double harga, String kategori) {
        super(nama, harga, kategori);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Komponen PC -> " + getNama() +
                           " | Harga: Rp" + getHarga() +
                           " | Kategori: " + getKategori());
    }
}

Berbeda dengan itu, kelas KomponenIO adalah subclass kedua dari Komponen yang fokus pada perangkat input dan output seperti keyboard, mouse, monitor, atau printer. Kelas ini menambahkan atribut konektivitas untuk menjelaskan bagaimana perangkat tersebut terhubung, misalnya menggunakan USB, HDMI, atau wireless. Sama seperti KomponenPC, kelas ini juga melakukan overriding pada method tampilkanInfo(). Dengan overriding ini, objek KomponenIO akan menampilkan detail khusus tentang konektivitas yang tidak dimiliki oleh komponen PC.


package Model;

public class KomponenIO extends Komponen {
    private String tipeIO; // contoh: "Input", "Output"

     public KomponenIO(String nama, double harga, String kategori) {
        super(nama, harga, kategori);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Komponen I/O -> " + getNama() +
                           " | Harga: Rp" + getHarga() +
                           " | Kategori: " + getKategori());
    }
}


### Output

Menu 1 Tambah Komponen
Disini user akan diberikan pilihan untuk menambahkan komponen pc atau komponen I/O.

Komponen PC

<img width="311" height="260" alt="image" src="https://github.com/user-attachments/assets/f7028b27-8a0a-4908-bf7f-fc84b8bf743a" />


Komponen I/O

<img width="328" height="262" alt="image" src="https://github.com/user-attachments/assets/57613dc3-d030-46d4-9630-a9f0baa21f3f" />


Menu 2 Lihat List Komponen

Di menu 2 user bisa melihat apa saja komponen yang sudah ditambahkan. 

<img width="471" height="190" alt="image" src="https://github.com/user-attachments/assets/fcba0505-a3ef-4a3b-9d67-7b932902ff45" />


Menu 3 Update Komponen

Disini user akan diberikan pilihan untuk memperbarui data komponen yang sudah mereka buat.

<img width="469" height="325" alt="image" src="https://github.com/user-attachments/assets/c2302ec0-19c5-42bc-824a-f4fc0b2a6401" />


Bukti kalau sudah di update

<img width="466" height="196" alt="image" src="https://github.com/user-attachments/assets/263d5816-d6ca-4fa4-a0ef-fccf46bc311e" />


Menu 4 Hapus Komponen

User akan diberikan pilihan untuk menghapus data komponen yang mereka inginkan.

Contoh

<img width="492" height="226" alt="image" src="https://github.com/user-attachments/assets/45e94a65-a1e9-4e9f-b6dc-23231fcee0bb" />


Hasil

<img width="473" height="186" alt="image" src="https://github.com/user-attachments/assets/9af7297d-baf6-4c14-a713-ed79522784fd" />


Menu 5 Hitung Total Harga

Disini user bisa menghitung total harga dari list komponen yang sudah mereka buat.

<img width="288" height="148" alt="image" src="https://github.com/user-attachments/assets/f784defb-70b0-41f8-841a-c9107774fe1f" />


Menu 6 Keluar

Jika memilih menu 6 maka otomatis user akan keluar dari program.

<img width="350" height="218" alt="image" src="https://github.com/user-attachments/assets/c0c5a8a3-7c33-424a-91f7-bee5ca6f6f8f" />
