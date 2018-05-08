package freemusic.util


object PackingResult {


    fun toSuccessMap(list: List<*>): Map<*, *> = mapOf("status" to 200, "data" to list)

    fun toSuccessMap(map: Map<String, *>): Map<*, *> = mapOf("status" to 200, "data" to map)

    private val staticSuccessMap = mapOf("status" to 200)
    fun toSuccessMap(): Map<*, *> = staticSuccessMap

    fun toWorngMap(detailed: String): Map<*, *> = mapOf("status" to 500, "data" to detailed)

    fun customMap(statusCode: Int, detailed: String): Map<String, *> = mapOf("status" to statusCode, "data" to detailed)
}