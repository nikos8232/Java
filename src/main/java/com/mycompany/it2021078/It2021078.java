/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

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

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author nik
 */
public class It2021078 {

    public static void main(String[] args) {
        
//        ArrayList<Movie> MoviesList = new ArrayList<Movie>();
//        ArrayList<Series> SeriesList = new ArrayList<Series>();
//        ArrayList<Series> MiniSeriesList = new ArrayList<Series>();
//        ArrayList<Directors> directorsList = new ArrayList<Directors>();
//        ArrayList<Actors> actorsList = new ArrayList<Actors>();
//        ArrayList<Accounts> accountsList = new ArrayList<Accounts>();
        Data data = new Data();
        data.initiateDataArrays();

        ArrayList<Accounts> accounts = new ArrayList<Accounts>();

        String userLoggedIn = "";
        
        // Create new object addShowOperation 
        addShowOperation addShowOperation = new addShowOperation();
        
        //searchShowOperation searchShowOperation - new searchShowOperation();
        searchShowOperation searchShowOperation = new searchShowOperation();

        accountOperation accountOperation = new accountOperation();
        
        
        while(true){
            
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                
                // Some simple print to display ID and Project name as ASCII art
                System.out.println(AsciiArt.IDENTIFICATION_ΝUMBER + "\n" + "\n" + AsciiArt.JAVA_PROJECT_NAME);
                
                // Print menu choices to do actions
                System.out.println(Messages.MENU);
                if(userLoggedIn == "") {
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
                                while(true){
                                    userLoggedIn = searchShowOperation.RateShow(shows, 0, userLoggedIn, accounts);
                                    if(userLoggedIn != "false" || userLoggedIn != "" ) {break;}
                                    else{ userLoggedIn = "";}
                                }
                            }

                        }


                        case "4" -> {
                        }

                        case "5" -> {
                            ArrayList shows = searchShowOperation.SearchShow();
                            if(shows.size() == 0){System.out.println("No results for your search!!!");}
                            else{
                                while(true){
                                    userLoggedIn = searchShowOperation.ShowRates(shows, userLoggedIn, accounts);
                                    if(userLoggedIn != "false" || userLoggedIn != "" ) {break;}
                                    else{ userLoggedIn = "";}
                                }

                            }
                        }
                        case "6" -> {
                            if(userLoggedIn == "") {
                                userLoggedIn = accountOperation.Register(accounts);
                            }else{
                                userLoggedIn = "";
                            }
                        }
                        case "7" -> {
                            userLoggedIn = accountOperation.LogIn(accounts);
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
