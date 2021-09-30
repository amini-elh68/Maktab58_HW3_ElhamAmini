package Maktab58_HW3_ElhamAmini.two.hybrid;

public class TestInterface4 implements Showable {
    public static void main(String[] args) {
        TestInterface4 obj = new TestInterface4();
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
