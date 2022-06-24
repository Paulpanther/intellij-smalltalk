package com.github.paulpanther.intellijsmalltalk.editor.run

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JComponent
import javax.swing.JPanel

class SmalltalkSettingsEditor: SettingsEditor<SmalltalkRunConfiguration>() {
    private lateinit var myPanel: JPanel
    private lateinit var mySqueakPath: LabeledComponent<TextFieldWithBrowseButton>
    private lateinit var myScriptPath: LabeledComponent<TextFieldWithBrowseButton>
    private lateinit var myImagePath: LabeledComponent<TextFieldWithBrowseButton>

    override fun resetEditorFrom(s: SmalltalkRunConfiguration) {
        mySqueakPath.component.text = s.squeakPath ?: ""
        myScriptPath.component.text = s.scriptPath ?: ""
        myImagePath.component.text = s.imagePath ?: ""
    }

    override fun applyEditorTo(s: SmalltalkRunConfiguration) {
        s.scriptPath = myScriptPath.component?.text ?: ""
        s.imagePath = myImagePath.component?.text ?: ""
        s.squeakPath = mySqueakPath.component?.text ?: ""
    }

    override fun createEditor(): JComponent {
        return myPanel
    }

    private fun createUIComponents() {
        myScriptPath = LabeledComponent()
        myScriptPath.component = TextFieldWithBrowseButton()
        myImagePath = LabeledComponent()
        myImagePath.component = TextFieldWithBrowseButton()
        mySqueakPath = LabeledComponent()
        mySqueakPath.component = TextFieldWithBrowseButton()
    }
}
