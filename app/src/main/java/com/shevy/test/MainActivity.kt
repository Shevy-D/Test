package com.shevy.test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.shevy.test.databinding.ActivityMainBinding
import com.shevy.test.services.MyService
import com.shevy.test.ui.main.Fragment1
import com.shevy.test.ui.main.Fragment2
import com.shevy.test.ui.main.Fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var wifiSwitch: Switch
    lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        title = "KotlinApp"
        wifiSwitch = binding.wifiSwitch
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                wifiManager.isWifiEnabled = true
                wifiSwitch.text = "WiFi is ON"
            } else {
                wifiManager.isWifiEnabled = false
                wifiSwitch.text = "WiFi is OFF"
            }
        }
    }
    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN)) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    wifiSwitch.isChecked = true
                    wifiSwitch.text = "WiFi is ON"
                    Toast.makeText(this@MainActivity, "Wifi is On", Toast.LENGTH_SHORT).show()
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    wifiSwitch.isChecked = false
                    wifiSwitch.text = "WiFi is OFF"
                    Toast.makeText(this@MainActivity, "Wifi is Off", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}