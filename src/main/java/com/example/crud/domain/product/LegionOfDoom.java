package com.example.crud.domain.product;

import com.example.crud.domain.enumerations.Affiliation;
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
@Document(collection = "LegionOfDoom")
public class LegionOfDoom {

    @MongoId
    private String id;

    private String name;


    private Affiliation affiliation;

    private Integer series;

    private Integer year;

    private String power;
}