package com.wsh.domain.dto;

import lombok.Data;

@Data
public class PageDto {
    private int number;
    private int totalPages;
    private long totalElements;
}
