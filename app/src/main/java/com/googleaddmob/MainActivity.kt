package com.googleaddmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        banner.loadAd(adRequest)

        banner.adListener = object: AdListener() {
            override fun onAdLoaded() {
                Log.d(Companion.TAG, "onAdLoaded: ")
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                Log.d(TAG, "onAdFailedToLoad: ")
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                Log.d(TAG, "onAdOpened: ")
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                Log.d(TAG, "onAdClicked: ")
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                Log.d(TAG, "onAdLeftApplication: ")
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                Log.d(TAG, "onAdClosed: ")
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}