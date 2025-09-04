package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.util.List;

import java.util.ArrayList;


@Entity
@Table(name = "financial_advisors")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advisor_id")
    private Long advisorId;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "email", nullable = false, length = 160, unique = true)
    private String email;

    @Column(name = "phone", length = 40)
    private String phone;

    @Column(name = "status", length = 30)
    private String status;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    // JPA requires a no-arg constructor
    public FinancialAdvisor() {}

    // Constructor initializing all instance variables except id (auto-generated)
    public FinancialAdvisor(String name, String email, String phone, String status, List<Client> clients) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        if (clients != null) {
            this.clients = clients;
        }
    }

    // Getters (no setter for id required)
    public Long getAdvisorId() { return advisorId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStatus() { return status; }
    public List<Client> getClients() { return clients; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setStatus(String status) { this.status = status; }
    public void setClients(List<Client> clients) { this.clients = clients; }

    // Convenience helpers
    public void addClient(Client client) {
        clients.add(client);
        client.setAdvisor(this);
    }
    public void removeClient(Client client) {
        clients.remove(client);
        client.setAdvisor(null);
    }
}