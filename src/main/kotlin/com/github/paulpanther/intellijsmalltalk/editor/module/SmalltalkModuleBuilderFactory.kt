package com.github.paulpanther.intellijsmalltalk.editor.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleBuilderFactory

class SmalltalkModuleBuilderFactory: ModuleBuilderFactory() {
    override fun createBuilder() = SmalltalkModuleBuilder()
}
