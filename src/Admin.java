import java.util.*;
public class Admin {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Object> restoList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static String nama, alamat, kodeResto;
    static String namaMenu, kodeMenu;

    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        // apabila status user admin
        System.out.println("\nMenu Admin");
        System.out.println("1. Lihat Resto");
        System.out.println("2. Tambah Resto");
        System.out.println("3. Hapus Resto");
        System.out.println("4. Kembali ke halaman Login");
        System.out.print("Menu Pilihan: ");
        int pilihan = Integer.parseInt(input.nextLine());
        switch (pilihan) {
            case 1:
                showResto();
                break;
            case 2:
                addResto();
                break;
            case 3:
                deleteResto();
                break;
            case 4:
                RestoOnline.login();
                break;
            default:
                System.out.println("Input salah!");
                System.out.println("Masukkan pilihan menu yang tersedia!");
                break;
        }
    }


//1. melihat resto
    static ArrayList<String> kodeRest, namaRest, alamatRest;
    // static ArrayList<Integer> hargaMenu;
    public static void showResto() {
        for (int i = 0; i < RestoPusat.restoList.size(); i++) {
            StringTokenizer stringtok = new StringTokenizer(
                    RestoPusat.restoList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
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
            Customer.showMenu(kodeRest.get(j));
        }
        RestoOnline.pause();
        System.out.println("Enter untuk melanjutkan!");
        menuAdmin();
    }

    //2. tambah resto
    public static void addResto() {
        int harga;
        System.out.println("\nNEW RESTO!");
        System.out.println("Silakan masukkan info resto baru!");
        System.out.print("| Kode Resto      : ");
        kodeResto = input.nextLine();
        System.out.print("| Nama Resto      : ");
        nama = input.nextLine();
        System.out.print("| Alamat Resto    : ");
        alamat = input.nextLine();
        System.out.print("| Banyak Menu     : ");
        int banyak = Integer.parseInt(input.nextLine());

        System.out.println("\t\tInfo Menu Resto");
        System.out.println("Masukkan info menu sesuai jumlah banyak menu!");
        for (int i = 0; i < banyak; i++) {
            System.out.print("Kode Menu         : ");
            kodeMenu = input.nextLine();
            System.out.print("Nama Menu         : ");
            namaMenu = input.nextLine();
            System.out.print("Harga Satuan Menu : ");
            harga = Integer.parseInt(input.nextLine());
            menuList.add(Arrays.asList(kodeResto, kodeMenu, namaMenu, harga));
        }
        restoList.add(Arrays.asList(kodeResto, nama, alamat));
        System.out.println("Resto Baru Telah Ditambahkan!");
        menuAdmin();
    }

    //3. Hapus Resto
    public static void deleteResto() {
        if (restoList.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            restoList.remove(index);
        }
        System.out.println("Resto Berhasil Dihapus!");
        menuAdmin();
    }

}


