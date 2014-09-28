package properties;

import java.util.Properties;

import dataset.ICommonProperties;

public class GraphProperties extends Properties {
	
	private static GraphProperties properties;
	public static String TRUE = "true";		//in case of typo
	public static String FALSE = "false";	//in case of typo
	
	private GraphProperties() {}
	
	public static GraphProperties getGraphProperties() {
		if (properties == null) {
			properties = new GraphProperties();
			properties.put(ICommonProperties.xAxisLabel, TRUE);
			properties.put(ICommonProperties.yAxisLabel, TRUE);
			properties.put(ICommonProperties.horizontalLines, TRUE);
			properties.put(ICommonProperties.trendLineVisible, FALSE);
			properties.put(ICommonProperties.trendLineEquationVisible, FALSE);
			return properties;
		} else
			return properties;
	}
}
