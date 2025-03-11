package DTOs;

import Exceptions.DaoException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class JsonConverter {

    //Displays List of Movies
    public void MoviesConverter(List<Movie> movies) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(movies);
        jsonObject.put("movies", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("movies");
        MoveListIterator(jsonArray, jsonArray2);
    }

    //Displays List of Bookings
    public void BookingConverter(List<Booking> bookings) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(bookings);
        jsonObject.put("bookings", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("bookings");
        BookingListIterator(jsonArray2);

    }

    //Displays List of Customers
    public void CustomerConverter(List<Customer> customers) throws DaoException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(customers);
        jsonObject.put("customers", jsonArray);

        JSONArray jsonArray2 = jsonObject.optJSONArray("customers");
        CustomerListIterator(jsonArray2, jsonArray2);
    }

    // Displays all the entities
    public void entitiesConverter(List<Movie> movies, List<Booking> bookings, List<Customer> customers) throws DaoException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(movies);
        JSONArray jsonArray2 = new JSONArray(bookings);
        JSONArray jsonArray3 = new JSONArray(customers);

        jsonObject.put("movies", jsonArray);
        jsonObject.put("bookings", jsonArray2);
        jsonObject.put("customers", jsonArray3);

        MoveListIterator(jsonArray, jsonArray);
        BookingListIterator(jsonArray2);
        CustomerListIterator(jsonArray, jsonArray3);


    }


    //Methods with for loops for going through the Lists of objects(entities):

    private void MoveListIterator(JSONArray jsonArray, JSONArray jsonArray2) {
        System.out.println("\nMovie Json Strings:\n");
        int idWidth = 5;
        int titleWidth = 28;
        int ratingWidth = 10;
        int durationWidth = 10;

        System.out.printf("%-" + idWidth + "s | %-" + titleWidth + "s | %-" + ratingWidth + "s | %-" + durationWidth + "s%n",
                "ID", "Title", "Rating", "Duration");
        System.out.println("=======================================================================");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            float rating = jsonObject.getFloat("rating");
            int duration = jsonObject.getInt("duration");

            System.out.printf("%-" + idWidth + "d | %-" + titleWidth + "s | %-" + ratingWidth + ".1f | %-" + durationWidth + "d%n",
                    id, title, rating, duration);}

    }

    private void BookingListIterator(JSONArray jsonArray2) {
        System.out.println("\nBooking Json Strings:\n");
        int idWidth = 10;
        int statusWidth = 15;
        int priceWidth = 15;
        int seatWidth = 12;

        System.out.printf("%-" + idWidth + "s | %-" + statusWidth + "s | %-" + priceWidth + "s | %-" + seatWidth + "s%n",
                "Booking ID", "Status", "Ticket Price", "Seat Number");
        System.out.println("=======================================================================");

        for (int i = 0; i < jsonArray2.length(); i++) {
            JSONObject jsonObject2 = jsonArray2.getJSONObject(i);
            int id = jsonObject2.getInt("bookingID");
            String status = jsonObject2.getString("status");
            float ticketPrice = jsonObject2.getFloat("ticket_price");
            int seatNumber = jsonObject2.getInt("seat_number");

            System.out.printf("%-" + idWidth + "d | %-" + statusWidth + "s | %" + priceWidth + ".2f | %" + (seatWidth-6) + "d%n",
                    id, status, ticketPrice, seatNumber);
        }
    }

    private void CustomerListIterator(JSONArray jsonArray, JSONArray jsonArray3) {
        System.out.println("\nCustomer Json Strings:\n");
        int idWidth = 12;
        int userNameWidth = 15;
        int balanceWidth = 15;
        int ticketsWidth = 18;

        System.out.printf("%-" + idWidth + "s | %-" + userNameWidth + "s | %-" + balanceWidth + "s | %-" + ticketsWidth + "s%n",
                "Customer ID", "User Name", "Wallet Balance", "Tickets Purchased");
        System.out.println("=======================================================================");

        for (int i = 0; i < jsonArray3.length(); i++) {
            JSONObject jsonObject2 = jsonArray3.getJSONObject(i);
            int id = jsonObject2.getInt("customer_id");
            String userName = jsonObject2.getString("userName");
            float walletBalance = jsonObject2.getFloat("walletBalance");
            int ticketsPurchased = jsonObject2.getInt("ticketsPurchased");

            System.out.printf("%-" + idWidth + "d | %-" + userNameWidth + "s | %" + balanceWidth + ".2f | %" + (ticketsWidth-8) + "d%n",
                    id, userName, walletBalance, ticketsPurchased);
        }
    }


}
