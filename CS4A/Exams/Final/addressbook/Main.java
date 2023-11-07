import java.io.*;

class Main {
  public static void main(String[] args) {


  //WRITE TO FILE
    AddressBook book = new AddressBook("abcde");
/*
    for (int i = 1; i <= 100; i++) {
      Contact c = new Contact();
      c.age = i;
      c.email = "email" + i + "@gmail.com";
      c.telephone = "123-456-7094";
      c.lastName = "Last" + i;
      c.firstName = "First" + i;

      book.addContact(c);
    }

    System.out.println(book);

    try (
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("addressBook.dat"));      
    ) {
        outputStream.writeObject(book);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }*/


    //READ FROM FILE
    try (
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("addressBook.dat"));
    ) {
        book = (AddressBook) inputStream.readObject();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(book);
  }
}