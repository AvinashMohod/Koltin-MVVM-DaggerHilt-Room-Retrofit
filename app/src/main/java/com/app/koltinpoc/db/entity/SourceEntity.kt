package com.app.koltinpoc.db.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize


data class SourceEntity(
    val id: String,
    val name: String
)