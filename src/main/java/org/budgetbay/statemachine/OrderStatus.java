package org.budgetbay.statemachine;

import lombok.Getter;

public enum OrderStatus {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    @Getter
    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
