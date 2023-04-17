import java.util.Scanner;

public class RestoOnline {
    static User users = new User();
    static Scanner input = new Scanner(System.in);
    static Login logins = new Login();
    static int pilihan;

    // Ditampilkan apabila users telah berhasil login

    public static void main(String[] args) {
        login();
}

public static void login(){int check=2;
    System.out.println("Selamat Datang di Resto Umum!");
    System.out.println("Silakan melakukan login terlebih dahulu!");
    do {
        if (Login.logins(users)) {
            check=1;
            if (users.getStatus().equals("admin")) {
                Admin.menuAdmin();
            } else if (users.getStatus().equals("customer")){
                Customer.menuCustomer();
            }
        } else {
            System.out.println("Username atau Password Salah!");
            System.out.println("Silakan melakukan login ulang!");
        }
    } while (check==2);
}
}
