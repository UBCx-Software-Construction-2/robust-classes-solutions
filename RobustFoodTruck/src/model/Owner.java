package model;

/**
 * Created by James on 2017-05-12.
 */
public class Owner {
    private String name;
    private Kitchen kitchen;

    public Owner(String name, Kitchen kit) {
        this.name = name;
        this.kitchen = kit;
    }

    //getters
    public String getName() { return name; }
    public Kitchen getKitchen() { return kitchen; }


    // MODIFIES: this object's kitchen field
    // EFFECTS: invokes the makeTaco() method on this object's kitchen, returns true
    //          unless an exception is caught, otherwise catches exception and returns false
    public boolean orderMoreTacos(int amount) {
        try {
            kitchen.makeTaco(amount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //MODIFIES: this object's kitchen field
    //EFFECTS: invokes the buyIngredients() method on this object's kitchen, returns true.
    public boolean askForMoreIngredients(int amount) {
        try {
            kitchen.buyIngredients(amount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }





}
