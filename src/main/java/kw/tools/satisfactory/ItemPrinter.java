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

    public String htmlPrinter(Item item)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<li><a href=\"#\">").append(item).append("</a>").append("\n");

        if (!item.inputs.isEmpty())
        {
            sb.append("<ul>\n");
            for (InputComponent component : item.inputs)
            {
                sb.append(htmlPrinter(component.item));
            }
            sb.append("</ul>\n");
        }

        sb.append("</li>\n");
        return sb.toString();
    }
}
