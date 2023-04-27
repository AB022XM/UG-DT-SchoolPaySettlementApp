package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.NotifyTransaction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the NotifyTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotifyTransactionRepository extends JpaRepository<NotifyTransaction, Long> {}
