package edu.upc.eetac.dsa.griverola.libros_android.api;

import java.util.HashMap;
import java.util.Map;


public class LibrosRootAPI {
    private Map<String, Link> links;

    public LibrosRootAPI() {
        links = new HashMap<String, Link>();
    }

    public Map<String, Link> getLinks() {
        return links;
    }
}