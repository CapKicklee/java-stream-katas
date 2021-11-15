package hiking;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HikingStats {

    public static void main(String[] args) {

        Function<String, HikingTrail> lineToHikingTrail =
                line -> {
                    String[] split = line.split(";");
                    String id = split[0].trim();
                    String type = split[2].trim();
                    String difficultyLabel = split[3].trim();
                    int difficulty = 0;
                    switch (difficultyLabel) {
                        case "Facile" -> difficulty = 1;
                        case "Moyen" -> difficulty = 2;
                        case "Difficile" -> difficulty = 3;
                        default -> {
                            break;
                        }
                    }
                    String category = split[4].trim();
                    int time = Integer.parseInt(split[5].trim().split(" minutes")[0]);
                    double length = Double.parseDouble(split[6].trim().split(" km")[0]);
                    String town = split[7].trim();
                    boolean pedestrian = "1".equals(split[10].trim());
                    boolean equestrian = "1".equals(split[11].trim());
                    boolean crossCountry = "1".equals(split[12].trim());

                    return new HikingTrail(id, type, difficulty, category, time, length, town, pedestrian, equestrian, crossCountry);
                };

        // https://data.nantesmetropole.fr/explore/dataset/224400028_itineraires-de-promenade-et-de-randonnee-en-loire-atlantique-pdipr%40loireatlantique
        Path path = Path.of("opendata", "itineraires-de-promenade-et-de-randonnee-en-loire-atlantique-pdipr.csv");
        Set<HikingTrail> trails = null;

        try(Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);) {
            trails = lines.skip(1)
                    .map(lineToHikingTrail)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("# hiking trails = " + trails.size());

        // Regrouper les chemins de randonnée par difficulté
        Map<String, List<HikingTrail>> trailsByDifficulty = null;

        System.out.println("Number of difficulties = " + trailsByDifficulty.size());
        System.out.println("Difficulties = " + trailsByDifficulty.keySet());
        System.out.println("Number of difficult trails = " + trailsByDifficulty.get("Difficile").size());

        // Afficher les statistiques basiques associées à la longueur des chemins de randonnées (nombre, somme, min, max, moyenne)
        System.out.println(trails.stream().mapToDouble(HikingTrail::getLength).summaryStatistics());

        // Compter le nombre de chemins de randonnées par ville
        Map<String, Long> trailsByTown = null;

        System.out.println("# towns = " + trailsByTown.size());

        // Trouver la ville avec le plus de chemins de randonnée
        Map.Entry<String, Long> townWithMostTrails = null;

        System.out.println("Town with most trails = " + townWithMostTrails);

        // Trouver la ville qui a la plus grande de distancee de chemins de randonnée cumulée
        Map<String, Double> trailDistanceByTown = null;

        Map.Entry<String, Double> townWithLongestTrailDistance = null;

        System.out.println("Town with longest trail distance = " + townWithLongestTrailDistance);

        // Calculer la distance moyenne des chemins de randonée faciles
        Double easyTrailsLength = 0.0;
        System.out.println("Combined length of easy hiking trails = " + easyTrailsLength);
    }

}
