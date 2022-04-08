package BioskopBH;

public class StudioNode {
    Film film;
    Seat[][] seats ;
    StudioNode next;

    public boolean hasNext() {
        return next != null;
    }

    public void initSeat() {
        seats = new Seat[6][5];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat();
            }
        }
    }
}
