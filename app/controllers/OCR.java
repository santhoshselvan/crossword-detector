package controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by tsanthosh on 26/09/2016.
 */
public class OCR {

    public Result ocrIt () {

        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            File a = new File( "/tmp/cross.jpg");

            try {
                FileUtils.copyFile( file, a);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String pointsJSON = PythonRunner.runScriptWithArguments("/Users/tsanthosh/tmp/detect_shapes.py", a.getAbsolutePath());


            Type listType = new TypeToken<List<Box>>() {}.getType();
            List<Box> listOfPoints = new Gson().fromJson(pointsJSON, listType);


            System.out.println( ((Box)Collections.max( listOfPoints)) );
            return ok(pointsJSON);
        } else {
            flash("error", "Missing file");
            return badRequest();
        }

    }
}
