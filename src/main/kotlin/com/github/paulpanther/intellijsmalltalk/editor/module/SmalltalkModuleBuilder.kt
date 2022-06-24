package com.github.paulpanther.intellijsmalltalk.editor.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.projectRoots.SdkTypeId

class SmalltalkModuleBuilder: ModuleBuilder() {
    override fun getModuleType() = SmalltalkModuleType

    override fun isSuitableSdkType(sdkType: SdkTypeId?): Boolean {
        return sdkType is SmalltalkImageSdk
    }
}
