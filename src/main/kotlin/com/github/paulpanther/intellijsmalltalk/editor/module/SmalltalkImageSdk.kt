package com.github.paulpanther.intellijsmalltalk.editor.module

import com.github.paulpanther.intellijsmalltalk.SqueakPathUtil
import com.intellij.openapi.projectRoots.*
import org.jdom.Element
import java.io.File

class SmalltalkImageSdk: SdkType("Smalltalk Image") {
    override fun suggestHomePath(): String? {
        val squeak = SqueakPathUtil.findSqueakPath()
        return squeak?.parentFile?.absolutePath
    }

    override fun isValidSdkHome(path: String): Boolean {
        return SqueakPathUtil.validPath(File(path))
    }

    override fun suggestSdkName(
        currentSdkName: String?,
        sdkHome: String
    ): String {
        return "Bert"
    }

    override fun getPresentableName() = "Smalltalk Image"

    override fun saveAdditionalData(
        additionalData: SdkAdditionalData,
        additional: Element
    ) {}

    override fun createAdditionalDataConfigurable(
        sdkModel: SdkModel,
        sdkModificator: SdkModificator
    ) = null
}
