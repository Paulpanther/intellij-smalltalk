package com.github.paulpanther.intellijsmalltalk.language

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class SmalltalkParserDefinition: ParserDefinition {

    companion object {
        val FILE = IFileElementType(SmalltalkLanguage)

        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENT = TokenSet.create(SmalltalkTypes.COMMENT)
    }

    override fun createLexer(project: Project?) = SmalltalkLexerAdapter()

    override fun createParser(project: Project?) = SmalltalkParser()

    override fun getFileNodeType() = FILE

    override fun getCommentTokens() = COMMENT

    override fun getWhitespaceTokens() = WHITE_SPACES

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement {
        return SmalltalkTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SmalltalkFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(
        left: ASTNode?,
        right: ASTNode?
    ): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}
