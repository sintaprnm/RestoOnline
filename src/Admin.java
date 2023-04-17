import java.util.*;
public class Admin {
    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        // apabila status user admin
        System.out.println("Welcome Admin!");
        System.out.println("1. Lihat Resto");
        System.out.println("2. Tambah Resto");
        System.out.println("3. Hapus Resto");
        System.out.println("4. Kembali ke halaman Login");
        System.out.print("Menu Pilihan: ");
        int pilihan = Integer.parseInt(input.nextLine());
        switch (pilihan) {
            case 1:
                System.out.println("liat resto");
                break;
            case 2:
                System.out.println("tambah resto");
                break;
            case 3:
                System.out.println("hapus resto");
                break;
            case 4:
                RestoOnline.login();
                break;
            default:
                System.out.println("yyyyy");
                break;
        }
    }

    static ArrayList<String> kodeRest, namaRest, alamatRest;
    // static ArrayList<Integer> hargaMenu;
    public static void showResto() {
        for (int i = 0; i < restoList.size(); i++) {
            StringTokenizer stringtok = new StringTokenizer(
                    restoList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            kodeRest.add(stringtok.nextToken());
            namaRest.add(stringtok.nextToken());
            alamatRest.add(stringtok.nextToken());
        }
        for (int j = 0; j < kodeRest.size(); j++) {
            System.out.print("Index: ");
            System.out.println(j);
            System.out.print("Kode Resto: ");
            System.out.println(kodeRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Nama Resto: ");
            System.out.println(namaRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Alamat Resto: ");
            System.out.println(alamatRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            showMenu(kodeRest.get(j));
        }
    }


}


