package phomenko.flightcontrol.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

public class JSON {
    public static ResponseEntity<String> errorWithMessage(String message){
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
    public static Map <String, Object> singleJsonObject(String key,Object value){
        return Collections.singletonMap(key,value);
    }
}
