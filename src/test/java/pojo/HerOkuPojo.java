package pojo;

public class HerOkuPojo {
    /*{     "firstname": "Ali",
            "lastname": "Can",
            "totalprice": 500,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2022-03-01",
                "checkout": "2022-03-11"
    }
    }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,

     */
   private  String firstname;
   private String lastname;
   private  int totalPrice;
   private boolean depositPaid;

    public BookingDatesPojoOr getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojoOr bookingdates) {
        this.bookingdates = bookingdates;
    }

    private BookingDatesPojoOr bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public HerOkuPojo() {
    }

    public HerOkuPojo(String firstname, String lastname, int totalPrice, boolean depositPaid, BookingDatesPojoOr bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "HerOkuPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalPrice=" + totalPrice +
                ", depositPaid=" + depositPaid +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
