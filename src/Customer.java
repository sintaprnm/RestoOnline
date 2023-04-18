import java.util.*;
public class Customer {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Object> restoList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static String nama, alamat, kodeResto;
    static String namaMenu, kodeMenu;
    
    public static void menuCustomer() {
        Scanner input = new Scanner(System.in);
        // apabila status user customer
            System.out.println("Menu Customer");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
        int pilihan = Integer.parseInt(input.nextLine());
        switch(pilihan) {
            case 1:
                showResto();
                break;
            case 2:
                addPesanan();
                break;
            case 3:
                showPesanan();
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

    private static void showResto() {
    }

    //1. melihat resto
    static ArrayList<String> kodeRest, namaRest, alamatRest;
    // static ArrayList<Integer> hargaMenu;
    public static void showResto(String s) {
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
            showResto(kodeRest.get(j));
        }
    }

//2. buat pesanan
    static ArrayList<Object> orderList = new ArrayList<Object>();
    public static void addPesanan() {
        int jarak = (int) (Math.random()*3) + 2;
        System.out.print("Masukan kode resto: ");
        kodeResto = input.nextLine();
        showResto(kodeResto);
        int[] harga = new int[100];
        int[] sub_total = new int[100];
        int[] kuantitas = new int[100];
        String[] menu = new String[100];
        String[] kode = new String[100];
        String[] kode_menu = new String[100];
        int total = 0;
        // proses pemesanan
        StringTokenizer stringtok = null;
        for (int i = 0; i < menuList.size(); i++) {
            stringtok = new StringTokenizer(menuList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            if (kodeResto.equals(stringtok.nextToken())) {
                kode[i] = stringtok.nextToken().trim();
                menu[i] = stringtok.nextToken().trim();
                harga[i] = Integer.parseInt(stringtok.nextToken().trim());
            }
        }
        System.out.print("Banyak Pesanan: ");
        int banyak = Integer.parseInt(input.nextLine());
        for (int i = 0; i < banyak; i++) {
            System.out.print("Masukkan kode menu: ");
            kode_menu[i] = input.nextLine();
            System.out.print("Kuantitas: ");
            kuantitas[i] = Integer.parseInt(input.nextLine());
            if (kode_menu[i].equals(kode[i])) {
                sub_total[i] = kuantitas[i] * harga[i];
                System.out.println("Sub Total: "+sub_total[i]);
            }
            total += sub_total[i];
            orderList.add(Arrays.asList(jarak, kodeResto, kode_menu[i], kuantitas[i], sub_total[i]));
        }
        System.out.println("Total Pemesanan: " + total);

    }

//3. lihat pesanan
    public static void showPesanan() {
        StringTokenizer stringtok = null;
        for (int i = 0; i < orderList.size(); i++) {
            stringtok = new StringTokenizer(orderList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            System.out.print("Jarak: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kode Resto: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kode Menu: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kuantitas: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Sub Total: ");
            System.out.println(stringtok.nextToken());
        }
        System.out.println(orderList.toString());
        System.out.println(orderList.size());
    }

    public static void showMenu(String s) {
    }
}

