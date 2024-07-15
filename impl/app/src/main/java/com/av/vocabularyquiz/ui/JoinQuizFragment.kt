package com.av.vocabularyquiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.av.vocabularyquiz.R
import com.av.vocabularyquiz.databinding.FragmentJoinQuizBinding
import com.av.vocabularyquiz.presentation.JoinQuizViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JoinQuizFragment : Fragment() {

    private val viewModel: JoinQuizViewModel by viewModels()
    private lateinit var binding: FragmentJoinQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJoinQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.joinQuizButton.setOnClickListener {
            val quizId = binding.quizIdInput.text.toString()
            viewModel.joinQuiz(quizId)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.joinQuizState.collect { result ->
                result?.let {
                    if (it.isSuccess) {
                        findNavController().navigate(R.id.action_joinQuizFragment_to_quizScreen)
                    } else {
                        Toast.makeText(context, "Failed to join quiz", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}