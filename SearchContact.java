package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchContact extends Form{
    private PhoneBookList phoneBookList;
    private JTextField fieldName;
    private JTextField phoneField;

    public SearchContact(){
        super("Search Contact");
        addGuiComponent();

    }

    private void addGuiComponent() {

        JLabel editContact = new JLabel("Search Contact");
        editContact.setBounds(0,20,500,100);
        editContact.setHorizontalAlignment(SwingConstants.CENTER);
        editContact.setFont(new Font("Dialog", Font.BOLD,30));
        add(editContact);

        // Create a name label
        JLabel name = new JLabel("Name");
        name.setBounds(30,100,400,100);
        name.setFont(new Font("Dialog",Font.BOLD,20));
        add(name);

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
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboard();
                dispose();
            }
        });

        // Create save button
        JButton save = new JButton("Search");
        save.setBounds(225,500,150,40);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });
        add(save);

        setVisible(true);

    }
    private void searchContact() {
        String name = fieldName.getText().trim();
        PhoneBook contact = phoneBookList.search(name);
        if (contact != null) {
            phoneField.setText(contact.phone);
        } else {
            JOptionPane.showMessageDialog(this, "Contact not found");
        }
    }

}
