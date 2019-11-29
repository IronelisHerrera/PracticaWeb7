import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import freemarker.template.Configuration;
import freemarker.template.Version;
import org.json.JSONObject;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.port;

import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.get;


public class Main {

    public static void main(String[] args) throws UnirestException {



            port(8081);

            HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:4567/rest/estudiantes/")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asJson();

            System.out.println("Listado de estudiantes:\n" + jsonResponse.getBody()+"\n");


            System.out.println("Matricula a consultar: ");
            Scanner in = new Scanner(System.in);

            String s = in.nextLine();

            HttpResponse<JsonNode> jsonResponse3 = Unirest.get("http://localhost:4567/rest/estudiantes/"+s)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asJson();

            System.out.println("Estudiante:\n" + jsonResponse3.getBody()+"\n");


            JSONObject j = new JSONObject();
            System.out.println("Agregar nuevo estudiante: \nCorreo: ");
            String correo = in.nextLine();
            j.put("correo",correo);
            System.out.println("\nCarrera: ");
            String carrera = in.nextLine();
            j.put("matricula",17);
            j.put("carrera",carrera);
            System.out.println("\nNombre: ");
            String nombre = in.nextLine();
            j.put("nombre",nombre);

            







    }

}
