package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteContact extends Form{
    private PhoneBookList phoneBookList;
    private JTextField fieldName;

    public DeleteContact(){
        super("Delete Contact");
        addGuiComponent();
    }

    private void addGuiComponent() {

        JLabel editContact = new JLabel("Delete Contact");
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





        // Create cancel button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(55,300,150,40);
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
        JButton save = new JButton("Delete");
        save.setBounds(225,300,150,40);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        add(save);


        setVisible(true);

    }
    private void deleteContact() {
        String name = fieldName.getText().trim();
        phoneBookList.delete(name);
        clearFields();
    }
    private void clearFields() {
        fieldName.setText("");
       // phoneField.setText("");
    }
}
