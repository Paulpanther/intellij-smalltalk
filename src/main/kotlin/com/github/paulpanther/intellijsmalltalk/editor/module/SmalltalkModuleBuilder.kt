package com.github.paulpanther.intellijsmalltalk.editor.module

import com.github.paulpanther.intellijsmalltalk.SmalltalkIcons
import com.github.paulpanther.intellijsmalltalk.vfs.MyTestVirtualFile
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModificationUtil
import javax.swing.Icon

class SmalltalkModuleBuilder: ModuleBuilder() {
    override fun getModuleType() = SmalltalkModuleType

    override fun isSuitableSdkType(sdkType: SdkTypeId?): Boolean {
        return sdkType is SmalltalkImageSdk
    }

    override fun getBuilderId() = "smalltalk"

    override fun getNodeIcon(): Icon {
        return SmalltalkIcons.file
    }

    override fun getDescription(): String {
        return "Hello this is Smalltalk Module Builder description hey hey hey"
    }

    override fun getPresentableName(): String {
        return "Smalltalk Module"
    }

    override fun getGroupName(): String {
        return "Smalltalk"
    }

    override fun setupModule(module: Module?) {
        if (module != null) {
            runWriteAction {
                ModuleRootModificationUtil.addContentRoot(module, MyTestVirtualFile("hellofile"))
                ModuleRootModificationUtil.addModuleLibrary()
//                val moduleModel = ModuleRootManager.getInstance(module).modifiableModel
//                moduleModel.add
//                val table = moduleModel.moduleLibraryTable
//                val lib = table.createLibrary("Smalltalk Lib")
//                val libModel = lib.modifiableModel
//                libModel.commit()
//                moduleModel.commit()
            }
        }
        super.setupModule(module)
    }
}
