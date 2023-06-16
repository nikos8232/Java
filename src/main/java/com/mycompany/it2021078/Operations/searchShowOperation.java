/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Operations;

import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Accounts.Accounts;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Rate;
import com.mycompany.it2021078.Model.Shows.Series;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nik
 */
public class searchShowOperation {
    int i;
    int j;
    int k;
    public ArrayList<ArrayList> SearchShow(){
        Scanner answer = new Scanner(System.in);
        ArrayList<ArrayList> results = new ArrayList<ArrayList>();
        ArrayList<Movie> movies = Data.getMoviesList();
        ArrayList<Series> series = Data.getSeriesList();
        ArrayList<MiniSeries> miniSeries = Data.getMiniSeriesList();
        System.out.println(Messages.SEARCH_SHOW_OPTIONS);

        // Read user input
        String user_choice = answer.nextLine();
        while(!user_choice.equals("1") && !user_choice.equals("2")){
            System.out.println(Messages.WRONG_INPUT);
            user_choice = answer.nextLine();
        }

        if(user_choice.equals("1")){
            System.out.println(Messages.ENTER_TITLE);
            user_choice = answer.nextLine();
            for(i = 0; i< movies.size(); i++){
                if(movies.get(i).getTitle().compareToIgnoreCase(user_choice)== 0){
                    System.out.println("Id: " + movies.get(i).getShowId() + " Title: " +
                            movies.get(i).getTitle() + " Release Year: " +
                            movies.get(i).getYear1() + " Average Score: " +
                            movies.get(i).getAverageRate());
                    results.add(new ArrayList<String>(){{ add(movies.get(i).getShowId()); add(movies.get(i).getTitle()); add("1"); }});
                }
            }
            for(i = 0; i< series.size(); i++){
                if(series.get(i).getTitle().compareToIgnoreCase(user_choice)== 0){
                    System.out.println("Id: " + series.get(i).getShowId() + " Title: " +
                            series.get(i).getTitle() + " Release Year: " +
                            series.get(i).getYear1() + " Average Score: " +
                            series.get(i).getAverageRate() + " Last Year: " +
                            series.get(i).getYearLast());
                    results.add(new ArrayList<String>(){{ add(series.get(i).getShowId()); add(series.get(i).getTitle()); add("2"); }});
                }
            }
            for(i = 0; i< miniSeries.size(); i++){
                if(miniSeries.get(i).getTitle().compareToIgnoreCase(user_choice)== 0){
                    System.out.println("Id: " + miniSeries.get(i).getShowId() + " Title: " +
                            miniSeries.get(i).getTitle() + " Release Year: " +
                            miniSeries.get(i).getYear1() + " Average Score: " +
                            miniSeries.get(i).getAverageRate() + " Last Year: " +
                            miniSeries.get(i).getYearLast());
                    results.add(new ArrayList<String>(){{ add(miniSeries.get(i).getShowId()); add(miniSeries.get(i).getTitle()); add("3"); }});
                }
            }
        }else {
            System.out.println(Messages.ENTER_YEAR);
            user_choice = answer.nextLine();
            for(i = 0; i< movies.size(); i++){
                if(movies.get(i).getYear1().compareTo(user_choice)== 0){
                    System.out.println("Id: " + movies.get(i).getShowId() + " Title: " +
                            movies.get(i).getTitle() + " Release Year: " +
                            movies.get(i).getYear1() + " Average Score: " +
                            movies.get(i).getAverageRate());
                    results.add(new ArrayList<String>(){{ add(movies.get(i).getShowId()); add(movies.get(i).getTitle()); add("1"); }});
                }
            }
            for(i = 0; i< series.size(); i++){
                if(series.get(i).getYear1().compareTo(user_choice)== 0){
                    System.out.println("Id: " + series.get(i).getShowId() + " Title: " +
                            series.get(i).getTitle() + " Release Year: " +
                            series.get(i).getYear1() + " Average Score: " +
                            series.get(i).getAverageRate() + " Last Year: " +
                            series.get(i).getYearLast());
                    results.add(new ArrayList<String>(){{ add(series.get(i).getShowId()); add(series.get(i).getTitle()); add("2"); }});
                }
            }
            for(i = 0; i< miniSeries.size(); i++){
                if(miniSeries.get(i).getYear1().compareTo(user_choice)== 0){
                    System.out.println("Id: " + miniSeries.get(i).getShowId() + " Title: " +
                            miniSeries.get(i).getTitle() + " Release Year: " +
                            miniSeries.get(i).getYear1() + " Average Score: " +
                            miniSeries.get(i).getAverageRate() + " Last Year: " +
                            miniSeries.get(i).getYearLast());
                    results.add(new ArrayList<String>(){{ add(miniSeries.get(i).getShowId()); add(miniSeries.get(i).getTitle()); add("3"); }});
                }
            }
        }
        return results;
    }
    public boolean RateShow(ArrayList<ArrayList<String>> shows, int reason, Data data, ArrayList<Accounts> accounts){
        int rateNum;
        boolean flag = true;
        accountOperation accountOperation = new accountOperation();
        System.out.println(Messages.RATE_QUESTION);
        Scanner answer = new Scanner(System.in);
        String result;
        String newLogIn;
        String user_choice = answer.nextLine();
        if(!(user_choice.compareToIgnoreCase("NO")== 0)){
            while(flag) {
                if(Data.getIsLoggedIn().equals("")) {
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
                for (int i = 0; i < shows.size(); i++) {
                    if (shows.get(i).get(1).compareToIgnoreCase(user_choice) == 0) {
                        if (shows.get(i).get(2).equals("1")) {
                            ArrayList<Movie> movies = Data.getMoviesList();
                            for (j = 0; j < movies.size(); j++) {
                                if (movies.get(j).getTitle().compareToIgnoreCase(shows.get(i).get(1)) == 0) {
                                    if(reason == 0)  {
                                    System.out.println(Messages.RATE_1_TO_10);
                                    user_choice = answer.nextLine();
                                    while (true) {
                                        try {
                                            rateNum = Integer.parseInt(user_choice);
                                            if (rateNum < 1 || rateNum > 10) {
                                                System.out.println(Messages.WRONG_INPUT);
                                                user_choice = answer.nextLine();
                                            } else {
                                                break;
                                            }
                                        } catch (NumberFormatException ex) {
                                            System.out.println(Messages.WRONG_INPUT);
                                            user_choice = answer.nextLine();
                                        }
                                    }
                                    movies.get(j).addRate(new Rate("username", rateNum));}
                                    else {
                                        for(k = 0; k < movies.get(j).getRates().size(); k++){
                                            System.out.println("Username: " + movies.get(j).getRates().get(k).getUsername()
                                            + " Score: " + movies.get(j).getRates().get(k).getRate() );
                                        }
                                        if(movies.get(j).getRates().size() == 0){
                                            System.out.println("No Entries");
                                        }
                                    }
                                    flag =false;
                                    break;
                                }
                            }
                        }
                        if (shows.get(i).get(2).equals("2")) {
                            ArrayList<Series> series = Data.getSeriesList();
                            for (j = 0; j < series.size(); j++) {
                                if (series.get(j).getTitle().compareToIgnoreCase(shows.get(i).get(1)) == 0) {
                                    if(reason == 0){
                                    System.out.println(Messages.RATE_1_TO_10);
                                    user_choice = answer.nextLine();
                                    while (true) {
                                        try {
                                            rateNum = Integer.parseInt(user_choice);
                                            if (rateNum < 1 || rateNum > 10) {
                                                System.out.println(Messages.WRONG_INPUT);
                                                user_choice = answer.nextLine();
                                            } else {
                                                break;
                                            }
                                        } catch (NumberFormatException ex) {
                                            System.out.println(Messages.WRONG_INPUT);
                                            user_choice = answer.nextLine();
                                        }
                                    }
                                    series.get(j).addRate(new Rate("username", rateNum));}
                                    else{
                                        for(k = 0; k < series.get(j).getRates().size(); k++){
                                            System.out.println("Username: " + series.get(j).getRates().get(k).getUsername()
                                                    + " Score: " + series.get(j).getRates().get(k).getRate() );
                                        }
                                        if(series.get(j).getRates().size() == 0){
                                            System.out.println("No Entries");
                                        }
                                    }
                                    flag =false;
                                    break;
                                }
                            }
                        }
                        if (shows.get(i).get(2).equals("3")) {
                            ArrayList<MiniSeries> miniSeries = Data.getMiniSeriesList();
                            for (j = 0; j < miniSeries.size(); j++) {
                                if (miniSeries.get(j).getTitle().compareToIgnoreCase(shows.get(i).get(1)) == 0) {
                                    if(reason == 0){
                                    System.out.println(Messages.RATE_1_TO_10);
                                    user_choice = answer.nextLine();
                                    while (true) {
                                        try {
                                            rateNum = Integer.parseInt(user_choice);
                                            if (rateNum < 1 || rateNum > 10) {
                                                System.out.println(Messages.WRONG_INPUT);
                                                user_choice = answer.nextLine();
                                            } else {
                                                break;
                                            }
                                        } catch (NumberFormatException ex) {
                                            System.out.println(Messages.WRONG_INPUT);
                                            user_choice = answer.nextLine();
                                        }
                                    }
                                    miniSeries.get(j).addRate(new Rate("username", rateNum));}
                                    else{
                                        for(k = 0; k < miniSeries.get(j).getRates().size(); k++){
                                            System.out.println("Username: " + miniSeries.get(j).getRates().get(k).getUsername()
                                                    + " Score: " + miniSeries.get(j).getRates().get(k).getRate() );
                                        }
                                        if(miniSeries.get(j).getRates().size() == 0){
                                            System.out.println("No Entries");
                                        }
                                    }
                                    flag =false;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                if(flag) {
                    System.out.println(Messages.WRONG_INPUT);
                    user_choice = answer.nextLine();
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public boolean ShowRates(ArrayList<ArrayList<String>> shows, Data data, ArrayList<Accounts> accounts){
        return RateShow(shows, 2, data, accounts);
    }
}
