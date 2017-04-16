import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Naga on 13-03-2017.
 */
@WebServlet(name = "ImageService", urlPatterns = "/ImageService")
public class ImageService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String response="";
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        System.out.println(data);
        String output = "";
        JSONObject params = new JSONObject(data);
        JSONObject result = params.getJSONObject("result");
        JSONObject parameters = result.getJSONObject("parameters");
        if (parameters.get("doctors").toString().equals("Ophthalmologist")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            jsonArray.put("https://dl.dropboxusercontent.com/content_link/3YBJyBMwuweqZKykkFXTDc1ujz7mZ23yoq47NHigL2noDMFQsjfSvn1meAzX4q2Y/file");

            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "Based on your symptoms the doctor suggested for you");
            js.put("displayText", "Based on your symptoms the doctor suggested for you");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("doctors").toString().equals("Orthopedist")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            jsonArray.put("https://dl.dropboxusercontent.com/content_link/sL3syWQ9FAsFTJC2hRJdx8n6xqnoBzHTHtQxzazpUIUq78mFBLn59i4VEEoy87Bz/file");

            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "Based on your symptoms the doctor suggested for you");
            js.put("displayText", "Based on your symptoms the doctor suggested for you");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("doctors").toString().equals("Orthopedist")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            jsonArray.put("https://dl.dropboxusercontent.com/content_link/sL3syWQ9FAsFTJC2hRJdx8n6xqnoBzHTHtQxzazpUIUq78mFBLn59i4VEEoy87Bz/file");

            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "Based on your symptoms the doctor suggested for you");
            js.put("displayText", "Based on your symptoms the doctor suggested for you");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("doctors").toString().equals("cardiologist")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://dl.dropboxusercontent.com/content_link/9DptJwIgBZcv87LlgMunLgdC3mvMZURSD5VvfXQyGTEjbx9tcuRm8ZA8JMG3P8rp/file");

            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "Based on your symptoms the doctor suggested for you");
            js.put("displayText", "Based on your symptoms the doctor suggested for you");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("null").toString().equals("clear")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(" ");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "screen is cleared");
            js.put("displayText", "screen is cleared");
            js.put("source", "image database");
            response = js.toString();
        }
        resp.setHeader("Content-type", "application/json");
        resp.getWriter().write(response);
    }
}
