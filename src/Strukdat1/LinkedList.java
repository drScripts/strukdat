package Strukdat1;

public class LinkedList {
    private Node firstNode;

    public void insertStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = firstNode;
        firstNode = node;
    }

    public void insertAt(int at, int data) {
        Node node = new Node();
        node.data = data;

        Node n = firstNode;
        int index = 0;

        if (at == 0) {
            insertStart(data);
        }else{
            while (index != at){
                n = n.next;
                index++;
            }
            Node tempNext = n.next;

            n.next = node;
            node.next = tempNext;
        }
    }

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        if (firstNode == null) {
            firstNode = node;
        } else {
            Node n = firstNode;
            while (n.hasNext()) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void show() {
        Node n = firstNode;
        while (n.hasNext()) {
            System.out.println(n.data);

            n = n.next;
        }
        System.out.println(n.data);
    }

}
