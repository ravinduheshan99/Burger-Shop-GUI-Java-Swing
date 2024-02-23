package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewOrdersCancelled extends JFrame {

    private JLabel lblTitle;
    private DefaultTableModel dtm;
    private JTable tblOrdP;
    private JButton btnBack;
    Color color = new Color(191, 49, 49);
    Color color2 = new Color(255, 195, 0);
    Color colorg = new Color(101, 183, 65);

    public ViewOrdersCancelled() {
        setTitle("Cancelled Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle = new JLabel("Cancelled Orders");
        lblTitle.setFont(new Font("", Font.PLAIN, 40));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(0, 0, 800, 70);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBackground(color);
        lblTitle.setOpaque(true);
        add(lblTitle);

        //Order Details Table Of Customer
        String[] columnNames = {"Order ID", "Customer ID", "Name", "Order QTY", "Total"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblOrdP = new JTable(dtm);
        // Use a JScrollPane to make the table scrollable
        JScrollPane tablePane = new JScrollPane(tblOrdP);
        tablePane.setBounds(100, 150, 600, 200);  // Set the position and size of the scroll pane
        add(tablePane);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblOrdP.getColumnCount(); i++) {
            tblOrdP.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        for (int i = 0; i < Controller.dbord.size(); i++) {
            if (Controller.dbord.get(i).getOrderStatus() == 2) {
                Object[] rowData = {Controller.dbord.get(i).getOrderId(), Controller.dbcus.get(i).getCustomerId(), Controller.dbcus.get(i).getCustomerName(), Controller.dbord.get(i).getOrderQty(), Controller.dbord.get(i).getOrderValue() + "0"};
                dtm.addRow(rowData);
            } else {

            }

        }

        btnBack = new JButton("Back");
        btnBack.setBackground(color);
        btnBack.setForeground(Color.white);
        btnBack.setFont(new Font("SANS_SERIF", 1, 15));
        btnBack.setBounds(670, 500, 100, 40);
        add(btnBack);
        btnBack.addActionListener(evt -> {
            new BurgerShopViewOrders().setVisible(true);
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
