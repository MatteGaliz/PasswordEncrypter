import java.io.*;
import java.util.*;

public class BasicCrypt {

    HashMap<String, ArrayList<Account>> keeper;

    public BasicCrypt() {
        keeper = new HashMap<>();
    }

    public void addPassword() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert the account you want to store");
        String account = scan.next();
        System.out.println("Insert the username of the " + account + " account");
        String username = scan.next();
        System.out.println("Insert the password for the account " + username);
        String password = scan.next();
        scan.close();
        ArrayList<Account> accounts = keeper.get(account);
        Account a = new Account(username, password);
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(a);
        keeper.put(account, accounts);
    }

    public void printPassword() {
        keeper.forEach((key, value) -> System.out.println(key + " " + value.toString()));
    }

    public void removePassword(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert the account you want to remove");
        String accountToRemove = scan.next();
        System.out.println(keeper.get(accountToRemove).toString());
        System.out.println("What user do you want to remove?");
        String userToRemove = scan.next();
        scan.close();
        ArrayList<Account> accounts = keeper.get(accountToRemove);
        accounts.removeIf(account -> account.getUsername().equals(userToRemove));
    }

    public void resetAccount(){
        Scanner scan = new Scanner(System.in);
        boolean deleting = true;
        System.out.println("Are you sure you want to remove all the saved accounts?    y/n");
        String c = scan.next();
        if(c.equals("y") || c.equals("Y")){
            keeper.clear();
        }
    }

    public void saveFile() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(keeper);
        out.close();
        fileOut.close();
        System.out.println("Serialized data has been saved");
    }

    public void getSaveFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("save.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        keeper = (HashMap<String, ArrayList<Account>>) in.readObject();
        in.close();
        fileIn.close();
    }

}