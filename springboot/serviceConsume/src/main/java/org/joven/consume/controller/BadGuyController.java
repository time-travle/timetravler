package org.joven.consume.controller;

import lombok.extern.log4j.Log4j2;
import org.joven.consume.component.BadGuyService;
import org.joven.consume.entity.ReturnResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * http://localhost:8161/api/badGuy/quotations/5
 * http://localhost:8161/api/badGuy/quotations
 */
@RestController
@Log4j2
@RequestMapping("/api/badGuy")
public class BadGuyController {

    @Resource
    private BadGuyService badGuyService;

    @GetMapping({"quotations", "quotations/{count}"})
    public ReturnResult<List<String>> getBadGuyQuotations(@PathVariable(value = "count", required = false) Integer count) {
        ReturnResult<List<String>> result = new ReturnResult<>();
        try {
            List<String> resultStrings = badGuyService.getQuotations(count);
            result.setData(resultStrings);
        } catch (Exception e) {
            log.error("Failed to get bad guy quotations.", e);
            result.setErrorMessage("error");
        }
        return result;
    }

}
