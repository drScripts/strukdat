package BioskopBH;

public class Seat {
    UserNode userBookedBy;

    public boolean isAvailable(){
        return userBookedBy == null;
    }

    public void setUserBookedBy(UserNode userBookedBy) {
        this.userBookedBy = userBookedBy;
    }
}
