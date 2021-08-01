package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

/**
 * The class that has a node which encapsulates a value of some type.
 * This value is then drawn thanks to the node.
 */
class ValueNode {
    protected int hPos;
    protected int vPos;
    private Text text;
    private IdataTypes value;

    /**
     * The constructor of the class, used by the builder
     * @param hPos The horizontal position of the node
     * @param vPos The vertical position of the node
     * @param value The value that it encapsulates
     */
    protected ValueNode(final int hPos, final int vPos, @NotNull IdataTypes value){
        this.hPos = hPos;
        this.vPos = vPos;
        this.value = value;
        text = new Text(value.toString());
        text.setX(hPos);
        text.setY(vPos);
        text.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
    }

    /**
     * @return Get the value of the node
     */
    public IdataTypes getValue(){
        return this.value;
    }

    /**
     * @return Get the node itself for later drawing
     */
    public Text getNode() {
        return text;
    }
}
