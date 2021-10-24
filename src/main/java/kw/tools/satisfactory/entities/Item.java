package kw.tools.satisfactory.entities;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    /**
     * Input components with their input amounts.
     * Normal item structure has base inputs specified, while recalculated item have the real needed inputs.
     */
    public List<InputComponent> inputs;

    /**
     *
     */
    public int baseOutput;

    /**
     * Unique name
     */
    public String name;

    /**
     * Indicates that item has no inputs - it's a raw, mined item.
     */
    public boolean raw = false;

    public int getBaseOutput()
    {
        return baseOutput;
    }

    /**
     * Generate a new Item - along with its components tree - with recalculated amounts.
     *
     * @param requested
     * @return
     */
    public Item getItemTreeForOutput(int requested)
    {
        Item newItem = new Item();
        newItem.name = this.name;
        newItem.raw = this.raw;
        newItem.inputs = new ArrayList<>();
        newItem.baseOutput = requested;

        if (raw)
        {
            return newItem;
        }

        for (InputComponent input : inputs)
        {
            int recalculatedInput = (int) Math.ceil((double) requested / baseOutput * input.baseInput);
            newItem.inputs.add(new InputComponent(input.item.getItemTreeForOutput(recalculatedInput), recalculatedInput));
        }
        return newItem;
    }

    @Override
    public String toString()
    {
        return this.name + " (" + baseOutput + ")";
    }

    public String toTreeString(String indent)
    {
        StringBuilder sb = new StringBuilder()
                .append(indent).append(this).append("\n");
        for (InputComponent component : inputs)
        {
            sb.append(component.item.toTreeString(indent + indent));
        }
        return sb.toString();
    }
}
