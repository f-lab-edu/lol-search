package com.sun5066.presentation.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.sun5066.presentation.main.model.MatchInfo

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    matches: List<MatchInfo>,
    lazyListState: LazyListState,
    keyboardController: SoftwareKeyboardController?,
    searchText: String,
    onSearchValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = searchText,
                onValueChange = onSearchValueChange,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        keyboardController?.hide()
                        onSearch(searchText)
                    }
                ),
                singleLine = true
            )
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = lazyListState,
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = matches,
                key = { it.metadata.matchId }
            ) { match ->
                Card(modifier = Modifier.padding(4.dp)) {
                    Column(Modifier.fillMaxWidth()) {
                        Text("게임 시간: ${match.info.gameDuration}")
                        Spacer(Modifier.height(8.dp))
                        (match.info.participants).forEach { participant ->
                            Text("summonerName: ${participant.summonerName}")
                            Spacer(Modifier.height(8.dp))
                            Text("kills: ${participant.kills}")
                            Spacer(Modifier.height(8.dp))
                            Text("deaths: ${participant.deaths}")
                            Spacer(Modifier.height(8.dp))
                            Text("win: ${participant.win}")
                            Spacer(Modifier.height(8.dp))
                            Text("level: ${participant.champLevel}")
                            Spacer(Modifier.height(8.dp))
                            Text("championName: ${participant.championName}")
                            Spacer(Modifier.height(8.dp))
                            Text("position: ${participant.individualPosition}")
                        }
                    }
                }
            }
        }
    }
}