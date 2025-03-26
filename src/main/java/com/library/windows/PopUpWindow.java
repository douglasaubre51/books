package com.library.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUpWindow extends JFrame{
    public PopUpWindow(String name){
        setLayout(null);
        setTitle(name);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("account created successfully!");
        label.setBounds(30, 0, 250, 20);
        add(label);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(30, 60, 100, 20);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginWindow window = new LoginWindow("ayane - login");
                dispose();
            }
        });
        add(loginButton);

        setVisible(true);
    }

    PopUpWindow(String name, String message) {
        setLayout(null);
        setTitle(name);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(message);
        label.setBounds(30, 0, 250, 20);
        add(label);

        JButton createAccountButton = new JButton("try again");
        createAccountButton.setBounds(30, 60, 100, 20);
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateAccountWindow window = new CreateAccountWindow("ayane - create new account!");
                dispose();
            }
        });
        add(createAccountButton);

        setVisible(true);

    }
}
