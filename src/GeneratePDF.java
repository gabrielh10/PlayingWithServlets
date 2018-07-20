import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFGraphics;
import com.qoppa.pdfWriter.PDFPage;

//Classe feita pra gerar o pdf. Recebe a imagem enviada pelo usuário.

public class GeneratePDF {
	String text;
	String imagePath;
	
	public GeneratePDF() {}
	public GeneratePDF(String text, String image) {
		this.text = text;
		this.imagePath = image;
	}
	
	public void generate(String text, String nameFile, InputStream background) {
	    	try{
	    		// create document
	    		PDFDocument pdfDoc = new PDFDocument ();
	    	 
	    		// create a PageFormat of standard letter size 
	    		// with no margins
	    		Paper p = new Paper ();
	//    		p.setSize(8.5 * 72, 11 * 72);
//	    		p.setImageableArea(0, 0, 8.5 * 72, 11 * 72);
	    		p.setSize(11 * 72, 8.5*72);
	    		p.setImageableArea(0, 0, 11 * 72, 8.5*72);
	    		PageFormat pf = new PageFormat ();
	    		pf.setPaper(p);
	    		
	    		// create a new page and add it to the PDF (important!)
	    		PDFPage page = pdfDoc.createPage(pf);
	    		pdfDoc.addPage(page);
	    	
	    		// get graphics from the page
	    		// this object is a Graphics2D Object and you can draw anything 
	    		// you would draw on a Graphics2D
	    		PDFGraphics g2d = (PDFGraphics) page.createGraphics();
	    		
	    		if(StorageObjects.getInstance().getImage() != null) {
	    		// read an image (could be png, jpg, etc...)
	    		InputStream inputImage = StorageObjects.getInstance().getImage();
/*	    		
	    		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    		
	            IOUtils.copy(inputImage, baos);
	            BufferedImage image = ImageIO.read(inputImage);
	            InputStream newInputImage = new ByteArrayInputStream(baos.toByteArray());
	    		inputImage = newInputImage;	            
	*/				
	    		UnclosableBufferedInputStream bis = new UnclosableBufferedInputStream(inputImage);
	    			
	   // 		byte[] bytes = getBytes(inputImage);
	    		BufferedImage image = ImageIO.read(bis);
	    		
	    		if(image != null) {
	    		// draw the image on the page
	    			g2d.drawImage(image, 0, 0, null);
	    			bis.close();
	    		}
	    		}
	    		// set the font and color
	    		g2d.setFont (PDFGraphics.HELVETICA.deriveFont(24f));
	    		g2d.setColor(Color.BLUE);
	        
	    		// draw text on the graphics object of the page
	    		g2d.drawString(text, 200, 30);
	    		// Save the document, insert the place here.
	    		pdfDoc.saveDocument (System.getProperty("user.dir")+nameFile+".pdf");
	    		System.out.println("Documento salvo em: "+System.getProperty("user.dir")+"\\"+nameFile+".pdf");
	    	}catch(Throwable t){
	    		t.printStackTrace();
	    	}
	}
	
	private static byte[] getBytes(InputStream is) throws IOException {
	    byte[] buffer = new byte[8192];
	ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
	int n;
	baos.reset();

	while ((n = is.read(buffer, 0, buffer.length)) != -1) {
	      baos.write(buffer, 0, n);
	    }

	   return baos.toByteArray();
	 }
}
