package mx.uv.practica03;


import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosRequest;
import https.t4is_uv_mx.saludos.EliminarSaludoRequest;
import https.t4is_uv_mx.saludos.EliminarSaludoResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;



@Endpoint
public class EndPoint {
    List<String> saludos = new ArrayList<>();
    @PayloadRoot(localPart= "SaludarRequest",namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        saludos.add("Hola " + peticion.getNombre());
        respuesta.setRespuesta("Hola " + peticion.getNombre());
        return respuesta;
    }
    @PayloadRoot(localPart= "BuscarSaludosRequest",namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public BuscarSaludosResponse buscarsaludos(@RequestPayload BuscarSaludosRequest peticion) {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        String todosSaludos="";
        for (String str : saludos) {
            todosSaludos= todosSaludos + str + " ";
        }
        respuesta.setRespuesta(todosSaludos);
        return respuesta;
    }
    /**
     * @param peticion
     * @return
     */
    @PayloadRoot(localPart= "ModificarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public ModificarSaludoResponse modificarSaludar(@RequestPayload ModificarSaludoRequest peticion) {
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        int numero=peticion.getId();
        saludos.set(numero,"Hola " + peticion.getNombre());
        respuesta.setRespuesta("El saludo" + peticion.getNombre()+ "ha sido modificado");
        return respuesta;
    }
    @PayloadRoot(localPart= "EliminarSaludoRequest",namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public EliminarSaludoResponse saludar(@RequestPayload EliminarSaludoRequest peticion) {
        EliminarSaludoResponse respuesta = new EliminarSaludoResponse();
        respuesta.setRespuesta("El saludo" + peticion.getNombre()+ "ha sido eliminado");
        saludos.remove(peticion.getId());
        return respuesta;
    }
}
