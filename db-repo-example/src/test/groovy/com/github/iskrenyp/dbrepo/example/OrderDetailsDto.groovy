package com.github.iskrenyp.dbrepo.example

import com.github.iskrenyp.spockdbrepo.api.IValidatableEntity
import groovy.transform.TupleConstructor
import net.sf.oval.constraint.Assert
import net.sf.oval.constraint.NotEmpty
import net.sf.oval.constraint.NotNull

@TupleConstructor
class OrderDetailsDto implements IValidatableEntity {

    @NotNull
    Integer orderNumber
    @NotNull
    @Assert(expr = "_value < _this.requiredDate", lang = 'groovy')
    Date orderDate
    @NotNull
    @NotEmpty
    String customerName
    @NotNull
    Integer orderLineNumber
    @NotNull
    @NotEmpty
    String productName
    @NotNull
    @Assert(expr = "_value >= 6", lang = 'groovy')
    Integer quantityOrdered
    @NotNull
    Integer priceEach
    @NotNull
    Date requiredDate
    @Assert(expr = "_value != null ? _this.status in ['Shipped', 'Disputed', 'Resolved', 'Cancelled'] : _this.status in ['Cancelled', 'On Hold', 'In Process']", lang = 'groovy')
    Date shippedDate
    @NotNull
    @NotEmpty
    @Assert(expr = "_value in ['Shipped', 'Disputed', 'Resolved', 'Cancelled', 'On Hold', 'In Process']", lang = 'groovy')
    String status
}
