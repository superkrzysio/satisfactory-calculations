package kw.tools.satisfactory;

import kw.tools.satisfactory.entities.Item;
import kw.tools.satisfactory.entities.ItemList;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.List;

@Service
public class ItemService
{
    private final List<Item> items;

    public ItemService()
    {
        Yaml yaml = new Yaml(new Constructor(ItemList.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("items.yaml");
        items = ((ItemList) yaml.load(inputStream)).items;
    }

    public List<Item> getAllItems()
    {
        return List.copyOf(items);
    }

    public Item getByName(String name)
    {
        return items.stream().filter(i -> i.name.equals(name)).findFirst().orElseThrow(
                () -> {
                    throw new IllegalArgumentException("Item " + name + "does not exist");
                }
        );
    }
}
