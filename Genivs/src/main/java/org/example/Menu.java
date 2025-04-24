package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Menu {


    public static void menu(Scanner scanner) {

        System.out.println("****GENIVS****");
        System.out.println("                            ");
        System.out.println("  1. Login");
        System.out.println("  2. Register");
        System.out.println("  3. Exit");

        String choice = scanner.nextLine();

        if (Objects.equals(choice, "1")) {

            Account.loadAccFromDB();
        }

        else if (Objects.equals(choice, "2")) {

            Register.registeration(scanner);

        }

        else if (Objects.equals(choice, "3")) {}

        else {}


    }

}
