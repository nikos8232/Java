/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Constants;

/**
 *
 * @author nik
 */
public class Messages {
    
    public static final  String MENU = """
                                                  What you want to do? 
                                        *******  Press 1 To Insert Show  ****** 
                                        *******  Press 2 To Update Show Infos  ****** 
                                        *******  Press 3 To Search Shows  ****** 
                                        *******  Press 4 To Search Actors/Directors  ****** 
                                        *******  Press 5 To View Ratings  ******
                                        *******  Press 6 To View Favorites  ******""";

    public static final  String MENU_REGISTER = "*******  Press 7 To Sign Up  ******";

    public static final  String MENU_LOGIN = "*******  Press 8 To Log In  ******";

    public static final  String MENU_LOGOUT = "*******  Press 7 To Log Out  ******";

    
    
    public static final  String CHOOSE_SHOW_TYPE = """
                                                              What you want to do? 
                                                    *******  Press 1 To Insert Movie  ****** 
                                                    *******  Press 2 To Insert Serie  ****** 
                                                    *******  Press 3 To Insert Mini Serie  ****** 
                                                   """ ;
    
    // ****************  Show(Movies,Series,Mini Series)  ****************
    public static final  String INSERT_SHOW_TITLE = "Insert Show's Title";
    public static final  String INSERT_SHOW_RELEASE_YEAR = "Insert Show's Release Year";
    public static final  String INSERT_SHOW_GENRE = "Insert Show's Genre(e.g. Crime,Drame,Romantic)";
    public static final  String MAXIMUM_GENRES = "The number of genres must be greater than 1 and  less than or equal to 3";
    public static final  String INSERT_SHOW_COUNTRY = "Insert Show's Country of production";
    
    
    // ****************  Director  ****************
    public static final  String INSERT_SHOW_DIRECTOR_NAME = "Insert Show's Director Fisrt Name";
    public static final  String INSERT_SHOW_DIRECTOR_SURNAME = "Insert Show's Director Last Name";
    public static final  String INSERT_SHOW_DIRECTOR_BIRTH = "Insert Show's Director Birth Date";
    public static final  String INSERT_SHOW_DIRECTOR_COUNTRY = "Insert Show's Director Country Of Birth";
    public static final  String INSERT_SHOW_DIRECTOR_WEBSITE = "Insert Show's Director Website";
    
    
    // ****************  Actor  ****************
    public static final  String INSERT_SHOW_ACTOR_NAME = "Insert Show's Actor Fisrt Name";
    public static final  String INSERT_SHOW_ACTOR_SURNAME = "Insert Show's Actor Last Name";
    public static final  String INSERT_SHOW_ACTOR_BIRTH = "Insert Show's Actor Birth Date";
    public static final  String INSERT_SHOW_ACTOR_COUNTRY = "Insert Show's Actor Country Of Birth";
    public static final  String INSERT_SHOW_ACTOR_WEBSITE = "Insert Show's Actor Website";
    public static final  String MAXIMUM_ACTORS = "The maximum number of actors must be less than or equal to 10";
    
    // ****************  Show - Series  ****************
    public static final  String INSERT_SERIES_SEASONS = "Insert Number Of Seasons";
    public static final  String INSERT_EPISODES_OF_SEASON = "Insert Episodes Of Season: %d";
    public static final  String INSERT_LAST_YEAR = "Insert Last Year Of Serie";
    
    // ****************  2. SearchAndEditShow  ****************
    public static final  String SEARCH_TEXT = """
                                                              Search And Then Edit Show 
                                                   *******  Type 1 to See All Shows  ******             
                                                   *******  Type 2 Movies By Show ID Or By Show Name ****** 
                                                   *******  Type 3 Series By Show ID Or By Show Name  ****** 
                                                   *******  Type 4 Mini Series By Show ID Or By Show Name  ****** 
                                                   *******  Type Exit To Go Back To Menu  ****** 
                                                    
                                                   """ ;
    public static final  String TYPE_OF_SHOW = """
                                                              What You Want To See: 
                                                    *******  Type 1 For Movies  ****** 
                                                    *******  Type 2 For Series  ****** 
                                                    *******  Type 3 For Mini Series  ****** 
                                                   """ ;
    
    
     public static final  String TYPE_NAME_OR_ID_OF_MOVIE = "Type Name Or Id To Search Movie";
     public static final  String TYPE_NAME_OR_ID_OF_SERIE = "Type Name Or Id To Search Serie";
     public static final  String TYPE_NAME_OR_ID_OF_MINI_SERIE = "Type Name Or Id To Search Mini Serie";
     
     public static final  String ENTER_TO_NEXT = "Press Enter to continue...";
     public static final  String SHOW_FOUND_BY_NAME = "Show found: ";
     public static final  String SHOW_ACTORS_RESULT = "You Can Only Add Actors To This Movie. Actors: ";
     public static final  String SHOW_HAVE_MAX_ACTORS = "Maximum Entries For Actors You Can't Add More Actors";
     public static final  String PRESS_TO_ADD_ACTOR = "Press 1 To Add Actors Or  2 To Exit";
     public static final  String NOTHING_FOUND = "Nothing Found";
     public static final  String SHOW_SERIES_RESULT = "You Can Add Actors, Seasons and Episodes To This Serie. Actors: ";
     public static final  String SHOW_SERIE_HAVE_MAX_ACTORS = "Maximum Entries For Actors You Add More Actors"; 
     public static final  String PRESS_TO_ADD_TO_SERIE = "Press 1 To Edit Actors Or  2 To Edit Season Or 3 To Edit Episodes Or 4 To Exit";
     
     public static final  String EDIT_NUMBER_OF_SEASON = "Edit Number Of Seasons(If Delete Season Also Episodes Will Delete!!!)"; 
     public static final  String WRONG_SEASON_NUMBER = "You Can't Set Seasons To Zero Enter Seasons Again";

     
     // ****************  2. SearchActorsAndDirectors ****************
     public static final  String SEARCH_ACTORS_DIRECTORS = """
                                                                                                            Search  Actors Or Directors
                                                                                                 *******  Type 1 To Search Actors By Name  ******             
                                                                                                 *******  Type 2 To Search Directors By Name ****** 
                                                                                                 *******  Type Exit To Go Back To Menu  ****** 
                                                                                                 """ ;
     public static final  String TYPE_ACTOR_FNAME = "Type First Name Of Actor And Press Enter";
     public static final  String TYPE_ACTOR_LNAME = "Type Last Name Of Actor And Press Enter";
     public static final  String RESULT_ACTORS_SEARCH = "Actor found: ";
     public static final  String ACTION_AFTER_SEARCH_ACTOR = "Press 1. To See Maximum And Minimum Average Of Show That Actor Played . Press 2 To Add Actor To Your Favorites";
     public static final String MOVIES_FOR_SEARCHED = "Movies Found: ";
     public static final  String TYPE_DIRECTOR_FNAME = "Type First Name Of Director And Press Enter ";
     public static final  String TYPE_DIRECTOR_LNAME = "Type Last Name Of Director And Press Enter";
     public static final  String ACTION_AFTER_SEARCH_DIRECTOR = "Press 1. To See Maximum And Minimum Average Of Show That Director Directed . Press 2 To Add Director To Your Favorites. Press 3 To Exit";
     public static final  String RESULT_DIRECTORS_SEARCH = "Director found: ";
     public static final  String ACTION_AFTER_SEARCH_DIRECTORS = "Press 1. To See Maximum And Minimum Average Of Show That Actor Played . Press 2 To Add Actor To Your Favorites. Press 3 To Exit";
    
     
    // ****************  Generic  ****************
    public static final  String STOP_ADD_ACTORS = "if you want to stop press: 0 if you want to continue press: 1";
    public static final  String BACK_TO_THE_MENU = "Type 0 to go back to the menu";
    public static final  String LAST_ENTRY = "Last entry!!!";
    public static final  String WRONG_INPUT = "Wrong INPUT! Please try again!!!";

    // ****************  Search    ****************

    public static final String SEARCH_SHOW_OPTIONS = "Press 1 to Search by Show Name or 2 by Release Year";
    public static final String ENTER_TITLE = "Enter title.";
    public static final String ENTER_YEAR = "Enter Year";
    public static final String RATE_QUESTION = "Type Title to rate or No to get back to menu";
    public static final String RATE_1_TO_10 = "Rate 1 to 10!";

    // ****************  Accounts    ****************

    public static final String ASK_USERNAME = "Please enter your Username:";

    public static final String ASK_PASSWORD = "Please enter Password:";
    public static final String ASK_EMAIL = "Please enter Email:";
}
