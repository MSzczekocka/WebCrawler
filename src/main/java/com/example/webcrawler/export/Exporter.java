package com.example.webcrawler.export;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import java.util.Set;

public class Exporter {

    public static void exportData(Set<String> urlsCrawled) throws Exception {
        Workbook workbook = new Workbook();
        Worksheet worksheet = workbook.getWorksheets().get(0);

        String[] arr = urlsCrawled.stream().toArray(String[]::new);
        worksheet.getCells().importArray(arr,0,0,true);

        workbook.save(System.getProperty("user.dir") + "\\WebExport.xlsx");
    }
}
