package com.UMCfront.religo.src.main.event

import com.UMCfront.religo.src.main.home.data.model.HomeCommunityAllList

data class EventResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<EventAllList>
)

data class EventAllList(
    val eventId: String,
    val eventImage: String,
    val location: String,
    val eventDate: String,
    val eventIntroduction: String,
    val participation: String
)