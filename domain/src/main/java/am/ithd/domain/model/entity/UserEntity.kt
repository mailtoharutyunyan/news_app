package am.ithd.domain.model.entity

import am.ithd.domain.model.Email

data class UserEntity(
	val lastName: String,
	val id: Int? = null,
	val avatar: String,
	val firstName: String,
	val email: Email
)
