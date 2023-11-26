package com.example.android_chatbot

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.android_chatbot.ui.theme.AndroidChatBotTheme

enum class ChatBotScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    SelectBot(title = R.string.SelectBot),
    AllChat(title = R.string.AllChat),
    Setting(title = R.string.Setting)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBotAppBar(
    currentScreen: ChatBotScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(R.drawable.chatbot), contentDescription = "PayAsYouGo")
                Spacer(modifier = Modifier.width(10.dp))
                Text(stringResource(currentScreen.title))}
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }else{
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ChatBotAppBarPreview() {
    val navController: NavHostController = rememberNavController()
    AndroidChatBotTheme {
        ChatBotAppBar(ChatBotScreen.Start,false, {navController.navigateUp()})
    }
}

/*@Composable
fun ChatBotApp(
    viewModel: ChatViewModel = ChatViewModel(),
    navController: NavHostController = rememberNavController()
) {

}
Scaffold(
...
) { innerPadding ->
    val uiState by viewModel.uiState.collectAsState()

    NavHost()
}*/

