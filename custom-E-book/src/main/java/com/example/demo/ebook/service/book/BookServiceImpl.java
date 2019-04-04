package com.example.demo.ebook.service.book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.repository.book.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository repository;
	@Override
	public Book registerBook(Book book,Publisher publisher) {
		book.setPublisher(publisher);
		book.setKeywords(book.getKeywords()+","+book.getBookName()+","+publisher.getName());
		Book save = repository.save(book);
		return save;
	}
	@Override
	public String saveBook(MultipartFile file, Book book, int publisherId) throws IOException {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			String homeDir = System.getProperty("user.home");
			System.out.println(homeDir);
			String destination = homeDir+"/ebooks/publisher_"+publisherId+"/book_"+book.getId()+"/complete_book.pdf";
			File file2 = new File(destination);
			file2.getParentFile().mkdirs();
			FileUtils.writeByteArrayToFile(file2, bytes);
			int noOfPages = getNoOfPages(destination);
			book.setTotalNoOfPages(noOfPages);
			book.setBookLoc(destination);
			book.setChaptersAdded(false);
			repository.save(book);
			return destination;
		}
		return "";
		
	}
	@Override
	public List<Book> getPublisherBooks(Publisher publisher) {
		List<Book> byPublisher = repository.findByPublisher(publisher);
		return byPublisher;
	}
	@Override
	public Book getBookById(int id) {
		Optional<Book> book = repository.findById(id);
		return book.get();
	}
	@Override
	public void update(Book book) {
		repository.save(book);
	}
	@Override
	public int getNoOfPages(String location) throws IOException {
		PDDocument doc = PDDocument.load(new File(location));
		int count = doc.getNumberOfPages();
		return count;
	}

}
