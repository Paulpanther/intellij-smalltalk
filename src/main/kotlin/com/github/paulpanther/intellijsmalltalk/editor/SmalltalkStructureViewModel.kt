package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkMethod
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkNamedIdentifier
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class SmalltalkStructureViewModel(
    editor: Editor?,
    psiFile: PsiFile
) : StructureViewModelBase(psiFile, editor, SmalltalkStructureViewElement(psiFile)),
    StructureViewModel.ElementInfoProvider {

    override fun getSorters() = arrayOf(Sorter.ALPHA_SORTER)

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is SmalltalkMethod
    }

    override fun getSuitableClasses(): Array<Class<Any>> {
        return arrayOf(
            SmalltalkMethod::class.java as Class<Any>
        )
    }
}
