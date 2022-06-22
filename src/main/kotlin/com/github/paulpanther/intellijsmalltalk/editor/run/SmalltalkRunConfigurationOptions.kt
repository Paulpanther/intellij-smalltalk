package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.execution.configurations.RunConfigurationOptions

class SmalltalkRunConfigurationOptions: RunConfigurationOptions() {
    private val myScriptName = string("").provideDelegate(this, "scriptName")
    private val myImageName = string("").provideDelegate(this, "imageName")

    var scriptName: String?
        get() = myScriptName.getValue(this)
        set(value) {
            myScriptName.setValue(this, value)
        }

    var imageName: String?
        get() = myImageName.getValue(this)
        set(value) {
            myImageName.setValue(this, value)
        }
}
