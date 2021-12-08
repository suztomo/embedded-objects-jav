package com.example.embedded;

import com.google.cloud.spring.data.spanner.core.mapping.Embedded;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;

@Table(name = "Requests")
public class Request {
    @PrimaryKey
    String requestId;

    String payload;

    @Embedded
    EntityHistory entityHistory;

}
