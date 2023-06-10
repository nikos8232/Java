/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Utils;
import com.mycompany.it2021078.Constants.Messages;
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
/**
 *
 * @author nik
 */
public class entriesValidation {


public boolean isDirectorsPresent(List<Directors> directors, String name, String surname) {
    return directors.stream()
        .anyMatch(director -> director.getFName().equals(name) && director.getLName().equals(surname));
}

public boolean isActorsPresent(List<Actors> directors, String name, String surname) {
    return directors.stream()
        .anyMatch(director -> director.getFName().equals(name) && director.getLName().equals(surname));
}

}
