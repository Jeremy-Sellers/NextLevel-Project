package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Barber;
import com.personal.nextlevel.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Override
    Optional<Photo> findById(Long id);
    List<Photo> findAllByBarber(Barber barber);

    Optional<Photo> findByPhotoName(String photoName);
}
