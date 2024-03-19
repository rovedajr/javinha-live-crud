package com.example.crud.controllers;

import com.example.crud.domain.enumerations.Affiliation;
import com.example.crud.domain.product.JusticeLeague;
import com.example.crud.domain.product.JusticeLeagueRepository;
import com.example.crud.domain.product.LegionOfDoom;
import com.example.crud.domain.product.LegionOfDoomRepository;
import com.example.crud.domain.product.ToysDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private JusticeLeagueRepository justiceLeagueRepository;

    private LegionOfDoomRepository legionOfDoomRepository;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){

        var allJusticeLeague = justiceLeagueRepository.findAll().stream().map(ToysDTO::from).toList();
        var allLegionOfDoom = legionOfDoomRepository.findAll().stream().map(ToysDTO::from).toList();

        var unifiedList = new ArrayList<ToysDTO>();

        unifiedList.addAll(allJusticeLeague);
        unifiedList.addAll(allLegionOfDoom);

        return ResponseEntity.ok(unifiedList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerProduct(@RequestBody @Valid ToysDTO data){

        if(Affiliation.JUSTICE_LEAGUE.equals(data.getAffiliation())){
            justiceLeagueRepository.save(JusticeLeague.builder()
                            .id(data.getId())
                            .name(data.getName())
                            .affiliation(data.getAffiliation())
                            .series(data.getSeries())
                            .year(data.getYear())
                            .power(data.getPower())
                    .build());
        }

        if(Affiliation.LEGION_OF_DOOM.equals(data.getAffiliation())){
            legionOfDoomRepository.save(LegionOfDoom.builder()
                    .id(data.getId())
                    .name(data.getName())
                    .affiliation(data.getAffiliation())
                    .series(data.getSeries())
                    .year(data.getYear())
                    .power(data.getPower())
                .build());
        }
    }

//    @PutMapping
//    public ResponseEntity<?> updateProduct(@RequestBody @Valid RequestProduct data){

//        Optional<Product> optionalProduct = repository.findById(data.id());
//
//        if(optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//
//            product.setName(data.name());
//
//            product.setPriceInCents(data.priceInCents());
//
//            Product updatedProduct = repository.save(product);
//            return ResponseEntity.ok(updatedProduct);
//
//        } else {
//            throw new EntityNotFoundException();
//        }

//    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<?> deleteProduct(@PathVariable String id){
//        Optional<Product> optionalProduct = repository.findById(id);
//        if(optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//            product.setActive(false);
//            return ResponseEntity.noContent().build();
//        } else {
//            return  ResponseEntity.notFound().build();
//        }
//
//    }
}