package br.com.dio.app.repositories.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.app.repositories.data.model.Repositores
import br.com.dio.app.repositories.databinding.ActivityMainBinding
import br.com.dio.app.repositories.databinding.ItemRepoBinding
import com.bumptech.glide.Glide

class RepositoryListAdapter : ListAdapter<Repositores, RepositoryListAdapter.ViewModel>(DiffCallback()) {

    inner class ViewModel(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Repositores){
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description
            binding.tvRepoLanguage.text = item.language
            binding.cpRepoQtdStars.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflate, parent, false)
        return ViewModel(binding)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<Repositores>() {
    override fun areItemsTheSame(oldItem: Repositores, newItem: Repositores) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repositores, newItem: Repositores) = oldItem.id == newItem.id

}
