package com.estukalov.assessment.controller;

import com.estukalov.assessment.domain.Item;
import com.estukalov.assessment.service.ItemNormalizationService;
import com.estukalov.assessment.service.ItemValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemValidationController {

    @Autowired
    ItemValidationService itemValidationService;

    @Autowired
    ItemNormalizationService itemNormalizationService;


    @PostMapping("/validate")
    public HttpEntity<Item> validate(@RequestBody Item item) {
        itemNormalizationService.normalize(item);
        itemValidationService.validate(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
