package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.SmalltalkLexerAdapter
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class SmalltalkSyntaxHighlighter: SyntaxHighlighterBase() {
    companion object {
        private val keys = mutableMapOf<IElementType, TextAttributesKey>()

        init {
            addKey(SmalltalkTypes.ASSIGNMENT_OPERATOR, OPERATION_SIGN)
            addKey(SmalltalkTypes.BLOCK_START, BRACES)
            addKey(SmalltalkTypes.BLOCK_END, BRACES)
            addKey(SmalltalkTypes.BLOCK_VARIABLE_SEPERATOR, OPERATION_SIGN)
            addKey(SmalltalkTypes.COMMENT, LINE_COMMENT)
            addKey(SmalltalkTypes.TRUE, KEYWORD)
            addKey(SmalltalkTypes.FALSE, KEYWORD)
            addKey(SmalltalkTypes.SELF, KEYWORD)
            addKey(SmalltalkTypes.SUPER, KEYWORD)
            addKey(SmalltalkTypes.NIL, KEYWORD)
            addKey(SmalltalkTypes.IDENTIFIER, IDENTIFIER)
            addKey(SmalltalkTypes.PARENTHESIS_START, PARENTHESES)
            addKey(SmalltalkTypes.PARENTHESIS_END, PARENTHESES)
            addKey(SmalltalkTypes.RETURN_OPERATOR, SEMICOLON)
            addKey(SmalltalkTypes.STRING, STRING)
            addKey(SmalltalkTypes.NUMBER, NUMBER)
            addKey(SmalltalkTypes.STATEMENT_SEPERATOR, SEMICOLON)
            addKey(SmalltalkTypes.KEYWORD, FUNCTION_DECLARATION)
            addKey(SmalltalkTypes.BINARY_OPERATOR, OPERATION_SIGN)
//            addKey(SmalltalkTypes.BLOCK_ARGUMENT, INSTANCE_FIELD)
        }

        private fun addKey(type: IElementType, other: TextAttributesKey) {
            keys[type] = createKey(type, other)
        }

        private fun createKey(type: IElementType, other: TextAttributesKey): TextAttributesKey {
            return TextAttributesKey.createTextAttributesKey("SMALLTALK_${type.debugName}", other)
        }
    }

    override fun getHighlightingLexer() = SmalltalkLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        val key = keys[tokenType]
        return key?.let { arrayOf(key) } ?: arrayOf()
    }
}
