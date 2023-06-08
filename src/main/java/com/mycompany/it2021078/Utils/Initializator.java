package com.mycompany.it2021078.Utils;

import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Series;

import java.util.ArrayList;

public class Initializator {
    public ArrayList<Actors> getActors(){
        ArrayList<Actors> actors = new ArrayList<Actors>();
        actors.add(new Actors("1","Robert", "Deniro",
                "1996", "Amerika", "www.dshds@denXerw.gr"));
        actors.add(new Actors("2","Al", "Paccino",
                "1983", "Puerto Riko", "www.jkha@denXerw.gr"));
        actors.add(new Actors("3","Michalis", "Leventogiannis",
                "1981", "Greece", "www.jgka@denXerw.gr"));
        actors.add(new Actors("4","DenXerw", "Gerwrgiou",
                "1932", "Greece", "www.hjagsh@denXerw.gr"));
        actors.add(new Actors("5","Elena", "Aloumani",
                "1996", "Marousi", "www.hgakas@denXerw.gr"));
        return actors;
    }

    public ArrayList<Directors> getDirectors(){
        ArrayList<Directors> directors = new ArrayList<Directors>();
        directors.add(new Directors("1","Alexandros", "Papakaliatis",
                "1983", "Papakaliatis", "www.dshds@denXerw.gr"));
        directors.add(new Directors("2","Manwlis", "Manousakis",
                "1971", "Greece", "www.jkha@denXerw.gr"));
        directors.add(new Directors("3","David", "Fincher",
                "1937", "Germany", "www.jkjkbjka@denXerw.gr"));
        directors.add(new Directors("4","Stanley", "Cubrik",
                "1988", "USA", "www.hjkkkh@denXerw.gr"));
        directors.add(new Directors("5","Filippos", "Nathanil",
                "1948", "USA", "www.hkkhosdi@denXerw.gr"));
        return directors;
    }
    public ArrayList<Movie> getMovies(){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("1", "Interstellar", new ArrayList<String>(){{add("Genre1"); add("Genre2"); add("Genre3");}},
                "2001", "USA", "Kwstas Papakaliatis",
                new ArrayList<String>(){{add("Actor1"); add("Actor2"); add("Actor3");}}));
        movies.add(new Movie("2", "Indiana Jones", new ArrayList<String>(){{add("Genre2"); add("Genre4");}},
                "2000", "USA", "Manwlis Manousakis",
                new ArrayList<String>(){{add("Actor7"); add("Actor8"); add("Actor9");}}));
        movies.add(new Movie("3", "Barbie", new ArrayList<String>(){{add("Genre3"); add("Genre7"); add("Genre8");}},
                "2023", "USA", "David Fincher",
                new ArrayList<String>(){{add("Actor3"); add("Actor9"); add("Actor12");}}));
        return movies;
    }

    public ArrayList<Series> getSeries(){
        ArrayList<Series> series = new ArrayList<Series>();
        series.add(new Series("1", "Breaking Bad", new ArrayList<String>(){{add("Genre1"); add("Genre2"); add("Genre3");}},
                "2001", "USA", "Kwstas Papakaliatis",
                new ArrayList<String>(){{add("Actor1"); add("Actor2"); add("Actor3");}},
                3, new ArrayList<Integer>(){{add(1); add(2); add(3);}}, "2007"));
        series.add(new Series("2", "Sons of Anarchy", new ArrayList<String>(){{add("Genre5"); add("Genre4"); add("Genre3");}},
                "1999", "USA", "Director 2",
                new ArrayList<String>(){{add("Actor5"); add("Actor5"); add("Actor7");}},
                3, new ArrayList<Integer>(){{add(10); add(4); add(7);}}, "2003"));
        series.add(new Series("3", "Better Call Saul", new ArrayList<String>(){{add("Genre5"); add("Genre8"); add("Genre11");}},
                "1991", "USA", "Director3",
                new ArrayList<String>(){{add("Actor1"); add("Actor2"); add("Actor3");}},
                3, new ArrayList<Integer>(){{add(13); add(4); add(9);}}, "2001"));

        return series;
    }







}
