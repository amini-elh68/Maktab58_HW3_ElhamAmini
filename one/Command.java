package Maktab58_HW3_ElhamAmini.one;

import java.util.Scanner;

import static Maktab58_HW3_ElhamAmini.one.Restaurant.dinnerMenu;
import static Maktab58_HW3_ElhamAmini.one.Restaurant.lunchMenu;

public class Command {
    enum TypeOfCommands {RESTAURANT, MANAGER, CUSTOMER}
    private static Command.TypeOfCommands type = Command.TypeOfCommands.RESTAURANT;
    private static int commandNumber;
    private final Scanner scanner = new Scanner(System.in);
    private Customer currentCustomer;

    public void executeApp() {
        Scanner scanner = new Scanner(System.in);
        while (!(type == TypeOfCommands.RESTAURANT && commandNumber == 3)) {
            printCommands(type);
            commandNumber = scanner.nextInt();
            executeCommands();
            setType(commandNumber);
        }
    }

    private void executeCommands() {
        if (type == TypeOfCommands.RESTAURANT && commandNumber == 2) {
            System.out.println("please enter your first name, last name, mobile no and gender(male or female)");
            String firstName = scanner.next();
            String lastName = scanner.next();
            String mobileNo = scanner.next();
            String gender = scanner.next();
            Customer customer = new Customer(firstName, lastName, mobileNo, gender.equalsIgnoreCase("male") ? Customer.Gender.MALE : Customer.Gender.FEMALE);
            currentCustomer = Restaurant.addCustomer(customer);
        } else if (type == TypeOfCommands.MANAGER && (commandNumber == 1 || commandNumber == 2)) {
            System.out.println("do you want add food or drink? please enter food or drink.");
            String typeOfMenuItem = scanner.next();
            if (typeOfMenuItem.equalsIgnoreCase("food")) {
                System.out.println("please enter food information(ID , NAME, PRICE, STOCK)");
                int Id = scanner.nextInt();
                String name = scanner.next();
                String price = scanner.next();
                int stock = scanner.nextInt();
                Food food = new Food(Id, name, price, stock);
                if (commandNumber == 1)
                    dinnerMenu.addMenuItem(food);

                else
                    Restaurant.getLunchMenu().addMenuItem(food);
            } else if (typeOfMenuItem.equalsIgnoreCase("drink")) {
                System.out.println("please enter drink information(ID , NAME, PRICE, STOCK)");
                int Id = scanner.nextInt();
                String name = scanner.next();
                String price = scanner.next();
                int stock = scanner.nextInt();
                Drink drink = new Drink(Id, name, price, stock);
                if (commandNumber == 1)
                    Restaurant.getDinnerMenu().addMenuItem(drink);
                else
                    Restaurant.getLunchMenu().addMenuItem(drink);
            }
        } else if (type == TypeOfCommands.MANAGER && commandNumber == 3) {
            for (Customer customer : Restaurant.getCustomers()) {
                customer.printCustomersInfo();
            }
        } else if (type == TypeOfCommands.CUSTOMER && commandNumber == 1) {
            System.out.println("choose your meal:");
            System.out.println("1) dinner");
            System.out.println("2) lunch");
            int meal = scanner.nextInt();
            RestaurantMenu.TypeOfMenu typeOfMenu = null;
            if (meal == 1) {
                dinnerMenu.displayMenu();
                typeOfMenu = RestaurantMenu.TypeOfMenu.DINNER;
            } else if (meal == 2) {
                Restaurant.lunchMenu.displayMenu();
                typeOfMenu = RestaurantMenu.TypeOfMenu.LAUNCH;
            }
            System.out.println("Which one do you want to order? please end of orders 0.");
            int[] itemIds = new int[0];
            int i = scanner.nextInt();
            while (i != 0) {
                itemIds = addItemId(itemIds, i);
                i = scanner.nextInt();//message

            }
            registerOrders(itemIds, typeOfMenu);
        } else if (type == TypeOfCommands.CUSTOMER && commandNumber == 2) {
            for (Order order : currentCustomer.getOrders()) {
                order.printOrders();
            }
        } else if (type == TypeOfCommands.CUSTOMER && commandNumber == 3) {
            System.out.println("please enter order id:");
            int orderId = scanner.nextInt();
            for (Order order : currentCustomer.getOrders()) {
                if (order.getId() == orderId) {
                    order.setStatus(Order.StatusOfOrder.CANCELED);
                    order.cancelOrder();
                    System.out.println("order was canceled successfully");
                }
            }
        }
    }

    private int[] addItemId(int[] ids, int id) {
        int[] temp = new int[ids.length + 1];
        for (int i = 0; i < ids.length; i++) {
            temp[i] = ids[i];
        }
        temp[temp.length - 1] = id;
        return temp;
    }

    private void registerOrders(int[] itemsIds, RestaurantMenu.TypeOfMenu type) {
        Order order = new Order();
        for (int i : itemsIds) {
            if (type == RestaurantMenu.TypeOfMenu.DINNER) {
                addItemToOrder(order, i, dinnerMenu.getMenuItems());
            } else {
                addItemToOrder(order, i, lunchMenu.getMenuItems());
            }
        }
        order.setStatus(Order.StatusOfOrder.RESERVED);
        order.setTypeOfMenu(type);
        if (order.getItems().length > 0) {
            currentCustomer.addOrder(order);
            System.out.println("this order was registered successfully");
        } else {
            System.out.println("this order dont registered");
        }
    }

    private void addItemToOrder(Order order, int i, MenuItem[] menuItems) {
        for (MenuItem item : menuItems) {
            if (i == item.getId()) {
                if (item.getStock() > 0) {
                    item.setStock(item.getStock() - 1);
                    order.addItem(item);
                    System.out.println(item.getName() + " was added successfully");
                } else {
                    System.out.println(item.getName() + " was added failed");
                }
            }
        }
    }

    private void setType(int number) {
        if (type == TypeOfCommands.RESTAURANT) {
            if (number == 1)
                type = TypeOfCommands.MANAGER;
            else if (number == 2)
                type = TypeOfCommands.CUSTOMER;
        } else if ((type == TypeOfCommands.MANAGER || type == TypeOfCommands.CUSTOMER) && number == 5) {
            type = TypeOfCommands.RESTAURANT;
        }
    }

    private void printCommands(TypeOfCommands type) {
        if (type == TypeOfCommands.RESTAURANT) {
            System.out.println("***Welcome to restaurant system***");
            System.out.println("1) login as manager");
            System.out.println("2) login as customer");
            System.out.println("3) Exit");
        } else if (type == TypeOfCommands.MANAGER) {
            System.out.println("***Manager Menu***");
            System.out.println("1) Add to dinner menu");
            System.out.println("2) Add to lunch menu");
            System.out.println("3) Customer info");
            System.out.println("5) Back to main menu");
        } else if (type == TypeOfCommands.CUSTOMER) {
            System.out.println("***Customer Menu***");
            System.out.println("1) Add new Order");
            System.out.println("2) Show Orders details");
            System.out.println("3) Cancel an order");
            System.out.println("5) Back to main menu");
        }
    }


}
