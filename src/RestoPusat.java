import java.util.ArrayList;

public class RestoPusat {

        String name, address;
        int id;
        static ArrayList<RestoPusat> restoList = new ArrayList<>();
        static ArrayList<ArrayList<RestoPusat>> menuList = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();


        public RestoPusat(int id, String name, String address) {
                this.id = id;
                this.name = name;
                this.address = address;
        }

        public static void addRestaurant(RestoPusat restaurant){
                restoList.add(restaurant);
        }

        public void addMenu(String kodeMenu, String menu, String price){
                ArrayList<String> menu1 = new ArrayList<>();
                menu1.add(kodeMenu);
                menu1.add(menu);
                menu1.add(price);
        }

        public void setAddress(){
                this.address = address;
        }

        public int getId(){
                return id;
        }

        public String getName(){
                return this.name;
        }

        public String getAddress(){
                return this.address;
        }

        public static int showRestaurant(){
                try{
                        restoList.get(0);
                        System.out.println("Daftar Restoran: ");
                        for(RestoPusat restaurant: restoList){
                                System.out.printf("%d. Restoran %s - %s%n",restaurant.getId(),restaurant.getName(),restaurant.getAddress());
                        }
                        return 1;
                }catch(IndexOutOfBoundsException e) {
                        System.out.println("Restoran tidak ada");
                        return 0;
                }
        }

        public static void deleteResto(int id){
                restoList.remove(id-1);
        }


//        kehancuran dimulai
        static ArrayList<String> menus = new ArrayList<>();
        public void setName(String name) {
                this.name = name;
        }

        public ArrayList<String> getMenus() {
                return menus;
        }

        public void setMenus(ArrayList menus) {
                this.menus = menus;
        }

        public ArrayList<Double> getPrice() {
                return price;
        }

        public void setPrice(ArrayList<Double> price) {
                this.price = price;
        }

        //fungsi customer
        public void showMenu() {
                System.out.println("Daftar menu di " + this.getName() + ":");

                for (int i = 0; i < menus.size(); i++) {
                        System.out.println("- " + menus.get(i) + " : Rp " + price.get(i));
                }
        }
        public double calculateTotal(ArrayList<String> selectedMenus) {
                double total = 0;

                for (String selectedMenu : selectedMenus) {
                        int index = menus.indexOf(selectedMenu);
                        if (index != -1) {
                                total += price.get(index);
                        }
                }

                return total;
        }
        public boolean hasMenu(String menuName) {
                return menus.contains(menuName);
        }
}