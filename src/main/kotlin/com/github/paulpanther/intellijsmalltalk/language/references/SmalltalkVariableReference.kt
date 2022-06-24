package com.github.paulpanther.intellijsmalltalk.language.references

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkMethod
import com.github.paulpanther.intellijsmalltalk.recursiveFindInParent
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.parentOfType

class SmalltalkVariableReference(element: PsiElement): PsiReferenceBase<PsiElement>(element, element.textRange) {
    override fun resolve(): PsiElement? {
        return element.recursiveFindInParent<SmalltalkMethod, PsiElement> { parent ->
            parent.variables.find { it.text == element.text }
        }
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, element.textLength)
    }
}
