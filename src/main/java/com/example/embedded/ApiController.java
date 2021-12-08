package com.example.embedded;

import com.google.cloud.spring.data.spanner.core.admin.SpannerDatabaseAdminTemplate;
import com.google.cloud.spring.data.spanner.core.admin.SpannerSchemaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    SpannerSchemaUtils schemaUtils;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    SpannerDatabaseAdminTemplate databaseAdmin;

    @GetMapping("/requests/{requestId}")
    String getRequest(@PathVariable String requestId)  {
        // This findById was failing with "SpannerDataException: Column not found: entityHistory"
        // in the Kotlin. In Java this just works fine.
        Optional<Request> r = requestRepository.findById(requestId);
        System.out.println("request isPresent? = " + r.isPresent());
        return r.get().payload;
    }
}
