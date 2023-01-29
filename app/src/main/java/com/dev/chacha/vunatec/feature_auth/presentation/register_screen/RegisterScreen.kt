package com.dev.chacha.vunatec.feature_auth.presentation.register_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.core.presentation.components.VunaTextField
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel
) {
    Scaffold(
        topBar = {
            VunaToolbar(
                title = "Register",
                showMenuBar = true,
                showBackArrow = true
            ) {

            }
        }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Create your Account",
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(id = R.string.signin),
                    maxLines = 2,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                )
                Spacer(modifier = Modifier.height(16.dp))

                VunaTextField(
                    text = viewModel.usernameText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Text,
                    error = viewModel.usernameError.value,
                    hint = stringResource(id = R.string.county),
                    modifier = Modifier.clickable {


                    }

                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Account Number",
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                )
                VunaTextField(
                    text = viewModel.usernameText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = viewModel.usernameError.value,
                    hint = stringResource(id = R.string.mobile_number),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "ID number",
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                )
                VunaTextField(
                    text = viewModel.usernameText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = viewModel.usernameError.value,
                    hint = stringResource(id = R.string.idnumber_hint),
                )

                Spacer(modifier = Modifier.height(15.dp))


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Red,
                            containerColor = Color.DarkGray
                        )
                    ) {
                        Text(
                            text = "Create profile + add accounts",
                            modifier = Modifier.padding(10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                }


            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun RegisterPreview() {
    VunaTecTheme {
        RegisterScreen(viewModel = RegisterViewModel())
    }

}


