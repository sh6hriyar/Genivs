package org.example;

import java.util.Scanner;

public class Login {

    public static Account login(Scanner scanner) {
        while (true) {
            boolean user = false;
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();


            System.out.print("Enter your password: ");
            String password = scanner.nextLine();


            for (Account acc : DB.accounts) {


                if (acc.getUsername().equals(username)) {


                    if (acc.getPassword().equals(password)) {
                        return acc;
                    }else {
                        System.out.println("Wrong password");
                        user = true;
                        break;
                    }


                }



            }
            if (!user) {
                System.out.println("Wrong username");
            }



        }
    }

}
