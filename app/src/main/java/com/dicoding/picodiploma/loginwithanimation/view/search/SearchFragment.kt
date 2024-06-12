package com.dicoding.picodiploma.loginwithanimation.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivitySearchBinding
import com.dicoding.picodiploma.loginwithanimation.di.FakeData
import com.dicoding.picodiploma.loginwithanimation.view.ViewModelFactory
import com.dicoding.picodiploma.loginwithanimation.view.adapter.SearchIngredientsAdapter
import com.dicoding.picodiploma.loginwithanimation.view.ingredients_detail.IngredientsDetailFragment


class SearchFragment : Fragment() {
    private var _binding: ActivitySearchBinding? = null
    private val binding get() = _binding!!

    private val isFromSearch by lazy { arguments?.getBoolean(SearchActivity.IS_FROM_SEARCH, false) }

    private val viewModel by viewModels<SearchViewModel> {
        ViewModelFactory(requireContext())
    }

    private val searchIngredientsAdapter = SearchIngredientsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivitySearchBinding.inflate(inflater, container, false)

        checkIntentValues()
        observeViewModel()
        setSearchBar()
        setRecyclerView()
        setListeners()

        return binding.root
    }


    private fun checkIntentValues() {
        binding.apply {
            svAccounts.hint =
                if (isFromSearch == true) "Keluhan apa yang kamu alami?" else "Cari Tanaman Herbal"
            searchIngredientsAdapter.isFromSearch = isFromSearch ?: false
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner) {
                if (it) {
                    // Handle ketika Loading disini
                } else {
                    // Handle ketika selesai Loading disini
                }
            }

            searchedIngredients.observe(viewLifecycleOwner) {
                searchIngredientsAdapter.submitList(it)
                binding.emptyView.isVisible = it.isEmpty()
            }

            errorMessage.observe(viewLifecycleOwner) {
                // Handling error disini
            }
        }
    }

    private fun setSearchBar() {
        binding.svAccounts.addTextChangedListener(onTextChanged = { query, _, _, _ ->
            if (query.isNullOrEmpty()) {
                viewModel.searchedIngredients.postValue(FakeData.generateIngredients())
            } else {
                viewModel.searchIngredients(query.toString(), isFromSearch ?: false)
            }
        })
    }

    private fun setRecyclerView() {
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchIngredientsAdapter
        }
    }

    private fun setListeners() {
        binding.apply {
            searchIngredientsAdapter.onIngredientsClick = { ingredients ->
                val bundle = Bundle()
                bundle.putParcelable(IngredientsDetailFragment.EXTRA_INGREDIENTS, ingredients)
                findNavController().navigate(R.id.navigation_detail, bundle)
            }

            btnBack.setOnClickListener { requireActivity().onBackPressed() }
        }
    }


    private fun showLoading(isLoading: Boolean) {
        binding.progressbar.isVisible = isLoading
    }

    companion object {
        const val IS_FROM_SEARCH = "is_from_search"
    }
}