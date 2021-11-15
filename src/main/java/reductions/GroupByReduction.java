package reductions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Map<String, List<City>> citiesByRegion;

        System.out.println("# cities = " + citiesByRegion.size());
        // Afficher les villes de la région Pays de la Loire


        // Collecter la liste de villes en une map regroupant le nombre de villes par région
        Map<String, Long> numberOfCitiesPerRegion;
        // Afficher le nombre de villes de la région Bretagne


        // Déterminer la région possédant le plus de villes
        Map.Entry<String, Long> regionWithMostCities;
        System.out.println(regionWithMostCities);

        // Collecter la population de la région Alsace
        int alsacePopulation;
        System.out.println(alsacePopulation);

        // Collecter la population de chaque région
        Map<String, Long> populationOfCitiesPerRegion;

        // Afficher la population de la région de votre choix

    }

}
