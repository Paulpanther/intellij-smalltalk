package com.github.paulpanther.intellijsmalltalk.services

import com.intellij.openapi.project.Project
import com.github.paulpanther.intellijsmalltalk.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
