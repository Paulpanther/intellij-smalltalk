package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.intellij.openapi.fileTypes.LanguageFileType

object SmalltalkStatementsFileType: LanguageFileType(SmalltalkLanguage) {
    override fun getName() = "Smalltalk Code File"

    override fun getDescription() = "Smalltalk executable code file"

    override fun getDefaultExtension() = "st"

    override fun getIcon() = SmalltalkIcons.file
}
