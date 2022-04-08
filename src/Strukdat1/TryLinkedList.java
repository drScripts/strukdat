package Strukdat1;
import java.util.Scanner;

public class TryLinkedList {
    static Node head;


    public static void main(String[] args) {
        addStart(20);
        addStart(2);
        insert(33);
        delete(33);
        show();
    }

    public static void addStart(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public static void insert(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (!head.hasNext()) { // kalo head ga ada next nya lansung masukin nextnya sama node baru
            head.next = newNode;
        } else {
            Node temp = head; // simpen head di temp variable
            while (temp.hasNext()) { // selama si tempnya masih ada next
                temp = head.next; // update tempnya sama nextnya sampe mampus (null)
            }
            temp.next = newNode; // tambahin si new node di node paling akhir
        }

    }

    public static void delete(int data) {
        Node temp = head, prev = null;

        // kalo node pertama datanya sama kaya parameter langsung ganti
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }

        // cari datanya
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        // kalo datanya gaada
        if (temp == null)
            return;

        // refresh node
        prev.next = temp.next;
    }

    public static void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);

            n = n.next;
        }
        System.out.println(n.data);
    }
}


class addLastDelete {
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Node head = null;
        Scanner scan = new Scanner(System.in);
        Node node = new Node();
        System.out.println(" 1. Add Last");
        System.out.println("2. Delete");
        System.out.println("3. Tampilkan");
        System.out.println("4. Keluar");
        System.out.println("===================");
        System.out.println("Masukan nomor menu");
        int menu = scan.nextInt();

        while (menu<4) {
            if (menu == 1) {
                System.out.println("Masukan NIM (0==exit)");
                String nim = scan.next();
                System.out.println("Masukan Nama ");
                String nama = scan.next();
                node.NIM = nim;
                node.NAMA = nama;
                if (head == null) {
                    head = node;
                } else {
                    Node temp = new Node();
                    temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = node;
                }
                System.out.println("Masukan nomor menu");
                menu = scan.nextInt();
            }else if(menu==2){
                System.out.println("Masukan Nim yang ingin dihilangkan / Didelete");
                String deleteNim = scan.next();
                if(deleteNim.equals(head.NIM)){
                    head=head.next;
                }else{
                    Node current = head;
                    while(current.next!=null){
                        if (current.next.NIM.equals(deleteNim)) {
                            current.next = current.next.next;
                            break;
                        } else {
                            current = current.next;
                        }
                    }
                }
                System.out.println("Masukan nomor menu");
                menu = scan.nextInt();
            }else if(menu==3){
                Node current = head;
                while(current.next != null){
                    System.out.println(current.NIM + " " + current.NAMA);
                    current=current.next;
                }

                System.out.println(current.NIM + " " + current.NAMA);
                System.out.println("Masukan nomor menu");
                menu = scan.nextInt();
            }else {
                System.out.println("TERIMAKASIH");
            }

        }
    }

}