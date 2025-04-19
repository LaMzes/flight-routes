package flightroutes.model;

import java.util.List;

public class Route {

    private List<String> cities;
    private int totalPrice;

    public Route(List<String> cities, int totalPrice){
        this.cities = cities;
        this.totalPrice = totalPrice;
    }

    public List<String> getCities() {
        return cities;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
