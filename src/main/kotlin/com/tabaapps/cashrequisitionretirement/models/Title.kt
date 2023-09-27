package com.tabaapps.cashrequisitionretirement.models

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
data class Title(
    @Column(nullable = false, unique = true)
    @NotNull
    var shortForm: String,

    @Column(nullable = false, unique = true)
    @NotNull
    var name: String,

    var isActive: Boolean,

    @OneToMany(mappedBy = "title")
    var employees: List<Employee>,

    @ManyToMany
    @JoinTable(
        name = "title_action",
        joinColumns = [JoinColumn(name = "title_id")],
        inverseJoinColumns = [JoinColumn(name = "action_id")]
    )
    var actions: List<Action>?
):BaseModel()
