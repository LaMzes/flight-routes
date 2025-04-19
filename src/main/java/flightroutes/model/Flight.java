package flightroutes.model;

public class Flight {

    private String flightFrom;
    private String flightTo;
    private int price;

    public Flight(String flightFrom, String flightTo, int price){
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.price = price;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public int getPrice() {
        return price;
    }
}
