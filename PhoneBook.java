package GUI;

public class PhoneBook {
    public String name;
    public String phone;
    public  PhoneBook(String name, String phone){
        this.name = name;
        this.phone = phone;

    }
    @Override
    public String toString() {
        return name + " -> " + phone;
    }
}
