import java.util.Scanner;

class Organization implements Cloneable {
    private String organizationCode;
    private String organizationName;
    private String organizationAddress;

    // Constructor
    public Organization(String organizationCode, String organizationName, String organizationAddress) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.organizationAddress = organizationAddress;
    }

    // Getter methods
    public String getOrganizationCode() {
        return organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    // Method to print object details
    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    // Overriding clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for Organization details
        System.out.print("Enter Organization Code: ");
        String orgCode = scanner.nextLine();

        System.out.print("Enter Organization Name: ");
        String orgName = scanner.nextLine();

        System.out.print("Enter Organization Address: ");
        String orgAddress = scanner.nextLine();

        // Creating an object of Organization class
        Organization org1 = new Organization(orgCode, orgName, orgAddress);

        // Printing details of original object
        System.out.println("Original Object Details:");
        org1.printDetails();

        // Cloning the object
        Organization org2 = null;
        try {
            org2 = (Organization) org1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Printing details of cloned object
        System.out.println("\nCloned Object Details:");
        if (org2 != null) {
            org2.printDetails();
        }

        scanner.close();
    }
}
