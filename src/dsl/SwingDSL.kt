package dsl

import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.net.URL
import javax.swing.*

typealias FontSize = Int
typealias Width = Int
typealias Height = Int
typealias CoordinateX = Int
typealias CoordinateY = Int

inline fun JFrame.frame(title: String = "", init: JFrame.() -> Unit): JFrame = apply {
    this.title = title
    init()
}

inline fun JFrame.panel(init: JPanel.() -> Unit): JPanel = JPanel().apply {
    init()
}.also { contentPane = it }

inline fun JPanel.button(label: String = "", init: JButton.() -> Unit): JButton = JButton(label).apply {
    init()
}.also { add(it) }

inline fun JPanel.textfield(label: String = "", init: JTextField.() -> Unit): JTextField = JTextField(label).apply {
    init()
}.also { add(it) }

inline fun JPanel.label(label: String = "", init: JLabel.() -> Unit): JLabel = JLabel(label).apply {
    init()
}.also { add(it) }


inline fun <reified T> resource(resourceDestination: String): URL {
    return T::class.java.getResource(resourceDestination)
}

fun rectangle(x: CoordinateX = 0, y: CoordinateY = 0, dimension: Dimension): Rectangle = Rectangle(x, y, dimension.width, dimension.height)

infix fun Width.x(height: Height) = Dimension(this, height)

fun blackText(text: String) = "<html><font color='black'>$text</font></html>"

fun boldFont(font: String, size: FontSize = 14) = Font(font, Font.BOLD, size)