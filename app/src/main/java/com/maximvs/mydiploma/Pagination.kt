package com.maximvs.mydiploma

data class Pagination(
    val current_page: Int,
    val limit: Int,
    val next_url: String,
    val offset: Int,
    val total: Int,
    val total_pages: Int
)