package com.danielcunha.zaz.ui.adPost.rating

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentNewRatingBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class NewRatingFragment : BaseFragment<NewRatingViewModel, FragmentNewRatingBinding>() {

    override val viewModel: NewRatingViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_new_rating
    private val navArgs: NewRatingFragmentArgs by navArgs()

    override fun setupFragment() {
        binding.rbStars.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            ratingBar.rating = rating
        }
    }

    override fun setupViewModel() {
        viewModel.setup(navArgs.adTitle)
    }
}