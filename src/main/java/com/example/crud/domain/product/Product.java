package com.example.crud.domain.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer priceInCents;

    private Boolean active;

    public Product(@NotNull RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.priceInCents = requestProduct.priceInCents();
        this.active = true;
    }
}