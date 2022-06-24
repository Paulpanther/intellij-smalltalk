package com.github.paulpanther.intellijsmalltalk

import com.intellij.openapi.util.SystemInfo
import java.io.File

object SqueakPathUtil {
    fun findSqueakPath(): File? {
        val command = whichSqueakCommand ?: return null
        val p = Runtime.getRuntime().exec(command)
        if (p.waitFor() != 0) return null

        val output = p.inputStream.bufferedReader().readLine()
        val outFile = File(output)
        if (!outFile.exists() || outFile.name != squeakFileName) return null

        return outFile
    }

    private const val winName = "Squeak.exe"
    private const val unixName = "squeak.sh"

    fun validPath(file: File) = file.exists() && file.extension == "image"

    private val squeakFileName get() = when {
        SystemInfo.isWindows -> winName
        SystemInfo.isLinux -> unixName
        else -> null
    }

    private val whichSqueakCommand get() = when {
        SystemInfo.isWindows -> arrayOf("where", winName)
        SystemInfo.isLinux -> arrayOf("which", unixName)
        else -> null
    }
}
