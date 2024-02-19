package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopSearchOrderDetails extends JFrame {
    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101,183,65);
    private JLabel lblTitle;
    private JLabel lblEnterOrdId;
    private JTextField txtOrdIdRes;
    private JButton btnSearch;
    private JLabel lblCusId;
    private JLabel lblCusIdRes;
    private JLabel lblName;
    private JLabel lblNameRes;
    private JLabel lblQTY;
    private JLabel lblQTYRes;
    private JLabel lblTotal;
    private JLabel lblTotalRes;
    private JLabel lblOrdStatus;
    private JLabel lblOrdStatusRes;
    private JButton btnClear;
    private JButton btnBack;

    public BurgerShopSearchOrderDetails() {
        setTitle("Search Order Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle = new JLabel("Search Order Details");
        lblTitle.setFont(new Font("", Font.PLAIN, 40));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(0, 0, 800, 70);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBackground(color);
        lblTitle.setOpaque(true);
        add(lblTitle);

        lblEnterOrdId = new JLabel("Enter OrderID : ");
        lblEnterOrdId.setFont(new Font("", Font.BOLD, 15));
        lblEnterOrdId.setForeground(Color.black);
        lblEnterOrdId.setBounds(100, 150, 150, 20);
        add(lblEnterOrdId);

        //Order Id Placeholder
        txtOrdIdRes = new JTextField();
        txtOrdIdRes.setFont(new Font("", Font.BOLD, 15));
        txtOrdIdRes.setForeground(Color.black);
        txtOrdIdRes.setBounds(220, 150, 100, 20);
        add(txtOrdIdRes);
        
        btnSearch = new JButton("Search");
        btnSearch.setBackground(color);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearch.setBounds(330, 150, 100, 20);
        add(btnSearch);
        btnSearch.addActionListener(evt -> {
           orders obj1 = Controller.searchOrder(txtOrdIdRes.getText());
           customer obj2 = Controller.searchCus(txtOrdIdRes.getText());
           lblCusIdRes.setText(obj2.getCustomerId());
           lblNameRes.setText(obj2.getCustomerName());
           lblQTYRes.setText(obj1.getOrderQty()+"");
           lblTotalRes.setText(obj1.getOrderValue()+"0");
           lblOrdStatusRes.setText(Controller.getStatusText(obj1.getOrderStatus()));
           
        });
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearch.setBackground(colorg);
                btnSearch.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearch.setBackground(color);
                btnSearch.setForeground(Color.white);
            }
        });

        lblCusId = new JLabel("Customer ID : ");
        lblCusId.setFont(new Font("", Font.BOLD, 15));
        lblCusId.setForeground(Color.black);
        lblCusId.setBounds(220, 220, 100, 20);
        add(lblCusId);

        lblCusIdRes = new JLabel("");
        lblCusIdRes.setFont(new Font("", Font.BOLD, 15));
        lblCusIdRes.setForeground(Color.black);
        lblCusIdRes.setBounds(320, 220, 100, 20);
        add(lblCusIdRes);

        lblName = new JLabel("Name             : ");
        lblName.setFont(new Font("", Font.BOLD, 15));
        lblName.setForeground(Color.black);
        lblName.setBounds(220, 260, 100, 20);
        add(lblName);

        lblNameRes = new JLabel("");
        lblNameRes.setFont(new Font("", Font.BOLD, 15));
        lblNameRes.setForeground(Color.black);
        lblNameRes.setBounds(320, 260, 150, 20);
        add(lblNameRes);

        lblQTY = new JLabel("QTY               : ");
        lblQTY.setFont(new Font("", Font.BOLD, 15));
        lblQTY.setForeground(Color.black);
        lblQTY.setBounds(220, 300, 100, 20);
        add(lblQTY);

        lblQTYRes = new JLabel("");
        lblQTYRes.setFont(new Font("", Font.BOLD, 15));
        lblQTYRes.setForeground(Color.black);
        lblQTYRes.setBounds(320, 300, 100, 20);
        add(lblQTYRes);

        lblTotal = new JLabel("Total              :");
        lblTotal.setFont(new Font("", Font.BOLD, 15));
        lblTotal.setForeground(Color.black);
        lblTotal.setBounds(220, 340, 100, 20);
        add(lblTotal);

        lblTotalRes = new JLabel("");
        lblTotalRes.setFont(new Font("", Font.BOLD, 15));
        lblTotalRes.setForeground(Color.black);
        lblTotalRes.setBounds(320, 340, 100, 20);
        add(lblTotalRes);

        lblOrdStatus = new JLabel("Order Status : ");
        lblOrdStatus.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatus.setForeground(Color.black);
        lblOrdStatus.setBounds(220, 380, 150, 20);
        add(lblOrdStatus);

        lblOrdStatusRes = new JLabel("");
        lblOrdStatusRes.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatusRes.setForeground(Color.black);
        lblOrdStatusRes.setBounds(320, 380, 150, 20);
        add(lblOrdStatusRes);

        btnBack = new JButton("Back");
        btnBack.setBackground(color);
        btnBack.setForeground(Color.white);
        btnBack.setFont(new Font("SANS_SERIF", 1, 15));
        btnBack.setBounds(550, 500, 100, 40);
        add(btnBack);
        btnBack.addActionListener(evt -> {
            new BurgerShopHome().setVisible(true);
            dispose();
        });
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack.setBackground(colorg);
                btnBack.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack.setBackground(color);
                btnBack.setForeground(Color.white);
            }
        });

        btnClear = new JButton("Clear");
        btnClear.setBackground(color);
        btnClear.setForeground(Color.white);
        btnClear.setFont(new Font("SANS_SERIF", 1, 15));
        btnClear.setBounds(670, 500, 100, 40);
        add(btnClear);
        btnClear.addActionListener(evt -> {
            clear();
        });
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClear.setBackground(colorg);
                btnClear.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClear.setBackground(color);
                btnClear.setForeground(Color.white);
            }
        });
    }
     private void clear(){
           txtOrdIdRes.setText(null);
           lblCusIdRes.setText(null);
           lblNameRes.setText(null);
           lblQTYRes.setText(null);
           lblTotalRes.setText(null);
           lblOrdStatusRes.setText(null);
    }
}
