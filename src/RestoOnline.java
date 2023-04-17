import java.util.Scanner;

public class RestoOnline {
    static User users = new User();
    static Scanner input = new Scanner(System.in);
    static Login logins = new Login();
    static int pilihan;

    // Ditampilkan apabila users telah berhasil login
    public static void menuAdmin() {
        // apabila status user admin
        if (users.getStatus().equals("admin")) {
            System.out.println("Welcome Admin!");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Tambah Resto");
            System.out.println("3. Hapus Resto");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
            pilihan = Integer.parseInt(input.nextLine());
            if (pilihan == 4) {
                Login.logins(users);
            } else {
                System.exit(0);
            }
        }
    }
    public static void menuCustomer() {

        // apabila status user customer
        if (users.getStatus().equals("customer")) {
            System.out.println("Welcome Customer Tercinta!");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
            pilihan = Integer.parseInt(input.nextLine());
            if (pilihan == 4) {
                Login.logins(users);
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        int check = 2;

        System.out.println("Selamat Datang di Resto Umum!");
        System.out.println("Silakan melakukan login terlebih dahulu!");
        do {
            if (Login.logins(users)) {
                if (users.getStatus().equals("admin")) {
                    menuAdmin();
                } else if (users.getStatus().equals("customer")){
                    menuCustomer();
                }
            } else {
                System.out.println("Username atau Password Salah!");
                System.out.println("Silakan melakukan login ulang!");
                Login.logins(users);
            }
            check=1;
        } while (check==2);
    }
}