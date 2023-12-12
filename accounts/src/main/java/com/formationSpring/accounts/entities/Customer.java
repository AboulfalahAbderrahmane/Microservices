package com.formationSpring.accounts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "customer")
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Customer extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    @Id
    private Long id;
    private String name;
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
}
