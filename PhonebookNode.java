package GUI;

public class PhonebookNode {

    public PhoneBook contact;
    public PhonebookNode next;

    public PhonebookNode(PhoneBook contact){
        this.contact = contact;
        this.next = null;

    }
}
