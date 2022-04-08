package Strukdat1;
import java.util.Scanner;

class AddFirst {
    static Nodes head = null;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Nodes node = new Nodes();
        System.out.println("NIM :  (0 = Berhenti )");
        String nim = scan.next();
        Nodes current = head;

        while(!nim.equals("0")){
            System.out.println("Nama : ");
            scan.nextLine();
            String nama = scan.nextLine();
            node.nim = nim;
            node.nama = nama;
            node.next = head;
            head = node;
            System.out.println("NIM :  (0 = Berhenti )");
            nim = scan.next();
        }
        System.out.println("Link List add First");
        while(current!=null){
            System.out.println(current.nim+ " " + current.nama);
            current=current.next;
        }

    }

}
class Nodes{
    String nim;
    String nama;
    Nodes next;
}
