package Maktab58_HW3_ElhamAmini.one;

public class Food extends MenuItem {
    public Food(int id, String name, String price, int stock) {
        super(id, name, price, stock);
        super.setTypeOfItem(TypeOfItem.FOOD);
    }
}
