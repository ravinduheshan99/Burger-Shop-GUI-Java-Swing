package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopUpdateOrder extends JFrame {

    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101, 183, 65);
    private JLabel lblTitle;
    private JLabel lblEnterOrdId;
    private JTextField txtOrdIdRes;
    private JButton btnSearch;
    private JLabel lblOrdStatus;
    private JComboBox OrdStatus;
    private JLabel lblCusId;
    private JTextField txtCusIdRes;
    private JLabel lblName;
    private JTextField txtNameRes;
    private JLabel lblQTY;
    private JTextField txtQTYRes;
    private JButton btnAddQty;
    private JLabel lblTot;
    private JLabel lblTotRes;
    private JButton btnBack;
    private JButton btnUpdate;
    private JButton btnClear;

    public BurgerShopUpdateOrder() {
        setTitle("Update Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle = new JLabel("Update Order");
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
        txtOrdIdRes.setBounds(210, 150, 100, 20);
        add(txtOrdIdRes);

        btnSearch = new JButton("Search");
        btnSearch.setBackground(color);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearch.setBounds(320, 150, 100, 20);
        add(btnSearch);
        btnSearch.addActionListener(evt -> {
            orders oid = Controller.searchOrder(txtOrdIdRes.getText());
            if (oid == null) {
                JOptionPane.showMessageDialog(null, "Invalid Order Id");
                clear();
            } else {
                orders obj1 = Controller.searchOrder(txtOrdIdRes.getText());
                customer obj2 = Controller.searchCus(txtOrdIdRes.getText());
                txtCusIdRes.setText(obj2.getCustomerId());
                txtNameRes.setText(obj2.getCustomerName());
                txtQTYRes.setText(obj1.getOrderQty() + "");
                lblTotRes.setText(obj1.getOrderValue() + "0");
                String Status = "";
                if (obj1.getOrderStatus() == 0) {
                    OrdStatus.setSelectedItem("Preparing");
                } else if (obj1.getOrderStatus() == 1) {
                    OrdStatus.setSelectedItem("Delivered");
                } else if (obj1.getOrderStatus() == 2) {
                    OrdStatus.setSelectedItem("Cancel");
                }
            }
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

        lblOrdStatus = new JLabel("Order Status  : ");
        lblOrdStatus.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatus.setForeground(Color.black);
        lblOrdStatus.setBounds(100, 200, 150, 20);
        add(lblOrdStatus);

        String[] Status = {"Preparing", "Delivered", "Cancel"};
        OrdStatus = new JComboBox(Status);
        OrdStatus.setFont(new Font("", Font.BOLD, 13));
        OrdStatus.setForeground(Color.black);
        OrdStatus.setBounds(210, 200, 150, 20);
        add(OrdStatus);

        lblCusId = new JLabel("Customer Id   : ");
        lblCusId.setFont(new Font("", Font.BOLD, 15));
        lblCusId.setForeground(Color.black);
        lblCusId.setBounds(100, 250, 150, 20);
        add(lblCusId);

        txtCusIdRes = new JTextField("");
        txtCusIdRes.setFont(new Font("", Font.BOLD, 15));
        txtCusIdRes.setForeground(Color.black);
        txtCusIdRes.setBounds(210, 250, 150, 20);
        add(txtCusIdRes);
        txtCusIdRes.setEditable(false);

        lblName = new JLabel("Name              : ");
        lblName.setFont(new Font("", Font.BOLD, 15));
        lblName.setForeground(Color.black);
        lblName.setBounds(100, 300, 150, 20);
        add(lblName);

        txtNameRes = new JTextField("");
        txtNameRes.setFont(new Font("", Font.BOLD, 15));
        txtNameRes.setForeground(Color.black);
        txtNameRes.setBounds(210, 300, 150, 20);
        add(txtNameRes);
        txtNameRes.setEditable(false);

        lblQTY = new JLabel("Order QTY     : ");
        lblQTY.setFont(new Font("", Font.BOLD, 15));
        lblQTY.setForeground(Color.black);
        lblQTY.setBounds(100, 350, 150, 20);
        add(lblQTY);

        txtQTYRes = new JTextField("");
        txtQTYRes.setFont(new Font("", Font.BOLD, 15));
        txtQTYRes.setForeground(Color.black);
        txtQTYRes.setBounds(210, 350, 150, 20);
        add(txtQTYRes);

        btnAddQty = new JButton("+");
        btnAddQty.setFont(new Font("", Font.BOLD, 15));
        btnAddQty.setForeground(Color.black);
        btnAddQty.setBounds(370, 350, 50, 20);
        add(btnAddQty);
        btnAddQty.addActionListener(evt -> {
            lblTotRes.setText(Controller.BURGERPRICE * Integer.parseInt(txtQTYRes.getText()) + "0");
        });

        lblTot = new JLabel("Total                : ");
        lblTot.setFont(new Font("", Font.BOLD, 15));
        lblTot.setForeground(Color.black);
        lblTot.setBounds(100, 400, 110, 20);
        add(lblTot);

        lblTotRes = new JLabel("");
        lblTotRes.setFont(new Font("", Font.BOLD, 15));
        lblTotRes.setForeground(color);
        lblTotRes.setBounds(210, 400, 100, 20);
        add(lblTotRes);

        btnUpdate = new JButton("Update Order");
        btnUpdate.setBackground(color);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setFont(new Font("SANS_SERIF", 1, 15));
        btnUpdate.setBounds(350, 500, 150, 40);
        add(btnUpdate);
        btnUpdate.addActionListener(evt -> {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(null, "Do you want to Update this order?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == 0) {
                int status = ordStatus();
                Controller.updateOrderDetails(txtOrdIdRes.getText(), status, Integer.parseInt(txtQTYRes.getText()));
                JOptionPane.showMessageDialog(null, "Your Order is Updated Successfully");
                clear();
                OrdStatus.setSelectedItem("Preparing");
            } else {

            }
        });
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdate.setBackground(colorg);
                btnUpdate.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdate.setBackground(color);
                btnUpdate.setForeground(Color.white);
            }
        });

        btnClear = new JButton("Clear");
        btnClear.setBackground(color);
        btnClear.setForeground(Color.white);
        btnClear.setFont(new Font("SANS_SERIF", 1, 15));
        btnClear.setBounds(535, 500, 100, 40);
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

        btnBack = new JButton("Back");
        btnBack.setBackground(color);
        btnBack.setForeground(Color.white);
        btnBack.setFont(new Font("SANS_SERIF", 1, 15));
        btnBack.setBounds(670, 500, 100, 40);
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

    }

    public int ordStatus() {
        if (OrdStatus.getSelectedItem().equals("Preparing")) {
            return 0;
        } else if (OrdStatus.getSelectedItem().equals("Delivered")) {
            return 1;
        } else if (OrdStatus.getSelectedItem().equals("Cancel")) {
            return 2;
        }
        return -1;
    }

    private void clear() {
        txtOrdIdRes.setText(null);
        txtCusIdRes.setText(null);
        txtNameRes.setText(null);
        txtQTYRes.setText(null);
        lblTotRes.setText(null);
    }
}
