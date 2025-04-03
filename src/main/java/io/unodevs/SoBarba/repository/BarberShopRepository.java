package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.BarberShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberShopRepository extends JpaRepository<BarberShop, Long> {
}
