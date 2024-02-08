package packmain;
import packfunction.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class primary {
    public record Kursus(LocalDate tanggaldaftar, String nama, String nohp, int kursusIndex, int jadwalIndex, int totalHarga, int pembayaran) {}
    public static String[] daftarKursus = {"Menjahit", "Memasak", "Menari", "Bernyanyi"};
    public static int[] hargaKursus = {500000, 700000, 400000, 450000};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Kursus> pendaftar = new ArrayList<>();
        int biayaTambahanMalam = 50000;

        int pil;
        do {
            System.out.println("-----Sistem Pendaftaran Kursus-----");
            System.out.println("1. Tambah Data Pendaftar");
            System.out.println("2. Tampilkan Riwayat Pelanggan");
            System.out.println("3. Cari Transaksi (nama)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-3): ");
            pil = sc.nextInt();
            sc.nextLine();

            switch (pil) {
                case 1:
                    LocalDate tanggaldaftar = LocalDate.now();

                    System.out.print("Masukkan nama Pendaftar : ");
                    String nama = sc.nextLine();

                    System.out.print("Masukkan No Handphone Pendaftar (08xxx) : ");
                    String nohp = sc.nextLine();

                    System.out.println("Pilih kursus yang akan dipilih:");
                    for (int j = 0; j < daftarKursus.length; j++) {
                        System.out.println((j + 1) + ". " + daftarKursus[j] + " - Rp " + hargaKursus[j]);
                    }
                    System.out.print("Input pilihan (1-" + daftarKursus.length + "): ");
                    int kursusIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    System.out.println("Pilih Jadwal:");
                    System.out.println("1. Pagi");
                    System.out.println("2. Malam (ada biaya tambahan sebesar 50.000)");
                    System.out.print("Input pilihan (1/2): ");
                    int jadwalIndex = sc.nextInt();
                    sc.nextLine();

                    int totalHarga = hargaKursus[kursusIndex] + (jadwalIndex == 2 ? biayaTambahanMalam : 0);
                    System.out.println("Total Harga: Rp " + totalHarga);

                    System.out.print("Masukkan jumlah pembayaran: Rp ");
                    int pembayaran = sc.nextInt();
                    sc.nextLine();

                    if (pembayaran < totalHarga) {
                        System.out.println("Sisa Pembayaran: Rp " + (totalHarga - pembayaran));
                        System.out.println("Maksimal pembayaran diselesaikan h-1 kursus dimulai");
                    } else {
                        System.out.println("Kembalian: Rp " + (pembayaran - totalHarga));
                    }

                    pendaftar.add(new Kursus(tanggaldaftar, nama, nohp, kursusIndex, jadwalIndex, totalHarga, pembayaran));
                    break;

                case 2:
                System.out.println("Pilihan Tampilan Riwayat transaksi");    
                System.out.println("1. Sort by nama");
                System.out.println("2. Sort by tanggal");
                System.out.println("3. Sort by status");
                System.out.print("input pilihan-> ");
                int pilsort = sc.nextInt();
                sc.nextLine();
                    switch (pilsort){
                        case 1:
                        sort.sortnama(pendaftar);
                        break;

                        case 2:
                        sort.sorttanggal(pendaftar);
                        break;

                        case 3:
                        sort.sortstatus(pendaftar);
                        break;
                    }
                System.out.println("Data Pelanggan yang Disimpan:");
                    for (Kursus data : pendaftar) {
                        System.out.println("Tanggal Pendaftaran: " + data.tanggaldaftar);
                        System.out.println("Nama Pelanggan: " + data.nama);
                        System.out.println("No Handphone: " + data.nohp);
                        System.out.println("Kursus: " + daftarKursus[data.kursusIndex]);
                        System.out.println("Jadwal: " + (data.jadwalIndex == 1 ? "Pagi" : "Malam"));
                        System.out.println("Total Harga: Rp " + data.totalHarga);
                        System.out.println("Pembayaran: Rp " + data.pembayaran);
                        System.out.println("Status Pembayaran: " + ((data.pembayaran < data.totalHarga) ? "Belum Lunas" : "Lunas"));
                        System.out.println("-----------------------------------");
                    }
                    break;
                
                case 3:
                    System.out.print("Masukkan Nama pendaftar yang akan dicari :");
                    String cari = sc.nextLine();
                    sc.nextLine();
                    search.searchnama (pendaftar, cari);
                    break;
                case 0:
                    System.out.println("Keluar dari program");
                    break;

                default:
                    System.out.println("Pilihan tidak ada");
            }
        } while (pil != 0);

        sc.close();
    }
}
