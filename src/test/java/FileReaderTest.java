import com.homeserver.entity.StudentDTO;
import com.homeserver.utils.BeanioFileReader;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


/**
 * Created by trung on 04/02/17.
 */
public class FileReaderTest {
    public final static Logger log = Logger.getLogger(FileReaderTest.class);

    @Test
    public void testCSVFileReader() {
        BeanioFileReader<StudentDTO> csvFileReader = new BeanioFileReader<StudentDTO>();
        csvFileReader.setSchemaFilePath("beanio/StudentCSVFile.xml");
        csvFileReader.setSchemaName("students");

        URL url = this.getClass().getResource("data/input/students.csv");
        File file = null;
        try {
            file = new File(url.toURI());
            List<StudentDTO> res = csvFileReader.readFromFile(file);
            if (res != null && !res.isEmpty()) {
                for (StudentDTO student : res) {
                    log.debug(student);
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testXMLFileReader() throws URISyntaxException {
        BeanioFileReader<StudentDTO> xmlFileReader = new BeanioFileReader<StudentDTO>();
        xmlFileReader.setSchemaFilePath("beanio/StudentXMLFIle.xml");
        xmlFileReader.setSchemaName("students");

        URL url = this.getClass().getResource("data/input/students.xml");
        File file = new File(url.toURI());
        List<StudentDTO> res = xmlFileReader.readFromFile(file);
        if (res != null && !res.isEmpty()) {
            for (StudentDTO student : res) {
                log.debug(student);
            }
        }
    }
}
