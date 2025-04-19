package flightroutes.controller;

import flightroutes.model.RequestDTO;
import flightroutes.model.ResponseDTO;
import flightroutes.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import flightroutes.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/routes")
    public List<ResponseDTO> getRoutes(@RequestBody RequestDTO request) {

        List<Route> routes = flightService.getAllRoutes(
                request.getOrigin(),
                request.getDestination(),
                request.getMaxFlights()
        );

        return routes.stream()
                .map(route -> new ResponseDTO(route.getCities(), route.getTotalPrice()))
                .collect(Collectors.toList());
    }

    @GetMapping("/test")
    public String test() {
        return "API is running!";
    }
}
