package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRecordRepository extends JpaRepository<ProductRecord,Long> {

}
