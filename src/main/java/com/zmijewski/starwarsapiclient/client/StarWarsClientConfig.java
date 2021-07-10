package com.zmijewski.starwarsapiclient.client;

import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;

public class StarWarsClientConfig {
    @Bean
    Decoder errorLoggingDecoder(ObjectFactory<HttpMessageConverters> objectFactory) {
        var springDecoder = new SpringDecoder(objectFactory);
        return new ResponseErrorLoggingDecoder(springDecoder);
    }
}
