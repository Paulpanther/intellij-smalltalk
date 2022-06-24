package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes.*
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class SmalltalkBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, wrap, alignment) {
    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()

        var child = myNode.firstChildNode
        while (child != null) {
            if (child.elementType != TokenType.WHITE_SPACE) {
                blocks += SmalltalkBlock(
                    child,
                    Wrap.createWrap(WrapType.NONE, false),
                    Alignment.createAlignment(),
                    spacingBuilder)
            }

            child = child.treeNext
        }

        return blocks
    }

    override fun getIndent(): Indent? {
        return if (isInBlock) {
            Indent.getNormalIndent()
        } else {
            Indent.getNoneIndent()
        }
    }

    private val isInBlock get() = node.treeParent?.elementType == BLOCK && node.elementType != BLOCK_START && node.elementType != BLOCK_END
}
