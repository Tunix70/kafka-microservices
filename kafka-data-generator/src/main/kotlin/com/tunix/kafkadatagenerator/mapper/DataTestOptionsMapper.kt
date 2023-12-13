package com.tunix.kafkadatagenerator.mapper

import com.tunix.kafkadatagenerator.dto.DataTestOptionsDto
import com.tunix.kafkadatagenerator.model.test.DataTestOptions
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface DataTestOptionsMapper: Mappable<DataTestOptions, DataTestOptionsDto>