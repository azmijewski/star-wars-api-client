package com.zmijewski.starwarsapiclient.application.datauploader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("!test")
public class DataUploaderJob {
    private final DataUploader dataUploader;

    @Scheduled(cron = "${starwarsapi.cron}")
    @PostConstruct
    public void uploadDataFromApi() {
        log.info("Start uploading data form api at: {}", LocalDateTime.now());
        dataUploader.uploadDataFromApi();
        log.info("Data successfully uploaded");
    }
}
