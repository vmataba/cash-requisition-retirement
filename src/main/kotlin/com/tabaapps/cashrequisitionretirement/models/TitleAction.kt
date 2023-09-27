package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity(name = "title_action")
data class TitleAction(
    @ManyToOne(optional = false)
    var title: Title,

    @ManyToOne(optional = false)
    var action: Action,

    var isActive: Boolean
) : BaseModel()
