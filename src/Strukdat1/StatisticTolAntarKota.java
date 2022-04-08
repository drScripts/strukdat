package Strukdat1;
import java.util.Random;
import java.util.Arrays;

public class StatisticTolAntarKota {
    static int[][][] tol = new int[5][5][3];

    public static void main(String[] args) {
        addToArray();
        tolAsalTujuan(1,2);
        tolAsalGol(1,1);
        tolGol(1);
    }

    public static void addToArray( ) {
        Random rand = new Random();
        for (int i = 0; i < tol.length; i++) {
            for (int j = 0; j < tol[i].length; j++) {
                for (int k = 0; k < tol[i][j].length; k++) {
                    tol[i][j][k] = rand.nextInt(20);
                }
            }
        }
    }

    public static void tolAsalTujuan(int asal, int tujuan) {
        int total = 0;
        for (int i = 0; i < tol[asal][tujuan].length; i++) {
            total+=tol[asal][tujuan][i];
        }
        System.out.println("Jumlah Mobil Dari Asal " + asal + " ke Tujuan " + tujuan + " Sebanyak " + total );
    }

    public static void tolAsalGol(int asal,int gol){
        int total = 0;
        for (int i = 0; i < tol[asal].length; i++) {
            total+=tol[asal][i][gol];
        }

        System.out.println("Jumlah Mobil Dari Asal " + asal + " dan Gol ke " + gol + " Sebanyak " + total);
    }

    public static void tolGol(int gol){
        int total = 0;
        for (int i = 0; i < tol.length; i++) {
            for (int j = 0; j < tol[i].length; j++) {
                total+=tol[i][j][gol];
            }
        }
        System.out.println("Jumlah Mobil Dari Golongan ke " + gol + " Sebanyak " + total);
    }

}
