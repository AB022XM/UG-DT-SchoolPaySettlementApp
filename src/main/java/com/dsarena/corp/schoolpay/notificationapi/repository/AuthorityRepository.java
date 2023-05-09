package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
