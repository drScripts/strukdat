package uts;

import java.util.Random;
import java.util.Scanner;

public class Nomer1 {
    static int[][][] kampusITHB = new int[20][10][2];

    public static void hitungJumlahjurusanTertentuPerJenisKelamin(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Jurusan ke berapa? ");
        int jurusan = scan.nextInt();
        for (int i = 0; i < kampusITHB.length; i++) {
            int perempuan = kampusITHB[i][jurusan][0];
            int lakiLaki = kampusITHB[i][jurusan][1];
            System.out.println("Angkatan ke- " + (i+1) +"Jumlah mahasiswa perempuan : " + perempuan + " Jumlah mahasiswa laki-laki: " + lakiLaki);
        }
    }

    public static void setKampusITHB(){
        for (int i = 0; i < kampusITHB.length; i++) {
            for (int j = 0; j < kampusITHB[i].length; j++) {
                for (int k = 0; k < kampusITHB[i][j].length; k++) {
                    Random rand = new Random();
                    kampusITHB[i][j][k] = rand.nextInt(200) + 1;
                }
            }
        }
    }

    public static void angkatanTerbanyak(){
        int indexTerbanyak = 0;
        int tempJumlah = 0;

        for (int i = 0; i < kampusITHB.length; i++) {
            int jumlah = 0;
            for (int j = 0; j < kampusITHB[i].length; j++) {
               jumlah+= kampusITHB[i][j][0] + kampusITHB[i][j][1];
            }

            if(jumlah > tempJumlah){
                tempJumlah = jumlah;
                indexTerbanyak = i;
            }
        }

        System.out.println("Angkatan dengan murdi terbanyak angkatan ke-" + (indexTerbanyak+1) + " dengan jumlah " + tempJumlah);
    }

    public static void main(String[] args) {
        setKampusITHB();

        hitungJumlahjurusanTertentuPerJenisKelamin();
        angkatanTerbanyak();
    }

 }










