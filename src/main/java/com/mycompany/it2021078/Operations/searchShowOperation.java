/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Operations;

import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Model.Shows.Shows;
import com.mycompany.it2021078.Utils.UniqueIdGenerator;
import com.mycompany.it2021078.Utils.entriesValidation;
import static com.mycompany.it2021078.Utils.entriesValidation.validDate;
import static com.mycompany.it2021078.Utils.inputHandler.getIntInput;
import static com.mycompany.it2021078.Utils.inputHandler.getStringInput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nik
 */
public class searchShowOperation {
    static final int CHUNK_SIZE = 5;
    
    
    public static void SearchAndEditShow(Data data){
        
        Scanner answer = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat) {
            
            // Print add Show menu choices to add one type of show
            System.out.println(Messages.SEARCH_TEXT);

            // Read user input
            String user_choice = answer.nextLine();  


            switch(user_choice) {

                            case "1" -> {// Print add Show menu choices to add one type of show
                                                System.out.println(Messages.TYPE_OF_SHOW);

                                                // Read user input
                                                String typeOfShow = answer.nextLine(); 
                                                Scanner scanner = new Scanner(System.in);
                                                ArrayList<? extends Shows> showList = null; 
                                                if("1".equals(typeOfShow)){
                                                     showList = Data.getMoviesList();
                                                }else if("2".equals(typeOfShow)){
                                                    showList = Data.getSeriesList();
                                                }else if ("3".equals(typeOfShow)){
                                                    showList = Data.getMiniSeriesList();
                                                }

                                                allShowInChunks(showList, scanner);
                                                break;
                                               }
                           case "2" -> {// Print add Show menu choices to add one type of show
                                                System.out.println(Messages.TYPE_NAME_OR_ID_OF_MOVIE);
                                                ArrayList<Movie> showList = Data.getMoviesList();
                                                String searchValue = answer.nextLine();
                                                SearchShowsByIdOrName(showList, searchValue);
                                                
                                               
                                                break;
                                               }
                           
                           case "3" -> {// Print add Show menu choices to add one type of show
                                                System.out.println(Messages.TYPE_NAME_OR_ID_OF_SERIE);
                                                String searchValue = answer.nextLine();
                                                ArrayList<Series> showList = Data.getSeriesList();
                                                SearchShowsByIdOrName(showList, searchValue); 
                                                
                                                break;
                                               }
                           case "4" -> {// Print add Show menu choices to add one type of show
                                                System.out.println(Messages.TYPE_NAME_OR_ID_OF_MINI_SERIE);
                                                String searchValue = answer.nextLine();
                                                ArrayList<MiniSeries> showList = Data.getMiniSeriesList();
                                                SearchShowsByIdOrName(showList, searchValue);
                                                
                                                break;
                                               }

                    
                           default -> {
                                                return;
                                            }

             }
        }
            
        
        
    }
    
    
    public static <T>  void allShowInChunks(ArrayList<T> showList, Scanner scanner) {
        for (int i = 0; i < showList.size(); i += CHUNK_SIZE) {
            int endIndex = Math.min(i + CHUNK_SIZE, showList.size());
            List<T> chunk = showList.subList(i, endIndex);

            for (T show : chunk) {
                System.out.println(show);
            }

            System.out.println(Messages.ENTER_TO_NEXT);
            scanner.nextLine();
        }
    }
    
    
    
    
    public static <T extends Shows>  void SearchShowsByIdOrName(ArrayList<T> showList, String searchValue) {
        
        Scanner answer = new Scanner(System.in);
        
        for(T t: showList){
                
            String showTitle = t.getTitle().toLowerCase();
            String showID = t.getShowId().toLowerCase(); 
            System.out.println(searchValue);
            if(searchValue.isEmpty()){
                break;
            }
            if (showTitle.equalsIgnoreCase(searchValue) || showID.equalsIgnoreCase(searchValue) ) {
                System.out.println(Messages.SHOW_FOUND_BY_NAME + t.getTitle());
                
                
                if(t instanceof Movie){
                    
                    String addActors = null;
                    System.out.println(Messages.SHOW_ACTORS_RESULT + t.getActorInfo());
                    
                        if(t.getActorInfo().size() >= 10){
                            System.out.println(Messages.SHOW_HAVE_MAX_ACTORS);
                        
                        }else{
                            
                            System.out.println(Messages.PRESS_TO_ADD_ACTOR);
                            addActors = answer.nextLine();

                            while(!"1".equals(addActors) && !"2".equals(addActors)){

                            System.out.println(Messages.WRONG_INPUT);
                            System.out.println(Messages.PRESS_TO_ADD_ACTOR);
                            addActors = answer.nextLine();
                        }
                            
                        if(!"2".equals(addActors)){
                            
                            editResultActorsFromSearch(t.getActorInfo());
                            
                        }
                        
                    }

                }else if (t instanceof Series){
                    
                    String editSerie = null;
                    System.out.println(Messages.SHOW_SERIES_RESULT + t.getActorInfo() + ((Series) t).getSeasons() + ((Series) t).getEpisodes() );

                       if(t.getActorInfo().size() >= 10){
                           System.out.println(Messages.SHOW_SERIE_HAVE_MAX_ACTORS);

                       }else{

                           System.out.println(Messages.PRESS_TO_ADD_TO_SERIE);
                           editSerie = answer.nextLine();

                           while(!"1".equals(editSerie) && !"2".equals(editSerie) && !"3".equals(editSerie) && !"4".equals(editSerie)) {

                                System.out.println(Messages.WRONG_INPUT);
                                System.out.println(Messages.PRESS_TO_ADD_TO_SERIE);
                                editSerie = answer.nextLine();
                            }

                            if("1".equals(editSerie)){

                                editResultActorsFromSearch(t.getActorInfo());
                                break;

                            }else if("2".equals(editSerie)){
                                editResultSeasonsFromSearch(t);

                            }else if ("3".equals(editSerie)){
                                editResultEpisodesFromSearch(t);
                            }else if ("4".equals(editSerie)){
                                break;
                            }

                    }
                    
                }else if (t instanceof MiniSeries){
                    
                }
                
            }else{
                System.out.println(Messages.NOTHING_FOUND);
                break;
                
            }
            
        }
        
    }
    

    
    public static <T> void editResultActorsFromSearch(ArrayList<T> actor_info){
        
        String actor_name = "";
        String actor_surname = "";
        String  actor_id;
        Scanner answer = new Scanner(System.in);
        
        ArrayList<Actors> actorsList = Data.getActorsList();
        
        // Create an object to validate if director or actor already exists
        entriesValidation checkDuplicatesEntries = new entriesValidation();
        UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
        
        
        while(true)
            {

                 // Create new actor
                 Actors newActors = new Actors();

                // Insert movie actor first name
                while(newActors.getFName() == null || newActors.getFName().isEmpty()){
                    actor_name = getStringInput(Messages.INSERT_SHOW_ACTOR_NAME);
                    newActors.setFName(actor_name);
                }


                // Insert movie actor last name
                while(newActors.getLName() == null ||newActors.getLName().isEmpty()){
                    actor_surname = getStringInput(Messages.INSERT_SHOW_ACTOR_SURNAME);
                    newActors.setLName(actor_surname);
                }



                // Combine actor first and last name to one to use later
                String actor_full_name = newActors.getFName() + " " + newActors.getLName();

                boolean isActorsPresent = checkDuplicatesEntries.isActorsPresent((List<Actors>) actorsList, actor_name, actor_surname);  


                // If actor not add yet add more info about
                if (!isActorsPresent) {
                            

                    actor_info.add((T) actor_full_name);
                    
                    // Actors unique id
                    actor_id = uniqueIdGenerator.UniqueIdGenerator( "Actors");

                    newActors.setPeopleId(actor_id);


                    // Insert movie actor birth date
                    while(true){
                        int birthYear = getIntInput(Messages.INSERT_SHOW_ACTOR_BIRTH);
                        if(validDate(birthYear)){
                                newActors.setBirthDate(birthYear);
                                break;
                            }
                    }
                    
                    // Insert movie actor country
                    while(newActors.getBirthCountry() == null || newActors.getBirthCountry().isEmpty()){
                         newActors.setBirthCountry(getStringInput(Messages.INSERT_SHOW_ACTOR_BIRTH));
                    }
                   

                    // Insert movie actor website
                    while(newActors.getWebsite() == null || newActors.getWebsite().isEmpty()){
                         newActors.setWebsite(getStringInput(Messages.INSERT_SHOW_ACTOR_WEBSITE));
                    }
                    

                   
                    // Add new actor object to ArrayList we have for them
                    actorsList.add(newActors);
                }

                

                // Warning  message to stop add actor
                System.out.println(Messages.STOP_ADD_ACTORS);

                String stop_adding_actors = answer.nextLine();
                
                String stop_adding_actors2 = "";
                // If user reache the maximum number of actors show message
                if(actorsList.size() >= 10 ){

                    System.out.println(Messages.MAXIMUM_ACTORS); 
                    System.out.println(Messages.BACK_TO_THE_MENU);
                    stop_adding_actors2 = answer.nextLine();
                    
                    
                }else if(actorsList.size() == 9 ){

                    // Warning  message to stop add actor
                    System.out.println(Messages.LAST_ENTRY);

                }
                if("0".equals(stop_adding_actors) || "0".equals(stop_adding_actors2)){
                    break;
                }
                

            }
    }
    
    
    
    public static <T extends Shows> void editResultSeasonsFromSearch(T season_info){
        int new_seasons = 0;
        int seasonToAdd = 0;
        String  editSeasonHandler = null;
        Scanner answer = new Scanner(System.in);
        Scanner warning = new Scanner(System.in);
        ArrayList<Integer> episodesOfSeasons = new ArrayList<>();
        
        Series series = (Series) season_info;
        // Insert movie country of production
        while(true){
            boolean validInput = false;
            System.out.println(Messages.EDIT_NUMBER_OF_SEASON);
            
            
            while(!validInput){
                try{
                    new_seasons = answer.nextInt();
                    if(new_seasons == 0){
                          System.out.println(Messages.WRONG_SEASON_NUMBER);
                    }else if (new_seasons == series.getSeasons() ) {
                            System.out.println("You Must Add Or Delete Season Season You Add :  " + new_seasons + "  Season This Series Have  " + series.getSeasons() );
                    }else{
                                
                                     
                        validInput = true;
                    }
                    
                }catch(InputMismatchException  e){
                    System.out.println("Wrong Input Enter Seasons Again");
                    validInput = false;
                    answer.nextLine();
                }    
                
            }
             
           

            if(new_seasons < series.getSeasons() ){

                int seasonToDelete = series.getSeasons() - new_seasons;
                System.out.println(seasonToDelete +" Season Will Be Delete, You Want To Continue Type 1 ?");
                editSeasonHandler = warning.nextLine();
            }else if(new_seasons > series.getSeasons() ){
                seasonToAdd = new_seasons - series.getSeasons();
                System.out.println(seasonToAdd +" Season Will Be Add, You Want To Continue Type 2 ?");
                editSeasonHandler = warning.nextLine();

            }



            if("1".equals(editSeasonHandler)){
                series.setSeasons(new_seasons);
                ArrayList<Integer> episodes = series.getEpisodes();
                ArrayList<Integer> subList = new ArrayList<>(episodes.subList(0, new_seasons));

                series.setEpisodes(subList);
                break;
            }else if("2".equals(editSeasonHandler)){

                series.setSeasons(new_seasons);
                seasonToAdd = seasonToAdd - 1;
                for (int seasonIndex = (series.getSeasons() - seasonToAdd) ; seasonIndex <= series.getSeasons(); seasonIndex++) {
                    int tempEpisodes = -1;
                    while( tempEpisodes == -1){
                        System.out.println("Insert Episodes Of Season " + seasonIndex);
                        tempEpisodes = answer.nextInt();
                        episodesOfSeasons.add(tempEpisodes);

                    }

                }

                ArrayList<Integer> copyEpisodesList = new ArrayList<>(series.getEpisodes());
                copyEpisodesList.addAll(episodesOfSeasons);

                series.setEpisodes(copyEpisodesList);
                 break;
            }



            
         }


   }
    
    
    
    
    
    public static <T extends Shows> void editResultEpisodesFromSearch(T season_info){
        int seasonToEdit = 0;
        int episodesToAdd = 0;
        int episodesEdit = 0;
        String  editEpisodesHandler = null;
        Scanner seasonChoice = new Scanner(System.in);
        Scanner newEpisodes = new Scanner(System.in);
        Scanner warning = new Scanner(System.in);
        ArrayList<Integer> episodesOfSeasons = new ArrayList<>();
        
        Series series = (Series) season_info;
        // Insert movie country of production
        while(true){
            boolean validInputSeason = false;
            boolean validInputEpisodes = false;
            System.out.println("This Serie Have:  " + series.getSeasons() + " Seasons, Type Number Of Season And Press Enter To Edit Episodes");
            
            
            while(!validInputSeason){
                try{
                    seasonToEdit = seasonChoice.nextInt();
                    if(seasonToEdit == 0){
                          System.out.println("You Can't Edit Zero Season");
                    }else if (seasonToEdit > series.getSeasons()) {
                            System.out.println("You Can't Edit Season That Not Exists");
                    }else{            
                        validInputSeason = true;
                    }
                    
                }catch(InputMismatchException  e){
                    System.out.println("Wrong Input Enter Season Again");
                    validInputSeason = false;
                    //seasonChoice.nextLine();
                }    
                
            }
            
            
            while(!validInputEpisodes){
                try{
                    System.out.println("Edit Number Of Episodes");
                    episodesEdit = newEpisodes.nextInt();
                    if(episodesEdit == 0){
                          System.out.println("You Can't Set Episodes To Zero Enter Episodes Again");
                    }else{                
                        validInputEpisodes = true;
                    }
                    
                }catch(InputMismatchException  e){
                    System.out.println("Wrong Input Enter Episodes Again");
                    validInputEpisodes = false;
                    newEpisodes.nextLine();
                }    
                
            }
             
           

            if(episodesEdit < series.getEpisodes().get(seasonToEdit -1) ){

                int episodesToDelete = series.getEpisodes().get(seasonToEdit -1 ) - episodesEdit;
                System.out.println(episodesToDelete +" Episode(s) Will Be Delete, You Want To Continue Type 1 ?");
                editEpisodesHandler = warning.nextLine();
            }else if(episodesEdit > series.getEpisodes().get(seasonToEdit -1 ) ){
                episodesToAdd = episodesEdit - series.getEpisodes().get(seasonToEdit -1 );
                System.out.println(episodesToAdd +" Episodes Will Be Add, You Want To Continue Type 2 ?");
                editEpisodesHandler = warning.nextLine();

            }


            if("1".equals(editEpisodesHandler)){
                series.getEpisodes().set(seasonToEdit -1 ,episodesEdit);

                break;
            }else if("2".equals(editEpisodesHandler)){
                series.getEpisodes().set(seasonToEdit -1 ,episodesEdit);

                 break;
            }



            
         }


   }
    
}
