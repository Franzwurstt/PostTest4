package com.mycompany.posttest3;

import Komponen.Komponen;
import Komponen.KomponenService;
import Model.KomponenPC;
import Model.KomponenIO;
import java.util.Scanner;

public class posttest4 {
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
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        input.close();
    }
}
