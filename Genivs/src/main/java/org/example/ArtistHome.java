package org.example;

import java.util.Scanner;

public class ArtistHome {

    public static void show(Account currentAcc, Scanner scanner) {


        while (true){

            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("WELCOME " + currentAcc.getUsername());
            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("***********************");


            System.out.println("1-Create Song");
            System.out.println("2-Edit Song Details");
            System.out.println("3-Logout");




            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {

                Song.createSong(scanner, currentAcc);


            }


            else if (choice.equals("2")) {

                Song.editSongDetails(scanner, currentAcc);

            }


            else if (choice.equals("3")) {


                break;
            }



            else
                System.out.println("Wrong choice!");
        }
    }

}
