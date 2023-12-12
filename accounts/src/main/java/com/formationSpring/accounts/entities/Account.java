package com.formationSpring.accounts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "accounts")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Account extends BaseEntity {

    @Column(name = "customer_id")
    @Id
    private Long id;
    @Column(name="account_number")

    private String accountNumber;
    private String accountType;
    private String branchAddress;

}
