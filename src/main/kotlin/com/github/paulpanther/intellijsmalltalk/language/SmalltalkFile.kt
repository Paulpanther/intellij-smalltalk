package com.github.paulpanther.intellijsmalltalk.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class SmalltalkFile(view: FileViewProvider)
    : PsiFileBase(view, SmalltalkLanguage) {

    override fun getFileType() = SmalltalkFileType

    override fun toString() = "Smalltalk File"
}
