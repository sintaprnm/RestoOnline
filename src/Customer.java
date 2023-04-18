import java.util.*;
public class Customer {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Object> restoList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static ArrayList<RestoPusat> restolist = new ArrayList<>();
//    static String namaResto, alamatResto, kodeResto, jarak;
//    static String namaMenu, kodeMenu;

    public static void menuCustomer() {
        Scanner input = new Scanner(System.in);
        // apabila status user customer
        int ulang = 1;
        do {
            System.out.println("Menu Customer");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    RestoPusat.showRestaurant();
                    break;
                case 2:
                    addPesanan();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:
                    RestoOnline.login();
                    break;
                default:
                    System.out.println("Input salah!");
                    System.out.println("Masukkan pilihan menu yang tersedia!");
                    break;
            }
            System.out.println("\nApakah anda ingin kembali ke menu? (1/2) \n1. Ya \n2. Tidak");
            ulang = input.nextInt();
        } while (ulang == 1);
    }


//2. add order
    public static void addPesanan() {
        //List restoran yang tersedia
        RestoPusat.showRestaurant();

        //Memilih restoran
        System.out.print("Pilih restoran : ");
        Scanner scanner = new Scanner(System.in);

        String selectedRestaurant = scanner.nextLine();

        RestoPusat chosenRestaurant = null;
        for (RestoPusat restaurant : restolist) {
            if (selectedRestaurant.equalsIgnoreCase(restaurant.getName())) {
                chosenRestaurant = restaurant;
//                System.out.println(restaurant);
                break;
            }
            System.out.println(restaurant);
        }
        //tampilan menu untuk memesan
        if (chosenRestaurant != null) {
            ArrayList<String> menus = chosenRestaurant.getMenus();
            ArrayList<Double> prices = chosenRestaurant.getPrice();

            System.out.println("Menu " + chosenRestaurant.getName() + ":");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i) + " - Rp " + prices.get(i));
            }

            // Memilih menu
            ArrayList<String> cartMenus = new ArrayList<>();
            ArrayList<Double> cartPrices = new ArrayList<>();
            boolean continueOrdering = true;
            while (continueOrdering) {
                System.out.print("Pilih nomor menu: ");
                int menuNumber = scanner.nextInt();
                scanner.nextLine();
                cartMenus.add(menus.get(menuNumber - 1));
                cartPrices.add(prices.get(menuNumber - 1));

                System.out.print("Tambah pesanan lagi? (y/n): ");
                String answer = scanner.nextLine();
                continueOrdering = answer.equalsIgnoreCase("y");
            }
            System.out.println("Masukkan jarak: ");
            int jarak = input.nextInt();

            // Menampilkan daftar pesanan dan total harga
            System.out.println("Pesanan Anda:");
            double totalPrice = 0;
            for (int i = 0; i < cartMenus.size(); i++) {
                System.out.println("- " + cartMenus.get(i) + " - Rp " + cartPrices.get(i));
                totalPrice += cartPrices.get(i);
            }
            System.out.println("Total harga: Rp " + totalPrice);
        } else {
            System.out.println("Restoran tidak ditemukan.");
        }
    }

    //3. lihat pesanan
    public static void showOrder() {
        System.out.println(restoList.size());
        ArrayList kodeResto = new ArrayList<>();
        ArrayList namaResto = new ArrayList<>();
        ArrayList alamatResto = new ArrayList<>();
        for (int i = 0; i < restoList.size(); i++) {
            StringTokenizer stringtok = new StringTokenizer(
                    restoList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            kodeResto.add(stringtok.nextToken());
            namaResto.add(stringtok.nextToken());
            alamatResto.add(stringtok.nextToken());
        }
        for (int j = 0; j < kodeResto.size(); j++) {
            System.out.print("Index: ");
            System.out.println(j);
            System.out.print("Kode Resto: ");
            System.out.println(kodeResto.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Nama Resto: ");
            System.out.println(namaResto.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Alamat Resto: ");
            System.out.println(alamatResto.toArray()[j].toString().replace("[", "").replace("]", ""));
            showMenu(kodeResto.get(j));
        }
    }

    private static void showMenu(Object o) {
    }
}


