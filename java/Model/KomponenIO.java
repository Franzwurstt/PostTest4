package Model;

import Komponen.Komponen;

public class KomponenIO extends Komponen {
    private String tipeIO; 

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