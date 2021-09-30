package Maktab58_HW3_ElhamAmini.one;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String mobileNo;
    private final Gender gender;
    private Order[] orders = new Order[0];
    enum Gender {MALE, FEMALE}
    public Customer(String firstName, String lastName, String mobileNo, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.gender = gender;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void printCustomersInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("{").append("first name: ").append(firstName).append(", ");
        builder.append("last name: ").append(lastName).append(", ");
        builder.append("mobile no: ").append(mobileNo).append(", ");
        builder.append("gender: ").append(gender).append("}");
        System.out.println(builder);
    }

    public void addOrder(Order order) {
        Order[] temp = new Order[orders.length + 1];
        for (int i = 0; i < orders.length; i++) {
            temp[i] = orders[i];
        }
        temp[temp.length - 1] = order;
        orders = temp;
    }


}
