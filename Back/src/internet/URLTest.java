package internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/examples/hello.txt");
		
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
		
		httpURLConnection.connect();
		
		InputStream is = httpURLConnection.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("imghttp.jpg"));
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = is.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}
		
		fos.close();
		is.close();
		httpURLConnection.disconnect();
	}
}
