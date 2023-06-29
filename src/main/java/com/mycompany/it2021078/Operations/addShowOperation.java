package com.mycompany.it2021078.Operations;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Shows;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Utils.UniqueIdGenerator;
import com.mycompany.it2021078.Utils.entriesValidation;
import static com.mycompany.it2021078.Utils.entriesValidation.validLastYearOfSerie;
import static com.mycompany.it2021078.Utils.entriesValidation.validDate;
import static com.mycompany.it2021078.Utils.inputHandler.getIntInput;
import static com.mycompany.it2021078.Utils.inputHandler.getStringInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class addShowOperation {
    
    String show_id;
    UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();

    
   
    public void InsertShow(Data data){
        
        Scanner answer = new Scanner(System.in);
        // Print add Show menu choices to add one type of show
        System.out.println(Messages.CHOOSE_SHOW_TYPE);
        
        // Read user input
        String user_choice = answer.nextLine();  
        
        switch(user_choice) {

                        case "1" -> { Movie movie = new Movie();
                                            
                                            show_id = uniqueIdGenerator.UniqueIdGenerator( "Movies");
                                            ArrayList<Movie> showList = Data.getMoviesList();
                                            addShowFunctionality(movie, user_choice, show_id, showList);
                                            System.out.println(Data.getMoviesList());
                                           }

                        case "2" -> { Series serie = new Series();
                                            
                                            show_id = uniqueIdGenerator.UniqueIdGenerator( "Series");
                                            ArrayList<Series> showList = Data.getSeriesList();
                                            addShowFunctionality(serie, user_choice, show_id,showList);
                                            System.out.println(Data.getSeriesList());
                                            }

                        case "3" -> { MiniSeries miniSerie = new MiniSeries();
                                           
                                            show_id = uniqueIdGenerator.UniqueIdGenerator( "MiniSeries");
                                            ArrayList<MiniSeries> showList = Data.getMiniSeriesList();
                                            addShowFunctionality(miniSerie, user_choice, show_id,showList);
                                            System.out.println(Data.getMiniSeriesList());
                                            }
                        
                       default -> {System.out.println("asdasd");}
                     
         }
        
        
    }
    
    

    public <T> void addShowFunctionality(Shows show, String userChoice, String show_id, ArrayList<T> showList){    

            int  releaseYear; 
            int  lastYearOfSerie;
            String genreChoice;
            String  director_name = "";
            String director_surname = "";
            String  director_id;
            String director_full_name;
            String actor_name = "";
            String actor_surname = "";
            String  actor_id;
            
            
            
            ArrayList<Integer> episodesOfSeasons = new ArrayList<>();
            ArrayList<String> genres_list = new ArrayList<>();
            ArrayList<Directors> directorsList = Data.getDirectorsList();
            ArrayList<Actors> actorsList = Data.getActorsList();
            ArrayList<String>  actors_array_list = new ArrayList<>();

            Scanner acceptString = new Scanner(System.in);
            
            // Create an object to validate if director or actor already exists
            entriesValidation checkDuplicatesEntries = new entriesValidation();

            // Insert movie title
            while(show.getTitle() == null || show.getTitle().isEmpty()){ 
                show.setTitle(getStringInput(Messages.INSERT_SHOW_TITLE));
            }


            // Insert movie release year
            while(true){
                releaseYear = getIntInput(Messages.INSERT_SHOW_RELEASE_YEAR);
                if(validDate(releaseYear)){
                        show.setyear1(releaseYear);
                        break;
                    }
            }


            // Insert movie genres
            while(true){

                // Replace all space (maybe function for that)
                genreChoice = getStringInput(Messages.INSERT_SHOW_GENRE).replaceAll(" ", "");
                
                if (!genreChoice.isEmpty()){
                   
                    // Convert user Strinf input to list
                    genres_list = new ArrayList<String>(Arrays.asList(genreChoice.split(",") ));
                    
                    // Check user input to be lower or equal than 3 genres
                    if(genres_list.size() > 0 && genres_list.size() <=3){
                        show.setGenre(genres_list);
                        break;
                    }
                
                }else{
                    System.out.println(Messages.MAXIMUM_GENRES);
                }
                       
            }

            // Insert movie country of production
            while(show.getProdCountry() == null || show.getProdCountry().isEmpty()){
                show.setProdCountry(getStringInput(Messages.INSERT_SHOW_COUNTRY));
            }

            
            // Check if user want to add Serie or Mini Serie to 1. Cast object Show as Serie or Mini Serie 2. To add number of Seasons
            if("2".equals(userChoice)){
                 //series = new Series();
                 Series series = (Series) show;
                 
                 // Insert movie country of production
                while( series.getSeasons() == 0 ){
                    int a = getIntInput(Messages.INSERT_SERIES_SEASONS);
                    series.setSeasons(a);
                }


                for (int i = 1; i <= series.getSeasons(); i++) {
                    int tempEpisodes = 0;
                    while(tempEpisodes == 0){
                         tempEpisodes = getIntInput(String.format(Messages.INSERT_EPISODES_OF_SEASON, i));
                    }
                    episodesOfSeasons.add(tempEpisodes);
                }
                series.setEpisodes(episodesOfSeasons);
                

                 // Insert movie release year
                while(true){

                    lastYearOfSerie = getIntInput(Messages.INSERT_LAST_YEAR);
                    if(validLastYearOfSerie(show.getYear1(),lastYearOfSerie) && validDate(lastYearOfSerie)){
                            series.setYearLast(lastYearOfSerie);
                            break;
                        }
                }


            }else if ("3".equals(userChoice)){
                
                //series = new MiniSeries();
                MiniSeries series = (MiniSeries) show;

                 // Insert movie country of production
                while( series.getSeasons() == 0 ){
                    int a = getIntInput(Messages.INSERT_SERIES_SEASONS);
                    series.setSeasons(a);
                }


                for (int i = 1; i <= series.getSeasons(); i++) {
                    int tempEpisodes = 0;
                    while(tempEpisodes == 0){
                         tempEpisodes = getIntInput(String.format(Messages.INSERT_EPISODES_OF_SEASON, i));
                    }
                    episodesOfSeasons.add(tempEpisodes);
                }
                series.setEpisodes(episodesOfSeasons);
                

                 // Insert movie release year
                while(true){

                    lastYearOfSerie = getIntInput(Messages.INSERT_LAST_YEAR);
                    if(validLastYearOfSerie(show.getYear1(),lastYearOfSerie) && validDate(lastYearOfSerie)){
                            series.setYearLast(lastYearOfSerie);
                            break;
                     }
                }
                
            }


             // Insert movie director name
            while(director_name.isEmpty()){
                director_name = getStringInput(Messages.INSERT_SHOW_DIRECTOR_NAME);
            }   

            
            // Insert movie director surname
            while(director_surname.isEmpty()){
                director_surname = getStringInput(Messages.INSERT_SHOW_DIRECTOR_SURNAME);
            }   
            
            
            // Combine director first and last name to one to use later
            director_full_name = director_name + " " + director_surname;

            show.setDirectorInfo(director_full_name);


             boolean isDirectorsPresent = checkDuplicatesEntries.isDirectorsPresent(directorsList, director_name, director_surname);  


            // If directors not add yet add more info about
            if (!isDirectorsPresent) {

                // Create new object director
                Directors newDirector = new Directors();

                newDirector.setFName(director_name);
                newDirector.setLName(director_surname);

                // Directors unique id
                director_id = uniqueIdGenerator.UniqueIdGenerator( "Directors");

                newDirector.setPeopleId(director_id);


                // Insert movie director birth date
                while(true){
                    int directorBirth = getIntInput(Messages.INSERT_SHOW_DIRECTOR_BIRTH);
                    if(validDate(directorBirth)){
                            show.setyear1(directorBirth);
                            break;
                      }
                    
                }   


                // Insert movie director country
                while(newDirector.getBirthCountry()== null || newDirector.getBirthCountry().isEmpty()){
                    System.out.println(Messages.INSERT_SHOW_DIRECTOR_COUNTRY);
                    newDirector.setBirthCountry(acceptString.nextLine());
                }
                
                // Insert movie director website
                    while(newDirector.getWebsite() == null || newDirector.getWebsite().isEmpty()){
                         newDirector.setWebsite(getStringInput(Messages.INSERT_SHOW_DIRECTOR_WEBSITE));
                    }
               
                // Add new director object to ArrayList we have for them
                directorsList.add(newDirector);

            } 

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

                 boolean isActorsPresent = checkDuplicatesEntries.isActorsPresent(actorsList, actor_name, actor_surname);  


                // If actor not add yet add more info about
                if (!isActorsPresent) {


                    // Actors unique id
                    actor_id = uniqueIdGenerator.UniqueIdGenerator( "Actors");

                    newActors.setPeopleId(actor_id);

                    // Insert movie actor birth date
                    while(true){
                        int birthYear = getIntInput(Messages.INSERT_SHOW_ACTOR_BIRTH);
                        System.out.println("nikos");
                        if(validDate(birthYear)){
                                System.out.println("nikos2");
                                newActors.setBirthDate(birthYear);
                                break;
                            }
                    }
                    
                    // Insert movie actor country
                    while(newActors.getBirthCountry() == null || newActors.getBirthCountry().isEmpty()){
                         newActors.setBirthCountry(getStringInput(Messages.INSERT_SHOW_ACTOR_COUNTRY));
                    }
                   

                    // Insert movie actor website
                    while(newActors.getWebsite() == null || newActors.getWebsite().isEmpty()){
                         newActors.setWebsite(getStringInput(Messages.INSERT_SHOW_ACTOR_WEBSITE));
                    }
                    
                    // Add new actor object to ArrayList we have for them
                    actorsList.add(newActors);
                }

                // List of Actors playing in the movie user insert
                actors_array_list.add(actor_full_name);

                // Warning  message to stop add actor
                System.out.println(Messages.STOP_ADD_ACTORS);

                String stop_adding_actors = acceptString.nextLine();

                // If user reache the maximum number of actors show message
                if(actors_array_list.size() >= 10 ){

                    System.out.println(Messages.MAXIMUM_ACTORS); 
                    System.out.println(Messages.BACK_TO_THE_MENU);
               
                }else if(actors_array_list.size() == 9 ){

                    // Warning  message to stop add actor
                    System.out.println(Messages.LAST_ENTRY);

                }else if("0".equals(stop_adding_actors) ){
                    break;  
                }
            }

            
            show.setActorInfo(actors_array_list);


            show.setShowId(show_id);
            show.setShowId(show_id);
            showList.add((T) show);
    }    
}