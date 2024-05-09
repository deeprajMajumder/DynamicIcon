package com.deepraj.dynamicicon

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepraj.dynamicicon.ui.theme.DynamicIconTheme

class MainActivity : ComponentActivity() {
    private val mainActivity = BuildConfig.main_activity
    private val mainActivityAliasTwo = BuildConfig.main_activity_alias_two
    private val mainActivityAliasThree = BuildConfig.main_activity_alias_three

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicIconTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screenn()
                }
            }
        }
    }

    // use this for default icon
    private fun changeIconToMain() {
        try {
            // Disable the Alias three component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Disable the Alias two component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the main logo is enabled
            Log.d("MainLogo", "Main Logo Enabled")
            Toast.makeText(this@MainActivity, "Main Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }

    // use this for second icon
    private fun changeIconToSecondIcon() {
        try {
            // Disable the Alias three component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the Alias two component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the Second logo is enabled
            Log.d("SecondLogo", "Second Logo Enabled")
            Toast.makeText(this@MainActivity, "Second Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }

    // use this for second icon
    private fun changeIconToThirdIcon() {
        try {
            // Enable the Alias three component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasThree
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the Alias two component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivityAliasTwo
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Enable the main activity component
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    mainActivity
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )

            // Log and display a toast message indicating that the Third logo is enabled
            Log.d("ThirdLogo", "Third Logo Enabled")
            Toast.makeText(this@MainActivity, "Third Logo Enabled.", Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            Log.e("Exception", e.toString())
        }
    }

    @Composable
    fun Screen(
        on30Click: () -> Unit = {},
        on60Click: () -> Unit = {},
        on90Click: () -> Unit = {},
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
                onClick = on30Click
            ) {
                Text(text = "30")
            }

            Button(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 16.dp),
                onClick = on60Click
            ) {
                Text(text = "60")
            }

            Button(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp),
                onClick = on90Click
            ) {
                Text(text = "90")
            }
        }
    }

    @Composable
    fun Screenn(
        onIconSelected: (Int) -> Unit = {},
    ) {
        var selectedIcon by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconToggleButton(
                    checked = selectedIcon == 1,
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedIcon = 1
                            onIconSelected(1)
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Icon 1"
                    )
                }

                IconToggleButton(
                    checked = selectedIcon == 2,
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedIcon = 2
                            onIconSelected(2)
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_2_foreground),
                        contentDescription = "Icon 2"
                    )
                }

                IconToggleButton(
                    checked = selectedIcon == 3,
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedIcon = 3
                            onIconSelected(3)
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_3_foreground),
                        contentDescription = "Icon 3"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle action based on selected icon */
                          when (selectedIcon) {
                              1-> {
                                  changeIconToMain()
                              }
                              2-> {
                                  changeIconToSecondIcon()
                              }
                              3-> {
                                  changeIconToThirdIcon()
                              }
                          }
                      },
                enabled = selectedIcon != 0
            ) {
                Text(text = "Select")
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        DynamicIconTheme {
            Screen()
        }
    }
}