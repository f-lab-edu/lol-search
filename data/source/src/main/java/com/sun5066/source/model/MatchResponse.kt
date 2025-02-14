package com.sun5066.source.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchResponse(
    @SerialName("metadata") val metadata: MetadataResponse,
    @SerialName("info") val info: InfoResponse
)

@Serializable
data class MetadataResponse(
    @SerialName("dataVersion") val dataVersion: String,
    @SerialName("matchId") val matchId: String,
    @SerialName("participants") val participants: List<String>
)

@Serializable
data class InfoResponse(
    @SerialName("endOfGameResult") val endOfGameResult: String,
    @SerialName("gameCreation") val gameCreation: Long,
    @SerialName("gameDuration") val gameDuration: Int,
    @SerialName("gameEndTimestamp") val gameEndTimestamp: Long,
    @SerialName("gameId") val gameId: Long,
    @SerialName("gameMode") val gameMode: String,
    @SerialName("gameName") val gameName: String,
    @SerialName("gameStartTimestamp") val gameStartTimestamp: Long,
    @SerialName("gameType") val gameType: String,
    @SerialName("gameVersion") val gameVersion: String,
    @SerialName("mapId") val mapId: Int,
    @SerialName("participants") val participants: List<ParticipantResponse>,
    @SerialName("platformId") val platformId: String,
    @SerialName("queueId") val queueId: Int,
    @SerialName("teams") val teams: List<TeamResponse>,
    @SerialName("tournamentCode") val tournamentCode: String
)

@Serializable
data class ParticipantResponse(
    @SerialName("summonerName") val summonerName: String,
    @SerialName("individualPosition") val individualPosition: String,
    @SerialName("totalDamageDealtToChampions") val totalDamageDealtToChampions: Int,
    @SerialName("win") val win: Boolean,
    @SerialName("kills") val kills: Int,
    @SerialName("assists") val assists: Int,
    @SerialName("deaths") val deaths: Int,
    @SerialName("champExperience") val champExperience: Int,
    @SerialName("champLevel") val champLevel: Int,
    @SerialName("championId") val championId: Int,
    @SerialName("championName") val championName: String,
    @SerialName("championTransform") val championTransform: Int,
)

@Serializable
data class TeamResponse(
    @SerialName("bans") val bans: List<BanResponse>,
    @SerialName("objectives") val objectives: ObjectivesResponse,
    @SerialName("teamId") val teamId: Int,
    @SerialName("win") val win: Boolean
)

@Serializable
data class BanResponse(
    @SerialName("championId") val championId: Int,
    @SerialName("pickTurn") val pickTurn: Int
)

@Serializable
data class ObjectivesResponse(
    @SerialName("atakhan") val atakhan: ObjectiveResponse,
    @SerialName("baron") val baron: ObjectiveResponse,
    @SerialName("champion") val champion: ObjectiveResponse,
    @SerialName("dragon") val dragon: ObjectiveResponse,
    @SerialName("horde") val horde: ObjectiveResponse,
    @SerialName("inhibitor") val inhibitor: ObjectiveResponse,
    @SerialName("riftHerald") val riftHerald: ObjectiveResponse,
    @SerialName("tower") val tower: ObjectiveResponse
)

@Serializable
data class ObjectiveResponse(
    @SerialName("first") val first: Boolean,
    @SerialName("kills") val kills: Int
)