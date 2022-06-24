package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkMethod
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.parentOfType

class SmalltalkVariableReference(element: PsiElement): PsiReferenceBase<PsiElement>(element, element.textRange) {
    override fun resolve(): PsiElement? {
        var elem: SmalltalkMethod?

        do {
            elem = element.parentOfType()
            val variables = elem?.variables
            variables?.find { it.text == element.text }?.let {
                return it
            }
        } while (elem != null)

        return null
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, element.textLength)
    }
}
