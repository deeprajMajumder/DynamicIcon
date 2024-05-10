package com.deepraj.dynamicicon

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val mainActivity = BuildConfig.main_activity
    private val mainActivityAliasTwo = BuildConfig.main_activity_alias_two
    private val mainActivityAliasThree = BuildConfig.main_activity_alias_three

    // use this for default icon
    fun changeIconToMain(context: Context) {
        try {
            // Disable the Alias three component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Disable the Alias two component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the main logo is enabled
            Log.d("MainLogo", "Main Logo Enabled")
            Toast.makeText(context, "Main Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }

    // use this for second icon
    fun changeIconToSecondIcon(context: Context) {
        try {
            // Disable the Alias three component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the Alias two component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the Second logo is enabled
            Log.d("SecondLogo", "Second Logo Enabled")
            Toast.makeText(context, "Second Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }

    // use this for third icon
     fun changeIconToThirdIcon(context: Context) {
        try {
            // Enable the Alias three component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the Alias two component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            context.applicationContext.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the Third logo is enabled
            Log.d("ThirdLogo", "Third Logo Enabled")
            Toast.makeText(context, "Third Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }
}