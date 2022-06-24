package com.github.paulpanther.intellijsmalltalk.editor

import com.github.paulpanther.intellijsmalltalk.language.SmalltalkLanguage
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes
import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes.*
import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings

class SmalltalkFormattingModelBuilder: FormattingModelBuilder {
    companion object {
        fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, SmalltalkLanguage)

                .around(ASSIGNMENT_OPERATOR)
                .spaceIf(settings.getCommonSettings(SmalltalkLanguage.id).SPACE_AROUND_ASSIGNMENT_OPERATORS)

                .after(STATEMENT_SEPERATOR)
                .lineBreakInCode()

                .around(BLOCK_VARIABLE_SEPERATOR)
                .spaceIf(settings.getCommonSettings(SmalltalkLanguage.id).SPACE_AROUND_ASSIGNMENT_OPERATORS)

                .between(KEYWORD, IDENTIFIER)
                .spaceIf(settings.getCommonSettings(SmalltalkLanguage.id).SPACE_AFTER_COMMA)

                .between(BLOCK_START, BLOCK_ARGUMENT)
                .spaceIf(settings.getCommonSettings(SmalltalkLanguage.id).SPACE_BEFORE_METHOD_LBRACE)

                .between(BLOCK_ARGUMENTS, STATEMENT)
                .lineBreakInCode()
        }
    }

    override fun createModel(ctx: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            ctx.containingFile,
            SmalltalkBlock(
                ctx.node,
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                createSpaceBuilder(ctx.codeStyleSettings)
            ),
            ctx.codeStyleSettings
        )
    }
}
