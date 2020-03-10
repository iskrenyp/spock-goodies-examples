package com.github.iskrenyp.dbrepo.example

import com.github.iskrenyp.spockdbrepo.api.IValidatableEntity

enum ClassicModelsSelect {

    ORDER_DETAILS_SELECT("""SELECT 
                                    orderNumber,
                                    orderDate,
                                    customerName,
                                    orderLineNumber,
                                    productName,
                                    quantityOrdered,
                                    priceEach,
                                    requiredDate,
                                    shippedDate,
                                    status 
                                FROM
                                    orders
                                INNER JOIN orderdetails 
                                    USING (orderNumber)
                                INNER JOIN products 
                                    USING (productCode)
                                INNER JOIN customers 
                                    USING (customerNumber)
                                ORDER BY 
                                    orderNumber, 
                                    orderLineNumber
                                LIMIT 100;""", { resp -> new OrderDetailsDto(resp) })

    String statement
    Closure<IValidatableEntity> mapper

    ClassicModelsSelect(String statement, Closure<IValidatableEntity> mapper) {
        this.statement = statement
        this.mapper = mapper
    }
}