package com.library.windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.library.models.Book;
import com.library.repositories.BookRepository;
import com.library.tools.UITools;
import com.library.types.WindowType;

public class LibraryWindow extends JFrame {
    public LibraryWindow(String name) {
        setTitle(name);
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel h1Label = new JLabel("Library");
        h1Label.setBounds(20, 0, 500, 50);
        h1Label.setFont(new Font("Serif", Font.BOLD, 30));
        add(h1Label);

        JLabel nameLabel = new JLabel("book name:");
        nameLabel.setBounds(20, 60, 100, 20);
        add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(110, 60, 200, 20);
        add(nameTextField);

        JButton getBookButton = new JButton("details");
        getBookButton.setBounds(20, 100, 200, 50);
        getBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UITools tools = new UITools();
                boolean isValid = tools.validateFields(nameTextField);

                if (isValid) {
                    String name = nameTextField.getName();
                    BookRepository _repository = new BookRepository();
                    Book book = _repository.getBook(name);

                    JLabel[] labels = new JLabel[] {
                            new JLabel("name:"), new JLabel("author:"), new JLabel("price:")
                    };

                    JLabel[] bookLabels = new JLabel[] {
                            new JLabel(book.name), new JLabel(book.author), new JLabel(book.price)
                    };

                    int incrementX = 20;
                    int incrementY = 40;

                    for (JLabel l : labels) {
                        l.setBounds(incrementX, incrementY, 200, 20);
                        add(l);
                        incrementY += 40;
                    }

                    incrementX = 50;
                    incrementY = 40;

                    for (JLabel bl : bookLabels) {
                        bl.setBounds(incrementX, incrementY, 200, 20);
                        add(bl);
                        incrementY += 40;
                    }
                } else {
                    PopUpWindow window = new PopUpWindow("error!", "empty fields!", WindowType.LIBRARY);
                    dispose();
                }
            }
        });
        add(getBookButton);

        setVisible(true);
    }
}
