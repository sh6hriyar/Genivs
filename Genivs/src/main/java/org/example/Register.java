package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Register {

    public static void registeration(Scanner scanner) {

        String name = validator(scanner,"Enter Your name(lowercase letters, min 3 chars, no spaces): ",
                "^[a-z]{3,100}$"  );
        String username = usernameValidator(scanner, "Enter Your Username(lowercase letters, min 3 chars, no spaces): ",
                "^[a-z]{3,100}$"  );
        String email = validator(scanner, "Enter Your Email address(example@example.com): ",
                "^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,})+$"  );
        String password = validator(scanner, "Enter Your Password(min 8 chars, upper and lower case, numbers and special chars): ",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$"  );
        String role = roleSelector(scanner);


        var account = new Account(name, username, email, password, role);


        Account.saveAccToDB(account);






    }



    private static String validator(Scanner scanner, String getterMessege, String regex ) {

        String case1;

        while (true){
            System.out.print(getterMessege);
            case1 = scanner.nextLine();
            if (!case1.matches(regex)) {
                System.out.println("invalid input!");
                System.out.println(case1);
            }
            else {
                break;
            }
        }
        return case1;
    }

    private static String roleValidator(Scanner scanner, String getterMessege, List<String> validOptions ) {

        String case1;

        while (true){
            System.out.print(getterMessege);
            case1 = scanner.nextLine();
            if (!validOptions.contains(case1.toLowerCase())) {
                System.out.println("invalid input!");
                System.out.println(case1);
            }
            else {
                break;
            }
        }
        return case1;
    }

    private static String roleSelector(Scanner scanner) {

        while (true){
            System.out.print("Choose Role(1-ARTIST, 2-MEMBER): ");
            String choi = scanner.nextLine();
            if (choi.equals("1")) {
                return "artist";
            }
            else if (choi.equals("2")) {
                return "member";
            }
            else {

                System.out.println("invalid input!");
            }
        }


    }

    private static String usernameValidator(Scanner scanner, String getterMessege, String regex ) {
        String case1;

        while (true){
            System.out.print(getterMessege);
            case1 = scanner.nextLine();
            if (!case1.matches(regex)) {
                System.out.println("invalid format!");
                System.out.println(case1);
            } else if (isExist(case1)) {
                System.out.println("username already exists!");
                System.out.println(case1);

            } else {
                break;
            }
        }
        return case1;
    }

    private static boolean isExist(String username) {
        for (Account acc : DB.accounts) {
            if (acc.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
