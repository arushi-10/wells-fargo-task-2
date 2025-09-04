package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id",nullable = false)
    private FinancialAdvisor advisor;

    @Column(name = "first_name",nullable=false,length=100)
    private String firstName;
    @Column(name = "last_name",nullable=false,length=100)
    private String lastName;
    @Column(nullable=false,unique = true,length=150)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(name = "risk_profile",length=50)
    private String riskProfile;
    @Column(name = "created_at",nullable=false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Portfolio> portfolios;


    // Default constructor
    public Client() {}

    // Parameterized constructor
    public Client(FinancialAdvisor advisor, String firstName, String lastName,
                  String email, String phone, String riskProfile, LocalDateTime createdAt) {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.riskProfile = riskProfile;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public Long getClientId() { return clientId; }

    public FinancialAdvisor getAdvisor() { return advisor; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRiskProfile() { return riskProfile; }
    public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
