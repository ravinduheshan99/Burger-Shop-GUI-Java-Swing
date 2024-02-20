package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopSearchCustomer extends JFrame {

    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101, 183, 65);
    private JLabel lblTitle1;
    private JLabel lblEnterCusId;
    private JTextField txtCusIdRes;
    private JButton btnSearch;
    private JLabel lblName;
    private JLabel lblNameRes;
    private JLabel lblTitle2;
    private DefaultTableModel dtm;
    private JTable tblOrd;
    private JButton btnClear;
    private JButton btnBack;

    public BurgerShopSearchCustomer() {
        setTitle("Search Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle1 = new JLabel("Search Customer");
        lblTitle1.setFont(new Font("", Font.PLAIN, 40));
        lblTitle1.setForeground(Color.white);
        lblTitle1.setBounds(0, 0, 800, 70);
        lblTitle1.setVerticalAlignment(JLabel.CENTER);
        lblTitle1.setHorizontalAlignment(JLabel.CENTER);
        lblTitle1.setBackground(color);
        lblTitle1.setOpaque(true);
        add(lblTitle1);

        lblEnterCusId = new JLabel("Enter Customer ID : ");
        lblEnterCusId.setFont(new Font("", Font.BOLD, 15));
        lblEnterCusId.setForeground(Color.black);
        lblEnterCusId.setBounds(100, 100, 150, 20);
        add(lblEnterCusId);

        txtCusIdRes = new JTextField("");
        txtCusIdRes.setFont(new Font("", Font.BOLD, 15));
        txtCusIdRes.setForeground(Color.black);
        txtCusIdRes.setBounds(250, 100, 150, 20);
        add(txtCusIdRes);

        btnSearch = new JButton("Search");
        btnSearch.setBackground(color);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearch.setBounds(410, 100, 100, 20);
        add(btnSearch);
        btnSearch.addActionListener(evt -> {
            customer cid = Controller.searchCustomer(txtCusIdRes.getText());
            if (cid == null) {
                JOptionPane.showMessageDialog(null, "Customer Does Not Exists.");
                clear();
            } else if (txtCusIdRes.getText().equals(cid.getCustomerId())) {
                lblNameRes.setText(cid.getCustomerName());
                for (int i = 0; i < Controller.dbcus.size(); i++) {
                    customer obj2 = Controller.dbcus.get(i);
                    if (obj2.getCustomerId().equals(txtCusIdRes.getText())) {
                        orders obj3 = Controller.dbord.get(i);
                        Object[] rowData = {obj3.getOrderId(), obj3.getOrderQty() + "", obj3.getOrderValue() + "0"};
                        dtm.addRow(rowData);
                    } else {

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Customer Id.");
                clear();
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

        lblName = new JLabel("Name   : ");
        lblName.setFont(new Font("", Font.BOLD, 15));
        lblName.setForeground(Color.black);
        lblName.setBounds(150, 150, 100, 20);
        add(lblName);

        lblNameRes = new JLabel("");
        lblNameRes.setFont(new Font("", Font.BOLD, 15));
        lblNameRes.setForeground(Color.black);
        lblNameRes.setBounds(218, 150, 120, 20);
        add(lblNameRes);

        lblTitle2 = new JLabel("Order Details");
        lblTitle2.setFont(new Font("", Font.PLAIN, 30));
        lblTitle2.setForeground(Color.white);
        lblTitle2.setBounds(0, 200, 800, 50);
        lblTitle2.setVerticalAlignment(JLabel.CENTER);
        lblTitle2.setHorizontalAlignment(JLabel.CENTER);
        lblTitle2.setBackground(color);
        lblTitle2.setOpaque(true);
        add(lblTitle2);

        //Order Details Table Of Customer
        String[] columnNames = {"Order ID", "Order QTY", "Total"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblOrd = new JTable(dtm);
        // Use a JScrollPane to make the table scrollable
        JScrollPane tablePane = new JScrollPane(tblOrd);
        tablePane.setBounds(100, 280, 600, 200);  // Set the position and size of the scroll pane
        add(tablePane);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblOrd.getColumnCount(); i++) {
            tblOrd.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

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

    private void clear() {
        txtCusIdRes.setText(null);
        lblNameRes.setText(null);
        dtm.setRowCount(0);
    }
}
