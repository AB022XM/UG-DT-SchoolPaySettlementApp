package com.dsarena.corp.schoolpay.notificationapi.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.dsarena.corp.schoolpay.notificationapi.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NotifyTransactionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NotifyTransaction.class);
        NotifyTransaction notifyTransaction1 = new NotifyTransaction();
        notifyTransaction1.setId(1L);
        NotifyTransaction notifyTransaction2 = new NotifyTransaction();
        notifyTransaction2.setId(notifyTransaction1.getId());
        assertThat(notifyTransaction1).isEqualTo(notifyTransaction2);
        notifyTransaction2.setId(2L);
        assertThat(notifyTransaction1).isNotEqualTo(notifyTransaction2);
        notifyTransaction1.setId(null);
        assertThat(notifyTransaction1).isNotEqualTo(notifyTransaction2);
    }
}
