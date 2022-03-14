package pojo;

public class BookingDatesPojoOr {
     /*"bookingdates": {
                "checkin": "2022-03-01",
                "checkout": "2022-03-11"
    }*/
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookingDatesPojoOr() {
    }

    public BookingDatesPojoOr(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojoOr{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
