package com.wsh.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageView<T> extends PageDto {
    List<T> content;
}
