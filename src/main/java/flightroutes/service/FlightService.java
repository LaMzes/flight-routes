package flightroutes.service;

import flightroutes.model.Flight;
import flightroutes.model.Route;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {
    private Map<String, List<Flight>> graph = new HashMap<>();
    private List<Route> routes = new ArrayList<>();

    private List<Flight> flights = Arrays.asList(
            new Flight("SOF", "MLE", 70),
            new Flight("SOF", "LON", 10),
            new Flight("LON", "MLE", 20),
            new Flight("SOF", "IST", 10),
            new Flight("IST", "CMB", 20),
            new Flight("CMB", "MLE", 40),
            new Flight("SOF", "NYC", 20)
    );

    private void buildGraph(){
        graph.clear();
        for (Flight flight : flights){
            graph.computeIfAbsent(flight.getFlightFrom(), k -> new ArrayList<>()).add(flight);
        }
    }

    private void findRoutes(String current, String destination, List<String> path, int priceSoFar, int flightsSoFar, Integer maxFlights, Set<String> visited){
        if (current.equals(destination)) {
            if (path.size() > 1) {
                List<String> routeCities = new ArrayList<>(path);
                routes.add(new Route(routeCities, priceSoFar));
            }
            return;
        }


        if (maxFlights != null && flightsSoFar >= maxFlights){
            return;
        }

        List<Flight> flightsFromCurrent = graph.getOrDefault(current, new ArrayList<>());
        for (Flight flight : flightsFromCurrent){
            if (visited.contains(flight.getFlightTo())) {
                continue;
            }

            path.add(flight.getFlightTo());
            visited.add(flight.getFlightTo());

            findRoutes(flight.getFlightTo(), destination, path, priceSoFar + flight.getPrice(), flightsSoFar + 1, maxFlights, visited);

            path.remove(path.size() - 1);
            visited.remove(flight.getFlightTo());
        }
    }

    public List<Route> getAllRoutes(String origin, String destination, Integer maxFlights) {
        routes.clear();

        buildGraph();

        List<String> path = new ArrayList<>();
        path.add(origin);
        Set<String> visited = new HashSet<>();
        visited.add(origin);

        findRoutes(origin, destination, path, 0, 0, maxFlights, visited);

        routes.sort(Comparator.comparingInt(Route::getTotalPrice));

        return routes;
    }
}
