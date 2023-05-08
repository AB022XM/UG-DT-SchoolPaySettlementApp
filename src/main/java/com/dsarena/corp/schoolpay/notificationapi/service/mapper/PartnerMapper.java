package com.dsarena.corp.schoolpay.notificationapi.service.mapper;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.Partner;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.PartnerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Partner} and its DTO {@link PartnerDTO}.
 */
@Mapper(componentModel = "spring")
public interface PartnerMapper extends EntityMapper<PartnerDTO, Partner> {}
