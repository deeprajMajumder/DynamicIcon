package com.deepraj.dynamicicon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepraj.dynamicicon.ui.theme.DynamicIconTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicIconTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }

    @Composable
    fun Screen(
        onIconSelected: (Int) -> Unit = {},
    ) {
        var selectedIcon by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text (
                text = "You may select any app icon from the options:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

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
                    },
                    modifier = Modifier
                        .padding(2.dp)
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(if (selectedIcon == 1) Color.LightGray else Color.Transparent)

                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Icon 1",
                        modifier = Modifier.size(72.dp)
                    )
                }

                IconToggleButton(
                    checked = selectedIcon == 2,
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedIcon = 2
                            onIconSelected(2)
                        }
                    },
                    modifier = Modifier
                        .padding(2.dp)
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(if (selectedIcon == 2) Color.LightGray else Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_2_foreground),
                        contentDescription = "Icon 2",
                        modifier = Modifier.size(72.dp)
                    )
                }

                IconToggleButton(
                    checked = selectedIcon == 3,
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedIcon = 3
                            onIconSelected(3)
                        }
                    },
                    modifier = Modifier
                        .padding(2.dp)
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(if (selectedIcon == 3) Color.LightGray else Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_3_foreground),
                        contentDescription = "Icon 3",
                        modifier = Modifier.size(72.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { // Handle action based on selected icon
                          when (selectedIcon) {
                              1-> {
                                  mainViewModel.changeIconToMain(this@MainActivity)
                              }
                              2-> {
                                  mainViewModel.changeIconToSecondIcon(this@MainActivity)
                              }
                              3-> {
                                  mainViewModel.changeIconToThirdIcon(this@MainActivity)
                              }
                          }
                      },
                enabled = selectedIcon != 0
            ) {
                Text(text = "Apply")
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