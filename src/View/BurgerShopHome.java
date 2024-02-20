package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopHome extends JFrame {

    private JButton btnPlaceOrder;
    private JButton btnSearchBestCustomer;
    private JButton btnSearchOrder;
    private JButton btnSearchCustomer;
    private JButton btnViewOrder;
    private JButton btnUpdateOrder;
    private JButton btnExit;
    private JPanel imgPanel;
    private JLabel lblImg;
    private JLabel lblHeader;
    private JPanel headerPanel;
    Color color = new Color(191, 49, 49);
    Color color2 = new Color(255, 195, 0);
    Color colorg = new Color(101, 183, 65);

    // Create an ImageIcon from the specified image file
    ImageIcon imgHome = new ImageIcon("D:\\Documents\\Self Learning Courses\\iCM-106-iCET\\Modules\\05-OOP\\Assignments\\Courseworks\\Week 04 -NetBeans\\BurgerShopGUI\\Images\\1.jpg");
    // Get the Image object from the ImageIcon and scale it to 300x300 pixels with smooth scaling
    Image scaledImage = imgHome.getImage().getScaledInstance(370, 510, Image.SCALE_SMOOTH);
    // Create a new ImageIcon with the scaled Image
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    // Now, scaledIcon contains the ImageIcon with the scaled image

    public BurgerShopHome() {
        setTitle("Home-iHungry Burger Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBounds(0, 0, 370, 60);
        headerPanel.setBackground(Color.white);

        lblHeader = new JLabel("Welcome To iHungry Burgers");
        lblHeader.setForeground(color2);
        lblHeader.setFont(new Font("SANS_SERIF", 1, 25));

        headerPanel.add(lblHeader);
        add(headerPanel);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBackground(color);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnPlaceOrder.setBounds(470, 100, 200, 40);
        add(btnPlaceOrder);
        btnPlaceOrder.addActionListener(evt -> {
            new BurgerShopPlaceOrder().setVisible(true);
            dispose();
        });
        btnPlaceOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlaceOrder.setBackground(colorg);
                btnPlaceOrder.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlaceOrder.setBackground(color);
                btnPlaceOrder.setForeground(Color.white);
            }
        });

        btnSearchBestCustomer = new JButton("Search Best Customer");
        btnSearchBestCustomer.setBackground(color);
        btnSearchBestCustomer.setForeground(Color.white);
        btnSearchBestCustomer.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearchBestCustomer.setBounds(470, 160, 200, 40);
        add(btnSearchBestCustomer);
        btnSearchBestCustomer.addActionListener(evt -> {

        });
        btnSearchBestCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchBestCustomer.setBackground(colorg);
                btnSearchBestCustomer.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchBestCustomer.setBackground(color);
                btnSearchBestCustomer.setForeground(Color.white);
            }
        });

        btnSearchOrder = new JButton("Search Order");
        btnSearchOrder.setBackground(color);
        btnSearchOrder.setForeground(Color.white);
        btnSearchOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearchOrder.setBounds(470, 220, 200, 40);
        add(btnSearchOrder);
        btnSearchOrder.addActionListener(evt -> {
            new BurgerShopSearchOrderDetails().setVisible(true);
            dispose();
        });
        btnSearchOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchOrder.setBackground(colorg);
                btnSearchOrder.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchOrder.setBackground(color);
                btnSearchOrder.setForeground(Color.white);
            }
        });

        btnSearchCustomer = new JButton("Search Customer");
        btnSearchCustomer.setBackground(color);
        btnSearchCustomer.setForeground(Color.white);
        btnSearchCustomer.setFont(new Font("SANS_SERIF", 1, 15));
        btnSearchCustomer.setBounds(470, 280, 200, 40);
        add(btnSearchCustomer);
        btnSearchCustomer.addActionListener(evt -> {
            new BurgerShopSearchCustomer().setVisible(true);
            dispose();
        });
        btnSearchCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchCustomer.setBackground(colorg);
                btnSearchCustomer.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchCustomer.setBackground(color);
                btnSearchCustomer.setForeground(Color.white);
            }
        });

        btnViewOrder = new JButton("View Orders");
        btnViewOrder.setBackground(color);
        btnViewOrder.setForeground(Color.white);
        btnViewOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnViewOrder.setBounds(470, 340, 200, 40);
        add(btnViewOrder);
        btnViewOrder.addActionListener(evt -> {

        });
        btnViewOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewOrder.setBackground(colorg);
                btnViewOrder.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewOrder.setBackground(color);
                btnViewOrder.setForeground(Color.white);
            }
        });

        btnUpdateOrder = new JButton("Update Order Details");
        btnUpdateOrder.setBackground(color);
        btnUpdateOrder.setForeground(Color.white);
        btnUpdateOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnUpdateOrder.setBounds(470, 400, 200, 40);
        add(btnUpdateOrder);
        btnUpdateOrder.addActionListener(evt -> {
            new BurgerShopUpdateOrder().setVisible(true);
            dispose();
        });
        btnUpdateOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateOrder.setBackground(colorg);
                btnUpdateOrder.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateOrder.setBackground(color);
                btnUpdateOrder.setForeground(Color.white);
            }
        });

        btnExit = new JButton("Exit");
        btnExit.setBackground(color);
        btnExit.setForeground(Color.white);
        btnExit.setFont(new Font("SANS_SERIF", 1, 15));
        btnExit.setBounds(670, 500, 100, 40);
        add(btnExit);
        btnExit.addActionListener(evt -> {
            System.exit(0);
        });
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExit.setBackground(colorg);
                btnExit.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExit.setBackground(color);
                btnExit.setForeground(Color.white);
            }
        });

        imgPanel = new JPanel(new FlowLayout());
        imgPanel.setBounds(0, 50, 370, 510);
        // Use the scaledIcon to create a JLabel
        lblImg = new JLabel(scaledIcon);
        // Add the JLabel to the imgPanel
        imgPanel.add(lblImg);
        add(imgPanel);
    }
}
