package com.uagr.kmp.course.data.local.model.user

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uId: String,
    val name: String,
    val email: String,
    val currency: String,
    val timezone: String,
    val locale: String,
    val isActive: Boolean,
    val emailVerified: Boolean,
    val createdAt: String,
    val updatedAt: String
)