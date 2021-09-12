package com.zmijewski.starwarsapiclient.client;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.util.List;

class RetryableErrorDecoder implements ErrorDecoder {
    private static final List<Integer> RETRYABLE_HTTP_ERROR_CODES = List.of(HttpStatus.BAD_GATEWAY.value(),
            HttpStatus.SERVICE_UNAVAILABLE.value(), HttpStatus.GATEWAY_TIMEOUT.value());

    @Override
    public Exception decode(String methodKey, Response response) {
        if (RETRYABLE_HTTP_ERROR_CODES.contains(response.status())) {
            return new RetryableException(response.status(), response.reason(),
                    response.request().httpMethod(), null, response.request());
        }
        return FeignException.errorStatus(methodKey, response);
    }
}
