package com.mycompany.it2021078;
import com.mycompany.it2021078.Constants.AsciiArt;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Operations.accountOperation;
import com.mycompany.it2021078.Operations.addShowOperation;
import com.mycompany.it2021078.Operations.searchShowOperation;
import com.mycompany.it2021078.Model.Accounts.Accounts;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.Favorite;
import com.mycompany.it2021078.Operations.searchActorDirectorOperation;
import static com.mycompany.it2021078.Operations.searchActorDirectorOperation.favoriteActorDirector;

import java.util.Scanner;
import java.util.ArrayList;

public class It2021078 {

    public static void main(String[] args) {
        

        Data data = new Data();
        data.initiateDataArrays();

        ArrayList<Accounts> accounts = new ArrayList<Accounts>();

        data.setIsLoggedIn("");
        
        // Create new object addShowOperation 
        addShowOperation addShowOperation = new addShowOperation();
        
        searchShowOperation searchShowOperation = new searchShowOperation();

        accountOperation accountOperation = new accountOperation();



        
        
        while(true){
            
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                
                // Some simple print to display ID and Project name as ASCII art
                System.out.println(AsciiArt.IDENTIFICATION_ΝUMBER + "\n" + "\n" + AsciiArt.JAVA_PROJECT_NAME);
                
                // Print menu choices to do actions
                System.out.println(Messages.MENU);
                if(Data.getIsLoggedIn() == "") {
                    System.out.println(Messages.MENU_REGISTER);
                    System.out.println(Messages.MENU_LOGIN);
                }else {
                    System.out.println(Messages.MENU_LOGOUT);
                }
                
                // Read user input
                String user_choice = myObj.nextLine();  
                //tasaras
                switch(user_choice) {

                        case "1" -> addShowOperation.InsertShow(data);

                        case "2" -> { searchShowOperation.SearchAndEditShow(data);
                }

                        case "3" -> {
                            ArrayList shows = searchShowOperation.SearchShow();
                            if(shows.size() == 0){System.out.println("No results for your search!!!");}
                            else{
                                while(searchShowOperation.RateShow(shows, 0, data, accounts)){}
                            }

                        }


                        case "4" -> {
                         
                                            searchActorDirectorOperation.SearchActorsAndDirectors(data, accounts);
                        }

                        case "5" -> {
                            ArrayList shows = searchShowOperation.SearchShow();
                            if(shows.size() == 0){System.out.println("No results for your search!!!");}
                            else{
                                while(searchShowOperation.ShowRates(shows, data, accounts)){}
                            }
                        }
                        
                        case "6" -> {
                            favoriteActorDirector(accounts);

                        }
                        case "7" -> {
                            if(Data.getIsLoggedIn() == "") {
                                data.setIsLoggedIn(accountOperation.Register(accounts));
                            }else{
                                data.setIsLoggedIn("");
                            }
                        }
                        case "8" -> {
                            data.setIsLoggedIn(accountOperation.LogIn(accounts));
                        }

                       default -> {
                           System.out.println("**********");

                           System.out.println(Data.getMoviesList());
                           System.out.println(Data.getSeriesList());
                           System.out.println(Data.getMiniSeriesList());
                           System.out.println(Data.getDirectorsList());
                           System.out.println(Data.getActorsList());
                }
                       // code block
              }
            // code block
            // code block
            // code block
                    }      

    }
}
