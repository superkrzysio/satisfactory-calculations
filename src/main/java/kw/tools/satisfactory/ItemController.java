package kw.tools.satisfactory;

import kw.tools.satisfactory.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public ModelAndView redirect(
            @RequestParam(value = "item", required = false) String selectedItem,
            @RequestParam(value = "count", required = false, defaultValue = "0") int requestedCount)
    {
        ModelAndView view = new ModelAndView("index");
        view.addObject("items", itemService.getAllItems());
        view.addObject("selectedItem", selectedItem);
        view.addObject("selectedCount", requestedCount);

        Item item = fetchItem(selectedItem);
        if (requestedCount > 0 && item != null)
        {
            Item recalculated = item.getItemTreeForOutput(requestedCount);
            view.addObject("itemTree", recalculated.toTreeString("  "));
        }
        return view;
    }

    private Item fetchItem(String name)
    {
        try
        {
            return itemService.getByName(name);
        } catch (IllegalArgumentException e)
        {
            return null;
        }
    }
}
