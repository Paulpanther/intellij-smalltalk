package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.roots.libraries.LibraryTable
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar

class SmalltalkImageLibraryManager {
    fun run() {
        val table = LibraryTablesRegistrar.getInstance().libraryTable
        val lib = table.createLibrary()
        val model = lib.modifiableModel

        val vs = SmalltalkVirtualFileSystem()
        model.addRoot(vs.root)
    }
}
