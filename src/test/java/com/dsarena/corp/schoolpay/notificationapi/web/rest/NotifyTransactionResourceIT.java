package com.dsarena.corp.schoolpay.notificationapi.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dsarena.corp.schoolpay.notificationapi.IntegrationTest;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import com.dsarena.corp.schoolpay.notificationapi.repository.NotifyTransactionRepository;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.NotifyTransactionDTO;
import com.dsarena.corp.schoolpay.notificationapi.service.mapper.NotifyTransactionMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
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
 * Integration tests for the {@link NotifyTransactionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class NotifyTransactionResourceIT {

    private static final String DEFAULT_TRANSACTION_U_ID = "AAAAAAAAAA";
    private static final String UPDATED_TRANSACTION_U_ID = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_ID = 1;
    private static final Integer UPDATED_RECORD_ID = 2;

    private static final String DEFAULT_CUSTOMER_PAYMENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_PAYMENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SCHOOL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_PAYMENT_CHANNEL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_PAYMENT_CHANNEL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SCHOOLPAY_RECEIPT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLPAY_RECEIPT_NUMBER = "BBBBBBBBBB";

    private static final Integer DEFAULT_AMOUNT = 1;
    private static final Integer UPDATED_AMOUNT = 2;

    private static final String DEFAULT_SCHOOL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARTNER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARTNER_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CREATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SOURCE_TRANSACTION_ID = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_TRANSACTION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STUDENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_STUDENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_STUDENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_STUDENT_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_CHARGES = 1;
    private static final Integer UPDATED_CHARGES = 2;

    private static final LocalDate DEFAULT_TIMESTAMP = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TIMESTAMP = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NARRATION = "AAAAAAAAAA";
    private static final String UPDATED_NARRATION = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY = "UGX";
    private static final String UPDATED_CURRENCY = "UGX";

    private static final String DEFAULT_DEBIT_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_DEBIT_ACCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_CREDIT_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_CREDIT_ACCOUNT = "BBBBBBBBBB";

    private static final ProccesingStatus DEFAULT_PROCCESSING_STATUS = ProccesingStatus.PENDING;
    private static final ProccesingStatus UPDATED_PROCCESSING_STATUS = ProccesingStatus.SUCCESS;

    private static final ProccesingStatus DEFAULT_FCR_TRANSACTION_STATUS = ProccesingStatus.PENDING;
    private static final ProccesingStatus UPDATED_FCR_TRANSACTION_STATUS = ProccesingStatus.SUCCESS;

    private static final String DEFAULT_FCR_TRANSACTION_ID = "AAAAAAAAAA";
    private static final String UPDATED_FCR_TRANSACTION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FCR_TRANSACTION_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_FCR_TRANSACTION_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_FIELD_1 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_1 = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_FIELD_2 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_FIELD_3 = "AAAAAAAAAA";
    private static final String UPDATED_FREE_FIELD_3 = "BBBBBBBBBB";

    private static final Integer DEFAULT_RETRIES = 5;
    private static final Integer UPDATED_RETRIES = 4;

    private static final String ENTITY_API_URL = "/api/notify-transactions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private NotifyTransactionRepository notifyTransactionRepository;

    @Autowired
    private NotifyTransactionMapper notifyTransactionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNotifyTransactionMockMvc;

    private NotifyTransaction notifyTransaction;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NotifyTransaction createEntity(EntityManager em) {
        NotifyTransaction notifyTransaction = new NotifyTransaction()
            .transactionUId(DEFAULT_TRANSACTION_U_ID)
            .recordId(DEFAULT_RECORD_ID)
            .customerPaymentCode(DEFAULT_CUSTOMER_PAYMENT_CODE)
            .schoolName(DEFAULT_SCHOOL_NAME)
            .sourcePaymentChannelCode(DEFAULT_SOURCE_PAYMENT_CHANNEL_CODE)
            .schoolpayReceiptNumber(DEFAULT_SCHOOLPAY_RECEIPT_NUMBER)
            .amount(DEFAULT_AMOUNT)
            .schoolCode(DEFAULT_SCHOOL_CODE)
            .partnerCode(DEFAULT_PARTNER_CODE)
            .dateCreated(DEFAULT_DATE_CREATED)
            .sourceTransactionId(DEFAULT_SOURCE_TRANSACTION_ID)
            .studentCode(DEFAULT_STUDENT_CODE)
            .studentName(DEFAULT_STUDENT_NAME)
            .charges(DEFAULT_CHARGES)
            .timestamp(DEFAULT_TIMESTAMP)
            .narration(DEFAULT_NARRATION)
            .currency(DEFAULT_CURRENCY)
            .debitAccount(DEFAULT_DEBIT_ACCOUNT)
            .creditAccount(DEFAULT_CREDIT_ACCOUNT)
            .proccessingStatus(DEFAULT_PROCCESSING_STATUS)
            .fcrTransactionStatus(DEFAULT_FCR_TRANSACTION_STATUS)
            .fcrTransactionId(DEFAULT_FCR_TRANSACTION_ID)
            .fcrTransactionReference(DEFAULT_FCR_TRANSACTION_REFERENCE)
            .freeField1(DEFAULT_FREE_FIELD_1)
            .freeField2(DEFAULT_FREE_FIELD_2)
            .freeField3(DEFAULT_FREE_FIELD_3)
            .retries(DEFAULT_RETRIES);
        return notifyTransaction;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NotifyTransaction createUpdatedEntity(EntityManager em) {
        NotifyTransaction notifyTransaction = new NotifyTransaction()
            .transactionUId(UPDATED_TRANSACTION_U_ID)
            .recordId(UPDATED_RECORD_ID)
            .customerPaymentCode(UPDATED_CUSTOMER_PAYMENT_CODE)
            .schoolName(UPDATED_SCHOOL_NAME)
            .sourcePaymentChannelCode(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE)
            .schoolpayReceiptNumber(UPDATED_SCHOOLPAY_RECEIPT_NUMBER)
            .amount(UPDATED_AMOUNT)
            .schoolCode(UPDATED_SCHOOL_CODE)
            .partnerCode(UPDATED_PARTNER_CODE)
            .dateCreated(UPDATED_DATE_CREATED)
            .sourceTransactionId(UPDATED_SOURCE_TRANSACTION_ID)
            .studentCode(UPDATED_STUDENT_CODE)
            .studentName(UPDATED_STUDENT_NAME)
            .charges(UPDATED_CHARGES)
            .timestamp(UPDATED_TIMESTAMP)
            .narration(UPDATED_NARRATION)
            .currency(UPDATED_CURRENCY)
            .debitAccount(UPDATED_DEBIT_ACCOUNT)
            .creditAccount(UPDATED_CREDIT_ACCOUNT)
            .proccessingStatus(UPDATED_PROCCESSING_STATUS)
            .fcrTransactionStatus(UPDATED_FCR_TRANSACTION_STATUS)
            .fcrTransactionId(UPDATED_FCR_TRANSACTION_ID)
            .fcrTransactionReference(UPDATED_FCR_TRANSACTION_REFERENCE)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .retries(UPDATED_RETRIES);
        return notifyTransaction;
    }

    @BeforeEach
    public void initTest() {
        notifyTransaction = createEntity(em);
    }

    @Test
    @Transactional
    void createNotifyTransaction() throws Exception {
        int databaseSizeBeforeCreate = notifyTransactionRepository.findAll().size();
        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);
        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isCreated());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeCreate + 1);
        NotifyTransaction testNotifyTransaction = notifyTransactionList.get(notifyTransactionList.size() - 1);
        assertThat(testNotifyTransaction.getTransactionUId()).isEqualTo(DEFAULT_TRANSACTION_U_ID);
        assertThat(testNotifyTransaction.getRecordId()).isEqualTo(DEFAULT_RECORD_ID);
        assertThat(testNotifyTransaction.getCustomerPaymentCode()).isEqualTo(DEFAULT_CUSTOMER_PAYMENT_CODE);
        assertThat(testNotifyTransaction.getSchoolName()).isEqualTo(DEFAULT_SCHOOL_NAME);
        assertThat(testNotifyTransaction.getSourcePaymentChannelCode()).isEqualTo(DEFAULT_SOURCE_PAYMENT_CHANNEL_CODE);
        assertThat(testNotifyTransaction.getSchoolpayReceiptNumber()).isEqualTo(DEFAULT_SCHOOLPAY_RECEIPT_NUMBER);
        assertThat(testNotifyTransaction.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testNotifyTransaction.getSchoolCode()).isEqualTo(DEFAULT_SCHOOL_CODE);
        assertThat(testNotifyTransaction.getPartnerCode()).isEqualTo(DEFAULT_PARTNER_CODE);
        assertThat(testNotifyTransaction.getDateCreated()).isEqualTo(DEFAULT_DATE_CREATED);
        assertThat(testNotifyTransaction.getSourceTransactionId()).isEqualTo(DEFAULT_SOURCE_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getStudentCode()).isEqualTo(DEFAULT_STUDENT_CODE);
        assertThat(testNotifyTransaction.getStudentName()).isEqualTo(DEFAULT_STUDENT_NAME);
        assertThat(testNotifyTransaction.getCharges()).isEqualTo(DEFAULT_CHARGES);
        assertThat(testNotifyTransaction.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testNotifyTransaction.getNarration()).isEqualTo(DEFAULT_NARRATION);
        assertThat(testNotifyTransaction.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
        assertThat(testNotifyTransaction.getDebitAccount()).isEqualTo(DEFAULT_DEBIT_ACCOUNT);
        assertThat(testNotifyTransaction.getCreditAccount()).isEqualTo(DEFAULT_CREDIT_ACCOUNT);
        assertThat(testNotifyTransaction.getProccessingStatus()).isEqualTo(DEFAULT_PROCCESSING_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionStatus()).isEqualTo(DEFAULT_FCR_TRANSACTION_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionId()).isEqualTo(DEFAULT_FCR_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getFcrTransactionReference()).isEqualTo(DEFAULT_FCR_TRANSACTION_REFERENCE);
        assertThat(testNotifyTransaction.getFreeField1()).isEqualTo(DEFAULT_FREE_FIELD_1);
        assertThat(testNotifyTransaction.getFreeField2()).isEqualTo(DEFAULT_FREE_FIELD_2);
        assertThat(testNotifyTransaction.getFreeField3()).isEqualTo(DEFAULT_FREE_FIELD_3);
        assertThat(testNotifyTransaction.getRetries()).isEqualTo(DEFAULT_RETRIES);
    }

    @Test
    @Transactional
    void createNotifyTransactionWithExistingId() throws Exception {
        // Create the NotifyTransaction with an existing ID
        notifyTransaction.setId(1L);
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        int databaseSizeBeforeCreate = notifyTransactionRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkTransactionUIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setTransactionUId(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRecordIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setRecordId(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCustomerPaymentCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setCustomerPaymentCode(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSchoolNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setSchoolName(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSourcePaymentChannelCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setSourcePaymentChannelCode(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSchoolpayReceiptNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setSchoolpayReceiptNumber(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setAmount(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPartnerCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setPartnerCode(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDateCreatedIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setDateCreated(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSourceTransactionIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setSourceTransactionId(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStudentCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setStudentCode(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStudentNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setStudentName(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTimestampIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setTimestamp(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNarrationIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setNarration(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCurrencyIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setCurrency(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDebitAccountIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setDebitAccount(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreditAccountIsRequired() throws Exception {
        int databaseSizeBeforeTest = notifyTransactionRepository.findAll().size();
        // set the field null
        notifyTransaction.setCreditAccount(null);

        // Create the NotifyTransaction, which fails.
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllNotifyTransactions() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        // Get all the notifyTransactionList
        restNotifyTransactionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(notifyTransaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].transactionUId").value(hasItem(DEFAULT_TRANSACTION_U_ID)))
            .andExpect(jsonPath("$.[*].recordId").value(hasItem(DEFAULT_RECORD_ID)))
            .andExpect(jsonPath("$.[*].customerPaymentCode").value(hasItem(DEFAULT_CUSTOMER_PAYMENT_CODE)))
            .andExpect(jsonPath("$.[*].schoolName").value(hasItem(DEFAULT_SCHOOL_NAME)))
            .andExpect(jsonPath("$.[*].sourcePaymentChannelCode").value(hasItem(DEFAULT_SOURCE_PAYMENT_CHANNEL_CODE)))
            .andExpect(jsonPath("$.[*].schoolpayReceiptNumber").value(hasItem(DEFAULT_SCHOOLPAY_RECEIPT_NUMBER)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].schoolCode").value(hasItem(DEFAULT_SCHOOL_CODE)))
            .andExpect(jsonPath("$.[*].partnerCode").value(hasItem(DEFAULT_PARTNER_CODE)))
            .andExpect(jsonPath("$.[*].dateCreated").value(hasItem(DEFAULT_DATE_CREATED.toString())))
            .andExpect(jsonPath("$.[*].sourceTransactionId").value(hasItem(DEFAULT_SOURCE_TRANSACTION_ID)))
            .andExpect(jsonPath("$.[*].studentCode").value(hasItem(DEFAULT_STUDENT_CODE)))
            .andExpect(jsonPath("$.[*].studentName").value(hasItem(DEFAULT_STUDENT_NAME)))
            .andExpect(jsonPath("$.[*].charges").value(hasItem(DEFAULT_CHARGES)))
            .andExpect(jsonPath("$.[*].timestamp").value(hasItem(DEFAULT_TIMESTAMP.toString())))
            .andExpect(jsonPath("$.[*].narration").value(hasItem(DEFAULT_NARRATION)))
            .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY)))
            .andExpect(jsonPath("$.[*].debitAccount").value(hasItem(DEFAULT_DEBIT_ACCOUNT)))
            .andExpect(jsonPath("$.[*].creditAccount").value(hasItem(DEFAULT_CREDIT_ACCOUNT)))
            .andExpect(jsonPath("$.[*].proccessingStatus").value(hasItem(DEFAULT_PROCCESSING_STATUS.toString())))
            .andExpect(jsonPath("$.[*].fcrTransactionStatus").value(hasItem(DEFAULT_FCR_TRANSACTION_STATUS.toString())))
            .andExpect(jsonPath("$.[*].fcrTransactionId").value(hasItem(DEFAULT_FCR_TRANSACTION_ID)))
            .andExpect(jsonPath("$.[*].fcrTransactionReference").value(hasItem(DEFAULT_FCR_TRANSACTION_REFERENCE)))
            .andExpect(jsonPath("$.[*].freeField1").value(hasItem(DEFAULT_FREE_FIELD_1)))
            .andExpect(jsonPath("$.[*].freeField2").value(hasItem(DEFAULT_FREE_FIELD_2)))
            .andExpect(jsonPath("$.[*].freeField3").value(hasItem(DEFAULT_FREE_FIELD_3)))
            .andExpect(jsonPath("$.[*].retries").value(hasItem(DEFAULT_RETRIES)));
    }

    @Test
    @Transactional
    void getNotifyTransaction() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        // Get the notifyTransaction
        restNotifyTransactionMockMvc
            .perform(get(ENTITY_API_URL_ID, notifyTransaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(notifyTransaction.getId().intValue()))
            .andExpect(jsonPath("$.transactionUId").value(DEFAULT_TRANSACTION_U_ID))
            .andExpect(jsonPath("$.recordId").value(DEFAULT_RECORD_ID))
            .andExpect(jsonPath("$.customerPaymentCode").value(DEFAULT_CUSTOMER_PAYMENT_CODE))
            .andExpect(jsonPath("$.schoolName").value(DEFAULT_SCHOOL_NAME))
            .andExpect(jsonPath("$.sourcePaymentChannelCode").value(DEFAULT_SOURCE_PAYMENT_CHANNEL_CODE))
            .andExpect(jsonPath("$.schoolpayReceiptNumber").value(DEFAULT_SCHOOLPAY_RECEIPT_NUMBER))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT))
            .andExpect(jsonPath("$.schoolCode").value(DEFAULT_SCHOOL_CODE))
            .andExpect(jsonPath("$.partnerCode").value(DEFAULT_PARTNER_CODE))
            .andExpect(jsonPath("$.dateCreated").value(DEFAULT_DATE_CREATED.toString()))
            .andExpect(jsonPath("$.sourceTransactionId").value(DEFAULT_SOURCE_TRANSACTION_ID))
            .andExpect(jsonPath("$.studentCode").value(DEFAULT_STUDENT_CODE))
            .andExpect(jsonPath("$.studentName").value(DEFAULT_STUDENT_NAME))
            .andExpect(jsonPath("$.charges").value(DEFAULT_CHARGES))
            .andExpect(jsonPath("$.timestamp").value(DEFAULT_TIMESTAMP.toString()))
            .andExpect(jsonPath("$.narration").value(DEFAULT_NARRATION))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY))
            .andExpect(jsonPath("$.debitAccount").value(DEFAULT_DEBIT_ACCOUNT))
            .andExpect(jsonPath("$.creditAccount").value(DEFAULT_CREDIT_ACCOUNT))
            .andExpect(jsonPath("$.proccessingStatus").value(DEFAULT_PROCCESSING_STATUS.toString()))
            .andExpect(jsonPath("$.fcrTransactionStatus").value(DEFAULT_FCR_TRANSACTION_STATUS.toString()))
            .andExpect(jsonPath("$.fcrTransactionId").value(DEFAULT_FCR_TRANSACTION_ID))
            .andExpect(jsonPath("$.fcrTransactionReference").value(DEFAULT_FCR_TRANSACTION_REFERENCE))
            .andExpect(jsonPath("$.freeField1").value(DEFAULT_FREE_FIELD_1))
            .andExpect(jsonPath("$.freeField2").value(DEFAULT_FREE_FIELD_2))
            .andExpect(jsonPath("$.freeField3").value(DEFAULT_FREE_FIELD_3))
            .andExpect(jsonPath("$.retries").value(DEFAULT_RETRIES));
    }

    @Test
    @Transactional
    void getNonExistingNotifyTransaction() throws Exception {
        // Get the notifyTransaction
        restNotifyTransactionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingNotifyTransaction() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();

        // Update the notifyTransaction
        NotifyTransaction updatedNotifyTransaction = notifyTransactionRepository.findById(notifyTransaction.getId()).get();
        // Disconnect from session so that the updates on updatedNotifyTransaction are not directly saved in db
        em.detach(updatedNotifyTransaction);
        updatedNotifyTransaction
            .transactionUId(UPDATED_TRANSACTION_U_ID)
            .recordId(UPDATED_RECORD_ID)
            .customerPaymentCode(UPDATED_CUSTOMER_PAYMENT_CODE)
            .schoolName(UPDATED_SCHOOL_NAME)
            .sourcePaymentChannelCode(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE)
            .schoolpayReceiptNumber(UPDATED_SCHOOLPAY_RECEIPT_NUMBER)
            .amount(UPDATED_AMOUNT)
            .schoolCode(UPDATED_SCHOOL_CODE)
            .partnerCode(UPDATED_PARTNER_CODE)
            .dateCreated(UPDATED_DATE_CREATED)
            .sourceTransactionId(UPDATED_SOURCE_TRANSACTION_ID)
            .studentCode(UPDATED_STUDENT_CODE)
            .studentName(UPDATED_STUDENT_NAME)
            .charges(UPDATED_CHARGES)
            .timestamp(UPDATED_TIMESTAMP)
            .narration(UPDATED_NARRATION)
            .currency(UPDATED_CURRENCY)
            .debitAccount(UPDATED_DEBIT_ACCOUNT)
            .creditAccount(UPDATED_CREDIT_ACCOUNT)
            .proccessingStatus(UPDATED_PROCCESSING_STATUS)
            .fcrTransactionStatus(UPDATED_FCR_TRANSACTION_STATUS)
            .fcrTransactionId(UPDATED_FCR_TRANSACTION_ID)
            .fcrTransactionReference(UPDATED_FCR_TRANSACTION_REFERENCE)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .retries(UPDATED_RETRIES);
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(updatedNotifyTransaction);

        restNotifyTransactionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, notifyTransactionDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isOk());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
        NotifyTransaction testNotifyTransaction = notifyTransactionList.get(notifyTransactionList.size() - 1);
        assertThat(testNotifyTransaction.getTransactionUId()).isEqualTo(UPDATED_TRANSACTION_U_ID);
        assertThat(testNotifyTransaction.getRecordId()).isEqualTo(UPDATED_RECORD_ID);
        assertThat(testNotifyTransaction.getCustomerPaymentCode()).isEqualTo(UPDATED_CUSTOMER_PAYMENT_CODE);
        assertThat(testNotifyTransaction.getSchoolName()).isEqualTo(UPDATED_SCHOOL_NAME);
        assertThat(testNotifyTransaction.getSourcePaymentChannelCode()).isEqualTo(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE);
        assertThat(testNotifyTransaction.getSchoolpayReceiptNumber()).isEqualTo(UPDATED_SCHOOLPAY_RECEIPT_NUMBER);
        assertThat(testNotifyTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testNotifyTransaction.getSchoolCode()).isEqualTo(UPDATED_SCHOOL_CODE);
        assertThat(testNotifyTransaction.getPartnerCode()).isEqualTo(UPDATED_PARTNER_CODE);
        assertThat(testNotifyTransaction.getDateCreated()).isEqualTo(UPDATED_DATE_CREATED);
        assertThat(testNotifyTransaction.getSourceTransactionId()).isEqualTo(UPDATED_SOURCE_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getStudentCode()).isEqualTo(UPDATED_STUDENT_CODE);
        assertThat(testNotifyTransaction.getStudentName()).isEqualTo(UPDATED_STUDENT_NAME);
        assertThat(testNotifyTransaction.getCharges()).isEqualTo(UPDATED_CHARGES);
        assertThat(testNotifyTransaction.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testNotifyTransaction.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testNotifyTransaction.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testNotifyTransaction.getDebitAccount()).isEqualTo(UPDATED_DEBIT_ACCOUNT);
        assertThat(testNotifyTransaction.getCreditAccount()).isEqualTo(UPDATED_CREDIT_ACCOUNT);
        assertThat(testNotifyTransaction.getProccessingStatus()).isEqualTo(UPDATED_PROCCESSING_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionStatus()).isEqualTo(UPDATED_FCR_TRANSACTION_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionId()).isEqualTo(UPDATED_FCR_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getFcrTransactionReference()).isEqualTo(UPDATED_FCR_TRANSACTION_REFERENCE);
        assertThat(testNotifyTransaction.getFreeField1()).isEqualTo(UPDATED_FREE_FIELD_1);
        assertThat(testNotifyTransaction.getFreeField2()).isEqualTo(UPDATED_FREE_FIELD_2);
        assertThat(testNotifyTransaction.getFreeField3()).isEqualTo(UPDATED_FREE_FIELD_3);
        assertThat(testNotifyTransaction.getRetries()).isEqualTo(UPDATED_RETRIES);
    }

    @Test
    @Transactional
    void putNonExistingNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, notifyTransactionDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateNotifyTransactionWithPatch() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();

        // Update the notifyTransaction using partial update
        NotifyTransaction partialUpdatedNotifyTransaction = new NotifyTransaction();
        partialUpdatedNotifyTransaction.setId(notifyTransaction.getId());

        partialUpdatedNotifyTransaction
            .transactionUId(UPDATED_TRANSACTION_U_ID)
            .recordId(UPDATED_RECORD_ID)
            .customerPaymentCode(UPDATED_CUSTOMER_PAYMENT_CODE)
            .schoolName(UPDATED_SCHOOL_NAME)
            .sourcePaymentChannelCode(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE)
            .amount(UPDATED_AMOUNT)
            .schoolCode(UPDATED_SCHOOL_CODE)
            .dateCreated(UPDATED_DATE_CREATED)
            .narration(UPDATED_NARRATION)
            .currency(UPDATED_CURRENCY)
            .fcrTransactionStatus(UPDATED_FCR_TRANSACTION_STATUS)
            .fcrTransactionId(UPDATED_FCR_TRANSACTION_ID)
            .fcrTransactionReference(UPDATED_FCR_TRANSACTION_REFERENCE)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField3(UPDATED_FREE_FIELD_3);

        restNotifyTransactionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNotifyTransaction.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedNotifyTransaction))
            )
            .andExpect(status().isOk());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
        NotifyTransaction testNotifyTransaction = notifyTransactionList.get(notifyTransactionList.size() - 1);
        assertThat(testNotifyTransaction.getTransactionUId()).isEqualTo(UPDATED_TRANSACTION_U_ID);
        assertThat(testNotifyTransaction.getRecordId()).isEqualTo(UPDATED_RECORD_ID);
        assertThat(testNotifyTransaction.getCustomerPaymentCode()).isEqualTo(UPDATED_CUSTOMER_PAYMENT_CODE);
        assertThat(testNotifyTransaction.getSchoolName()).isEqualTo(UPDATED_SCHOOL_NAME);
        assertThat(testNotifyTransaction.getSourcePaymentChannelCode()).isEqualTo(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE);
        assertThat(testNotifyTransaction.getSchoolpayReceiptNumber()).isEqualTo(DEFAULT_SCHOOLPAY_RECEIPT_NUMBER);
        assertThat(testNotifyTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testNotifyTransaction.getSchoolCode()).isEqualTo(UPDATED_SCHOOL_CODE);
        assertThat(testNotifyTransaction.getPartnerCode()).isEqualTo(DEFAULT_PARTNER_CODE);
        assertThat(testNotifyTransaction.getDateCreated()).isEqualTo(UPDATED_DATE_CREATED);
        assertThat(testNotifyTransaction.getSourceTransactionId()).isEqualTo(DEFAULT_SOURCE_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getStudentCode()).isEqualTo(DEFAULT_STUDENT_CODE);
        assertThat(testNotifyTransaction.getStudentName()).isEqualTo(DEFAULT_STUDENT_NAME);
        assertThat(testNotifyTransaction.getCharges()).isEqualTo(DEFAULT_CHARGES);
        assertThat(testNotifyTransaction.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testNotifyTransaction.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testNotifyTransaction.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testNotifyTransaction.getDebitAccount()).isEqualTo(DEFAULT_DEBIT_ACCOUNT);
        assertThat(testNotifyTransaction.getCreditAccount()).isEqualTo(DEFAULT_CREDIT_ACCOUNT);
        assertThat(testNotifyTransaction.getProccessingStatus()).isEqualTo(DEFAULT_PROCCESSING_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionStatus()).isEqualTo(UPDATED_FCR_TRANSACTION_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionId()).isEqualTo(UPDATED_FCR_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getFcrTransactionReference()).isEqualTo(UPDATED_FCR_TRANSACTION_REFERENCE);
        assertThat(testNotifyTransaction.getFreeField1()).isEqualTo(UPDATED_FREE_FIELD_1);
        assertThat(testNotifyTransaction.getFreeField2()).isEqualTo(DEFAULT_FREE_FIELD_2);
        assertThat(testNotifyTransaction.getFreeField3()).isEqualTo(UPDATED_FREE_FIELD_3);
        assertThat(testNotifyTransaction.getRetries()).isEqualTo(DEFAULT_RETRIES);
    }

    @Test
    @Transactional
    void fullUpdateNotifyTransactionWithPatch() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();

        // Update the notifyTransaction using partial update
        NotifyTransaction partialUpdatedNotifyTransaction = new NotifyTransaction();
        partialUpdatedNotifyTransaction.setId(notifyTransaction.getId());

        partialUpdatedNotifyTransaction
            .transactionUId(UPDATED_TRANSACTION_U_ID)
            .recordId(UPDATED_RECORD_ID)
            .customerPaymentCode(UPDATED_CUSTOMER_PAYMENT_CODE)
            .schoolName(UPDATED_SCHOOL_NAME)
            .sourcePaymentChannelCode(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE)
            .schoolpayReceiptNumber(UPDATED_SCHOOLPAY_RECEIPT_NUMBER)
            .amount(UPDATED_AMOUNT)
            .schoolCode(UPDATED_SCHOOL_CODE)
            .partnerCode(UPDATED_PARTNER_CODE)
            .dateCreated(UPDATED_DATE_CREATED)
            .sourceTransactionId(UPDATED_SOURCE_TRANSACTION_ID)
            .studentCode(UPDATED_STUDENT_CODE)
            .studentName(UPDATED_STUDENT_NAME)
            .charges(UPDATED_CHARGES)
            .timestamp(UPDATED_TIMESTAMP)
            .narration(UPDATED_NARRATION)
            .currency(UPDATED_CURRENCY)
            .debitAccount(UPDATED_DEBIT_ACCOUNT)
            .creditAccount(UPDATED_CREDIT_ACCOUNT)
            .proccessingStatus(UPDATED_PROCCESSING_STATUS)
            .fcrTransactionStatus(UPDATED_FCR_TRANSACTION_STATUS)
            .fcrTransactionId(UPDATED_FCR_TRANSACTION_ID)
            .fcrTransactionReference(UPDATED_FCR_TRANSACTION_REFERENCE)
            .freeField1(UPDATED_FREE_FIELD_1)
            .freeField2(UPDATED_FREE_FIELD_2)
            .freeField3(UPDATED_FREE_FIELD_3)
            .retries(UPDATED_RETRIES);

        restNotifyTransactionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNotifyTransaction.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedNotifyTransaction))
            )
            .andExpect(status().isOk());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
        NotifyTransaction testNotifyTransaction = notifyTransactionList.get(notifyTransactionList.size() - 1);
        assertThat(testNotifyTransaction.getTransactionUId()).isEqualTo(UPDATED_TRANSACTION_U_ID);
        assertThat(testNotifyTransaction.getRecordId()).isEqualTo(UPDATED_RECORD_ID);
        assertThat(testNotifyTransaction.getCustomerPaymentCode()).isEqualTo(UPDATED_CUSTOMER_PAYMENT_CODE);
        assertThat(testNotifyTransaction.getSchoolName()).isEqualTo(UPDATED_SCHOOL_NAME);
        assertThat(testNotifyTransaction.getSourcePaymentChannelCode()).isEqualTo(UPDATED_SOURCE_PAYMENT_CHANNEL_CODE);
        assertThat(testNotifyTransaction.getSchoolpayReceiptNumber()).isEqualTo(UPDATED_SCHOOLPAY_RECEIPT_NUMBER);
        assertThat(testNotifyTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testNotifyTransaction.getSchoolCode()).isEqualTo(UPDATED_SCHOOL_CODE);
        assertThat(testNotifyTransaction.getPartnerCode()).isEqualTo(UPDATED_PARTNER_CODE);
        assertThat(testNotifyTransaction.getDateCreated()).isEqualTo(UPDATED_DATE_CREATED);
        assertThat(testNotifyTransaction.getSourceTransactionId()).isEqualTo(UPDATED_SOURCE_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getStudentCode()).isEqualTo(UPDATED_STUDENT_CODE);
        assertThat(testNotifyTransaction.getStudentName()).isEqualTo(UPDATED_STUDENT_NAME);
        assertThat(testNotifyTransaction.getCharges()).isEqualTo(UPDATED_CHARGES);
        assertThat(testNotifyTransaction.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testNotifyTransaction.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testNotifyTransaction.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testNotifyTransaction.getDebitAccount()).isEqualTo(UPDATED_DEBIT_ACCOUNT);
        assertThat(testNotifyTransaction.getCreditAccount()).isEqualTo(UPDATED_CREDIT_ACCOUNT);
        assertThat(testNotifyTransaction.getProccessingStatus()).isEqualTo(UPDATED_PROCCESSING_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionStatus()).isEqualTo(UPDATED_FCR_TRANSACTION_STATUS);
        assertThat(testNotifyTransaction.getFcrTransactionId()).isEqualTo(UPDATED_FCR_TRANSACTION_ID);
        assertThat(testNotifyTransaction.getFcrTransactionReference()).isEqualTo(UPDATED_FCR_TRANSACTION_REFERENCE);
        assertThat(testNotifyTransaction.getFreeField1()).isEqualTo(UPDATED_FREE_FIELD_1);
        assertThat(testNotifyTransaction.getFreeField2()).isEqualTo(UPDATED_FREE_FIELD_2);
        assertThat(testNotifyTransaction.getFreeField3()).isEqualTo(UPDATED_FREE_FIELD_3);
        assertThat(testNotifyTransaction.getRetries()).isEqualTo(UPDATED_RETRIES);
    }

    @Test
    @Transactional
    void patchNonExistingNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, notifyTransactionDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamNotifyTransaction() throws Exception {
        int databaseSizeBeforeUpdate = notifyTransactionRepository.findAll().size();
        notifyTransaction.setId(count.incrementAndGet());

        // Create the NotifyTransaction
        NotifyTransactionDTO notifyTransactionDTO = notifyTransactionMapper.toDto(notifyTransaction);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNotifyTransactionMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(notifyTransactionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the NotifyTransaction in the database
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteNotifyTransaction() throws Exception {
        // Initialize the database
        notifyTransactionRepository.saveAndFlush(notifyTransaction);

        int databaseSizeBeforeDelete = notifyTransactionRepository.findAll().size();

        // Delete the notifyTransaction
        restNotifyTransactionMockMvc
            .perform(delete(ENTITY_API_URL_ID, notifyTransaction.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NotifyTransaction> notifyTransactionList = notifyTransactionRepository.findAll();
        assertThat(notifyTransactionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
