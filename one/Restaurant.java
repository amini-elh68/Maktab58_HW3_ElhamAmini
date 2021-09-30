package Maktab58_HW3_ElhamAmini.one;

public class Restaurant {
    public static DinnerMenu dinnerMenu = new DinnerMenu();
    public static LunchMenu lunchMenu = new LunchMenu();
    public static Customer[] customers = new Customer[0];

    public static DinnerMenu getDinnerMenu() {
        return dinnerMenu;
    }

    public static void setDinnerMenu(DinnerMenu dinnerMenu) {
        Restaurant.dinnerMenu = dinnerMenu;
    }

    public static LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public static void setLunchMenu(LunchMenu lunchMenu) {
        Restaurant.lunchMenu = lunchMenu;
    }

    public static Customer[] getCustomers() {
        return customers;
    }

    public static Customer addCustomer(Customer customer) {
        Customer[] temp = new Customer[customers.length + 1];
        for (int i = 0; i < customers.length; i++) {
            temp[i] = customers[i];
        }
        temp[temp.length - 1] = customer;
        customers = temp;
        System.out.println("your information was added successfully");
        return customers[customers.length - 1];
    }
}
