package com.dev.chacha.vunatec.feature_alerts.domain.model

data class Alerts(
    val icon: String,
    val alertTypTitle: String,
    val incomingAlertIcon: Int,
    val outgoingAlertIcon: Int,
    val alertTypeSubtitle: String,
    val durationAlerts: String
)

val alerts = listOf(
    Alerts(
        icon = "",
        alertTypeSubtitle = "Home",
        incomingAlertIcon = 1,
        outgoingAlertIcon = 1,
        durationAlerts = "Home",
        alertTypTitle = "Home"
    )
)
