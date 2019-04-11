import java.awt.Rectangle;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
public final class Tool  {
	/**
	 *提取指定矩形内的文本
	 * */
	public static  void ExtractTextByArea(PDPage page,int x,int y,int width,int height) throws IOException
	{
		PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition( true );
        Rectangle rect = new Rectangle( x, y, width, height );
        stripper.addRegion( "class1", rect );
        stripper.extractRegions( page );
        System.out.println( "Text in the area:" + rect );
        System.out.println( stripper.getTextForRegion( "class1" ) );
	}
	/**
	 * 提取指定页面范围内的文本
	 * @throws IOException 
	* */
	public static void ExtractTextByPages(PDDocument document,int beginPage,int endPage) throws IOException
	{
		 PDFTextStripper stripper = new PDFTextStripper();

	        // This example uses sorting, but in some cases it is more useful to switch it off,
	        // e.g. in some files with columns where the PDF content stream respects the
	        // column order.
	        stripper.setSortByPosition(true);
	            // Set the page interval to extract. If you don't, then all pages would be extracted.
	            stripper.setStartPage(beginPage);
	            stripper.setEndPage(endPage);

	            // let the magic happen
	            String text = stripper.getText(document);

	            // do some nice output with a header
	    /*        String pageStr = String.format("page %d:", p);
	            System.out.println(pageStr);
	            for (int i = 0; i < pageStr.length(); ++i)
	            {
	                System.out.print("-");
	            }
	            System.out.println();*/
	            System.out.println(text.trim());
	            System.out.println();

	            // If the extracted text is empty or gibberish, please try extracting text
	            // with Adobe Reader first before asking for help. Also read the FAQ
	            // on the website: 
	            // https://pdfbox.apache.org/2.0/faq.html#text-extraction
	}
}
