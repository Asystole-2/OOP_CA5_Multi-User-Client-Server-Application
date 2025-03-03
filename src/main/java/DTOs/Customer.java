package DTOs;

public class Customer {

    private int customer_id;
    private String userName;
    private Float walletBalance;
    private int ticketsPurchased;

    public Customer() {

    }

    public Customer(int customer_id, String userName, Float walletBalance, int ticketsPurchased) {
        this.customer_id = customer_id;
        this.userName = userName;
        this.walletBalance = walletBalance;
        this.ticketsPurchased = ticketsPurchased;
    }

    public Customer(String userName, Float walletBalance, int ticketsPurchased) {
        this.userName = userName;
        this.walletBalance = walletBalance;
        this.ticketsPurchased = ticketsPurchased;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getTicketsPurchased() {
        return ticketsPurchased;
    }

    public void setTicketsPurchased(int ticketsPurchased) {
        this.ticketsPurchased = ticketsPurchased;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", userName='" + userName + '\'' +
                ", walletBalance=" + walletBalance +
                ", ticketsPurchased=" + ticketsPurchased +
                '}';
    }
}
