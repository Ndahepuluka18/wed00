package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends Form {

    private PhoneBookList phoneBookList;
    private JTextArea textArea;
    private JTextField fieldName,phoneField;
    public Dashboard() {
        super("Phone book");
        phoneBookList = new PhoneBookList();
        addGuiComponent();
    }

    private void addGuiComponent() {

        // create a phone book label
        JLabel phoneB = new JLabel("Phone Book");
        phoneB.setFont(new Font("Dialog", Font.BOLD,30));

        phoneB.setBounds(0,10,500,100);

        phoneB.setForeground(Colours.TEXT_COLOR);

        phoneB.setHorizontalAlignment(SwingConstants.CENTER);

        add(phoneB);




        // Create a name label
        JLabel name = new JLabel("Name");
        name.setBounds(30,100,400,100);
        name.setFont(new Font("Dialog",Font.BOLD,20));
        name.setForeground(Colours.TEXT_COLOR);
        add(name);

        // create the textField
        fieldName = new JTextField();
        fieldName.setBounds(110,139,300,25);
        fieldName.setFont(new Font("Dialog", Font.ITALIC,16));
        fieldName.setForeground(Colours.TEXT_COLOR);
        fieldName.setBackground(Colours.SECONDARY_COLOR);
        add(fieldName);


        // Create  the Phone label
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(30,160,400,100);
        phoneLabel.setFont(new Font("Dialog",Font.BOLD,20));
        phoneLabel.setForeground(Colours.TEXT_COLOR);
        add(phoneLabel);

        // create the textField
        phoneField = new JTextField();
        phoneField.setBounds(110,200,300,25);
        phoneField.setFont(new Font("Dialog", Font.ITALIC,16));
        phoneField.setForeground(Colours.TEXT_COLOR);
        phoneField.setBackground(Colours.SECONDARY_COLOR);
        add(phoneField);


        // Create a insert button

        JButton insert = new JButton("Insert");
        insert.setBounds(10,250,150,30);
        insert.setFont(new Font("Dialog", Font.BOLD, 18));
        insert.setBackground(Colours.TEXT_COLOR);
        insert.setForeground(Colours.PRIMARY_COLOR);
       // insert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(insert);
        insert.addActionListener(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e) {
                insertContact();
            }


        });


        // Create update button
        JButton update = new JButton("Update");
        update.setBounds(170,250,150,30);
        update.setFont(new Font("Dialog", Font.BOLD, 18));
        update.setForeground(Colours.PRIMARY_COLOR);
        update.setBackground(Colours.TEXT_COLOR);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        add(update);





        // create delete button
        JButton delete = new JButton("Delete");
        delete.setBounds(330,250,150,30);
        delete.setFont(new Font("Dialog", Font.BOLD, 18));
        delete.setBackground(Colours.TEXT_COLOR);
        delete.setForeground(Colours.PRIMARY_COLOR);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        add(delete);


        // create a search button
        JButton search = new JButton("Search");
        search.setBounds(10,280,150,30);
        search.setFont(new Font("Dialog", Font.BOLD, 18));
        search.setBackground(Colours.TEXT_COLOR);
        search.setForeground(Colours.PRIMARY_COLOR);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });
        add(search);



        // create a Display button
        JButton display = new JButton("Display");
        display.setBounds(170,280,150,30);
        display.setFont(new Font("Dialog", Font.BOLD, 18));
        display.setForeground(Colours.PRIMARY_COLOR);
        display.setBackground(Colours.TEXT_COLOR);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayContacts();
            }
        });
        add(display);

        // create exit button
        JButton exit = new JButton("Exit");
        exit.setBounds(330,280,150,30);
        exit.setFont(new Font("Dialog", Font.BOLD, 18));
        exit.setBackground(Colours.TEXT_COLOR);
        exit.setForeground(Colours.PRIMARY_COLOR);
        add(exit);
        // add action listener
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // create the text area
        textArea = new JTextArea(10,2);
        textArea.setBounds(40,320,400,300);
        textArea.setFont(new Font("Dialog",Font.BOLD,16));
        textArea.setForeground(Colours.TEXT_COLOR);
        textArea.setBackground(Colours.SECONDARY_COLOR);
        textArea.setEditable(false);
        add(textArea);

        // add a scroll pane to the textArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(40,320,400,300);
        scrollPane.setForeground(Colours.TEXT_COLOR);
        scrollPane.setBackground(Colours.SECONDARY_COLOR);
        add(scrollPane);


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
    private void updateContact() {
        String name = fieldName.getText().trim();
        String newPhone = phoneField.getText().trim();
        if (validateInput(name, newPhone)) {
            phoneBookList.update(name, newPhone);
            JOptionPane.showMessageDialog(this,"Contact updated successfully.");
            clearFields();
        }
    }

    private boolean validateInput(String name, String phone) {
        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Both fields must be filled.");
            return false;
        }
        return true;
    }

    private void clearFields() {
        fieldName.setText("");
        phoneField.setText("");
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
    private void deleteContact() {
        String name = fieldName.getText().trim();
        phoneBookList.delete(name);
        JOptionPane.showMessageDialog(this, "Contact deleted successfully.");
        clearFields();
    }

    private void displayContacts() {
        textArea.setText(phoneBookList.display());
    }
}

