package com.poi.apachepoiexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ExcelController {

    private static String FILE_NAME = "blablareport.xls";
    private GenerateExcel generateExcel = new GenerateExcel();

    @GetMapping("/generate")
    public void generateExcelFile(HttpServletRequest req, HttpServletResponse res){

        byte[] content = generateExcel.doShit();

        res.setContentType("application/vnd.ms-excel");
        res.setHeader("Content-disposition", "attachment; filename=" + FILE_NAME);
        try {
            ServletOutputStream out = res.getOutputStream();
            out.write(content);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
