package animalsList

import android.annotation.SuppressLint
import androidx.compose.foundation.*
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import model.*

//import androidx.compose.ui.tooling.data.EmptyGroup.name

@SuppressLint("SuspiciousIndentation")
@Composable
fun AnimalsScreen(
    repo: Repo
) {
    val showDetail = remember { mutableStateOf(false) }
    val tabIndex = remember { mutableStateOf(0) }
    val animaSave = remember { mutableStateOf(repo.animalsList[0][0]) }

        if (showDetail.value)
        DetailScreen(
            animal = animaSave.value,
            setShowDetail = {value -> showDetail.value = value},
        )
//        DetailScreen(animaSave.value) {
//            showDetail.value = it
//        }

    Column {

        TabRow(selectedTabIndex = tabIndex.value) {
            repo.tabs.forEachIndexed { index, tabtext ->
                Tab(
                    text = { Text(tabtext) },
                    selected = tabIndex.value == index,
                    onClick = { tabIndex.value = index },
                )
            }
        }
        LazyColumn {
            items(repo.animalsList[tabIndex.value]) { animal ->
                AnimalListItem(
                    animal = animal,
                    onClick = {
                        showDetail.value = true
                        animaSave.value = animal
                    }
                )
            }
        }
    }
}

@Composable
fun AnimalListItem(
    animal: Animal,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.clickable { onClick() },
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 110.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = animal.name,
                    style = MaterialTheme.typography.h5
                )
//                Text(
//                    text = animal.description,
//                    style = MaterialTheme.typography.subtitle2
//                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(90.dp)
//                    .clip(CircleShape)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                animal.image?.let { painterResource(it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(animal: Animal, setShowDetail: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = { setShowDetail(false) },
        DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            IconButton(
                onClick = { setShowDetail(false) }
            )
            {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = animal.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            animal.image?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = animal.description,
                style = TextStyle(
                    fontSize = 14.sp,
                )
            )
        }
    }
}

