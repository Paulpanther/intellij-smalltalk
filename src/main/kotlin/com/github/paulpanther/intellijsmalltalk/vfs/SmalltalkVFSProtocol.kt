package com.github.paulpanther.intellijsmalltalk.vfs

import com.github.paulpanther.intellijsmalltalk.connection.ConnectionClient

//data class SVFSFileReferences(
//    val all: List<SVFSFileReference>)
//
data class SVFSFileReference(
    val category: String,
    val name: String,
    val length: Long)

data class SVFSFileAndContent(
    val file: String,
    val content: String)

private class SVFSRequest(val type: String)

private class SVFSDataRequest(val type: String, val data: Any)

object SmalltalkVFSProtocol {
    fun getAllFiles(): List<SVFSFileReference> {
        return ConnectionClient.send(
            SVFSRequest("get-files"))
    }

    fun getContent(file: String): String {
        return ConnectionClient.send(SVFSDataRequest("get-content", file))
    }

    fun setContent(file: String, content: String): String {
        return ConnectionClient.send(SVFSDataRequest("set-content", SVFSFileAndContent(file, content)))
    }
}
