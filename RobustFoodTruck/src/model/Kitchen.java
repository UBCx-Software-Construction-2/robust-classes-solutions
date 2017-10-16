package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Kitchen {

    private static final int INGREDIENT_PER_TACO = 3;
    private static final int DOLLAR_PER_INGREDIENT = 2;
    private int ingredient;
    private int tacoCount;
    private int balance;
    private boolean cookReady;

    public Kitchen(int initialIngredient, int initialTaco, int balance, boolean cookStatus) {
        ingredient = initialIngredient;
        tacoCount = initialTaco;
        cookReady = cookStatus;
        this.balance = balance;
    }

    // getters
    public int getIngredientCount() { return ingredient; }
    public int getTacoCount() { return tacoCount; }
    public boolean getCookState() { return cookReady; }
    public int getBalance() { return balance; }

    public void setCookStatus(boolean b) {
        cookReady = b;
    }

    // MODIFIES: this
    // EFFECTS:  number is added to tacoCount, and ingredient is decremented accordingly,
    //           throws NoCookException if !cookReady,
    //           throws NoIngredientException if ingredient - (INGREDIENT_PER_TACO * amount) < 0
    public void makeTaco(int amount) throws NoIngredientException, NoCookException {
        if (!cookReady) {
            throw new NoCookException("We don't have a cook!");
        } else {
            if (ingredient - (INGREDIENT_PER_TACO * amount) < 0) {
                throw new NoIngredientException("We don't have enough ingredients!");
            } else {
                   ingredient -= (INGREDIENT_PER_TACO * amount);
                tacoCount += amount;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: (amount) is added to the ingredient field, and the balance field is decremented accordingly,
    //          throws NotEnoughMoneyException if balance = (DOLLAR_PER_INGREDIENT * amount) < 0
    public void buyIngredients(int amount) throws NotEnoughMoneyException {
        if (balance - (DOLLAR_PER_INGREDIENT * amount) < 0) {
            throw new NotEnoughMoneyException("Not enough money to buy ingredients!");
        } else {
            ingredient += amount;
            balance -= (DOLLAR_PER_INGREDIENT * amount);
        }
    }


}
