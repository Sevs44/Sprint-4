package com.example.sprint_4.ui.adduser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sprint_4.databinding.FragmentAddUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment() {

    private lateinit var binding: FragmentAddUserBinding

    private val viewModel: AddUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSaveUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val favoriteColor = binding.etFavColor.text.toString()
            val birthdate = binding.etBirthdate.text.toString()
            //val favoriteCity = Location(binding.etFavoriteCityLat.text.toString().toDouble(), binding.etFavoriteCityLong.text.toString().toDouble())
            val favoriteNumber = binding.etFavNumber.text.toString().toInt()
            //val actualPosition = Location(binding.etActualPositionLat.text.toString().toDouble(), binding.etActualPositionLong.text.toString().toDouble())

            val user = UserEntity(
                name = name,
                favoriteColor = favoriteColor,
                birthdate = birthdate,
                favoriteCity = favoriteCity,
                favoriteNumber = favoriteNumber,
                actualPosition = actualPosition
            )

            viewModel.insert(user)
            findNavController().navigateUp() // Navigate back to the user list
        }
    }
}
