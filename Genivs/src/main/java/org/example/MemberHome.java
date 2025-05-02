package org.example;

import java.util.Scanner;

public class MemberHome {

    public static void show(Account currentAcc, Scanner scanner) {

        while (true) {
            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("WELCOME " + currentAcc.getUsername());
            System.out.println("***********************");
            System.out.println("***********************");
            System.out.println("***********************");


            System.out.println("1-Browse musics");
            System.out.println("2-Browse artists");
            System.out.println("3-Favorite songs");
            System.out.println("4-Following artists");
            System.out.println("5-Logout");
            String option = scanner.nextLine();


            if (option.equals("1")) {
                Song.browseSongs(scanner, currentAcc);
            }


            else if (option.equals("2")) {

                Artist.browseArtist(scanner, currentAcc);

            }


            else if (option.equals("3")) {
                Song.browseFavoriteSongs(scanner, currentAcc);
            }


            else if (option.equals("4")) {

                Artist.browseArtist(scanner, currentAcc);


            }





            else if (option.equals("5")) {
                break;
            }


            else
                System.out.println("Wrong input!");
        }



    }

}
