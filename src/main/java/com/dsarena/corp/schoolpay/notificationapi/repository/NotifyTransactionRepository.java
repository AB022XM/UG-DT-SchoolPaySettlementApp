package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the NotifyTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotifyTransactionRepository extends JpaRepository<NotifyTransaction, Long> {
    Optional<NotifyTransaction> findByRecordId(Integer recordId);
    // @Query("select n from NotifyTransaction n " +
    //         "where upper(n.proccessingStatus) =" +ProccesingStatus.INITIATED +
    //         "order by n.dateCreated")
    // Iterable<NotifyTransaction> findByProccessingStatus();

    Boolean existsByRecordId(Integer recordId);
}
