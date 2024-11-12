package com.launderup.LaunderUp_Backend.controllers;

import com.launderup.LaunderUp_Backend.models.Partner;
import com.launderup.LaunderUp_Backend.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerRepository partnerRepository;

    @GetMapping("/{id}")
    public Mono<Partner> getPartnerById(@PathVariable Long id){
        return partnerRepository.findById(id);
    }

    @GetMapping
    public Flux<Partner> getAllPartners(){
        return partnerRepository.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Partner> updatePartner(@PathVariable Long id, @RequestBody Partner partnerDetails){
        return partnerRepository.findById(id).flatMap(existingPartner -> {
            existingPartner.setShopName(partnerDetails.getShopName());
            existingPartner.setShopAddress(partnerDetails.getShopAddress());
            return partnerRepository.save(existingPartner);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePartner(@PathVariable Long id){
        return partnerRepository.deleteById(id);
    }
}
