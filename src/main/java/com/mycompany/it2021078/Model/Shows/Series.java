
package com.mycompany.it2021078.Model.Shows;
import com.mycompany.it2021078.Model.Shows.Shows;
import java.util.ArrayList; // import the ArrayList class


public class Series extends Shows {
    
    protected int seasons;
    protected ArrayList<Integer> episodes;
    protected String yearLast;
    
    
    @Override
    public String toString() {
        return "Shows [showId=" + showId + ", title=" + title +  ", genre=" + genre + ", year1=" + year1 + ", prodCountry=" + prodCountry + ", directorInfo=" + directorInfo + ", actorInfo=" + actorInfo +"]";
    }
    public Series(){}
    
    public Series(String showId, String title, ArrayList<String> genre, String year1, String prodCountry, String directorInfo, ArrayList<String> actorInfo, int seasons, ArrayList<Integer> episodes, String yearLast){
       
        super(showId, title, genre, year1, prodCountry, directorInfo,actorInfo );
        this.seasons = seasons;
        this.episodes = episodes;
        this.yearLast = yearLast;
        
   
    }
   
    // Getter
    public int getSeasons() {
      return seasons;
    }

    // Setter
    public void setSeasons(int newSeasons) {
      this.seasons = newSeasons;
    }
    
    
    // Getter
    public ArrayList<Integer> getEpisodes() {
      return episodes;
    }

    // Setter
    public void setEpisodes(ArrayList<Integer> newEpisodes) {
      this.episodes = newEpisodes;
    }
    
    
    // Getter
    public String getYearLast() {
      return yearLast;
    }

    // Setter
    public void setYearLast(String newYearLast) {
      this.yearLast = newYearLast;
    }
    
}
