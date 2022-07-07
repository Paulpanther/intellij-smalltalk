package com.github.paulpanther.intellijsmalltalk.connection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*

object ConnectionClient: WebSocketListener() {
    private val client = OkHttpClient()
    private var socket: WebSocket? = null
    private var response: String? = null
    val gson = GsonBuilder().create()

    fun run() {
        val req = Request.Builder()
            .url("ws://localhost:2424")
            .build()
        socket = client.newWebSocket(req, this)
        socket?.send("Hello")
    }

    fun sendRaw(message: String): String {
        if (socket == null) run()

        socket?.send(message)
        while (response == null) {
            Thread.sleep(1)
        }

        val res = response
        response = null
        return res ?: ""
    }

    inline fun <reified T> send(message: Any): T {
        val res = sendRaw(gson.toJson(message))
        return gson.fromJson(res, T::class.java)
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {}

    override fun onFailure(
        webSocket: WebSocket,
        t: Throwable,
        response: Response?
    ) {
        throw t
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        println(text)
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {}
}
