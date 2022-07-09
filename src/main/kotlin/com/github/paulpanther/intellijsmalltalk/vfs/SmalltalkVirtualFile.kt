package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileSystem

abstract class SmalltalkVirtualFile(
    protected val myFileSystem: SmalltalkVirtualFileSystem,
    protected val myName: String,
    protected val myParent: SmalltalkDirectoryVirtualFile?,
): VirtualFile() {
    abstract fun findAtPath(path: List<String>): VirtualFile?

    override fun getPath(): String {
        val parentPath = myParent?.path?.let { "$it/" } ?: ""
        return "$parentPath$myName"
    }

    override fun getName(): String {
        return myName
    }

    override fun getParent(): VirtualFile? {
        return myParent
    }

    override fun getFileSystem(): VirtualFileSystem {
        return myFileSystem
    }

    override fun isWritable(): Boolean {
        return true
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun getTimeStamp(): Long {
        // TODO
        return 0
    }

    override fun refresh(
        asynchronous: Boolean,
        recursive: Boolean,
        postRunnable: Runnable?
    ) {
        // TODO("Not yet implemented")
    }
}
