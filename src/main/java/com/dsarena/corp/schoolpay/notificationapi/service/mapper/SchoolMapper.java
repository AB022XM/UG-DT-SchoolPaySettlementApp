package com.dsarena.corp.schoolpay.notificationapi.service.mapper;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.School;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.SchoolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link School} and its DTO {@link SchoolDTO}.
 */
@Mapper(componentModel = "spring")
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {
    @Mapping(source = "schoolCode", target = "schoolCode")
    SchoolDTO toDto(School school);
}
