package kw.tools.satisfactory;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    public List<Component> inputs;
    public Component output;
    public String name;

    /**
     * Indicates that item has no inputs - it's a raw, mined item.
     */
    public boolean raw;


    public int getBaseOutput()
    {
        return output.baseProductivity;
    }

    public List<Component> getInputsForOutput(int requested)
    {
        if(raw)
        {
            throw new IllegalAccessError("This item has no inputs");
        }

        List<Component> requestedOutputs = new ArrayList<>();
        for (Component input : inputs)
        {
            int recalculatedInput = (int) Math.ceil((double) requested / output.baseProductivity * input.baseProductivity);
            requestedOutputs.add(new Component(input.item, recalculatedInput));
        }
        return requestedOutputs;
    }
}
