package com.github.paulpanther.intellijsmalltalk.editor

import com.intellij.lang.Commenter

class SmalltalkCommenter: Commenter {
    override fun getLineCommentPrefix() = null

    override fun getBlockCommentPrefix() = "\""
    override fun getBlockCommentSuffix() = "\""

    override fun getCommentedBlockCommentPrefix() = null
    override fun getCommentedBlockCommentSuffix() = null
}
