package model;

import exceptions.IllegalAgeException;
import exceptions.IllegalAmountException;
import exceptions.MissingFareException;
import exceptions.NoBalanceException;

public class BusFareCard {

    private static final int AGE_CUTOFF = 18;
    public static final double ADULT_FARE = 2.75;
    public static final double CONCESSION_FARE = 1.75;
    private String ownerName;
    private int ownerAge;
    private double balance;
    private boolean fareLoaded;

    public BusFareCard(String nm, int age, double initialLoad) throws IllegalAmountException {
        if (initialLoad < 0) {
            throw new IllegalAmountException("$" + initialLoad + " is not a valid amount to load onto your card.");
        } else {
            ownerName = nm;
            ownerAge = age;
            balance = initialLoad;
            fareLoaded = false;
        }

    }

    // getters
    public String getName() { return ownerName; }
    public int getAge() { return ownerAge; }
    public double getBalance() { return balance; }
    public boolean isFareLoaded() { return fareLoaded; }

    // MODIFIES: this
    // EFFECTS: subtract cost of the adult fare from the balance and set the fareLoaded field to true,
    //          throws IllegalAgeException if ownerAge <= AGE_CUTOFF,
    //          throws NoBalanceException if balance - ADULT_FARE <0
    public void purchaseAdultFare() throws IllegalAgeException, NoBalanceException {
        if (ownerAge <= AGE_CUTOFF) {
            throw new IllegalAgeException("Please purchase a concession fare.");
        } else {
            if (balance - ADULT_FARE < 0) {
                throw new NoBalanceException("You do not have enough money to purchase this fare.");
            } else {
                balance -= ADULT_FARE;
                fareLoaded = true;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: subtract cost of a concession fare from the balance, set the fareLoaded field to true,
    //          throws IllegalAgeException if ownerAge > AGE_CUTOFF,
    //          throws NoBalanceException if balance - CONCESSION_FARE < 0
    public void purchaseConcessionTicket() throws IllegalAgeException, NoBalanceException {
        if (ownerAge > AGE_CUTOFF) {
            throw new IllegalAgeException("Please purchase an adult fare.");
        } else {
            if (balance - CONCESSION_FARE < 0) {
                throw new NoBalanceException("You do not have enough money to purchase this fare.");
            } else {
                balance -= CONCESSION_FARE;
                fareLoaded = true;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the specified amount onto the card's balance field,
    //          throws IllegalAmountException if amount <= 0
    public void reloadBalance(double amount) throws IllegalAmountException {
        if (amount <= 0) {
            throw new IllegalAmountException("This is not a valid amount to reload onto your card.");
        } else {
            balance += amount;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets fareLoaded field to false, else throws exception,
    //          throws MissingFareException if fareLoaded != true
    public void boardBus() throws MissingFareException {
        if (fareLoaded) {
            fareLoaded = false;
        } else {
            throw new MissingFareException("You do not have a fare loaded.");
        }
    }


}

