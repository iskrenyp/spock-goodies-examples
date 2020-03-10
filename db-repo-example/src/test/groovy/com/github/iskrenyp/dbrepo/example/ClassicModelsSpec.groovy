package com.github.iskrenyp.dbrepo.example

import com.github.iskrenyp.spockdbrepo.api.Repo
import spock.lang.Shared
import spock.lang.Specification
import static ClassicModelsSelect.ORDER_DETAILS_SELECT

class ClassicModelsSpec extends Specification {

    @Shared @Repo(name='classicmodels') def models
    @Shared ClassicModelsDb classicModelsDb = new ClassicModelsDb('classicmodels')

    def "Validate business logic in an app data store"() {
        given: "The business logic SQL select was created to validate the business requirement"
            String selectStatement = """
                                SELECT 
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
                                LIMIT 100;
                                """
        when: "The statement is executed"
            List<OrderDetailsDto> orderDetails = models.select(selectStatement) { resp -> new OrderDetailsDto(resp) }
        then: "The business logic for every returned record is validated"
            orderDetails.every { it.validated() }
    }

    def "Alternative approach for same test case (doing same thing with little abstraction)" () {
        expect: "The business logic for order details is validated"
            classicModelsDb
                    .run(ORDER_DETAILS_SELECT)
                    .every { it.validated() }
    }
}
