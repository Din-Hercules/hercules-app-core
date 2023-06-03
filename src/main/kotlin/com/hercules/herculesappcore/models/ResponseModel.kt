package com.hercules.herculesappcore.models

object ResponseModel {
    data class Status(val statusCode: Int, val message: String)

    data class Data(val data: Any)
}