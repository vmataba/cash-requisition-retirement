package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
data class Action(
    @Column(nullable = false)
    @NotNull
    var type: ActionType,

    @Column(nullable = false, unique = true)
    @NotNull
    var name: String,

    @Column(nullable = false, unique = true)
    @NotNull
    var pastForm: String,

    var color: String?,

    @ManyToMany
    @JoinTable(
        name = "title_action",
        joinColumns = [JoinColumn(name = "action_id")],
        inverseJoinColumns = [JoinColumn(name = "title_id")]
    )
    var titles: List<Title>?

) : BaseModel()
