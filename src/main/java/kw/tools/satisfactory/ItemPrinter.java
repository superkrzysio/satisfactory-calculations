package kw.tools.satisfactory;

import kw.tools.satisfactory.entities.InputComponent;
import kw.tools.satisfactory.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemPrinter
{
    public final static String INDENT = "  ";

    public String printedTree(Item item)
    {
        return printedTree(item, 0);
    }

    public String printedTree(Item item, int indentLevel)
    {
        StringBuilder sb = new StringBuilder()
                .append(INDENT.repeat(indentLevel)).append(item).append("\n");
        for (InputComponent component : item.inputs)
        {
            sb.append(printedTree(component.item, indentLevel+1));
        }
        return sb.toString();
    }
}
