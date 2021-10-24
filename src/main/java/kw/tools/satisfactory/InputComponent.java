package kw.tools.satisfactory;

/**
 * A class that shows base input of a produced item.
 * Base input should be initialized by some configuration.
 */
public class InputComponent
{
    public Item item;
    public int baseInput;

    public InputComponent()
    {

    }

    public InputComponent(Item item, int input)
    {
        this.item = item;
        this.baseInput = input;
    }
}
