package com.dsarena.corp.schoolpay.notificationapi.service.mapper;

import com.dsarena.corp.schoolpay.notificationapi.domain.School;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.SchoolDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link School} and its DTO {@link SchoolDTO}.
 */
@Mapper(componentModel = "spring")
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {}
