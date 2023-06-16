/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Model;

import com.mycompany.it2021078.Model.Accounts.Accounts;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Series;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Shows;
import com.mycompany.it2021078.Utils.Initializator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nik
 */
public class Data {
    
    static String isLoggedIn;
    static ArrayList<Movie> moviesList;
    static ArrayList<Directors> directorsList;
    static ArrayList<Actors> actorsList;
    static ArrayList<Series> seriesList;
    static ArrayList<MiniSeries> miniSeriesList;

    // Constructors
    //Ηello
    public Data(){}
    public Data(ArrayList<Movie> moviesList, ArrayList<Directors> directorsList, ArrayList<Actors> actorsList, ArrayList<Series> seriesList ,ArrayList<MiniSeries> miniSeriesList) {
        this.moviesList = moviesList;
        //this.showsList = showsList;
        this.directorsList = directorsList;
        this.actorsList = actorsList;
        this.seriesList = seriesList;
        this.miniSeriesList = miniSeriesList;
    }

    // Getters
//    public static ArrayList<Shows> getShowsList() {
//        return showsList;
//    }
    public static String getIsLoggedIn() {
        return isLoggedIn;
    }
    public static ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    public static ArrayList<Directors> getDirectorsList() {
        return directorsList;
    }

    public static ArrayList<Actors> getActorsList() {
        return actorsList;
    }

    public static ArrayList<Series> getSeriesList() {
        return seriesList;
    }

    public static ArrayList<MiniSeries> getMiniSeriesList() {
        return miniSeriesList;
    }

    // Setters
//    public void setShowsList(ArrayList<Shows> showsList) {
//        this.showsList = showsList;
//    }

    public void setIsLoggedIn (String isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
    public void setMoviesList(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public void setDirectorsList(ArrayList<Directors> directorsList) {
        this.directorsList = directorsList;
    }

    public void setActorsList(ArrayList<Actors> actorsList) {
        this.actorsList = actorsList;
    }

    public void setSeriesList(ArrayList<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public void setMiniSeriesList(ArrayList<MiniSeries> miniSeriesList) {
        this.miniSeriesList = miniSeriesList;
    }

    //Initiate data

     public void initiateDataArrays(){
        Initializator init = new Initializator();
        this.setActorsList(init.getActors());
        this.setDirectorsList(init.getDirectors());
        this.setMoviesList(init.getMovies());
        this.setSeriesList(init.getSeries());
        this.setMiniSeriesList(init.getMiniSeries());
    }
    
}
