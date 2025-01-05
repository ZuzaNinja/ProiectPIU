package com.example.proiectpiu_managementfinanciar.settings

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.budget.MainBudgetActivity
import com.example.proiectpiu_managementfinanciar.home_dashboard.ParentDashboardActivity
import com.example.proiectpiu_managementfinanciar.objective.ObjectiveStartPageActivityAdult

class SettingsStartActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var homeButton: View
    private lateinit var budgetButton: View
    private lateinit var goalsButton: View
    private lateinit var reportsButton: View
    private lateinit var settingsButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_start)

        initializeViews()

        setListeners()

        findViewById<View>(R.id.profile_button).setOnClickListener(this)
        findViewById<View>(R.id.notifications_button).setOnClickListener(this)
        findViewById<View>(R.id.security_button).setOnClickListener(this)
        findViewById<View>(R.id.alert_button).setOnClickListener(this)
        findViewById<View>(R.id.language_button).setOnClickListener(this)
    }

    private fun initializeViews() {
        homeButton = findViewById(R.id.homeButton)
        budgetButton = findViewById(R.id.budgetButton)
        goalsButton = findViewById(R.id.goalsButton)
        reportsButton = findViewById(R.id.reportsButton)
        settingsButton = findViewById(R.id.settingsButton)
    }

    private fun setListeners() {
        homeButton.setOnClickListener(this)
        budgetButton.setOnClickListener(this)
        goalsButton.setOnClickListener(this)
        reportsButton.setOnClickListener(this)
        settingsButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.profile_button -> {
                //startActivity(Intent(this, ProfileActivity::class.java))
                Toast.makeText(this, "Profile (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.notifications_button -> {
                startActivity(Intent(this, NotificationActivity::class.java))
            }
            R.id.security_button -> {
                //startActivity(Intent(this, SecurityActivity::class.java))
                Toast.makeText(this, "Securitate (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.alert_button -> {
                //startActivity(Intent(this, AlertActivity::class.java))
                Toast.makeText(this, "Alerte (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.language_button -> {
                //startActivity(Intent(this, LanguageActivity::class.java))
                Toast.makeText(this, "Limbă (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.homeButton -> {
                startActivity(Intent(this, ParentDashboardActivity::class.java))
            }
            R.id.budgetButton -> {
                startActivity(Intent(this, MainBudgetActivity::class.java))
            }
            R.id.goalsButton -> {
                startActivity(Intent(this, ObjectiveStartPageActivityAdult::class.java))
            }
            R.id.reportsButton -> {
                Toast.makeText(this, "Rapoarte (în lucru)", Toast.LENGTH_SHORT).show()
            }
            R.id.settingsButton -> {
                startActivity(Intent(this, SettingsStartActivity::class.java))
            }
            else -> {
                Toast.makeText(this, "Acțiune necunoscută", Toast.LENGTH_SHORT).show()
            }
        }
    }
}