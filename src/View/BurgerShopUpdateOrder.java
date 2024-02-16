package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopUpdateOrder extends JFrame {
    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101, 183, 65);
    private JLabel lblTitle;
    private JLabel lblOrdStatus;
    private JComboBox OrdStatus;
    private JLabel lblOrdId;
    private JTextField txtOrdIdRes;
    private JLabel lblCusId;
    private JTextField txtCusIdRes;
    private JLabel lblName;
    private JTextField txtNameRes;
    private JLabel lblQTY;
    private JTextField txtQTYRes;
    private JLabel lblTot;
    private JLabel lblTotRes;
    private JButton btnBack;
    private JButton btnUpdate;

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

        lblOrdStatus = new JLabel("Order Status");
        lblOrdStatus.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatus.setForeground(Color.black);
        lblOrdStatus.setBounds(100, 150, 150, 20);
        add(lblOrdStatus);

        String[] Status = {"Preparing", "Delivered", "Cancel"};
        OrdStatus = new JComboBox(Status);
        OrdStatus.setFont(new Font("", Font.BOLD, 13));
        OrdStatus.setForeground(Color.black);
        OrdStatus.setBounds(200, 150, 150, 20);
        add(OrdStatus);

        lblOrdId = new JLabel("Order Id");
        lblOrdId.setFont(new Font("", Font.BOLD, 15));
        lblOrdId.setForeground(Color.black);
        lblOrdId.setBounds(100, 200, 100, 20);
        add(lblOrdId);

        txtOrdIdRes = new JTextField("00001");
        txtOrdIdRes.setFont(new Font("", Font.BOLD, 15));
        txtOrdIdRes.setForeground(Color.black);
        txtOrdIdRes.setBounds(200, 200, 150, 20);
        add(txtOrdIdRes);

        lblCusId = new JLabel("Customer Id");
        lblCusId.setFont(new Font("", Font.BOLD, 15));
        lblCusId.setForeground(Color.black);
        lblCusId.setBounds(100, 250, 150, 20);
        add(lblCusId);

        txtCusIdRes = new JTextField("C0001");
        txtCusIdRes.setFont(new Font("", Font.BOLD, 15));
        txtCusIdRes.setForeground(Color.black);
        txtCusIdRes.setBounds(200, 250, 150, 20);
        add(txtCusIdRes);

        lblName = new JLabel("Name");
        lblName.setFont(new Font("", Font.BOLD, 15));
        lblName.setForeground(Color.black);
        lblName.setBounds(100, 300, 150, 20);
        add(lblName);

        txtNameRes = new JTextField("Saman Kumara");
        txtNameRes.setFont(new Font("", Font.BOLD, 15));
        txtNameRes.setForeground(Color.black);
        txtNameRes.setBounds(200, 300, 150, 20);
        add(txtNameRes);

        lblQTY = new JLabel("Order QTY");
        lblQTY.setFont(new Font("", Font.BOLD, 15));
        lblQTY.setForeground(Color.black);
        lblQTY.setBounds(100, 350, 150, 20);
        add(lblQTY);

        txtQTYRes = new JTextField("20");
        txtQTYRes.setFont(new Font("", Font.BOLD, 15));
        txtQTYRes.setForeground(Color.black);
        txtQTYRes.setBounds(200, 350, 150, 20);
        add(txtQTYRes);

        lblTot = new JLabel("Total");
        lblTot.setFont(new Font("", Font.BOLD, 15));
        lblTot.setForeground(Color.black);
        lblTot.setBounds(100, 400, 100, 20);
        add(lblTot);

        lblTotRes = new JLabel("7500.00");
        lblTotRes .setFont(new Font("", Font.BOLD, 15));
        lblTotRes .setForeground(color);
        lblTotRes .setBounds(200, 400, 100, 20);
        add(lblTotRes );

        btnUpdate = new JButton("Update Order");
        btnUpdate.setBackground(color);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setFont(new Font("SANS_SERIF", 1, 15));
        btnUpdate.setBounds(500, 500, 150, 40);
        add(btnUpdate);
        btnUpdate.addActionListener(evt -> {

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
