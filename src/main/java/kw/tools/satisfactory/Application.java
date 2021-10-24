package kw.tools.satisfactory;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;

public class Application
{
    public static void main(String[] args) throws IOException
    {
        new Application().parse();
    }

    public void parse() throws IOException
    {
        Yaml yaml = new Yaml(new Constructor(ItemList.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("items.yaml");
        ItemList items = yaml.load(inputStream);
    }
}
