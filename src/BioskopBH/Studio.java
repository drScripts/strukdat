package BioskopBH;

public class Studio {
    private StudioNode head;

    public void insert(Film film) {
        StudioNode newNode = new StudioNode();
        newNode.film = film;
        if (head == null) {
            head = newNode;
        }else{
            StudioNode temp = head;
            while (temp.hasNext()){
             temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public StudioNode getSelectedStudio(int index){
        StudioNode selected = head;
        int current = 0;

        if(head != null){
            while (index != current){
                selected = selected.next;
                current++;
            }
        }

        return selected;
    }

    public String getStringAllName(){
        String nameFilm = "";
        int counter = 1;

        if(head != null){
            StudioNode temp = head;
            nameFilm += counter + ". " + temp.film.name + " - " + temp.film.jadwal + "\n";
            while (temp.hasNext()){
                counter++;
                nameFilm += counter + ". " + temp.film.name + " - " + temp.film.jadwal + "\n";
                temp = temp.next;
            }
        }

        return nameFilm;
    }
}

