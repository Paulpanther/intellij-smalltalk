package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.language.psi.*
import com.github.paulpanther.intellijsmalltalk.language.psi.impl.SmalltalkNamedIdentifierImpl
import com.github.paulpanther.intellijsmalltalk.language.psi.impl.SmalltalkVariableImpl
import com.github.paulpanther.intellijsmalltalk.language.references.SmalltalkArgumentReference
import com.github.paulpanther.intellijsmalltalk.language.references.SmalltalkVariableReference
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.impl.source.tree.LeafPsiElement

object SmalltalkPsiImplUtil {
    @JvmStatic
    fun getNameIdentifier(element: SmalltalkNamedIdentifier): PsiElement {
        return element.identifier
    }

    @JvmStatic
    fun getName(element: SmalltalkNamedIdentifier): String {
        return element.text
    }

    @JvmStatic
    fun setName(element: SmalltalkNamedIdentifier, newName: String): PsiElement {
        val oldNode = element.node.firstChildNode as LeafPsiElement
        oldNode.replaceWithText(newName)
        return element
    }

    @JvmStatic
    fun getVariables(element: SmalltalkMethod): List<PsiElement> {
        return element.temporaries?.variableList ?: listOf()
    }

    @JvmStatic
    fun getArguments(element: SmalltalkMethod): List<PsiElement> {
        return element.keywordSelector?.argumentList ?: listOf()
    }

    @JvmStatic
    fun getReferences(element: SmalltalkIdentifierUsage): Array<PsiReferenceBase<PsiElement>> {
        return arrayOf(
            SmalltalkVariableReference(element),
            SmalltalkArgumentReference(element))
    }
}
