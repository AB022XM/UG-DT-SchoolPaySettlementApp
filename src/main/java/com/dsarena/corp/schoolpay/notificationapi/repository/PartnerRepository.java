package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.Partner;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Partner entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {}
