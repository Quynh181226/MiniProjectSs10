package com.Ss10.MiniProject2.equipmentborrowingmana.custom_validator;

import com.Ss10.MiniProject2.equipmentborrowingmana.model.dto.EquipmentFormRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ReturnDateValidator implements ConstraintValidator<ReturnDateValid, EquipmentFormRequest> {
    @Override
    public boolean isValid(EquipmentFormRequest request, ConstraintValidatorContext context) {
        if (request.getBorrowDate() == null || request.getReturnDate() == null) {
            return true;
        }

        boolean isValid = request.getReturnDate().isAfter(request.getBorrowDate());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("returnDate")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
