package pojo;

public class HerOkuResponsePojo {

    private String bookinId;
    private HerOkuPojo booking;

    public String getBookinId() {
        return bookinId;
    }

    public void setBookinId(String bookinId) {
        this.bookinId = bookinId;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo booking) {
        this.booking = booking;
    }

    public HerOkuResponsePojo() {
    }

    public HerOkuResponsePojo(String bookinId, HerOkuPojo booking) {
        this.bookinId = bookinId;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerOkuResponsePojo{" +
                "bookinId='" + bookinId + '\'' +
                ", booking=" + booking +
                '}';
    }
}
