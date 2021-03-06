package upm.etsit.isst.p2p.servlets;

import javax.servlet.ServletException;
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
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.json.*;

import upm.etsit.isst.p2p.model.ServiceProvider;
import upm.etsit.isst.p2p.dao.ServiceProviderDAOImplementation;

@WebServlet("/FormPetitionServlet")
public class FormPetitionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public FormPetitionServlet() {
	
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

		/*ServiceProvider provider = new ServiceProvider();
		provider.setName("Mobike");
		provider.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInfo");
		provider.setActive(true);
		provider.setScopeNeeded(true);
		provider.setToken("");
		ServiceProviderDAOImplementation.getInstance().create(provider);


		ServiceProvider provider2 = new ServiceProvider();
		provider2.setName("Hive");
		provider2.setUrl("https://hive.frontend.fleetbird.eu/api/prod/v1.06/map/cars");
		provider2.setActive(false);
		provider2.setScopeNeeded(false);
		provider2.setToken("");
		ServiceProviderDAOImplementation.getInstance().create(provider);
	*/


		List<ServiceProvider> providers = ServiceProviderDAOImplementation.getInstance().readAll();
		System.out.println("providers: "+providers);


		try {
			for(int i = 0 ; i<providers.size();i++) {  //Iteracion sobre la lista de proveedores
				ServiceProvider actualProvider = providers.get(i);
				if(actualProvider.getActive()){  //Si no hemos desactivado el proveedor
					String latitude = req.getParameter("latitude"); //Recuperamos parametros de la peticion
					String longitude = req.getParameter("longitude");
					String radio = req.getParameter("radio");
					URL serviceUrl = new URL(actualProvider.getUrl());
					String urlParameters="latitude="+latitude+"&longitude="+longitude;
					if(actualProvider.getScopeNeeded()) { //Si es necesario adjuntar un scope a la peticion
						urlParameters = urlParameters+ "&scope="+radio;
					}
					HttpURLConnection myURLConnection = (HttpURLConnection)serviceUrl.openConnection(); //Conexion a la api
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
				    try {
						JSONObject obj = new JSONObject(response);
						System.out.println(response);
						resp.setContentType("application/json");  
						resp.setCharacterEncoding("UTF-8"); 
						resp.getWriter().print(obj);
				    } catch (JSONException e) {
					  System.out.println("Bad json");
				
				    }
				}
			}
	
			//Redireccion
			//resp.sendRedirect(req.getContextPath() + "/ServletName"); 
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
	}
	
}


