package properties;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dataset.ICommonProperties;

public class ApplicationProperties {
	private static ApplicationProperties properties;
	
	private String cartesianClassName;
	private String columnClassName;
	private String horizontalBarClassName;
	private String multipleLinesClassName;
	
	protected ApplicationProperties(String cartesianClassName, String columnClassName, String horizontalBarGraphClassName, String multipleLinesClassName) {
		this.cartesianClassName = cartesianClassName;
		this.columnClassName = columnClassName;
		this.horizontalBarClassName = horizontalBarGraphClassName;
		this.multipleLinesClassName = multipleLinesClassName;
	}
	
	public String getCartesianClassName() {
		return cartesianClassName;
	}

	public String getColumnClassName() {
		return columnClassName;
	}

	public String getHorizontalBarClassName() {
		return horizontalBarClassName;
	}

	public String getMultipleLinesClassName() {
		return multipleLinesClassName;
	}

	synchronized static public ApplicationProperties getApplicationProperties() {
		if(properties == null) {
			//Read application.properties file
			File file = new File("application.properties");
			System.out.println(file.getAbsolutePath());
			FileReader reader = null;
			try {
				reader = new FileReader(file);
			} catch(FileNotFoundException e) {
				System.out.println("CAN NOT find application.properties file! Make sure it has been created properly before running!");
				return null;
			}
			BufferedReader bufReader = new BufferedReader(reader);
			//fetch class name
			String line = new String();
			String tmp1 = new String();
			String tmp2 = new String();
			String tmp3 = new String();
			String tmp4 = new String();
			Pattern p = Pattern.compile("(\\w+)\\s*=\\s*((\\w*\\.)*[A-Z]\\w*)");
			try {
				while((line = bufReader.readLine()) != null) {
					Matcher m = p.matcher(line);
					if(m.find()) {
						String graphName = m.group(1);
						if(graphName.equals(ICommonProperties.cartesian)) {
							tmp1 = m.group(2);
						} else if(graphName.equals(ICommonProperties.column)) {
							tmp2 = m.group(2);
						} else if(graphName.equals(ICommonProperties.horizontalBarGraph)) {
							tmp3 = m.group(2);
						} else if(graphName.equals(ICommonProperties.multipleLines)) {
							tmp4 = m.group(2);
						}
					}
				}
				bufReader.close();
			} catch(IOException e) {
				e.printStackTrace();
				return null;
			}
			if(tmp1 != null && tmp2 != null && tmp3 != null && tmp4 != null) {
				properties = new ApplicationProperties(tmp1, tmp2, tmp3, tmp4);
				return properties;
			}  else {
				throw new RuntimeException("The format of application.properties is NOT right. The system can NOT parse it!");
			}
		} else {
			return properties;
		}
	}
}
