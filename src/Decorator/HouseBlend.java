package Decorator;

public class HouseBlend extends Beverage{
    public HouseBlend() {
        discription = "Amazing House Blend from the Starbuzz house";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
