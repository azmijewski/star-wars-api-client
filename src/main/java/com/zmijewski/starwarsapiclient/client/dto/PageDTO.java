package com.zmijewski.starwarsapiclient.client.dto;

import lombok.Value;

import java.util.List;

@Value
public class PageDTO<T> {
    Integer count;
    String next;
    List<T> results;
}
