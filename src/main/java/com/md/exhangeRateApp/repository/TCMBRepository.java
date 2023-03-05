package com.md.exhangeRateApp.repository;

import com.md.exhangeRateApp.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCMBRepository extends JpaRepository<Currency, Integer> {
}
