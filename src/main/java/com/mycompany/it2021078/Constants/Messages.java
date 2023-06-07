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
                                        *******  Press 5 To Sign Up  ****** """;
    
    
    public static final  String CHOOSE_SHOW_TYPE = """
                                                              What you want to do? 
                                                    *******  Press 1 To Insert Movie  ****** 
                                                    *******  Press 2 To Insert Serie  ****** 
                                                    *******  Press 3 To Insert Mini Serie  ****** 
                                                   """ ;
    
    // ****************  Show  ****************
    public static final  String INSERT_SHOW_TITLE = "Insert Show's Title";
    public static final  String INSERT_SHOW_RELEASE_YEAR = "Insert Show's Release Year";
    public static final  String INSERT_SHOW_GENRE = "Insert Show's Genre(e.g. Crime,Drame,Romantic)";
    public static final  String MAXIMUM_GENRES = "The maximum number of genres must be less than or equal to 3";
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
    
    
    // ****************  Generic  ****************
    public static final  String STOP_ADD_ACTORS = "if you want to stop press: 0 if you want to continue press: 1";
    public static final  String BACK_TO_THE_MENU = "Press 0 to go back to the menu";
    public static final  String LAST_ENTRY = "Last entry!!!";
    

    
}
