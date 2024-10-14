package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends Form {

    private PhoneBookList phoneBookList;
    private JTextArea textArea;
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

        phoneB.setHorizontalAlignment(SwingConstants.CENTER);

        add(phoneB);

        // just created

        // end


        // Create a insert button

        JButton insert = new JButton("Insert");
        insert.setBounds(10,150,150,30);
        insert.setFont(new Font("Dialog", Font.BOLD, 18));
        add(insert);
        insert.addActionListener(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e) {
                new InsertContact();
                dispose();
            }


        });


        // Create update button
        JButton update = new JButton("Update");
        update.setBounds(170,150,150,30);
        update.setFont(new Font("Dialog", Font.BOLD, 18));
        add(update);

        // adding action listener
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateContact();
                dispose();
            }
        });


        // create delete button
        JButton delete = new JButton("Delete");
        delete.setBounds(330,150,150,30);
        delete.setFont(new Font("Dialog", Font.BOLD, 18));
        add(delete);

        // adding action listener
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteContact();
                dispose();
            }
        });



        // create a search button
        JButton search = new JButton("Search");
        search.setBounds(10,180,150,30);
        search.setFont(new Font("Dialog", Font.BOLD, 18));
        add(search);

        // adding action listener
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchContact();
                dispose();
            }
        });

        // create a Display button
        JButton display = new JButton("Display");
        display.setBounds(170,180,150,30);
        display.setFont(new Font("Dialog", Font.BOLD, 18));
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayContacts();
            }
        });
        add(display);

        // create exit button
        JButton exit = new JButton("Exit");
        exit.setBounds(330,180,150,30);
        exit.setFont(new Font("Dialog", Font.BOLD, 18));
        add(exit);
        // add action listener
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // create the text area
        textArea = new JTextArea(10,50);
        textArea.setBounds(30,230,400,400);
        textArea.setFont(new Font("Dialog",Font.BOLD,16));
        textArea.setEditable(false);
        add(textArea);

        // add a scroll pane to the textArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30,230,400,400);
        add(scrollPane);


        setVisible(true);



    }

    private void displayContacts() {
        textArea.setText(phoneBookList.display());
    }
}

