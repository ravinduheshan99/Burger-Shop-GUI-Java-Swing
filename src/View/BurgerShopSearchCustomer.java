package View;

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

        lblEnterCusId = new JLabel("Enter OrderID : ");
        lblEnterCusId.setFont(new Font("", Font.BOLD, 15));
        lblEnterCusId.setForeground(Color.black);
        lblEnterCusId.setBounds(100, 100, 150, 20);
        add(lblEnterCusId);

        txtCusIdRes = new JTextField("C0001");
        txtCusIdRes.setFont(new Font("", Font.BOLD, 15));
        txtCusIdRes.setForeground(Color.black);
        txtCusIdRes.setBounds(220, 100, 150, 20);
        add(txtCusIdRes);

        lblName = new JLabel("Name   : ");
        lblName.setFont(new Font("", Font.BOLD, 15));
        lblName.setForeground(Color.black);
        lblName.setBounds(150, 150, 100, 20);
        add(lblName);

        lblNameRes = new JLabel("Saman Kumara");
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
        // Add sample data to the table
        Object[] rowData1 = {"O001", "5", 2530.00};
        dtm.addRow(rowData1);
        Object[] rowData2 = {"O002", "5", 2530.00};
        dtm.addRow(rowData2);
        Object[] rowData3 = {"O003", "5", 2530.00};
        dtm.addRow(rowData3);
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
}
