package com.github.paulpanther.intellijsmalltalk.language

import com.intellij.psi.tree.IElementType

class SmalltalkTokenType(debugName: String)
    : IElementType(debugName, SmalltalkLanguage) {

    override fun toString(): String {
        return "SmalltalkTokenType." + super.toString()
    }
}
