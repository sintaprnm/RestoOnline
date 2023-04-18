import java.util.*;
public class Admin {

    static Scanner input = new Scanner(System.in);

    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        // apabila status user admin
        int ulang = 1;
        do {
            System.out.println("\nMenu Admin");
            System.out.println("1. Lihat Resto");
            System.out.println("2. Tambah Resto");
            System.out.println("3. Hapus Resto");
            System.out.println("4. Kembali ke halaman Login");
            System.out.print("Menu Pilihan: ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    RestoPusat.showRestaurant();
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
            System.out.println("\nApakah anda ingin kembali ke menu? (1/2) \n1. Ya\n2. Tidak");
            ulang = input.nextInt();
        }while(ulang == 1);
    }

    //2. tambah resto
    public static void addResto() {
        System.out.println("\nNEW RESTO!");
        System.out.println("Silakan masukkan info resto baru!");
        System.out.print("| Kode Resto      : ");
        int kodeResto = input.nextInt();
        input.nextLine();
        System.out.print("| Nama Resto      : ");
        String nama = input.nextLine();
        System.out.print("| Alamat Resto    : ");
        String alamat = input.nextLine();
        System.out.print("| Banyak Menu     : ");
        int banyak = Integer.parseInt(input.nextLine());

        RestoPusat restolist = new RestoPusat(kodeResto,nama,alamat);
        RestoPusat.addRestaurant(restolist);

        System.out.println("\n\t\t\tInfo Menu Resto");
        System.out.println("Masukkan info menu sesuai jumlah banyak menu!");
        for (int i = 0; i < banyak; i++) {
            System.out.print("| Kode Menu         : ");
            String kodeMenu = input.nextLine();
            System.out.print("| Nama Menu         : ");
            String namaMenu = input.nextLine();
            System.out.print("| Harga Satuan Menu : ");
            String harga = input.nextLine();

            restolist.addMenu(kodeMenu, namaMenu, harga);
        }
        System.out.println("Resto Baru Telah Ditambahkan!");
        menuAdmin();
    }

    //3. Hapus Resto
    public static void deleteResto() {
        if (RestoPusat.showRestaurant() != 0) {
            System.out.print("\nMasukkan Nomor Indeks resto yang ingin dihapus: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            RestoPusat.deleteResto(index);
        }
        System.out.println("Resto Berhasil Dihapus!");
        menuAdmin();
    }

}