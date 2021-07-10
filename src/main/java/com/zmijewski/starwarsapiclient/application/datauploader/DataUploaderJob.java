package com.zmijewski.starwarsapiclient.application.datauploader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataUploaderJob {
    private final DataUploader dataUploader;

    @PostConstruct
    public void uploadDataOnStart() {
        dataUploader.uploadDataFromApi();
    }

    @Scheduled(cron = "${starwarsapi.cron}")
    public void uploadDataFromApi() {
        log.info("Start uploading data form api at: {}", LocalDate.now());
        dataUploader.uploadDataFromApi();
    }
}
