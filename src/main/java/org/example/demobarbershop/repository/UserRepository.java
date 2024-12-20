package org.example.demobarbershop.repository;

import org.example.demobarbershop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
