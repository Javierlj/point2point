package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64; 


@WebServlet("/FormPetitionServlet")
public class FormPetitionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public FormPetitionServlet() throws MalformedURLException {
		System.out.print("url");
		final URL MobikeUrl = new URL("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInfo");
		final URL HiveUrl = new URL("https://hive.frontend.fleetbird.eu/api/prod/v1.06/map/cars");
		urls = new URL[]{MobikeUrl, HiveUrl};
	}
	
	private URL[] urls;	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		try {
			String latitude = req.getParameter("latitude");
			String longitude = req.getParameter("longitude");
			String radio = req.getParameter("radio");
			String mobikeParameters="latitude="+latitude+"&longitude="+longitude+"&scope="+radio; 
			String HiveParameters="latitude="+latitude+"&longitude="+longitude;
			String[] parameters = new String[] {mobikeParameters,HiveParameters}; 
			for(int i = 0 ; i<urls.length;i++) {
				URL serviceUrl = urls[i];
				String urlParameters = parameters[i];
				HttpURLConnection myURLConnection = (HttpURLConnection)serviceUrl.openConnection();
				byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
				int    postDataLength = postData.length;
				myURLConnection.setRequestMethod("POST");
				myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				myURLConnection.setRequestProperty("platform", "1");
				myURLConnection.setRequestProperty("Content-Language", "en-US");
				myURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Android 7.1.2; Pixel Build/NHG47Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.9 NTENTBrowser/3.7.0.496 (IWireless-US) Mobile Safari/537.36"); 
				myURLConnection.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
				myURLConnection.setUseCaches(false);
				myURLConnection.setDoInput(true);
				myURLConnection.setDoOutput(true);	
				try( DataOutputStream wr = new DataOutputStream( myURLConnection.getOutputStream())) {
					   wr.write( postData );
					}
				Reader in = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream(), "UTF-8"));
				StringBuilder sb = new StringBuilder();
			    for (int c; (c = in.read()) >= 0;)
			        sb.append((char)c);
			    String response = sb.toString();
			    System.out.println(response);
			}

		} catch (ProtocolException e) {
			e.printStackTrace();
		}
	
	}
}


