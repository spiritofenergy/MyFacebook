package com.kodex.myfacebook.screens

import android.media.Image
import android.provider.ContactsContract.StatusUpdates
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Chat
import androidx.compose.material.icons.rounded.ChatBubble
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Store
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodex.myfacebook.R
import com.kodex.myfacebook.models.TabItem
import com.kodex.myfacebook.ui.theme.BrandBlue
import com.kodex.myfacebook.ui.theme.ButtonGray
import kotlinx.coroutines.selects.select

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()){
        LazyColumn{
            item{
                TopBarApp()
            }
            item {
                TopBar()
            }
            item {
                StatusUpdateBar(
                   avatarUrl = "https://firebasestorage.googleapis.com/v0/b/facebook-1d441.appspot.com/o/mini.png?alt=media&token=51230c04-ef51-4ee4-8a05-180394697c3b",
                   onTextChange = {
                    // TODO
                },
                    onSendClick = {
                        // TODO
                    }
                )
            }
        }
    }
}

@Composable
fun StatusUpdateBar(
    avatarUrl:String,
    onTextChange: (String)-> Unit,
    onSendClick: () -> Unit
) {
    Surface{
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                AsyncImage(model = ImageRequest.Builder(
                    LocalContext.current
                ).data(avatarUrl)
                    .crossfade(true)
                    .placeholder(R.drawable.placeholder)
                    .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape))
                Spacer(Modifier.width(8.dp))
                var text by remember {
                    mutableStateOf("")
                }
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        //  focusedIndicatorColor = (BrandBlue),
                        unfocusedIndicatorColor = (BrandBlue)

                    ),
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = {
                        text = it
                        onTextChange(it)
                    },
                    placeholder = {
                        Text(stringResource(R.string.whats_you_new))
                    },
                    keyboardActions = KeyboardActions {
                        onSendClick()
                        text = ""
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Send
                    )
                )
            }
            Divider()
        }
    }
}


@Composable
fun TopBar() {
    Surface {
        var tabIndex by remember {
            mutableStateOf(0)
        }
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.primary,
        ) {
            val tabs = listOf(
                TabItem(Icons.Rounded.Home, stringResource(R.string.home)),
                TabItem(Icons.Rounded.Tv, stringResource(R.string.reels)),
                TabItem(Icons.Rounded.Store, stringResource(R.string.marketplace)),
                TabItem(Icons.Rounded.Newspaper, stringResource(R.string.news)),
                TabItem(Icons.Rounded.Notifications, stringResource(R.string.notifications)),
                TabItem(Icons.Rounded.Menu, stringResource(R.string.menu)),
            )

            tabs.forEachIndexed { i, item ->
                Tab(selected = tabIndex == i,
                    onClick = { tabIndex = i },
                    modifier = Modifier.heightIn(48.dp)) {
                    Icon(item.icon,
                        contentDescription = item.contentDescription,
                        tint = if (i == tabIndex) {
                            MaterialTheme.colors.primary
                        } else {
                            MaterialTheme.colors.onSurface.copy(alpha = 0.44f)
                        })
                }
            }
        }
    }
}

@Composable
private fun TopBarApp() {
    Surface {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.app_name),
                style = MaterialTheme.typography.h6
            )
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(ButtonGray)
            ) {
                Icon(Icons.Rounded.Search, contentDescription = stringResource(R.string.search))
            }

            Spacer(Modifier.width(8.dp))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(ButtonGray)
            ) {
                Icon(Icons.Rounded.ChatBubble, contentDescription = stringResource(R.string.chat))
            }


        }
    }
}
        
