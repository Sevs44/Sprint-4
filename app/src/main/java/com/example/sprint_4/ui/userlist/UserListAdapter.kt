package com.example.sprint_4.ui.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint_4.data.UserEntity
import com.example.sprint_4.databinding.ItemRecyclerviewListNameBinding

class UserListAdapter(private val onItemClicked: (UserEntity) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var users: List<UserEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRecyclerviewListNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, onItemClicked)
    }

    override fun getItemCount(): Int = users.size

    fun submitList(userList: List<UserEntity>) {
        users = userList
        notifyDataSetChanged()
    }

    class UserViewHolder(private val binding: ItemRecyclerviewListNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserEntity, onItemClicked: (UserEntity) -> Unit) {
            binding.tvName.text = user.name
            binding.root.setOnClickListener {
                onItemClicked(user)
            }
        }
    }
}