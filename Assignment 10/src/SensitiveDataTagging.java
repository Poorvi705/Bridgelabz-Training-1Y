// Custom marker interface
interface SensitiveData {
    // No methods – marker interface only
}

// Example class containing sensitive data
class UserCredentials implements SensitiveData {

    private String username;
    private String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{username='" + username + "', password='" + password + "'}";
    }
}

// Another class without sensitive data
class PublicInfo {
    private String info;

    PublicInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "PublicInfo{info='" + info + "'}";
    }
}

// Main class
public class SensitiveDataTagging {

    // Method to simulate encryption for sensitive objects
    public static void processObject(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + obj);
        } else {
            System.out.println("No encryption needed: " + obj);
        }
    }

    public static void main(String[] args) {

        UserCredentials credentials = new UserCredentials("alice", "pass123");
        PublicInfo info = new PublicInfo("Company Address");

        processObject(credentials); // Should trigger encryption
        processObject(info);        // No encryption
    }
}