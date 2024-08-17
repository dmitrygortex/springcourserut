package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.entities.Booking;
import org.example.entities.BaseEntity;
import org.example.entities.Studio;
import org.example.repositories.BaseRepository;
import org.example.repositories.BookingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl extends BaseRepositoryImpl<Booking> implements BookingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    protected BookingRepositoryImpl(Class<Booking> entityClass) {
        super(entityClass);
    }


    @Override
    public List<Studio> findAvailableStudios(LocalDateTime startBookingDate, LocalDateTime endBookingDate, String address, Integer minRentFee, Integer maxRentFee, String equipmentType) {
        String queryStr = "SELECT s FROM Studio s " +
                "LEFT JOIN Booking b ON s.id = b.studio.id " +
                "WHERE (b.id IS NULL OR b.endBookingDate <= :startBookingDate OR b.startBookingDate >= :endBookingDate) " +
                "AND (:address IS NULL OR s.address LIKE :address) " +
                "AND (:minRentFee IS NULL OR s.rentFee >= :minRentFee) " +
                "AND (:maxRentFee IS NULL OR s.rentFee <= :maxRentFee) " +
                "AND (:equipmentType IS NULL OR EXISTS (SELECT e FROM Equipment e WHERE e.studio.id = s.id AND e.type LIKE :equipmentType))";

        TypedQuery<Studio> query = entityManager.createQuery(queryStr, Studio.class);
        query.setParameter("startBookingDate", startBookingDate);
        query.setParameter("endBookingDate", endBookingDate);
        query.setParameter("address", address == null ? null : "%" + address + "%");
        query.setParameter("minRentFee", minRentFee);
        query.setParameter("maxRentFee", maxRentFee);
        query.setParameter("equipmentType", equipmentType == null ? null : "%" + equipmentType + "%");

        return query.getResultList();
    }

    @Override
    public boolean isStudioBooked(Integer studioId, LocalDateTime startBookingDate, LocalDateTime endBookingDate) {
        String queryStr = "SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
                "FROM Booking b " +
                "WHERE b.studio.id = :studioId " +
                "AND b.endBookingDate > :startBookingDate " +
                "AND b.startBookingDate < :endBookingDate";

        TypedQuery<Boolean> query = entityManager.createQuery(queryStr, Boolean.class);
        query.setParameter("studioId", studioId);
        query.setParameter("startBookingDate", startBookingDate);
        query.setParameter("endBookingDate", endBookingDate);

        return query.getSingleResult();
    }

    @Override
    public List<Booking> findBookingsByClientId(Integer clientId) {
        String queryStr = "SELECT b FROM Booking b WHERE b.client.id = :clientId AND b.isDeleted = false";
        TypedQuery<Booking> query = entityManager.createQuery(queryStr, Booking.class);
        query.setParameter("clientId", clientId);
        return query.getResultList();
    }

    @Override
    public List<Booking> findBookingsByStudioId(Integer studioId) {
        String queryStr = "SELECT b FROM Booking b WHERE b.studio.id = :studioId AND b.isDeleted = false";
        TypedQuery<Booking> query = entityManager.createQuery(queryStr, Booking.class);
        query.setParameter("studioId", studioId);
        return query.getResultList();
    }

}
