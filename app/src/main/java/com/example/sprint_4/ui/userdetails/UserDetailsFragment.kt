package com.example.sprint_4.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.sprint_4.databinding.FragmentUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding
    private val args: UserDetailsFragmentArgs by navArgs()
    private val viewModel: UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = args.id

        viewModel.getUserById(userId).observe(viewLifecycleOwner, Observer { user ->
            user?.let {
                binding.tvUserName.text = it.name
                binding.tvUserFavColor.text = it.favoriteColor
                binding.tvUserBirthdate.text = it.birthdate
                binding.tvFavNumber.text = it.favoriteNumber.toString()
                binding.tvActualLocationValue.text = it.actualPosition.toString()
                //binding.tvUserFavCity.text = it.favoriteCity.toString()
            }
        })
    }

}
