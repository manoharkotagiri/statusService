package com.example.statusService.model

data class HierarchyRolesRestInput(
        //TO DO: Add History Flag and get paged records from Archive table
        var pageRequest: InputPageRequest = InputPageRequest(),
        var queries: List<InputQueryFields> = emptyList(),
        var includeHistory: Boolean = false
)

data class InputQueryFields (
        var queryField: String? = null,
        var queryValue: String? = null,
        var searchCriteria: String? = null,
        var isSalesVariantField: Boolean = false,
        var isEmbeddedIdField: Boolean = false
)

data class InputPageRequest(
        var pageNumber: Int = 0,
        var pageSize: Int = 10,
        var sortAscending: Boolean = true
)

data class HierarchyRolesRestOutput(
        var totalElements: Long = 0,
        var totalPages: Int = 0,
        var numberOfElements: Int = 0,
        var pageRequest: InputPageRequest = InputPageRequest(),
        var results: ArrayList<HierarchyRolesDisplayFields> = arrayListOf()
)

data class HierarchyRolesDisplayFields(
        var publishedGtin: String? = null,
        var version: Long? = null,
        var innerPackItemId: String? = null,
        var salesVariantItemIdList: MutableSet<String> = mutableSetOf(),
        var itemHierarchyStatus: String? = null,
        var roleUpdateDateAndTime: String? = null,
        var venusImfNumber: String? = null,
        var venusReasonCode: String? = null
)