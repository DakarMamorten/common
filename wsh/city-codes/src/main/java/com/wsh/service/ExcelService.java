package com.wsh.service;

import com.wsh.dto.CodeDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExcelService {
    public static final String FILE_PATH = "D:\\1.xlsx";
    private final AdminCodeService adminCodeService;

    public List<CodeDto> read() {
        List<String> codes = adminCodeService.getAdminCode();
        List<CodeDto> results = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new File(FILE_PATH))) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell code = row.getCell(3);
                Cell adminCode = row.getCell(5);
                if (code != null && adminCode != null) {
                    String codeValue = code.getStringCellValue();
                    String adminCodeValue = adminCode.getStringCellValue();
                    if (StringUtils.isNoneBlank(codeValue)
                            && StringUtils.isNoneBlank(adminCodeValue)
                            && codes.contains(adminCode.getStringCellValue())) {
                        results.add(new CodeDto(codeValue, adminCode.getStringCellValue()));
                    }
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return results;
    }
}
