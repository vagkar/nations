package com.qualco.nations.dao;

import com.qualco.nations.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Region, Integer> {
}
