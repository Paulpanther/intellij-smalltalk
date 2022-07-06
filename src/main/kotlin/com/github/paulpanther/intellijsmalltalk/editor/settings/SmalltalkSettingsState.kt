package com.github.paulpanther.intellijsmalltalk.editor.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.github.paulpanther.intellijsmalltalk.editor.settings.SmalltalkSettingsState",
    storages = [Storage("SqueakExeSettings.xml")] )
class SmalltalkSettingsState: PersistentStateComponent<SmalltalkSettingsState> {

    var squeakExePath = ""
    var squeakImagePath = ""

    override fun getState() = this

    override fun loadState(state: SmalltalkSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}
