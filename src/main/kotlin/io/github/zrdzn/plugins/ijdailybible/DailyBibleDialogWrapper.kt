package io.github.zrdzn.plugins.ijdailybible

import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel
import com.intellij.openapi.ui.DialogWrapper
import java.awt.Dimension
import javax.swing.JTextArea
import org.jsoup.Jsoup

class DailyBibleDialogWrapper: DialogWrapper(true) {

    init {
        title = "Daily Verse from the Bible"
        isResizable = false
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(BorderLayout())

        val bibleSite = Jsoup.connect("https://www.verseoftheday.com/").get()
        val verse = bibleSite.selectFirst("div.bilingual-left").text()

        val textArea = JTextArea(verse)
        textArea.lineWrap = true
        textArea.size = Dimension(700, 80)
        textArea.isEditable = false
        dialogPanel.add(textArea, BorderLayout.CENTER)

        return dialogPanel
    }

}
