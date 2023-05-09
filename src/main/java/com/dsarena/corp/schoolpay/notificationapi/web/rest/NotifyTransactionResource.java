package com.dsarena.corp.schoolpay.notificationapi.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsarena.corp.schoolpay.notificationapi.Util.PostToAmol;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA.ResponseDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotificationResponse;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.School;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import com.dsarena.corp.schoolpay.notificationapi.repository.NotifyTransactionRepository;
import com.dsarena.corp.schoolpay.notificationapi.repository.SchoolRepository;
import com.dsarena.corp.schoolpay.notificationapi.service.NotifyTransactionService;
import com.dsarena.corp.schoolpay.notificationapi.service.SchoolService;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.NotifyTransactionDTO;
import com.dsarena.corp.schoolpay.notificationapi.web.rest.errors.BadRequestAlertException;
import com.fasterxml.jackson.core.JsonProcessingException;

import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link NotifyTransaction}.
 */
@RestController
@RequestMapping("payment/api/v1/transaction/")
public class NotifyTransactionResource {

    private final Logger log = LoggerFactory.getLogger(NotifyTransactionResource.class);

    private static final String ENTITY_NAME = "notifyTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NotifyTransactionService notifyTransactionService;
    private final SchoolService dSchoolService;
    private final NotifyTransactionRepository notifyTransactionRepository;
    private final SchoolRepository schoolRepository;

    public NotifyTransactionResource(
        NotifyTransactionService notifyTransactionService,
        NotifyTransactionRepository notifyTransactionRepository,
        SchoolRepository schoolRepository,
        SchoolService dSchoolService
    ) {
        this.notifyTransactionService = notifyTransactionService;
        this.notifyTransactionRepository = notifyTransactionRepository;
        this.schoolRepository = schoolRepository;
        this.dSchoolService = dSchoolService;
    }

    /**
     * {@code POST  /notify-transactions} : Create a new notifyTransaction.
     *
     * @param notifyTransactionDTO the notifyTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new notifyTransactionDTO, or with status {@code 400 (Bad Request)} if the notifyTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @PostMapping("/notify")
    public ResponseEntity<NotificationResponse> createNotifyTransaction(@Valid @RequestBody NotifyTransactionDTO notifyTransactionDTO)
        throws URISyntaxException, NumberFormatException, KeyManagementException, NoSuchAlgorithmException, JsonProcessingException {
        // Integer transactionId = NotifyTransaction.generateUniqueRef();
        log.debug("REST request to save NotifyTransaction : {}", notifyTransactionDTO);
        if (notifyTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new notifyTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.INITIATED);
        //Do a duplicate check here
        Optional<NotifyTransaction> notifyTransaction = notifyTransactionRepository.findByRecordId(notifyTransactionDTO.getRecordId());

        if (notifyTransaction.isPresent()) {
            NotificationResponse duplicateResp = new NotificationResponse(
                String.valueOf(notifyTransaction.get().getAmount()),
                String.valueOf(notifyTransaction.get().getRecordId()),
                notifyTransaction.get().getTransactionUId(),
                "Transaction already processed:  " + notifyTransaction.get().getTimestamp(),
                true
            );
            return ResponseEntity.created(new URI("/notify/" + notifyTransactionDTO.getTransactionUId())).body(duplicateResp);
        }

        Optional<School> school = schoolRepository.findBySchoolCode(notifyTransactionDTO.getSchoolCode());
        if (school.isEmpty()) {
            throw new BadRequestAlertException(
                "School with schoolCode " + notifyTransactionDTO.getSchoolCode() + " does not exist",
                ENTITY_NAME,
                "not found"
            );
        }

                log.debug("isPresentValue For notifyTransaction: " + notifyTransaction.isPresent());
                log.debug("isPresentValue For School: "+school.toString() +" IsSCHOOL-PRESENT: "+ school.isPresent());


        notifyTransactionDTO.setCreditAccount(school.get().getSchoolAccountNumber());
        notifyTransactionDTO.setDebitAccount(school.get().getFreeField1());
        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.PENDING);
        notifyTransactionDTO.setTimestamp(LocalDate.now());
        NotifyTransactionDTO result = notifyTransactionService.save(notifyTransactionDTO);
        log.debug(ENTITY_NAME + " ON Saved: " + result.toString());
        //fetch saved object
        NotifyTransaction savedNotifyTransaction = notifyTransactionRepository.findById(result.getId()).orElse(null);
        if (savedNotifyTransaction == null) {
            throw new BadRequestAlertException(
                "An error occurred while processing the transaction with recordId" + notifyTransactionDTO.getRecordId(),
                ENTITY_NAME,
                "not found"
            );
        }

        log.info("Saved NotifyTransaction: " + savedNotifyTransaction.toString());
        NotificationResponse responseCreatedResponse = new NotificationResponse(
            result.getAmount().toString(),
            result.getRecordId().toString(),
            savedNotifyTransaction.getTransactionUId(),
            "Transaction has been received",
            true
        );
        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.PENDING);
        ResponseDetails responseDetails = new PostToAmol()
            .postTransactionGLCASA(savedNotifyTransaction, school.get().getSchoolAccountNumber());

            //route notify
        log.debug("REQUEST_STRING:  " + responseDetails.getRequest().getBody().toString());
        return ResponseEntity.created(new URI("/notify/" + result.getTransactionUId())).body(responseCreatedResponse);
    }

    /**
     * {@code PUT  /notify-transactions/:id} : Updates an existing notifyTransaction.
     *
     * @param id the id of the notifyTransactionDTO to save.
     * @param notifyTransactionDTO the notifyTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated notifyTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the notifyTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the notifyTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    // @PutMapping("/notify-transactions/{id}")
    // public ResponseEntity<NotifyTransactionDTO> updateNotifyTransaction(
    //     @PathVariable(value = "id", required = false) final Long id,
    //     @Valid @RequestBody NotifyTransactionDTO notifyTransactionDTO
    // ) throws URISyntaxException {
    //     log.debug("REST request to update NotifyTransaction : {}, {}", id, notifyTransactionDTO);
    //     if (notifyTransactionDTO.getId() == null) {
    //         throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
    //     }
    //     if (!Objects.equals(id, notifyTransactionDTO.getId())) {
    //         throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
    //     }

    //     if (!notifyTransactionRepository.existsById(id)) {
    //         throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
    //     }

    //     NotifyTransactionDTO result = notifyTransactionService.update(notifyTransactionDTO);
    //     return ResponseEntity
    //         .ok()
    //         .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, notifyTransactionDTO.getId().toString()))
    //         .body(result);
    // }

    // /**
    //  * {@code PATCH  /notify-transactions/:id} : Partial updates given fields of an existing notifyTransaction, field will ignore if it is null
    //  *
    //  * @param id the id of the notifyTransactionDTO to save.
    //  * @param notifyTransactionDTO the notifyTransactionDTO to update.
    //  * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated notifyTransactionDTO,
    //  * or with status {@code 400 (Bad Request)} if the notifyTransactionDTO is not valid,
    //  * or with status {@code 404 (Not Found)} if the notifyTransactionDTO is not found,
    //  * or with status {@code 500 (Internal Server Error)} if the notifyTransactionDTO couldn't be updated.
    //  * @throws URISyntaxException if the Location URI syntax is incorrect.
    //  */
    // @PatchMapping(value = "/notify-transactions/{id}", consumes = { "application/json", "application/merge-patch+json" })
    // public ResponseEntity<NotifyTransactionDTO> partialUpdateNotifyTransaction(
    //     @PathVariable(value = "id", required = false) final Long id,
    //     @NotNull @RequestBody NotifyTransactionDTO notifyTransactionDTO
    // ) throws URISyntaxException {
    //     log.debug("REST request to partial update NotifyTransaction partially : {}, {}", id, notifyTransactionDTO);
    //     if (notifyTransactionDTO.getId() == null) {
    //         throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
    //     }
    //     if (!Objects.equals(id, notifyTransactionDTO.getId())) {
    //         throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
    //     }

    //     if (!notifyTransactionRepository.existsById(id)) {
    //         throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
    //     }

    //     Optional<NotifyTransactionDTO> result = notifyTransactionService.partialUpdate(notifyTransactionDTO);

    //     return ResponseUtil.wrapOrNotFound(
    //         result,
    //         HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, notifyTransactionDTO.getId().toString())
    //     );
    // }

    /**
     * {@code GET  /notify-transactions} : get all the notifyTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of notifyTransactions in body.
     */
    // @GetMapping("/notify-transactions")
    // public ResponseEntity<List<NotifyTransactionDTO>> getAllNotifyTransactions(
    //     @org.springdoc.api.annotations.ParameterObject Pageable pageable
    // ) {
    //     log.debug("REST request to get a page of NotifyTransactions");
    //     Page<NotifyTransactionDTO> page = notifyTransactionService.findAll(pageable);
    //     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
    //     return ResponseEntity.ok().headers(headers).body(page.getContent());
    // }

    /**
     * {@code GET  /notify-transactions/:id} : get the "id" notifyTransaction.
     *
     * @param id the id of the notifyTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the notifyTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<NotifyTransactionDTO> getNotifyTransaction(@PathVariable Long id) {
        log.debug("REST request to get NotifyTransaction : {}", id);
        Optional<NotifyTransactionDTO> notifyTransactionDTO = notifyTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(notifyTransactionDTO);
    }
    /**
     * {@code DELETE  /notify-transactions/:id} : delete the "id" notifyTransaction.
     *
     * @param id the id of the notifyTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    // @DeleteMapping("/notify-transactions/{id}")
    // public ResponseEntity<Void> deleteNotifyTransaction(@PathVariable Long id) {
    //     log.debug("REST request to delete NotifyTransaction : {}", id);
    //     notifyTransactionService.delete(id);
    //     return ResponseEntity
    //         .noContent()
    //         .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
    //         .build();
    // }
}
