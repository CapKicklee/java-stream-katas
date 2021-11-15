package hiking;

public class HikingTrail {

    private String id;
    private String type;
    private int difficulty;
    private String category;
    private int time;
    private double length;
    private String town;
    private boolean pedestrian;
    private boolean equestrian;
    private boolean crossCountry;

    public HikingTrail(String id, String type, int difficulty, String category,
                       int time, double length, String town, boolean pedestrian,
                       boolean equestrian, boolean crossCountry) {
        this.id = id;
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.time = time;
        this.length = length;
        this.town = town;
        this.pedestrian = pedestrian;
        this.equestrian = equestrian;
        this.crossCountry = crossCountry;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public int getTime() {
        return time;
    }

    public double getLength() {
        return length;
    }

    public String getTown() {
        return town;
    }

    public boolean isPedestrian() {
        return pedestrian;
    }

    public boolean isEquestrian() {
        return equestrian;
    }

    public boolean isCrossCountry() {
        return crossCountry;
    }

    @Override
    public String toString() {
        return "HikingTrail{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' +
                ", time='" + time + '\'' +
                ", length='" + length + '\'' +
                ", town='" + town + '\'' +
                ", pedestrian=" + pedestrian +
                ", equestrian=" + equestrian +
                ", crossCountry=" + crossCountry +
                '}';
    }
}