package flightroutes.model;

import java.util.List;

public class ResponseDTO {

    private List<String> cities;
    private int price;

    public ResponseDTO(List<String> cities, int price) {
        this.cities = cities;
        this.price = price;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
