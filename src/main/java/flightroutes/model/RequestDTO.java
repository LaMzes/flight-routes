package flightroutes.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RequestDTO {

    @NotBlank(message = "Origin cannot be null or empty")
    @Size(min = 3, max = 3, message = "Origin must be exactly 3 letters")
    private String origin;
    @NotBlank(message = "Destination cannot be null or empty")
    @Size(min = 3, max = 3, message = "Destination must be exactly 3 letters")
    private String destination;
    @Positive
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
