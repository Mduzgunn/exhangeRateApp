package com.md.exhangeRateApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currency")
public class CurrencyParse {
    @XmlElement(name = "CurrencyCode")
    @JsonProperty("CurrencyCode")
    private String CurrencyCode;


    @XmlElement(name = "BanknoteSelling")
    @JsonProperty("BanknoteSelling")
    private Double BanknoteSelling;


    @XmlElement(name = "CrossOrder")
    @JsonProperty("CrossOrder")
    private Integer CrossOrder;


    @XmlElement(name = "ForexSelling")
    @JsonProperty("ForexSelling")
    private Double ForexSelling;


    @XmlElement(name = "BanknoteBuying")
    @JsonProperty("BanknoteBuying")
    private Double BanknoteBuying;


    @XmlElement(name = "Unit")
    @JsonProperty("Unit")
    private Integer Unit;


    @XmlElement(name = "Isim")
    @JsonProperty("Isim")
    private String Isim;


    @XmlElement(name = "ForexBuying")
    @JsonProperty("ForexBuying")
    private Double ForexBuying;


    public CurrencyParse(String currencyCode, Double banknoteSelling, Integer crossOrder,
                         Double forexSelling, Double banknoteBuying, Integer unit,
                         String isim, Double forexBuying) {
        CurrencyCode = currencyCode;
        BanknoteSelling = banknoteSelling;
        CrossOrder = crossOrder;
        ForexSelling = forexSelling;
        BanknoteBuying = banknoteBuying;
        Unit = unit;
        Isim = isim;
        ForexBuying = forexBuying;
    }

    public CurrencyParse() {
    }

    @Override
    public String toString() {
        return "CurrencyParse{" +
                "CurrencyCode='" + CurrencyCode + '\'' +
                ", BanknoteSelling=" + BanknoteSelling +
                ", CrossOrder=" + CrossOrder +
                ", ForexSelling=" + ForexSelling +
                ", BanknoteBuying=" + BanknoteBuying +
                ", Unit=" + Unit +
                ", Isim='" + Isim + '\'' +
                ", ForexBuying=" + ForexBuying +
                '}';
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public Double getBanknoteSelling() {
        return BanknoteSelling;
    }

    public void setBanknoteSelling(Double banknoteSelling) {
        BanknoteSelling = banknoteSelling;
    }

    public Integer getCrossOrder() {
        return CrossOrder;
    }

    public void setCrossOrder(Integer crossOrder) {
        CrossOrder = crossOrder;
    }

    public Double getForexSelling() {
        return ForexSelling;
    }

    public void setForexSelling(Double forexSelling) {
        ForexSelling = forexSelling;
    }

    public Double getBanknoteBuying() {
        return BanknoteBuying;
    }

    public void setBanknoteBuying(Double banknoteBuying) {
        BanknoteBuying = banknoteBuying;
    }

    public Integer getUnit() {
        return Unit;
    }

    public void setUnit(Integer unit) {
        Unit = unit;
    }

    public String getIsim() {
        return Isim;
    }

    public void setIsim(String isim) {
        Isim = isim;
    }

    public Double getForexBuying() {
        return ForexBuying;
    }

    public void setForexBuying(Double forexBuying) {
        ForexBuying = forexBuying;
    }
}
