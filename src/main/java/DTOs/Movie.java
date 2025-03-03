package DTOs;

public class Movie {

 private int movie_id;
 private String movieTitle;
 private float rating;
 private int director;

 public Movie() {

 }
 public Movie(int movie_id, String movieTitle, float rating, int director) {
     this.movie_id = movie_id;
     this.movieTitle = movieTitle;
     this.rating = rating;
     this.director = director;
 }
 public Movie(String movieTitle, float rating, int director) {
     this.movieTitle = movieTitle;
     this.rating = rating;
     this.director = director;

 }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movieTitle='" + movieTitle + '\'' +
                ", rating=" + rating +
                ", director=" + director +
                '}';
    }
}
