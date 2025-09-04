package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "portfolio_name", nullable = false, length = 120)
    private String portfolioName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    // Default constructor
    public Portfolio() {}

    // Parameterized constructor
    public Portfolio(Client client, String portfolioName, Date createdDate, List<Security> securities) {
        this.client = client;
        this.portfolioName = portfolioName;
        this.createdDate = createdDate;
        if (securities != null) {
            this.securities = securities;
        }
    }

    // Getters
    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public String getPortfolioName() { return portfolioName; }
    public Date getCreatedDate() { return createdDate; }
    public List<Security> getSecurities() { return securities; }

    // Setters
    public void setClient(Client client) { this.client = client; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
