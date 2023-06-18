package com.utk.apps.main.repository;

import com.utk.apps.main.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    Show findByIdEquals(Long showId);
}
