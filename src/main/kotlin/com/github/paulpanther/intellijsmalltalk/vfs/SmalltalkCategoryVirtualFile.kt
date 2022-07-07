package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile

class SmalltalkCategoryVirtualFile(
    mySystem: SmalltalkVirtualFileSystem,
    myName: String,
    myParent: SmalltalkRootVirtualFile?,
    myChildren: MutableList<SmalltalkVirtualFile>
): SmalltalkDirectoryVirtualFile(mySystem, myName, myParent, myChildren) {

    override fun findAtPath(path: List<String>): VirtualFile? {
        val next = path[0]
        val child = myChildren.find { it.name == next }
        return child?.findAtPath(path.subList(1, path.size))
    }
}
