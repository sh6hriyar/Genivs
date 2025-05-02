package org.example;

import java.util.Scanner;

public class Artist {


    private static void showArtistsDetails() {
        for (Account artist : DB.accounts){
            if (artist.getRole().equals("artist")) {
                System.out.println(artist.getName() + " @" + artist.getUsername() );
            }
        }
    }


    private static Account checkIfArtistExists(String username) {
        for (Account artist : DB.accounts){
            if (artist.getUsername().equals(username)) {
                return artist;
            }
        }
        return null;
    }


    private static void followUnfollowArtist(Scanner scanner, Account member, String artistUsername) {
        if (member.followingArtists.contains(artistUsername)) {
            System.out.print("Unfollow artist?(enter 1 to agree, anything else to ignore!): ) ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                member.followingArtists.remove(artistUsername);
            }
        }
        else {
            System.out.print("Follow artist?(enter 1 to agree, anything else to ignore!): ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                member.followingArtists.add(artistUsername);
            }

        }

    }


    private static void showArtistsMusicsToMember(Scanner scanner, Account artist, Account member) {
        System.out.print("Enter 1 to musics details or anything else to ignore: ");
        String option = scanner.nextLine();
        if (option.equals("1")) {
            for (Song song : DB.songs) {
                if (artist.getUsername().equals(song.getArtist())){
                    System.out.println(song.getTitle() + "\\" + song.getGenre());
                    System.out.println("*******");
                }
            }
            showSong(scanner, member);
        }
    }

    private static void showArtistsMusicsToMembersOrFollowUnfo(Scanner scanner, Account member, String artistUsername) {
        while (true){
            System.out.println("1-follow or unfollow artists? ");
            System.out.println("2-show content");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                followUnfollowArtist(scanner, member, artistUsername);
                break;
            }
            else if (option.equals("2")) {
                showArtistsMusicsToMember(scanner, checkIfArtistExists(artistUsername), member);
                break;
            }
            else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void showSong(Scanner scanner, Account member) {
        while (true){
            System.out.print("enter song title(enter cancel to...): ");

            String title = scanner.nextLine();

            if (Song.checkTitleToShowLyrics(title)) {
                Song.showLyrics(title, scanner);
                Song.addOrRemoveSongToFavoriteSongs(scanner, member, title);
            } else if (title.equals("cancel")) {
                break;

            } else {
                System.out.println("Invalid song title!");
            }
        }
    }



    public static void browseArtist(Scanner scanner, Account member) {
        while (true) {
            showArtistsDetails();
            System.out.print("Enter artist Username(enter *CANCEL* to cancel browsing): ");
            String artistUsername = scanner.nextLine();
            if (artistUsername.equals("CANCEL")) {
                break;
            } else if (checkIfArtistExists(artistUsername) != null) {
                showArtistsMusicsToMembersOrFollowUnfo(scanner, member, artistUsername);



            }else
                System.out.println("Artist does not exist");

        }
    }

    public static void browseFollowingArtist(Scanner scanner, Account member, String artistUsername) {
        while (true) {
            showFollowingArtistDetails(member);
            System.out.print("Enter artist Username(enter *CANCEL* to cancel browsing): ");
            String choice = scanner.nextLine();
            if (choice.equals("CANCEL")) {
                break;
            } else if (checkIfArtistExists(artistUsername) != null) {
                followUnfollowArtist(scanner, member, artistUsername);
                showArtistsMusicsToMember(scanner, checkIfArtistExists(artistUsername), member);

            }else
                System.out.println("Artist does not exist");


        }
    }

    private static void showFollowingArtistDetails(Account member) {
        for (Account account : DB.accounts){
            for (String artistUsername : member.followingArtists){
                if (artistUsername.equals(account.getUsername())){
                    System.out.println(account.getUsername() + " @" + account.getUsername());
                    System.out.println("********");
                    break;
                }
            }
        }
    }

}
