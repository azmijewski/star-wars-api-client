package com.zmijewski.starwarsapiclient.client;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.lang.reflect.Type;

@RequiredArgsConstructor
@Slf4j
public class ResponseErrorLoggingDecoder implements Decoder {
    private final Decoder decoder;


    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        if (response.status() >= HttpStatus.BAD_REQUEST.value()) {
            log.error("Star Wars Api Exception! Request: {}, status: {}, response body: {}", response.request(), response.status(), response.body());
        }
        return decoder.decode(response, type);
    }
}
