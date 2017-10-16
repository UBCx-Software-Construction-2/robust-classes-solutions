package model;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;

public class MovieGoer {

    private String name;
    private int age;
    private Ticket ticket;
    private TicketKiosk tk;

    public MovieGoer(String name, int age,  TicketKiosk tk) {
        this.name = name;
        this.age = age;
        ticket = null;
        this.tk = tk;
    }

    //getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public TicketKiosk getTicketKiosk() { return tk; }
    public Ticket getTicket() { return ticket; }

    // EFFECTS: ticket becomes set to a new ticket with the given movie,
    //          throws UnderAgeException if age < m.getAgeRestriction,
    //          throws ShowingFullException if m.isFull
    public boolean buyTicket(Movie m) throws UnderAgeException, ShowingFullException {
        if (age < m.getAgeRestriction()) {
            throw new UnderAgeException("You are too young to watch " + m.getTitle());
        } else {
            if (m.isFull()) {
                throw new ShowingFullException(m.getTitle() + " is at capacity.");
            } else {
                ticket = new Ticket(m);
                m.addViewer();
                return true;
            }
        }
    }


}
