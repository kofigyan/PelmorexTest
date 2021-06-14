package com.example.pelmorextest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo(@PrimaryKey val id: String, val imageUrl: String, val createdAt: String)