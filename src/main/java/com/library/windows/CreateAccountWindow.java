package com.library.windows;

import javax.swing.JFrame;

import com.library.repositories.AccountRepository;
import com.library.tools.UITools;
import com.library.types.WindowType;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

public class CreateAccountWindow extends JFrame {
    public CreateAccountWindow(String name) {
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle(name);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel h1Label = new JLabel("Create an Account");
        h1Label.setBounds(20, 0, 500, 50);
        h1Label.setFont(new Font("Serif", Font.BOLD, 30));
        add(h1Label);

        JLabel nameLabel = new JLabel("username:");
        nameLabel.setBounds(20, 60, 100, 20);
        add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(110, 60, 200, 20);
        add(nameTextField);

        JLabel emailLabel = new JLabel("email:");
        emailLabel.setBounds(20, 80, 100, 20);
        add(emailLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(110, 80, 200, 20);
        add(emailTextField);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(20, 100, 100, 20);
        add(passwordLabel);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(110, 100, 200, 20);
        add(passwordTextField);

        JButton submitButton = new JButton("create");
        submitButton.setBounds(40, 140, 100, 20);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean result = false;

                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordTextField.getText();

                UITools tools = new UITools();

                boolean isValid = tools.validateFields(nameTextField, emailTextField, passwordTextField);

                if (isValid) {
                    AccountRepository repository = new AccountRepository(name, email, password);
                    result = repository.createNewAccount();
                }

                if (result) {
                    PopUpWindow window = new PopUpWindow("action result!", "account created successfully!",
                            WindowType.LOGIN);
                    dispose();
                } else {
                    PopUpWindow window = new PopUpWindow("action result!", "failed to create new account!",
                            WindowType.CREATE_ACCOUNT);
                    dispose();
                }

                tools.clearTextFields(nameTextField, emailTextField, passwordTextField);
            }
        });
        add(submitButton);

        JButton resetButton = new JButton("clear");
        resetButton.setBounds(200, 140, 100, 20);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UITools tools = new UITools();
                tools.clearTextFields(nameTextField, emailTextField, passwordTextField);
            }
        });
        add(resetButton);

        setVisible(true);

    }

}
