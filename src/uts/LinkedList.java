package uts;


class Node{
    char data;
    Node next;

    public boolean hasNext(){
        return next != null;
    }
}

public class LinkedList {
    static Node head;

    public static void insert(char data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.hasNext()) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public static void setHead(){
        char[] sample = {'A','B','C','D','E'};
        for (char charSample :
                sample) {
            insert(charSample);
        }
    }

    public static void infoAfter(char data){
        Node temp = head;
        if(temp.data == data){
            System.out.println("After " + data + " is " + temp.next.data);
        }else{
            while (temp.hasNext()){
                if(temp.data == data){
                    System.out.println("After " + data + " is " + temp.next.data);
                }
                temp = temp.next;
            }
        }
    }

    public static void countAfter(char data){
        int count = 0;

        Node tempFirst = head;
        if(tempFirst.data == data){
            while (tempFirst.hasNext()){
                count++;
                tempFirst = tempFirst.next;
            }

            System.out.println("Count After " + data + " is " + count);
        }else{
            boolean startSearch = false;
            Node temp = head;
            while (temp.hasNext()){
                if(temp.data == data){
                    startSearch = true;
                }
                if(startSearch){
                    count++;
                }
                temp = temp.next;
            }

            System.out.println("Count After " + data + " is " + count);
        }
    }

    public static void main(String[] args) {
        setHead();
        infoAfter('B');
        countAfter('B');
    }
}
