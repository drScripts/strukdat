package Strukdat1;

public class Node {
    String NAMA;
    String NIM;
    int data;

    Node next;

    public boolean hasNext(){
        return this.next != null;
    }
}
