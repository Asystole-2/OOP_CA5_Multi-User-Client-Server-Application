package DTOs;

public class Movie {
    private int id;
    private String title;
    private float rating;
    private int duration;

    public Movie() {}

    public Movie(int id, String title, float rating, int duration) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }


    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + id +
                ", movieTitle='" + title + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }
}





