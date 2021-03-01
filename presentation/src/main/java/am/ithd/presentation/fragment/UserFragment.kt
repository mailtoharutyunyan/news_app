package am.ithd.presentation.fragment

import am.ithd.presentation.R
import am.ithd.presentation.viewmodel.UserViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


class UserFragment : Fragment() {

//    private lateinit var binding: CurrencyFragmentBinding

    private val viewModel: UserViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    companion object {

    }
}