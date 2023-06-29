package com.mycompany.it2021078.Model.People;

import com.mycompany.it2021078.Model.People.People;
import java.util.ArrayList;
import java.util.Date;


public class Actors extends People {
    
    
    @Override
    public String toString() {
        return "Actors [peopleId=" + peopleId + ", fName=" + fName +  ", lName=" + lName + ", birthDate=" + birthDate + ", birthCountry=" + birthCountry + ", website=" + website +"]";
    }
    public Actors(){}
     public Actors(String peopleId, String fName, String lName, int birthDate, String birthCountry, String website){
        super(peopleId, fName, lName, birthDate, birthCountry, website );
    }
}
