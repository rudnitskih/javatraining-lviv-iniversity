package enums;

import javax.swing.*;

public class PersonReader {
    // reference https://stackoverflow.com/a/6555051
    public Person read() {
        JTextField nameField = new JTextField(5);
        JTextField statusField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Marriage status:"));
        myPanel.add(statusField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Name and Marriage status", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Person person = new Person(nameField.getText(), MaritalStatus.findByDbCode(Integer.parseInt(statusField.getText())));
            System.out.println(person);
            return person;
        } else {
            return null;
        }
    }
}
