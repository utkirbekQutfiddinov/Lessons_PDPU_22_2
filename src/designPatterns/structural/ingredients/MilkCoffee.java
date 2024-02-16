package designPatterns.structural.ingredients;

public class MilkCoffee extends Coffee {
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    public MilkCoffee() {
    }

    @Override
    public String getName() {
        return super.getName() + " + sut(1)";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 7;
    }
}
