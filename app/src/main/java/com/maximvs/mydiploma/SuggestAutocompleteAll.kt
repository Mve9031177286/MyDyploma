package com.maximvs.mydiploma

data class SuggestAutocompleteAll(
    val contexts: Contexts,
    val input: List<String>,
    val weight: Int
)