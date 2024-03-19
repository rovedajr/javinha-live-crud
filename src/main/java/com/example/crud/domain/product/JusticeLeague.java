package com.example.crud.domain.product;

import com.example.crud.domain.enumerations.Affiliation;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "JusticeLeague")
public class JusticeLeague {

    @MongoId
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Affiliation affiliation;

    private int series;

    private int year;

    private String power;
}