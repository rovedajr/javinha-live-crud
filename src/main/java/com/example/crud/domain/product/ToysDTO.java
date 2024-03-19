package com.example.crud.domain.product;

import com.example.crud.domain.enumerations.Affiliation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToysDTO {

    private String id;

    private String name;

    private Affiliation affiliation;

    private int series;

    private int year;

    private String power;

    public static ToysDTO from(JusticeLeague justiceLeague) {
        return ToysDTO.builder()
                .id(justiceLeague.getId())
                .name(justiceLeague.getName())
                .affiliation(justiceLeague.getAffiliation())
                .series(justiceLeague.getSeries())
                .year(justiceLeague.getYear())
                .power(justiceLeague.getPower())
            .build();
    }

    public static ToysDTO from(LegionOfDoom legionOfDoom) {
        return ToysDTO.builder()
                .id(legionOfDoom.getId())
                .name(legionOfDoom.getName())
                .affiliation(legionOfDoom.getAffiliation())
                .series(legionOfDoom.getSeries())
                .year(legionOfDoom.getYear())
                .power(legionOfDoom.getPower())
                .build();
    }

}