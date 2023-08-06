package Decorator;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDiscription() + ": $" + beverage.cost());

        Beverage beverage1 = new Mocha(new Mocha(new DarkRoast()));

        System.out.println(beverage1.getDiscription() + ": $" + beverage1.cost());

    }
}
