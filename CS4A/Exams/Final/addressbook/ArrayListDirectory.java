import java.util.ArrayList;

public class ArrayListDirectory implements ICompanyDirectory, DirectoryDisplay {
    private ArrayList<Contact> allContacts;
    private ArrayList<Contact> workers;

    public ArrayListDirectory() {
        allContacts = new ArrayList<>();
        workers = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact) throws Exception {
        if (allContacts.contains(contact))
            throw new Exception(String.format("Contact with id = {0} already exists", contact.getId()));
        
        allContacts.add(contact);

        if (contact instanceof Worker)
            workers.add(contact);
    }

    @Override
    public void removeContact(String id) {
        for (int i = 0; i < allContacts.size(); i++)
            if (allContacts.get(i).getId().equalsIgnoreCase(id)) {
                allContacts.remove(i);
                break;
            }
    }

    @Override
    public Contact getContact(String id) {
        for (Contact c : allContacts)
            if (c.getId().equalsIgnoreCase(id))
                return c;
        
        return null;
    }

    @Override
    public ArrayList<Contact> searchContact(String criteria) {
        
        ArrayList<Contact> matchingItems = new ArrayList<>();

        for (int i = 0; i < allContacts.size(); i++) {
            Contact next = allContacts.get(i);

            if (next.toString().contains(criteria))
                matchingItems.add(next);        
        }

        return matchingItems;
    }


    @Override
    public String getDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("DIRECTORY\n");
        sb.append("--------");

        for (Contact c : allContacts) {

            sb.append(c.toString());
            sb.append("\n\n");
        }

        sb.append("-------");

        return sb.toString();
    }
    
}
