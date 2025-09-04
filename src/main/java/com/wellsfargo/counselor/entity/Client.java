package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "email", length = 160)
    private String email;

    @Column(name = "phone", length = 40)
    private String phone;

    @Column(name = "risk_profile", length = 60)
    private String riskProfile;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios = new ArrayList<>();

    public Client() {}

    public Client(FinancialAdvisor advisor, String firstName, String lastName, String email,
                  String phone, String riskProfile, LocalDate createdAt, List<Portfolio> portfolios) {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.riskProfile = riskProfile;
        this.createdAt = createdAt;
        if (portfolios != null) {
            this.portfolios = portfolios;
        }
    }

    public Long getClientId() { return clientId; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getRiskProfile() { return riskProfile; }
    public LocalDate getCreatedAt() { return createdAt; }
    public List<Portfolio> getPortfolios() { return portfolios; }

    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
