package am.ithd.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
	val lastName: String,
	val id: Int? = null,
	val avatar: String,
	val firstName: String,
	val email: String
)
