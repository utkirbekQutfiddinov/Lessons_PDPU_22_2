package designPatterns.structural;

import designPatterns.structural.ingredients.Coffee;
import designPatterns.structural.ingredients.MilkCoffee;
import designPatterns.structural.ingredients.SugarCoffee;

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();

        for (int i = 0; i < 2; i++) {
            coffee = new SugarCoffee(coffee);
        }

        coffee = new MilkCoffee(coffee);

        System.out.println(coffee.getPrice());
        System.out.println(coffee.getName());


    }
}
