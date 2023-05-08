package com.dsarena.corp.schoolpay.notificationapi.service;

import com.dsarena.corp.schoolpay.notificationapi.domain.School;
import com.dsarena.corp.schoolpay.notificationapi.repository.SchoolRepository;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.SchoolDTO;
import com.dsarena.corp.schoolpay.notificationapi.service.mapper.SchoolMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link School}.
 */
@Service
@Transactional
public class SchoolService {

    private final Logger log = LoggerFactory.getLogger(SchoolService.class);

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    /**
     * Save a school.
     *
     * @param schoolDTO the entity to save.
     * @return the persisted entity.
     */
    public SchoolDTO save(SchoolDTO schoolDTO) {
        log.debug("Request to save School : {}", schoolDTO);
        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    /**
     * Update a school.
     *
     * @param schoolDTO the entity to save.
     * @return the persisted entity.
     */
    public SchoolDTO update(SchoolDTO schoolDTO) {
        log.debug("Request to update School : {}", schoolDTO);
        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    /**
     * Partially update a school.
     *
     * @param schoolDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SchoolDTO> partialUpdate(SchoolDTO schoolDTO) {
        log.debug("Request to partially update School : {}", schoolDTO);

        return schoolRepository
            .findById(schoolDTO.getId())
            .map(existingSchool -> {
                schoolMapper.partialUpdate(existingSchool, schoolDTO);

                return existingSchool;
            })
            .map(schoolRepository::save)
            .map(schoolMapper::toDto);
    }

    /**
     * Get all the schools.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SchoolDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Schools");
        return schoolRepository.findAll(pageable).map(schoolMapper::toDto);
    }

    /**
     * Get one school by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SchoolDTO> findOne(Long id) {
        log.debug("Request to get School : {}", id);
        return schoolRepository.findById(id).map(schoolMapper::toDto);
    }

    /**
    //  * Get one school by id.
    //  *
    //  * @param id the id of the entity.
    //  * @return the entity.
    //  */
    // @Transactional(readOnly = true)
    // public Optional<SchoolDTO> findOneBySchoolCode(String schoolCode) {
    //     log.debug("Request to get School : {}", schoolCode);
    //     return schoolRepository.findBySchoolCode(schoolCode).map());
    // }

    /**
     * Delete the school by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete School : {}", id);
        schoolRepository.deleteById(id);
    }
}
