package com.github.paulpanther.intellijsmalltalk.connection

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ConnectionStartAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        ConnectionClient().run()
    }
}
