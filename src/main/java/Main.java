import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import static spark.Spark.port;

public class Main {

    public static void main(String[] args) throws UnirestException {
        port(8081);

        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:4567/rest/estudiantes/")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .asJson();

        System.out.println("Listado de estudiantes:\n" + jsonResponse.getBody() + "\n");


    }

}
