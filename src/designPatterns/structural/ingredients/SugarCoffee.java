package designPatterns.structural.ingredients;

public class SugarCoffee extends Coffee {

    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    public SugarCoffee() {
    }

    public String getName() {
        return super.getName() + " + shakar(1)";
    }

    public int getPrice() {
        return super.getPrice() + 5;
    }
}
