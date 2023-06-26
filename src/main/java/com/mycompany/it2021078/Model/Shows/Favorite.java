/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Model.Shows;

import java.util.ArrayList;

/**
 *
 * @author nik
 */
public class Favorite {
    
    private String username;
    private ArrayList<String> favActors;
    private ArrayList<String> favDirector;
    
    public Favorite(String username, ArrayList<String> favActors, ArrayList<String> favDirector){
        this.username = username;
        this.favActors = favActors;
        this.favDirector = favDirector;
    }

    public String getUsername(){return this.username;}
    
    public void setUsername(String username){this.username = username;}

    public ArrayList<String> getFavActors() {return favActors;}
    
    public void setFavActors(ArrayList<String> favActors){this.favActors = favActors;}
    
    public ArrayList<String> getFavDirector() {return favDirector;}
    
    public void setFavDirector(ArrayList<String> favDirector){this.favDirector = favDirector;}
    
    
    
    
    
}
    

