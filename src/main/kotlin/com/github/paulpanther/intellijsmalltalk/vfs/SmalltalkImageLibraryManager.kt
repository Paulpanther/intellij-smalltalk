package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.vfs.VirtualFile

class SmalltalkImageLibraryManager {
    fun run(project: Project) {
        runWriteAction {

//            val table = LibraryTablesRegistrar.getInstance().getLibraryTable(project)
//            val tableModel = table.modifiableModel
//
//            val lib = table.createLibrary()
//            val model = lib.modifiableModel
//
//            val vs = SmalltalkVirtualFileSystem()
//            model.addRoot(SmalltalkClassVirtualFile(vs, "smalltalk file", null, 42), OrderRootType.SOURCES)
//            model.name = "Smalltalk Lib"
//            model.commit()
//            tableModel.commit()
//
//            ModuleRootModificationUtil.addDependency()
        }
    }
}
