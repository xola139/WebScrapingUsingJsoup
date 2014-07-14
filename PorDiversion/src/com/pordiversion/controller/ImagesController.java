package com.pordiversion.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pordiversion.bean.Imagen;

@Controller
public class ImagesController {
	
	
    @RequestMapping("/xd")
    public String logTasPage( ModelMap model) {
								Document doc;
								try {
									doc = Jsoup.connect("http://quejalada.com/").get();
									Elements elementos=doc.select("div.entry-content").select("p").select("a");
									System.out.println(elementos.size());
								
									List<Imagen> lstImg=new ArrayList<Imagen>();
									Imagen img;
									for (Element table : elementos) {
										img=new Imagen();
										img.setImg(table.attr("href"));
										lstImg.add(img);
									}
									model.addAttribute("imagenes", lstImg);

								
									doc = Jsoup.connect("http://www.esgag.com/").get();
									elementos=doc.select("div[class*=badge-post-container]").select("div").select("a").select("img");
									System.out.println(elementos.size());
								
									List<Imagen> lstImgEsgag=new ArrayList<Imagen>();
								
									for (Element table : elementos) {
										img=new Imagen();
										img.setImg(table.attr("src"));
										lstImgEsgag.add(img);
									}
									model.addAttribute("imagenesEsgag", lstImgEsgag);
									
									
									
									
									doc = Jsoup.connect("http://asipasa.com").get();
									Element ultimoItem=doc.select("div.box_content").select("a").first();
									System.out.println(ultimoItem.select("a").attr("href"));
									
									int ultimo=Integer.valueOf(ultimoItem.select("a").attr("href"));
									List<Imagen> lstChistedeldia=new ArrayList<Imagen>();
									for(int i=0;i<=10;i++){
										doc = Jsoup.connect("http://asipasa.com/"+ultimo).get();
										elementos=doc.select("div[id=main_image]").select("img");
										
										for (Element table : elementos) {
											img=new Imagen();
											img.setImg("http://asipasa.com/"+table.attr("src"));
											lstChistedeldia.add(img);
										}
										ultimo=ultimo-1;
									}
									model.addAttribute("imageneshistedeldia", lstChistedeldia);
									
									 
									//*****************************************
									doc = Jsoup.connect("http://nuevoydivertido.com/").get();
									elementos=doc.select("img[class*=wp-image]");
									System.out.println(elementos.size());
								
									List<Imagen> lstND=new ArrayList<Imagen>();
								
									for (Element table : elementos) {
										img=new Imagen();
										img.setImg(table.attr("src"));
										lstND.add(img);
									}
									model.addAttribute("imagenesND", lstND);
									
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
    	
    	//SocketReader.arranca();
        return "lavista";
    }
    
    
    @RequestMapping("/test")
    public String flujoACliente() {
		//SocketReader.arranca();
        return "tester";
    }//ClienteWebConexion
}
