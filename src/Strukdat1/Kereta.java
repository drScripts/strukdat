package Strukdat1;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nama = new String[100];
        String[] tujuan = new String[100];
        int[] usia = new int[100];
        String[] bagasi = new String[100];
        String[] kelas = new String[100];
        int[] harga = new int[100];

        boolean isExit = false;

        while (!isExit) {
            scan.nextLine();
            // scan scan
            String name = scan.nextLine();

            isExit = true;
        }

        Kereta kereta = new Kereta(nama,tujuan,usia,bagasi,kelas,harga);

    }
}

class Kereta {
    String[] nama;
    String[] tujuan;
    int[] usia;
    String[] bagasi;
    String[] kelas;
    int[] harga;

    Kereta(String[] nama, String[] tujuan, int[] usia, String[] bagasi, String[] kelas, int[] harga) {
        this.nama = nama;
        this.tujuan = tujuan;
        this.usia = usia;
        this.bagasi = bagasi;
        this.kelas = kelas;
        this.harga = harga;
    }

}
