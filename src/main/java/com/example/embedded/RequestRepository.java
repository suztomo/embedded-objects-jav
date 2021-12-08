package com.example.embedded;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;

public interface RequestRepository extends SpannerRepository<Request, String> {
}
