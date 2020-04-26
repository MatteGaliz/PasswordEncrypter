
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
            System.out.println("1. Visualizza le password salvate");
            System.out.println("2. Aggiungi un account");
            System.out.println("3. Rimuovi un account");
            System.out.println("9. Esci");
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