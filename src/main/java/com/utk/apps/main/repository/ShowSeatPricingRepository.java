package com.utk.apps.main.repository;

import com.utk.apps.main.entity.Show;
import com.utk.apps.main.entity.ShowSeatPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatPricingRepository extends JpaRepository<ShowSeatPricing, Long> {

    List<ShowSeatPricing> findByShowEquals(Show show);
}
