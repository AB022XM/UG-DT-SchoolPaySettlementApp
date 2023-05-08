package com.dsarena.corp.schoolpay.notificationapi.repository;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the NotifyTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotifyTransactionRepository extends JpaRepository<NotifyTransaction, Long> {
    Optional<NotifyTransaction> findByRecordId(Integer recordId);

    Optional<NotifyTransaction> findByProcessingStatus(ProccesingStatus proccesingStatus);

    @Query("select n from NotifyTransaction n " +
            "where upper(n.proccessingStatus) = upper(:proccessingStatus) " +
            "order by n.dateCreated")
    Iterable<NotifyTransaction> findByProccessingStatus(@Param("proccessingStatus") ProccesingStatus proccessingStatus);



}
