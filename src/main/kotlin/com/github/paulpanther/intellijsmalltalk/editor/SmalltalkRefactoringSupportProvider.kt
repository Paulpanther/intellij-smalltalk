package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkNamedIdentifier
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement

class SmalltalkRefactoringSupportProvider: RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is SmalltalkNamedIdentifier
    }
}
