package org.example;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoRepository extends JpaRepository<PhotoMrt, String> {
}
