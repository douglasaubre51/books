package com.library.windows;

import javax.swing.JFrame;

import com.library.repositories.AccountRepository;
import com.library.tools.UITools;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginWindow extends JFrame {

    public LoginWindow(String name){
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle(name);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel h1Label = new JLabel("Log in");
        h1Label.setBounds(20, 0, 500, 50);
        h1Label.setFont(new Font("Serif", Font.BOLD, 30));
        add(h1Label);

        JLabel emailLabel = new JLabel("email:");
        emailLabel.setBounds(20, 60, 100, 20);
        add(emailLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(110, 60, 200, 20);
        add(emailTextField);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(20, 80, 100, 20);
        add(passwordLabel);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(110, 80, 200, 20);
        add(passwordTextField);

        JButton submitButton = new JButton("log in");
        submitButton.setBounds(40, 140, 80, 20);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean result = false;
                UITools tools = new UITools();

                String email = emailTextField.getText();
                String password = passwordTextField.getText();

                boolean isValid = tools.validateFields(emailTextField, passwordTextField);

                if (isValid) {
                    AccountRepository repository = new AccountRepository(email, password);
                    result = repository.login();

                    tools.clearTextFields(emailTextField, passwordTextField);
                }

                if (result==true) {
                    System.out.println("login success!");
                } else {
                    System.out.println("login failure!");
                }
            }
        });
        add(submitButton);

        JButton resetButton = new JButton("clear");
        resetButton.setBounds(140, 140, 70, 20);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UITools tools = new UITools();
                tools.clearTextFields(emailTextField, passwordTextField);
            }
        });
        add(resetButton);

        JButton createAccountButton = new JButton("create account");
        createAccountButton.setBounds(260, 140, 150, 20);
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
