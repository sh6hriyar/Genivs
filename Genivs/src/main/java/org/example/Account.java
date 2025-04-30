package org.example;

import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;


public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;

    public Account(String name, String username, String email, String password, String role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public static void saveAccToDB(Account obj){

        try {
            DB.accounts.add(obj);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accObj.dat"));
            out.writeObject(DB.accounts);
            System.out.println("Saving Account to DB was successful");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void loadAccFromDB(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("accObj.dat"));
            DB.accounts = (List<Account>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }



}
