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
public class MiniSeries extends Series{
    
     @Override
    public String toString() {
        return "Show Id=" + showId + ", Title=" + title +  ", Show Type=Mini Serie"  +  ", genre=" + genre +  ", directorInfo=" + directorInfo + ", actorInfo=" + actorInfo + ", seasons=" + seasons + ", episodes=" + episodes + ", yearLast=" + yearLast;
    }
    public MiniSeries(){}
    
    public MiniSeries(String showId, String title, ArrayList<String> genre, String year1, String prodCountry, String directorInfo, ArrayList<String> actorInfo, int seasons, ArrayList<Integer> episodes, String yearLast){
       
        super(showId, title, genre, year1, prodCountry, directorInfo, actorInfo, seasons, episodes,yearLast );    
   
    }
    
}
