package com.loc.newsapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar
import com.loc.newsapp.presentation.common.searchBar
import com.loc.newsapp.presentation.common.shimmerEffect
import com.loc.newsapp.presentation.navgraph.Route
import com.loc.newsapp.presentation.onboarding.composable.Dimensions.mediumpadding1

@Composable
fun HomeScreen(articles: LazyPagingItems<Article>, navigate: (String) -> Unit) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            }else{
                ""
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = mediumpadding1)
        .statusBarsPadding()
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = mediumpadding1)
        )

        Spacer(modifier = Modifier.height(mediumpadding1))

        SearchBar(
            modifier = Modifier.padding(horizontal = mediumpadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
                navigate(Route.SearchScreen.route)
            },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(mediumpadding1))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = mediumpadding1),
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(mediumpadding1))

        ArticlesList(
            modifier = Modifier.padding(horizontal = mediumpadding1),
            articles = articles,
            onClick = {
                navigate(Route.DetailsScreen.route)
            }
        )
    }
}