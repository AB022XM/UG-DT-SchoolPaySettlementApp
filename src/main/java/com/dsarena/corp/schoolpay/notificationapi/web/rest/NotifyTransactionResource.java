package com.dsarena.corp.schoolpay.notificationapi.web.rest;

import com.dsarena.corp.schoolpay.notificationapi.Util.Constants;
import com.dsarena.corp.schoolpay.notificationapi.Util.Helper;
import com.dsarena.corp.schoolpay.notificationapi.Util.PostToAmol;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA.ResponseDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Responses.CASATOCASA.AmolResponse;
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
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
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
        log.debug("\n\n\n");

        log.debug("+++++++++++++++++++++++++++++NEW TRANSACTION initiated ++++++++++++++++++");

        log.debug("+++++++++++++++++++++++++++++ TRANSACTION DETAILS START ++++++++++++++++++");
        log.debug(notifyTransactionDTO.toString());
        log.debug("+++++++++++++++++++++++++++++ TRANSACTION DETAILS END ++++++++++++++++++");
        log.debug("ORIGINAL OBJECT : {}", notifyTransactionDTO);
        if (notifyTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new notifyTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }

        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.INITIATED);
        //Do a duplicate check here
        Optional<NotifyTransaction> notifyTransaction = notifyTransactionRepository.findByRecordId(notifyTransactionDTO.getRecordId());

        if (notifyTransaction.isPresent()) {
            log.debug("+++++++++++++++++++++++++++++  TRANSACTION DETAILS EXISTS ++++++++++++++++++");
            log.debug(notifyTransaction.toString());
            log.debug("+++++++++++++++++++++++++++++ TRANSACTION DETAILS EXISTS END ++++++++++++++++++");

            Boolean settlementSuc = false;
            String statusMesg = notifyTransaction.get().getProccessingStatus().name() + "";
            String msgDetails = "Transaction already processed :  " + notifyTransaction.get().toString();
            if (statusMesg.equalsIgnoreCase(ProccesingStatus.SUCCESS.name())) {
                settlementSuc = true;
            }
            NotificationResponse duplicateResp = new NotificationResponse(
                String.valueOf(notifyTransaction.get().getAmount()),
                String.valueOf(notifyTransaction.get().getRecordId()),
                notifyTransaction.get().getTransactionUId(),
                msgDetails,
                settlementSuc
            );
            return ResponseEntity.ok(duplicateResp);
        }

        Optional<School> school = schoolRepository.findBySchoolCode(notifyTransactionDTO.getSchoolCode());
        log.debug("isPresentValue For School: " + school.toString() + " IsSCHOOL-PRESENT: " + school.isPresent());
        if (school.isEmpty()) {
            throw new BadRequestAlertException(
                "School with schoolCode " + notifyTransactionDTO.getSchoolCode() + " does not exist",
                ENTITY_NAME,
                "not found"
            );
        }
        String transactionId = Helper.TranIdGen();
        notifyTransactionDTO.setCreditAccount(school.get().getSchoolAccountNumber());
        notifyTransactionDTO.setDebitAccount(school.get().getFreeField1());
        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.PENDING);
        //notifyTransactionDTO.setTimestamp(LocalDateTime.now());

        String narrative =
            notifyTransactionDTO.getSourcePaymentChannelCode() +
            " | " +
            notifyTransactionDTO.getSourceTransactionId() +
            " | " +
            notifyTransactionDTO.getStudentCode();

        notifyTransactionDTO.setNarration(narrative);
        notifyTransactionDTO.setFcrTransactionStatus(ProccesingStatus.PENDING);
        notifyTransactionDTO.setProccessingStatus(ProccesingStatus.PENDING);

        notifyTransactionDTO.setTransactionUId(transactionId);
        NotifyTransactionDTO result = notifyTransactionService.save(notifyTransactionDTO);

        if (result == null) {
            log.debug("FAILURE: no able to get saved transaction");
            throw new BadRequestAlertException(
                "An error occurred while processing the transaction with recordId" + notifyTransactionDTO.getRecordId(),
                ENTITY_NAME,
                "not found"
            );
        }
        try {
            postToAmolUpdate(result);
        } catch (Exception e) {
            log.debug("No DETAILS FOUND ON RESULT: " + result.toString());
        }

        NotificationResponse responseCreatedResponse = new NotificationResponse(
            result.getAmount().toString(),
            result.getRecordId().toString(),
            result.getTransactionUId() + "",
            "Transaction has been received ",
            true
        );

        return ResponseEntity.ok(responseCreatedResponse);
    }

    // private void postToAmolUpdate(NotifyTransactionDTO savedNtDTO)
    //     throws KeyManagementException, JsonProcessingException, NoSuchAlgorithmException {
    //     try {
    //         if (savedNtDTO != null) {
    //             ResponseDetails responseDetails = new PostToAmol().postTransactionGLCASA(savedNtDTO);
    //             NotifyTransactionDTO notDTO = null;
    //             if (responseDetails != null) {
    //                 if (responseDetails.getAmolResponse() != null) {
    //                     String tranStatus = responseDetails.getAmolResponse().getStatus();
    //                     log.debug("REQUEST AMOL PREVIOUS :  " + responseDetails.getRequest().getBody().toString());

    //                     savedNtDTO.setFreeField2(responseDetails.getRequest().toString());
    //                     savedNtDTO.setFreeField3(responseDetails.getAmolResponse().toString());

    //                     if (tranStatus.equalsIgnoreCase(Constants.SUCCESS)) {
    //                         savedNtDTO.setFcrTransactionId(responseDetails.getAmolResponse().getData().getTransferId());
    //                         savedNtDTO.setFcrTransactionReference(responseDetails.getAmolResponse().getData().getTransferReferenceId());
    //                         savedNtDTO.setFcrTransactionStatus(ProccesingStatus.SUCCESS);
    //                     } else if (tranStatus.equalsIgnoreCase(ProccesingStatus.FAILED.name())) {
    //                         savedNtDTO.setFcrTransactionStatus(ProccesingStatus.FAILED);
    //                     } else {
    //                         savedNtDTO.setProccessingStatus(ProccesingStatus.UNKNOWN);
    //                     }
    //                 }
    //             }

    //             //Optional<NotifyTransactionDTO> updateAfterDeposit =  commented out since its not being used.

    //             notifyTransactionService.partialUpdate(notDTO);
    //         }
    //     } catch (Exception e) {
    //         log.debug(e.getStackTrace().toString());
    //         log.debug(e.getMessage().toString());
    //     }
    // }

    private void postToAmolUpdate(NotifyTransactionDTO savedNtDTO)
        throws KeyManagementException, JsonProcessingException, NoSuchAlgorithmException {
        log.debug("postToAmolUpdate BEFORE ANYUPDATE :  " + savedNtDTO.toString());

        try {
            log.debug("OBJECT-NotifyTransactionDTO Before amol posting :  " + savedNtDTO.toString());
            log.debug(
                "\n RECORDID: " +
                savedNtDTO.getRecordId() +
                " TRANSACTIONID " +
                savedNtDTO.getTransactionUId() +
                "\n ###AUTO ID### : " +
                savedNtDTO.getId()
            );
            if (savedNtDTO != null) {
                ResponseDetails responseDetails = new PostToAmol().postTransactionGLCASA(savedNtDTO);
                if (responseDetails != null) {
                    AmolResponse amolResponse = responseDetails.getAmolResponse();
                    if (amolResponse != null) {
                        String tranStatus = amolResponse.getStatus() + "";
                        log.debug("REQUEST AMOL PREVIOUS :  " + responseDetails.getRequest().getBody().toString());

                        savedNtDTO.setFreeField2(responseDetails.getRequest() + "");
                        savedNtDTO.setFreeField3(responseDetails.getAmolResponse().toString() + "");

                        if (tranStatus.equalsIgnoreCase(Constants.SUCCESS)) {
                            savedNtDTO.setFcrTransactionId(amolResponse.getData().getTransferId());
                            savedNtDTO.setFcrTransactionReference(amolResponse.getData().getTransferReferenceId());
                            savedNtDTO.setProccessingStatus(ProccesingStatus.SUCCESS);

                            savedNtDTO.setFcrTransactionStatus(ProccesingStatus.SUCCESS);
                        } else if (tranStatus.equalsIgnoreCase(ProccesingStatus.FAILED.name())) {
                            savedNtDTO.setFcrTransactionStatus(ProccesingStatus.FAILED);
                            savedNtDTO.setProccessingStatus(ProccesingStatus.FAILED);
                        } else {
                            savedNtDTO.setProccessingStatus(ProccesingStatus.UNKNOWN);
                            savedNtDTO.setFcrTransactionStatus(ProccesingStatus.UNKNOWN);
                            savedNtDTO.setFreeField1(amolResponse.toString());
                        }
                    }
                }
                //Optional<NotifyTransactionDTO> updateAfterDeposit =  commented out since its not being used.
                notifyTransactionService.partialUpdate(savedNtDTO);
            }
        } catch (Exception e) {
            log.debug(e.getStackTrace().toString());
            log.debug(e.getMessage().toString());
        }
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
