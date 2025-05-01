package org.example;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Account.loadAccFromDB();
        Song.loadSongFromFile();

        Scanner scanner = new Scanner(System.in);
        Menu.menu(scanner);


    }


}