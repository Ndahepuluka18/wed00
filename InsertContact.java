package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InsertContact extends Form{
    private PhoneBookList phoneBookList;
    private JTextField fieldName;
    private JTextField phoneField;


    public InsertContact(){
        super("Edit");
        phoneBookList = new PhoneBookList();
        addGuiComponent();
    }

    private void addGuiComponent() {

        JLabel editContact = new JLabel("Insert Contact");
        editContact.setBounds(0,20,500,100);
        editContact.setHorizontalAlignment(SwingConstants.CENTER);
        editContact.setFont(new Font("Dialog", Font.BOLD,30));
        add(editContact);

        // Create a name label
        JLabel name = new JLabel("Name");
        name.setBounds(30,100,400,100);
        name.setFont(new Font("Dialog",Font.BOLD,20));
        add(name);

        // create the textField
        fieldName = new JTextField();
        fieldName.setBounds(110,139,300,25);
        fieldName.setFont(new Font("Dialog", Font.BOLD,18));
        add(fieldName);


        // Create  the Phone label
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(30,160,400,100);
        phoneLabel.setFont(new Font("Dialog",Font.BOLD,20));
        add(phoneLabel);

        // create the textField
        phoneField = new JTextField();
        phoneField.setBounds(110,200,300,25);
        phoneField.setFont(new Font("Dialog", Font.BOLD,18));
        add(phoneField);


        // Create cancel button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(55,500,150,40);
        add(cancel);

        // add action listener


        // Create save button
        JButton save = new JButton("Save");
        save.setBounds(225,500,150,40);

        // add action listener
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertContact();
            }
        });

        add(save);

        setVisible(true);

    }

    private void insertContact() {
        String name = fieldName.getText().trim();
        String phone = phoneField.getText().trim();
        if (validateInput(name, phone)) {
            phoneBookList.insert(new PhoneBook(name, phone));
            JOptionPane.showMessageDialog(this,"Contact saved successfully");
            clearFields();
        }
    }
    private boolean validateInput(String name, String phone) {
        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insert into both field.");
            return false;
        }
        return true;
    }

    private void clearFields() {
        fieldName.setText("");
        phoneField.setText("");
    }

}
