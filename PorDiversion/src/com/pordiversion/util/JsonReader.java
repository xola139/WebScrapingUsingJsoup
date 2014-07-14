package com.pordiversion.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class JsonReader {
	public enum Ventanas {
		POR_CONSOLIDAR,
		RETRASO_CONSOLIDACION,
		POR_ENVIAR_A_CENTRAL,
		RETRASO_ENVIO_A_CENTRAL,
		ENVIADO_A_CENTRAL,
		POR_FRAGMENTAR,
		RETRASO_FRAGMENTACION,
		POR_ENVIAR_A_CLIENTE,
		RETRASO_ENVIO_A_CLIENTE,
		ENVIADO_A_CLIENTE,
		FLUJO_ALTERNO;
	}
	public enum Operacion {
		entrada,
		salida;
	}
	
	public static String ventana(String jsonMessage) {
		String tableName;

		String type = getPrimitive(jsonMessage, "type");

		switch (Ventanas.valueOf(type)) {
			case POR_CONSOLIDAR:
				tableName = "tablaConsolidacion";
			break;
			case RETRASO_CONSOLIDACION:
				tableName = "tablaRetrasoConsolidacion";
			break;
			case POR_ENVIAR_A_CENTRAL:
				tableName = "tablaEnvioCentral";
			break;
			case RETRASO_ENVIO_A_CENTRAL:
				tableName = "tablaRetrasoEnvioCentral";
			break;
			case ENVIADO_A_CENTRAL:
				tableName = "tablaEnviadoCentral";
			break;
			case POR_FRAGMENTAR:
				tableName = "tablaFragmentacion";
			break;
			case RETRASO_FRAGMENTACION:
				tableName = "tablaRetrasoFragmentacion";
			break;
			case POR_ENVIAR_A_CLIENTE:
				tableName = "tablaEnvioCliente";
			break;
			case RETRASO_ENVIO_A_CLIENTE:
				tableName = "tablaRetrasoEnvioCliente";
			break;
			case ENVIADO_A_CLIENTE:
				tableName = "tablaEnviadoCliente";
			break;
			case FLUJO_ALTERNO:
				tableName = "tablaFlujoAlterno";
			break;
			default:
				tableName = "genericFunction";
			break;
		}
		return tableName;
	}
	public static String flujo(String campo) {
		String flujo;

		switch (Ventanas.valueOf(campo)) {
			case POR_CONSOLIDAR:
			case RETRASO_CONSOLIDACION:
			case POR_ENVIAR_A_CENTRAL:
			case RETRASO_ENVIO_A_CENTRAL:
			case ENVIADO_A_CENTRAL:
				flujo = "aCentral";
			break;
			case POR_FRAGMENTAR:
			case RETRASO_FRAGMENTACION:
			case POR_ENVIAR_A_CLIENTE:
			case RETRASO_ENVIO_A_CLIENTE:
			case ENVIADO_A_CLIENTE:
			case FLUJO_ALTERNO:
				flujo = "aCliente";
			break;
			default:
				flujo = "genericFunction";
			break;
		}
		return flujo;
	}
	
	public static String operacion(String jsonMessage) {
		String javaScriptFunction;

		String operacion = getPrimitive(jsonMessage, "operacion");

		switch (Operacion.valueOf(operacion)) {
			case entrada:
				javaScriptFunction = "add";
			break;
			default:
				javaScriptFunction = "remove";
			break;
		}
		return javaScriptFunction;
	}
	
	public static String idConteo(String jsonMessage) {
		String idConteo;

		String ventana = getPrimitive(jsonMessage, "ventana");

		switch (Ventanas.valueOf(ventana)) {
		case POR_CONSOLIDAR:
			idConteo = "conteoPorConsolidar";
		break;
		case RETRASO_CONSOLIDACION:
			idConteo = "conteoRetrasoConsolidacion";
		break;
		case POR_ENVIAR_A_CENTRAL:
			idConteo = "conteoPorEnviarACentral";
		break;
		case RETRASO_ENVIO_A_CENTRAL:
			idConteo = "conteoRetrasoEnvioACentral";
		break;
		case ENVIADO_A_CENTRAL:
			idConteo = "conteoEnviadosACentral";
		break;
		case POR_FRAGMENTAR:
			idConteo = "conteoPorFragmentar";
		break;
		case RETRASO_FRAGMENTACION:
			idConteo = "conteoRetrasoFragmentacion";
		break;
		case POR_ENVIAR_A_CLIENTE:
			idConteo = "conteoPorEnviarACliente";
		break;
		case RETRASO_ENVIO_A_CLIENTE:
			idConteo = "conteoRetrasoEnvioACliente";
		break;
		case ENVIADO_A_CLIENTE:
			idConteo = "conteoEnviadosACliente";
		break;
		case FLUJO_ALTERNO:
			idConteo = "conteoFlujoAlterno";
		break;
		default:
			idConteo = "genericId";
		break;
	}
		return idConteo;
	}
	
	public static String getPrimitive(String jsonMessage, String campo) {
		JsonElement jelement = new JsonParser().parse(jsonMessage);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonPrimitive jprim = jobject.getAsJsonPrimitive(campo);
        return jprim.getAsString();
	}
}
