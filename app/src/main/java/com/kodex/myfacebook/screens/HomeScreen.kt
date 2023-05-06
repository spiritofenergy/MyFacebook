package com.kodex.myfacebook.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kodex.myfacebook.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()){
        Row(Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.app_name))
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                
            }
        }
    }
        
}