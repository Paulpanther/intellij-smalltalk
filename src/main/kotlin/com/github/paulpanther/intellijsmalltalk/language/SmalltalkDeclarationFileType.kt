package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.intellij.openapi.fileTypes.LanguageFileType

object SmalltalkDeclarationFileType: LanguageFileType(SmalltalkLanguage) {
    override fun getName() = "Smalltalk Instance / Class File"

    override fun getDescription() = "Smalltalk file where a new instance or class is declared"

    override fun getDefaultExtension() = "stc"

    override fun getIcon() = SmalltalkIcons.file
}
