package com.sun5066.domain.model

data class MatchDto(
    val metadata: MetadataDto,
    val info: InfoDto
)

data class MetadataDto(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>
)

data class InfoDto(
    val endOfGameResult: String,
    val gameCreation: Long,
    val gameDuration: Int,
    val gameEndTimestamp: Long,
    val gameId: Long,
    val gameMode: String,
    val gameName: String,
    val gameStartTimestamp: Long,
    val gameType: String,
    val gameVersion: String,
    val mapId: Int,
    val participants: List<ParticipantDto>,
    val platformId: String,
    val queueId: Int,
    val teams: List<TeamDto>,
    val tournamentCode: String
)

data class ParticipantDto(
    val summonerName: String,
    val individualPosition: String,
    val totalDamageDealtToChampions: Int,
    val win: Boolean,
    val kills: Int,
    val assists: Int,
    val deaths: Int,
    val champExperience: Int,
    val champLevel: Int,
    val championId: Int,
    val championName: String,
    val championTransform: Int,
)

data class TeamDto(
    val bans: List<BanDto>,
    val objectives: ObjectivesDto,
    val teamId: Int,
    val win: Boolean
)

data class BanDto(
    val championId: Int,
    val pickTurn: Int
)

data class ObjectivesDto(
    val atakhan: ObjectiveDto,
    val baron: ObjectiveDto,
    val champion: ObjectiveDto,
    val dragon: ObjectiveDto,
    val horde: ObjectiveDto,
    val inhibitor: ObjectiveDto,
    val riftHerald: ObjectiveDto,
    val tower: ObjectiveDto
)

data class ObjectiveDto(
    val first: Boolean,
    val kills: Int
)