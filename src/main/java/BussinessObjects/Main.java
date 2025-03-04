package BussinessObjects;

import DAOs.MovieDAO;
import DAOs.BookingDAO;
import DAOs.CustomerDAO;
import DTOs.Movie;
import DTOs.Customer;
import DTOs.Booking;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MovieDAO movieDao = new MovieDAO();
        CustomerDAO customerDao = new CustomerDAO();
        BookingDAO bookingDao = new BookingDAO();


        System.out.println("\n****MOVIES****");
        List<Movie> movies = movieDao.getAllMovies();
        for (Movie movie : movies) {
            System.out.println(movie.getId() + " - " + movie.getTitle() + " (" + movie.getRating() + "/10, " + movie.getDuration() + " min)");
        }


        System.out.println("\n****CUSTOMERS****");
        List<Customer> customers = customerDao.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.getCustomer_id() + " - " + customer.getUserName() + " (Balance: $" + customer.getWalletBalance() + ", Tickets: " + customer.getTicketsPurchased() + ")");
        }


        System.out.println("\n****BOOKING****");
        List<Booking> bookings = bookingDao.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingID() + " - " + booking.getStatus() + " (Price: $" + booking.getTicket_price() + ", Seat: " + booking.getSeat_number() + ")");
        }
    }
}
