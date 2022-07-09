package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileSystem
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

class MyTestVirtualFile(
    val myName: String,
): VirtualFile() {
    private val vs = SmalltalkVirtualFileSystem()

    override fun getPath(): String {
        return "C:$myName"
    }

    override fun getName(): String {
        return myName
    }

    override fun getParent(): VirtualFile? {
        return null
    }

    override fun getChildren(): Array<VirtualFile> {
        return arrayOf()
    }

    override fun getOutputStream(requestor: Any?, newModificationStamp: Long, newTimeStamp: Long): OutputStream {
        return ByteArrayOutputStream()
    }

    override fun contentsToByteArray(): ByteArray {
        return "hey".toByteArray()
    }

    override fun getFileSystem(): VirtualFileSystem {
        return vs
    }

    override fun isWritable(): Boolean {
        return false
    }

    override fun isDirectory(): Boolean {
        return false
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun getTimeStamp(): Long {
        return 0
    }

    override fun getLength(): Long {
        return 10
    }

    override fun refresh(
        asynchronous: Boolean,
        recursive: Boolean,
        postRunnable: Runnable?
    ) {
    }

    override fun getInputStream(): InputStream {
        return contentsToByteArray().inputStream()
    }
}
