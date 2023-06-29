package com.mycompany.it2021078.Model.People;
import java.util.ArrayList;
import java.util.Date;

import com.mycompany.it2021078.Interfaces.PeopleIDGenerator;




public class People implements PeopleIDGenerator{
    
    protected String peopleId;
    protected String fName;
    protected String lName;
    protected int birthDate;
    protected String birthCountry;
    protected String website;
    
    
    @Override
    public String toString() {
        return "People [peopleId=" + peopleId + ", fName=" + fName +  ", lName=" + lName + ", birthDate=" + birthDate + ", birthCountry=" + birthCountry + ", website=" + website +"]";
    }
    public People(){}
    public People(String peopleId, String fName, String lName, int birthDate, String birthCountry, String website){
       
        this.peopleId = peopleId;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
        this.website = website;
           
    }
   
    // Getter
    public String getPeopleId() {
      return peopleId;
    }

    // Setter
    public void setPeopleId(String newPeopleId) {
      this.peopleId = newPeopleId;
    }
    

    // Getter
    public String getFName() {
      return fName;
    }

    // Setter
    public void setFName(String newFName) {
      this.fName = newFName;
    }
    
    // Getter
    public String getLName() {
      return lName;
    }

    // Setter
    public void setLName(String newLName) {
      this.lName = newLName;
    }
    
    // Getter
    public int getBirthDate() {
      return birthDate;
    }

    // Setter
    public void setBirthDate(int newBirthDate) {
      this.birthDate = newBirthDate;
    }
    
    // Getter
    public String getBirthCountry() {
      return birthCountry;
    }

    // Setter
    public void setBirthCountry(String newBirthCountry) {
      this.birthCountry = newBirthCountry;
    }
    
    // Getter
    public String getWebsite() {
      return website;
    }

    // Setter
    public void setWebsite(String newWebsite) {
      this.website = newWebsite;
    }
    
    
    
}

