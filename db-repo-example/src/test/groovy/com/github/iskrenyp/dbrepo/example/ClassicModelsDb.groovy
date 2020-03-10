package com.github.iskrenyp.dbrepo.example

import com.github.iskrenyp.spockdbrepo.api.IValidatableEntity
import com.github.iskrenyp.spockdbrepo.api.SqlDataStore
import groovy.transform.InheritConstructors

@InheritConstructors
class ClassicModelsDb extends SqlDataStore{

    List<IValidatableEntity> run(ClassicModelsSelect validation) {
        select(validation.statement, validation.executor)
    }
}
