//package org.example.deprecated_repositories;
//
//import org.example.entities.Studio;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//@NoRepositoryBean
//public interface StudioRepository extends JpaRepository<Studio, Integer> {
//    @Query("SELECT s FROM Studio s WHERE s.name LIKE %:name%")
//    List<Studio> findStudiosByName(@Param("name") String name);
//
//    @Query("SELECT s FROM Studio s WHERE s.address LIKE %:address%")
//    List<Studio> findStudiosByAddress(@Param("address") String address);
//
//    @Query("SELECT s FROM Studio s WHERE s.rentFee <= :rentFee")
//    List<Studio> findStudiosByRentFee(@Param("rentFee") Integer rentFee);
//
//    @Query("SELECT s FROM Studio s")
//    List<Studio> findAllStudios();
//}
