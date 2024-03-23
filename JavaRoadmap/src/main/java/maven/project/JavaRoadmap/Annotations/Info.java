package maven.project.JavaRoadmap.Annotations;

import java.lang.annotation.Documented;

@Documented 	//is added for annotation to appear in javadoc-generated documentation	
//annotation type is the form of interface
public @interface Info {
	
//	the body contains annotation type element declarations, which look 
//	a lot like methods
		String date();
		int currentVersion() default 1;
		String lastModified() default "N/A";

}
