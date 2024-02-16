package View;

import static Controller.Controller.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BurgerShopPlaceOrder extends JFrame {
    Color color = new Color(191, 49, 49);
    Color colorg = new Color(101,183,65);
    private JLabel lblTitle;
    private JLabel lblOrdId;
    private JLabel lblOrdIdRes;
    private JLabel lblHr1;
    private JLabel lblCusId;
    private JTextField txtCusRes;
    private JLabel lblOrdQty;
    private JTextField txtQTYRes;
    private JLabel lblOrdStatus;
    private JLabel lblOrdStatusRes;
    private JLabel lblNetTotal;
    private JLabel lblNetTotalRes;
    private JButton btnPlaceOrder;
    private JButton btnBackToHome;
    private JButton btnCancel;

    public BurgerShopPlaceOrder() {
        setTitle("Place Orde");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitle = new JLabel("Place Order");
        lblTitle.setFont(new Font("", Font.PLAIN, 40));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(0, 0, 800, 70);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBackground(color);
        lblTitle.setOpaque(true);
        add(lblTitle);

        lblOrdId = new JLabel("Order Id        : ");
        lblOrdId.setFont(new Font("", Font.BOLD, 15));
        lblOrdId.setForeground(Color.black);
        lblOrdId.setBounds(100, 150, 100, 20);
        add(lblOrdId);

        //Order Id Placeholder
        lblOrdIdRes = new JLabel(generateOrderId());
        lblOrdIdRes.setFont(new Font("", Font.BOLD, 15));
        lblOrdIdRes.setForeground(Color.black);
        lblOrdIdRes.setBounds(200, 150, 100, 20);
        add(lblOrdIdRes);

        lblCusId = new JLabel("Customer Id : ");
        lblCusId.setFont(new Font("", Font.BOLD, 15));
        lblCusId.setForeground(Color.black);
        lblCusId.setBounds(100, 200, 100, 20);
        add(lblCusId);

        //Customer Id Placeholder
        txtCusRes = new JTextField();
        txtCusRes.setFont(new Font("", Font.BOLD, 15));
        txtCusRes.setForeground(Color.black);
        txtCusRes.setBounds(200, 200, 100, 20);
        add(txtCusRes);

        lblHr1 = new JLabel("---------------------------------------------------------------------------------------");
        lblHr1.setFont(new Font("", Font.PLAIN, 15));
        lblHr1.setForeground(Color.black);
        lblHr1.setBounds(50, 250, 500, 20);
        add(lblHr1);

        lblOrdQty = new JLabel("Burger QTY  : ");
        lblOrdQty.setFont(new Font("", Font.BOLD, 15));
        lblOrdQty.setForeground(Color.black);
        lblOrdQty.setBounds(100, 300, 110, 20);
        add(lblOrdQty);

        //QTY Placeholder
        txtQTYRes = new JTextField();
        txtQTYRes.setFont(new Font("", Font.BOLD, 15));
        txtQTYRes.setForeground(Color.black);
        txtQTYRes.setBounds(203, 300, 100, 20);
        add(txtQTYRes);

        lblOrdStatus = new JLabel("Order Status : ");
        lblOrdStatus.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatus.setForeground(Color.black);
        lblOrdStatus.setBounds(100, 350, 150, 20);
        add(lblOrdStatus);

        //Ord Status Placeholder
        lblOrdStatusRes = new JLabel("Preparing");
        lblOrdStatusRes.setFont(new Font("", Font.BOLD, 15));
        lblOrdStatusRes.setForeground(Color.black);
        lblOrdStatusRes.setBounds(203, 350, 100, 20);
        add(lblOrdStatusRes);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBackground(color);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setFont(new Font("SANS_SERIF", 1, 15));
        btnPlaceOrder.setBounds(520, 150, 200, 40);
        add(btnPlaceOrder);
        btnPlaceOrder.addActionListener(evt -> {

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

        btnBackToHome = new JButton("Back To Home Page");
        btnBackToHome.setBackground(color);
        btnBackToHome.setForeground(Color.white);
        btnBackToHome.setFont(new Font("SANS_SERIF", 1, 15));
        btnBackToHome.setBounds(520, 240, 200, 40);
        add(btnBackToHome);
        btnBackToHome.addActionListener(evt -> {
            new BurgerShopHome().setVisible(true);
            dispose();
        });
        btnBackToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackToHome.setBackground(colorg);
                btnBackToHome.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToHome.setBackground(color);
                btnBackToHome.setForeground(Color.white);
            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(color);
        btnCancel.setForeground(Color.white);
        btnCancel.setFont(new Font("SANS_SERIF", 1, 15));
        btnCancel.setBounds(520, 330, 200, 40);
        add(btnCancel);
        btnCancel.addActionListener(evt -> {

        });
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancel.setBackground(colorg);
                btnCancel.setForeground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancel.setBackground(color);
                btnCancel.setForeground(Color.white);
            }
        });

        lblNetTotal = new JLabel("NET Total : ");
        lblNetTotal.setFont(new Font("", Font.BOLD, 15));
        lblNetTotal.setForeground(Color.black);
        lblNetTotal.setBounds(520, 450, 150, 20);
        add(lblNetTotal);

        lblNetTotalRes = new JLabel("7500.00");
        lblNetTotalRes.setFont(new Font("", Font.BOLD, 15));
        lblNetTotalRes.setForeground(color);
        lblNetTotalRes.setBounds(620, 450, 150, 20);
        add(lblNetTotalRes);
    }
}
