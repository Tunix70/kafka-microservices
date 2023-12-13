package com.tunix.kafkadatagenerator.mapper

import com.tunix.kafkadatagenerator.dto.DataDto
import com.tunix.kafkadatagenerator.model.Data
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface DataMapper: Mappable<Data, DataDto>
