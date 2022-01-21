package com.example.clicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.clicker.src.User
import com.squareup.picasso.Picasso

class UploadViaInternet(user: User, picture:ImageView) : Fragment() {
    val user:User = user
    val picture:ImageView = picture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upload_via_internet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.upload)
        val input:EditText = view.findViewById(R.id.urlAddress)

        button.setOnClickListener{
            user.sourcePicture = input.text.toString()
            Picasso.get().load(user.sourcePicture).placeholder(R.drawable.avatar_header).into(picture)
        }
    }

}