package com.wsh.core;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageArray {

  private List<List<String>> data;
  private int recordsFiltered;
  private int recordsTotal;
  private int draw;
}
