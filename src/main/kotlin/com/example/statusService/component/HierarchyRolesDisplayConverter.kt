package com.example.statusService.component

import com.example.statusService.config.ObjectMapperConfig
import com.example.statusService.model.HierarchyRolesRestInput
import com.example.statusService.model.HierarchyRolesRestOutput
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.FileReader
import java.util.stream.Collectors

@Component
class HierarchyRolesDisplayConverter(val objectMapperConfig: ObjectMapperConfig) {

    fun extractTenResults (restInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {

        val responseBR = BufferedReader(FileReader(ClassPathResource("responseWith10Results.json").file))
        var packagingDetailsResponse = responseBR.lines().collect(Collectors.joining("\n"))

        val objectMapper = objectMapperConfig.objectMapper()
        var hierarchyRolesRestOutput = objectMapper.readValue(packagingDetailsResponse, HierarchyRolesRestOutput::class.java)

        return hierarchyRolesRestOutput
    }

    fun extractTwentyResults (restInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {

        val responseBR = BufferedReader(FileReader(ClassPathResource("responseWith20Results.json").file))
        var packagingDetailsResponse = responseBR.lines().collect(Collectors.joining("\n"))

        val objectMapper = objectMapperConfig.objectMapper()
        var hierarchyRolesRestOutput = objectMapper.readValue(packagingDetailsResponse, HierarchyRolesRestOutput::class.java)

        return hierarchyRolesRestOutput
    }

    fun extractFiftyResults (restInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {

        val responseBR = BufferedReader(FileReader(ClassPathResource("responseWith50Results.json").file))
        var packagingDetailsResponse = responseBR.lines().collect(Collectors.joining("\n"))

        val objectMapper = objectMapperConfig.objectMapper()
        var hierarchyRolesRestOutput = objectMapper.readValue(packagingDetailsResponse, HierarchyRolesRestOutput::class.java)

        return hierarchyRolesRestOutput
    }

    fun extractHundredResults (restInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {

        val responseBR = BufferedReader(FileReader(ClassPathResource("responseWith100Results.json").file))
        var packagingDetailsResponse = responseBR.lines().collect(Collectors.joining("\n"))

        val objectMapper = objectMapperConfig.objectMapper()
        var hierarchyRolesRestOutput = objectMapper.readValue(packagingDetailsResponse, HierarchyRolesRestOutput::class.java)

        return hierarchyRolesRestOutput
    }
}