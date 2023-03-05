package com.md.exhangeRateApp.dto

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Currency")
data class CurrencyDTO @JvmOverloads constructor(
    @XmlElement(name = "CurrencyId")
    var currencyId: Int?,
    @XmlElement(name = "BanknoteSelling")
    var banknoteSelling: Double?,
    @XmlElement(name = "CrossOrder")
    var crossOrder: Int?,
    @XmlElement(name = "ForexSelling")
    var forexSelling: Double?,
    @XmlElement(name = "ForexBuying")
    var forexBuying: Double?,
    @XmlElement(name = "BanknoteBuying")
    var banknoteBuying: Double?,
    @XmlElement(name = "Unit")
    var unit: Int?,
    @XmlElement(name = "Name")
    var name: String?
)