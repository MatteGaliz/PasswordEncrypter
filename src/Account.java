import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        crypt();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void crypt() {
        byte[] decrypted = password.getBytes();
        byte[] crypted = new byte[decrypted.length];
        for (int i = 0; i < decrypted.length; i++) {
            crypted[i] = (byte) ((i % 2 == 0) ? decrypted[i] + 8 : decrypted[i] - 8);
        }
        password = new String(crypted);
    }

    public void decrypt() {
        byte[] crypted = password.getBytes();
        byte[] decrypted = new byte[crypted.length];
        for (int i = 0; i < decrypted.length; i++) {
            decrypted[i] = (byte) ((i % 2 == 0) ? crypted[i] - 8 : crypted[i] + 8);
        }
        password = new String(decrypted);
    }

    public String toString() {
        decrypt();
        String decryptedPwd = password;
        crypt();
        return "username: " + username + " \t password:" + decryptedPwd;
    }
}