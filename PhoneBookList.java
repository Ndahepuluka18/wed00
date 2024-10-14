package GUI;

import java.util.ArrayList;

public class PhoneBookList {

    private PhonebookNode head;

    public void insert(PhoneBook contact) {
        PhonebookNode newNode = new PhonebookNode(contact);
        if (head == null) {
            head = newNode;
        } else {
            PhonebookNode current = head;
            PhonebookNode previous = null;

            while (current != null && current.contact.name.compareTo(contact.name) < 0) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                previous.next = newNode;
            }
        }
    }

    public boolean delete(String name) {
        if (head == null) return false;

        if (head.contact.name.equals(name)) {
            head = head.next;
            return true;
        }
        PhonebookNode current = head;
        PhonebookNode previous = null;

        while (current != null && !current.contact.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            return true;
        }

        return false;
    }
    public PhoneBook search(String name) {
        PhonebookNode current = head;
        while (current != null) {
            if (current.contact.name.equals(name)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }
    public void update(String name, String newPhone) {
        PhoneBook contact = search(name);
        if (contact != null) {
            contact.phone = newPhone;
        }
    }
    public String display() {
        StringBuilder result = new StringBuilder();
        PhonebookNode[] nodes = toArray();
        selectionSort(nodes);
        for (PhonebookNode node : nodes) {
            result.append(node.contact.toString()).append("\n");
        }
        return result.toString();
    }

    private PhonebookNode[] toArray() {
        ArrayList<PhonebookNode> list = new ArrayList<>();
        PhonebookNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list.toArray(new PhonebookNode[0]);
    }

    private void selectionSort(PhonebookNode[] nodes) {
        int n = nodes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nodes[j].contact.name.compareTo(nodes[minIndex].contact.name) < 0) {
                    minIndex = j;
                }
            }
            // Swap nodes
            PhonebookNode temp = nodes[minIndex];
            nodes[minIndex] = nodes[i];
            nodes[i] = temp;
        }
    }

}