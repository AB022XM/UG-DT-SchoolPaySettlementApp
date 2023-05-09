package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Partner entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    // Partner findByFreeText2(String freeField2);
}
