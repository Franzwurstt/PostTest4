package Model;

import Komponen.Komponen;

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
