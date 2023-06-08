/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.it2021078;
import com.mycompany.it2021078.Constants.AsciiArt;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Operations.addShowOperation;
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
        Data data = new Data(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        
        // Create new object addShowOperation 
        addShowOperation operation = new addShowOperation();
        
        
        while(true){
            
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                
                // Some simple print to display ID and Project name as ASCII art
                System.out.println(AsciiArt.IDENTIFICATION_ΝUMBER + "\n" + "\n" + AsciiArt.JAVA_PROJECT_NAME);
                
                // Print menu choices to do actions
                System.out.println(Messages.MENU);
                
                // Read user input
                String user_choice = myObj.nextLine();  
                //tasaras
                switch(user_choice) {

                        case "1" -> operation.InsertShow(data);

                        case "2" -> { System.out.println("**********");
                                           
                                            System.out.println(Data.getMoviesList());
                                            System.out.println(Data.getSeriesList());
                                            System.out.println(Data.getDirectorsList());
                                            System.out.println(Data.getActorsList());
                                            
                                            //System.out.println(MoviesList);
                                            //System.out.println(actorsList);
                                            //System.out.println(directorsList);
                }

                        case "3" -> {
                }

                        case "4" -> {
                }

                        case "5" -> {
                }

                        case "6" -> {
                }

                       default -> {
                }
                       // code block
              }
            // code block
            // code block
            // code block
                    }      

    }
}
