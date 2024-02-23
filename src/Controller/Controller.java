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
        String lastOrderId = dbord.get(dbord.size() - 1).getOrderId();
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

    public static String check(String cusId) {
        String cusName = "";
        for (int i = 0; i < dbcus.size(); i++) {
            if (cusId.equals(dbcus.get(i).getCustomerId())) {
                cusName = dbcus.get(i).getCustomerName();
                return cusName;
            }
        }
        return null;
    }

    public static customer[] bestCustomer() {
        // Removing duplicate customer id's and names
        customer[] idArrayDupRemoved = removeDuplicates();

        // Summing the total order values for each customer id
        calculateTotalOrderValues(idArrayDupRemoved);

        // Sort the objects according to the order value using bubble sort
        customer[] bc = bubbleSort(idArrayDupRemoved);

        return bc;
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

    public static customer[] bubbleSort(customer[] idArrayDupRemoved) {
        for (int i = 0; i < idArrayDupRemoved.length - 1; i++) {
            for (int j = 0; j < idArrayDupRemoved.length - 1; j++) {
                if (idArrayDupRemoved[j].getTotal() < idArrayDupRemoved[j + 1].getTotal()) {
                    customer temp = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName(), idArrayDupRemoved[j].getTotal());
                    idArrayDupRemoved[j] = idArrayDupRemoved[j + 1];
                    idArrayDupRemoved[j + 1] = temp;
                }
            }
        }
        return idArrayDupRemoved;
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
    
}
