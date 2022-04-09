package TubesKasir;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Random;

public class Main {
    static HashMap<Integer, Double> diskon = new HashMap<>();
    static int maxWaiting = 7;
    static Admin admin = new Admin();
    static int counter = 0;
    static double disc = 0;
    static Makanan[] makanan = new Makanan[5];
    static Makanan[] minuman = new Makanan[5];
    static int counts = counter;

    static Client[] clients = new Client[5];

    static SQueue queue = new SQueue(maxWaiting);

    static {
        // --Init Makanan--
        makanan[0] = new Makanan("Indomie", 5000);
        makanan[1] = new Makanan("Spaghetti", 15000);
        makanan[2] = new Makanan("Macaroni", 10000);
        makanan[3] = new Makanan("Pizza", 20000);
        makanan[4] = new Makanan("Ga Beli", 0);
        minuman[0] = new Makanan("Air Mineral", 5000);
        minuman[1] = new Makanan("Kopi Hitam", 3000);
        minuman[2] = new Makanan("Teh botol", 10000);
        minuman[3] = new Makanan("Susu Murni", 15000);
        minuman[4] = new Makanan("Ga beli", 0);
    }
    // totalharga = minuman[pilihMinum - 1].harga * jumlahbelinya;

    static void initDiskon() {
        diskon.put(1, 0.05);
        diskon.put(2, 0.01);
        diskon.put(3, 0.01);
        diskon.put(4, 0.01);
        diskon.put(5, 0.01);
        diskon.put(6, 0.1);
        diskon.put(7, 0.2);
        diskon.put(8, 0.05);
        diskon.put(9, 0.05);
        diskon.put(10, 0.1);
    }

    static String textMinumanString() {
        String menu = "";
        for (int i = 0; i < minuman.length; i++) {
            menu += "\n" + (i + 1) + " " + (minuman[i].nama + " " + minuman[i].harga);
        }
        return menu;
    }

    static void mainMenu() {
        int menu;
        do {
            menu = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "1. Masuk\n2. Admin\n3. Waiting List\n4. Exit"));
            switch (menu) {
                case 1:
                    masuk();
                    break;
                case 2:
                    validateAdmin(admin);
                    break;
                case 3:
                    showWaitingList();
                    break;
            }
        } while (menu != 4);
        queue.print();
        System.exit(0);
    }

    static void masuk() {
        String name = JOptionPane.showInputDialog(null, "Masukkan nama : ");


        int queueIndex = queue.search(name);

        if (queueIndex == -1) {
            if (counter <= 4) {
                clients[counter].username = name;
                if (clients[counter].keranjang.jumlah[0][0] == 0) {
                    counter += 1;
                    menuUser();
                } else {
                    queue.insert(clients[counter]);
                }
            } else {
                waitingList(name);
            }
        } else {
            int slotIndex = slotCheck();
            if (slotIndex != -1) {
                menuUser(queueIndex);
            } else {
                JOptionPane.showMessageDialog(null, "Maaf restoran sedang Penuh!", "Restoran Status", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static int slotCheck() {
        int index = -1;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                return i;
            }
        }
        return index;
    }


    static void menuUser() {
        int menu = 0;
        while (menu != 4) {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu : \n" +
                    "1. Makanan dan Minuman \n" +
                    "2. Konfirmasi \n" +
                    "3. Cek Diskon\n" +
                    "4. Exit\n\n" +
                    "Masukkan menu : "));
            switch (menu) {
                case 1:
                    menuMakanan();
                    break;
                case 2:
                    menuKonfirmasi();
                    break;
                case 3:
                    validateDiskon();
                    break;
                case 4:
                    mainMenu();
                    break;
            }
        }
    }

    static void menuUser(int index) {
        int menu = 0;
        while (menu != 4) {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu : \n" +
                    "1. Makanan dan Minuman \n" +
                    "2. Konfirmasi \n" +
                    "3. Cek Diskon\n" +
                    "4. Exit\n\n" +
                    "Masukkan menu : "));
            switch (menu) {
                case 1:
                    menuMakanan(index);
                    break;
                case 2:
                    menuKonfirmasi(index);
                    break;
                case 3:
                    validateDiskon(index);
                    break;
                case 4:
                    mainMenu();
                    break;
            }
        }
    }

    static void validateDiskon() {
        if (clients[counter - 1].keranjang.totalKeranjang >= 500000) {
            disc = gachaDiskon();
            JOptionPane.showMessageDialog(null, "SELAMAT ANDA MENDAPATKAN DISKON SEBESAR " + disc,
                    "Discount Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Pembelanjaan anda : " + clients[counter - 1].keranjang.totalKeranjang
                            + "\n Tidak dapat diskon, karena pembelian tidak melebihi Rp. 500.000",
                    "Discount Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static void validateDiskon(int index) {
        if (clients[index].keranjang.totalKeranjang >= 500000) {
            disc = gachaDiskon();
            JOptionPane.showMessageDialog(null, "SELAMAT ANDA MENDAPATKAN DISKON SEBESAR " + disc,
                    "Discount Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Pembelanjaan anda : " + clients[index].keranjang.totalKeranjang
                            + "\n Tidak dapat diskon, karena pembelian tidak melebihi Rp. 500.000",
                    "Discount Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static String textMakananString() {
        String menu = "";
        for (int i = 0; i < makanan.length; i++) {
            menu += "\n" + (i + 1) + " " + (makanan[i].nama + " " + makanan[i].harga);
        }
        return menu;
    }

    static void menuKonfirmasi() {
        String menuMakanan = "";
        String menuMinuman = "";
        for (int i = 0; i < clients[counter - 1].keranjang.jumlah[0].length; i++) {
            if (clients[counter - 1].keranjang.jumlah[0][i] != 0) {
                menuMakanan = makanan[i].nama + " dengan jumlah : " + clients[counter - 1].keranjang.jumlah[0][i]
                        + "\n";
            }
        }
        for (int i = 0; i < clients[counter - 1].keranjang.jumlah[0].length; i++) {
            if (clients[counter - 1].keranjang.jumlah[1][i] != 0) {
                menuMinuman = minuman[i].nama + " dengan jumlah : " + clients[counter - 1].keranjang.jumlah[1][i]
                        + "\n";
            }
        }
        clients[counter - 1].keranjang.totalKeranjang = ((clients[counter - 1].keranjang.totalKeranjang)
                - (clients[counter - 1].keranjang.totalKeranjang * disc));
        int validate = JOptionPane.showConfirmDialog(null, "Pesanan anda adalah : "
                        + "\nMakanan : " + menuMakanan
                        + "\nMinuman : " + menuMinuman
                        + "\nDiskon  : " + disc
                        + "\nTotal Belanja : " + clients[counter - 1].keranjang.totalKeranjang, "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (validate == JOptionPane.YES_OPTION) {
            admin.penghasilan += clients[counter - 1].keranjang.totalKeranjang;
            for (int i = 0; i < 4; i++) {
                admin.total.penjualan[0][i] += clients[counter - 1].keranjang.jumlah[0][i];
                admin.total.penjualan[1][i] += clients[counter - 1].keranjang.jumlah[1][i];
            }

        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    clients[counter - 1].keranjang.jumlah[i][j] = 0;
                }
            }
            clients[counter - 1].keranjang.totalKeranjang = 0;
            menuUser();
        }
    }

    static void menuKonfirmasi(int index) {
        String menuMakanan = "";
        String menuMinuman = "";
        for (int i = 0; i < clients[index].keranjang.jumlah[0].length; i++) {
            if (clients[index].keranjang.jumlah[0][i] != 0) {
                menuMakanan = makanan[i].nama + " dengan jumlah : " + clients[index].keranjang.jumlah[0][i]
                        + "\n";
            }
        }
        for (int i = 0; i < clients[index].keranjang.jumlah[0].length; i++) {
            if (clients[index].keranjang.jumlah[1][i] != 0) {
                menuMinuman = minuman[i].nama + " dengan jumlah : " + clients[index].keranjang.jumlah[1][i]
                        + "\n";
            }
        }
        clients[index].keranjang.totalKeranjang = ((clients[index].keranjang.totalKeranjang)
                - (clients[index].keranjang.totalKeranjang * disc));
        int validate = JOptionPane.showConfirmDialog(null, "Pesanan anda adalah : "
                        + "\nMakanan : " + menuMakanan
                        + "\nMinuman : " + menuMinuman
                        + "\nDiskon  : " + disc
                        + "\nTotal Belanja : " + clients[index].keranjang.totalKeranjang, "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (validate == JOptionPane.YES_OPTION) {
            admin.penghasilan += clients[index].keranjang.totalKeranjang;
            for (int i = 0; i < 4; i++) {
                admin.total.penjualan[0][i] += clients[index].keranjang.jumlah[0][i];
                admin.total.penjualan[1][i] += clients[index].keranjang.jumlah[1][i];
            }

        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    clients[index].keranjang.jumlah[i][j] = 0;
                }
            }
            clients[index].keranjang.totalKeranjang = 0;
            menuUser(index);
        }
    }

    static void menuMakanan() {
        int inputMakanan = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Menu makanan :  " + textMakananString()));

        if (inputMakanan != 0) {
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Jumlah yang ingin dibeli :"));
            clients[counter - 1].keranjang.jumlah[0][inputMakanan - 1] = jumlah;
            clients[counter - 1].keranjang.totalKeranjang += makanan[inputMakanan - 1].harga * jumlah;
        }

        int inputMinuman = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu minuman : " + textMinumanString()));
        if (inputMinuman != 0) {
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Jumlah yang ingin dibeli :"));
            clients[counter - 1].keranjang.jumlah[1][inputMinuman - 1] = jumlah;
            clients[counter - 1].keranjang.totalKeranjang += minuman[inputMinuman - 1].harga * jumlah;
        }
    }

    static void menuMakanan(int index) {
        int inputMakanan = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Menu makanan :  " + textMakananString()));

        if (inputMakanan != 0) {
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Jumlah yang ingin dibeli :"));
            clients[index].keranjang.jumlah[0][inputMakanan - 1] = jumlah;
            clients[index].keranjang.totalKeranjang += makanan[inputMakanan - 1].harga * jumlah;
        }

        int inputMinuman = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu minuman : " + textMinumanString()));
        if (inputMinuman != 0) {
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Jumlah yang ingin dibeli :"));
            clients[index].keranjang.jumlah[1][inputMinuman - 1] = jumlah;
            clients[index].keranjang.totalKeranjang += minuman[inputMinuman - 1].harga * jumlah;
        }
    }

    static boolean IsFull(SQueue queue) {
        return queue.tail == queue.clients.length - 1;
    }

    static void waitingList(String name) {
        if (IsFull(queue)) {
            JOptionPane.showMessageDialog(null, "Antrian Penuh", "Queue Status", JOptionPane.ERROR_MESSAGE);
        } else {
            int ask = JOptionPane.showConfirmDialog(null, "Apakah anda ingin masuka antrian atau tidak");
            switch (ask) {
                case JOptionPane.YES_OPTION:
                    Client client = new Client();
                    client.username = name;
                    if (queue.tail == -1) {
                        queue.tail++;
                        queue.clients[queue.head + 1] = client;
                        queue.head += 1;
                    } else {
                        queue.clients[queue.tail + 1] = client;
                        queue.tail += 1;
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }

    static void showWaitingList() {
        String print = "";
        if (queue.head == -1) {
            JOptionPane.showMessageDialog(null, "Antrian Kosong", "Queue Status", JOptionPane.ERROR_MESSAGE);
            menuUser();
        } else {
            for (int i = queue.head; i <= queue.tail; i++) {// i = 0
                print += (i + 1) + ". " + (queue.clients[i].username + " ");
            }
            JOptionPane.showMessageDialog(null, print, "Queue Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ---------------------------------------------------------- MENU ADMIN
    // ---------------------------------------------------------- //

    static void validateAdmin(Admin admin) {
        int gagal = 3;
        while (gagal != 0) {
            String user = JOptionPane.showInputDialog(null, "Masukkan user");
            String pass = JOptionPane.showInputDialog(null, "Masukkan password");

            if (user.equals(admin.username) && pass.equals(admin.password)) {
                JOptionPane.showMessageDialog(null, "LOGIN ADMIN BERHASIL");
                menuAdmin();
            } else {
                JOptionPane.showMessageDialog(null, "ANDA SIAPA? Kesempatan : " + gagal);
                gagal--;
            }
        }
        mainMenu();
    }

    static void menuAdmin() {
        int menus = 0;
        while (menus != 5) {
            menus = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu : \n" +
                    "1. Hitung Pendapatan\n" +
                    "2. Status Makanan \n" +
                    "3. Delete Antrian \n" +
                    "4. Logout\n" +
                    "5. Exit\n\n" +
                    "Masukkan menu : "));
            switch (menus) {
                case 1:
                    hitungPendapatan();
                    break;
                case 2:
                    penjualanMakanan();
                    break;
                case 3:
                    deleteAntrian();
                    break;
                case 4:
                    mainMenu();
                    break;
            }
        }
    }

    static void hitungPendapatan() {
        JOptionPane.showMessageDialog(null, "Total penghasilan yang didapat : Rp." + admin.penghasilan);
        menuAdmin();
    }

    static void penjualanMakanan() {
        JOptionPane.showMessageDialog(null, "---- Makanan ----"
                + "\nIndomie : x" + admin.total.penjualan[0][0]
                + "\nSpaghetti : x" + admin.total.penjualan[0][1]
                + "\nMacaroni : x" + admin.total.penjualan[0][2]
                + "\nPizza : x" + admin.total.penjualan[0][3]
                + "\n\n---- Minuman ----"
                + "\nAir Mineral : x" + admin.total.penjualan[1][0]
                + "\nKopi Hitam : x" + admin.total.penjualan[1][1]
                + "\nTeh Botol : x" + admin.total.penjualan[1][2]
                + "\nSusu Murni : x" + admin.total.penjualan[1][3], "Total Penjualan", JOptionPane.INFORMATION_MESSAGE);
    }

    static boolean IsEmpty(SQueue queue) {
        return queue.head == -1;
    }

    static void deleteAntrian() {
        String output = "";
        if (IsEmpty(queue)) {
            if (counts == 5) {
                counts = 0;
            }
            clients[counts].username = output;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    clients[counts].keranjang.jumlah[i][j] = 0;
                }
            }
            counts = counter;
            JOptionPane.showMessageDialog(null, "Antrian kosong", "Info Antrian : ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (counts == 5) {
                counts = 0;
            }
            if (queue.tail == 0) {
                output += queue.clients[queue.head];
                queue.head = -1;
                queue.tail = -1;
            } else if (queue.head <= queue.tail) {
                output += queue.clients[queue.head].username;
                for (int i = queue.head + 1; i <= queue.tail; i++) {
                    queue.clients[queue.head] = queue.clients[i];
                    queue.head++;
                }
            }
            queue.tail--;
            queue.head = 0;

            clients[counts].username = output;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    clients[counts].keranjang.jumlah[i][j] = 0;
                }
            }
            clients[counts].keranjang.totalKeranjang = 0;
            counts++;
        }
        menuAdmin();
    }

    static double gachaDiskon() {
        int value;
        Random rand = new Random();
        value = rand.nextInt(10);
        return diskon.get(value);

    }

    public static void main(String[] args) {
        queue.head = -1;
        queue.tail = -1;
        for (int i = 0; i < 5; i++) {
            clients[i] = new Client();
            clients[i].keranjang = new Keranjang();
        }
        initDiskon();
        mainMenu();

    }
}
