package me.filipebezerra.twittertracked.domain.service

import me.filipebezerra.twittertracked.domain.TrackedHashTag
import me.filipebezerra.twittertracked.domain.repository.TrackedHashTagRepository
import org.springframework.stereotype.Service

@Service
class TrackedHashTagService(private val repository: TrackedHashTagRepository) {

    fun save(trackedHashTag: TrackedHashTag) = repository.save(trackedHashTag)

    fun all() = repository.findAll()
}