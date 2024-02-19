package Controller;

import DB.ListCus;
import DB.ListOrd;
import Model.customer;
import Model.orders;
import java.util.*;

public class Controller {
    public static ListCus dbcus = new ListCus();
    public static ListOrd dbord = new ListOrd();

    public static double BURGERPRICE = 500;
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;

    public static String generateOrderId() {
        if (dbcus.size() == 0) {
            return "B0001";
        }
        String lastOrderId = dbord.get(dbord.size()-1).getOrderId();
        int number = Integer.parseInt(lastOrderId.split("B")[1]);
        number++;
        return String.format("B%04d", number);
    }

    public static String getStatusText(int orderStatus) {
        switch (orderStatus) {
            case PREPARING:
                return "Preparing";
            case DELIVERED:
                return "Delivered";
            case CANCEL:
                return "Cancelled";
            default:
                return "Unknown";
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            //Handle any exceptions.
        }
    }

    public static void placeOrder(String oid, String cid, String cname, int oqty) {
            dbcus.add(new customer(cid, cname));
            dbord.add(new orders(oid, 0, oqty, (oqty * BURGERPRICE)));
            System.out.println("Your Order is Placed Successfully");
            
    }

    public static void bestCustomer() {
        L20:
        while (true) {
            // Removing duplicate customer id's and names
            customer[] idArrayDupRemoved = removeDuplicates();

            // Summing the total order values for each customer id
            calculateTotalOrderValues(idArrayDupRemoved);

            // Sort the objects according to the order value using bubble sort
            bubbleSort(idArrayDupRemoved);

            displayBestCustomers(idArrayDupRemoved);

            // Prompt user to go back to the main menu
            System.out.print("Do you want to go back to the main menu? (Y/N): ");
            Scanner sc = new Scanner(System.in);
            char res = sc.next().toUpperCase().charAt(0);
            if (res == 'Y') {
                break L20;
            } else if (res == 'N') {
                continue L20;
            } else {
                System.out.println("***Please enter a valid input (Y OR N)***");
                continue L20;
            }
        }
    }

    public static customer[] removeDuplicates() {
        customer[] idArrayDupRemoved = new customer[0];
        for (int i = 0; i < dbcus.size(); i++) {
            if (!(search(dbcus.get(i).getCustomerId(), idArrayDupRemoved))) {
                customer[] tempIdArray = new customer[idArrayDupRemoved.length + 1];
                for (int j = 0; j < idArrayDupRemoved.length; j++) {
                    tempIdArray[j] = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName());
                }
                tempIdArray[tempIdArray.length - 1] = new customer(dbcus.get(i).getCustomerId(), dbcus.get(i).getCustomerName());
                idArrayDupRemoved = tempIdArray;
            }
        }
        return idArrayDupRemoved;
    }

    public static void calculateTotalOrderValues(customer[] idArrayDupRemoved) {
        for (int k = 0; k < idArrayDupRemoved.length; k++) {
            int total = 0;
            for (int m = 0; m < dbcus.size(); m++) {
                if (idArrayDupRemoved[k].getCustomerId().equals(dbcus.get(m).getCustomerId())) {
                    total += dbord.get(m).getOrderValue();
                }
            }
            idArrayDupRemoved[k].setTotal(total);
        }
    }

    public static void bubbleSort(customer[] idArrayDupRemoved) {
        for (int i = 0; i < idArrayDupRemoved.length - 1; i++) {
            for (int j = 0; j < idArrayDupRemoved.length - 1; j++) {
                if (idArrayDupRemoved[j].getTotal() < idArrayDupRemoved[j + 1].getTotal()) {
                    customer temp = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName(), idArrayDupRemoved[j].getTotal());
                    idArrayDupRemoved[j] = idArrayDupRemoved[j + 1];
                    idArrayDupRemoved[j + 1] = temp;
                }
            }
        }
    }

    public static void displayBestCustomers(customer[] idArrayDupRemoved) {
        System.out.println("________________________________________________________________________________");
        System.out.println("|                                 BEST CUSTOMER                                 |");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("CustomerID\t\t\t\t\tName\t\t\t\t\tTotal");
        System.out.println("---------------------------------------------------------------------------------");

        for (customer aCustomer : idArrayDupRemoved) {
            System.out.println(aCustomer.getCustomerId() + "\t\t\t\t\t" + aCustomer.getCustomerName() + "\t\t\t\t\t" + aCustomer.getTotal());
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public static boolean search(String customerId, customer[] idArrayDupRemoved) {
        for (customer aCustomer : idArrayDupRemoved) {
            if (aCustomer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public static orders searchOrder(String oid) {
            String orderId = oid;
            for (int i = 0; i < dbord.size(); i++) {
                if (orderId.equals(dbord.get(i).getOrderId())) {
                    return dbord.get(i);
                }
            }
            return null;
    }
    
    public static customer searchCus(String oid) {
            String orderId = oid;
            for (int i = 0; i < dbord.size(); i++) {
                if (orderId.equals(dbord.get(i).getOrderId())) {
                    return dbcus.get(i);
                }
            }
            return null;
    }

    public static customer searchCustomer(String cid) {
            String res5 = cid;
                for (int i = 0; i < dbcus.size(); i++) {
                    if (res5.equals(dbcus.get(i).getCustomerId())) {
                    return dbcus.get(i);
             }       
        }
                return null;
    }
    
    public static orders searchCusOrdDtl(String cid) {
            String res5 = cid;
                for (int i = 0; i < dbcus.size(); i++) {
                    if (res5.equals(dbcus.get(i).getCustomerId())) {
                    return dbord.get(i);
             }       
        }
                return null;
    }
    
    public static void viewOrders() {
        L4:
        while (true) {
            System.out.println("__________________________________________________________________________________");
            System.out.println("|                                VIEW ORDER DETAILS                               |");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\n[1] Delivered Order");
            System.out.println("[2] Preparing Order");
            System.out.println("[3] Cancel Order");

            Scanner input5 = new Scanner(System.in);
            L5:
            while (true) {
                System.out.print("\nEnter an option to continue : ");
                int ans2 = input5.nextInt();

                if (ans2 == 1) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                DELIVERED ORDERS                              |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 1) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L3:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans3 = input5.next().toUpperCase().charAt(0);
                        if (ans3 == 'Y') {
                            break L4;
                        } else if (ans3 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L3;
                        }
                    }


                } else if (ans2 == 2) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                PREPARING ORDERS                              |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 0) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L7:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input5.next().toUpperCase().charAt(0);
                        if (ans4 == 'Y') {
                            break L4;
                        } else if (ans4 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L7;
                        }
                    }

                } else if (ans2 == 3) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                CANCEL ORDERS                                 |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 2) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L8:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input5.next().toUpperCase().charAt(0);
                        if (ans4 == 'Y') {
                            break L4;
                        } else if (ans4 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L8;
                        }
                    }

                } else {
                    System.out.print("\n***Please Enter a Valid Input***");
                    continue L5;
                }
            }

        }

    }

    public static void updateOrderDetails(String oid, int ordStatus, int qty) {
            for (int i = 0; i < dbord.size(); i++) {
                if (oid.equals(dbord.get(i).getOrderId())) {
                int value1 = qty;
                dbord.get(i).setOrderQty(value1);
                dbord.get(i).setOrderValue(value1 * BURGERPRICE);
                System.out.println("\n\t***Update order quantity successfully***");
                int value2 = ordStatus;
                dbord.get(i).setOrderStatus(value2);
                System.out.println("\n\tUpdate order status successfully");
              }
        }
    }

    public static void exit() {
        clearConsole();
        System.out.println("\n\t\t***Thanks For Coming. Have a Nice Day***\n");
        System.exit(0);
    }
}
