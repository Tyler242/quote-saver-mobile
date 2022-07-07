package com.tyler.quotesaverfinal.models

/**
 * Quote class for the quotes
 * */
data class Quote(
    var text: String,
    var source: String,
    var date: String,
    var keywords: List<String>) {
}