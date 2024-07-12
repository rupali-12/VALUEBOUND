import java.util.ArrayList;

public class TVManagementSystem {
    private ArrayList<TVShow> shows;

    TVManagementSystem() {
        shows = new ArrayList<>();
    }

    public void addShow(TVShow show) {
        shows.add(show);
        System.out.println(show.getName() + " has been added.");
    }

    public void removeShow(String name) {
        boolean found = false;
        for (TVShow show : shows) {
            if (show.getName().equalsIgnoreCase(name)) {
                shows.remove(show);
                System.out.println(show.getName() + " has been removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(name + " not found");
        }
    }

    public void displayAllShows() {
        if (shows.isEmpty()) {
            System.out.println("No Shows Available");
            return;
        }
        for (TVShow show : shows) {
            System.out.println(show);
        }
    }
}