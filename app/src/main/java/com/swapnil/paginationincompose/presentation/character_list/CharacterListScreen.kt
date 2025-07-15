package com.swapnil.paginationincompose.presentation.character_list

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage

@Composable
fun CharacterListScreen(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val characters = viewModel.characters.collectAsLazyPagingItems()
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top=40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Rick and Morty Characters",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                ,
            state = listState
        ) {
            itemsIndexed(
                characters,
                key = { _, character -> character.id }) { index, character ->

                // Check visibility
                val isVisible = remember {
                    derivedStateOf {
                        val visibleItems = listState.layoutInfo.visibleItemsInfo
                        visibleItems.any { it.index == index }
                    }
                }
                val scale = remember { Animatable(0f) }

                // val hasAnimated = remember { mutableStateOf(false) }

                LaunchedEffect(isVisible.value) {
                    if (isVisible.value) {
                        scale.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(
                                durationMillis = 300, // Adjust as needed for smoothness
                                easing = FastOutSlowInEasing
                            )
                        )
                    } else {
                        scale.snapTo(0f) // Reset scale when not visible
                    }
                }
                character?.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                            .graphicsLayer(scaleX = scale.value, scaleY = scale.value)
                            .shadow(elevation = 10.dp)
                            .background(Color.White, shape = RoundedCornerShape(10.dp))
                        ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = it.image,
                            contentDescription = it.name,
                            modifier = Modifier
                                .padding(vertical = 5.dp, horizontal = 5.dp)
                                .clip(CircleShape)
                                .size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            modifier = Modifier.fillMaxSize()
                            ,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = it.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = it.status, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }

            }

            characters.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                contentAlignment = androidx.compose.ui.Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = androidx.compose.ui.Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                    loadState.refresh is LoadState.Error -> {
                        val error = loadState.refresh as LoadState.Error
                        item {
                            Text(
                                text = "Error: ${error.error.localizedMessage}",
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        val error = loadState.append as LoadState.Error
                        item {
                            Text(
                                text = "Error loading more: ${error.error.localizedMessage}",
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}

