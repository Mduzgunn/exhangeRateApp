package com.md.exhangeRateApp.controller;

import com.md.exhangeRateApp.dto.CurrencyDTO;
import com.md.exhangeRateApp.service.TCMBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api")
public class TCMBController {
    private final TCMBService tcmbService;
    private static final Logger LOG = LoggerFactory.getLogger(TCMBController.class);

    public TCMBController(TCMBService tcmbService) {
        this.tcmbService = tcmbService;
    }

    @GetMapping("/list/{date}")
    public ResponseEntity<?> retrieveKurList(@Valid @Size(min = 8)@PathVariable("date")String date) {
        List<CurrencyDTO> currencyList = tcmbService.createCurrency(date);
        return new ResponseEntity<>(currencyList, HttpStatus.OK);
    }

    @GetMapping("/saved/list")
    public ResponseEntity<?> retrieveKurList(){
        List<CurrencyDTO> currencyList = tcmbService.getAllCurrencys();
        return  new ResponseEntity<>(currencyList, HttpStatus.OK);
    }

}
