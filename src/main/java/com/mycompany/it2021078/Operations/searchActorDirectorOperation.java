
package com.mycompany.it2021078.Operations;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Accounts.Accounts;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.People;
import com.mycompany.it2021078.Model.Shows.Favorite;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Series;
import static com.mycompany.it2021078.Operations.searchShowOperation.SearchShowsByIdOrName;
import static com.mycompany.it2021078.Utils.inputHandler.getStringInput;
import java.util.ArrayList;
import java.util.Scanner;


public class searchActorDirectorOperation {
    public static ArrayList<Favorite> favoriteList  = new ArrayList<Favorite>();
    
    public static void SearchActorsAndDirectors(Data data, ArrayList<Accounts> accounts){
        
        Scanner answer = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat) {
            
            // Print add Show menu choices to add one type of show
            System.out.println(Messages.SEARCH_ACTORS_DIRECTORS);

            // Read user input
            String user_choice = answer.nextLine();  


            switch(user_choice) {

                            case "1" -> {
                                                String actorFirstName = getStringInput(Messages.TYPE_ACTOR_FNAME);
                                                String actorLastName = getStringInput(Messages.TYPE_ACTOR_LNAME);
                                                ArrayList<Actors> peopleList = Data.getActorsList();
                                                searchActorsOrDirectors(peopleList, actorFirstName, actorLastName, accounts, data);
                                                    
                                                break;
                                               }
                           case "2" -> { 
                                                String directorFirstName = getStringInput(Messages.TYPE_DIRECTOR_FNAME);
                                                String directorLastName = getStringInput(Messages.TYPE_DIRECTOR_LNAME);
                                                ArrayList<Directors> peopleList = Data.getDirectorsList();
                                                searchActorsOrDirectors(peopleList, directorFirstName, directorLastName, accounts, data);
                                                    
                                                break;
                                               }
                           
                           case "3" -> {// Print add Show menu choices to add one type of show
                                                System.out.println(Messages.TYPE_NAME_OR_ID_OF_SERIE);
                                                String searchValue = answer.nextLine();
                                                ArrayList<Series> showList = Data.getSeriesList();
                                                SearchShowsByIdOrName(showList, searchValue); 
                                                
                                                break;
                                               }
                    
                           default -> {
                                                return;
                                            }

             }
        }
            
        
        
    }
    
public static <T extends People>  void searchActorsOrDirectors(ArrayList<T> peopleList, String searchValueOne, String searchValueTwo, ArrayList<Accounts> accounts, Data data) {
         Scanner answer = new Scanner(System.in);
         for(T t:peopleList){
             String peopleFirstName = t.getFName().toLowerCase();
             String peopleLastName = t.getLName().toLowerCase();
             
             if(peopleFirstName.equalsIgnoreCase(searchValueOne) && peopleLastName.equalsIgnoreCase(searchValueTwo)){
                 
                  if(t instanceof Actors)
                  {
                        ArrayList<String> listOfTitles = searchActorOrDirectorTitles(peopleFirstName,peopleLastName, "Actor", Data.getMoviesList(), Data.getSeriesList(), Data.getMiniSeriesList());
                        System.out.println(Messages.RESULT_ACTORS_SEARCH + t.getPeopleId() + t.getFName() + t.getLName());
                        System.out.println(Messages.MOVIES_FOR_SEARCHED + listOfTitles);

                       

                        System.out.println(Messages.ACTION_AFTER_SEARCH_ACTOR);
                        String userChoiceActors = answer.nextLine();

                        while(!"1".equals(userChoiceActors) && !"2".equals(userChoiceActors) && !"3".equals(userChoiceActors)){

                        System.out.println(Messages.WRONG_INPUT);
                        System.out.println(Messages.ACTION_AFTER_SEARCH_ACTOR);
                        userChoiceActors = answer.nextLine();
                        }

                         if("1".equals(userChoiceActors)){
                              
                             ArrayList<String[]> findScoreList = findScoreList(listOfTitles);
                            
                              if(findScoreList.isEmpty()){
                                 System.out.println("No Review Yet");
                             }else if (findScoreList.size() == 1){
                                 System.out.println("Only One Rating Exist " + findScoreList.get(0)[0] + ": " +  findScoreList.get(0)[1]);
                             }else if(findScoreList.size() == 2){
                                 System.out.println("Min Rating " + findScoreList.get(0)[0] + ": " +  findScoreList.get(0)[1] + " And Max Rating " + findScoreList.get(1)[0] + ": " +  findScoreList.get(1)[1]);
                             }
                              
                         }else if ("2".equals(userChoiceActors)){
                             
                             if(Data.getIsLoggedIn().equals("")) {
                                 
                                boolean flag = true;
                                String newLogIn;
                                String result;
                                accountOperation accountOperation = new accountOperation();
                                System.out.println("Press 1 to log in or 2 to Register");
                                newLogIn = answer.nextLine();
                                
                                while (!newLogIn.equals("1") && !newLogIn.equals("2")) {
                                    System.out.println(Messages.WRONG_INPUT);
                                    newLogIn = answer.nextLine();
                                }
                                
                                if (newLogIn.equals("1")) {
                                    result = accountOperation.LogIn(accounts);
                                } else {
                                    result = accountOperation.Register(accounts);
                                }
                                
                                if (result.equals("")) {
                                    flag = false;
                                    break;
                                } else {
                                    data.setIsLoggedIn(result);
                                }
                            }
                             
                            for (Accounts account : accounts) {
                                if (account.getUsername().equals(Data.getIsLoggedIn())) {
                                    ArrayList<String> favActors = new ArrayList<String>();
                                    ArrayList<String> favDirectors = new ArrayList<String>();
                                    
                                    favActors.add( t.getFName() + " " +  t.getLName());
                                    Favorite favorite = new Favorite(account.getUsername(), favActors, favDirectors);
                                    favoriteList.add(favorite);
                                    account.setFavorite(favoriteList);
                                   
                                }
                           }
                             
                         }else if("3".equals(userChoiceActors)){
                             return ;
                         }

                        
                  }else if (t instanceof Directors)
                  {
                      
                        ArrayList<String> listOfTitles = searchActorOrDirectorTitles(peopleFirstName,peopleLastName, "Director", Data.getMoviesList(), Data.getSeriesList(), Data.getMiniSeriesList());
                        System.out.println(Messages.RESULT_DIRECTORS_SEARCH + t.getPeopleId() +  t.getFName() + t.getLName());
                        
                        System.out.println(Messages.MOVIES_FOR_SEARCHED + listOfTitles);

                       

                        System.out.println(Messages.ACTION_AFTER_SEARCH_DIRECTOR);
                        String userChoiceActors = answer.nextLine();

                        while(!"1".equals(userChoiceActors) && !"2".equals(userChoiceActors) && !"3".equals(userChoiceActors)){

                        System.out.println(Messages.WRONG_INPUT);
                        System.out.println(Messages.ACTION_AFTER_SEARCH_DIRECTOR);
                        userChoiceActors = answer.nextLine();
                        }

                         if("1".equals(userChoiceActors)){

                             ArrayList<String[]> findScoreList = findScoreList(listOfTitles);
                            
                             if(findScoreList.isEmpty()){
                                 System.out.println("No Review Yet");
                             }else if (findScoreList.size() == 1){
                                 System.out.println("Only One Rating Exist " + findScoreList.get(0)[0] + ": " +  findScoreList.get(0)[1]);
                             }else if(findScoreList.size() == 2){ 
                                 
                                 System.out.println("Min Rating " + findScoreList.get(0)[0] + ": " +  findScoreList.get(0)[1] + " And Max Rating " + findScoreList.get(1)[0] + ": " +  findScoreList.get(1)[1]);
                             }
                             
                         }else if ("2".equals(userChoiceActors)){
                             
                             if(Data.getIsLoggedIn().equals("")) {
                                 
                                boolean flag = true;
                                String newLogIn;
                                String result;
                                accountOperation accountOperation = new accountOperation();
                                System.out.println("Press 1 to log in or 2 to Register");
                                newLogIn = answer.nextLine();
                                
                                while (!newLogIn.equals("1") && !newLogIn.equals("2")) {
                                    System.out.println(Messages.WRONG_INPUT);
                                    newLogIn = answer.nextLine();
                                }
                                
                                if (newLogIn.equals("1")) {
                                    result = accountOperation.LogIn(accounts);
                                } else {
                                    result = accountOperation.Register(accounts);
                                }
                                
                                if (result.equals("")) {
                                    flag = false;
                                    break;
                                } else {
                                    data.setIsLoggedIn(result);
                                }
                            }
                             
                            for (Accounts account : accounts) {
                                if (account.getUsername().equals(Data.getIsLoggedIn())) {
                                    ArrayList<String> favActors = new ArrayList<String>();
                                    ArrayList<String> favDirectors = new ArrayList<String>();
                                    
                                    favDirectors.add( t.getFName() + " " +  t.getLName());
                                    Favorite favorite = new Favorite(account.getUsername(), favActors, favDirectors);
                                    favoriteList.add(favorite);
                                    account.setFavorite(favoriteList);
                                   
                                }
                           }
                            
                         }else if("3".equals(userChoiceActors)){
                             return ;
                         }
                      
                  }
             }
             
         }
         
         
     }


// ****************** Function needed For Search Actor/Director and display shows ******************
public static ArrayList<String> searchActorOrDirectorTitles(String firstName, String lastName, String objectFlag, ArrayList<Movie> movies, ArrayList<Series> series, ArrayList<MiniSeries> miniSeries) {
    
        ArrayList<String> titles = new ArrayList<>();
        
        
        // Search movies
        for (Movie movie : movies) { 
            if(objectFlag == "Director"){
                
                String stringToCompare;
                stringToCompare = movie.getDirectorInfo().toLowerCase();
                if (stringToCompare.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(movie.getTitle());
                }   
                
            }else if (objectFlag == "Actor"){
                ArrayList<String> stringToCompareList = new ArrayList<String>();
                
          
                for (String movieObj : movie.getActorInfo() ){
                    stringToCompareList.add(movieObj.toLowerCase());
                }
                
                
                if (stringToCompareList.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(movie.getTitle());
                }   
            }
            
        }

        // Search series
        for (Series serie : series) {
            
            if(objectFlag == "Director"){
                
                String stringToCompare;
                stringToCompare = serie.getDirectorInfo().toLowerCase();
                if (stringToCompare.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(serie.getTitle());
                }   
                
            }else if (objectFlag == "Actor"){
                ArrayList<String> stringToCompareList = new ArrayList<String>();
                
          
                for (String movieObj : serie.getActorInfo() ){
                    stringToCompareList.add(movieObj.toLowerCase());
                }
                
                
                if (stringToCompareList.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(serie.getTitle());
                }   
            }
            
        }

        // Search mini-series
        for (MiniSeries miniSerie : miniSeries) {
           if(objectFlag == "Director"){
                
                String stringToCompare;
                stringToCompare = miniSerie.getDirectorInfo().toLowerCase();
                if (stringToCompare.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(miniSerie.getTitle());
                }   
                
            }else if (objectFlag == "Actor"){
                ArrayList<String> stringToCompareList = new ArrayList<String>();
                
          
                for (String movieObj : miniSerie.getActorInfo() ){
                    stringToCompareList.add(movieObj.toLowerCase());
                }
                
                
                if (stringToCompareList.contains((firstName + " " + lastName).toLowerCase())) {
                    titles.add(miniSerie.getTitle());
                }   
            }
        }

        return titles;
    }

public static ArrayList<String[]> findScoreList(ArrayList<String> listOfTitles){
        ArrayList<String[]> minMax = new ArrayList<>();
        for(String title: listOfTitles){
           
            for(int i = 0; i< Data.getMoviesList().size(); i++){
                Data.getMoviesList().get(i).getTitle();
                 if(title.equals(Data.getMoviesList().get(i).getTitle()) && Data.getMoviesList().get(i).getAverageRate() != "No reviews"){
                     minMax.add(new String[]{Data.getMoviesList().get(i).getTitle(), Data.getMoviesList().get(i).getAverageRate() } );
                 }
            }
            for(int i = 0; i< Data.getSeriesList().size(); i++){
                Data.getSeriesList().get(i).getTitle();
                 if(title.equals(Data.getSeriesList().get(i).getTitle()) && Data.getMoviesList().get(i).getAverageRate() != "No reviews"){
                     minMax.add(new String[]{Data.getMoviesList().get(i).getTitle(), Data.getMoviesList().get(i).getAverageRate() } );
                 }
            }
            for(int i = 0; i< Data.getMiniSeriesList().size(); i++){
                Data.getMiniSeriesList().get(i).getTitle();
                 if(title.equals(Data.getMiniSeriesList().get(i).getTitle()) && Data.getMoviesList().get(i).getAverageRate() != "No reviews"){
                     minMax.add(new String[]{Data.getMoviesList().get(i).getTitle(), Data.getMoviesList().get(i).getAverageRate() } );
                 }
            }
           
        }
        
        if(!minMax.isEmpty()){
            double minValue = Double.MAX_VALUE;
            double maxValue = Double.MIN_VALUE;
            String[] minTuple = null;
            String[] maxTuple = null;


            for (String[] tuple : minMax) {
                double value = Double.parseDouble(tuple[1].split("/")[0]);
                if (value < minValue) {
                    minValue = value;
                    minTuple = tuple;
                }
                if (value > maxValue) {
                    maxValue = value;
                    maxTuple = tuple;
                }
            }

            minMax.clear();
            minMax.add(minTuple);
            minMax.add(maxTuple);
        }
        
        
        return minMax;
    
}

public static void favoriteActorDirector(ArrayList<Accounts> favList) {
    for (Accounts account : favList) {
        
        System.out.println("Favorites Directors: ");
        for(Favorite favorite: account.getFavorite()){
            
            if(!favorite.getFavDirector().isEmpty()){
                System.out.println(favorite.getFavDirector());
            }
            
            
        }
        
        System.out.println("Favorites Actor: ");
        for(Favorite favorite: account.getFavorite()){
            if(!favorite.getFavActors().isEmpty()){
                System.out.println(favorite.getFavActors());
            }
            
        }
        
    }
            
    }

}
