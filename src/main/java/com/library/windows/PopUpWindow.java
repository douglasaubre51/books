package com.library.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.library.WindowType;

public class PopUpWindow extends JFrame {
    public PopUpWindow(String name, String message, WindowType windowType) {
        setLayout(null);
        setTitle(name);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(message);
        label.setBounds(30, 0, 250, 20);
        add(label);

        JButton Button = new JButton(name);
        Button.setBounds(30, 60, 100, 20);
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (windowType == windowType.LOGIN) {
                    LoginWindow window = new LoginWindow("ayane - ");
                    dispose();
                }
                if (windowType == windowType.CREATE_ACCOUNT) {
                    CreateAccountWindow window = new CreateAccountWindow("ayane - ");
                    dispose();
                }
                if (windowType == windowType.LIBRARY) {
                    LibraryWindow window = new LibraryWindow("ayane - ");
                    dispose();
                }
            }
        });
        add(Button);

        setVisible(true);
    }
}
