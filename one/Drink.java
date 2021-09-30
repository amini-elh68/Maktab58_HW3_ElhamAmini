package Maktab58_HW3_ElhamAmini.one;

public class Drink extends MenuItem {
    public Drink(int id, String name, String price, int stock) {
        super(id, name, price, stock);
        super.setTypeOfItem(TypeOfItem.DRINK);
    }
}
