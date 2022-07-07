package com.github.paulpanther.intellijsmalltalk.language;

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.impl.source.resolve.FileContextUtil

class SmalltalkParserUtil: GeneratedParserUtilBase() {

	companion object {
		@JvmStatic
		fun isMethodFile(builder: PsiBuilder, level: Int): Boolean {
			val file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY)
			return file != null && file.fileType == SmalltalkMethodFileType
		}

		@JvmStatic
		fun isStatementFile(builder: PsiBuilder, level: Int): Boolean {
			val file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY)
			return file != null && file.fileType == SmalltalkStatementsFileType
		}
	}
}
