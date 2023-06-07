package com.example;
import javax.xml.parsers.DocumentBuilder;
public class Header_footer {

	private double getHeaderFooterHeight(
			Table table, DocumentBuilder builder) throws Exception {
			Document doc = builder.getDocument();
			doc.updatePageLayout();
			LayoutCollector lc = new LayoutCollector(doc);
			LayoutEnumerator le = new LayoutEnumerator(doc);
			double headerFooterHeight = 0;
			double cellHeight = 0;
			CellCollection cells = table.getLastRow().getCells();
			for (Cell cell : cells) {
			  ParagraphCollection paragraphs = cell.getParagraphs();
			  for (Paragraph para : paragraphs) {
			    le.setCurrent(lc.getEntity(para));
			    
			    double paragraphHeight = le.getRectangle().getHeight();
			    cellHeight += paragraphHeight;
			  }
			  if (cellHeight > headerFooterHeight) {
			    headerFooterHeight = cellHeight;
			  }
			}
			return headerFooterHeight;
	}

}

