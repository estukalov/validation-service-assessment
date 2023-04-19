package com.estukalov.assessment.service;

import com.estukalov.assessment.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ItemNormalizationServiceImpl implements ItemNormalizationService {
    Logger logger = LoggerFactory.getLogger(ItemNormalizationServiceImpl.class);

    @Override
    public void normalize(Item item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.info("InterruptedException was thrown: " + e.getMessage());
            throw new RuntimeException(e);
        }

        final String manufacturerPartNumber = item.getItemSpecifics().getManufacturerPartNumber();

        if (! manufacturerPartNumber.isEmpty()) {
            item.getItemSpecifics().setManufacturerPartNumber(capitalizeString(manufacturerPartNumber));
        }

        final String type = item.getItemSpecifics().getType();
        if (! type.isEmpty()) {
            item.getItemSpecifics().setType(capitalizeString(type));
        }
    }

    private String capitalizeString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
