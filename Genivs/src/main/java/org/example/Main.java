package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Account.loadAccFromDB();

        Scanner scanner = new Scanner(System.in);
        Menu.menu(scanner);


    }


}