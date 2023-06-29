package com.mycompany.it2021078.Utils;
import com.mycompany.it2021078.Constants.Messages;
import com.mycompany.it2021078.Model.Accounts.Accounts;
import com.mycompany.it2021078.Model.Data;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Shows;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.Shows.Series;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class entriesValidation {


public boolean isDirectorsPresent(List<Directors> directors, String name, String surname) {
    return directors.stream()
        .anyMatch(director -> director.getFName().equals(name) && director.getLName().equals(surname));
}

public boolean isActorsPresent(List<Actors> directors, String name, String surname) {
    return directors.stream()
        .anyMatch(director -> director.getFName().equals(name) && director.getLName().equals(surname));
}

public static boolean validLastYearOfSerie(int prodYear, int lastYear){

    return lastYear >= prodYear;
}
public static boolean validDate(int  input_year){
    int currentYear = LocalDate.now().getYear();
    return input_year <= currentYear && input_year > 1500;
    
}

public static boolean isUsernameExist(String username, ArrayList<Accounts> accounts) {
        // Check if the username already exists in the accountList
        for (Accounts account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
