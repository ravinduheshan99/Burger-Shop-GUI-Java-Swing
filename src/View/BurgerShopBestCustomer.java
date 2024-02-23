package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopBestCustomer extends JFrame {

    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101, 183, 65);
    private JLabel lblTitle1;
    private DefaultTableModel dtm;
    private JTable tblCus;
    private JButton btnBack;

    public BurgerShopBestCustomer() {
        setTitle("Best Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle1 = new JLabel("Best Customer");
        lblTitle1.setFont(new Font("", Font.PLAIN, 40));
        lblTitle1.setForeground(Color.white);
        lblTitle1.setBounds(0, 0, 800, 70);
        lblTitle1.setVerticalAlignment(JLabel.CENTER);
        lblTitle1.setHorizontalAlignment(JLabel.CENTER);
        lblTitle1.setBackground(color);
        lblTitle1.setOpaque(true);
        add(lblTitle1);
       
        //Order Details Table Of Customer
        String[] columnNames = {"Customer ID", "Name", "Total"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblCus = new JTable(dtm);
        // Use a JScrollPane to make the table scrollable
        JScrollPane tablePane = new JScrollPane(tblCus);
        tablePane.setBounds(100, 150, 600, 200);  // Set the position and size of the scroll pane
        add(tablePane);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblCus.getColumnCount(); i++) {
            tblCus.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        customer[] bc = Controller.bestCustomer();
        for (customer c : bc) {
            Object[] rowData = {c.getCustomerId(), c.getCustomerName(),c.getTotal()+"0"};
            dtm.addRow(rowData);
        }
        
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
}
