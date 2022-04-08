package BioskopBH;

public class Film {
    String name;
    String genre;
    int durasi;
    int harga;
    String jadwal;

    Film(String name,String genre,int durasi, int harga,String jadwal){
        this.name = name;
        this.genre = genre;
        this.durasi = durasi;
        this.harga = harga;
        this.jadwal = jadwal;
    }
}
