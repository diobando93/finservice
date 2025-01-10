package com.hackathon.finservice.user.repository;

import java.util.Optional;
import java.util.UUID;
import com.hackathon.finservice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmail(String email);

}
