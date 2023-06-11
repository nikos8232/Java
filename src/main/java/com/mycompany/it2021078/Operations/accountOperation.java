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
}
