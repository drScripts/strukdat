package Strukdat1;
import java.util.Random;
import java.util.Arrays;

public class AntarKota {
    static int[][] tolAntarKotalJumlah = new int[3][3];
    static int[][] tolAntarKotalPendapatan = new int[3][3];
    static int[] harga = {10000,20000,30000,40000,50000};
    public static void main(String[] args) {
        addToArrayJumlah();
        setTolAntarKotalPendapatan();
        getHorizontalTotal();
        getVerticalTotal();
    }

    public static void addToArrayJumlah(){
        Random rand = new Random();
        for (int i = 0; i < tolAntarKotalJumlah.length; i++) {
            for (int j = 0; j < tolAntarKotalJumlah[i].length; j++) {
                tolAntarKotalJumlah[i][j] = rand.nextInt(20);
            }
        }
    }

    public static void setTolAntarKotalPendapatan(){
        for (int i = 0; i < tolAntarKotalPendapatan.length; i++) {
            for (int j = 0; j < tolAntarKotalPendapatan[i].length; j++) {
                tolAntarKotalPendapatan[i][j] = tolAntarKotalJumlah[i][j] * harga[j];
            }
        }
    }

    public static void getHorizontalTotal(){
        for(int i = 0; i < tolAntarKotalPendapatan.length;i++){
            int totalPerJadwal = 0;
            for (int j = 0; j < tolAntarKotalPendapatan[i].length; j++) {
                totalPerJadwal+=tolAntarKotalPendapatan[i][j];
            }
            System.out.println("Jumlah Jenis Mobil Ke - " + i + " : " + totalPerJadwal);
        }
    }

    public static void getVerticalTotal(){
        int[] totalVerticalPergolongan = new int[3];

        for(int i = 0; i < tolAntarKotalPendapatan.length;i++){
            for (int j = 0; j < tolAntarKotalPendapatan[i].length; j++) {
                totalVerticalPergolongan[j]+=tolAntarKotalPendapatan[i][j];
            }
        }


        for (int i = 0; i < totalVerticalPergolongan.length; i++) {
            System.out.println("Jumlah Golongan ke " + i+1 + " : " + totalVerticalPergolongan[i]);
        }
    }

}
