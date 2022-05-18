package com.wsh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeDto {
    private final String code;
    private final String adminCode;
}
