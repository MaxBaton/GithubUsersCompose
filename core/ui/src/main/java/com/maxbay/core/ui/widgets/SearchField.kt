package com.maxbay.core.ui.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.R
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.defaultFormFieldHeight56
import com.maxbay.core.ui.theme.itemHeight24
import com.maxbay.core.ui.theme.itemWidth24
import com.maxbay.core.ui.theme.round16

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderResId: Int,
    @DrawableRes leadingIconResId: Int,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        value = value,
        shape = RoundedCornerShape(round16),
        modifier = modifier.height(defaultFormFieldHeight56),
        placeholder = {
            Text(
                text = stringResource(id = placeholderResId),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        },
        visualTransformation = visualTransformation,
        onValueChange = onValueChange,
        leadingIcon = {
            Image(
                modifier = Modifier
                    .height(itemHeight24)
                    .width(itemWidth24),
                painter = painterResource(id = leadingIconResId),
                contentDescription = "form icon",
                contentScale = ContentScale.None
            )

        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}


@Preview(showBackground = true)
@Composable
internal fun SearchFieldPreview() {
    GithubUsersComposeTheme {
        SearchField(
            value = "Hotel or city name",
            placeholderResId = androidx.compose.material3.R.string.search_bar_search,
            leadingIconResId = R.drawable.ic_left_arrow,
            onValueChange = {},
        )
    }
}