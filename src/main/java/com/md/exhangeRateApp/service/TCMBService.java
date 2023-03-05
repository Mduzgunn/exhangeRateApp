package com.md.exhangeRateApp.service;

import com.md.exhangeRateApp.dto.CurrencyDTO;
import com.md.exhangeRateApp.dto.ResponseTree;
import com.md.exhangeRateApp.dto.converter.CurrencyConverter;
import com.md.exhangeRateApp.entity.Currency;
import com.md.exhangeRateApp.repository.TCMBRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


@Service
public class TCMBService {
    private static final Logger LOG = LoggerFactory.getLogger(TCMBService.class);
    private final TCMBRepository repository;
    private final CurrencyConverter currencyConverter;

    private static ResponseTree responseTree;

    public TCMBService(TCMBRepository repository, CurrencyConverter currencyConverter){
        this.repository=repository;
        this.currencyConverter = currencyConverter;
    }

    protected List<Currency> getAllCurrencyList(){
        return repository.findAll();
    }
    public List<CurrencyDTO> getAllCurrencys(){
        return currencyConverter.convertToCurrencyDtoList(getAllCurrencyList());
    }

    @Transactional
    public List<CurrencyDTO> createCurrency(String date) {
        generator(date);
        List<Currency> currencyList = CurrencyConverter.convertToKurEntityList(responseTree.getCurrency());
        repository.saveAll(currencyList);
        List<CurrencyDTO> currencyDtoList = CurrencyConverter.convertToCurrencyDtoList(currencyList);
        return currencyDtoList;
    }


    public void generator(String dateIsoFormat) {
        String path = "https://tcmb.gov.tr/kurlar/";
        String seperator = "-";
        String date =dateIsoFormat.replace(seperator,"");

        String day =date.substring(6,8);
        String month =date.substring(4,6);
        String year =date.substring(0,4);
        String month_year =year + month;
        String day_month_year = day + month + year;

        if (Integer.parseInt(year) < 1996 ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Year value must be greater than or equal to 1996");
        }

        try {
            URL url = new URL(path + month_year + "/" + day_month_year + ".xml");
            unmarshaller(url);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }
    private void unmarshaller(URL url) {
        try {
            //Xml formattaki veriyi uygun Pojo sınıfına bind ediyoruz (unMarshaller)
            JAXBContext jaxbContext = JAXBContext.newInstance(ResponseTree.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            responseTree  = (ResponseTree) unmarshaller.unmarshal(url);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
