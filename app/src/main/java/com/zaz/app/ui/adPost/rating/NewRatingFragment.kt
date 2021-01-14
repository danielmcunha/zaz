package com.zaz.app.ui.adPost.rating

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.zaz.app.R
import com.zaz.app.databinding.FragmentNewRatingBinding
import com.zaz.app.ui.core.base.BaseFragment

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