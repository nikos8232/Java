/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Model.Shows;
import com.mycompany.it2021078.Interfaces.PeopleIDGenerator;
import com.mycompany.it2021078.Interfaces.ShowIDGenerator;
import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author nik
 */
public class Shows  implements ShowIDGenerator{
    
    protected String showId;
    protected String title;
    protected ArrayList<String> genre  = new ArrayList<>();
    protected int year1;
    protected String prodCountry;
    protected String directorInfo;
    protected ArrayList<String> actorInfo;
    
    @Override
    public String toString() {
        return "Show Id=" + showId + ", Title=" + title +  ", Show Type=Show" + genre + ", genre=" + genre + ", directorInfo=" + directorInfo + "]";
    }
    
    public Shows(){}
    public Shows(String showId, String title, ArrayList<String> genre, int year1, String prodCountry, String directorInfo, ArrayList<String> actorInfo){
       
        this.showId = showId;
        this.title = title;
        this.genre = genre;
        this.year1 = year1;
        this.prodCountry = prodCountry;
        this.directorInfo = directorInfo;
        this.actorInfo = actorInfo;
           
    }
   
    
    // Getter
    public String getShowId() {
      return showId;
    }

    // Setter
    public void setShowId(String newShowId) {
      this.showId = newShowId;
    }
    
    // Getter
    public String getTitle() {
      return title;
    }

    // Setter
    public void setTitle(String newTitle) {
      this.title = newTitle;
    }
    
    // Getter
    public ArrayList<String> getGenre() {
      return genre;
    }

    // Setter
    public void setGenre(ArrayList<String> newGenre) {
      this.genre = newGenre;
    }
    
    // Getter
    public int getYear1() {
      return year1;
    }

    // Setter
    public void setyear1(int newYear1) {
      this.year1 = newYear1;
    }
    
    // Getter
    public String getProdCountry() {
      return prodCountry;
    }

    // Setter
    public void setProdCountry(String newProdCountry) {
      this.prodCountry = newProdCountry;
    }
    
    // Getter
    public String getDirectorInfo() {
      return directorInfo;
    }

    // Setter
    public void setDirectorInfo(String newDirectorInfo) {
      this.directorInfo = newDirectorInfo;
    }
    
    // Getter
    public ArrayList<String> getActorInfo() {
      return actorInfo;
    }

    // Setter
    public void setActorInfo(ArrayList<String> newActorInfo) {
      this.actorInfo = newActorInfo;
    }
    
}
