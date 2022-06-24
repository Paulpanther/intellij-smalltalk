package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class SmalltalkRunConfiguration(
    project: Project,
    factory: ConfigurationFactory,
    name: String
): RunConfigurationBase<SmalltalkRunConfigurationOptions>(project, factory, name) {

    override fun getOptions(): SmalltalkRunConfigurationOptions {
        return super.getOptions() as SmalltalkRunConfigurationOptions
    }

    var squeakPath by options::squeakPath
    var scriptPath by options::scriptPath
    var imagePath by options::imagePath

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return SmalltalkSettingsEditor()
    }

    override fun checkConfiguration() {
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return object: CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val commandLine = GeneralCommandLine(squeakPath, "-vm-display-null", imagePath, scriptPath)
                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
                ProcessTerminatedListener.attach(processHandler)
                return processHandler
            }
        }
    }
}
