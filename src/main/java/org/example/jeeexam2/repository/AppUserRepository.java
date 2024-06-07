package org.example.jeeexam2.repository;

import org.example.jeeexam2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Override
    Optional<AppUser> findById(Long aLong);

    Optional<AppUser> findByUsername(String username);
}