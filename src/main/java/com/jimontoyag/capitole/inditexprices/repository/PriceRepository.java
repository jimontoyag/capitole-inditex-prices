package com.jimontoyag.capitole.inditexprices.repository;

import com.jimontoyag.capitole.inditexprices.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query(
      "SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId "
          + "AND :date BETWEEN p.startDate and p.endDate ORDER BY p.priority DESC, p.id DESC LIMIT 1")
  Optional<PriceEntity> findFinalPrice(
      @Param("productId") long productId,
      @Param("brandId") long brandId,
      @Param("date") Instant date);
}
