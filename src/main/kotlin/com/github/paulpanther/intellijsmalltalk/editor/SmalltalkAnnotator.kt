package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkIdentifierUsage
import com.github.paulpanther.intellijsmalltalk.language.references.SmalltalkArgumentReference
import com.github.paulpanther.intellijsmalltalk.language.references.SmalltalkVariableReference
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class SmalltalkAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is SmalltalkIdentifierUsage) {
            if (!hasRef(element)) {
                holder
                    .newAnnotation(HighlightSeverity.ERROR, "Unresolved identifier")
                    .range(element.textRange)
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    .create()
            }
        }
    }

    private fun hasRef(elem: SmalltalkIdentifierUsage): Boolean {
        return SmalltalkVariableReference(elem).resolve() != null
                || SmalltalkArgumentReference(elem).resolve() != null
    }
}
