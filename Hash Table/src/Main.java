import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creating a hashTable with the capacity of 10
        HashTable<String, StudentEntry> hashTable = new HashTable<>(10);

        // ------------------------------------------------------------------------
        // Creating 10 instances of StudentEntry to later add them to the hashTable
        StudentEntry temp1 = new StudentEntry("John", "Smith", "Computer Science", 1988,
                new ContactInfo(5555555, "jsmith@email.com"));
        StudentEntry temp2 = new StudentEntry("Howard", "Calico", "Chemical Engineering", 1991,
                new ContactInfo(8675309, "hcalico@email.com"));
        StudentEntry temp3 = new StudentEntry("Yarah", "Bahri", "Psychology", 1976,
                new ContactInfo(6647665, "ybahri3@email.com"));
        StudentEntry temp4 = new StudentEntry("Aveline", "Macon", "Arts", 1991,
                new ContactInfo(7181234, "its_aveline@avelineworld.com"));
        StudentEntry temp5 = new StudentEntry("Pratik", "Gera", "Psychology", 1996,
                new ContactInfo(3232368, "pgera@email.com"));
        StudentEntry temp6 = new StudentEntry("Usui", "Aimi", "Psychology", 1996,
                new ContactInfo(4623457, "x_shadow_hunter_x03@gaming.com"));
        StudentEntry temp7 = new StudentEntry("Jane", "Smith", "Computer Science", 1990,
                new ContactInfo(5555555, "j2smith@email.com"));
        StudentEntry temp8 = new StudentEntry("Vreni", "Spitz", "Law", 1992,
                new ContactInfo(5554444, "vspitz@email.com"));
        StudentEntry temp9 = new StudentEntry("Pratik", "Comar", "Business", 1991,
                new ContactInfo(6645622, "pcomar@email.com"));
        StudentEntry temp10 = new StudentEntry("Padma", "Gera", "Arts", 1994,
                new ContactInfo(5554544, "pgera@realemail.org"));

        System.out.println("[INFO] Key format: 'Last 2 digits of birthYear + First 3 letters of lastName', \n[INFO] Hash function: 'Polynomial Hash'.");
        // Adding records of 10 different students to the hashTable and using the polynomial hash code
        hashTable.addEntry(temp1, 1, 1);
        hashTable.addEntry(temp2, 1, 1);
        hashTable.addEntry(temp3, 1, 1);
        hashTable.addEntry(temp4, 1, 1);
        hashTable.addEntry(temp5, 1, 1);
        hashTable.addEntry(temp6, 1, 1);
        hashTable.addEntry(temp7, 1, 1);
        hashTable.addEntry(temp8, 1, 1);
        hashTable.addEntry(temp9, 1, 1);
        hashTable.addEntry(temp10, 1, 1);

        // Printing the "Fullname Lastname, birthday -- unique KEY"
        System.out.println("------------------");
        hashTable.print(1);
        System.out.println("------------------");

        // Printing some stats
        System.out.println("------------------");
        hashTable.printStats();
        System.out.println("------------------");
        // ------------------------------------------------------------------------

        System.out.print("[PERMISSION] Continue? Please enter anything once you are ready to proceed :) = ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Now making another hashTable
        HashTable<Integer, StudentEntry> hashTable2 = new HashTable<>(10);

        System.out.println("[INFO] Key format: 'birthYear + lastName.length() * firstName.length()', \n[INFO] Hash function: 'Direct Int Hash'.");
        // Adding records of 10 different students to the hashTable but this time we will directly use the int hash code
        hashTable2.addEntry(temp1, 2, 2);
        hashTable2.addEntry(temp2, 2, 2);
        hashTable2.addEntry(temp3, 2, 2);
        hashTable2.addEntry(temp4, 2, 2);
        hashTable2.addEntry(temp5, 2, 2);
        hashTable2.addEntry(temp6, 2, 2);
        hashTable2.addEntry(temp7, 2, 2);
        hashTable2.addEntry(temp8, 2, 2);
        hashTable2.addEntry(temp9, 2, 2);
        hashTable2.addEntry(temp10, 2, 2);

        // Printing the "Fullname Lastname, birthday -- unique KEY"
        System.out.println("------------------");
        hashTable2.print(2);
        System.out.println("------------------");

        // Printing some stats
        System.out.println("------------------");
        hashTable2.printStats();
        System.out.println("------------------");
        // ------------------------------------------------------------------------

        System.out.print("[PERMISSION] Continue? Please enter anything once you are ready to proceed :) = ");
        scanner.nextLine();

        // Now making another hashTable
        HashTable<Integer, StudentEntry> hashTable3 = new HashTable<>(10);

        System.out.println("[INFO] Key format: 'birthYear + lastName.length() * firstName.length()', \n[INFO] Hash function: 'Polynomial Hash'.");
        // Adding records of 10 different students to the hashTable
        hashTable3.addEntry(temp1, 2, 1);
        hashTable3.addEntry(temp2, 2, 1);
        hashTable3.addEntry(temp3, 2, 1);
        hashTable3.addEntry(temp4, 2, 1);
        hashTable3.addEntry(temp5, 2, 1);
        hashTable3.addEntry(temp6, 2, 1);
        hashTable3.addEntry(temp7, 2, 1);
        hashTable3.addEntry(temp8, 2, 1);
        hashTable3.addEntry(temp9, 2, 1);
        hashTable3.addEntry(temp10, 2, 1);

        // Printing the "Fullname Lastname, birthday -- unique KEY"
        System.out.println("------------------");
        hashTable3.print(2);
        System.out.println("------------------");

        // Printing some stats
        System.out.println("------------------");
        hashTable3.printStats();
        System.out.println("------------------");
        // ------------------------------------------------------------------------

        System.out.print("[PERMISSION] Continue? Please enter anything once you are ready to proceed :) = ");
        scanner.nextLine();

        // Now making another hashTable
        HashTable<String, StudentEntry> hashTable4 = new HashTable<>(10);

        System.out.println("[INFO] Key format: 'First letter of firstName + First letter of lastName + First digit of birthYear + Last digit of birthYear + firstName.length()', \n[INFO] Hash function: 'Polynomial Hash'.");
        // Adding records of 10 different students to the hashTable and we again use the polynomial hash code
        hashTable4.addEntry(temp1, 3, 1);
        hashTable4.addEntry(temp2, 3, 1);
        hashTable4.addEntry(temp3, 3, 1);
        hashTable4.addEntry(temp4, 3, 1);
        hashTable4.addEntry(temp5, 3, 1);
        hashTable4.addEntry(temp6, 3, 1);
        hashTable4.addEntry(temp7, 3, 1);
        hashTable4.addEntry(temp8, 3, 1);
        hashTable4.addEntry(temp9, 3, 1);
        hashTable4.addEntry(temp10, 3, 1);

        // Printing the "Fullname Lastname, birthday -- unique KEY"
        System.out.println("------------------");
        hashTable4.print(3);
        System.out.println("------------------");

        // Printing some stats
        System.out.println("------------------");
        hashTable4.printStats();
        System.out.println("------------------");

        // ------------------------------------------------------------------------
    }
}
