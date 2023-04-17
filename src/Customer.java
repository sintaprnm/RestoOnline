import java.util.*;
public class Customer {
    public static void menuCustomer() {
        Scanner input = new Scanner(System.in);
        // apabila status user customer
            System.out.println("Welcome Customer Tercinta!");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
        int pilihan = Integer.parseInt(input.nextLine());
        switch(pilihan) {
            case 1:
                System.out.println("Lihat resto");
                break;
            case 2:
                System.out.println("tambah pesanan");
                break;
            case 3:
                System.out.println("lihat pesanan");
                break;
            case 4:
                RestoOnline.login();
                break;
            default:
                System.out.println("yyyyy");
                break;
        }
    }
}

