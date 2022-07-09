package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile

class SmalltalkRootVirtualFile(
    mySystem: SmalltalkVirtualFileSystem,
    myChildren: MutableList<SmalltalkVirtualFile> = mutableListOf()
) : SmalltalkDirectoryVirtualFile(mySystem, "/", null, myChildren) {
    override fun findAtPath(path: List<String>): VirtualFile? {
        val next = path[0]
        val child = myChildren.find { it.name == next }
        if (path.size < 2) {
            return child
        }
        return child?.findAtPath(path.slice(1 until path.size))
    }
}
