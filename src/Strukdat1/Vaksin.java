package Strukdat1;

import java.util.Random;

public class Vaksin {
    static int[][][] vaksinStat = new int[3][4][3]; /// usia,jenis,tahap
    public static void main(String[] args) {
        addVaksinJumlah();
        totalVaksinPerJenis();
        kelompokUsia();
        perTahap();
    }

    public static void addVaksinJumlah(){
        Random rand = new Random();

        for (int i = 0; i < vaksinStat.length; i++) {
            for (int j = 0; j < vaksinStat[i].length; j++) {
                for (int k = 0; k < vaksinStat[i][j].length; k++) {
                    vaksinStat[i][j][k] = rand.nextInt(20);
                }
            }
        }
    }
    
    public static void totalVaksinPerJenis(){
        int[] jenisVaksin = new int[4];

        for (int i = 0; i < vaksinStat.length; i++) { // usia
            for (int j = 0; j < vaksinStat[i].length; j++) { // jenis
                for (int k = 0; k < vaksinStat[i][j].length; k++) { /// tahap
                    jenisVaksin[j]+=vaksinStat[i][j][k];
                }
            }
        }

        for (int i = 0; i < jenisVaksin.length; i++) {
            System.out.println("Jumlah Jenis Vaksin ke " + (i + 1 )+ ":" + jenisVaksin[i]);
        }
    }

    public static void kelompokUsia() {
        int[] usia = new int[3];

        for (int i = 0; i < vaksinStat.length; i++) {
            for (int j = 0; j < vaksinStat[i].length; j++) {
                for (int k = 0; k < vaksinStat[i][j].length; k++) {
                    usia[i]+=vaksinStat[i][j][k];
                }
            }
        }
        for (int i = 0; i < usia.length; i++) {
            System.out.println("Jumlah Jenis Usia ke " + (i + 1) + ":" + usia[i]);
        }
    }

    public static void perTahap(){
        int[] tahap = new int[3];

        for (int i = 0; i < vaksinStat.length; i++) { // usia
            for (int j = 0; j < vaksinStat[i].length; j++) { // jenis
                for (int k = 0; k < vaksinStat[i][j].length; k++) { // tahap
                    tahap[k]+=vaksinStat[i][j][k];
                }
            }
        }

        for (int i = 0; i < tahap.length; i++) {
            System.out.println("Jumlah Jenis tahap ke " + (i + 1) + ":" + tahap[i]);
        }
    }

}
