
package com.mycompany.it2021078.Operations;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Shows;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Utils.entriesValidation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.time.LocalDate;
import java.util.Scanner;

public class addShowOperation {

    

    public void InsertShow(Data data){
        
        Scanner answer = new Scanner(System.in);

       
        // Print add Show menu choices to add one type of show
        System.out.println(Messages.CHOOSE_SHOW_TYPE);
        
        // Read user input
        String user_choice = answer.nextLine();  
        
        switch(user_choice) {

                        case "1" -> { addShowFunctionality(user_choice);
                                             System.out.println(Data.getMoviesList());
                                           }

                        case "2" -> { addShowFunctionality(user_choice);
                                            System.out.println(Data.getSeriesList());
                                            }

                        case "3" -> { addShowFunctionality(user_choice);
                                             System.out.println(Data.getMiniSeriesList());
                                            }
                        
                       default -> {System.out.println("asdasd");}
                     
         }
        
        
    }
    
    public void addShowFunctionality(String userChoice){
        
        String releaseYear = ""; 
        String genreChoice = "" ;
        String  director_name = "";
        String director_surname = "";
        String  director_id = "";
        String director_full_name = "";
        String actor_name = "";
        String actor_surname = "";
        String  actor_id = "";
        String show_id = "";
        Shows show = null;
        ArrayList<Integer> episodesOfSeasons = new ArrayList<>();
        ArrayList<String> genres_list = new ArrayList<>();
        
        Scanner answer = new Scanner(System.in);
        int currentYear = LocalDate.now().getYear();
        
        
        ArrayList<Directors> directorsList = Data.getDirectorsList();
        ArrayList<Actors> actorsList = Data.getActorsList();
        ArrayList<String>  actors_array_list = new ArrayList<>();
      
        
        // Create an object to validate if director or actor already exists
        entriesValidation checkDuplicatesEntries = new entriesValidation();
       
        
        // Check user's choice to initiate object  (Movie, Serie, Mini Serie)  and List
         if ("1".equals(userChoice)) { // User Choice to add movie
             
             ArrayList<Movie> showList = Data.getMoviesList();
             show =  new Movie();
             showList.add((Movie) show);
                                 
         } else if ("2".equals(userChoice)) {// User Choice to add serie
             
             ArrayList<Series> showList = Data.getSeriesList();
             show = new Series();
             showList.add((Series) show);
                
         } else if ("3".equals(userChoice)) {// User Choice to add mini serie
             
             ArrayList<MiniSeries> showList = Data.getMiniSeriesList();
             show =  new MiniSeries();
             showList.add((MiniSeries) show);
                  
         }
         
         
        // Insert movie title
        while(show.getTitle() == null || show.getTitle().isEmpty()){
            System.out.println(Messages.INSERT_SHOW_TITLE);                        
            show.setTitle(answer.nextLine());
        }

        System.out.println(show.getClass().getSimpleName());
        
        // Insert movie release year
        while(show.getYear1() == null || show.getYear1().isEmpty()){
            System.out.println(Messages.INSERT_SHOW_RELEASE_YEAR);
            releaseYear = answer.nextLine();
            try{
                if(Integer.parseInt(releaseYear) <= currentYear || Integer.parseInt(releaseYear) > 1500 ){
                    show.setyear1(releaseYear);
                }
            }catch(NumberFormatException e){
                System.out.println("Wrong year");
            }    
        }

        
        // Insert movie genres
        while(show.getGenre() == null || show.getGenre().isEmpty()){

            
            System.out.println(Messages.INSERT_SHOW_GENRE);

            // Replace all space (maybe function for that)
            genreChoice = answer.nextLine().replaceAll(" ", ""); 

            // Convert user Strinf input to list
            genres_list = new ArrayList<String>(Arrays.asList(genreChoice.split(",") ));
            
            // Check user input to be lower or equal than 3 genres
            if(genres_list.size() <=3){
                show.setGenre(genres_list);
            }else{
                System.out.println(Messages.MAXIMUM_GENRES);
            }
            
        }

        // Insert movie country of production
        while(show.getProdCountry() == null || show.getProdCountry().isEmpty()){
            System.out.println(Messages.INSERT_SHOW_COUNTRY);
            show.setProdCountry(answer.nextLine());
        }
        
         // Check if user want to add Serie or Mini Serie to 1. Cast object Show as Serie or Mini Serie 2. To add number of Seasons
        if("2".equals(userChoice)){
             //series = new Series();
             Series series = (Series) show;
             // Insert movie country of production
            while( series.getSeasons() == 0 ){
                System.out.println("Insert Number Of Seasons");
                series.setSeasons(answer.nextInt());
            }


            for (int i = 1; i <= series.getSeasons(); i++) {
                int tempEpisodes = -1;
                while( tempEpisodes == -1){
                    System.out.println("Insert Episodes Of Season " + i);
                    tempEpisodes = answer.nextInt();
                    episodesOfSeasons.add(tempEpisodes);

                }

            }
            series.setEpisodes(episodesOfSeasons);

            while(series.getYearLast() == null || series.getYearLast().isEmpty()){
                System.out.println("Last Year Of Serie");
                series.setYearLast(answer.nextLine());
            }

        }else if ("3".equals(userChoice)){
            //series = new MiniSeries();
            MiniSeries series = (MiniSeries) show;

             // Insert movie country of production
            while( series.getSeasons() == 0 ){
                System.out.println("Insert Number Of Seasons");
                series.setSeasons(answer.nextInt());
            }


            for (int i = 1; i <= series.getSeasons(); i++) {
                int tempEpisodes = -1;
                while( tempEpisodes == -1){
                    System.out.println("Insert Episodes Of Season " + i);
                    tempEpisodes = answer.nextInt();
                    episodesOfSeasons.add(tempEpisodes);

                }

            }
            series.setEpisodes(episodesOfSeasons);

            while(series.getYearLast() == null || series.getYearLast().isEmpty()){
                System.out.println("Last Year Of Serie");
                series.setYearLast(answer.nextLine());
            }

        }

        
        while(director_name.isEmpty()){
            // Insert movie director name
            System.out.println(Messages.INSERT_SHOW_DIRECTOR_NAME);
            director_name = answer.nextLine();
        }   
        
        // Insert movie director surname
        while(director_surname.isEmpty()){
            System.out.println(Messages.INSERT_SHOW_DIRECTOR_SURNAME);
            director_surname = answer.nextLine();
        }   
            // Combine director first and last name to one to use later
            director_full_name = director_name + " " + director_surname;
            System.out.println("*************");
            System.out.println(director_full_name);
            System.out.println("*************");

            show.setDirectorInfo(director_full_name);
            System.out.println(show.getDirectorInfo());
            
           
         boolean isDirectorsPresent = checkDuplicatesEntries.isDirectorsPresent(directorsList, director_name, director_surname);  
  

        // If directors not add yet add more info about
        if (!isDirectorsPresent) {

            // Create new object director
            Directors newDirector = new Directors();
            
            newDirector.setFName(director_name);
            newDirector.setLName(director_surname);
            
            // Directors unique id
            UUID uniqueDirectorId = UUID.randomUUID();

            // Directors unique id
            director_id = uniqueDirectorId.toString();
            newDirector.setPeopleId(director_id);


            // Insert movie director birth date
            while(newDirector.getBirthDate()== null || newDirector.getBirthDate().isEmpty()){
                System.out.println(Messages.INSERT_SHOW_DIRECTOR_BIRTH);
                newDirector.setBirthDate(answer.nextLine());
            }    

            // Insert movie director country
            while(newDirector.getBirthCountry()== null || newDirector.getBirthCountry().isEmpty()){
                System.out.println(Messages.INSERT_SHOW_DIRECTOR_COUNTRY);
                newDirector.setBirthCountry(answer.nextLine());
            }
            // Insert movie director website
            System.out.println(Messages.INSERT_SHOW_DIRECTOR_WEBSITE);
            newDirector.setWebsite(answer.nextLine());


            // Add new director object to ArrayList we have for themAQQQQQQQQQQQQQ
            directorsList.add(newDirector);

        } 

        while(true)
        {

             // Create new director
             Actors newActors = new Actors();

            // Insert movie actor first name
            while(newActors.getFName() == null || newActors.getFName().isEmpty()){
                System.out.println(Messages.INSERT_SHOW_ACTOR_NAME);
                actor_name = answer.nextLine();
                newActors.setFName(actor_name);
            }


            // Insert movie actor last name
            while(newActors.getLName() == null ||newActors.getLName().isEmpty()){
                System.out.println(Messages.INSERT_SHOW_ACTOR_SURNAME);
                actor_surname = answer.nextLine();
                newActors.setLName(actor_surname);
            }


            // Combine actor first and last name to one to use later
            String actor_full_name = newActors.getFName() + " " + newActors.getLName();

             boolean isActorsPresent = checkDuplicatesEntries.isActorsPresent(actorsList, actor_name, actor_surname);  
             
            
            // If actor not add yet add more info about
            if (!isActorsPresent) {



                // Actors unique id
                UUID uniqueDirectorId = UUID.randomUUID();

                actor_id = uniqueDirectorId.toString();
                newActors.setPeopleId(actor_id);


                // Insert movie actor birth date
                System.out.println(Messages.INSERT_SHOW_ACTOR_BIRTH);
                //actor_birth_date = answer.nextLine();
                newActors.setBirthDate(answer.nextLine());

                // Insert movie actor country
                System.out.println(Messages.INSERT_SHOW_ACTOR_COUNTRY);
                newActors.setBirthCountry(answer.nextLine());

                // Insert movie actor website
                System.out.println(Messages.INSERT_SHOW_ACTOR_WEBSITE);
                //actor_website = answer.nextLine();
                newActors.setWebsite(answer.nextLine());

                // Create new director
                //Actors newActors = new Actors(actor_id, actor_name, actor_surname, actor_birth_date, actor_country_of_birth, actor_website);

                // Add new actor object to ArrayList we have for them
                actorsList.add(newActors);
            }

            // List of Actors playing in the movie user insert
            actors_array_list.add(actor_full_name);

            // Warning  message to stop add actor
            System.out.println(Messages.STOP_ADD_ACTORS);

            String stop_adding_actors = answer.nextLine();

            // If user reache the maximum number of actors show message
            if(actors_array_list.size() >= 10 ){

                System.out.println(Messages.MAXIMUM_ACTORS); 
                System.out.println(Messages.BACK_TO_THE_MENU);
                //String stop_adding_actors = answer.nextLine();

            }else if(actors_array_list.size() == 9 ){

                // Warning  message to stop add actor
                System.out.println(Messages.LAST_ENTRY);

            }else if("0".equals(stop_adding_actors) ){
                break;  
            }

        }

        UUID uniqueDirectorId = UUID.randomUUID();
        show.setActorInfo(actors_array_list);
        System.out.println("******************");
        System.out.println(actors_array_list);
        System.out.println("********************");

        show_id = uniqueDirectorId.toString();
        show.setShowId(show_id);
        //Movie newMovie = new Movie(show_id, title, genres_list, releaseYear, countryofProduction, director_full_name, actors_array_list);
        
    }
    
    
}
