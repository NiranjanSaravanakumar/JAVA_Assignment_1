import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class    {
    private String name;
    private String phoneNumber;
    private String email;


    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
 @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


class AddressBook {
    private List<Contact> contacts;


    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }


    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
  public void searchContactByName(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}


public class AddressBookApp {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
               switch (choice) {
                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(contact);
                    break;

                case 2:
                     System.out.println("\nContacts:");
                    addressBook.viewContacts();
                    break;

                case 3:

                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContactByName(searchName);
                    break;

                case 4:

                    System.out.println("Exiting the Address Book application.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}