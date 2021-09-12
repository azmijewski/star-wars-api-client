package com.zmijewski.starwarsapiclient.api.model;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PageModel <T> {
    Long count;
    Integer pages;
    List<T> elements;

    public PageModel(Page<T> domainPage) {
        count = domainPage.getTotalElements();
        pages = domainPage.getTotalPages();
        elements = domainPage.getContent();
    }
}
