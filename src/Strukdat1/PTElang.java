package Strukdat1;
import java.util.Arrays;
import java.util.Scanner;


public class PTElang {
    public static void main(String[] args) {
        no2();
    }

    public static void no1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ingin mencari data ? PERSEGI||Persegi Panjang||Jajar Genjang||Trapesium|| Belah Ketupat || Layangan || Segitiga || Lingkaran");
        String pilihan = scan.nextLine().toLowerCase();



        switch (pilihan) {
            case "persegi":
                double rumusKelilingPersegi = 0;
                double rumusLuasPersegi = 0;

                for (int i = 0; i < global.sisi.length; i++) {
                    System.out.println("Masukan Sisi Persegi");
                    global.sisi[i] = scan.nextDouble();
                    rumusKelilingPersegi = 4 * global.sisi[i];
                    rumusLuasPersegi = 2 * global.sisi[i];
                }
                System.out.println(rumusKelilingPersegi);

                break;

            case "persegi panjang":
                System.out.println("Masukan Panjang Persegi Panjang");
                global.panjang = scan.nextDouble();
                System.out.println("Masukan Lebar Persegi");
                global.lebar = scan.nextDouble();
                double rumusKelilingPersegiPanjang = (2 * global.panjang) + (2 * global.lebar);
                double rumusLuasPersegiPanjang = global.panjang * global.lebar;
                System.out.println(rumusKelilingPersegiPanjang);
                System.out.println(rumusLuasPersegiPanjang);
                break;

            case "jajar genjang":
                System.out.println("Masukan Panjang Jajar Genjang");
                global.panjang = scan.nextDouble();
                System.out.println("Masukan Lebar Jajar Genjang");
                global.lebar = scan.nextDouble();
                System.out.println("Masukan Tinggi Jajar Genjang");
                global.tinggi = scan.nextDouble();
                System.out.println("Masukan Alas Jajar Genjang ");
                global.alas = scan.nextDouble();
                double rumusKelilingJajarGenjang = 2 * (global.panjang + global.lebar);
                double rumusLuasJajarGenjang = global.alas * global.tinggi;
                System.out.println(rumusKelilingJajarGenjang);
                System.out.println(rumusLuasJajarGenjang);
                break;

            case "trapesium":
                double total = 0;
                double KelilingTrapesium = 0;
                double[] sisiTrapesium = new double[4];

                for (int i = 0; i < sisiTrapesium.length; i++) {
                    System.out.println("Masukan Sisi ke - " + i);
                    sisiTrapesium[i] = scan.nextDouble();
                    total += sisiTrapesium[i];
                }
                System.out.println("Masukan tinggi trapesium");
                global.tinggi = scan.nextDouble();
                KelilingTrapesium = sisiTrapesium[1] + sisiTrapesium[2] * global.tinggi * 2;
                System.out.println(total);
                System.out.println(KelilingTrapesium);
                break;

            case "belah ketupat":
                double kelilingBK = 0;
                double luasBK = 0;
                for (int i = 0; i < global.sisi.length; i++) {
                    System.out.println("Masukan sisi Belah Ketupat");
                    global.sisi[i] = scan.nextDouble();
                    kelilingBK = 4 * global.sisi[i];

                }
                System.out.println("Masukan Diagonal 1 : ");
                double d1BK = scan.nextDouble();
                System.out.println("Masukan Diagonal 2 : ");
                double d2BK = scan.nextDouble();
                luasBK = d1BK * d2BK / 2;
                System.out.println(kelilingBK);
                System.out.println(luasBK);
                break;

            case "layangan":
                System.out.println("Masukan Panjang Layangan");
                global.panjang = scan.nextDouble();
                System.out.println("Masukan Lebar layangan : ");
                global.lebar = scan.nextDouble();
                System.out.println("Masukan Diagonal 1 : ");
                double d1L = scan.nextDouble();
                System.out.println("Masukan Diagonal 2 : ");
                double d2L = scan.nextDouble();

                double KelilingL = (2 * global.panjang) + (2 * global.lebar);
                double LuasL = d1L * d2L / 2;

                System.out.println(KelilingL);
                System.out.println(LuasL);
                break;

            case "segitiga":
                double kelilingSegitiga = 0;

                for (int i = 0; i < global.sisi.length; i++) {
                    System.out.println("Masukan sisi ke : " + (i + 1));
                    global.sisi[i] = scan.nextDouble();
                    kelilingSegitiga += global.sisi[i];
                }
                System.out.println("Masukan Alas Segitiga ");
                global.alas = scan.nextDouble();

                System.out.println("Masukan tinggi Segitiga");
                global.tinggi = scan.nextDouble();
                double LuasSegitiga = global.alas * global.tinggi;
                System.out.println(kelilingSegitiga);
                System.out.println(LuasSegitiga);
            case "lingkaran":
                double phi = 3.14;
                System.out.println("Masukan Jari-Jari Lingkaran");
                double jariL = scan.nextDouble();
                double kelilingLingkaran = 2 * phi * jariL;
                double LuasLingkaran = phi * Math.pow(jariL, 2);

                System.out.println(kelilingLingkaran);
                System.out.println(LuasLingkaran);
        }

    }

    public static void no2() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        int i = 0;

        while (!exit) {
            System.out.println("Masukan Nama anda");
            kereta.nama[i] = scan.nextLine();
            System.out.println("Kemana Tujuan Anda ? A||B||C||D||E");
            kereta.tujuan[i] = scan.next().toLowerCase();
            System.out.println("Kelas yang dipilih Promo||Ekomomi||Bisnis");
            kereta.kelas[i] = scan.next().toLowerCase();
            System.out.println("Masukan Usia anda ");
            kereta.usia[i] = scan.nextInt();
            System.out.println("Masukan Tipe Bagasi anda || 'K' = <=15Kg || 'L' <=20kg || 'M' > 20kg ");
            kereta.bagasi[i] = scan.next().toLowerCase();

            if (kereta.tujuan[i].equals("a") && kereta.kelas[i].equals("promo")) {
                kereta.harga[i] = 310000;
            } else if (kereta.tujuan[i].equals("b") && kereta.kelas[i].equals("promo")) {
                kereta.harga[i] = 500000;
            } else if (kereta.tujuan[i].equals("c") && kereta.kelas[i].equals("promo")) {
                kereta.harga[i] = 620000;
            } else if (kereta.tujuan[i].equals("a") && kereta.kelas[i].equals("ekonomi")) {
                kereta.harga[i] = 400000;
            } else if (kereta.tujuan[i].equals("b") && kereta.kelas[i].equals("ekonomi")) {
                kereta.harga[i] = 550000;
            } else if (kereta.tujuan[i].equals("c") && kereta.kelas[i].equals("ekonomi")) {
                kereta.harga[i] = 700000;

            } else if (kereta.tujuan[i].equals("a") && kereta.kelas[i].equals("bisnis")) {
                kereta.harga[i] = 500000;
            } else if (kereta.tujuan[i].equals("b") && kereta.kelas[i].equals("bisnis")) {
                kereta.harga[i] = 620000;
            } else if (kereta.tujuan[i].equals("c") && kereta.kelas[i].equals("bisnis")) {
                kereta.harga[i] = 750000;
            } else {
                System.err.println("Salah memasukan tujuan");
            }

            if (kereta.bagasi[i].equals("k")) {
                kereta.daftarBagasi[i] = 45000;
            } else if (kereta.bagasi[i].equals("l")) {
                kereta.daftarBagasi[i] = 90000;
            } else if (kereta.bagasi[i].equals("m")) {
                kereta.daftarBagasi[i] = 120000;
            } else {
                System.err.println("Salah memasukan kode bagasi");
            }
            System.out.println("Apakah masih ingin melanjutkan ? ");
            String validate = scan.next();

            exit = validate.equals("n");
            System.out.println(exit);
            i++;
            scan.nextLine();
        }
        System.out.println(Arrays.toString(kereta.nama) + "   ||   ");
        System.out.println(Arrays.toString(kereta.tujuan) + "   ||   ");
        System.out.println(Arrays.toString(kereta.usia) + "   ||   ");
        validasiHargaTiket();
        System.out.println(Arrays.toString(kereta.daftarBagasi) + "   ||   ");
        totalBayar();

    }

    public static void totalBayar() {
        double totalbayar = 0;
        for (int i = 0; i < kereta.harga.length; i++) {
            totalbayar = kereta.diskon[i] + kereta.daftarBagasi[i];
            System.out.println("   " + totalbayar);
        }
    }


    public static void validasiHargaTiket() {

        for (int i = 0; i < kereta.usia.length; i++) {
            if (kereta.usia[i] < 1 || kereta.usia[i] > 60) {
                kereta.diskon[i] = kereta.harga[i] * 0.5;
                System.out.println(Arrays.toString(kereta.harga));
            } else {
                kereta.diskon[i] = kereta.harga[i];
                System.out.println(Arrays.toString(kereta.harga));
            }
        }
    }


    public static class global {
        static final double[] sisi = new double[3];
        static double lebar;
        static double panjang;
        static double alas;
        static double tinggi;
        static double diagonal;
    }

    public static class kereta {
        static String[] nama = new String[100];
        static String[] tujuan = new String[100];
        static int[] usia = new int[100];
        static String[] bagasi = new String[100];
        static String[] kelas = new String[100];
        static int[] harga = new int[100];
        static int[] daftarBagasi = new int[100];
        static double[] diskon = new double[100];
    }
}


