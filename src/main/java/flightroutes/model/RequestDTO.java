package flightroutes.model;

public class RequestDTO {

    private String origin;
    private String destination;
    private Integer maxFlights;

    public String getOrigin(){
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getMaxFlights() {
        return maxFlights;
    }
}
