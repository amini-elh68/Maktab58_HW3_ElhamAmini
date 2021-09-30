package Maktab58_HW3_ElhamAmini.one;

public class RestaurantMenu {
    protected MenuItem[] menuItems = new MenuItem[0];
    protected TypeOfMenu typeOfMenu;
    enum TypeOfMenu {DINNER, LAUNCH}

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public TypeOfMenu getTypeOfMenu() {
        return typeOfMenu;
    }

    public void setTypeOfMenu(TypeOfMenu typeOfMenu) {
        this.typeOfMenu = typeOfMenu;
    }

    protected void addMenuItem(MenuItem item) {
        MenuItem[] items = new MenuItem[menuItems.length + 1];
        for (int i = 0; i < menuItems.length; i++) {
            items[i] = menuItems[i];
        }
        items[items.length - 1] = item;
        menuItems = items;
        System.out.println("It was added successfully");
    }

    protected void displayMenu() {
        if (getTypeOfMenu() == TypeOfMenu.DINNER) {
            System.out.println("***Dinner Menu***");
        } else {
            System.out.println("***Lunch Menu***");
        }
        System.out.println("Foods");
        for (MenuItem item : menuItems) {
            if (item.getTypeOfItem() == MenuItem.TypeOfItem.FOOD)
                item.printItemInformation();
        }
        System.out.println("Drinks");
        for (MenuItem item : menuItems) {
            if (item.getTypeOfItem() == MenuItem.TypeOfItem.DRINK)
                item.printItemInformation();
        }
    }


}
