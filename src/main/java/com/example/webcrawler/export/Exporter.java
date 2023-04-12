package com.example.webcrawler.export;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.example.webcrawler.entity.VisitedUrl;

import java.util.List;

public class Exporter {

    public static void exportData(List<VisitedUrl> urlsCrawled) throws Exception {
        Workbook workbook = new Workbook();
        Worksheet worksheet = workbook.getWorksheets().get(0);

        String[] arr = urlsCrawled.stream().map(VisitedUrl::getVisitedUrl).toArray(String[]::new);
        worksheet.getCells().importArray(arr,0,0,true);

        workbook.save(System.getProperty("user.dir") + "\\WebExport.xlsx");
    }
}
