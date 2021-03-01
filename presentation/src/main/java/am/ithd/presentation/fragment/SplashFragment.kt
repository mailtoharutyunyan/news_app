package am.ithd.presentation.fragment

import am.ithd.presentation.R
import am.ithd.presentation.util.delayed
import am.ithd.presentation.viewmodel.UserViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_fragment) {

    private val viewModel: UserViewModel by activityViewModels()

    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SplashFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onErrorLiveData.observe(viewLifecycleOwner, {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_splashFragment_to_logInFragment)
        })
        viewModel.onCompleteLiveData.observe(viewLifecycleOwner, {
            {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_splashFragment_to_currencyFragment)
            }.delayed(1000)
        })
    }
}