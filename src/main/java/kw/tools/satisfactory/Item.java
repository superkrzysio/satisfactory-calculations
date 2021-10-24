package kw.tools.satisfactory;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    public List<InputComponent> inputs;
    public int baseOutput;
    public String name;

    /**
     * Indicates that item has no inputs - it's a raw, mined item.
     */
    public boolean raw = false;

    public int getBaseOutput()
    {
        return baseOutput;
    }

    public List<InputComponent> getInputsForOutput(int requested)
    {
        if (raw)
        {
            throw new IllegalStateException("This item has no inputs");
        }

        List<InputComponent> requestedOutputs = new ArrayList<>();
        for (InputComponent input : inputs)
        {
            int recalculatedInput = (int) Math.ceil((double) requested / baseOutput * input.baseInput);
            requestedOutputs.add(new InputComponent(input.item, recalculatedInput));
        }
        return requestedOutputs;
    }
}
