package com.example.demo.ebook.service.chapter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.repository.chapter.ChapterRepository;

@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	ChapterRepository repository;

	@Override
	public int saveChapters(ArrayList<String> names, ArrayList<String> keywords, ArrayList<String> description,
			ArrayList<Integer> price, ArrayList<Integer> startPage, ArrayList<Integer> endPage, Book book)
			throws IOException {
		String sourceDocument = book.getBookLoc();
		String chapLocation = sourceDocument.substring(0, sourceDocument.length() - 17) + "chap_";
		String chapPreviewLocation = chapLocation;
		System.out.println(sourceDocument);
		System.out.println(chapLocation);
		System.out.println(book.getNoOfChapters());
		System.out.println(description.size());
		for (int i = 0; i < book.getNoOfChapters(); i++) {
			String loc = cutPdf(startPage.get(i), endPage.get(i), sourceDocument, chapLocation + (i + 1)+".pdf", false);
			if(endPage.get(i)-startPage.get(i)<=2) {
				cutPdf(startPage.get(i), endPage.get(i), sourceDocument, chapLocation + (i + 1)+"_preview.pdf", false);
			}
			else {
				cutPdf(startPage.get(i), startPage.get(i)+2, sourceDocument, chapLocation + (i + 1)+"_preview.pdf", false);
			}
			Chapter chapter = new Chapter();
			chapter.setBook(book);
			chapter.setDescription(description.get(i));
			chapter.setEndPage(endPage.get(i));
			chapter.setKeywords(keywords.get(i)+","+names.get(i)+","+book.getBookName()+","+book.getPublisher().getName());
			chapter.setLoc(loc);
			chapter.setName(names.get(i));
			chapter.setPrice(price.get(i));
			chapter.setStartPage(startPage.get(i));
			repository.save(chapter);
		}
		return 0;
	}
	

	@Override
	public String cutPdf(int startPage, int endPage, String source, String dest, boolean flag) throws IOException {
		File file = new File(source);
		PDDocument sourceDocument = PDDocument.load(file);
		Splitter splitter = new Splitter();
		splitter.setStartPage(startPage);
		splitter.setEndPage(endPage);
		splitter.setSplitAtPage(endPage);
		List<PDDocument> split1 = splitter.split(sourceDocument);
		
		if(flag) {
			PDFRenderer pdfRenderer = new PDFRenderer(split1.get(0));
			BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
			boolean writeImage = ImageIOUtil.writeImage(bim, "jpg", dest, 300);
			System.out.println(writeImage);
			System.out.println("hello");
		}
		else {
			split1.get(0).save(new File(dest));
			sourceDocument.close();
		}
		sourceDocument.close();
		return dest;
	}


	@Override
	public List<Chapter> getChaptersByBook(Book book) {
		List<Chapter> listOfChapters = repository.findByBookOrderById(book);
		return listOfChapters;
	}


	@Override
	public void saveChapter(Chapter chapter) {
		repository.save(chapter);
	}
}
