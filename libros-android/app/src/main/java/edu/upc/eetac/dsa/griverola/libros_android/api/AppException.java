package edu.upc.eetac.dsa.griverola.libros_android.api;


public class AppException extends Exception {
    public AppException() {
        super();
    }

    public AppException(String detailMessage) {
        super(detailMessage);
    }
}
