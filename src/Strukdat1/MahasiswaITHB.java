package Strukdat1;

import java.util.Random;

public class MahasiswaITHB {
    static int[][][] mhs = new int[5][10][2];

    public static void main(String[] args) {
        setMhs();
        mhsPerProdi(1);
        mhsPerAngkatanPerJk(1, 0);
        mhsPerProdiPerJk(1, 1);
    }

    public static void setMhs() {
        Random rand = new Random();

        for (int i = 0; i < mhs.length; i++) {
            for (int j = 0; j < mhs[i].length; j++) {
                for (int k = 0; k < mhs[i][j].length; k++) {
                    mhs[i][j][k] = rand.nextInt(20);
                }
            }
        }
    }

    public static void mhsPerProdiPerJk(int prodi, int jk) {
        int total = 0;
        for (int i = 0; i < mhs[prodi].length; i++) {
            for (int j = 0; j < mhs[prodi][i].length; j++) {
                total += mhs[prodi][i][jk];
            }
        }
        System.out.println("jumlah Mahasiswa dari prodi " + prodi + " dengan Jenis Kelamin Ke " + jk + " Sebanyak " + total);
    }

    public static void mhsPerProdi(int prodi) {
        int total = 0;
        for (int i = 0; i < mhs[prodi].length; i++) {
            for (int j = 0; j < mhs[prodi][i].length; j++) {
                total += mhs[prodi][i][j];
            }
        }
        System.out.println("Jumlah Mahasiswa Dari Prodi ke " + prodi + " Sebanyak " + total);
    }

    public static void mhsPerAngkatanPerJk(int angkatan, int jk) {
        int total = 0;
        for (int i = 0; i < mhs.length; i++) {
            for (int j = 0; j < mhs[i][angkatan].length; j++) {
                total += mhs[i][angkatan][jk];
            }
        }

        System.out.println("Jumlah Mahasiswa dari angkatan ke " + angkatan + " dengan Jenis Kelamin ke " + jk + " Sebanyak " + total);
    }


}
