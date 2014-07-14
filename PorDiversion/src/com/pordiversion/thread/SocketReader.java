package com.pordiversion.thread;

	
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.pordiversion.bean.Juego;
import com.pordiversion.bean.MessageBean;
import com.pordiversion.util.JsonReader;


public class SocketReader implements Runnable {

	private static LinkedBlockingQueue<String> messagesFromSocket = new LinkedBlockingQueue<String>();
	public static final String FIN_TRANSMISION = "<END OF TRANSMISSION>"; 
	private static Thread hilo;
	private static boolean active = true;
	private Socket client;
	private Scanner scanner;
	private static Elements elementos;
	
	private static boolean cargaInicial=false;


	/**
	 * @param elementos the elementos to set
	 */
	public static void setElementos(Elements elementos) {
		SocketReader.elementos = elementos;
	}

	private SocketReader() {
	}
	
	public void connect() {
		boolean conectado = false;
		System.out.println("************* CONEXION A SOCKET ******************");

	//	while (!conectado) {
			//try {
	
				//System.out.println("Intento de conexion con socket.");
				//client = new Socket("15.156.24.35", 4560);
				//client = new Socket("15.128.75.80", 4570);
				//client.setSoTimeout(61000);
				//scanner = new Scanner(client.getInputStream());
				
				//conectado = true;
	
//			} catch (IOException e) {
				//System.out.println("Fallo intento de conexion con socket. Se reintentara en 1 segundos.");
			//	try {
				//	Thread.sleep(1000);
			//	} catch (InterruptedException e1) {
					//System.out.println("Error en el sleep al esperar intento de reconexion.");
		//		}
	//		}
		//}

		System.out.println("************* CONEXION EXITOSA ******************");
	}
	
	public void disconnect() throws IOException {
		System.out.println("************* DESCONEXION ******************");
		System.out.println("Cerrando socket.");
		client.close();
		System.out.println("Cerrando scanner.");
		scanner.close();
		System.out.println("************* DESCONEXION EXITOSA ******************");
	}
	
	public synchronized static void arranca() {
		if (hilo == null) {
			hilo = new Thread(new SocketReader());
			hilo.start();
		}
	}
	
	@Override
	public void run() {
		int intentos = 0;
		int nc=0;
		//connect();
		//new Thread(new Centinela(this)).start();
		Juego newJuego=new Juego();
		Gson gson = new Gson();
		System.out.println("El hilo esta...>>>>>>"+active);
		while (active) {
					try {
						try{
								Document doc;
		//						System.setProperty("http.proxyHost", "127.0.0.1");
		//						System.setProperty("http.proxyPort", "9666");
		
//								System.getProperties().put( "proxySet", "true" );
//								System.getProperties().put( "socksProxyHost", "127.0.0.1" );
//								System.getProperties().put( "socksProxyPort", "9150" );
//							
								String idJuego="383280";
								newJuego=new Juego();
								
								
								doc = Jsoup.connect("http://quejalada.com/").get();
								//set id juego
								//newJuego.setIdJuego(idJuego);
								//get text time play
								//newJuego.setTiempoJuego(doc.getElementById(idJuego+"statusTabText").html());
								//get minute now
								//newJuego.setMinuto(doc.getElementById(idJuego+"clock").html());
								//get name local
								//newJuego.setLocal(doc.select("div.matchup").select("[class^=team home]").select("div.team-info").select("h3").html());
								//get marcador
								//newJuego.setMarcador(doc.getElementById(idJuego+"headerScore").html());
								//get name visit
								//newJuego.setVisitante(doc.select("div.matchup").select("[class^=team away]").select("div.team-info").select("h3").html());
								
								//get lst comments
								elementos=doc.select("div.entry-content").select("p").select("a");
								
								System.out.println(elementos.size());
								
								String msj;
								for (Element table : elementos) {
									
									
									
									System.out.println(table.attr("href"));
									
//									System.out.println(table.select("img[src]"));
									
//									messagesFromSocket.put(gson.toJson(newJuego));
//									
//									
//										if(nc<elementos.size()){
//											msj=table.select("div.comment").select("p").html();
//											if(msj.contains("ESPNFC.com"))
//												lst.add(msj);
//											nc++;
//							    	}
								}
//								
//								for(int i=lst.size()-1;i>=0;i--){
//									System.out.println(lst.get(i));
//									newJuego.setMensaje(lst.get(i).toString());
//									messagesFromSocket.put(gson.toJson(newJuego));
//								}
								
								Thread.sleep(10000L);
								cargaInicial=true;
								
						} catch (IOException e) {
							e.printStackTrace();
						}
				
					} 
			
			catch (InterruptedException e1) {
					System.out.println("Error en el sleep al esperar por reconexion.");
				}
			catch (NullPointerException e) {
				System.out.println("Error al colocar mensaje en LinkedBlockingQueue.");
				e.printStackTrace();
			}
		}
		
}



	public static boolean isCargaInicial() {
		return cargaInicial;
	}

	public static void setCargaInicial(boolean cargaInicial) {
		SocketReader.cargaInicial = cargaInicial;
	}

	public static LinkedBlockingQueue<String> getMessagesFromSocket() {
		return messagesFromSocket;
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		SocketReader.active = active;
	}

	public Socket getClient() {
		return client;
	}

	public Scanner getScanner() {
		return scanner;
	}
 
}
