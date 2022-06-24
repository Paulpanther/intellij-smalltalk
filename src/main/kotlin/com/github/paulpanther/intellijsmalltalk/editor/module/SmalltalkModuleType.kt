package com.github.paulpanther.intellijsmalltalk.editor.module

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.projectRoots.Sdk
import javax.swing.Icon

private const val id = "SMALLTALK_TYPE"

object SmalltalkModuleType: ModuleType<SmalltalkModuleBuilder>(id) {
    override fun createModuleBuilder() = SmalltalkModuleBuilder()

    override fun getName() = "Smalltalk"

    override fun getDescription() = "Create new Smalltalk Module"

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return SmalltalkIcons.file
    }
}
