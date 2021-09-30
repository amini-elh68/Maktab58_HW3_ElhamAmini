package Maktab58_HW3_ElhamAmini.two.multiple;

public class Device implements Printable, Showable {
    public static void main(String[] args) {
        Device obj = new Device();
        obj.print();
        obj.show();
    }

    @Override
    public void print() {
        System.out.println("Hello");
    }

    @Override
    public void show() {
        System.out.println("Welcome");
    }
}
