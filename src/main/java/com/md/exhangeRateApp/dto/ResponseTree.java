package com.md.exhangeRateApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Tarih_Date")
public class ResponseTree {
    @XmlElement(name = "Currency")
    @JsonProperty("Currency")
    private List<CurrencyParse> Currency;

    @XmlElement(name = "Bulten_No")
    @JsonProperty("Bulten_No")
    private String Bulten_No;

    @XmlElement(name = "Date")
    @JsonProperty("Date")
    private String Date;

    @XmlElement(name = "Tarih")
    @JsonProperty("Tarih")
    private String Tarih;

    public ResponseTree(List<CurrencyParse> currency, String bulten_No, String date, String tarih) {
        Currency = currency;
        Bulten_No = bulten_No;
        Date = date;
        Tarih = tarih;
    }

    public ResponseTree() {
    }

    public List<CurrencyParse> getCurrency() {
        return Currency;
    }

    public void setCurrency(List<CurrencyParse> currency) {
        Currency = currency;
    }

    public String getBulten_No() {
        return Bulten_No;
    }

    public void setBulten_No(String bulten_No) {
        Bulten_No = bulten_No;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

}
