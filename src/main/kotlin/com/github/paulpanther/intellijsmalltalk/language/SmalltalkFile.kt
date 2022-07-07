package com.github.paulpanther.intellijsmalltalk.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class SmalltalkFile(view: FileViewProvider) : PsiFileBase(view, SmalltalkLanguage) {

    override fun getFileType() = when (virtualFile?.extension) {
        "stm" -> SmalltalkMethodFileType
        else -> SmalltalkStatementsFileType  // or st
    }

    override fun toString() = "Smalltalk File"
}
