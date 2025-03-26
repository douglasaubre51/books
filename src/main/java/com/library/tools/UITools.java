package com.library.tools;

import javax.swing.*;

public class UITools {
     public boolean validateFields(JTextField a, JTextField b) {
        if (a.getText().trim().isEmpty() || b.getText().trim().isEmpty()) {
            return false;
        } else
            return true;
    }

    public boolean validateFields(JTextField a, JTextField b, JTextField c) {
        if (a.getText().trim().isEmpty() || b.getText().trim().isEmpty() || c.getText().trim().isEmpty()) {
            return false;
        } else
            return true;
    }

    public void clearTextFields(JTextField a, JTextField b) {
        a.setText("");
        b.setText("");
        return;
    }

    public void clearTextFields(JTextField a, JTextField b, JTextField c) {
        a.setText("");
        b.setText("");
        c.setText("");
        return;
    }

}
