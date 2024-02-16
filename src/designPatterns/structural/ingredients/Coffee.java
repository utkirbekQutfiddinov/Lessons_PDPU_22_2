package designPatterns.structural.ingredients;

public class Coffee {
    private String name="oddiy";
    private int price=100;

    public Coffee(Coffee coffee) {
        this.name=coffee.getName();
        this.price=coffee.getPrice();
    }

    public Coffee() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
