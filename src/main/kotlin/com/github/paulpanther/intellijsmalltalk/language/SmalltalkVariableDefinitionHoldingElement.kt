package com.github.paulpanther.intellijsmalltalk.language

import com.intellij.psi.PsiElement

interface SmalltalkVariableDefinitionHoldingElement: PsiElement {
    fun getVariables(): List<PsiElement>
}
