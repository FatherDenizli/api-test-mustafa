package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)

//https://json2csharp.com/code-converters/json-to-pojo

public class BookingDatesPojo {

    /*1)Create private variables for all keys
    2) Create constructors with all kesy and without any key
    3) Create public getter and getters methods
    4) Create toString() method*/

    private String checkin;
    private String checkout;

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

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

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
//    public String firstname;
//    public String lastname;
//    public int totalprice;
//    public boolean depositpaid;
//    public Bookingdates bookingdates;
//    public String additionalneeds;