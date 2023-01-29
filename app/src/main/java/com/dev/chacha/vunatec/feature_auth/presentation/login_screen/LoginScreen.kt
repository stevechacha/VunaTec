package com.dev.chacha.vunatec.feature_auth.presentation.login_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.core.presentation.components.VunaTextField
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Scaffold(
        topBar = {
            VunaToolbar(
                title = "VunaTec",
            ) {}


        }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(vertical = 16.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 25.dp)
                ) {
                    VunaTextField(
                        text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Phone,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.phone_number),

                        )
                    Spacer(modifier = Modifier.height(20.dp))

                    VunaTextField(
                        text = viewModel.passwordText.value,
                        onValueChange = {
                            viewModel.setPasswordText(it)
                        },
                        hint = stringResource(id = R.string.password_hint),
                        keyboardType = KeyboardType.Password,
                        error = viewModel.passwordError.value,
                        isPasswordVisible = viewModel.showPassword.value,
                        onPasswordToggleClick = {
                            viewModel.setShowPassword(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Green
                        ),
                        shape = RoundedCornerShape(8)

                    ) {
                        Text(
                            text = stringResource(id = R.string.login),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = stringResource(id = R.string.create_account),
                            color = Color.Green,
                        )
                        Text(
                            text = stringResource(id = R.string.forgot_password),
                            color = Color.Green,
                            textDecoration = TextDecoration.Underline,
                        )

                    }

                }

            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    VunaTecTheme {
        LoginScreen(viewModel = LoginViewModel())
    }
}
