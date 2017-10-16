package model;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;
import java.util.LinkedList;
import java.util.List;

public class TicketKiosk {

    private String name;
    private List<Movie> movies;

    public TicketKiosk(String name) {
        this.name = name;
        movies = new LinkedList<>();
    }

    // getters
    public String getName() { return name; }
    public List<Movie> getMovies() { return movies; }

    //EFFECTS: adds the movie (m) to the movies field. Check if the movie (m) is already within movies before you
    //         add it in the method. If adding (m) is successful, return true, else return false.
    public boolean addMovie(Movie m) {
        if (!movies.contains(m)) {
            movies.add(m);
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: sells a ticket for the given movie to the given moviegoer. Return true if
    //          the purchase is successful, else false. Catches UnderAgeException and ShowingFullException.
    public boolean sellTicket(MovieGoer mg, Movie m) {
        try {
            mg.buyTicket(m);
            return true;
        } catch (UnderAgeException | ShowingFullException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
