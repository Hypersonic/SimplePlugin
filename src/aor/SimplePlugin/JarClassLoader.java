package aor.SimplePlugin;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * This class is necessary, because find class cannot be called from a URLClass Loader.
 * @author Jay
 * @deprecated This class doesn't seem to help.
 */
public class JarClassLoader extends URLClassLoader {
	String className;

	public JarClassLoader(final URL[] urls, final ClassLoader parent,final String mainClassName) {
		super(urls, parent);
		className=mainClassName;
	}
	protected Class<?> findClass() throws ClassNotFoundException {
		return super.findClass(className);
	}
}