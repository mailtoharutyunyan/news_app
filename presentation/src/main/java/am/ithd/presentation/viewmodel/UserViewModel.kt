package am.ithd.presentation.viewmodel

import am.ithd.data.manager.SessionManager
import am.ithd.domain.usecase.UserUseCase
import am.ithd.presentation.model.UserPresentation
import am.ithd.presentation.util.toUserPresentation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {

    val onErrorLiveData = MutableLiveData<Throwable>()
    val onCompleteLiveData = MutableLiveData<Boolean>()
    val userLiveData = MutableLiveData<MutableList<UserPresentation>>()

    private val bag = CompositeDisposable()

    fun getUsers() {
        userUseCase.invoke().delay(5, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ user ->
                val value = userLiveData.value ?: mutableListOf()
                value.addAll(user.map { it.toUserPresentation() })
                userLiveData.value = value
                onCompleteLiveData.value = true
            }, {
                onErrorLiveData.value = it
            }).let {
                bag.add(it)
            }
    }


}