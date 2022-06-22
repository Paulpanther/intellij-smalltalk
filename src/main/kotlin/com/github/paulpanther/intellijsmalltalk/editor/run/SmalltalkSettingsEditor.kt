package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JComponent
import javax.swing.JPanel

class SmalltalkSettingsEditor: SettingsEditor<SmalltalkRunConfiguration>() {
    private lateinit var myPanel: JPanel
    private lateinit var myScriptName: LabeledComponent<TextFieldWithBrowseButton>
    private lateinit var myImageName: LabeledComponent<TextFieldWithBrowseButton>

    override fun resetEditorFrom(s: SmalltalkRunConfiguration) {
        myScriptName.component.text = s.scriptName ?: ""
        myImageName.component.text = s.imageName ?: ""
    }

    override fun applyEditorTo(s: SmalltalkRunConfiguration) {
        s.scriptName = myScriptName.component?.text ?: ""
        s.imageName = myImageName.component?.text ?: ""
    }

    override fun createEditor(): JComponent {
        return myPanel
    }

    private fun createUIComponents() {
        myScriptName = LabeledComponent()
        myScriptName.component = TextFieldWithBrowseButton()
        myImageName = LabeledComponent()
        myImageName.component = TextFieldWithBrowseButton()
    }
}
