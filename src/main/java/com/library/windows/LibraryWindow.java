package com.library.windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
                    String name = nameTextField.getText();
                    System.out.println("name" + name);
                    BookRepository _repository = new BookRepository();
                    Book book = _repository.getBook(name);

                    if (book != null) {
                        System.out.println("hello" + book.name);

                        JTextField bookNameTextField = new JTextField();
                        bookNameTextField.setText(book.name);
                        bookNameTextField.setBounds(20, 100, 70, 20);
                        add(bookNameTextField);
                        JOptionPane.showMessageDialog(null, "name: "+book.name + "\n" +"author: "+ book.author + "\n"+"price: " + book.price+" rs",
                                "result", JOptionPane.INFORMATION_MESSAGE);


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
