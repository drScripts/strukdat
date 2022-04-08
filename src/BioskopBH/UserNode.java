package BioskopBH;

public class UserNode {
    String email;
    String fullName;
    String password;
    private UserNode next;

    UserNode(String email,String fullName,String password){
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

    public UserNode getNext() {
        return next;
    }
}
