package com.yema.retrofittest.dataclass

data class ServerInfoResponse(
    val info: Info,
    var code: Int,
    var message: String
)


data class Info(
    val id: Int,
    val name: String,
    val url: String
)