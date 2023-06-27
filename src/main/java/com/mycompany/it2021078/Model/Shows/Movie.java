/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Model.Shows;

import com.mycompany.it2021078.Model.Shows.Shows;
import java.util.ArrayList;

/**
 *
 * @author nik
 */
public class Movie extends Shows {
    
    
     @Override
    public String toString() {
        return "Show Id=" + showId + ", Title=" + title +  ", Show Type=Movie" + genre + ", genre=" + genre + ", directorInfo=" + directorInfo;
    }
    
    public Movie(){super();}
     public Movie(String showId, String title, ArrayList<String> genre, int year1, String prodCountry, String directorInfo, ArrayList<String> actorInfo ){
        super(showId, title, genre, year1, prodCountry, directorInfo,actorInfo );
    }
    
}
