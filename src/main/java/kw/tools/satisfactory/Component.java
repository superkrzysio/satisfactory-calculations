package kw.tools.satisfactory;

/**
 * A class that refers to item and its base productivity - either input or output.
 * Base productivity should be initialized by some configuration.
 */
public class Component
{
    public final Item item;
    public final int baseProductivity;

    public Component(Item item, int productivity)
    {
        this.item = item;
        this.baseProductivity = productivity;
    }
}
