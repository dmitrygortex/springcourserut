package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "Booking")
public class Booking extends BaseEntity{

    private RentStatus status;
    private LocalDateTime startBookingDate;
    private LocalDateTime endBookingDate;
    private Studio studio;
    private Client client;
    private Staff staff;

    // Поменять Бд добавить к каждому бронированию несколько услуг ДОБАВИТЬ как услуга многие ко многим

    // Редактирование бронирования (продление) чтобы можно было забронировать больше
    // чем сейчас на другое время но тогда была бы равносильное бронирование.



    // Добавить время бронирования чтобы можно было исключить возможность брони
    // и не оплаты с заменой статуса на RESERVED
    // и пользователь если студия не оплачивалась больше 15 мин
    // смог все равно забронировать пробовать
    // НЕ ДЕЛАТЬ

    //private LocalDateTime updatedAt;

    @Column(name = "status")
    public RentStatus getStatus(){
        return status;
    }

    @Column(name = "startBookingDate")
    public LocalDateTime getStartBookingDate(){
        return startBookingDate;
    }

    @Column(name = "endBookingDate")
    public LocalDateTime getEndBookingDate(){
        return endBookingDate;
    }

    // cascade = CascadeType.ALL
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "id")
    public Studio getStudio() {
        return studio;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    public Staff getStaff() {
        return staff;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }

    public void setStartBookingDate(LocalDateTime startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public void setEndBookingDate(LocalDateTime endBookingDate) {
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
