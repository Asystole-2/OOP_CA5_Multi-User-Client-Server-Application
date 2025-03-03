CREATE DATABASE IF NOT EXISTS MovieTicketBooking;
USE MovieTicketBooking;

CREATE TABLE IF NOT EXISTS Movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating FLOAT NOT NULL,
    duration INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    wallet_balance FLOAT NOT NULL,
    tickets_purchased INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Booking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    ticket_price FLOAT NOT NULL,
    seat_number INT NOT NULL
);

INSERT INTO Movie (title, rating, duration) VALUES
('Inception', 8.8, 148),
('The Dark Knight', 9.0, 152),
('Interstellar', 8.6, 169),
('Titanic', 7.8, 195),
('Avatar', 7.9, 162),
('The Shawshank Redemption', 9.3, 142),
('The Godfather', 9.2, 175),
('The Matrix', 8.7, 136),
('Gladiator', 8.5, 155),
('Jurassic Park', 8.1, 127),
('Avengers: Endgame', 8.4, 181),
('Spider-Man: No Way Home', 8.2, 148),
('The Lion King', 8.5, 118),
('Frozen', 7.4, 102),
('Finding Nemo', 8.1, 100),
('Toy Story', 8.3, 81),
('Coco', 8.4, 105),
('The Incredibles', 8.0, 115),
('Shrek', 7.9, 90),
('Up', 8.2, 96);

-- Insert data into the User table
INSERT INTO Customer (username, wallet_balance, tickets_purchased) VALUES
('user1', 50.00, 2),
('user2', 100.00, 5),
('user3', 75.50, 3),
('user4', 30.00, 1),
('user5', 200.00, 8),
('user6', 120.75, 4),
('user7', 80.20, 2),
('user8', 65.30, 3),
('user9', 150.00, 7),
('user10', 90.45, 4),
('user11', 40.00, 2),
('user12', 220.00, 9),
('user13', 55.60, 3),
('user14', 130.80, 6),
('user15', 70.00, 3),
('user16', 95.50, 4),
('user17', 110.00, 5),
('user18', 85.75, 3),
('user19', 105.90, 5),
('user20', 140.00, 6);

INSERT INTO Booking (status, ticket_price, seat_number) VALUES
('Confirmed', 12.50, 1),
('Pending', 15.00, 2),
('Cancelled', 10.00, 3),
('Confirmed', 8.50, 4),
('Confirmed', 14.00, 5),
('Pending', 11.50, 6),
('Confirmed', 9.75, 7),
('Cancelled', 13.25, 8),
('Confirmed', 16.00, 9),
('Confirmed', 10.50, 10),
('Pending', 18.00, 11),
('Confirmed', 11.75, 12),
('Cancelled', 7.50, 13),
('Confirmed', 19.00, 14),
('Confirmed', 20.00, 15),
('Pending', 22.50, 16),
('Cancelled', 12.00, 17),
('Confirmed', 9.25, 18),
('Confirmed', 14.75, 19),
('Pending', 17.50, 20);
