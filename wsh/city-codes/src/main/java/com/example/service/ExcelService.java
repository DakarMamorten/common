package com.example.service;

import com.example.domain.CityCode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelService {
    public static final String FILE_PATH = "d://1.xlsx";
    public List<CityCode> read(){

        List<CityCode> results = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row: sheet) {
            Cell code = row.getCell(3);
            Cell adminCode = row.getCell(5);
        }
        return results;
    }
}
