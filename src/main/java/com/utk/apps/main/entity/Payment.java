package com.utk.apps.main.entity;

import com.utk.apps.main.status.PaymentStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment extends EntityMaster {

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    private String transactionId;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
