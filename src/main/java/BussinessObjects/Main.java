package BussinessObjects;

import DAOs.MovieDAO;
import DAOs.BookingDAO;
import DAOs.CustomerDAO;
import DTOs.Movie;
import DTOs.Customer;
import DTOs.Booking;
import DTOs.JsonConverter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDAO movieDao = new MovieDAO();
        CustomerDAO customerDao = new CustomerDAO();
        BookingDAO bookingDao = new BookingDAO();
        JsonConverter jsonConverter = new JsonConverter();

        while (true) {
            System.out.println("\n_____________________________________MENU ____________________________________________________");
            System.out.println("1. View All Movies");
            System.out.println("2. View All Customers");
            System.out.println("3. View All Bookings");
            System.out.println("4. Insert a New Movie");
            System.out.println("5. Update a Movie");
            System.out.println("6. Delete a Movie");
            System.out.println("7. Filter Movies by Rating");
            System.out.println("8. Json entities");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n________________________ALL OF THE MOVIES ______________________");
                    List<Movie> movies = movieDao.getAllMovies();
                    for (Movie movie : movies) {
                        System.out.println(movie.getId() + " - " + movie.getTitle() + " (" + movie.getRating() + "/10, " + movie.getDuration() + " min)");
                    }
                    break;

                case 2:
                    System.out.println("\n______________________ALL OF THE CUSTOMERS_________________");
                    List<Customer> customers = customerDao.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer.getCustomer_id() + " - " + customer.getUserName() + " (Balance: $" + customer.getWalletBalance() + ", Tickets: " + customer.getTicketsPurchased() + ")");
                    }
                    break;

                case 3:
                    System.out.println("\n______________________ALL BOOKING_______________________________");
                    List<Booking> bookings = bookingDao.getAllBookings();
                    for (Booking booking : bookings) {
                        System.out.println(booking.getBookingID() + " - " + booking.getStatus() + " (Price: $" + booking.getTicket_price() + ", Seat: " + booking.getSeat_number() + ")");
                    }
                    break;

                case 4:
                    System.out.println("\n_________________ADD MOVIE ______________");
                    System.out.println("Enter details for the new movie:");
                    int newId;
                    boolean idExists;
                    do {
                        System.out.print("ID: ");
                        newId = sc.nextInt();
                        idExists = movieDao.getMovieById(newId) != null;
                        if (idExists) {
                            System.out.println("ID already exists. enter a new one .");
                        }
                    } while (idExists);
                    sc.nextLine();
                    System.out.print("Title: ");
                    String newTitle = sc.nextLine();

                    float newRating = 0;
                    boolean validRating = false;
                    while (!validRating) {
                        System.out.print("Rating: ");
                        if (sc.hasNextFloat()) {
                            newRating = sc.nextFloat();
                            validRating = true;
                        } else {
                            System.out.println("InvaliD. Please enter a valid number for the rating.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Duration (in minutes): ");
                    int newDuration = sc.nextInt();

                    Movie newMovie = new Movie(newId, newTitle, newRating, newDuration);
                    movieDao.insertMovie(newMovie);
                    System.out.println("New movie '" + newMovie.getTitle() + "' inserted successfully.");
                    break;

                case 5:
                    System.out.println("\n_____________________UPDATE MOVIE________________________");
                    System.out.println("Enter the ID of the movie you want to update:");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new details for the movie:");
                    System.out.print("Title: ");
                    String updatedTitle = sc.nextLine();

                    float updatedRating = 0;
                    validRating = false;
                    while (!validRating) {
                        System.out.print("Rating: ");
                        if (sc.hasNextFloat()) {
                            updatedRating = sc.nextFloat();
                            validRating = true;
                        } else {
                            System.out.println("Invalid input. Please enter a valid number for the rating.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Duration (in minutes): ");
                    int updatedDuration = sc.nextInt();

                    Movie updatedMovie = new Movie(updateId, updatedTitle, updatedRating, updatedDuration);
                    movieDao.updateMovieById(updateId, updatedMovie);
                    System.out.println("Movie with ID " + updateId + " updated successfully.");
                    break;

                case 6:
                    System.out.println("\n_________________DELETE MOVIE _________________");
                    System.out.println("Please enter the ID of the movie you want to delete:");
                    int deleteId = sc.nextInt();
                    Movie deleteMovie = movieDao.deleteByKey(deleteId);
                    if (deleteMovie == null) {
                        System.out.println("No movie found with that ID.");
                    } else {
                        System.out.println("Movie '" + deleteMovie.getTitle() + "' with ID " + deleteMovie.getId() + " was deleted successfully.");
                    }
                    break;

                case 7:
                    System.out.println("\n___________________________ FILTER MOVIES BY RATING__________________________");
                    System.out.println("Enter the minimum rating to filter movies:");

                    float minRating = 0;
                    validRating = false;
                    while (!validRating) {
                        if (sc.hasNextFloat()) {
                            minRating = sc.nextFloat();
                            validRating = true;
                        } else {
                            System.out.println("Invalid, Please enter a new number for the minimum rating.");
                            sc.nextLine();
                        }
                    }

                    List<Movie> filteredMovies = movieDao.filterMoviesByRating(minRating);
                    if (filteredMovies.isEmpty()) {
                        System.out.println("No movies found with a rating of " + minRating + " or higher.");
                    } else {
                        System.out.println("Movies with a rating of " + minRating + " or higher:");
                        for (Movie movie : filteredMovies) {
                            System.out.println(movie.getId() + " - " + movie.getTitle() + " (" + movie.getRating() + "/10, " + movie.getDuration() + " min)");
                        }
                    }
                    break;

                case 8:
                    jsonConverter.MoviesConverter( movies = movieDao.getAllMovies());
                    jsonConverter.BookingConverter(bookings = bookingDao.getAllBookings());
                    jsonConverter.CustomerConverter(customers = customerDao.getAllCustomers());
                    break;
                case 9:
                    System.out.println(" Goodbye ;)");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid enter a number between 1 and 9 .");
                    break;
            }
        }

//        //Feature 6
//        System.out.println("\n****FILTERED BOOKINGS (Status: Confirmed)****");
//        List<Booking> confirmedBookings = bookingDao.findBookingsApplyFilter("Confirmed");
//        for (Booking booking : confirmedBookings) {
//            System.out.println(booking.getBookingID() + " - " + booking.getStatus() + " (Price: $" + booking.getTicket_price() + ", Seat: " + booking.getSeat_number() + ")");
//        }
//    }
}
}