package com.dsarena.corp.schoolpay.notificationapi.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.dsarena.corp.schoolpay.notificationapi.IntegrationTest;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.Partner;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.DELFLAG;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.RecordStatus;
import com.dsarena.corp.schoolpay.notificationapi.repository.PartnerRepository;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.PartnerDTO;
import com.dsarena.corp.schoolpay.notificationapi.service.mapper.PartnerMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link PartnerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PartnerResourceIT {

    private static final UUID DEFAULT_PARTNER_ID = UUID.randomUUID();
    private static final UUID UPDATED_PARTNER_ID = UUID.randomUUID();

    private static final Integer DEFAULT_PARTNER_CODE = 1;
    private static final Integer UPDATED_PARTNER_CODE = 2;

    private static final Integer DEFAULT_PARTNER_SHORTCODE = 1;
    private static final Integer UPDATED_PARTNER_SHORTCODE = 2;

    private static final String DEFAULT_PHONENUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONENUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_PARTNER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARTNER_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_REGISTRATIONDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_REGISTRATIONDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Boolean DEFAULT_IS_ABSA_PARTNER = false;
    private static final Boolean UPDATED_IS_ABSA_PARTNER = true;

    private static final RecordStatus DEFAULT_STATUS = RecordStatus.ACTIVE;
    private static final RecordStatus UPDATED_STATUS = RecordStatus.INACTIVE;

    private static final String DEFAULT_FREE_FIELD_1 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_1 = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_FIELD_2 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_FIELD_3 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_3 = "BBBBBBBBBB";

    private static final Boolean DEFAULT_PROVIDE_DEBIT_ACCOUNT = false;
    private static final Boolean UPDATED_PROVIDE_DEBIT_ACCOUNT = true;

    private static final Boolean DEFAULT_PROVIDE_CREDIT_ACCOUNT = false;
    private static final Boolean UPDATED_PROVIDE_CREDIT_ACCOUNT = true;

    private static final DELFLAG DEFAULT_IS_DELETED = DELFLAG.True;
    private static final DELFLAG UPDATED_IS_DELETED = DELFLAG.False;

    private static final String ENTITY_API_URL = "/api/partners";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private PartnerMapper partnerMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPartnerMockMvc;

    private Partner partner;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Partner createEntity(EntityManager em) {
        Partner partner = new Partner()
            .partnerId(DEFAULT_PARTNER_ID)
            .partnerCode(DEFAULT_PARTNER_CODE)
            .partnerShortcode(DEFAULT_PARTNER_SHORTCODE)
            .phonenumber(DEFAULT_PHONENUMBER)
            .address(DEFAULT_ADDRESS)
            .partnerName(DEFAULT_PARTNER_NAME)
            .registrationdate(DEFAULT_REGISTRATIONDATE)
            .isAbsaPartner(DEFAULT_IS_ABSA_PARTNER)
            .status(DEFAULT_STATUS)
            .freeField1(DEFAULT_FREE_FIELD_1)
            .freeField2(DEFAULT_FREE_FIELD_2)
            .freeField3(DEFAULT_FREE_FIELD_3)
            .provideDebitAccount(DEFAULT_PROVIDE_DEBIT_ACCOUNT)
            .provideCreditAccount(DEFAULT_PROVIDE_CREDIT_ACCOUNT)
            .isDeleted(DEFAULT_IS_DELETED);
        return partner;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Partner createUpdatedEntity(EntityManager em) {
        Partner partner = new Partner()
            .partnerId(UPDATED_PARTNER_ID)
            .partnerCode(UPDATED_PARTNER_CODE)
            .partnerShortcode(UPDATED_PARTNER_SHORTCODE)
            .phonenumber(UPDATED_PHONENUMBER)
            .address(UPDATED_ADDRESS)
            .partnerName(UPDATED_PARTNER_NAME)
            .registrationdate(UPDATED_REGISTRATIONDATE)
            .isAbsaPartner(UPDATED_IS_ABSA_PARTNER)
            .status(UPDATED_STATUS)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .provideDebitAccount(UPDATED_PROVIDE_DEBIT_ACCOUNT)
            .provideCreditAccount(UPDATED_PROVIDE_CREDIT_ACCOUNT)
            .isDeleted(UPDATED_IS_DELETED);
        return partner;
    }

    @BeforeEach
    public void initTest() {
        partner = createEntity(em);
    }

    @Test
    @Transactional
    void createPartner() throws Exception {
        int databaseSizeBeforeCreate = partnerRepository.findAll().size();
        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);
        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isCreated());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeCreate + 1);
        Partner testPartner = partnerList.get(partnerList.size() - 1);
        assertThat(testPartner.getPartnerId()).isEqualTo(DEFAULT_PARTNER_ID);
        assertThat(testPartner.getPartnerCode()).isEqualTo(DEFAULT_PARTNER_CODE);
        assertThat(testPartner.getPartnerShortcode()).isEqualTo(DEFAULT_PARTNER_SHORTCODE);
        assertThat(testPartner.getPhonenumber()).isEqualTo(DEFAULT_PHONENUMBER);
        assertThat(testPartner.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testPartner.getPartnerName()).isEqualTo(DEFAULT_PARTNER_NAME);
        assertThat(testPartner.getRegistrationdate()).isEqualTo(DEFAULT_REGISTRATIONDATE);
        assertThat(testPartner.getIsAbsaPartner()).isEqualTo(DEFAULT_IS_ABSA_PARTNER);
        assertThat(testPartner.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testPartner.getFreeField1()).isEqualTo(DEFAULT_FREE_FIELD_1);
        assertThat(testPartner.getFreeField2()).isEqualTo(DEFAULT_FREE_FIELD_2);
        assertThat(testPartner.getFreeField3()).isEqualTo(DEFAULT_FREE_FIELD_3);
        assertThat(testPartner.getProvideDebitAccount()).isEqualTo(DEFAULT_PROVIDE_DEBIT_ACCOUNT);
        assertThat(testPartner.getProvideCreditAccount()).isEqualTo(DEFAULT_PROVIDE_CREDIT_ACCOUNT);
        assertThat(testPartner.getIsDeleted()).isEqualTo(DEFAULT_IS_DELETED);
    }

    @Test
    @Transactional
    void createPartnerWithExistingId() throws Exception {
        // Create the Partner with an existing ID
        partner.setId(1L);
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        int databaseSizeBeforeCreate = partnerRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPartnerIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = partnerRepository.findAll().size();
        // set the field null
        partner.setPartnerId(null);

        // Create the Partner, which fails.
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPartnerCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = partnerRepository.findAll().size();
        // set the field null
        partner.setPartnerCode(null);

        // Create the Partner, which fails.
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPartnerNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = partnerRepository.findAll().size();
        // set the field null
        partner.setPartnerName(null);

        // Create the Partner, which fails.
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = partnerRepository.findAll().size();
        // set the field null
        partner.setStatus(null);

        // Create the Partner, which fails.
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsDeletedIsRequired() throws Exception {
        int databaseSizeBeforeTest = partnerRepository.findAll().size();
        // set the field null
        partner.setIsDeleted(null);

        // Create the Partner, which fails.
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        restPartnerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isBadRequest());

        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPartners() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        // Get all the partnerList
        restPartnerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(partner.getId().intValue())))
            .andExpect(jsonPath("$.[*].partnerId").value(hasItem(DEFAULT_PARTNER_ID.toString())))
            .andExpect(jsonPath("$.[*].partnerCode").value(hasItem(DEFAULT_PARTNER_CODE)))
            .andExpect(jsonPath("$.[*].partnerShortcode").value(hasItem(DEFAULT_PARTNER_SHORTCODE)))
            .andExpect(jsonPath("$.[*].phonenumber").value(hasItem(DEFAULT_PHONENUMBER)))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS)))
            .andExpect(jsonPath("$.[*].partnerName").value(hasItem(DEFAULT_PARTNER_NAME)))
            .andExpect(jsonPath("$.[*].registrationdate").value(hasItem(DEFAULT_REGISTRATIONDATE.toString())))
            .andExpect(jsonPath("$.[*].isAbsaPartner").value(hasItem(DEFAULT_IS_ABSA_PARTNER.booleanValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].freeField1").value(hasItem(DEFAULT_FREE_FIELD_1)))
            .andExpect(jsonPath("$.[*].freeField2").value(hasItem(DEFAULT_FREE_FIELD_2)))
            .andExpect(jsonPath("$.[*].freeField3").value(hasItem(DEFAULT_FREE_FIELD_3)))
            .andExpect(jsonPath("$.[*].provideDebitAccount").value(hasItem(DEFAULT_PROVIDE_DEBIT_ACCOUNT.booleanValue())))
            .andExpect(jsonPath("$.[*].provideCreditAccount").value(hasItem(DEFAULT_PROVIDE_CREDIT_ACCOUNT.booleanValue())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED.toString())));
    }

    @Test
    @Transactional
    void getPartner() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        // Get the partner
        restPartnerMockMvc
            .perform(get(ENTITY_API_URL_ID, partner.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(partner.getId().intValue()))
            .andExpect(jsonPath("$.partnerId").value(DEFAULT_PARTNER_ID.toString()))
            .andExpect(jsonPath("$.partnerCode").value(DEFAULT_PARTNER_CODE))
            .andExpect(jsonPath("$.partnerShortcode").value(DEFAULT_PARTNER_SHORTCODE))
            .andExpect(jsonPath("$.phonenumber").value(DEFAULT_PHONENUMBER))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS))
            .andExpect(jsonPath("$.partnerName").value(DEFAULT_PARTNER_NAME))
            .andExpect(jsonPath("$.registrationdate").value(DEFAULT_REGISTRATIONDATE.toString()))
            .andExpect(jsonPath("$.isAbsaPartner").value(DEFAULT_IS_ABSA_PARTNER.booleanValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.freeField1").value(DEFAULT_FREE_FIELD_1))
            .andExpect(jsonPath("$.freeField2").value(DEFAULT_FREE_FIELD_2))
            .andExpect(jsonPath("$.freeField3").value(DEFAULT_FREE_FIELD_3))
            .andExpect(jsonPath("$.provideDebitAccount").value(DEFAULT_PROVIDE_DEBIT_ACCOUNT.booleanValue()))
            .andExpect(jsonPath("$.provideCreditAccount").value(DEFAULT_PROVIDE_CREDIT_ACCOUNT.booleanValue()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED.toString()));
    }

    @Test
    @Transactional
    void getNonExistingPartner() throws Exception {
        // Get the partner
        restPartnerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPartner() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();

        // Update the partner
        Partner updatedPartner = partnerRepository.findById(partner.getId()).get();
        // Disconnect from session so that the updates on updatedPartner are not directly saved in db
        em.detach(updatedPartner);
        updatedPartner
            .partnerId(UPDATED_PARTNER_ID)
            .partnerCode(UPDATED_PARTNER_CODE)
            .partnerShortcode(UPDATED_PARTNER_SHORTCODE)
            .phonenumber(UPDATED_PHONENUMBER)
            .address(UPDATED_ADDRESS)
            .partnerName(UPDATED_PARTNER_NAME)
            .registrationdate(UPDATED_REGISTRATIONDATE)
            .isAbsaPartner(UPDATED_IS_ABSA_PARTNER)
            .status(UPDATED_STATUS)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .provideDebitAccount(UPDATED_PROVIDE_DEBIT_ACCOUNT)
            .provideCreditAccount(UPDATED_PROVIDE_CREDIT_ACCOUNT)
            .isDeleted(UPDATED_IS_DELETED);
        PartnerDTO partnerDTO = partnerMapper.toDto(updatedPartner);

        restPartnerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, partnerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isOk());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
        Partner testPartner = partnerList.get(partnerList.size() - 1);
        assertThat(testPartner.getPartnerId()).isEqualTo(UPDATED_PARTNER_ID);
        assertThat(testPartner.getPartnerCode()).isEqualTo(UPDATED_PARTNER_CODE);
        assertThat(testPartner.getPartnerShortcode()).isEqualTo(UPDATED_PARTNER_SHORTCODE);
        assertThat(testPartner.getPhonenumber()).isEqualTo(UPDATED_PHONENUMBER);
        assertThat(testPartner.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testPartner.getPartnerName()).isEqualTo(UPDATED_PARTNER_NAME);
        assertThat(testPartner.getRegistrationdate()).isEqualTo(UPDATED_REGISTRATIONDATE);
        assertThat(testPartner.getIsAbsaPartner()).isEqualTo(UPDATED_IS_ABSA_PARTNER);
        assertThat(testPartner.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testPartner.getFreeField1()).isEqualTo(UPDATED_FREE_FIELD_1);
        assertThat(testPartner.getFreeField2()).isEqualTo(UPDATED_FREE_FIELD_2);
        assertThat(testPartner.getFreeField3()).isEqualTo(UPDATED_FREE_FIELD_3);
        assertThat(testPartner.getProvideDebitAccount()).isEqualTo(UPDATED_PROVIDE_DEBIT_ACCOUNT);
        assertThat(testPartner.getProvideCreditAccount()).isEqualTo(UPDATED_PROVIDE_CREDIT_ACCOUNT);
        assertThat(testPartner.getIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void putNonExistingPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, partnerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(partnerDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePartnerWithPatch() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();

        // Update the partner using partial update
        Partner partialUpdatedPartner = new Partner();
        partialUpdatedPartner.setId(partner.getId());

        partialUpdatedPartner
            .partnerCode(UPDATED_PARTNER_CODE)
            .partnerShortcode(UPDATED_PARTNER_SHORTCODE)
            .phonenumber(UPDATED_PHONENUMBER)
            .registrationdate(UPDATED_REGISTRATIONDATE)
            .status(UPDATED_STATUS)
            .provideDebitAccount(UPDATED_PROVIDE_DEBIT_ACCOUNT)
            .isDeleted(UPDATED_IS_DELETED);

        restPartnerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPartner.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPartner))
            )
            .andExpect(status().isOk());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
        Partner testPartner = partnerList.get(partnerList.size() - 1);
        assertThat(testPartner.getPartnerId()).isEqualTo(DEFAULT_PARTNER_ID);
        assertThat(testPartner.getPartnerCode()).isEqualTo(UPDATED_PARTNER_CODE);
        assertThat(testPartner.getPartnerShortcode()).isEqualTo(UPDATED_PARTNER_SHORTCODE);
        assertThat(testPartner.getPhonenumber()).isEqualTo(UPDATED_PHONENUMBER);
        assertThat(testPartner.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testPartner.getPartnerName()).isEqualTo(DEFAULT_PARTNER_NAME);
        assertThat(testPartner.getRegistrationdate()).isEqualTo(UPDATED_REGISTRATIONDATE);
        assertThat(testPartner.getIsAbsaPartner()).isEqualTo(DEFAULT_IS_ABSA_PARTNER);
        assertThat(testPartner.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testPartner.getFreeField1()).isEqualTo(DEFAULT_FREE_FIELD_1);
        assertThat(testPartner.getFreeField2()).isEqualTo(DEFAULT_FREE_FIELD_2);
        assertThat(testPartner.getFreeField3()).isEqualTo(DEFAULT_FREE_FIELD_3);
        assertThat(testPartner.getProvideDebitAccount()).isEqualTo(UPDATED_PROVIDE_DEBIT_ACCOUNT);
        assertThat(testPartner.getProvideCreditAccount()).isEqualTo(DEFAULT_PROVIDE_CREDIT_ACCOUNT);
        assertThat(testPartner.getIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void fullUpdatePartnerWithPatch() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();

        // Update the partner using partial update
        Partner partialUpdatedPartner = new Partner();
        partialUpdatedPartner.setId(partner.getId());

        partialUpdatedPartner
            .partnerId(UPDATED_PARTNER_ID)
            .partnerCode(UPDATED_PARTNER_CODE)
            .partnerShortcode(UPDATED_PARTNER_SHORTCODE)
            .phonenumber(UPDATED_PHONENUMBER)
            .address(UPDATED_ADDRESS)
            .partnerName(UPDATED_PARTNER_NAME)
            .registrationdate(UPDATED_REGISTRATIONDATE)
            .isAbsaPartner(UPDATED_IS_ABSA_PARTNER)
            .status(UPDATED_STATUS)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .provideDebitAccount(UPDATED_PROVIDE_DEBIT_ACCOUNT)
            .provideCreditAccount(UPDATED_PROVIDE_CREDIT_ACCOUNT)
            .isDeleted(UPDATED_IS_DELETED);

        restPartnerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPartner.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPartner))
            )
            .andExpect(status().isOk());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
        Partner testPartner = partnerList.get(partnerList.size() - 1);
        assertThat(testPartner.getPartnerId()).isEqualTo(UPDATED_PARTNER_ID);
        assertThat(testPartner.getPartnerCode()).isEqualTo(UPDATED_PARTNER_CODE);
        assertThat(testPartner.getPartnerShortcode()).isEqualTo(UPDATED_PARTNER_SHORTCODE);
        assertThat(testPartner.getPhonenumber()).isEqualTo(UPDATED_PHONENUMBER);
        assertThat(testPartner.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testPartner.getPartnerName()).isEqualTo(UPDATED_PARTNER_NAME);
        assertThat(testPartner.getRegistrationdate()).isEqualTo(UPDATED_REGISTRATIONDATE);
        assertThat(testPartner.getIsAbsaPartner()).isEqualTo(UPDATED_IS_ABSA_PARTNER);
        assertThat(testPartner.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testPartner.getFreeField1()).isEqualTo(UPDATED_FREE_FIELD_1);
        assertThat(testPartner.getFreeField2()).isEqualTo(UPDATED_FREE_FIELD_2);
        assertThat(testPartner.getFreeField3()).isEqualTo(UPDATED_FREE_FIELD_3);
        assertThat(testPartner.getProvideDebitAccount()).isEqualTo(UPDATED_PROVIDE_DEBIT_ACCOUNT);
        assertThat(testPartner.getProvideCreditAccount()).isEqualTo(UPDATED_PROVIDE_CREDIT_ACCOUNT);
        assertThat(testPartner.getIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void patchNonExistingPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partnerDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPartner() throws Exception {
        int databaseSizeBeforeUpdate = partnerRepository.findAll().size();
        partner.setId(count.incrementAndGet());

        // Create the Partner
        PartnerDTO partnerDTO = partnerMapper.toDto(partner);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPartnerMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(partnerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Partner in the database
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePartner() throws Exception {
        // Initialize the database
        partnerRepository.saveAndFlush(partner);

        int databaseSizeBeforeDelete = partnerRepository.findAll().size();

        // Delete the partner
        restPartnerMockMvc
            .perform(delete(ENTITY_API_URL_ID, partner.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Partner> partnerList = partnerRepository.findAll();
        assertThat(partnerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
