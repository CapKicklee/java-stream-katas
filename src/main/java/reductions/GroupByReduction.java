package reductions;

import hiking.HikingTrail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByReduction {

    public static void main(String[] args) {

        List<City> cities = List.of(
                new City("Vannes", "Bretagne", 53438, 32300),
                new City("Strasbourg", "Alsace", 284677, 78260),
                new City("Le Mans", "Pays de la Loire", 143252, 52810),
                new City("Angers", "Pays de la Loire", 154508, 42710),
                new City("Schiltigheim", "Alsace", 33069, 7630),
                new City("Rennes", "Bretagne", 217728, 50390),
                new City("Noirmoutier", "Pays de la Loire", 4614, 19970));

        // Collecter cette liste en une map regroupant les villes par région
        Map<String, List<City>> citiesByRegion = cities.stream()
                .collect(Collectors.groupingBy(City::getState));

        System.out.println("# cities = " + citiesByRegion.size());
        // Afficher les villes de la région Pays de la Loire
        System.out.println("Cities of Pays de la Loire = " + citiesByRegion.get("Pays de la Loire"));

        // Collecter la liste de villes en une map regroupant le nombre de villes par région
        Map<String, Long> numberOfCitiesPerRegion =
                cities.stream()
                        .collect(Collectors.groupingBy(City::getState, Collectors.counting()));
        // Afficher le nombre de villes de la région Bretagne
        System.out.println("# cities in Bretagne = " + numberOfCitiesPerRegion.get("Bretagne"));

        // Déterminer la région possédant le plus de villes
        Map.Entry<String, Long> regionWithMostCities =
                numberOfCitiesPerRegion.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();
        System.out.println(regionWithMostCities);

        // Collecter la population de la région Alsace
        int alsacePopulation = citiesByRegion.get("Alsace").stream()
                .collect(Collectors.summingInt(City::getPopulation));
        System.out.println(alsacePopulation);

        // Collecter la population de chaque région
        Map<String, Integer> populationOfCitiesPerRegion =
                cities.stream()
                        .collect(
                                Collectors.groupingBy(
                                        City::getState,
                                        Collectors.summingInt(City::getPopulation
                                        )
                                )
                        );

        // Afficher la population de la région de votre choix
        System.out.println("Population of Alsace = " + populationOfCitiesPerRegion.get("Alsace"));
        System.out.println("Population of Bretagne = " + populationOfCitiesPerRegion.get("Bretagne"));
        System.out.println("Population of Pays de la Loire = " + populationOfCitiesPerRegion.get("Pays de la Loire"));
    }

}