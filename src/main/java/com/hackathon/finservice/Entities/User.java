package com.hackathon.finservice.Entities;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer       id;

  @Column(nullable = false, length = 128)
  private String        name;

  @Column(nullable = false, unique = true, length = 128)
  private String        email;

  @Column(nullable = false, length = 128)
  private String        password;

  @Column(nullable = false)
  private String        accountNumber;

  @Column(nullable = false)
  private String        accountType = "Main";

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @PrePersist
  private void generateAccountNumber() {
    if (accountNumber == null) {
      accountNumber = UUID.randomUUID().toString();
    }
  }

}
