package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.intellij.openapi.fileTypes.LanguageFileType

object SmalltalkMethodFileType: LanguageFileType(SmalltalkLanguage) {
    override fun getName() = "Smalltalk Method Declaration File"

    override fun getDescription() = "Smalltalk file in which a new method is declared"

    override fun getDefaultExtension() = "stm"

    override fun getIcon() = SmalltalkIcons.file
}
