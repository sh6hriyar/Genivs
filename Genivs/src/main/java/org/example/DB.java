package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Account> accounts = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();



    public static void saveAccounts() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accObj.dat"));
        out.writeObject(accounts);
    }

    public static void saveSongs() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("song.dat"));
        out.writeObject(songs);
    }

}
