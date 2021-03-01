package am.ithd.presentation.model

import am.ithd.domain.model.Email

data class UserPresentation(
    val lastName: String,
    val id: Int? = null,
    val avatar: String,
    val firstName: String,
    val email: Email
)