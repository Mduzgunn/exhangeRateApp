package com.md.exhangeRateApp.dto.converter;

import com.md.exhangeRateApp.dto.CurrencyDTO;
import com.md.exhangeRateApp.dto.CurrencyParse;
import com.md.exhangeRateApp.entity.Currency;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyConverter {

    public static CurrencyDTO convertToCurrencyDto(Currency from) {
        return new CurrencyDTO(
                from.getCurrencyId(),
                from.getBanknoteSelling(),
                from.getCrossOrder(),
                from.getForexSelling(),
                from.getForexBuying(),
                from.getBanknoteBuying(),
                from.getUnit(),
                from.getName()
        );
    }

    public static Currency convertToKurEntity(CurrencyParse currencyParse) {
        Currency currency = new Currency();
        currency.setName(currencyParse.getIsim());
        currency.setUnit(currencyParse.getUnit());
        currency.setBanknoteBuying(currencyParse.getBanknoteBuying());
        currency.setBanknoteSelling(currencyParse.getBanknoteSelling());
        currency.setForexBuying(currencyParse.getForexBuying());
        currency.setForexSelling(currencyParse.getForexSelling());
        return currency;
    }

    public static List<CurrencyDTO> convertToCurrencyDtoList(List<Currency> currencyList) {
        List<CurrencyDTO> currencyDtoList = new ArrayList<>();
        for (Currency item : currencyList) {
            currencyDtoList.add(convertToCurrencyDto(item));
        }
        return currencyDtoList;
    }

    public static List<Currency> convertToKurEntityList(List<CurrencyParse> currencyParseList) {
        List<Currency> currencyList = new ArrayList<>();
        for (CurrencyParse currencyParse : currencyParseList) {
            currencyList.add(convertToKurEntity(currencyParse));
        }
        return currencyList;
    }
}
