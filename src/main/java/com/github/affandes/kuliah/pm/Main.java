package com.github.affandes.kuliah.pm;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        int pilihan;
        do {
            System.out.println("\n=== SIMULASI BROWSER HISTORY ===");
            System.out.println("1. Browse (Tambah Website)");
            System.out.println("2. Back (Kembali ke Website Sebelumnya)");
            System.out.println("3. View (Lihat Semua History)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan alamat website: ");
                    String site = sc.nextLine();
                    history.push(site);
                    System.out.println("✅ Berhasil membuka: " + site);
                    break;

                case 2:
                    if (history.isEmpty()) {
                        System.out.println("⚠️ History kosong. Tidak ada halaman untuk kembali.");
                    } else {
                        String last = history.pop();
                        System.out.println("⬅️ Kembali dari: " + last);
                        if (!history.isEmpty()) {
                            System.out.println("Sekarang kamu di: " + history.peek());
                        } else {
                            System.out.println("Tidak ada halaman yang tersisa di history.");
                        }
                    }
                    break;

                case 3:
                    if (history.isEmpty()) {
                        System.out.println("📭 History masih kosong.");
                    } else {
                        System.out.println("\n=== DAFTAR HISTORY BROWSER ===");
                        Stack<String> temp = new Stack<>();
                        temp.addAll(history);

                        int count = 1;
                        while (!temp.isEmpty()) {
                            System.out.println(count + ". " + temp.pop());
                            count++;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

    }
}
