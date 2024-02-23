package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopViewOrders extends JFrame {
    private JButton btnProcessingOrders;
    private JButton btnDeliveredOrders;
    private JButton btnCancelledOrder;
    private JButton btnBack;
    private JPanel imgPanel;
    private JLabel lblImg;
    private JLabel lblHeader;
    private JLabel lbltitle;
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

    public BurgerShopViewOrders() {
        setTitle("View Orders");
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
        
        lbltitle = new JLabel("View Orders");
        lbltitle.setFont(new Font("", Font.PLAIN, 40));
        lbltitle.setForeground(Color.white);
        lbltitle.setBounds(370, 0, 430, 70);
        lbltitle.setVerticalAlignment(JLabel.CENTER);
        lbltitle.setHorizontalAlignment(JLabel.CENTER);
        lbltitle.setBackground(color);
        lbltitle.setOpaque(true);
        add(lbltitle);

        btnProcessingOrders = new JButton("Processing Orders");
        btnProcessingOrders.setBackground(color);
        btnProcessingOrders.setForeground(Color.white);
        btnProcessingOrders.setFont(new Font("SANS_SERIF", 1, 15));
        btnProcessingOrders.setBounds(470, 200, 200, 40);
        add(btnProcessingOrders);
        btnProcessingOrders.addActionListener(evt -> {
            new ViewOrdersProcessing().setVisible(true);
            dispose();
        });
        btnProcessingOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProcessingOrders.setBackground(colorg);
                btnProcessingOrders.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProcessingOrders.setBackground(color);
                btnProcessingOrders.setForeground(Color.white);
            }
        });

        btnDeliveredOrders = new JButton("Delivered Orders");
        btnDeliveredOrders.setBackground(color);
        btnDeliveredOrders.setForeground(Color.white);
        btnDeliveredOrders.setFont(new Font("SANS_SERIF", 1, 15));
        btnDeliveredOrders.setBounds(470, 270, 200, 40);
        add(btnDeliveredOrders);
        btnDeliveredOrders.addActionListener(evt -> {
            new ViewOrdersDelivered().setVisible(true);
            dispose();
        });
        btnDeliveredOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeliveredOrders.setBackground(colorg);
                btnDeliveredOrders.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeliveredOrders.setBackground(color);
                btnDeliveredOrders.setForeground(Color.white);
            }
        });

        btnCancelledOrder = new JButton("Cancelled Orders");
        btnCancelledOrder.setBackground(color);
        btnCancelledOrder.setForeground(Color.white);
        btnCancelledOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnCancelledOrder.setBounds(470, 340, 200, 40);
        add(btnCancelledOrder);
        btnCancelledOrder.addActionListener(evt -> {
            new ViewOrdersCancelled().setVisible(true);
            dispose();
        });
        btnCancelledOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelledOrder.setBackground(colorg);
                btnCancelledOrder.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelledOrder.setBackground(color);
                btnCancelledOrder.setForeground(Color.white);
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

        imgPanel = new JPanel(new FlowLayout());
        imgPanel.setBounds(0, 50, 370, 510);
        // Use the scaledIcon to create a JLabel
        lblImg = new JLabel(scaledIcon);
        // Add the JLabel to the imgPanel
        imgPanel.add(lblImg);
        add(imgPanel);
    }
}
