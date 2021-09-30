package Maktab58_HW3_ElhamAmini.one;

import static Maktab58_HW3_ElhamAmini.one.Restaurant.dinnerMenu;
import static Maktab58_HW3_ElhamAmini.one.Restaurant.lunchMenu;

public class Order {

    private static int seq = 0;
    private final int id;
    private StatusOfOrder status;
    enum StatusOfOrder {RESERVED, CANCELED}
    private MenuItem[] items = new MenuItem[0];
    private RestaurantMenu.TypeOfMenu typeOfMenu;
    public Order() {
        seq++;
        id = seq;
    }

    public int getId() {
        return id;
    }

    public StatusOfOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOfOrder status) {
        this.status = status;
    }

    public RestaurantMenu.TypeOfMenu getTypeOfMenu() {
        return typeOfMenu;
    }

    public void setTypeOfMenu(RestaurantMenu.TypeOfMenu typeOfMenu) {
        this.typeOfMenu = typeOfMenu;
    }

    public MenuItem[] getItems() {
        return items;
    }

    public void printOrders() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").append(id).append("   ");
        builder.append("{");
        int orderPrice = 0;
        for (MenuItem item : items) {
            builder.append(item.getName());
            builder.append("(" + item.getPrice() + "T)");
            builder.append("-");
            orderPrice += Integer.valueOf(item.getPrice());
        }
        builder = new StringBuilder(builder.substring(0, builder.length() - 1));
        builder.append("}   ");
        builder.append("order price: ").append(orderPrice).append("T   ");
        double tax = (typeOfMenu == RestaurantMenu.TypeOfMenu.DINNER ? 0.1 * orderPrice : 0.15 * orderPrice);
        builder.append("tax: ").append(tax).append("   ");
        builder.append("total price: ").append(Double.valueOf(orderPrice) + tax).append("   ");
        builder.append("order status: ").append(status);
        System.out.println(builder);
    }

    public void addItem(MenuItem item) {
        MenuItem[] temp = new MenuItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;
    }

    public void cancelOrder() {
        if (typeOfMenu == RestaurantMenu.TypeOfMenu.DINNER) {
            for (MenuItem item : items) {
                for (MenuItem menuItem : dinnerMenu.getMenuItems()) {
                    if (menuItem.getId() == item.getId()) {
                        menuItem.setStock(menuItem.getStock() + 1);
                    }
                }
            }
        } else if (typeOfMenu == RestaurantMenu.TypeOfMenu.LAUNCH) {
            for (MenuItem item : items) {
                for (MenuItem menuItem : lunchMenu.getMenuItems()) {
                    if (menuItem.getId() == item.getId()) {
                        menuItem.setStock(menuItem.getStock() + 1);
                    }
                }
            }
        }
    }


}
