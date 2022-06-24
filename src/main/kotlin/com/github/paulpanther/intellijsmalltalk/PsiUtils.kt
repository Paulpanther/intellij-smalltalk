package com.github.paulpanther.intellijsmalltalk

import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType

inline fun <reified T : PsiElement, K> PsiElement.recursiveFindInParent(
    find: (T) -> K?
): K? {
    var elem = parentOfType<T>()

    while (elem != null) {
        find(elem)?.let {
            return it
        }
        elem = elem.parentOfType()
    }

    return null
}
