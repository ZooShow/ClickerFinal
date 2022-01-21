package com.example.clicker

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.clicker.src.User
import java.util.*

class UpPower(user: User, gold:TextView, power:TextView) : Fragment(), View.OnClickListener{
    var user:User = user
    val gold:TextView = gold
    val power:TextView = power

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.up_power)
        val text:TextView = view.findViewById(R.id.tetx_up_hero_power)
        val powerTextView: TextView = view.findViewById(R.id.power_up)
        val goldTextView: TextView = view.findViewById(R.id.gold_up)

        powerTextView.text = "Сила: " + user.power.toString()
        goldTextView.text = "Золото: " + user.gold.toString()
        text.text = "Увеличить силу героя (необходимо" + user.increaser + " золота)"

        button.setOnClickListener{
            if (user.increasePower()){
                power.text = "Сила: " + user.power.toString()
                gold.text = "Золото: " + user.gold.toString()
                text.text = "Увеличить силу героя (необходимо" + user.increaser + " золота)"
                powerTextView.text = "Сила: " + user.power.toString()
                goldTextView.text = "Золото: " + user.gold.toString()
            } else{
                Toast.makeText(requireContext(), "Недостаточно золота", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_up_power, container, false)
        return inflater.inflate(R.layout.fragment_up_power, container, false)
    }

    override fun onClick(p0: View?) {}
}