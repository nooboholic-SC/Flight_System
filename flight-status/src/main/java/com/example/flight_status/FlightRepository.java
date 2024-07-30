package com.example.flight_status;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Custom queries can be defined here if needed
}
