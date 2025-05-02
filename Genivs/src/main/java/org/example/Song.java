package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String artist;
    private String genre;
    private String lyrics;



    public Song(String title, String artist, String genre, String lyrics) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.lyrics = lyrics;
    }

    public static void saveSongToFile(Song song) {
        DB.songs.add(song);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("song.dat"));
            out.writeObject(DB.songs);
            System.out.println("Song saved to file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void loadSongFromFile() throws IOException, ClassNotFoundException {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("song.dat"));
            DB.songs = (List<Song>) in.readObject();
    }


    public static void createSong(Scanner scanner, Account currentAcc) {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Lyrics(line 1 + enter + line 2 + enter + ... + line n + enter + * + enter): ");
        String line;
        StringBuilder lyricsString = new StringBuilder();
        while (!(line = scanner.nextLine()).equals("*")) {
            lyricsString.append(line).append("\n");
        }
        String lyrics = lyricsString.toString();

        Song newSong = new Song(title, currentAcc.getUsername(), genre, lyrics);
        Song.saveSongToFile(newSong);
    }




    private static List<String> showArtistSongs(Account currentAcc) {
        List<String> titles = new ArrayList<>();
        for (Song song : DB.songs) {
            if (song.artist.equals(currentAcc.getUsername())) {
                System.out.println(song.title);
                titles.add(song.title);

            }
        }
        return titles;

    }





    public static void editSongDetails(Scanner scanner, Account currentAcc) {
        List<String> titles = showArtistSongs(currentAcc);
        if (!titles.isEmpty()) {
            while (true) {
                System.out.print("Enter title or *cancel* to cancel editing song : ");
                String title = scanner.nextLine();
                if (title.equals("cancel")) {
                    break;
                } else if (titles.contains(title)) {

                    for (Song song : DB.songs) {
                        if (song.title.equals(title)) {
                            System.out.println("1-Edit title");
                            System.out.println("2-Edit genre");
                            System.out.println("3-Edit lyrics");
                            System.out.println("4-Cancel editing");
                            String choice = scanner.nextLine();

                            if (choice.equals("1")) {
                                System.out.print("Enter new title: ");
                                song.setTitle(scanner.nextLine());
                                break;
                            }
                            else if (choice.equals("2")) {
                                System.out.print("Enter new genre: ");
                                song.setGenre(scanner.nextLine());
                                break;
                            }
                            else if (choice.equals("3")) {
                                System.out.print("Enter new lyrics(line 1 + enter + line 2 + enter + ... + line n + enter + * + enter): ");
                                song.setLyrics(scanner);
                                break;
                            }
                            else if (choice.equals("4")) {
                                break;
                            }else {
                                System.out.println("Wrong input!");
                                break;
                            }



                        }
                    }
                    break;


                }else
                    System.out.println("Wrong song title!");
            }
        }
        else {
            System.out.println("You did not create any songs!");
        }



    }
    public static void browseSongs(Scanner scanner, Account currentAcc) {
        for (Song song : DB.songs) {
            System.out.println(song);
            System.out.println("******");
        }
        whileForBrowse(scanner, currentAcc);

    }


     public static void showLyrics(String title, Scanner scanner) {
        for (Song song : DB.songs) {
            if (song.title.equals(title)) {
                System.out.println(song.title + " By " + song.artist);
                System.out.println("Lyrics:");
                System.out.println(song.lyrics);
                System.out.println("***press Enter to continue***");
                scanner.nextLine();
                break;
            }
        }
    }

    public static boolean checkTitleToShowLyrics(String title) {
        for (Song song : DB.songs) {
            if (song.title.equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static void addOrRemoveSongToFavoriteSongs(Scanner scanner, Account currentAcc, String title) {

        if (currentAcc.favoriteSongs.contains(title)) {
            System.out.print("remove song song from favorite song list?(enter 1 to agree) ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                currentAcc.favoriteSongs.remove(title);
            }
        }
        else {
            System.out.print("add song to favorite song list?(enter 1 to agree) ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                currentAcc.favoriteSongs.add(title);
            }
        }

    }


    private static void showFavoriteSongs(Account currentAcc) {
        for (Song gSong : DB.songs) {
            for (String lSong : currentAcc.favoriteSongs) {
                if (lSong.equals(gSong.title)) {
                    System.out.println(gSong);
                    System.out.println("*****");
                    break;
                }
            }
        }
    }

    public static void browseFavoriteSongs(Scanner scanner, Account currentAcc) {
        showFavoriteSongs(currentAcc);
        whileForBrowse(scanner, currentAcc);

    }

    private static void whileForBrowse(Scanner scanner, Account currentAcc) {
        while (true) {

            System.out.print("Enter title or *cancel* to cancel browsing: ");
            String title = scanner.nextLine();
            if (title.equals("cancel")) {
                break;
            } else if (checkTitleToShowLyrics(title)) {
                showLyrics(title, scanner);
                addOrRemoveSongToFavoriteSongs(scanner, currentAcc, title);


            }else
                System.out.println("wrong title!");

        }
    }



    public String getArtist(){
        return artist;
    }
    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }






    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(Scanner scanner) {
        String line;
        StringBuilder lyricsString = new StringBuilder();
        while (!(line = scanner.nextLine()).equals("*")) {
            lyricsString.append(line).append("\n");
        }
        String lyrics = lyricsString.toString();
        this.lyrics = lyrics;


    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }



    @Override
    public String toString() {
        return title + "\\" + genre + "\\" + "By " + artist;
    }
}


