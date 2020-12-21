package com.example.statusService.service

import com.example.statusService.component.HierarchyRolesDisplayConverter
import com.example.statusService.model.HierarchyRolesRestInput
import com.example.statusService.model.HierarchyRolesRestOutput
import org.springframework.stereotype.Service

@Service
class HierarchyRolesService(val hierarchyRolesDisplayConverter: HierarchyRolesDisplayConverter) {

    fun getHierarchyRoles(hierarchyRolesRestInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {

        when (hierarchyRolesRestInput.pageRequest.pageSize) {
            20 -> {
                return hierarchyRolesDisplayConverter.extractTwentyResults(hierarchyRolesRestInput)
            }
            50 -> {
                return hierarchyRolesDisplayConverter.extractFiftyResults(hierarchyRolesRestInput)
            }
            100 -> {
                return hierarchyRolesDisplayConverter.extractHundredResults(hierarchyRolesRestInput)
            }
            else -> return hierarchyRolesDisplayConverter.extractTenResults(hierarchyRolesRestInput)
        }

    }
}
