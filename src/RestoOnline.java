import java.util.Scanner;

public class RestoOnline {
    static User users = new User();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        int check = 2;
        System.out.println("Selamat Datang di Resto Umum!");
        System.out.println("Silakan melakukan login terlebih dahulu!");
        do {
            if (Login.logins(users)) {
                check = 1;
                if (users.getStatus().equals("admin")) {
                    System.out.println("Welcome Admin!");
                    Admin.menuAdmin();
                } else if (users.getStatus().equals("customer")) {
                    System.out.println("Selamat datang customer tercinta!");
                    Customer.menuCustomer();
                }
            } else {
                System.out.println("Username atau Password Salah!");
                System.out.println("Silakan melakukan login ulang!");
            }
        } while (check == 2);
    }

    public static void pause() {
        Scanner s = new Scanner(System.in);
        s.next();
    }
}