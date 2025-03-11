package DTOs;

import Exceptions.DaoException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class JsonConverter {

    public void MoviesConverter(List<Movie> movies) throws DaoException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(movies);
        jsonObject.put("movies", jsonArray);

        String jsonString = jsonObject.toString();
        System.out.println("\nJson String for the Movie entity list:\n" + jsonString);
    }

    public void BookingConverter(List<Booking> bookings) throws DaoException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(bookings);
        jsonObject.put("bookings", jsonArray);

        String jsonString = jsonObject.toString();
        System.out.println("\nJson String for the Booking entity list\n:" + jsonString);
    }

    public void CustomerConverter(List<Customer> customers) throws DaoException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(customers);
        jsonObject.put("customers", jsonArray);

        String jsonString = jsonObject.toString();
        System.out.println("\nJson String for the Customer entity list\n:" + jsonString);

    }

    public void IterateInMovies(List<Movie> movies) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(movies);
        jsonObject.put("movies", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("movies");
        System.out.println("Movie Json Strings:");

        for (int i = 0; i < jsonArray2.length(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            int id = jsonObject2.getInt("id");
            System.out.println("  ID: " + id);
            String title = jsonObject2.getString("title");
            System.out.println("  Title: " + title);
            float rating = jsonObject2.getFloat("rating");
            System.out.println("  Rating: " + rating);
            int duration = jsonObject2.getInt("duration");
            System.out.println("  Duration: " + duration);

        }
    }
}
