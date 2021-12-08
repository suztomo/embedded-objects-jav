package com.example.embedded;

import java.util.Date;

public class EntityHistory {
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;

    EntityHistory() {}

    EntityHistory(String userId) {
        createdAt = new Date(System.currentTimeMillis());
        updatedAt = new Date(System.currentTimeMillis());
        createdBy = userId;
        updatedBy = userId;
    }
}
