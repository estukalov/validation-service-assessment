package com.estukalov.assessment.service;

import com.estukalov.assessment.domain.Condition;
import com.estukalov.assessment.domain.Item;
import com.estukalov.assessment.domain.ItemBuilder;
import com.estukalov.assessment.domain.ItemSpecificsBuilder;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ItemNormalizationServiceImplTest {
    ItemNormalizationServiceImpl itemNormalizationService = new ItemNormalizationServiceImpl();

    @Test
    public void verifyNormalization() {
        Item item = new ItemBuilder().setCondition(Condition.NEW)
                .setItemSpecifics(new ItemSpecificsBuilder()
                        .setType("armrest")
                        .setManufacturerPartNumber("honda-123").createItemSpecifics()).createItem();

        itemNormalizationService.normalize(item);

        assertThat(item.getItemSpecifics().getType(), is("Armrest"));
        assertThat(item.getItemSpecifics().getManufacturerPartNumber(), is("Honda-123"));
    }

}