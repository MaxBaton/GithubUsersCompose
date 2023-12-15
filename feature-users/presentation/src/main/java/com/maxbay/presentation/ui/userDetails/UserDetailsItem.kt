package com.maxbay.presentation.ui.userDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.padding16
import com.maxbay.core.ui.theme.padding8
import com.maxbay.core.ui.theme.space8
import com.maxbay.domain.models.UserDetails
import com.maxbay.presentation.R

@Composable
fun UserDetailsItem(
    userDetails: UserDetails,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = padding16),
        verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
          modifier = Modifier
              .weight(0.35f)
              .fillMaxWidth(),
          contentAlignment = Alignment.TopCenter
      ) {
          AsyncImage(
              modifier = Modifier
                  .fillMaxWidth()
                  .aspectRatio(1f)
                  .clip(shape = CircleShape),
              model = userDetails.avatarUrl,
              contentDescription = stringResource(id = R.string.ic_user_details_avatar_description, userDetails.name)
          )
      }

      Box(modifier = Modifier
          .weight(0.65f)
          .padding(start = padding8)) {
          Column(verticalArrangement = Arrangement.spacedBy(space8)) {
              TextInfoItem(
                    title = stringResource(id = R.string.email),
                    value = userDetails.email
              )
              TextInfoItem(
                  title = stringResource(id = R.string.location),
                  value = userDetails.location
              )
              TextInfoItem(
                  title = stringResource(id = R.string.company),
                  value = userDetails.company
              )
          }
      }
    }
}

@Composable
@Preview(showBackground = true)
fun UserDetailsItemPreview() {
    GithubUsersComposeTheme {
//        UserDetailsItem()
    }
}