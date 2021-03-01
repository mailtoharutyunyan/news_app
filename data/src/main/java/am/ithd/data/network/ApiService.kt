package am.ithd.data.network

import am.ithd.data.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    fun getUsers(): Observable<List<User>>

    @POST("users")
    fun createUser(): Single<User>

}