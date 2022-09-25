package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findById(long id);
    Shop findByShopDescription(String shopDescription);
    Shop getById(long id);
}
