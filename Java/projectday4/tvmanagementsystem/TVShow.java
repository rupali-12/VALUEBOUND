
public class TVShow {
    private String name;
    private String category;
    private double rating;

    public TVShow(String name, String category, double rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "name='" + name + '\'' +
                ", catetgory='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }
}
