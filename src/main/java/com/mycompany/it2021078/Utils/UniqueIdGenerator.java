/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Utils;
import com.mycompany.it2021078.Interfaces.PeopleIDGenerator;
import com.mycompany.it2021078.Interfaces.ShowIDGenerator;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Model.Shows.MiniSeries;

import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.People.Directors;
import java.util.ArrayList;

/**
 *
 * @author nik
 */
public class UniqueIdGenerator {
    int nextId = 0;
    String finalNextId;
    
    
    
    public String  UniqueIdGenerator(String section){
        
        switch (section) {
            case "Movies" -> { ArrayList<Movie> moviesList = Data.getMoviesList();
                                         nextId = ShowsUniqueIdGenerator(moviesList);
                                         finalNextId = Integer.toString(nextId) + "M";
            }
            case "Series" -> { ArrayList<Series> seriesList = Data.getSeriesList();
                                         nextId = ShowsUniqueIdGenerator(seriesList);
                                         finalNextId = Integer.toString(nextId) + "S";
            }                           
            case "MiniSeries" -> { ArrayList<MiniSeries> miniSeriesList = Data.getMiniSeriesList();
                                                nextId = ShowsUniqueIdGenerator(miniSeriesList); 
                                                finalNextId = Integer.toString(nextId) + "MS";
            }
            case "Actors" -> { ArrayList<Actors> actorsList = Data.getActorsList();
                                         nextId = PeopleUniqueIdGenerator(actorsList);
                                         finalNextId = Integer.toString(nextId) + "A";
            }
            case "Directors" -> {  ArrayList<Directors> directorsList = Data.getDirectorsList();
                                             nextId = PeopleUniqueIdGenerator(directorsList);
                                             finalNextId = Integer.toString(nextId) + "D";
            }
            default -> {
            }
        }
        
        return finalNextId;
           
        
    }
    
    public <T extends  PeopleIDGenerator> int PeopleUniqueIdGenerator(ArrayList<T> list){
    int maxId = Integer.MIN_VALUE;

    for(T obj: list){
       
        String numericPart = obj.getPeopleId().replaceAll("[^\\d]", "");
        int peopleId = Integer.parseInt(numericPart);
        
         if (peopleId > maxId){
             maxId = peopleId;
         }
    }
   return maxId + 1;              
    
}    
    
public <T extends  ShowIDGenerator> int ShowsUniqueIdGenerator(ArrayList<T> list){
    int maxId = Integer.MIN_VALUE;

    for(T obj: list){
       
        String numericPart = obj.getShowId().replaceAll("[^\\d]", "");
        int peopleId = Integer.parseInt(numericPart);
        
         if (peopleId > maxId){
             maxId = peopleId;
         }
    }
   return maxId + 1;              
    
}        

    
    
}
