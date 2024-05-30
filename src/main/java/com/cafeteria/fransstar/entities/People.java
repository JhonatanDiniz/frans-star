package com.cafeteria.fransstar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active=true;
    private String name;
    @CPF
    private String cpf;
    @Email
    private String email;
    private String phone;

    public void updateData(People obj) {
        if (obj.name != null) {
            this.name = obj.name;
        }

        if (obj.cpf != null) {
            this.cpf = obj.cpf;
        }

        if (obj.email != null) {
            this.email = obj.email;
        }

        if (obj.phone != null) {
            this.phone = obj.phone;
        }
    }
    public void delete(){
        this.active = false;
    }

}