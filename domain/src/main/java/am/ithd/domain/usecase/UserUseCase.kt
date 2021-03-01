package am.ithd.domain.usecase

import am.ithd.domain.model.entity.UserEntity
import am.ithd.domain.repository.Repository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UserUseCase @Inject constructor(private val repository: Repository) {

    private val error: Single<UserEntity>? = null

    fun createUser(userEntity: UserEntity): Single<UserEntity>? {
        if (!userEntity.email.isValid()) {
            return null
        } else if (userEntity.firstName.isNotEmpty())
            return error!!
        return repository.createUser(userEntity)
    }

    operator fun invoke(): Observable<List<UserEntity>> =
        repository.getUsers()

}