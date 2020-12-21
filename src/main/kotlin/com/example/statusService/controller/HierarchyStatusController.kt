package com.example.statusService.controller

import com.example.statusService.model.HierarchyRolesRestInput
import com.example.statusService.model.HierarchyRolesRestOutput
import com.example.statusService.service.HierarchyRolesService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class HierarchyStatusController(val hierarchyRolesService: HierarchyRolesService) {

    private var logger: Logger = LoggerFactory.getLogger(HierarchyStatusController::class.java)

    @CrossOrigin(origins = ["*"])
    @PostMapping("/hierarchyRoles")
    fun getHierarchyRoles(@RequestBody hierarchyRolesRestInput: HierarchyRolesRestInput): HierarchyRolesRestOutput {
        return hierarchyRolesService.getHierarchyRoles(hierarchyRolesRestInput)
    }
}