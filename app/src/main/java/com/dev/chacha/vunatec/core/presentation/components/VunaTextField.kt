package com.dev.chacha.vunatec.core.presentation.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.util.TestTags

@Composable
fun VunaTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 50,
    error: String = "",
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester = FocusRequester()
){
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val indicatorUnfocusedWidth = 1.dp
    val indicatorFocusedWidth = 2.dp
    val textFieldPadding = 16.dp
    val color = Color.White.copy(alpha = 0.78F)
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = color,
        cursorColor = color,
        leadingIconColor = color,
        trailingIconColor = color,
        focusedBorderColor = Transparent,
        unfocusedBorderColor = Transparent,
        focusedLabelColor = Transparent,
        unfocusedLabelColor = color,

        disabledBorderColor = Transparent

    )

    val indicatorColor = if (isFocused) Color.Green else Color.DarkGray
    val indicatorWidth = if (isFocused) indicatorFocusedWidth else indicatorUnfocusedWidth

    Column(modifier = Modifier.fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp))  {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            placeholder = {
                Text(
                    text = hint,
                    textAlign = TextAlign.Start,
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if (isPasswordToggleDisplayed) {
                val icon: @Composable () -> Unit = {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!isPasswordVisible)
                        },
                        modifier = Modifier
                            .semantics {
                                testTag = TestTags.PASSWORD_TOGGLE
                            }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            tint = Color.Green,
                            contentDescription = if (isPasswordVisible) {
                                stringResource(id = R.string.password_visible_content_description)
                            } else {
                                stringResource(id = R.string.password_hidden_content_description)
                            },
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
                icon
            } else null,
            interactionSource = interactionSource,
            modifier = Modifier.fillMaxWidth()
                .drawBehind {
                    val strokeWidth = indicatorWidth.value * density
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        indicatorColor,
                        Offset(textFieldPadding.toPx(), y),
                        Offset(size.width - textFieldPadding.toPx(), y),
                        strokeWidth
                    )
                }
                .semantics {
                    testTag = TestTags.STANDARD_TEXT_FIELD
                }
                .focusRequester(focusRequester = focusRequester),
            colors = textFieldColors

        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()

            )

        }
    }

}