package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.language.psi.*
import com.github.paulpanther.intellijsmalltalk.language.psi.impl.SmalltalkVariableImpl
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

object SmalltalkPsiImplUtil {
    @JvmStatic
    fun getNameIdentifier(element: SmalltalkVariable): PsiElement {
        return element.identifier
    }

    @JvmStatic
    fun getName(element: SmalltalkVariable): String {
        return element.text
    }

    @JvmStatic
    fun setName(element: SmalltalkVariable, newName: String): PsiElement {
        return element.replace(SmalltalkVariableImpl(element.node))
    }

    @JvmStatic
    fun getVariables(element: SmalltalkMethod): List<PsiElement> {
        return element.temporaries?.variableList ?: listOf()
    }

    @JvmStatic
    fun getReference(element: SmalltalkIdentifierUsage): PsiReferenceBase<PsiElement> {
        return SmalltalkVariableReference(element)
    }
}
