
import java.io.IOException;
import java.util.Scanner;

public class JCrypter {
    public static void main(String[] args) {
        BasicCrypt crypter = new BasicCrypt();
       /* String data = "ciao123";

        System.out.println("Original: " + data);
        System.out.println("Crypted: " + cry);
        System.out.println("Decrypted: " + dec);
*/
        /*for (int i = 0; i < 3; i++) {
            crypter.addData();
        }
        crypter.printData();*/

        boolean active = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("--- Password storage ---");
        try {
            crypter.getSaveFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found");
        }
        while (active) {
            System.out.println("1. Visualize saved passwords");
            System.out.println("2. Add an account");
            System.out.println("3. Remove an account");
            System.out.println("4. Reset the account");
            System.out.println("9. Exit");
            int ch = scan.nextInt();
            switch (ch) {
                case 1:
                    crypter.printPassword();
                    break;
                case 2:
                    crypter.addPassword();
                    break;
                case 3:
                    crypter.removePassword();
                    break;
                case 4:
                    crypter.resetAccount();
                    break;
                case 9:
                    try {
                        crypter.saveFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    active = false;
                    break;
                default:
                    break;
            }
        }
    }
}