import base.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    public static Properties fileReader(String filePath) throws IOException {

        File f1 = new File(System.getProperty("user.dir")+filePath);
        FileInputStream fileinput = null;
        fileinput = new FileInputStream(f1);
        Properties prop = new Properties();
        prop.load(fileinput);
        String browser=prop.getProperty("browser");
        System.out.println(browser);
        BaseClass.browserName=browser;
        return prop;
    }
}
