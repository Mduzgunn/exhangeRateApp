package com.md.exhangeRateApp.entity

import jakarta.persistence.*
import org.hibernate.Hibernate

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@Entity
@XmlRootElement
data class Currency @JvmOverloads constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    var currencyId: Int?,
    @Column(name = "Banknote_Selling")
    var banknoteSelling: Double? = 0.00,
    @XmlElement
    var crossOrder: Int,
    @XmlElement
    var forexSelling: Double?,
    @XmlElement
    var forexBuying: Double?,
    @Column(name = "Banknote_Buying")
    var banknoteBuying: Double?,
    @Column(name = "Unit")
    var unit: Int? =null,
    @XmlElement
    var name: String?,
    )
{

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Currency

        return currencyId != null && currencyId == other.currencyId
    }

    override fun hashCode(): Int = javaClass.hashCode()
}