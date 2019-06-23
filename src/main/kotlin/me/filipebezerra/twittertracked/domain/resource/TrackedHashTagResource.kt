package me.filipebezerra.twittertracked.domain.resource

import me.filipebezerra.twittertracked.domain.TrackedHashTag
import me.filipebezerra.twittertracked.domain.service.TrackedHashTagService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tracked-hash-tag")
class TrackedHashTagResource(private val service: TrackedHashTagService) {

    @GetMapping
    fun all() = service.all()

    @PostMapping
    fun save(@RequestBody trackedHashTag: TrackedHashTag) = service.save(trackedHashTag)
}