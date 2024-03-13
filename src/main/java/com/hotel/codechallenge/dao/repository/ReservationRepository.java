package com.hotel.codechallenge.dao.repository;

import com.hotel.codechallenge.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


}
