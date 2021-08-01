package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The builder class for creating nodes that store values
 */
public class ValueNodeBuilder {
    private int hPos;
    private int vPos;
    private IdataTypes value;

    /**
     * The constructor of the class
     */
    public ValueNodeBuilder() {
    }

    /**
     * Set the position the node will have
     * @param hPos The horizontal position of the node
     * @param vPos The vertical position of the node
     * @return The builder with the updated position
     */
    public ValueNodeBuilder setPosition(int hPos, int vPos) {
        this.hPos = hPos;
        this.vPos = vPos;
        return this;
    }

    /**
     * Set the value the node will have
     * @param value Tha value for the node
     * @return The builder with the updated value
     */
    public ValueNodeBuilder setValue(IdataTypes value){
        this.value = value;
        return this;
    }

    /**
     * @return The node built with the parameters given to the builder
     */
    public ValueNode build() {
        return new ValueNode(hPos, vPos, value);
    }
}
