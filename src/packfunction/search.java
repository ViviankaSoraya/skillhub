package packfunction;

import java.util.List;
import packmain.primary;

public class search {
    public static void searchnama(List<primary.Kursus> arrsearch, String nama) {
        boolean found = false;
        for (primary.Kursus data : arrsearch) {
            if (data != null && data.nama().equalsIgnoreCase(nama)) {
                found = true;
                System.out.println("Tanggal Pendaftaran: " + data.tanggaldaftar());
                System.out.println("Nama Pelanggan: " + data.nama());
                System.out.println("No Handphone: " + data.nohp());
                System.out.println("Kursus: " + primary.daftarKursus[data.kursusIndex()]);
                System.out.println("Jadwal: " + (data.jadwalIndex() == 1 ? "Pagi" : "Malam"));
                System.out.println("Total Harga: Rp " + data.totalHarga());
                System.out.println("Pembayaran: Rp " + data.pembayaran());
                System.out.println("Status Pembayaran: " + ((data.pembayaran() < data.totalHarga()) ? "Belum Lunas" : "Lunas"));
                break;
            }
        }

        if (!found) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
