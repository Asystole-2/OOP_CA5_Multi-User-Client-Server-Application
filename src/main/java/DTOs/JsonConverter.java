package DTOs;

import Exceptions.DaoException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class JsonConverter {

    public void MoviesConverter(List<Movie> movies) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(movies);
        jsonObject.put("movies", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("movies");
        System.out.println("Movie Json Strings:");

        System.out.println("=============================================================");
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
            System.out.println("=============================================================");

        }
    }

    public void BookingConverter(List<Booking> bookings) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(bookings);
        jsonObject.put("bookings", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("bookings");
        System.out.println("Booking Json Strings:");
        System.out.println("=============================================================");

        for (int i = 0; i < jsonArray2.length(); i++) {
            JSONObject jsonObject2 = jsonArray2.getJSONObject(i);
            int id = jsonObject2.getInt("bookingID");
            System.out.println("  ID: " + id);
            String status = jsonObject2.getString("status");
            System.out.println("  Status: " + status);
            float ticketPrice = jsonObject2.getFloat("ticket_price");
            System.out.println("  Ticket Price: " + ticketPrice);
            int seatNumber = jsonObject2.getInt("seat_number");
            System.out.println("  Seat Number: " + seatNumber);
            System.out.println("=============================================================");

        }

    }

    public void CustomerConverter(List<Customer> customers) throws DaoException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(customers);
        jsonObject.put("customers", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("customers");
        System.out.println("Customer Json Strings:");
        System.out.println("=============================================================");
        for (int i = 0; i < jsonArray2.length(); i++) {
            JSONObject jsonObject2 = jsonArray2.getJSONObject(i);
            int id = jsonObject2.getInt("customer_id");
            System.out.println("  ID: " + id);
            String userName = jsonObject2.getString("userName");
            System.out.println("  User Name: " + userName);
            float walletBalance = jsonObject2.getFloat("walletBalance");
            System.out.println("  Wallet Balance: " + walletBalance);
            int ticketsPurchased = jsonObject2.getInt("ticketsPurchased");
            System.out.println("  Tickets Purchased: " + ticketsPurchased);
            System.out.println("=============================================================");
        }
    }


}
