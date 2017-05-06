package junit.practiceTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import junit.practice.*;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class FrameworksTest {

	@DataPoints
	public static ApplicationServer[] APP_SERVER_PARAM = ApplicationServer.values();

	@DataPoints
	public static Database[] DATABASE_PARAM = Database.values();
	static Map<String, Boolean> SUPPORTS = new HashMap<String, Boolean>();

	@BeforeClass
	public static void setUpClass() throws Exception {
		InputStream in = FrameworksTest.class.getResourceAsStream("support.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(in));
			for(;;) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}

				String[] params = line.split("\\|");
				SUPPORTS.put(params[0] + "-" + params[1], Boolean.valueOf(params[2]));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	@Theory
	public void isSupportはtrueを返す(ApplicationServer appServer, Database db) throws Exception {
		assumeTrue(isSupport(appServer, db));
		String desc = ", AppServer:" + appServer + ", DB:" + db;
		assertThat(desc, Frameworks.isSupport(appServer, db), is(true));
	}

	@Theory
	public void isSupportはfalseを返す(ApplicationServer appServer, Database db) throws Exception {
		assumeTrue(!isSupport(appServer, db));
		String desc = ", AppServer:" + appServer + ", DB:" + db;
		assertThat(desc, Frameworks.isSupport(appServer, db), is(false));
	}



	private boolean isSupport(ApplicationServer appServer, Database db) {
		return SUPPORTS.get(appServer.toString() + "-" + db.toString());
	}





}
