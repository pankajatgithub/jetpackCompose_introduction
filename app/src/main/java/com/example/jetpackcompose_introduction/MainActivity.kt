package com.example.jetpackcompose_introduction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_introduction.ui.theme.JetpackCompose_IntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }

    }
}

data class User(
    val id : Int
)
val users = listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1)
)
@Composable
fun UserList(){
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        for(i in 1..10)
//        {
//            UserCard()
//        }
//    }
    LazyColumn{
        items(users){user ->
            UserCard()

        }
    }

}

@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .border(1.dp, color = Color.DarkGray)
                .padding(12.dp)//we don't have margin in jetpack compose
        ) {
            Image(
                painter = painterResource(id = android.R.drawable.btn_star_big_on),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = stringResource(id = R.string.dummy_text))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        UserList()
    }
}