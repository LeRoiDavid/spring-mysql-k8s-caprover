package com.mourchidtech.springcaprover.controllers;


import com.mourchidtech.springcaprover.entities.Post;
import com.mourchidtech.springcaprover.services.ExcelGenerator;
import com.mourchidtech.springcaprover.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostClassicController {

    private final PostService service;
    private final ExcelGenerator excelGenerator;

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

//        List<Post> listOfStudents = service.fetchAll();
//        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        excelGenerator.generateExcelFile(response, service.fetchAll());
    }
}
