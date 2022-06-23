package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.execution.configurations.RunConfigurationOptions

class SmalltalkRunConfigurationOptions: RunConfigurationOptions() {
    var squeakPath: String? by string("").provideDelegate(this, this::squeakPath)
    var scriptPath: String? by string("").provideDelegate(this, this::scriptPath)
    var imagePath: String? by string("").provideDelegate(this, this::imagePath)
}
