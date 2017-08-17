package model;

public class Movie {

    private String title;
    private int ageRestriction;
    private int currentSeating;
    private int maxSeating;

    public Movie(String title, int ageRestriction, int seating) {
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.currentSeating = 0;
        maxSeating = seating;
    }

    //getters
    public String getTitle() { return title; }
    public int getAgeRestriction() { return ageRestriction; }
    public int getCurrentSeating() { return currentSeating; }
    public int getMaxSeating() { return maxSeating; }

    // EFFECTS: return true if the movie is full
    public boolean isFull() {
        return currentSeating >= maxSeating;
    }

    // EFFECTS: increment the currentSeating field
    public void addViewer() { currentSeating++; }


}
