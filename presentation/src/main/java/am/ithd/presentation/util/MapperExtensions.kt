package am.ithd.presentation.util

import am.ithd.domain.model.entity.UserEntity
import am.ithd.presentation.model.UserPresentation

fun UserEntity.toUserPresentation() =
    UserPresentation(
        lastName, id, avatar, firstName, email
    )