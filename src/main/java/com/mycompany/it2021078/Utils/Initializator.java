package com.mycompany.it2021078.Utils;

import com.mycompany.it2021078.Model.People.Actors;
import com.mycompany.it2021078.Model.People.Directors;
import com.mycompany.it2021078.Model.Shows.MiniSeries;
import com.mycompany.it2021078.Model.Shows.Movie;
import com.mycompany.it2021078.Model.Shows.Series;

import java.util.ArrayList;

public class Initializator {
    public ArrayList<Actors> getActors(){
        ArrayList<Actors> actors = new ArrayList<Actors>();
        actors.add(new Actors("1A","Brad", "Pitt",
                1963, "USA", "www.dshds@denXerw.gr"));
        actors.add(new Actors("2A","Al", "Pacino",
                1970, "New York City", "www.jkha@denXerw.gr"));
        actors.add(new Actors("3A","Leonardo", "Dicaprio",
                1974, "Greece", "www.jgka@denXerw.gr"));
        actors.add(new Actors("4A","Elisabeth", "Moss",
                1982, "USA", "www.hjagsh@denXerw.gr"));
        actors.add(new Actors("5A","Bob", "Odenkirk",
                1962, "USA", "www.hgakas@denXerw.gr"));
        return actors;
    }

    public ArrayList<Directors> getDirectors(){
        ArrayList<Directors> directors = new ArrayList<Directors>();
        directors.add(new Directors("1D","David", "Fincher",
                1962, "Colorado", "www.dshds@denXerw.gr"));
        directors.add(new Directors("2D","Quentin", "Tarantino",
                1963, "Noxvil", "www.jkha@denXerw.gr"));
        directors.add(new Directors("3D","Christopher", "Nolan",
                1970, "England", "www.jkjkbjka@denXerw.gr"));
        directors.add(new Directors("4D","Michelle", "MacLaren",
                1965, "USA", "www.hjkkkh@denXerw.gr"));
        directors.add(new Directors("5D","Stanley", "Kubrick",
                1928, "USA", "www.hkkhosdi@denXerw.gr"));
        return directors;
    }
    public ArrayList<Movie> getMovies(){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("1M", "Fight Club", new ArrayList<String>(){{add("Drama");}},
                1999, "USA", "David Fincher",
                new ArrayList<String>(){{add("Brad Pitt"); add("Edward Norton"); add("Zach Grenier");}}));
        movies.add(new Movie("2M", "Pulp Fiction", new ArrayList<String>(){{add("Crime"); add("Drama");}},
                1994, "USA", "David Fincher",
                new ArrayList<String>(){{add("Brad Pitt"); add("Uma Thurman"); add("Samuel Jackson");}}));
        movies.add(new Movie("3M", "Inception", new ArrayList<String>(){{add("Action"); add("Adventure"); add("Sci-Fi");}},
                2010, "USA", "Christopher Nolan",
                new ArrayList<String>(){{add("Brad Pitt"); add("Elliot Page"); add("Ken Watanabe");}}));
        return movies;
    }

    public ArrayList<Series> getSeries(){
        ArrayList<Series> series = new ArrayList<Series>();
        series.add(new Series("1S", "Breaking Bad", new ArrayList<String>(){{add("Crime"); add("Drama"); add("Thriller");}},
                2008, "USA", "Michelle MacLaren",
                new ArrayList<String>(){{add("Bryan Cranston"); add("Anna Gunn"); add("Aaron Paul");}},
                5, new ArrayList<Integer>(){{add(7); add(13); add(13); add(13); add(16);}}, 2013));
        series.add(new Series("2S", "Mad Men", new ArrayList<String>(){{add("Drama");}},
                2007, "USA", "Matthew Weiner",
                new ArrayList<String>(){{add("John Hamm"); add("Elizabeth Moss"); add("Vincent Kartheiser");}},
                3, new ArrayList<Integer>(){{add(13); add(13); add(13);}}, 2015));
        series.add(new Series("3S", "Better Call Saul", new ArrayList<String>(){{add("Crime"); add("Drama");}},
                2015, "USA", "Michelle MacLaren",
                new ArrayList<String>(){{add("Bob Odenkirk"); add("Rhea Seehorn"); add("Jonathan Banks");}},
                6, new ArrayList<Integer>(){{add(10); add(10); add(10); add(10); add(10); add(13);}}, 2022));

        return series;
    }

    public ArrayList<MiniSeries> getMiniSeries(){
        ArrayList<MiniSeries> miniSeries = new ArrayList<MiniSeries>();
        miniSeries.add(new MiniSeries("1MS", "Chernobyl", new ArrayList<String>(){{add("Drama"); add("History"); add("Thriller");}},
                2019, "USA", "Craig Mazin",
                new ArrayList<String>(){{add("Jessie Buckley"); add("Jared Harris"); add("Stellan Skarsgard");}},
                1, new ArrayList<Integer>(){{add(5);}}, 2019));
        miniSeries.add(new MiniSeries("2MS", "1883", new ArrayList<String>(){{add("Drama"); add("Western");}},
                2021, "USA", "Taylor Sheridan",
                new ArrayList<String>(){{add("Sam Elliot"); add("Faith Hill"); add("Isabel May");}},
                1, new ArrayList<Integer>(){{add(10);}}, 2022));
        miniSeries.add(new MiniSeries("3MS", "The Haunting of Hill House", new ArrayList<String>(){{add("Drama"); add("Horror"); add("Mystery");}},
                2018, "USA", "Mike Flanagan",
                new ArrayList<String>(){{add("Michiel Huisman"); add("Carla Gugino"); add("Henry Thomas");}},
                1, new ArrayList<Integer>(){{add(10);}}, 2018));

        return miniSeries;
    }





}
