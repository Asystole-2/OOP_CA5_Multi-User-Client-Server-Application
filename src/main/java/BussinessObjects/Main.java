package BussinessObjects;

import DAOs.MovieDAO;
import DAOs.BookingDAO;
import DAOs.CustomerDAO;
import DTOs.Movie;
import DTOs.Customer;
import DTOs.Booking;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        System.out.println("*****Delete*****");
        System.out.println("Please enter id for the element you want to delete");
        int id = sc.nextInt();
        Movie deleteMovie = movieDao.deleteByKey(id);
        if(deleteMovie == null){
            System.out.println("No Movie's found with that ID");
        }
        else{
            System.out.println("Movie " + deleteMovie.getTitle()+ " with the ID of "+ deleteMovie.getId()+ "was successfull");
        }
    }
}
