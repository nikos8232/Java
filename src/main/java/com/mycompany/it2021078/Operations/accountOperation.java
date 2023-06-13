package com.mycompany.it2021078.Operations;

import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Accounts.Accounts;

import java.util.ArrayList;
import java.util.Scanner;

public class accountOperation {

    public String Register(ArrayList<Accounts> accounts){
        Scanner answer = new Scanner(System.in);
        System.out.println(Messages.ASK_USERNAME);
        String username = answer.nextLine();
        System.out.println(Messages.ASK_PASSWORD);
        String password = answer.nextLine();
        System.out.println(Messages.ASK_EMAIL);
        String email = answer.nextLine();
        accounts.add(new Accounts(email,username, password));
        return username;

    }

    public String LogIn(ArrayList<Accounts> accounts){
        if(accounts.isEmpty()){
            System.out.println("No accounts registered yet");
            return "";
        }
        Scanner answer = new Scanner(System.in);
        while(true) {
            System.out.println(Messages.ASK_USERNAME);
            String username = answer.nextLine();
            System.out.println(Messages.ASK_PASSWORD);
            String password = answer.nextLine();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                    System.out.println("Successfully logged in!\nWelcome " + username);
                    return username;
                }
            }
            System.out.println("Wrong username or password. Want to try again? Yes or no?");
            if (answer.nextLine().equalsIgnoreCase("NO")) {
                break;
            }
        }
        return "";
    }
}
