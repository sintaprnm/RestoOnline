import java.util.Scanner;

public class Login {
    static Scanner input = new Scanner(System.in);

    public static boolean logins(User users) {
        boolean cek = false;
        users.setUsername("admin");
        users.setPassword("admin");

        users.setUsernameCust("customer");
        users.setPasswordCust("customer");

        //layar user
        String username, password;
        System.out.print("Masukkan username: ");
        username = input.nextLine();
        System.out.print("Masukkan password: ");
        password = input.nextLine();

        //proses
        if (users.getUsername().equals(username) || users.getUsernameCust().equals(username)) {
            if (users.getPassword().equals(password)) {
                users.setStatus("admin");
                cek = true;
            } else if (users.getPasswordCust().equals(password)) {
                users.setStatus("customer");
                cek = true;
            }
        }
        return cek;
    }
}