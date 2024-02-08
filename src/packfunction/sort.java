package packfunction;

import java.util.List;

import packmain.primary;
import packmain.primary.Kursus;

public class sort {
    // Algoritma pengurutan Insertion Sort berdasarkan nama
    public static void sortnama(List<primary.Kursus> arrsort) {
        int n = arrsort.size();
        for (int i = 1; i < n; ++i) {
            Kursus key = arrsort.get(i);
            int j = i - 1;
            while (j >= 0 && arrsort.get(j).nama().compareToIgnoreCase(key.nama()) > 0) {
                arrsort.set(j + 1, arrsort.get(j));
                j = j - 1;
            }
            arrsort.set(j + 1, key);
        }
    }

    public static void sorttanggal(List<primary.Kursus> arrsort) {
        int n = arrsort.size();
        for (int i = 1; i < n; ++i) {
            primary.Kursus key = arrsort.get(i);
            int j = i - 1;
            while (j >= 0 && arrsort.get(j).tanggaldaftar().compareTo(key.tanggaldaftar()) > 0) {
                arrsort.set(j + 1, arrsort.get(j));
                j = j - 1;
            }
            arrsort.set(j + 1, key);
        }
    }

    public static void sortstatus(List<primary.Kursus> arrsort) {
        int n = arrsort.size();
        for (int i = 1; i < n; ++i) {
            primary.Kursus key = arrsort.get(i);
            int j = i - 1;
            while (j >= 0 && arrsort.get(j).pembayaran() < key.pembayaran()) {
                arrsort.set(j + 1, arrsort.get(j));
                j = j - 1;
            }
            arrsort.set(j + 1, key);
        }
    }
}