package com.zmijewski.starwarsapiclient.client;

import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;

class StarWarsClientConfig {
    @Bean
    Decoder errorLoggingDecoder(ObjectFactory<HttpMessageConverters> objectFactory) {
        var springDecoder = new SpringDecoder(objectFactory);
        return new ResponseErrorLoggingDecoder(springDecoder);
    }

    @Bean
    Logger.Level logger() {
        return Logger.Level.BASIC;
    }

    @Bean
    Retryer retryer() {
        return new Retryer.Default();
    }

    @Bean
    ErrorDecoder errorDecoder() {
        return new RetryableErrorDecoder();
    }
}
