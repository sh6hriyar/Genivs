package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Register {

    public static void registeration(Scanner scanner) {

        String name = validator(scanner,"Enter Your name(lowercase letters, min 3 chars, no spaces): ",
                "^[a-z]{3,100}$"  );
        String username = validator(scanner, "Enter Your Username(lowercase letters, min 3 chars, no spaces): ",
                "^[a-z]{3,100}$"  );
        String email = validator(scanner, "Enter Your Email address(example@example.com): ",
                "^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,})+$"  );
        String password = validator(scanner, "Enter Your Password(min 8 chars, upper and lower case, numbers and special chars): ",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$"  );
        String role = roleValidator(scanner, "Enter Your Role(member or artist): ", Arrays.asList("member", "artist"));


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

}
