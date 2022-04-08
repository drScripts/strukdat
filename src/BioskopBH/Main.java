package BioskopBH;


import javax.swing.*;

public class Main {
    static Bioskop pusat = new Bioskop();
    static Bioskop tupai = new Bioskop();

    static Bioskop[] bioskop;
    static User users = new User();

    public static void initBioskop() {
        Studio pusatStudio = new Studio();
        Film starWars1 = new Film("Star Wars 1", "action", 120, 45000, "26 December 2022");
        Film starWars2 = new Film("Star Wars 2", "action", 120, 45000, "26 December 2022");
        Film starWars3 = new Film("Star Wars 3", "action", 120, 45000, "26 December 2022");
        pusatStudio.insert(starWars1);
        pusatStudio.insert(starWars2);
        pusatStudio.insert(starWars3);

        Studio tupaiStudio = new Studio();
        Film jkt1 = new Film("JKT 48 K", "fanboy", 120, 45000, "26 December 2022");
        Film jkt2 = new Film("JKT 48 T", "fanboy", 120, 45000, "26 December 2022");
        Film jkt3 = new Film("JKT 48 III", "fanboy", 120, 45000, "26 December 2022");
        Film jkt4 = new Film("JKT 48 JMT", "fanboy", 120, 45000, "26 December 2022");
        Film jkt5 = new Film("JKT 48", "fanboy", 120, 45000, "26 December 2022");
        tupaiStudio.insert(jkt1);
        tupaiStudio.insert(jkt2);
        tupaiStudio.insert(jkt3);
        tupaiStudio.insert(jkt4);
        tupaiStudio.insert(jkt5);

        pusat.studio = pusatStudio;
        pusat.name = "PUSAT";
        pusat.alamat = "PUSAT";

        tupai.studio = tupaiStudio;
        tupai.name = "TUPAi";
        tupai.alamat = "TUPAi";

        bioskop = new Bioskop[]{pusat, tupai};
    }


    public static UserNode register() {
        String email = JOptionPane.showInputDialog("Masukan email: ");
        String password = JOptionPane.showInputDialog("Masukan Password: ");
        String fullName = JOptionPane.showInputDialog("Masukan Nama Lengkap: ");

        return users.insertUser(email, password, fullName);
    }

    public static UserNode login() {
        String email = JOptionPane.showInputDialog("Masukan Email: ");
        String password = JOptionPane.showInputDialog("Masukan Password: ");

        UserNode user = users.searchUser(email);
        UserNode verifyUser = null;
        if (user == null) {
            System.out.println("User tidak ditemukan");
        } else {
            if (user.password.equals(password)) {
                verifyUser = user;
            } else {
                System.out.println("Password Salah");
            }
        }
        return verifyUser;
    }

    public static int getSelectedBioskop() {
        String dialogString = "Silahkan Pilih Bioskop : \n";
        for (int i = 0; i < bioskop.length; i++) {
            dialogString += (i + 1) + ". " + bioskop[i].name + "\n";
        }

        return Integer.parseInt(JOptionPane.showInputDialog(dialogString));
    }

    public static int getSelectedStudio(int bioskopi) {
        Bioskop bioskopS = bioskop[bioskopi];
        String dialogString = "Silahkan Pilih Film :\n";
        dialogString += bioskopS.studio.getStringAllName();

        return Integer.parseInt(JOptionPane.showInputDialog(dialogString));
    }

    public static StudioNode selectChair(UserNode user, StudioNode studio) {
        studio.initSeat();
        Seat[][] seatRow = studio.seats;
        String dialogString = "Select Seats Row:\n";
        for (int i = 0; i < seatRow.length; i++) {
            dialogString += (i + 1) + ". " + "Baris ke-" + (i + 1) + "\n";
        }

        int selectedRow = Integer.parseInt(JOptionPane.showInputDialog(dialogString));

        dialogString = "Select Available Seats : \n";

        for (int i = 0; i < seatRow[selectedRow - 1].length; i++) {
            if (seatRow[selectedRow - 1][i].isAvailable()) {
                dialogString += "Kursi ke-" + (i + 1) + "\n";
            }
        }

        int selectedSeat = Integer.parseInt(JOptionPane.showInputDialog(dialogString));

        Seat seat = seatRow[selectedRow-1][selectedSeat-1];

        if(seat.userBookedBy != null){
            System.out.println(seat.userBookedBy.fullName);
        }else{
            System.out.println("Belum");
        }

        seatRow[selectedRow - 1][selectedSeat - 1].setUserBookedBy(user);

        JOptionPane.showMessageDialog(null, "Success Booking", "Success", JOptionPane.INFORMATION_MESSAGE);
        return studio;
    }

    public static void mainMenu(UserNode user) {
        boolean isExit = false;
        while (!isExit) {
            String dialogString = "Menu : \n1.Booking Film\n2.Log out";

            int userSelect = Integer.parseInt(JOptionPane.showInputDialog(dialogString));
            if (userSelect == 2) {
                isExit = true;
            } else {
                int selectedBioskop = getSelectedBioskop();
                int selectedStudio = getSelectedStudio(selectedBioskop);
                StudioNode newStudio = selectChair(user, bioskop[selectedBioskop].studio.getSelectedStudio(selectedStudio));

            }

        }
    }

    public static void main(String[] args) {
        initBioskop();

        boolean isExit = false;
        while (!isExit) {
            String dialogMain = "Menu  : \n1.Login\n2.Register\n3.Exit";
            int selected = Integer.parseInt(JOptionPane.showInputDialog(dialogMain));
            switch (selected) {
                case 1:
                    UserNode user = login();
                    if (user != null) {
                        mainMenu(user);
                    }
                    break;
                case 2:
                    UserNode userNode = register();
                    mainMenu(userNode);
                    break;
                default:
                    isExit = true;
                    break;
            }

        }

    }
}
















