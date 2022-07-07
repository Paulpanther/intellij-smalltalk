package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset

class SmalltalkClassVirtualFile(
    mySystem: SmalltalkVirtualFileSystem,
    myName: String,
    myCategory: SmalltalkCategoryVirtualFile,
    private val myLength: Long
): SmalltalkVirtualFile(mySystem, myName, myCategory) {
    private var content: String? = null

    override fun findAtPath(path: List<String>): VirtualFile? {
        return if (path.size == 1 && myName == path[0]) {
            this
        } else {
            null
        }
    }

    override fun isDirectory() = false

    override fun getChildren(): Array<VirtualFile> {
        return arrayOf()
    }

    override fun getOutputStream(
        requestor: Any?,
        newModificationStamp: Long,
        newTimeStamp: Long
    ): OutputStream {
        val stream = ByteArrayOutputStream()

        return object: OutputStream() {
            override fun write(b: Int) {
                stream.write(b)
            }

            override fun close() {
                content = stream.toString(Charset.defaultCharset())
                super.close()
            }
        }
    }

    override fun contentsToByteArray(): ByteArray {
        loadContent()
        return content?.toByteArray() ?: error("Content unloaded")
    }

    override fun getLength(): Long {
        return myLength
    }

    override fun refresh(
        asynchronous: Boolean,
        recursive: Boolean,
        postRunnable: Runnable?
    ) {
        // TODO("Not yet implemented")
    }

    override fun getInputStream(): InputStream {
        loadContent()
        return content?.byteInputStream() ?: error("Content unloaded")
    }

    private fun loadContent() {
        if (content == null) {
            content = SmalltalkVFSProtocol.getContent(name)
        }
    }
}
