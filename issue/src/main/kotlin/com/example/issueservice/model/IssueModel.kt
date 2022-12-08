package com.example.issueservice.model

import com.example.issueservice.domain.Issue
import com.example.issueservice.domain.enums.IssuePriority
import com.example.issueservice.domain.enums.IssueStatus
import com.example.issueservice.domain.enums.IssueType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class IssueRequest (
    val summary:String,
    val description: String,
    val type : IssueType,
    val priority: IssuePriority,
    var status: IssueStatus,
)

data class IssueResponse (
    val id : Long,
    val summary:String,
    val description: String,
    val userId: Long,
    val type : IssueType,
    val priority: IssuePriority,
    var status: IssueStatus,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {

        operator fun invoke(issue: Issue) =
            with(issue) { // with (issue) 를 사용하여 this 가 issue 가 됌
                IssueResponse (
                    id = id!!,
                    summary = summary,
                    description = description,
                    userId= userId,
                    type= type,
                    priority=priority,
                    status= status,
                    createdAt =createdAt,
                    updatedAt = updatedAt,
                )
            }
    }
}