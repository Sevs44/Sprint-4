package com.example.sprint_4.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint_4.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding

    private val userListViewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserListAdapter { user ->
            val action =
                UserListFragmentDirections.actionFragmentUserListToFragmentUserDetails(user.id)
            findNavController().navigate(action)
        }

        binding.rvUserList.layoutManager = LinearLayoutManager(context)
        binding.rvUserList.adapter = adapter

        userListViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            users?.let { adapter.submitList(it) }
        })

        binding.btnAdd.setOnClickListener {
            val action = UserListFragmentDirections.actionFragmentUserListToFragmentAddUser2()
            findNavController().navigate(action)
        }
    }
}
