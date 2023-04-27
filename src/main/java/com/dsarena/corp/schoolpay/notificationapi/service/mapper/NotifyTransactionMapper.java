package com.dsarena.corp.schoolpay.notificationapi.service.mapper;

import com.dsarena.corp.schoolpay.notificationapi.domain.NotifyTransaction;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.NotifyTransactionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link NotifyTransaction} and its DTO {@link NotifyTransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface NotifyTransactionMapper extends EntityMapper<NotifyTransactionDTO, NotifyTransaction> {}
