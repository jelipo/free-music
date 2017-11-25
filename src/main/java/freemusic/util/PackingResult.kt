package freemusic.util

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject

object PackingResult {


    fun toSuccessMap(list: List<*>): Map<*, *> = mapOf("status" to 200, "data" to list)

    fun toSuccessMap(map: Map<String, *>): Map<*, *> = mapOf("status" to 200, "data" to map)

    fun toSuccessMap(json: JSONObject): Map<*, *> = mapOf("status" to 200, "data" to json)

    fun toSuccessMap(): Map<*, *> = mapOf("status" to 200)

    fun toSuccessMap(jsonArray: JSONArray): Map<*, *> = mapOf("status" to 200, "data" to jsonArray)

    fun toWorngMap(detailed: String): Map<*, *> = mapOf("status" to 200, "data" to detailed)

}