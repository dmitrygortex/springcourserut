package org.example.deprecated_repositories;

import org.example.entities.Booking;
import org.example.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


    // неверно сделал все репозитории тк я их наследовал от JPA репозиториев,
    // но удаления вообще нельзя допускать из за того что надо оставлять все сущности для истории,
    // даже если в моей предметной области для каждой из сущностей нужен весь CRUD
    // (тк обучение на данных и тд)


    @Query("SELECT s FROM Studio s " +
            "LEFT JOIN Booking b ON s.id = b.studio.id " +
            "WHERE (b.id IS NULL OR b.endBookingDate <= :startBookingDate OR b.startBookingDate >= :endBookingDate) " +
            "AND (:address IS NULL OR s.address LIKE %:address%) " +
            "AND (:minRentFee IS NULL OR s.rentFee >= :minRentFee) " +
            "AND (:maxRentFee IS NULL OR s.rentFee <= :maxRentFee) " +
            "AND (:equipmentType IS NULL OR EXISTS (SELECT e FROM Equipment e WHERE e.studio.id = s.id AND e.type LIKE %:equipmentType%))")
    List<Studio> findAvailableStudios(
            @Param("startBookingDate") LocalDateTime startBookingDate,
            @Param("endBookingDate") LocalDateTime endBookingDate,
            @Param("address") String address,
            @Param("minRentFee") Integer minRentFee,
            @Param("maxRentFee") Integer maxRentFee,
            @Param("equipmentType") String equipmentType);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM Booking b " +
            "WHERE b.studio.id = :studioId " +
            "AND b.endBookingDate > :startBookingDate " +
            "AND b.startBookingDate < :endBookingDate")
    boolean isStudioBooked(
            @Param("studioId") Integer studioId,
            @Param("startBookingDate") LocalDateTime startBookingDate,
            @Param("endBookingDate") LocalDateTime endBookingDate);


    @Query("SELECT b FROM Booking b WHERE b.client.id = :clientId")
    List<Booking> findBookingsByClientId(@Param("clientId") Integer clientId);

    @Query("SELECT b FROM Booking b WHERE b.id = :bookingId")
    Booking findBookingById(@Param("bookingId") Integer bookingId);

    @Query("SELECT b FROM Booking b WHERE b.studio.id = :studioId")
    List<Booking> findBookingsByStudioId(@Param("studioId") Integer studioId);

}


