package controllers;

import java.util.List;

/**
 * Created by tsanthosh on 27/09/2016.
 */
public class BoxOperations {

    public static Box getBiggestBox( Box ... boxes ){


        for (Box box :
                boxes) {

        }

        return null;
    }

    public static Box getBiggestBox( List<Box> boxes ){

        return getBiggestBox( boxes.toArray(new Box[boxes.size()]) );
    }
}
