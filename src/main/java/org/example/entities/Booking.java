package entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Booking")
public class Booking extends BaseEntity{

    //private int bookingID;
    private RentStatus status;
    private Date startBookingDate;
    private Date endBookingDate;
    private Studio studio;
    private Client client;
    private Staff staff;


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "bookingID")
//    public int getBookingID(){
//        return bookingID;
//    }

    @Column(name = "status")
    public RentStatus getStatus(){
        return status;
    }

    @Column(name = "startBookingDate")
    public Date getStartBookingDate(){
        return startBookingDate;
    }

    @Column(name = "endBookingDate")
    public Date getEndBookingDate(){
        return endBookingDate;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "studioId", referencedColumnName = "id")
    public Studio getStudio() {
        return studio;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", referencedColumnName = "id")
    public Staff getStaff() {
        return staff;
    }

//    public void setBookingID(int bookingID) {
//        this.bookingID = bookingID;
//    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }

    public void setStartBookingDate(Date startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public void setEndBookingDate(Date endBookingDate) {
        this.endBookingDate = endBookingDate;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
