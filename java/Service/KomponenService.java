package Komponen;

import Model.KomponenIO;
import Model.KomponenPC;
import java.util.ArrayList;

public class KomponenService {
    private ArrayList<Komponen> daftarKomponen = new ArrayList<>();

    
    public void tambahKomponen(Komponen k) {
        daftarKomponen.add(k);
        System.out.println("Komponen berhasil ditambahkan!");
    }
   
    public void tambahKomponen(String nama, double harga, String kategori, boolean isPC) {
        if (isPC) {
            KomponenPC pc = new KomponenPC(nama, harga, kategori);
            daftarKomponen.add(pc);
        } else {
            KomponenIO io = new KomponenIO(nama, harga, kategori);
            daftarKomponen.add(io);
        }
        System.out.println("Komponen berhasil ditambahkan (dengan overloading)!");
    }
    
    public void lihatKomponen() {
        if (daftarKomponen.isEmpty()) {
            System.out.println("Daftar komponen kosong.");
        } else {
            for (int i = 0; i < daftarKomponen.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarKomponen.get(i).tampilkanInfo(); // Polymorphism
            }
        }
    }

    public void updateKomponen(int index, Komponen baru) {
        if (index >= 0 && index < daftarKomponen.size()) {
            daftarKomponen.set(index, baru);
            System.out.println("Komponen berhasil diupdate!");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void hapusKomponen(int index) {
        if (index >= 0 && index < daftarKomponen.size()) {
            daftarKomponen.remove(index);
            System.out.println("Komponen berhasil dihapus!");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void hitungTotalHarga() {
        double total = 0;
        for (Komponen k : daftarKomponen) {
            total += k.getHarga();
        }
        System.out.println("Total harga semua komponen: Rp" + String.format("%,.2f", total));
    }
}
