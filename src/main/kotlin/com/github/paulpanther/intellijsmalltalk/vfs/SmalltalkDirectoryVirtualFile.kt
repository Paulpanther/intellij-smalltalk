package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

abstract class SmalltalkDirectoryVirtualFile(
    mySystem: SmalltalkVirtualFileSystem,
    myName: String,
    myParent: SmalltalkDirectoryVirtualFile?,
    protected val myChildren: MutableList<SmalltalkVirtualFile>
): SmalltalkVirtualFile(mySystem, myName, myParent) {
    override fun isDirectory(): Boolean {
        return true
    }

    override fun getChildren(): Array<VirtualFile> {
        return myChildren.toTypedArray()
    }

    val childrenList by ::myChildren

    override fun getOutputStream(
        requestor: Any?,
        newModificationStamp: Long,
        newTimeStamp: Long
    ): OutputStream {
        return ByteArrayOutputStream()
    }

    override fun contentsToByteArray(): ByteArray {
        return "".toByteArray()
    }

    override fun getLength(): Long {
        return 0
    }

    override fun getInputStream(): InputStream {
        return contentsToByteArray().inputStream()
    }
}
