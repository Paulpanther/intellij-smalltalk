package com.github.paulpanther.intellijsmalltalk.editor.module

import com.intellij.ide.util.importProject.ModuleDescriptor
import com.intellij.ide.util.importProject.ProjectDescriptor
import com.intellij.ide.util.projectWizard.importSources.DetectedProjectRoot
import com.intellij.ide.util.projectWizard.importSources.ProjectFromSourcesBuilder
import com.intellij.ide.util.projectWizard.importSources.ProjectStructureDetector
import java.io.File

class SmalltalkProjectStructureDetector: ProjectStructureDetector() {
    override fun detectRoots(
        dir: File,
        children: Array<out File>,
        base: File,
        result: MutableList<DetectedProjectRoot>
    ): DirectoryProcessingResult {
        TODO("Not yet implemented")
    }

    override fun setupProjectStructure(
        roots: MutableCollection<DetectedProjectRoot>,
        projectDescriptor: ProjectDescriptor,
        builder: ProjectFromSourcesBuilder
    ) {
        super.setupProjectStructure(roots, projectDescriptor, builder)
    }
}
