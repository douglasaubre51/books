package com.library.windows;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LibraryWindow extends JFrame {
    public LibraryWindow(){
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel h1Label = new JLabel("Library");
        h1Label.setBounds(20, 0, 500, 50);
        h1Label.setFont(new Font("Serif", Font.BOLD, 30));
        add(h1Label);

        

        setVisible(true);
    }
}
