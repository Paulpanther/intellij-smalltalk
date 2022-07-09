package com.github.paulpanther.intellijsmalltalk.vfs

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFileSystem

class SmalltalkVirtualFileSystem: VirtualFileSystem() {
    override fun getProtocol() = "squeak-ws"

    val root = SmalltalkRootVirtualFile(this)

    override fun findFileByPath(path: String): VirtualFile? {
        if (!path.startsWith("/")) return null
        if (path == "/") return root

        val pathParts = path.slice(1 until path.length).split("/")
        return root.findAtPath(pathParts)
    }

    override fun refresh(asynchronous: Boolean) {
        val allFiles = SmalltalkVFSProtocol.getAllFiles()

        root.childrenList.clear()
        val categories = allFiles
            .map { it.category }
            .distinct()
            .associateWith { SmalltalkCategoryVirtualFile(this, it, root)
                .also { category -> root.childrenList += category } }
        allFiles
            .map {
                val category = categories[it.category]!!
                SmalltalkClassVirtualFile(this, it.name, category, it.length)
                    .also { file -> category.childrenList += file }
            }

    }

    override fun refreshAndFindFileByPath(path: String): VirtualFile? {
        refresh(false)
        return findFileByPath(path)
    }

    override fun addVirtualFileListener(listener: VirtualFileListener) {
        // TODO("Not yet implemented")
    }

    override fun removeVirtualFileListener(listener: VirtualFileListener) {
        // TODO("Not yet implemented")
    }

    override fun deleteFile(requestor: Any?, vFile: VirtualFile) {
        // TODO("Not yet implemented")
    }

    override fun moveFile(
        requestor: Any?,
        vFile: VirtualFile,
        newParent: VirtualFile
    ) {
        // TODO("Not yet implemented")
    }

    override fun renameFile(
        requestor: Any?,
        vFile: VirtualFile,
        newName: String
    ) {
        // TODO("Not yet implemented")
    }

    override fun createChildFile(
        requestor: Any?,
        vDir: VirtualFile,
        fileName: String
    ): VirtualFile {
        // TODO("Not yet implemented")
        return vDir
    }

    override fun createChildDirectory(
        requestor: Any?,
        vDir: VirtualFile,
        dirName: String
    ): VirtualFile {
        // TODO("Not yet implemented")
        return vDir
    }

    override fun copyFile(
        requestor: Any?,
        virtualFile: VirtualFile,
        newParent: VirtualFile,
        copyName: String
    ): VirtualFile {
        // TODO("Not yet implemented")
        return virtualFile
    }

    override fun isReadOnly(): Boolean {
        // TODO("Not yet implemented")
        return false
    }
}
