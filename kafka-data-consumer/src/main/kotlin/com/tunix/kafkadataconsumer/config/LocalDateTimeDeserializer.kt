package com.tunix.kafkadataconsumer.config

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.time.LocalDateTime

@Component
class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LocalDateTime {
        val jsonArray = json.getAsJsonArray()
        val year = jsonArray[0].asInt
        val month = jsonArray[1].asInt
        val day = jsonArray[2].asInt
        val hour = jsonArray[3].asInt
        val minute = jsonArray[4].asInt
        val second = jsonArray[5].asInt
        return LocalDateTime.of(year, month, day, hour, minute, second)
    }
}