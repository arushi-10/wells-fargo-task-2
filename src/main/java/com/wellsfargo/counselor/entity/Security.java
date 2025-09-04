package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "securities")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_id")
    private Long securityId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "category", length = 60)
    private String category;

    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Default constructor
    public Security() {}

    // Parameterized constructor (without id, which is auto-generated)
    public Security(Portfolio portfolio, String name, String category,
                    Date purchaseDate, Double purchasePrice, Integer quantity) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Getters
    public Long getSecurityId() { return securityId; }
    public Portfolio getPortfolio() { return portfolio; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Date getPurchaseDate() { return purchaseDate; }
    public Double getPurchasePrice() { return purchasePrice; }
    public Integer getQuantity() { return quantity; }

    // Setters
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}