package org.example.demobarbershop.repository;

import org.example.demobarbershop.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Integer> {
}
