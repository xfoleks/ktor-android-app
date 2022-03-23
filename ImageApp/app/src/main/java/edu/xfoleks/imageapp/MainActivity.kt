package edu.xfoleks.imageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.imageapp.ui.theme.RabbitAppTheme

@AndroidEntryPoint
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabbitAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    val viewModel: MainViewModel = hiltViewModel()
                    val image = viewModel.state.value.image
                    val isLoading = viewModel.state.value.isLoading
                    image?.let {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentDescription = getString(R.string.car)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = it.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = it.description)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Button(
                        onClick = viewModel::getRandomImage,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = getString(R.string.next_car))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (isLoading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}