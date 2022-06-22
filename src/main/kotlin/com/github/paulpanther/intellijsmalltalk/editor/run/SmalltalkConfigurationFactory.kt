package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

class SmalltalkConfigurationFactory(type: ConfigurationType): ConfigurationFactory(type) {
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return SmalltalkRunConfiguration(project, this, "Smalltalk")
    }

    override fun getId() = SmalltalkRunConfigurationType.id

    override fun getOptionsClass(): Class<out BaseState>? {
        return SmalltalkRunConfigurationOptions::class.java
    }
}
