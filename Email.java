import java.util.Scanner;

public class Email {
  private String firstName;
  private String lastName;
  private int defaultPasswordLength = 10;
  private String email;
  private String password;
  private String department;
  private int mailboxCapacity = 500;
  private String alternateEmail;
  private String companySuffix = "wooddesigns.com";

  // Constructor
  public Email(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = setDepartment();
    this.password = randomPassword(defaultPasswordLength);

    System.out.println("Your password is: " + this.password);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
  }

  // Ask for department
  private String setDepartment() {
    System.out.println(
        "Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code:");
    Scanner in = new Scanner(System.in);
    int choice = in.nextInt();
    in.close();
    switch (choice) {
      case 1:
        return "sales";
      case 2:
        return "dev";
      case 3:
        return "acct";
      case 0:
        return "";
      default:
        return "";
    }
  }

  // Generate random pass
  private String randomPassword(int length) {
    String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567899!@#$%";
    char[] password = new char[length];
    for (int i = 0; i < length; i++) {
      int rand = (int) (Math.random() * passwordSet.length());
      password[i] = passwordSet.charAt(rand);
    }
    return new String(password);
  }

  // Set mailbox capacity
  public void setMailboxCapacity(int capacity) {
    this.mailboxCapacity = capacity;
  }

  // Set alternate email
  public void setAlternateEmail(String alt) {
    this.alternateEmail = alt;
  }

  // Change the password
  public void changePassword(String password) {
    this.password = password;
  }

  public int getMailboxCapacity() {
    return mailboxCapacity;
  }

  public String getAlternateEmail() {
    return alternateEmail;
  }

  public String getPassword() {
    return password;
  }

  public String showInfo() {
    return String.format("DISPLAY NAME: %s %s%nCOMPANY EMAIL: %s%nMAILBOX CAPACITY: %dmb", firstName, lastName, email,
        mailboxCapacity);
  }
}