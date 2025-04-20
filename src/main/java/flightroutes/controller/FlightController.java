package flightroutes.controller;

import flightroutes.model.RequestDTO;
import flightroutes.model.ResponseDTO;
import flightroutes.model.Route;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import flightroutes.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/routes")
    public ResponseEntity<List<ResponseDTO>> getRoutes(@Valid @RequestBody RequestDTO request) {

        List<Route> routes = flightService.getAllRoutes(
                request.getOrigin(),
                request.getDestination(),
                request.getMaxFlights()
        );

        List<ResponseDTO> response = routes.stream()
                .map(route -> new ResponseDTO(route.getCities(), route.getTotalPrice()))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/flightroutes/test")
    public String test() {
        return "API is running!";
    }
}
