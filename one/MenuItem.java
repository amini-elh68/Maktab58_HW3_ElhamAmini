package Maktab58_HW3_ElhamAmini.one;

public class MenuItem {

    private int id;
    private String name;
    private String price;
    private int stock;
    private TypeOfItem typeOfItem;
    enum TypeOfItem {FOOD, DRINK}

    public MenuItem(int id, String name, String price, int stock) {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TypeOfItem getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(TypeOfItem typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public void printItemInformation() {
        StringBuilder builder = new StringBuilder();
        builder.append(getId()).append("   ").append(getName()).append("   ").append(getPrice()).append("T");
        System.out.println(builder);
    }


}
