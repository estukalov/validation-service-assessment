package com.estukalov.assessment.controller;

import com.estukalov.assessment.AssessmentApplication;
import com.estukalov.assessment.domain.Condition;
import com.estukalov.assessment.domain.Item;
import com.estukalov.assessment.domain.ItemBuilder;
import com.estukalov.assessment.domain.ItemSpecificsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AssessmentApplication.class)
@AutoConfigureMockMvc
class ItemValidationControllerTest {
    @Autowired
    private ItemValidationController itemValidationController;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void verifySuccessfulValidationForNewItem() throws Exception {
        Item item = createTestItem();
        String itemString = objectMapper.writeValueAsString(item);
        performValidationApiCall(itemString)
                .andExpect(status().isOk());
    }

    @Test
    public void verifyManufacturerPartNumberRequiredForNewItem() throws Exception {
        Item item = createTestItem();
        item.getItemSpecifics().setManufacturerPartNumber("");
        String itemString = objectMapper.writeValueAsString(item);
        performValidationApiCall(itemString)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].message").value("Manufacturer Part Number is null for a new item"));
    }

    @Test
    public void verifyManufacturerPartNumberNotRequiredForUsedItem() throws Exception {
        Item item = createTestItem();
        item.setCondition(Condition.USED);
        item.getItemSpecifics().setManufacturerPartNumber("");
        String itemString = objectMapper.writeValueAsString(item);
        performValidationApiCall(itemString)
                .andExpect(status().isOk());
    }

    @Test
    public void verifyMultipleErrors() throws Exception {
        Item item = createTestItem();
        item.setCondition(Condition.NEW);
        item.getItemSpecifics().setManufacturerPartNumber("");
        item.setTitle("");
        String itemString = objectMapper.writeValueAsString(item);
        performValidationApiCall(itemString)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.length()").value(2));
    }

    private ResultActions performValidationApiCall(String content) throws Exception {
        return mockMvc.perform(post("/items/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content));
    }

    private Item createTestItem() {
        return new ItemBuilder().setCondition(Condition.NEW)
                .setTitle("oem armrest")
                .setItemSpecifics(new ItemSpecificsBuilder()
                        .setType("armrest")
                        .setManufacturerPartNumber("honda-123")
                        .createItemSpecifics())
                .createItem();
    }
}