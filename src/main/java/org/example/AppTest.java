package org.example;

import javax.swing.*;
import java.awt.*;

public class AppTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Amba Cell");
        frame.setSize(400, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // BOTTOM NAVIGATION
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(0, 60)); // tinggi bottom bar
        sidebar.setLayout(new GridLayout(1, 4, 10, 0));
        sidebar.setBackground(new Color(45, 52, 54));

        JButton btnHome = new JButton("Home");
        JButton btnKatalog = new JButton("Katalog");
        JButton btnKeranjang = new JButton("Keranjang");
        JButton btnHistory = new JButton("History");

        sidebar.add(btnHome);
        sidebar.add(btnKatalog);
        sidebar.add(btnKeranjang);
        sidebar.add(btnHistory);

        // CONTENT
        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);

        contentPanel.add(createPage("HALAMAN HOME"), "HOME");
        contentPanel.add(createPage("HALAMAN KATALOG"), "PRODUK");
        contentPanel.add(createPage("HALAMAN HISTORY"), "TRANSAKSI");
        contentPanel.add(createPage("HALAMAN KERANJANG"), "LAPORAN");

        // ACTION
        btnHome.addActionListener(e -> cardLayout.show(contentPanel, "HOME"));
        btnKatalog.addActionListener(e -> cardLayout.show(contentPanel, "PRODUK"));
        btnHistory.addActionListener(e -> cardLayout.show(contentPanel, "TRANSAKSI"));
        btnKeranjang.addActionListener(e -> cardLayout.show(contentPanel, "LAPORAN"));

        // ADD TO FRAME
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.add(sidebar, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // HALAMAN
    private static JPanel createPage(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}