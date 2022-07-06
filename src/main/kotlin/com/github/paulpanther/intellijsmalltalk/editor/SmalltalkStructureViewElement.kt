package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.SmalltalkFile
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkMethod
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class SmalltalkStructureViewElement(
    private val myElement: NavigatablePsiElement
): StructureViewTreeElement, SortableTreeElement {

    override fun getPresentation(): ItemPresentation {
        return myElement.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        return if (myElement is SmalltalkFile) {
            val methods = myElement.children.filterIsInstance<SmalltalkMethod>()
            return methods.map { SmalltalkStructureViewElement(it as NavigatablePsiElement) }.toTypedArray()
        } else {
            arrayOf()
        }
    }

    override fun navigate(requestFocus: Boolean) {
        myElement.navigate(requestFocus)
    }

    override fun canNavigate() = myElement.canNavigate()

    override fun canNavigateToSource() = myElement.canNavigateToSource()

    override fun getValue() = myElement

    override fun getAlphaSortKey(): String = myElement.text
}
