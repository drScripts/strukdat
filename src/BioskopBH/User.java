package BioskopBH;

public class User {
    static UserNode head;

    public UserNode insertUser (String email,String password,String fullName){
        UserNode newNode = new UserNode(email,fullName,password);

        if(head == null){
            head = newNode;
        }else{
            UserNode temp = head;
            while (temp.hasNext()){
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }

        return  newNode;
    }

    public UserNode searchUser(String email){
        UserNode value = null;
        if(head != null){
            if(head.email.equals(email)){
                value = head;
            }else{
                UserNode temp = head;
                boolean isSearch = true;
                while (temp.hasNext() && isSearch){
                    if(temp.email.equals(email)){
                        value = temp;
                        isSearch = false;
                    }
                    temp = temp.getNext();
                }
            }
        }

        return value;
    }

}













