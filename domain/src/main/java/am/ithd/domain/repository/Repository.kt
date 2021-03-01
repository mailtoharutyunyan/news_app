package am.ithd.domain.repository

import am.ithd.domain.model.entity.UserEntity
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {
    fun getUsers(): Observable<List<UserEntity>>
    fun createUser(userEntity: UserEntity): Single<UserEntity>
}