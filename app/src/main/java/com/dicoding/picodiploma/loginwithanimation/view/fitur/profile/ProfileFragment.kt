package com.dicoding.picodiploma.loginwithanimation.view.fitur.profile

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import com.dicoding.picodiploma.loginwithanimation.databinding.FragmentProfileBinding
import com.dicoding.picodiploma.loginwithanimation.di.Result
import com.dicoding.picodiploma.loginwithanimation.view.ViewModelFactory
import com.dicoding.picodiploma.loginwithanimation.view.customview.LoadingDialog
import com.github.dhaval2404.imagepicker.ImagePicker

class ProfileFragment : Fragment() {

    private var editMode: Boolean = false
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel by viewModels<ProfileViewModel> {
            ViewModelFactory(requireContext())
        }

        val loadingDialog = LoadingDialog(requireContext())
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val nameTextView: TextView = binding.profileName
        val emailTextView: TextView = binding.profileEmail

        profileViewModel.getUser().observe(requireActivity()) { result ->
            when (result) {
                is Result.Loading -> {
                    loadingDialog.show()
                }
                is Result.Success -> {
                    loadingDialog.dismiss()
                    nameTextView.text = result.data.name
                    emailTextView.text = result.data.email
                    Glide.with(requireContext()).load(result.data.profilePictureUrl?:"https://storage.googleapis.com/herbalease-image/Foto-Profil/blank-profile-picture-973460_1280.png")
                        .override(200,200).skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.NONE).into(binding.profileImage)
                }
                is Result.Error -> {
                    loadingDialog.dismiss()
                    showToast(result.error)
                }
            }
        }

        binding.buttonEdit.setOnClickListener {
            binding.buttonEdit.visibility = View.GONE
            binding.buttonSave.visibility = View.VISIBLE

            binding.profileName.inputType = InputType.TYPE_CLASS_TEXT
            binding.profileEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            binding.profileName.requestFocus()
            binding.profileImage.setOnClickListener {
                ImagePicker.Companion.with(this)
                    .crop(1f, 1f)
                    .compress(1024)
                    .maxResultSize(
                        1080,
                        1080
                    )
                    .start()
            }
        }

        binding.buttonSave.setOnClickListener {
            binding.buttonSave.visibility = View.GONE
            binding.buttonEdit.visibility = View.VISIBLE
            binding.profileName.inputType = InputType.TYPE_NULL
            binding.profileEmail.inputType = InputType.TYPE_NULL
            binding.profileImage.setOnClickListener {
            }
            showToast("TO DO: API Call Edit")
        }

        binding.logoutPromptTextView.setOnClickListener {
            AlertDialog.Builder(requireContext()).apply {
                setTitle("Logout")
                setMessage("Are you sure you want to logout?")
                setPositiveButton("Yes") { _, _ ->
                    profileViewModel.logout()
                    Toast.makeText(requireContext(), "Logout Success", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("No"){ dialog, _ ->
                    dialog.dismiss()
                }
                create()
                show()
            }

        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri = data?.data!!
            Log.d("profile pic", "profile ${uri}")


            Glide.with(requireContext())
                .load(uri)
                .centerCrop()
                .override(500, 500)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.profileImage)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            showToast(ImagePicker.getError(data))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showToast(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}
