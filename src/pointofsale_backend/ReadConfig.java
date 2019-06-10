/*
 * Copyright 2019 Rifky <qnoy.rifky@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pointofsale_backend;

import org.apache.commons.configuration.PropertiesConfiguration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.configuration.ConfigurationException;
import static pointofsale_backend.Library.get_fullPath;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 * https://www.mkyong.com/java/how-to-read-file-in-java-fileinputstream/
 * https://agung-setiawan.com/mengambil-konfigurasi-commons-config/
 */
public class ReadConfig {

    private static PropertiesConfiguration configuration = new PropertiesConfiguration();
    private static Properties properti = new Properties();
    private static FileInputStream file_inputStream;
    
    //constructor
    public ReadConfig() {
        loadConfig();
    }
    
    /**
    * mengambil value dari parameter
    * @param getParams
    * @return String
     */
    public String get_config(String getParams){
        return configuration.getString(getParams); 
    }
    /**
     * load file pointofsale_config.ini
     * mengambil value dari parameter yang ada di dalam file *.ini
     *
     */
    private static void loadConfig() {
        try {
            String dir_iniFile = get_fullPath("config/pointofsale_config.ini");
            //boolean directoryExists = new java.io.File(dir_iniFile).exists();
                FileInputStream file = new FileInputStream(dir_iniFile);
                configuration.load(file);
        } catch (ConfigurationException  | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Tidak ada file .ini !\n"+ex);
            Logger.getLogger(ReadConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
