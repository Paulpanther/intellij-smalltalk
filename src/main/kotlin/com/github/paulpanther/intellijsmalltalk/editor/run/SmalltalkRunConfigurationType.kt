package com.github.paulpanther.intellijsmalltalk.editor.run

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType

class SmalltalkRunConfigurationType: ConfigurationType {
    companion object {
        const val id = "SmalltalkRunConfiguration"
    }

    override fun getDisplayName() = "Smalltalk"

    override fun getConfigurationTypeDescription() = "Run Smalltalk File"

    override fun getIcon() = SmalltalkIcons.file

    override fun getId() = Companion.id

    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(SmalltalkConfigurationFactory(this))
    }
}
