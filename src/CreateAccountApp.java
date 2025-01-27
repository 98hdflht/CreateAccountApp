// Quincy Yarbrough
// 7/25/2024
// updated a create account app to accept phone numbers and email

import java.util.Scanner;

public class CreateAccountApp {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fullName = getFullName();
        System.out.println();

        String password = getPassword();
        System.out.println();
        // to get email
        String email = getEmail();
        System.out.println();
        // to get phone number
        String phone = getPhone();
        System.out.println();

        String msg = getSuccessMessage(fullName, phone);
        System.out.println(msg);
    }

    private static String getFullName() {
        while(true) {
            System.out.print("Enter full name: ");
            String name = sc.nextLine().trim();
            if (name.contains(" ")) {
                return name;
            } else {
                System.out.println("You must enter your full name.\n");
            }
        }
    }

    private static String getPassword() {
        while (true) {
            System.out.print("Enter password: ");
            String password = sc.nextLine().trim();

            boolean isMinLength = false;
            boolean hasDigit =false;
            boolean hasUppercase = false;

            if (password.length() >= 8) {
                isMinLength = true;
            }

            for (char c: password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                }
            }

            if (isMinLength && hasDigit && hasUppercase) {
                return password;
            } else {
                System.out.println("Password must be 8 characters or more\n" + "with at least one digit and one uppercase letter.\n");
            }
        }
    }
    // function to retrieve email from user
    private static String getEmail() {
        while (true) {
            System.out.print("Enter EMail: ");
            String email = sc.nextLine().trim();

            boolean hasAt = false;
            boolean hasCom = false;

            if (email.contains("@")) {
                hasAt = true;
            }
            if (email.endsWith(".com")) {
                hasCom = true;
            }

            if (hasAt && hasCom) {
                return email;

            } else {
                System.out.println("Please enter a valid EMail address.\n");
            }

        }
    }
    // function to retrieve phone number from user
    private static String getPhone() {
        while (true) {
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine().trim();
            // used to strip the number clean
            phone = phone.replaceAll("\\D", "");
            // check for length and format the number
            if (phone.length() == 10) {
                return phone.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1.$2.$3");
            } else {
                System.out.println("Please enter a valid phone number\n.");
            }
        }

    }
    // updated success message
    private static String getSuccessMessage(String fullName, String phone) {
        int index = fullName.indexOf(" ");
        String firstName = fullName.substring(0,1).toUpperCase() + fullName.substring(1, index).toLowerCase();
        return "Hi " + firstName + ", thanks for creating an account! We will text your confirmation code to this number:  " + phone;
    }
}