package io.github.zrdzn.plugins.ijdailybible

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import org.jetbrains.annotations.NotNull

class DailyBibleListener: ProjectManagerListener {

    override fun projectOpened(@NotNull project: Project) {
        DailyBibleDialogWrapper().show()
    }

}
